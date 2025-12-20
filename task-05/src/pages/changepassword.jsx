import './changepassword.css'
import Line from '/src/components/line.jsx'
import { Link } from 'react-router-dom';
import Logo from '/assets/logo.png'

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
function ChangePassword(){
   
    return(

            <div className='changepassword'>
                
                <input
                type='password'
                className='changepasswordinput'
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
        <ChangePassword />
        <Link className='Dashboard' to={"/Dashboard"}>
            <button className='submit'>
                CONFIRM
            </button>
        </Link>
        <h3 className='enter_email'>Enter Email</h3>
        <h3 className='enter_username'>Enter Username</h3>
        <h3 className='enter_password'>Enter Password</h3>
        <h3 className='change_password'>Confirm Password</h3>
        <h1 className='Welcome'>CHANGE PASSWORD</h1>

        
        </>
    )
}



export default Changepassword