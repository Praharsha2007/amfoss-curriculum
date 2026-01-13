import './signuppage.css'
import Line from '/src/components/line.jsx'
import { Link, useNavigate } from 'react-router-dom';
import Logo from '/assets/logo.png'
import Google from '/src/components/google.jsx'
import { useState } from 'react';

function SignUp(){

    const [email, setEmail] = useState("")
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const navigate = useNavigate()
    const signUp = async () => {
        const response = await fetch("http://127.0.0.1:5000/register", {           
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify({
                email: email,
                username: username,
                password: password
            })
        })

        const data = await response.json()
        console.log(data)
        localStorage.setItem("username", username)
        localStorage.setItem("user_id", data.user_id);

        if (response.ok) {
            navigate("/Dashboard")
        }
    }

    return(
        <>
            <div className='email'>
                <input
                    type='Text'
                    className='emailinput'
                    placeholder='Enter your Email...'
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />
            </div>

            <div className='usernamesignup'>
                <input
                    type='Text'
                    className='usernameinput'
                    placeholder='Enter your username...'
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
            </div>

            <div className='passwordsignup'>
                <input
                    type='password'
                    className='passwordinput'
                    placeholder='Enter your password...'
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </div>

            <Line />

            {/* FIX 2: No Link here — otherwise fetch gets cancelled */}
            <button className='submit1' onClick={signUp}>
                SIGN UP
            </button>

            <h3 className='enter_email'>Enter Email</h3>
            <h3 className='enter_username'>Enter Username</h3>
            <h3 className='enter_password'>Enter Password</h3>

            <h1 className='Welcome1'>WELCOME</h1>

            <Link className='login_link' to="/LogIn"> 
                <button className='Login'>LOGIN</button>
            </Link>

            <div className='ExtraLine'>
                <Line />
            </div>

            <h4 className='Change'>If you already have an account, then </h4>
        </>
    )
}

export default SignUp
