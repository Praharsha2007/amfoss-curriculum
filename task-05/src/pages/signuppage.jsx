import './signuppage.css'
import Line from '/src/components/line.jsx'
import { Link } from 'react-router-dom';
import Logo from '/assets/logo.png'
import Google from '/src/components/google.jsx'
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

function SignUp(){
    return(
        <>
            <Email />
            <Password />
            <Username />
            <Line />
            <Link className='Dashboard' to={"/Dashboard"}>
                <button className='submit1'>
                    SIGN UP
                </button>
            </Link>
            <h3 className='enter_email'>Enter Email</h3>
            <h3 className='enter_username'>Enter Username</h3>
            <h3 className='enter_password'>Enter Password</h3>

            <h1 className='Welcome1'>WELCOME</h1>

            <Link className='login_link' to="/LogIn"> 
            <button className='Login'>LOGIN</button>
            
            </Link>
            <div className='Google_Button'>
                <Google />
            </div>
            <div className='ExtraLine'>
                <Line />
            </div>
            <h4 className='Change'>If you already have an account, then </h4>
        </>
    )
}



export default SignUp