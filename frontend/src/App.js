import React, {Component} from 'react';
import logo from './logo.svg';
import Header from './component/Header.js';
import Main from './component/Main.js';
import './App.css';
import { BrowserRouter} from 'react-router-dom';
class App extends Component {

    state = {};

    componentDidMount() {
        // setInterval(this.hello, 250);
    }

    hello = () => {
        fetch('/api/hello')
            .then(response => response.text())
            .then(message => {
                this.setState({message: message});
            });
    };

    render() {
        return (
          <BrowserRouter>
            <div>
             <Header />
             <Main />
             <div className="App">
                   <header className="App-header">
                       <img src={logo} className="App-logo" alt="logo"/>
                       <h1 className="App-title">{this.state.message}</h1>
                   </header>
                   <p className="App-intro">
                       To get started, edit <code>src/App.js</code> and save to reload.
                   </p>
               </div>
            </div>
          </BrowserRouter>
        );
    }
}
export default App;
