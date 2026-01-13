import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import headphones from "/assets/headphones.svg";
import "./menu.css";

function Menu() {
  const [albums, setAlbums] = useState([]);
  const navigate = useNavigate();
  const username = localStorage.getItem("username");

  useEffect(() => {
    if (!username) return;

    const fetchAlbums = async () => {
      const res = await fetch(
        `http://127.0.0.1:5000/playlist/all?username=${username}`
      );
      const data = await res.json();
      setAlbums(data);
    };

    fetchAlbums();
  }, [username]);

  return (
    <div className="LibraryPage">
      <h1 className="PlaylistTitle">YOUR PLAYLISTS</h1>

      <div className="AlbumsGrid">
        {albums.map((album) => (
          <div
            key={album.id}
            className="AlbumCard"
            onClick={() => navigate(`/Playlist/${album.id}`)}
          >
            <div className="AlbumCover">
              <img src={headphones} alt="cover" />
            </div>
            <p>{album.name}</p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Menu;
