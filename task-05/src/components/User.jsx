import './User.css'
import user_button from '/assets/user.svg'
import { Link } from 'react-router-dom'
function User(){
    return(
        <div className='User'>
            
                <Link className='Settings' to="/Settings">
                
                <button className='Userbutton'>
                    <img src={user_button} alt='User'></img>
                </button>
                </Link>
                
        
        </div>
    )
}
export default User