from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_cors import CORS
from flask_bcrypt import Bcrypt
import requests
from sqlalchemy import event
from sqlalchemy.engine import Engine
import sqlite3

app = Flask(__name__)
CORS(app, supports_credentials=True)
bcrypt = Bcrypt(app)

app.config["SQLALCHEMY_DATABASE_URI"] = "sqlite:///melofi.db"
app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = False

db = SQLAlchemy(app)
@event.listens_for(Engine, "connect")
def set_sqlite_pragma(dbapi_connection, connection_record):
    if isinstance(dbapi_connection, sqlite3.Connection):
        cursor = dbapi_connection.cursor()
        cursor.execute("PRAGMA foreign_keys=ON;")
        cursor.close()

class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(100), unique=True)
    email = db.Column(db.String(100), unique=True)
    password = db.Column(db.String(200))

class Playlist(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(150))
    username = db.Column(db.String(100))

class PlaylistSong(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    playlist_id = db.Column(db.Integer, db.ForeignKey("playlist.id"))
    audio = db.Column(db.String(300))
    title = db.Column(db.String(200))
    artist = db.Column(db.String(200))
    cover = db.Column(db.String(300))

    playlist = db.relationship("Playlist", backref="songs")
    
class RecentlyPlayed(db.Model):
    id = db.Column(db.Integer, primary_key=True)

    user_id = db.Column(
        db.Integer,
        db.ForeignKey("user.id"),
        nullable=False
    )

    song_id = db.Column(db.String(100))
    title = db.Column(db.String(200))
    artist = db.Column(db.String(200))
    cover = db.Column(db.String(300))
    audio = db.Column(db.String(400))

    played_at = db.Column(
                db.DateTime,
                default=db.func.current_timestamp()
    )

    user = db.relationship("User", backref="recently_played")

with app.app_context():
    db.create_all()

@app.route("/register", methods=["POST"])
def register():
    data = request.json
    password_hash = bcrypt.generate_password_hash(data["password"]).decode("utf-8")

    user = User(
        username=data["username"],
        email=data["email"],
        password=password_hash
    )

    db.session.add(user)
    db.session.commit()

    return {"msg":"ok","username":user.username,"user_id":user.id}, 201

@app.route("/login", methods=["POST"])
def login():
    data = request.json
    user = User.query.filter_by(username=data["username"]).first()

    if not user or not bcrypt.check_password_hash(user.password, data["password"]):
        return {"msg":"Invalid"}, 401

    return {"username":user.username,"user_id":user.id}, 200


@app.route("/playlist/create", methods=["POST"])
def create_playlist():
    data = request.json

    playlist = Playlist(
        name=data["name"],
        username=data["username"]
    )
    db.session.add(playlist)
    db.session.commit()

    return {"id": playlist.id, "msg": "done"}, 201

@app.route("/playlist/all", methods=["GET"])
def get_all_playlists():
    username = request.args.get("username")

    if not username:
        return jsonify([])

    playlists = Playlist.query.filter_by(username=username).all()

    result = []
    for p in playlists:
        result.append({
            "id": p.id,
            "name": p.name
        })

    return jsonify(result)


@app.route("/playlist/<int:id>")
def get_playlist(id):
    p = Playlist.query.get(id)

    songs_list = []
    for s in p.songs:
        songs_list.append({
            "id": s.id,
            "title": s.title,
            "artist": s.artist,
            "cover": s.cover,
            "audio": s.audio
        })

    return jsonify({
        "id": p.id,
        "name": p.name,
        "songs": songs_list
    })

@app.route("/playlist/addsong", methods=["POST"])
def add_song():
    print(request.json)

    data = request.json

    song = PlaylistSong(
        playlist_id=int(data["playlist_id"]),
        audio=data["audio"],
        title=data["title"],
        artist=data["artist"],
        cover=data["cover"]
    )

    db.session.add(song)
    db.session.commit()

    return {"msg": "added"}, 201

@app.route("/playlist/removesong", methods=["POST"])
def remove_song():
    data = request.json

    song = PlaylistSong.query.get(data["song_id"])

    if not song:
        return {"msg": "Song not found"}, 404

    db.session.delete(song)
    db.session.commit()

    return {"msg": "Removed"}, 200

@app.route("/playlist/liked/<username>")
def get_liked(username):
    playlist = Playlist.query.filter_by(
        username=username,
        name="Liked Songs"
    ).first()

    if not playlist:
        playlist = Playlist(name="Liked Songs", username=username)
        db.session.add(playlist)
        db.session.commit()

    return {"id": playlist.id}

@app.route("/playlist/like", methods=["POST"])
def like_song():
    data = request.json
    username = data["username"]
    song = data["song"]

    liked = Playlist.query.filter_by(
        username=username,
        name="Liked Songs"
    ).first()

    if not liked:
        liked = Playlist(name="Liked Songs", username=username)
        db.session.add(liked)
        db.session.commit()
    exists = PlaylistSong.query.filter_by(
        playlist_id=liked.id,
        audio=song["audio"]
    ).first()

    if exists:
        return {"msg": "Already liked"}

    liked_song = PlaylistSong(
        playlist_id=liked.id,
        title=song["track_name"],
        artist=song["artist_name"],
        cover=song["cover"],
        audio=song["audio"]
    )

    db.session.add(liked_song)
    db.session.commit()

    return {"msg": "Liked"}, 201

base_url = "https://api.audius.co/v1"


@app.route("/songs", methods=["GET"])
def search_songs():
    query = request.args.get("q")
    if not query:
        return jsonify([])

    try:
        res = requests.get(
            "https://api.audius.co/v1/tracks/search",
            params={"query": query, "limit": 10},
            timeout=5
        )
    except:
        return jsonify([])

    if res.status_code != 200:
        return jsonify([])

    tracks = res.json().get("data", [])
    result = []

    for x in tracks:
        cover = None
        artwork = x.get("artwork")

        if artwork and isinstance(artwork, dict):
            url = artwork.get("150x150")
            if url and url.startswith("http"):
                cover = url

        result.append({
            "id": x["id"],
            "track_name": x["title"],
            "artist_name": x["user"]["name"],
            "audio": f"https://api.audius.co/v1/tracks/{x['id']}/stream?app_name=melofi",
            "cover": cover
        })

    return jsonify(result)

@app.route("/trending", methods=["GET"])
def trending_songs():
    url = f"{base_url}/tracks/trending"
    response = requests.get(url, params={
        "limit": 20,
        "time": "week" 
    })

    data = response.json()["data"]

    result = []

    for x in data:
        result.append({
            "id": x["id"],
            "track_name": x["title"],
            "artist_name": x["user"]["name"],
            "audio": f"{base_url}/tracks/{x['id']}/stream",
            "cover": x.get("artwork", {}).get("150x150"),
        })

    return jsonify(result)

@app.route("/recently-played", methods=["POST"])
def add_recently_played():
    data = request.json

    recent = RecentlyPlayed(
        user_id=data["user_id"],
        song_id=data["song_id"],
        title=data["track_name"],
        artist=data["artist_name"],
        cover=data["cover"],
        audio=data["audio"]
    )

    db.session.add(recent)
    db.session.commit()

    return {"msg": "saved"}, 201

@app.route("/recently-played/<int:user_id>")
def get_recently_played(user_id):
    songs = (
        RecentlyPlayed.query
        .filter_by(user_id=user_id)
        .order_by(RecentlyPlayed.played_at.desc())
        .limit(20)
        .all()
    )

    result = []
    for s in songs:
        result.append({
            "id": s.id,
            "track_name": s.title,
            "artist_name": s.artist,
            "cover": s.cover,
            "audio": s.audio
        })

    return jsonify(result)



if __name__ == "__main__":
    app.run(debug=True)
