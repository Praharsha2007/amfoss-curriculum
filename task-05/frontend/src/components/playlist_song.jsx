import "./playlist_song.css";
import Delete from "/src/components/Delete.jsx";
import headphones from "/assets/headphones.svg";

function PSong({ song }) {
  return (
    <div className="PlaylistSong">
      <img
        src={song.cover || "/assets/headphones.svg"}
      />

      <div>
        <p>{song.title}</p>
        <p>{song.artist}</p>
      </div>

      <audio src={song.audio} />
    </div>
  );
}


export default PSong;
