import { AiOutlineUser } from "react-icons/ai";

function Header(props){
    return(
        <div className="d-flex justify-content-between">
            <button type="button" onClick={props.logout} className="btn btn-dark">Logout</button>
            <span class="profileIcon">
                <AiOutlineUser />
                {props.username}
            </span>
        </div>
    );
}

export default Header;