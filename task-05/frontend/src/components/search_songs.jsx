import Search_Song from "./Search_Song.jsx";
import "./search_songs.css";

function Suggesting({ songs, setSongs, setCurrentSong }) {

  const handleDelete = (id) => {
    setSongs(songs.filter(song => song.id !== id));
  };

  return (
    <div className="results">
      {songs.map(song => (
        <Search_Song
          key={song.id}
          song={song}
          setCurrentSong={setCurrentSong}
          onDelete={handleDelete}
        />
      ))}
    </div>
  );
}

export default Suggesting;
