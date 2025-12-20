import './Home.css'
import home_button from '/assets/home.svg'
import { Link } from 'react-router-dom'
function Home(){
    return (
        <div className='Home'>
            <Link className='SwitchtoDashboard' to={"/Dashboard"}>
            <button className='Homebutton'>
                <img src={home_button}></img>
            </button>
            </Link>
        </div>
    )
}

export default Home