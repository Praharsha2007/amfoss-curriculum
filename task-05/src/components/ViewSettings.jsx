import './ViewSettings.css'
import { Link } from 'react-router-dom';

function View_Settings(){
    return(
        <Link to="/Settings">
        <button className='Settings_View'>
            <h2 className='Title_Settings'> SETTINGS </h2>
        </button>
        </Link>
    )
}

export default View_Settings