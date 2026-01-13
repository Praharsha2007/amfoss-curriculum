import './details.css'
import cover from '/assets/headphones.svg'
import Bottom from '/src/components/bottommenu.jsx'
import Back from '/src/components/back.jsx'
import { useState } from 'react'
function Details({song}){

    return(
        <>
        <div className="details-wrapper">

  <div className="Album_Cover">
    <img src={song.cover} />
  </div>

  <div className="Details1">
    <h2 className="Song_Title">SONG: {song.track_name}</h2>
    <h2 className="Artist_Details">ARTIST: {song.artist_name}</h2>
    <h2 className="Released_Year">YEAR: {song.release_date}</h2>
  </div>

</div>


        <Back />
        </>
    )   
}

export default Details