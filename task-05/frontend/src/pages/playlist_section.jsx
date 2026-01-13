import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import PSong from "/src/components/playlist_song.jsx";
import Top from "/src/components/TopMenu.jsx";

function Playlist() {
  const { id } = useParams();
  const [playlist, setPlaylist] = useState(null);

  useEffect(() => {
    const fetchPlaylist = async () => {
      const res = await fetch(`http://127.0.0.1:5000/playlist/${id}`);
      const data = await res.json();
      setPlaylist(data);
      localStorage.setItem("current_playlist_id", id);
    };

    fetchPlaylist();
  }, [id]);

  if (!playlist) return null;

  return (
    <>
      <Top />
      <h1 className="PlaylistTitle">{playlist.name}</h1>

      <div className="PArrangement">
        {playlist.songs.map(song => (
          <PSong key={song.id} song={song} />
        ))}
      </div>
    </>
  );
}

export default Playlist;
