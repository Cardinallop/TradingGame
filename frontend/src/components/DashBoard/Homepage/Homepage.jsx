import React, { Component } from "react";
import 'bootstrap/dist/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';

import BuyItem from "./BuyItem";
import SellItem from "./SellItem";
import LeaderBoard from "./LeaderBoard";

class Homepage extends Component{

    state={
        showBuy: true
    }

    renderBuySell = () => {
        return(this.state.showBuy)? <BuyItem />: <SellItem />
    }

    showBuy = () => {
        this.setState({showBuy: true});
    }

    showSell = () => {
        this.setState({showBuy: false});
    }

    render(){

        let buysell = this.renderBuySell();
        return(
            <div className="container" style={{paddingTop: "50px"}}>
                <div className="row">

                    <div className="col-md-6">
                        <div className="d-flex justify-content-center">
                            <button 
                                className={"btn " + (this.state.showBuy? "btn-dark": "btn-light") + " choiceBtn"}
                                onClick={this.showBuy}
                                >Buy</button>
                            <button 
                                className={"btn " + (this.state.showBuy? "btn-light": "btn-dark") + " choiceBtn"}
                                onClick={this.showSell}
                                >Sell</button>
                        </div>
                        {buysell}
                    </div>

                    <div className="col-md-1"></div>

                    <div className="col-md-5">
                        <LeaderBoard />
                    </div>
                </div>
            </div>
        );
    }

}

export default Homepage;