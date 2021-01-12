import React, { Component } from "react";
import logo from './logo.svg';
import './App.css';
import NavBar from "./components/nav_bar"
import AboutPage from './pages/about_page'
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
} from "react-router-dom";
import LoginPage from "./components/Login/LoginPage";
import SignupPage from "./components/Login/SignupPage";
import DashBoard from "./components/DashBoard/DashBoard";
import ProfileInfo from "./components/DashBoard/Profile/ProfileInfo";

function App() {
  return (
    <Router>
      <div className="App">
        <NavBar/>
        <main>
          <Switch>
             <Route path='/about' component={AboutPage} />
          </Switch>
        </main>
        <Route exact path="/" component={LoginPage} />
        <Route exact path="/login" component={LoginPage} />
        <Route exact path="/signup" component={SignupPage} />
        <Route exact path="/dashboard" component={DashBoard} />
        <Route exact path="/profile" component={ProfileInfo} />
      </div>
    </Router>
  );
}

export default App;
