import PlaylistSong from '/src/components/playlist_song.jsx'
import Add from '/src/components/Add.jsx'
import Delete from '/src/components/Delete.jsx'
import Top from '/src/components/TopMenu.jsx'
import Bottom from '/src/components/bottommenu.jsx'
import './likedsongs.css'
function NPlaylist(){
    return(
        <>
        <div className='NArrangement'>
            <PlaylistSong />
            <PlaylistSong />
            <PlaylistSong />
        </div>
        <Top />
        <Bottom />
        <h1 className='NlaylistTitle'>LIKED SONGS</h1>
        <div className='NControls'>
                    <Delete />
                    <Add />
        </div>
        </>
    )
}

export default NPlaylist