
function Header(props){
    return(
        <div className="d-flex justify-content-between">
            <button type="button" onClick={props.logout} className="btn btn-dark">Logout</button>
            <span>Username</span>
        </div>
    );
}

export default Header;