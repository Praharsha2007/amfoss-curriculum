import "./Menu.css";
import menu_button from "/assets/menu.svg";
import { useState } from "react";
import SideBar from "./sidebar.jsx";
import back from "/assets/right.svg";

function Menu() {
  const [open, setOpen] = useState(false);

  return (
    <>
      <button className="MenuButton" onClick={() => setOpen(true)}>
        <img src={menu_button} />
      </button>

      {open && (
        <div className="Sidebararrangement">
          <SideBar />
          <button className="SideBack" onClick={() => setOpen(false)}>
            <img src={back} />
          </button>
        </div>
      )}
    </>
  );
}

export default Menu;
