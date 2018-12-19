import React from 'react'
import { Switch, Route } from 'react-router-dom'
import Test1 from './Test1.js';
import Home from './Home.js';
import Add from './Add.js';
import Login from './Login.js'

// The Main component renders one of the three provided
// Routes (provided that one matches). Both the /roster
// and /schedule routes will match any pathname that starts
// with /roster or /schedule. The / route will only match
// when the pathname is exactly the string "/"
const Main = () => (
  <main>
    <Switch>
      <Route exact path="/" component={Home}/>
      <Route path="/test1" component={Test1} />
      <Route path="/inbox" component={Home} />
      <Route path="/add" component={Add} />
      <Route path="/update/:id" component={Add} />
      <Route path="/login" component={Login} />
    </Switch>
  </main>
)

export default Main
