import './back.css'
import back_button from '/assets/back.svg'
import { Link } from 'react-router-dom'
function User(){
    return(
        <div className='add'>
            
                <Link to="/Dashboard">
                <button className='BackButton'>
                    <img src={back_button} alt='add'></img>
                </button>
                </Link>
        
        </div>
    )
}
export default User