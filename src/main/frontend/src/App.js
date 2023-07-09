import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Home';
import Login from './Login';

function App() {
    return (
        <div className="App">
            <Home></Home>
        </div>
    );
}

export default App;
