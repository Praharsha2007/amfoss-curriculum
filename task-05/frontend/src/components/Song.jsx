import "./Song.css";
import headphones from "/assets/headphones.svg";

function Song({ song, onClick }) {
  return (
    <button className="box" onClick={onClick}>
      <div className="SongCard">
        <div className="Cover">
          <img
            src={song.cover || headphones}
          />
        </div>

        <div className="SongTitle">
          {song.track_name}
        </div>
      </div>
    </button>
  );
}

export default Song;
