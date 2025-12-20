import './sidebar.css'
import View from '/src/components/ViewPlaylists.jsx'
import View_Liked from '/src/components/ViewLiked.jsx'
import View_Settings from '/src/components/ViewSettings.jsx'
import Add_Playlist from '/src/components/AddPlaylist.jsx'
import { Link } from 'react-router-dom'

import '/src/components/Menu.jsx'
function SideBar1(){
    return(
        <>
        <div className='Sidebar'>
            <Link to="/Library">
            <div className='Playlist'>
                <View />
            </div>
            </Link>
            <div className='Songs'>
                <View_Liked />
            </div>
            <Link to="/Settings">
            <div className='Settings_Button'>
                <View_Settings />
            </div>
            </Link>
            <div className='NewPlaylist'>
                <Add_Playlist />
            </div>
            <h1 className='Username'>
                USERNAME
            </h1>  
        </div>
        
        </>
    )
}

export default SideBar1