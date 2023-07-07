import React, { useState } from 'react';

function Login() {
    const [userName, setUserName] = useState('');
    const [userPassword, setUserPassword] = useState('');
    const [loginResult, setLoginResult] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        // 서버에 로그인 요청 보내기
        const response = await fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ userName, userPassword }),
        });

        // 서버의 응답 받기
        const data = await response.json();

        // 응답 처리
        if (response.ok) {
            setLoginResult('Login success');
        } else {
            setLoginResult('Fail');
        }
    };

    return (
        <div className="login-wrapper">
            <h2>Login</h2>
            <form onSubmit={handleSubmit} id="login-form">
                <input
                    type="text"
                    name="userName"
                    placeholder="Email"
                    value={userName}
                    onChange={(event) => setUserName(event.target.value)}
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
