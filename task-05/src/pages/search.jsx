import './search.css'
import Search from '../components/Search.jsx'
import Bottom_Menu from '../components/bottommenu.jsx'
import Suggesting from '../components/search_songs.jsx'
import Back from '../components/back.jsx'
function Searching(){
    return(
        <>
        <Search />
        <Bottom_Menu />
        <div className='Suggestions'>
            <Suggesting />
            <Suggesting />
            <Suggesting />
        </div>
        <Back />
        </>
    )
}

export default Searching