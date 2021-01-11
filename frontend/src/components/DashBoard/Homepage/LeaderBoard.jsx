import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

import UserRank from "./UserRank";

class LeaderBoard extends Component{

    state={
        users: [],
    };

    componentDidMount = () => {
        this.populateUsers();
    }

    /**
     * This method is for testing purposes
     */
    populateUsers(){
        let users = this.state.users;
        users.push({
            username: "Mike",
            money: 70
        });
        users.push({
            username: "Evalynne",
            money: 65
        });
        users.push({
            username: "Andrew",
            money: 62
        });
        users.push({
            username: "Carrie",
            money: 59
        });
        users.push({
            username: "Joe",
            money: 55
        });
        this.setState({users: users});
    }

    render(){

        return(
            <div class="card">
                <div class="card-header">LeaderBoard</div>
                <div class="card-body">
                    <table className="table">
                        <thead>
                            <tr>
                            <th scope="col">Rank</th>
                            <th scope="col">Username</th>
                            <th scope="col">Money</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.users.map( (user, index) => (
                                <UserRank 
                                    key={index}
                                    rank={index+1}
                                    username={user.username}
                                    money={user.money}
                                />
                            ) )}
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default LeaderBoard;