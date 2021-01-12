import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import './LoginPage.css'
import { AiOutlineUser } from "react-icons/ai";
import { AiOutlineLock } from "react-icons/ai";
import { AiOutlinePhone } from "react-icons/ai";
import { AiOutlineMail } from "react-icons/ai";
import { FaRegAddressBook } from "react-icons/fa";

class SignUpPage extends Component{

    state = {

    };

    /**
     * This method will take in the fields and send a post request to the api to register users
     * @param {} event is the form that contains all the input fields
     */
    register = (event) => {
        event.preventDefault();
        let username = event.target.username.value;
        let firstname = event.target.firstname.value;
        let lastname = event.target.lastname.value;
        let password = event.target.password.value;
        let confirmPassword = event.target.confirmPassword.value;
        let address = event.target.address.value;
        let phone = event.target.phone.value;
        let email = event.target.email.value;

        //call the api

        //redirect
        this.props.history.push({
            pathname: "/login"
        });
    }

    redirectToLogin = () => {
        this.props.history.push({
            pathname: "/login"
        });
    }

    render(){
        return(
            <div>
                <div className="container">
                    <div className="d-flex justify-content-end" style={{marginBottom:"50px"}}>
                        <button type="button" onClick={this.redirectToLogin} className="btn btn-dark">Login</button>
                    </div>

                    <h1>Register</h1>
                    <div className="row">
                        <div className="col" />
                        <div className="col-md-5">
                            <form onSubmit={this.register}>
                                <div className="md-form">
                                    <AiOutlineUser className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="username" placeholder="Username" required />
                                </div>
                                <div className="md-form">
                                    <AiOutlineUser className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="firstname" placeholder="First Name" required />
                                </div>
                                <div className="md-form">
                                    <AiOutlineUser className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="lastname" placeholder="Last Name" required />
                                </div>
                                <div className="md-form">
                                    <AiOutlineLock className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="password" placeholder="Password" required />
                                </div>
                                <div className="md-form">
                                    <AiOutlineLock className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="confirmPassword" placeholder="Confirm Password" required />
                                </div>
                                <div className="md-form">
                                    <FaRegAddressBook className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="address" placeholder="Address" />
                                </div>
                                <div className="md-form">
                                    <AiOutlinePhone className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="phone" placeholder="Phone" />
                                </div>
                                <div className="md-form">
                                    <AiOutlineMail className="prefix d-flex justify-content-start" />
                                    <input type="text" className="form-control" id="email" placeholder="Email" required />
                                </div>
                                <button className="btn btn-primary d-flex justify-content-start">Register</button>
                            </form>
                        </div>
                        <div className="col" />
                    </div>
                    
                </div>
                
            </div>
        );
    }

}

export default SignUpPage;