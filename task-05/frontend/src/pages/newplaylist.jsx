import { useState } from 'react'
import './newplaylist.css'
import PlaylistSong from '/src/components/playlist_song.jsx'
import Add from '/src/components/Add.jsx'
import Delete from '/src/components/Delete.jsx'
import Top from '/src/components/TopMenu.jsx'
import Bottom from '/src/components/bottommenu.jsx'

function NPlaylist(){
    const [name, setName] = useState("")

    const newPlaylist = async () => {
        const response = await fetch("http://127.0.0.1:5000/playlist/create", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name,
                username: localStorage.getItem("username")
            })
        })

        const data = await response.json()
        console.log(data)
        if (data.msg == "done"){
            alert("Created the playlist!")
        }
    }

    return(
        <>
            <input
                className='playlistInput'
                type='text'
                placeholder='Enter a playlist name....'
                value={name}
                onChange={(e) => setName(e.target.value)}
                onKeyDown={(e) => {
                    if (e.key === "Enter"){
                        newPlaylist()
                    }
                }}
            />

            <div className='NArrangement'></div>

            <Top />

            <div className='NControls'>
                <div className='Add'onClick={newPlaylist}
                />
            </div>

            <h2 className='Title'>
                Add Songs to this new playlist and Name it.
            </h2>
        </>
    )
}

export default NPlaylist
