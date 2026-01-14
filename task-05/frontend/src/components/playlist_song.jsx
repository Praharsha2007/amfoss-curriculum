import "./playlist_song.css";
import Delete from "/src/components/Delete.jsx";
import headphones from "/assets/headphones.svg";

function PSong({ song, onDelete }) {

  const deleteSong = async () => {
    const res = await fetch("http://127.0.0.1:5000/playlist/removesong", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        song_id: song.id
      })
    });

    const data = await res.json();

    if (data.msg === "Removed") {
      alert("Song removed from playlist");
      onDelete(song.id);
    }
  };

  return (
    <div className="PlaylistSong">
      <img src={song.cover || headphones} />

      <div>
        <p>{song.title}</p>
        <p>{song.artist}</p>
      </div>
      <button onClick={deleteSong}>
        <Delete />
      </button>

      <audio src={song.audio} />
    </div>
  );
}

export default PSong;
