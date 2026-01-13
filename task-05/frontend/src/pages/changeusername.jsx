import './changeusername.css'
import Logo from '/assets/logo.png'
import Line from '/src/components/line.jsx'
import { Link , useNavigate} from 'react-router-dom'
import { useState,  } from 'react'

function Changepassword(){

    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [username, setUsername] = useState("")
    const [new_us, setNewUsername] = useState("")
    const navigate = useNavigate()
    const changeUsername = async() => {
        const response = await fetch("http://127.0.0.1:5000/changeusername", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                email: email,
                password: password,
                new_us: new_us,
            })

        })
        const data = await response.json()
        console.log(data)
        if (response.ok){
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

            <div className='passwordsignup'>
                <input
                    type='password'
                    className='passwordinput'
                    placeholder='Enter your password...'
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
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

            <div className='changeusername'>
                <input
                    type='text'
                    className='changeusernameinput'
                    placeholder='Enter your username...'
                    value={new_us}
                    onChange={(e) => setNewUsername(e.target.value)}
                />
            </div>


                <button className='submit' onClick={changeUsername}>
                    CONFIRM
                </button>

            <h3 className='enter_email'>Enter Email</h3>
            <h3 className='enter_username'>Enter Username</h3>
            <h3 className='enter_password'>Enter Password</h3>
            <h3 className='change_username'>New Username</h3>
            <h1 className='Welcome'>CHANGE USERNAME</h1>    
        </>
    )
}

export default Changepassword
