import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import Item from "./Item";

class SellItem extends Component{

    state={
        items: [],
        totalPrice: 0.00,
        itemsSold: new Map(),
    };

    componentDidMount = () =>{
        this.fillStateWithTestInfo();
    }

    /**
     * This method keeps track of all the items and their quantities that the user wants to buy by storing the values in a hashamp
     * @param {JSON} item contains name, price, and quantity fields
     */
    addToCart = (item) => {
        let map = this.state.itemsSold;
        map.set(item.name, item);
        this.calculateTotal();   
    }

    /**
     * Calculates the running sum of the prices of all the items the user wants to buy
     */
    calculateTotal = () => {
        let itemsSold = this.state.itemsSold;
        let totalPrice = 0;
        for(let[key, value] of itemsSold){
            totalPrice += (value.price * value.quantity);
        }
        totalPrice = (Math.round(totalPrice * 100) / 100).toFixed(2);
        this.setState({totalPrice: totalPrice});
    }

    /**
     * This method is for testing purposes
     */
    fillStateWithTestInfo = () => {
        let newState = [];
        
        newState.push({
            name: "orange",
            price: 2,
            quantity: 3
        });
        newState.push({
            name: "watermelon",
            price: 10,
            quantity: 1
        });
        newState.push({
            name: "apple",
            price: 5.37,
            quantity: 2
        });
        this.setState({items: newState});
    }

    /**
     * This method will convert the map of selected items into a JSON and send it as a post request to the api
     */
    sellItems = () => {
        let selected = this.state.itemsSold;
        let json = [];
        for(let[key,value] of selected){
            json.push(value);
        }

        //== INCOMPLETE ==
        //write api call to server
    }

    render(){
        return(
            <div className="card">
                <div className="card-header">Sell Items</div>
                <div className="card-body">
                    <table className="table">
                        <thead>
                            <tr>
                                <th scope="col">Item Name</th>
                                <th scope="col">Price</th>
                                <th scope="col">Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.items.map( (item, index) => (
                                <Item
                                    key={index}
                                    name={item.name}
                                    price={item.price}
                                    quantity={item.quantity}
                                    addToCart={this.addToCart}
                                />
                            ) )}
                        </tbody>

                    </table>

                    
                    <div className="d-flex justify-content-end">
                        <span>Total: ${parseFloat(this.state.totalPrice)}</span>
                    </div>
                    <div className="d-flex justify-content-end">
                        <button className="btn btn-primary">Sell</button>
                    </div>
                </div>          
            </div>
        );
    }
}

export default SellItem;