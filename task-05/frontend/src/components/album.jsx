import { useNavigate } from "react-router-dom";
import cover from "/assets/headphones.svg";

function Album({ album }) {
  const navigate = useNavigate();

  if (!album) return null;   

  return (
    <button
      className="container"
      onClick={() => navigate(`/Playlist/${album.id}`)}
    >
      <div className="AlbumCard">
        <div className="Cover">
          <img src={cover} />
        </div>
        <div className="AlbumTitle">{album.name}</div>
      </div>
    </button>
  );
}

export default Album;
