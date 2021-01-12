import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import './ProfileInfo.css';

class ProfileInfo extends Component{

    state = {
        username: "",
        firstname: "",
        lastname: "",
        address: "",
        phone: "",
        email: "",
    };

    componentDidMount = () => {
        this.getUserInfo();
    }

    /**
     * This method passes the users username to the render method
     */
    getUsername = () => {
        //== INCOMPLETE ==
        let username = "TESTUSER1";
        let suffix = "'s balance"
        return username + suffix
    }

    /**
     * This method returns the amount of money this user has
     */
    getCurrentBalance = () => {
        return "";
    }

    /**
     * This mehtod returns the amount of money this user has including their portfolio
     */
    getTotalBalance = () => {
        return "";
    }

    /**
     * This method returns the rank of this user
     */
    getRank = () => {
        return "";
    }

    /**
     * This method will send the api a get request and update the state
     */
    getUserInfo = () => {
        //Temporary test info
        let username="TESTUSER";
        let firstname="TEST";
        let lastname="USER";
        let address="1 TESTING DR., TESTLAND, NJ";
        let phone="9739104343";
        let email="TESTEMAIL@Testmail.com";

        //Set the state
        this.setState({
            username: username,
            firstname: firstname,
            lastname: lastname,
            address: address,
            phone: phone,
            email: email
        })
    }

    /**
     * This method will send the api an update request to update the users info
     */
    updateUser = (event) => {
        event.preventDefault();

        this.updatePassword(event.target.password.value);       //handle password update separately

        let username = (event.target.username.value.length === 0)? this.state.username : event.target.username.value;
        let firstname = (event.target.firstname.value.length === 0)? this.state.firstname : event.target.firstname.value;
        let lastname = (event.target.lastname.value.length === 0)? this.state.lastname : event.target.lastname.value;
        let address = (event.target.address.value.length === 0)? this.state.address : event.target.address.value;
        let phone = (event.target.phone.value.length === 0)? this.state.phone : event.target.phone.value;
        let email = (event.target.email.value.length === 0)? this.state.email : event.target.email.value;

        console.log(username);
        console.log(firstname);
        console.log(lastname);
        console.log(address);
        console.log(phone);
        console.log(email);
    }

    /**
     * This method sends an update request to the api to update a users password.
     * We must handle password updates separately since we do not show the users password 
     * @param {String} password 
     */
    updatePassword = (password) => {
        if(password.length === 0){
            return;
        }
    }

    render(){

        return(
            <div className="container" style={{paddingTop: "50px"}}>
                <div className="row">

                    <div className="col-md-5">
                        <h2>Edit User</h2>
                        <form onSubmit={this.updateUser}>
                            <div className="form-group form-inline">
                                <label>Username: </label>
                                <input type="text" className="form-control" id="username" placeholder={this.state.username} style={{width: "100%"}}></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>Password: </label>
                                <input type="text" className="form-control" id="password" style={{width: "100%"}}></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>First Name: </label>
                                <input type="text" className="form-control" id="firstname" placeholder={this.state.firstname} style={{width: "100%"}}></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>LastName: </label>
                                <input type="text" className="form-control" id="lastname" placeholder={this.state.lastname} style={{width: "100%"}}></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>Address: </label>
                                <input type="text" className="form-control" id="address" placeholder={this.state.address} style={{width: "100%"}}></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>Phone: </label>
                                <input type="text" className="form-control" id="phone" placeholder={this.state.phone} style={{width: "100%"}}></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>Email: </label>
                                <input type="text" className="form-control" id="email" placeholder={this.state.email} style={{width: "100%"}}></input>
                            </div>
                            <div className="d-flex justify-content-end">
                                <button type="submit" className="btn btn-primary">Update Info</button>
                            </div>
                            
                        </form>
                    </div>
                    <div className="col-md-2"></div>
                    <div className="col-md-5">
                        <h2>User Info</h2> 
                        <form>
                            <div className="form-group form-inline">
                                <label>Current Balance</label>
                                <input type="text" className="form-control" value={this.getCurrentBalance()} style={{width: "100%"}} readOnly></input>
                            </div>
                            <div className="form-group form-inline">
                                <label>Total Balance</label> 
                                <input type="text" className="form-control" value={this.getTotalBalance()} style={{width: "100%"}} readOnly></input>
                                <small>*This includes the worth of your portfolio</small>
                            </div>
                            <div className="form-group form-inline">
                                <label>Rank</label>
                                <input type="text" className="form-control" value={this.getRank()} style={{width: "100%"}} readOnly></input>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }

}

export default ProfileInfo;