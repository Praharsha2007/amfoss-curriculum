import './ViewLiked.css'
import { Link } from 'react-router-dom'
function LSongs(){
    return(
        <Link to="/LikedSongs">
        <button className='Liked_View'>
            <h2 className='Title_Songs'> VIEW LIKED SONGS </h2>
        </button>
        </Link>
    )
}

export default LSongs