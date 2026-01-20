import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";

function Playlist() {
  const { id } = useParams();
  const [songs, setSongs] = useState([]);
  const [playlist, setPlaylist] = useState(null);

  useEffect(() => {
    const fetchPlaylist = async () => {
      const res = await fetch(`http://127.0.0.1:5000/playlist/${id}`);
      const data = await res.json();
      setPlaylist(data);
      setSongs(data.songs);

      localStorage.setItem("current_playlist_id", id);
    };

    fetchPlaylist();
  }, [id]);

  if (!playlist) return null;

  return (
    <div className="playlist_page">
      <h1 className="PlaylistHeader">{playlist.name}</h1>


      {songs.map(song => (
        <div key={song.id} className="song_row">
          <img
            src={song.cover || "/assets/headphones.svg"}
            onError={(e) => {
            e.target.src = "/assets/headphones.svg";
          }}
/>
          <div>
            <p>{song.title}</p>
            <p>{song.artist}</p>
          </div>
          <audio src={song.audio} controls />
        </div>
      ))}
    </div>
  );
}

export default Playlist;
