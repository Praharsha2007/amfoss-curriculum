import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import Dashboard from './pages/Dashboard.jsx'
import SignUp from './pages/signuppage.jsx'
import LogIn from './pages/login.jsx'
import Settings from './pages/settings.jsx'
import ChangePassword from './pages/changepassword.jsx'
import ChangeUsername from './pages/changeusername.jsx'
import Menu from './pages/menu.jsx'
import Details from './pages/details.jsx'
import Playlist from './pages/playlist_section.jsx'
import Liked from './pages/likedsongs.jsx'
import New from './pages/newplaylist.jsx'
import { BrowserRouter, Routes, Route } from "react-router-dom"
import Search from './pages/search.jsx'

function App(){
  return(
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<SignUp/>} />
        <Route path='/LogIn' element={<LogIn />}/>
        <Route path='/SignUp' element={<SignUp />} />
        <Route path='/Settings' element={<Settings />}/>
        <Route path='/Dashboard' element={<Dashboard />}/>
        <Route path='/ChangePassword' element={<ChangePassword />}/>
        <Route path='/ChangeUsername' element={<ChangeUsername />}/>
        <Route path='/Library' element={<Menu />} />
        <Route path='/Details' element={<Details />} />
        <Route path='/Playlist' element={<Playlist/>} />
        <Route path='/Search' element={<Search />} />
        <Route path='/LikedSongs' element={<Liked />} />
        <Route path='/NewPlaylist' element={<New />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App