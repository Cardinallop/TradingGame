import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import './LoginPage.css'
import { AiOutlineUser } from "react-icons/ai";
import { AiOutlineLock } from "react-icons/ai";

class LoginPage extends Component{

    state = {

    };

    render(){

        return(
            <div className="background-img">
                
                <div class="container">

                    <div className="d-flex justify-content-end" style={{marginBottom:"50px"}}>
                        <button className="btn btn-dark">Register</button>
                    </div>

                    <h1>Login</h1>
                    <div class="row">
                        <div class="col" />
                        <div class="col-md-5">
                            <form>
                                <div class="md-form">
                                    <AiOutlineUser className="prefix d-flex justify-content-start" />
                                    <input type="text" class="form-control" id="username" placeholder="Username" />

                                </div>
                                <div class="md-form">
                                    <AiOutlineLock className="prefix d-flex justify-content-start" />
                                    <input type="text" class="form-control" id="password" placeholder="Password" />
                                </div>
                                <button className="btn btn-primary d-flex justify-content-start">Login</button>
                            </form>
                        </div>
                        <div class="col" />
                    </div>
                    
                </div>
                
            </div>
        );
    }

}

export default LoginPage;