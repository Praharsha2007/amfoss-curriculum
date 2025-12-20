import './login.css'
import SignUp from './signuppage.jsx';
import Line from '/src/components/linelogin.jsx'
import { Link } from 'react-router-dom';
import Logo from '/assets/logo.png'
import Google from '/src/components/google.jsx'
function Username(){
    return(
            <button className='usernamelogin'>
                
                <input
                type='Text'
                className='usernameinput'
                placeholder='Enter your username...'

            
            /></button> 
        )
}
function Password(){
    return(
            <button className='passwordlogin'>
                
                <input
                type='password'
                className='passwordinput'
                placeholder='Enter password...'
            /></button>
        )
}


function Login(){
    return(
        <>
        <div className='container'>
            
            <h1 className='login'>LOG IN</h1>
            <h3 className='enter_username'>Enter Username</h3>
            <Username />

        <Password />
        <Link className='done_link' to="/Dashboard">
            <button className='Done'>LOGIN </button>
        </Link>

        
        
        <h3 className='enter_password'>Enter Password</h3>
        <Link to="/ChangePassword">
        <h3 className='forgot_password'>Forgot Password?</h3>
        </Link>
        
        <h4 className='switch_signup'>If you do not have an account, CREATE ONE!</h4>

        <Link className='signup_link' to="/SignUp">
        <button className='register'>
            REGISTER
        </button>
        </Link>
        
        <Line />
        
        <div className='line1'> </div>
        <div className='Alternates'>
            <Google />
        </div>
        </div>
        </>
    )
}

export default Login
