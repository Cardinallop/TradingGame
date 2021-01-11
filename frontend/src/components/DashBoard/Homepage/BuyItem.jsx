import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import Item from "./Item";

class BuyItem extends Component{

    state={
        items: [],
        totalPrice: 0.00,
        itemsBought: new Map(),
    };

    componentDidMount = () =>{
        this.fillStateWithTestInfo();
    }

    /**
     * This method keeps track of all the items and their quantities that the user wants to buy by storing the values in a hashamp
     * @param {JSON} item contains name, price, and quantity fields
     */
    addToCart = (item) => {
        let map = this.state.itemsBought;
        map.set(item.name, item);
        this.calculateTotal();   
    }

    /**
     * Calculates the running sum of the prices of all the items the user wants to buy
     */
    calculateTotal = () => {
        var itemsBought = this.state.itemsBought;
        var totalPrice = 0;
        for(let[key, value] of itemsBought){
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
            name: "apple",
            price: 5.37,
            quantity: 5
        });
        newState.push({
            name: "orange",
            price: 2,
            quantity: 10
        });
        newState.push({
            name: "watermelon",
            price: 10,
            quantity: 4
        });
        this.setState({items: newState});
    }

    render(){
        return (
            

            <div className="card">
                <div className="card-header">Buy Items</div>
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
                        <button className="btn btn-primary">Purchase</button>
                    </div>
                    
                </div>
            </div>

            
            
        );
    }
}

export default BuyItem;