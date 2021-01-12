import React from "react"
import { NavLink } from 'react-router-dom'

function NavBar() {
    return (
        <div className="nav_list">
            <ul>
                <li><NavLink to='/'>Home</NavLink></li>
                <li><NavLink to='/about'>About</NavLink></li>
            </ul>
        </div>
    );
}

export default NavBar
