import './search_songs.css'
import Scover from '/assets/headphones.svg'
import Delete from '/src/components/DeleteS.jsx'
import Add from '/src/components/AddS.jsx'

function Search_Song(){
    return(
        <button className='SearchSong'>
                    <div className='SImage'><img className='SLogo' src={Scover}></img></div>
                    <div className='STitle'>Song Title</div>
                    <div className='SArtist'>Artist</div>
                    <div className='Search_Controls'>
                        <Delete />      
                    </div>
                    <div className='AddS'>
                        <Add />      
                    </div>
                </button>
    )
}

export default Search_Song