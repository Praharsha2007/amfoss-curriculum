import "./search.css";
import Search from "../components/SearchInput.jsx";
import Bottom_Menu from "../components/bottommenu.jsx";
import Suggesting from "../components/search_songs.jsx";
import Back from "../components/back.jsx";
import { useState } from "react";

function Searching({ setCurrentSong }) {
  const [query, setQuery] = useState("");
  const [song, setSong] = useState([]);

  const fetchSong = async () => {
    if (!query) return;

    const response = await fetch(
      `http://127.0.0.1:5000/songs?q=${encodeURIComponent(query)}`
    );
    const data = await response.json();
    setSong(data);
  };

  return (
    <div className="SearchPage">
      <Search query={query} setQuery={setQuery} onSearch={fetchSong} />

      <div className="SuggestionsWrapper">
        <div className="Suggestions">
          <Suggesting songs={song} setCurrentSong={setCurrentSong} />
        </div>
      </div>

      <Back />
    </div>
  );
}


export default Searching;
