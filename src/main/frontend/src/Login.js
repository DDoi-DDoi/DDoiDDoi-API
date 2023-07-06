import React from 'react';

function Login() {
    const handleSubmit = (event) => {
        event.preventDefault();
        // 로그인 폼 제출 처리 로직 추가
    };

    return (
        <div className="login-wrapper">
            <h2>Login</h2>
            <form onSubmit={handleSubmit} id="login-form">
                <input type="text" name="userName" placeholder="Email" />
                <input type="password" name="userPassword" placeholder="Password" />
                <label htmlFor="remember-check">
                    <input type="checkbox" id="remember-check" />
                    아이디 저장하기
                </label>
                <input type="submit" value="Login" />
            </form>
        </div>
    );
}

export default Login;
