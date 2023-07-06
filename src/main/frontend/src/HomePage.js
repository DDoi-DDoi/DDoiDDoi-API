import React from 'react';

class HomePage extends React.Component {
    handleLoginClick = () => {
        // 로그인 버튼 클릭 시 동작하는 함수
        // TODO: 로그인 처리 로직 작성
    };

    handleSignupClick = () => {
        // 회원 가입 버튼 클릭 시 동작하는 함수
        // TODO: 회원 가입 처리 로직 작성
    };

    render() {
        return (
            <div>
                <div style={{ textAlign: 'right' }}>
                    <button onClick={this.handleLoginClick}>로그인</button>
                    <button onClick={this.handleSignupClick}>회원 가입</button>
                </div>
                <div style={{ textAlign: 'center' }}>
                    <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
                        <h1 style={{ margin: '0 auto' }}>게시판</h1>
                        <div>
                            <a href="/board">더보기</a>
                        </div>
                    </div>
                </div>
                <div style={{ textAlign: 'center' }}>
                    <a href="/ranking">랭킹</a>
                </div>
                <div>
                    {/* 실시간 채팅 공간 */}
                    {/* TODO: 실시간 채팅 컴포넌트 추가 */}
                </div>
            </div>
        );
    }
}

export default HomePage;
