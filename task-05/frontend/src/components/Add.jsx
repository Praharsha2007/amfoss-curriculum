import add_button from "/assets/add.svg";

function Add({ song }) {
  const handleAdd = async () => {
    const playlistId = localStorage.getItem("current_playlist_id");

    if (!playlistId) {
      alert("Open a playlist first");
      return;
    }

    const res = await fetch("http://127.0.0.1:5000/playlist/addsong", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        playlist_id: playlistId,
        title: song.track_name,
        artist: song.artist_name,
        cover: song.cover,
        audio: song.audio
      })
    });

    const data = await res.json();
    console.log(data);
    alert("Song added");
  };

  return (
    <button onClick={handleAdd}>
      <img src={add_button} />
    </button>
  );
}

export default Add;
