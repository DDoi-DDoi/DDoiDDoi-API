import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './route/Home';
import Login from './route/Login';
import Board from "./route/Board";
import Chat from "./route/Chat";
import UpLoad from "./route/UpLoad";

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/home" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/board" element={<Board />} />
                <Route path="/chat" element={<Chat />} />
                <Route path="/imageUpLoad" element={<UpLoad />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
