import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Home';
import Login from './Login';
import Board from "./Board";
import Chat from "./Chat";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/home" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/board" element={<Board />} />
                <Route path="/chat" element={<Chat />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
