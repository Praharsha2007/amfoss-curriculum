import './Add.css'
import add_button from '/assets/add.svg'
function User(){
    return(
        <div className='add'>
            
                
                <button className='AddButton'>
                    <img src={add_button} alt='add'></img>
                </button>
                
        
        </div>
    )
}
export default User