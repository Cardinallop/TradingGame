import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import "./DashBoard.css";

import Header from "./Header";
import Homepage from "./Homepage/Homepage";
import ProfileInfo from "./Profile/ProfileInfo";


class DashBoard extends Component{

    state = {
        showHome: true
    };

    renderHomeProfile = () => {
        if(this.state.showHome){
            return <Homepage />
        }else{
            return <ProfileInfo />
        }
    }

    showHome = () => {
        this.setState({showHome: true});
    }

    showProfile = () => {
        this.setState({showHome: false});
    }

    render(){
        let page = this.renderHomeProfile();
        return(
            <div>
                <Header />
                <div className="d-flex justify-content-center">
                    <button 
                        className={"btn " + (this.state.showHome? "btn-dark": "btn-light") + " choiceBtn"}
                        onClick={this.showHome}
                        >Home</button>
                    <button 
                        className={"btn " + (this.state.showHome? "btn-light": "btn-dark") + " choiceBtn"}
                        onClick={this.showProfile}
                        >Profile</button>
                </div>
                {page}
            </div>
            
        );
    }

}

export default DashBoard;