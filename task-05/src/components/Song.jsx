import './Song.css'
import cover from '/assets/headphones.svg'

function Song(){
    return(
        <button className= "box">
            <div className='SongCard'>
            <div className='Cover'><img src={cover}></img></div>
            <div className='SongTitle'>TITLE</div>
        </div>
        
        </button>
    )
}

export default Song