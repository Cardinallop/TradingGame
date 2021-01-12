import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import "./DashBoard.css";

import Header from "./Header";
import Homepage from "./Homepage/Homepage";
import ProfileInfo from "./Profile/ProfileInfo";
import AboutPage from "./pages/about_page";


class DashBoard extends Component{

    constructor(props){
        super();

        // if(props.location.username == null){         
        //     props.history.push({
        //         pathname: "/login"
        //     });
        // }
    }

    state = {
        showHome: 0
    };

    renderHomeProfile = () => {
        if(this.state.showHome == 0){
            return <Homepage />
        }else if(this.state.showHome == 1){
            return <ProfileInfo />
        }else if(this.state.showHome == 2){
            return <AboutPage />
        }
    }

    showHome = () => {
        this.setState({showHome: 0});
    }

    showProfile = () => {
        this.setState({showHome: 1});
    }

    showAbout = () => {
        this.setState({showHome: 2})
    }

    logout = () => {
        this.props.history.push({
            pathname: "/login"
        });
    }

    render(){
        let page = this.renderHomeProfile();
        return(
            <div>
                <Header 
                    logout={this.logout}
                    username={this.props.location.username}
                />
                <div className="d-flex justify-content-center">
                    <button 
                        className={"btn " + (this.state.showHome == 0? "btn-dark": "btn-light") + " choiceBtn"}
                        onClick={this.showHome}
                        >Home</button>
                    <button 
                        className={"btn " + (this.state.showHome == 1? "btn-dark": "btn-light") + " choiceBtn"}
                        onClick={this.showProfile}
                        >Profile</button>
                    <button 
                        className={"btn " + (this.state.showHome == 2? "btn-dark": "btn-light") + " choiceBtn"}
                        onClick={this.showAbout}
                        >About</button>
                </div>
                {page}
            </div>
            
        );
    }

}

export default DashBoard;