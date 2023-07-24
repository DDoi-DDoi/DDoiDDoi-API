import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import './Login.css';

function Login() {
    const [userId, setUserId] = useState('');
    const [userPassword, setUserPassword] = useState('');
    const [userName, setUserName] = useState('');
    const [loginResult, setLoginResult] = useState('');
    const navigate = useNavigate(); // useNavigate 훅 사용

    useEffect(() => {
        // 로그인 정보를 로컬 스토리지에서 가져와서 userName 상태를 설정합니다.
        const storedUserId = localStorage.getItem('userId');
        const storedUserPassword = localStorage.getItem('userPassword');

        if (storedUserId && storedUserPassword) {
            setUserId(storedUserId);
            setUserPassword(storedUserPassword);
        }
    }, []);

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
            console.log('Login Response:', data);
            if (data.status === 'success') {
                setUserName(data.userName);
                setLoginResult(`로그인 성공, userName : ${data.userName}`);

                // 로그인 정보를 로컬 스토리지에 저장
                localStorage.setItem('userId', userId);
                localStorage.setItem('userPassword', userPassword);

                navigate('/home'); // 로그인 성공 시 Home 페이지로 이동
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
            {userName ? (
                <p>{`${userName} 님 안녕하세요.`}</p>
            ) : (
                <form onSubmit={handleSubmit} id="login-form">
                    <input
                        type="text"
                        name="userId"
                        placeholder="사용자 아이디"
                        value={userId}
                        onChange={(event) => setUserId(event.target.value)}
                    />
                    <input
                        type="password"
                        name="userPassword"
                        placeholder="비밀번호"
                        value={userPassword}
                        onChange={(event) => setUserPassword(event.target.value)}
                    />
                    <label htmlFor="remember-check">
                        <input type="checkbox" id="remember-check" />
                        아이디 저장하기
                    </label>
                    <input type="submit" value="로그인" />
                </form>
            )}
            <p>{loginResult}</p>
        </div>
    );
}

export default Login;
