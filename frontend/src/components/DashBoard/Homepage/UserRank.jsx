import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

class UserRank extends Component{
    state={
        username: this.props.username,
        rank: this.props.rank,
        money: (Math.round(this.props.money * 100) / 100).toFixed(2),
    }

    render(){

        return(
            <tr>
                <td>{this.state.rank}</td>
                <td>{this.state.username}</td>
                <td>${this.state.money}</td>
            </tr>
        );
    }
}

export default UserRank;