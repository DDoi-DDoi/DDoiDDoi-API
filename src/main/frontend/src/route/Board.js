import React from 'react';
import '../css/Board.css';
function Board() {
    const boardList = [
        { id: 1, author: 'John Doe', title: 'Lorem Ipsum', views: 10, date: '2023-07-01' },
        { id: 2, author: 'Jane Smith', title: 'Dolor Sit Amet', views: 5, date: '2023-07-02' },
        { id: 3, author: 'Alice Johnson', title: 'Consectetur Adipiscing', views: 8, date: '2023-07-03' },
    ];

    return (
        <div className="board-wrapper">
            <h2>게시판</h2>
            <table>
                <thead>
                <tr>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성 날짜</th>
                </tr>
                </thead>
                <tbody>
                {boardList.map((board) => (
                    <tr key={board.id}>
                        <td>{board.author}</td>
                        <td>{board.title}</td>
                        <td>{board.views}</td>
                        <td>{board.date}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
}

export default Board;
