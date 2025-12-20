import './changeusername.css'
import Logo from '/assets/logo.png'
import Line from '/src/components/line.jsx'
import { Link } from 'react-router-dom';

function Email(){
    return(
        <>
            <div className='email'>
                
                <input
                type='Text'
                className='emailinput'
                placeholder='Enter your Email...'
            /></div>
        </>
        )
}

function Username(){

    return(
            <div className='usernamesignup'>
                
                <input
                type='Text'
                className='usernameinput'
                placeholder='Enter your username...'

            
            /></div> 
        )
}
function Password(){

    return(

            <div className='passwordsignup'>
                
                <input
                type='password'
                className='passwordinput'
                placeholder='Enter your password...'
            /></div>
        )
}
function ChangeUsername(){
    return(

            <div className='changeusername'>
                
                <input
                type='password'
                className='changeusernameinput'
                placeholder='Enter your password...'
            /></div>
        )
}

function Changepassword(){
    return(
        <>
        <Email />
        <Password />
        <Username />
        <ChangeUsername />
        <Link className='Dashboard' to={"/Dashboard"}>
            <button className='submit'>
                CONFIRM
            </button>
        </Link>
        <h3 className='enter_email'>Enter Email</h3>
        <h3 className='enter_username'>Enter Username</h3>
        <h3 className='enter_password'>Enter Password</h3>
        <h3 className='change_username'>Confirm Username</h3>
        <h1 className='Welcome'>CHANGE USERNAME</h1>    
  
        </>
    )
}



export default Changepassword