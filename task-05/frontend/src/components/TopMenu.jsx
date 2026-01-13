import melofi from "/assets/melofi.png";
import { Link, useLocation } from "react-router-dom";
import Menu from "./Menu.jsx";
import User from "./User.jsx";
import search from "/assets/search.svg";
import "./TopMenu.css";

function TopMenu() {
  const location = useLocation();
  const hideMenu = location.pathname === "/SearchPage";

  return (
    <div className="TopBar">

      {/* LEFT */}
      <div className="TopLeft">
        <Link to="/Dashboard">
          <img src={melofi} className="Melofi_logo" />
        </Link>
      </div>

      {/* CENTER */}
      <div className="TopCenter">
        <Link to="/SearchPage">
          <img src={search} className="TopIcon" />
        </Link>
      </div>

      {/* RIGHT */}
      <div className="TopRight">
        {!hideMenu && <Menu />}

        <Link to="/Library" className="TopLink">
        
        </Link>

        <User />
      </div>

    </div>
  );
}

export default TopMenu;
