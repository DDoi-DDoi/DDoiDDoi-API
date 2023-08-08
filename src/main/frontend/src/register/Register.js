import React, { useState } from 'react';
import './Register.css';
const Register = () => {
    const [formData, setFormData] = useState({
        userName: '',
        password: '',
        name: '',
        emailPrefix: '',
        emailDomain: 'direct',
    });

    const handleChange = (event) => {
        const { name, value } = event.target;
        setFormData((prevFormData) => ({
            ...prevFormData,
            [name]: value,
        }));
    };

    const handleDomainChange = (event) => {
        const { value } = event.target;
        setFormData((prevFormData) => ({
            ...prevFormData,
            emailDomain: value,
        }));
    };

    const handleSubmit = async (event) => {
        event.preventDefault();

        const email = formData.emailDomain === 'direct' ? formData.emailPrefix : `${formData.emailPrefix}@${formData.emailDomain}`;
        console.log('전송하는 데이터:', {
            userName: formData.userName,
            password: formData.password,
            name: formData.name,
            email: email,
        });
        try {
            const response = await fetch('http://localhost:8080/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({
                    userName: formData.userName,
                    password: formData.password,
                    name: formData.name,
                    email: email,
                }),
            });

            if (!response.ok) {
                throw new Error('회원가입 요청이 실패했습니다.');
            }

            const responseData = await response.json();
            console.log('회원가입 성공:', responseData);
            setFormData({
                userName: '',
                password: '',
                name: '',
                emailPrefix: '',
                emailDomain: 'direct',
            });
        } catch (error) {
            console.error('회원가입 오류:', error);
        }
    };

    return (
        <div className="register-container">
            <h2>회원가입</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label htmlFor="userName">아이디</label>
                    <input
                        type="text"
                        id="userName"
                        name="userName"
                        value={formData.userName}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="password">패스워드</label>
                    <input
                        type="password"
                        id="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="name">이름</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={formData.name}
                        onChange={handleChange}
                        required
                    />
                </div>
                <div>
                    <label htmlFor="email">이메일</label>
                    <input
                        type="text"
                        id="emailPrefix"
                        name="emailPrefix"
                        value={formData.emailPrefix}
                        onChange={handleChange}
                        style={{ marginRight: 5 }}
                        required
                    />
                    <span style={{ marginRight: 5 }}>@</span>
                    <select
                        id="emailDomain"
                        name="emailDomain"
                        value={formData.emailDomain}
                        onChange={handleDomainChange}
                        required
                    >
                        <option value="direct">직접입력</option>
                        <option value="naver.com">naver.com</option>
                        <option value="daum.com">daum.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="nate.com">nate.com</option>
                    </select>
                </div>
                <button type="submit">Register</button>
            </form>
        </div>
    );
};

export default Register;
