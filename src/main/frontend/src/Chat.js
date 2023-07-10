import React, { useState, useEffect } from 'react';
import './Chat.css';

const Chat = () => {
    const [messages, setMessages] = useState([]);
    const [inputValue, setInputValue] = useState('');
    const [socket, setSocket] = useState(null);

    useEffect(() => {
        // WebSocket 연결 설정
        const ws = new WebSocket('wss://port-0-ddoiddoi-api-7xwyjq992llj5bmtue.sel4.cloudtype.app/chat');

        ws.onopen = () => {
            console.log('WebSocket 연결이 열렸습니다.');
        };

        ws.onmessage = (event) => {
            const receivedMessage = event.data;
            console.log('Received message:', receivedMessage);

            setMessages((prevMessages) => [...prevMessages, receivedMessage]);
        };

        ws.onclose = () => {
            console.log('WebSocket 연결이 닫혔습니다.');
        };

        setSocket(ws);

        return () => {
            ws.close();
        };
    }, []);

    const sendMessage = () => {
        if (inputValue) {
            socket.send(inputValue);
            setInputValue('');
        }
    };

    const handleInputChange = (event) => {
        setInputValue(event.target.value);
    };

    return (
        <div className="chat-container">
            <div className="chat-header">
                <h1>Chat</h1>
            </div>
            <div className="chat-messages">
                {messages.map((message, index) => (
                    <div key={index} className="chat-message">
                        {message}
                    </div>
                ))}
            </div>
            <div className="chat-input">
                <input type="text" value={inputValue} onChange={handleInputChange} />
                <button onClick={sendMessage}>Send</button>
            </div>
        </div>
    );
};

export default Chat;
