import './Add.css'
import add_button from '/assets/add.svg'
import { Link } from 'react-router-dom'
function User(){
    return(
        <div className='addS'>
            
                
                <div className='AddButtonS'>
                    <img src={add_button} alt='add'></img>
                </div>
                
        
        </div>
    )
}
export default User