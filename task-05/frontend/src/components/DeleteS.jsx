import './Delete.css'
import delete_button from '/assets/delete.svg'
import { Link } from 'react-router-dom'
function User(){
    return(
        <div className='DeleteS'>
                <div className='DeleteButtonS'>
                    <img src={delete_button} alt='User'></img>
                </div>
        </div>
    )
}
export default User