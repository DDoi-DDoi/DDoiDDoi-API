import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';

function Login() {
    const [userId, setUserId] = useState('');
    const [userPassword, setUserPassword] = useState('');
    const [userName, setUserName] = useState('');
    const [loginResult, setLoginResult] = useState('');
    const navigate = useNavigate(); // useNavigate 훅 사용

    const handleSubmit = async (event) => {
        event.preventDefault();

        // 서버에 로그인 요청 보내기
        const response = await fetch('http://localhost:8080/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ userId, userPassword }),
            mode: 'cors',
        });

        // 서버의 응답 받기
        if (response.ok) {
            const data = await response.json();
            if (data.status === 'success') {
                setUserName(data.userName);
                setLoginResult(`로그인 성공, userName : ${data.userName}`);
                //navigate('/home'); // 로그인 성공 시 Home 페이지로 이동
            } else {
                setUserName('');
                setLoginResult('로그인 실패.');
            }
        } else {
            setUserName('');
            setLoginResult('로그인 실패.');
        }
    };

    return (
        <div className="login-wrapper">
            <h2>로그인</h2>
            <form onSubmit={handleSubmit} id="login-form">
                <input
                    type="text"
                    name="userId"
                    placeholder="User ID"
                    value={userId}
                    onChange={(event) => setUserId(event.target.value)}
                />
                <input
                    type="password"
                    name="userPassword"
                    placeholder="Password"
                    value={userPassword}
                    onChange={(event) => setUserPassword(event.target.value)}
                />
                <label htmlFor="remember-check">
                    <input type="checkbox" id="remember-check" />
                    아이디 저장하기
                </label>
                <input type="submit" value="Login" />
            </form>
            <p>{loginResult}</p>
        </div>
    );
}

export default Login;
