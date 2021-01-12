import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import './LoginPage.css'
import { AiOutlineUser } from "react-icons/ai";
import { AiOutlineLock } from "react-icons/ai";

class LoginPage extends Component{

    state = {
        hasFailed: false,
    };

    /**
     * This method will call the api and pass the username and password input fields. The api will give us the authentication status
     */
    attemptLogin = (event) => {
        event.preventDefault();
        let username = event.target.username.value;
        let password = event.target.password.value;

        //Call the api

        //redirect to dashboard
        this.props.history.push({
            pathname: "/dashboard",
            username: username
        });
    }

    /**
     * This method displays a failed login message after a failed login attempt
     */
    displayFailedLogin = () => {
        if(this.state.hasFailed){
            return <small style={{color: "red"}}>*Failed Login attempt. Please try again!</small>
        }
    }

    redirectToRegister = () => {
        this.props.history.push({
            pathname: "/login"
        });
    }

    render(){
        return(
            <div>
                <div className="container">
                    <div className="d-flex justify-content-end" style={{marginBottom:"50px"}}>
                        <button type="button" onClick={this.redirectToRegister} className="btn btn-dark">Register</button>
                    </div>
                    <h1>Login</h1>
                    {this.displayFailedLogin()}
                    <div className="row">
                        <div className="col" />
                        <div className="col-md-5">
                            <form onSubmit={this.attemptLogin}>
                                <div className="md-form">
                                    <AiOutlineUser className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="username" placeholder="Username" required />
                                </div>
                                <div className="md-form">
                                    <AiOutlineLock className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="password" placeholder="Password" required />
                                </div>
                                <button type="submit" className="btn btn-primary d-flex justify-content-start">Login</button>
                            </form>
                        </div>
                        <div className="col" />
                    </div>
                    
                </div>
                
            </div>
        );
    }

}

export default LoginPage;