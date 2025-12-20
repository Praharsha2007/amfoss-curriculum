import './details.css'
import cover from '/assets/headphones.svg'
import Bottom from '/src/components/bottommenu.jsx'
import Back from '/src/components/back.jsx'
import { useState } from 'react'
function Details(){

    return(
        <>
        <div className='Album_Cover'>
            <img src={cover}></img>
        </div>
        <div className='Details1'>
            <h2 className='Song_Title'>SONG: ____</h2>
            <h2 className='Artist_Details'>ARTIST: ____</h2>
            <h2 className='Album'>ALBUM: ____</h2>
            <h2 className='Released_Year'>YEAR: ____</h2>
        </div>
        <Bottom />
        <Back />
        </>
    )   
}

export default Details