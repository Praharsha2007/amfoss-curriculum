import "./Search_Song.css";
import Add from "/src/components/Add.jsx";
function Search_Song({ song, setCurrentSong }) {
  return (
    <div className="SearchSong">

      <div
        className="SongInfo"
        onClick={() => setCurrentSong(song)}
        style={{ cursor: "pointer" }}
      >
        <img
          className="AlbumCover"
          src={song.cover || "/assets/headphones.svg"}
          onError={(e) => (e.target.src = "/assets/headphones.svg")}
        />
        <div>
          <p className="STitle">{song.track_name}</p>
          <p className="SArtist">{song.artist_name}</p>
        </div>
      </div>

      <div className="SongActions">
        <Add song={song} />
      </div>

    </div>
  );
}


export default Search_Song;
