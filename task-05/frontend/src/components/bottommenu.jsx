import { useEffect, useRef } from "react";
import "./bottommenu.css";
import pause from "/assets/pause.svg";
import rewind from "/assets/rewind.svg";
import forward from "/assets/forward.svg";
import like from "/assets/like.svg";
import resume from "/assets/play.svg";

function Bottom_Menu({ play }) {
  const audioRef = useRef(null);

  // 🔊 Play when song changes
  useEffect(() => {
    if (!audioRef.current || !play?.audio) return;

    audioRef.current.src = play.audio;
    audioRef.current.load();
    audioRef.current.play().catch(() => {});
  }, [play?.audio]);

  // 📝 SAVE to Recently Played
  useEffect(() => {
    if (!play?.audio) return;

    const userId = localStorage.getItem("user_id");
    if (!userId) return;

    fetch("http://127.0.0.1:5000/recently-played", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        user_id: userId,
        song_id: play.id,
        track_name: play.track_name,
        artist_name: play.artist_name,
        cover: play.cover,
        audio: play.audio
      })
    });

  }, [play?.audio]);   // runs whenever a new song plays

  const likeCurrent = async () => {
    const username = localStorage.getItem("username");
    if (!username || !play?.audio) return;

    await fetch("http://127.0.0.1:5000/playlist/like", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        username,
        song: play
      })
    });
  };

  return (
    <div className="Bar">
      <audio ref={audioRef} />

      <div className="Image">
        <img src={play?.cover || "/assets/headphones.svg"} />
      </div>

      <div className="song_details">
        <div className="Song">{play?.track_name || ""}</div>
        <div className="Artist">{play?.artist_name || ""}</div>
      </div>

      <div className="Controls">
        <button onClick={() => audioRef.current.currentTime -= 10}>
          <img src={forward} />
        </button>

        <button onClick={() => audioRef.current.pause()}>
          <img src={pause} />
        </button>

        <button onClick={() => audioRef.current.play()}>
          <img src={resume} />
        </button>

        <button onClick={() => audioRef.current.currentTime += 10}>
          <img src={rewind} />
        </button>
      </div>

      <div className="Bar_Right">
        <button onClick={likeCurrent}>
          <img src={like} />
        </button>
      </div>
    </div>
  );
}

export default Bottom_Menu;
