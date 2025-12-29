import './Menu.css'
import menu_button from '/assets/menu.svg'
import { Link } from 'react-router-dom'
import SideBar from '/src/components/sidebar.jsx'
import { useState } from 'react'
import back from '/assets/right.svg'
function Menu(){
    const [visible, setVisible] = useState(false);
    return(
        <>
        <div className='Menu'>
            <button className='MenuButton' onClick={() => setVisible(true)}>
                <img src={menu_button} alt='Menu'></img>
            </button>
            
            {visible && <div className='Sidebararrangement'>
            <SideBar />
            <button className='SideBack' onClick={()=> setVisible(false)}>
                <img src={back}></img>
                {visible && <div>
                    </div>}
        </button>

            </div>}
        </div>
        
        
        </>
    )
}

export default Menu
