import "./Dashboard.css";
import TopBar from "/src/components/TopMenu.jsx";
import Song from "/src/components/Song.jsx";
import { useEffect, useState } from "react";

function Dashboard({ setCurrentSong }) {
  const [recent, setRecent] = useState([]);
  const [recommended, setRecommended] = useState([]);

  const userId = localStorage.getItem("user_id");

  useEffect(() => {
    async function load() {
      try {
        const r1 = await fetch(
          `http://127.0.0.1:5000/recently-played/${userId}`
        );
        const recentData = await r1.json();
        setRecent(recentData);

        const r2 = await fetch("http://127.0.0.1:5000/trending");
        const recData = await r2.json();
        setRecommended(recData);
      } catch (err) {
        console.error("Dashboard load failed", err);
      }
    }

    load();
  }, [userId]);

  return (
    <div className="DContainer">
      <TopBar />

      <div className="Content">
        <h2 className="SectionTitle">Recently Played</h2>

        <div className="Recently_Played">


          {recent.map(song => (
            <Song
              key={song.id}
              song={song}
              onClick={() => setCurrentSong(song)}
            />
          ))}
        </div>

        <h2 className="SectionTitle">Recommended</h2>

        <div className="Recommended_Songs">
          {recommended.map(song => (
            <Song
              key={song.id}
              song={song}
              onClick={() => setCurrentSong(song)}
            />
          ))}
        </div>
      </div>
    </div>
  );
}

export default Dashboard;
