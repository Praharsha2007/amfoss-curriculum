import "./changepassword.css";
import { Link , useNavigate} from "react-router-dom";
import Logo from "/assets/logo.png";
import { useState } from "react";

function Changepassword() {
    const [username, setUsername] = useState("")
    const [old_pw, setPassword] = useState("")
    const [email, setEmail] = useState("")
    const [new_pw, setNew] = useState("")
    const navigate = useNavigate()
    const changePassword = async() => {
        const response = await fetch("http://127.0.0.1:5000/changepassword", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                old_pw: old_pw,
                new_pw: new_pw,
            })

        })
        const data = await response.json()
        console.log(data)
        if (response.ok){
            navigate("/Dashboard")
        }

    }
        
  return (
    <>
      <div className="email">
        <input
          type="text"
          className="emailinput"
          placeholder="Enter your Email..."
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>

      <div className="passwordsignup">
        <input
          type="password"
          className="passwordinput"
          placeholder="Enter your password..."
          value = {old_pw}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>

      <div className="usernamesignup">
        <input
          type="text"
          className="usernameinput"
          placeholder="Enter your username..."
          value = {username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>
      <div className="changepassword">
        <input
          type="password"
          className="changepasswordinput"
          placeholder="Confirm your password..."
          value = {new_pw}
          onChange={(e) => setNew(e.target.value)}
        />
      </div>

        <button className="submit" onClick={changePassword}>CONFIRM</button>

      <h3 className="enter_email">Enter Email</h3>
      <h3 className="enter_username">Enter Username</h3>
      <h3 className="enter_password">Enter Password</h3>
      <h3 className="change_password">Confirm Password</h3>

      <h1 className="Welcome">CHANGE PASSWORD</h1>
    </>
  );
}

export default Changepassword;
