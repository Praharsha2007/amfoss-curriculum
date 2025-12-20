import './Delete.css'
import delete_button from '/assets/delete.svg'
import { Link } from 'react-router-dom'
function User(){
    return(
        <div className='Delete'>
                <button className='DeleteButton'>
                    <img src={delete_button} alt='User'></img>
                </button>
        </div>
    )
}
export default User