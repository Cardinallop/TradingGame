import React, { Component } from "react";

class Item extends Component{

    state={
        name: this.props.name,
        price: (Math.round(this.props.price * 100) / 100).toFixed(2),
        quantity: this.props.quantity
    }

    /**
     * This method is called everytime a change is made in the quantity field and calls the parent component to update its fields
     * @param {*} event is the quantity field that is being submitted
     */
    handleChange = (event) => {
        let name = this.state.name;
        let price = this.state.price;

        
        let quantity = parseFloat(event.target.value);

        if(event.target.value.length === 0){ quantity = 0; }
        else if( isNaN(quantity) ){ return; }

        if(quantity > this.state.quantity){ 
            quantity = this.state.quantity;
            event.target.value = this.state.quantity;
        }
        else if(quantity < 0){
            quantity = 0;
            event.target.value = 0;
        }

        let item = {
            name: name,
            price: price,
            quantity: quantity
        }
        this.props.addToCart(item);
    }

    render(){

        return (
            <tr>
                <td style={{padding: "5px"}}>{this.state.name}</td>
                <td style={{padding: "5px"}}>${this.state.price}</td>
                <td style={{padding: "5px"}}>
                    
                    <div className="form-group row d-flex justify-content-center input-group-sm">
                        <input type="number" className="form-control" id="qty" style={{width: "70px", padding: "0px"}} onChange={this.handleChange}  />
                        <span>/{this.state.quantity}</span>
                    </div>
                    
                </td>
            </tr>

        );
    }
}

export default Item;