import { StrictMode } from 'react'
import melofi from '/assets/melofi.png'
import './TopMenu.css'
import Search from '/src/components/Search.jsx'
import Menu from '/src/components/Menu.jsx'
import User from '/src/components/User.jsx'
import Home from '/src/components/Home.jsx'

function MenuBar(){
  return(
    <div className='TopBar'>
    <Search />
    <Menu />
    <User />
    <Home />
    <div className='Melofi1'>
      <img className='Melofi_logo' src={melofi} alt='melofi'></img>
    </div>
    </div>
  
  )
}

export default MenuBar;