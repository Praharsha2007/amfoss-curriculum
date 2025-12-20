
import './newplaylist.css'
import PlaylistSong from '/src/components/playlist_song.jsx'
import Add from '/src/components/Add.jsx'
import Delete from '/src/components/Delete.jsx'
import Top from '/src/components/TopMenu.jsx'
import Bottom from '/src/components/bottommenu.jsx'

function NPlaylist(){
    return(
            <>
            <input
            className='playlistInput'
            type='text'
            placeholder='Enter a playlist name....'></input>
            <div className='NArrangement'>
                
            </div>

            <Top />
            <Bottom />
            <div className='NControls'>
                <Delete />
                <Add />
            </div>
            <h2 className='Title'>
                Add Songs to this new playlist and Name it.
            </h2>
        </>
    )
}

export default NPlaylist
