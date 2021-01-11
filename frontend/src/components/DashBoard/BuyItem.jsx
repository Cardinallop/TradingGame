import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

class BuyItem extends Component{

    state={
        items: [],
    };

    componentDidMount = () =>{
        console.log("here");
        this.fillStateWithTestInfo();
    }

    fillStateWithTestInfo = () => {
        let newState = [];
        newState.push({
            item: "apple",
            price: 5,
            amount: 5
        });
        newState.push({
            item: "orange",
            price: 2,
            amount: 10
        });
        
        this.setState({items: newState});
    }

    render(){
        
        return (
            <div className="container">

            </div>
        );
    }
}

export default BuyItem;