import './login.css'
import SignUp from './signuppage.jsx'
import Line from '/src/components/linelogin.jsx'
import { Link , useNavigate} from 'react-router-dom'
import Logo from '/assets/logo.png'
import Google from '/src/components/google.jsx'
import { useState } from 'react'

function Login(){

    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const navigate = useNavigate()
    const logIn = async () => {
        const response = await fetch("http://127.0.0.1:5000/login",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                password: password
            })

        })
        const data = await response.json()
        localStorage.setItem("username", username)
        localStorage.setItem("user_id", data.user_id);


        console.log(data)
        if (response.ok){
            navigate("/Dashboard")
        }

    }

    return(
        <>
        <div className='container'>
            
            <h1 className='login'>LOG IN</h1>
            <h3 className='enter_username'>Enter Username</h3>

            <button className='usernamelogin'>
                <input
                    type='Text'
                    className='usernameinput'
                    placeholder='Enter your username...'
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
            </button>

            <button className='passwordlogin'>
                <input
                    type='password'
                    className='passwordinput'
                    placeholder='Enter password...'
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </button>

            <button className='Done' onClick={logIn}>LOGIN</button>

            <h3 className='enter_password'>Enter Password</h3>

            <Link to="/ChangePassword">
                <h3 className='forgot_password'>Forgot Password?</h3>
            </Link>
        
            <h4 className='switch_signup'>If you do not have an account, CREATE ONE!</h4>

            <Link className='signup_link' to="/SignUp">
                <button className='register'>REGISTER</button>
            </Link>
        
            <Line />
        
            <div className='line1'></div>

        </div>
        </>
    )
}

export default Login
