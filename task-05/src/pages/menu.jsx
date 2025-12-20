import './menu.css'
import Top from '../components/TopMenu.jsx'
import Bottom from '../components/bottommenu.jsx'
import Album from '../components/album.jsx'
import Delete from '../components/Delete.jsx'
import Add from '../components/Add.jsx'
import { Link } from 'react-router-dom'
function Menu(){
    return(
        <>
        <Top />
        <Bottom />
        <div className='Arrangements'>
            <Link to="/Playlist">
                    <Album />
            </Link>
                    <Album />
                    <Album />
                    <Album />
                    <Album />
                    <Album />
            
        </div>
        <div className='Controls'>
            <Delete />
            <Add />
        </div>
        
        <h1 className='Playlist_Title'> YOUR PLAYLISTS...</h1>
        </>
    )
    
}

export default Menu