import Bottom from '/src/components/bottommenu.jsx'

import './settings.css'
import Top from '/src/components/TopMenu.jsx'

import Side from '/src/components/sidebar.jsx'

import { Link } from 'react-router-dom'
function Settings(){
    return(
        <>
        <Top />
        <Link className='SwitchToUsername' to={"/ChangeUsername"}>
        <button className='username'>
            <h2> CHANGE USERNAME </h2>
        </button>
        </Link>
        <Link className='SwitchToLogin' to={"/LogIn"}>
            <button className='account'>
                <h2> CHANGE ACCOUNT </h2>
            </button>
        </Link>
        <Link className='SwitchToPassword' to={"/ChangePassword"}>
        <button className= 'password'>
            <h2>CHANGE PASSWORD </h2>
        </button>
        </Link>
        <h1 className='title'>
            HEY THERE, [USERNAME]
        </h1>
        <Bottom />
        
        
        </>
        
    )
}

export default Settings