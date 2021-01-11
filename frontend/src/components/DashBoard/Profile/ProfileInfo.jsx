import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

class ProfileInfo extends Component{

    state = {

    };

    render(){

        return(
            <div className="container" style={{paddingTop: "50px"}}>
                <div className="row">
                    <div className="col-md-1">
                    </div>

                    <div className="col-md-6">
                        <form>
                            <div className="form-group">
                                <input type="text" className="form-control" id="username" placeholder="Username"></input>
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control" id="firstname" placeholder="First Name"></input>
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control" id="lastname" placeholder="Last Name"></input>
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control" id="address1" placeholder="Address 1"></input>
                            </div>
                            <div className="form-group">
                                <input type="number" className="form-control" id="phone" placeholder="Phone Number"></input>
                            </div>
                            <div className="form-group">
                                <input type="text" className="form-control" id="email" placeholder="Email"></input>
                            </div>
                            <div class="d-flex justify-content-end">
                            <button type="submit" className="btn btn-primary">Update Info</button>
                            </div>
                            
                        </form>
                    </div>
                    <div className="col-md-5"></div>
                </div>
            </div>
        );
    }

}

export default ProfileInfo;