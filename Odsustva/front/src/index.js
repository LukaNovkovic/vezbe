import React from "react";
import ReactDOM from "react-dom";
import { Route, Link, HashRouter as Router, Switch, Redirect } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import Home from "./components/Home";

import Radnici from './components/dostava/Radnici';
import EditRadnik from './components/dostava/Edit';
import Odsustvo from './components/dostava/Odsustvo';

import Login from './components/authorization/Login';
import NotFound from "./components/NotFound";
import {logout} from './services/auth';

class App extends React.Component {
  render() {

    const jwt = window.localStorage['jwt'];

    if(jwt){return (
      <div>
        <Router>
          <Navbar expand bg="dark" variant="dark">
            <Navbar.Brand as={Link} to="/">
                Home
            </Navbar.Brand>
            <Nav>
              
              <Nav.Link as={Link} to="/radnici">
                Radnici
              </Nav.Link>
                <Button onClick={()=>logout()}>Logout</Button>
            </Nav>
          </Navbar>
          <Container style={{paddingTop:"25px"}}>
            <Switch>
              <Route exact path="/" component={Home} />
              <Route exact path="/login"  render={()=><Redirect to="/radnici"/>}/>
          
              <Route exact path="/radnici" component={Radnici} />
              <Route exact path="/radnici/edit/:id" component={EditRadnik} />
              <Route exact path="/radnici/odsustvo/:id" component={Odsustvo} />

              <Route component={NotFound} />
            </Switch>
          </Container>
        </Router>
      </div>
    );
  }else{
    return( <Container>
      <Router>
        <Switch>
          <Route exact path="/login" component={Login}/>
          <Route render={()=> <Redirect to = "/login"/>}/>
        </Switch>
      </Router>
    </Container>);
   
  }
      
  }
}

ReactDOM.render(<App />, document.querySelector("#root"));
