import { BrowserRouter, Routes, Route, useLocation } from "react-router-dom";
import { useState } from "react";
import TopMenu from "./components/TopMenu.jsx";
import Bottom_Menu from "./components/bottommenu.jsx";
import Dashboard from "./pages/Dashboard.jsx";
import SignUp from "./pages/signuppage.jsx";
import Login from "./pages/login.jsx";
import Settings from "./pages/settings.jsx";
import ChangePassword from "./pages/changepassword.jsx";
import ChangeUsername from "./pages/changeusername.jsx";
import Library from "./pages/menu.jsx";
import Details from "./pages/details.jsx";
import Playlist from "./pages/playlist_section.jsx";
import Liked from "./pages/likedsongs.jsx";
import New from "./pages/newplaylist.jsx";
import SearchPage from "./pages/search.jsx";

function Layout({ currentSong, setCurrentSong }) {
  const location = useLocation();

  const hideTopRoutes = [
  "/",
  "/Login",
  "/SignUp",
  "/SearchPage",
  "/Settings",
  "/ChangePassword",
  "/ChangeUsername",
  "/Details"
];

const hideTop = hideTopRoutes.includes(location.pathname);


  return (
    <>
      {!hideTop && <TopMenu />}

      <Routes>
        <Route path="/" element={<SignUp />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/SignUp" element={<SignUp />} />
        <Route path="/Dashboard" element={<Dashboard setCurrentSong={setCurrentSong} />} />
        <Route path="/Settings" element={<Settings />} />
        <Route path="/ChangePassword" element={<ChangePassword />} />
        <Route path="/ChangeUsername" element={<ChangeUsername />} />
        <Route path="/Library" element={<Library />} />
        <Route path="/Details" element={<Details song={currentSong} />} />
        <Route path="/Playlist/:id" element={<Playlist />} />
        <Route path="/LikedSongs" element={<Liked />} />
        <Route path="/NewPlaylist" element={<New />} />
        <Route path="/SearchPage" element={<SearchPage setCurrentSong={setCurrentSong} />} />
      </Routes>

      <Bottom_Menu play={currentSong} />
    </>
  );
}

function App() {
  const [currentSong, setCurrentSong] = useState({
    cover: "",
    track_name: "Select a song",
    artist_name: "--",
    audio: "",
  });

  return (
    <BrowserRouter>
      <Layout currentSong={currentSong} setCurrentSong={setCurrentSong} />
    </BrowserRouter>
  );
}

export default App;
