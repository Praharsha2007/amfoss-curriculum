import { useEffect, useState } from "react";
import PlaylistSong from "/src/components/playlist_song.jsx";
import Top from "/src/components/TopMenu.jsx";
import Bottom from "/src/components/bottommenu.jsx";
import "./likedsongs.css";

function LikedSongs() {
  const [songs, setSongs] = useState([]);
  const username = localStorage.getItem("username");

  useEffect(() => {
    const loadLiked = async () => {
      // Step 1: get liked playlist id
      const res1 = await fetch(
        `http://127.0.0.1:5000/playlist/liked/${username}`
      );
      const data1 = await res1.json();

      // Step 2: get songs inside that playlist
      const res2 = await fetch(
        `http://127.0.0.1:5000/playlist/${data1.id}`
      );
      const data2 = await res2.json();

      setSongs(data2.songs);
    };

    loadLiked();
  }, []);

  return (
    <>
      <Top />
      <h1 className="NPlaylistTitle">LIKED SONGS</h1>

      <div className="NArrangement">
        {songs.map((song) => (
          <PlaylistSong key={song.id} song={song} />
        ))}
      </div>

      <Bottom />
    </>
  );
}

export default LikedSongs;
