import './playlist_section.css'
import Add from '/src/components/Add.jsx'
import Bottom from '/src/components/bottommenu.jsx'
import Delete from '/src/components/Delete.jsx'
import PlaylistSong from '/src/components/playlist_song.jsx'
import Top from '/src/components/TopMenu.jsx'
function Playlist(){
    return(
        <>
        <div className='PArrangement'>
            <PlaylistSong />
            <PlaylistSong />
            <PlaylistSong />
        </div>
        <Top />
        <Bottom />
        <h1 className='PlaylistTitle'>PLAYLIST - 1</h1>
        <div className='PControls'>
                    <Delete />
                    <Add />
                </div>
        </>
    )
}

export default Playlist