import search_button from '/assets/search.svg'
import './Search.css'
import { Link } from 'react-router-dom';
function Search() {
    return (
        <>
        <Link to="/Search">
        <button className='SearchBar'>
            <button className='logo'>
                <img src={search_button} alt='Search button' />
            </button>
            <input
                type="text" 
                className="searchInput" 
                placeholder="Search..."
            />
        </button>
        </Link>
        </>
    )
}

export default Search;