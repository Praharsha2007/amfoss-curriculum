import './AddPlaylist.css'
import { Link } from 'react-router-dom'
function New_Playlist(){
    return(
        <Link to="/NewPlaylist">
        <button className='NewPlaylistL'>
            <h2 className='Title_Songs'> CREATE A NEW PLAYLIST </h2>
        </button>
        </Link>
    )
}

export default New_Playlist