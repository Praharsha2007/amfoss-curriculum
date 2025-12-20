import './album.css'
import cover from '/assets/headphones.svg'

function Album(){
    return(
        <button className= "container">
            <div className='AlbumCard'>
            <div className='Cover'><img src={cover}></img></div>
            <div className='AlbumTitle'>TITLE</div>
        
        </div>
        
        </button>
    )
}

export default Album