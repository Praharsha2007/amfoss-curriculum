import Search_Song from "./Search_Song.jsx";
import "./search_songs.css"
function Suggesting({ songs, setCurrentSong }) {
  return (
    <div className="results">
      {songs.map((song, i) => (
        <Search_Song key={i} song={song} setCurrentSong={setCurrentSong} />
      ))}
    </div>
  );
}


export default Suggesting;