from flask import Flask, request, jsonify
from flask_cors import CORS
import requests

app = Flask(__name__)
CORS(app)

base_url = "https://api.audius.co/v1"
@app.route("/songs", methods=["GET"])
def search_songs():
    query = request.args.get("q") 
    limit = 3 
    if not query:
        return ("Error, no parameter")
    search_url = f"{base_url}/tracks/search"
    params = {
        "query": query,
        "limit": limit,
    }
    response = requests.get(search_url, params=params)
    data = response.json()
    if response.status_code != 200:
        return ("API Error")
    
    tracks = data.get("data")
    result = []
    for x in tracks:
        result.append({
            "id": x.get("id"),
            "track_name": x.get("title"),
            "artist_name": x.get("user").get("name"),
            "audio": f"{base_url}/tracks/{x.get('id')}/stream",
            "cover": (x.get("artwork") or {}).get("150x150"),
            "release_date": x.get("release_date")
        })
    return jsonify(result)
@app.route("/")
def hello():
    return "Hey there"

if __name__ == "__main__":
    app.run(debug=True)
