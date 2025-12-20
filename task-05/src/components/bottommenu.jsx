import './bottommenu.css'
import pause from '/assets/pause.svg'
import rewind from '/assets/rewind.svg'
import forward from '/assets/forward.svg'
import like from '/assets/like.svg'
import { Link } from 'react-router-dom'

function Bar(){
    return(
        <>
        <div className='Bar'>
            <button className='Pause'>
                <img src={pause} alt='pause'></img>
            </button>
            <button className='Rewind'>
                <img src={forward} alt='rewind'></img>
            </button>
            <button className='Forward'>
                <img src={rewind} alt='forward'></img>
            </button>
            <Link to="/Details">
            <button className='details'>
                DETAILS
            </button>
            </Link>
            <div className='Slider'>
                
            </div>
            <div className='Image'>

            </div>
            <div className='Song'>
                Song Title
            </div>
            <div className='Artist'>
                Artist
            </div>
            <button className='Like'>
                <img src={like} alt='heart'></img>
            </button>
        </div>
        
        </>
    )
}

export default Bar