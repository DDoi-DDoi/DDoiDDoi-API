import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './Home';
import Login from './login/Login';
import Board from "./Board";
import Chat from "./chat/Chat";
import Register from "./register/Register";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/home" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/board" element={<Board />} />
                <Route path="/chat" element={<Chat />} />
                <Route path="/register" element={<Register />}/>
            </Routes>
        </BrowserRouter>
    );
}

export default App;
