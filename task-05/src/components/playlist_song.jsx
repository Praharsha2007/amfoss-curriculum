import './playlist_song.css'
import pcover from '/assets/headphones.svg'
import Delete from '/src/components/Delete.jsx'

function PSong(){
    return(
        <button className='PlaylistSong'>
            <div className='PImage'><img className='PLogo' src={pcover}></img></div>
            <div className='PTitle'>Song Title</div>
            <div className='PArtist'>Artist</div>
            <div className='SControls'>
                            <Delete />
                                
            </div>
        </button>

    )
}

export default PSong
