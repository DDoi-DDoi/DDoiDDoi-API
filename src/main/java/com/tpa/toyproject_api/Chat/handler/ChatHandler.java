package com.tpa.toyproject_api.Chat.handler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ChatHandler {

    private Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    public void handleMessage(WebSocketSession session, TextMessage message) throws Exception {
        String receivedMessage = message.getPayload();
        System.out.println("Received message: " + receivedMessage);

        // 새로운 메시지를 저장
        // 저장된 메시지를 모든 클라이언트에게 브로드캐스트
        broadcastMessage(receivedMessage);
    }

    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        // WebSocket 전송 오류 처리
        System.out.println("WebSocket transport error: " + exception.getMessage());
    }

    public void handleConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        // WebSocket 연결 종료 처리
        // 클라이언트 세션 제거
        sessions.remove(session.getId());
    }

    private void broadcastMessage(String message) throws Exception {
        TextMessage textMessage = new TextMessage(message);
        Set<String> sessionIds = sessions.keySet();

        for (String sessionId : sessionIds) {
            WebSocketSession session = sessions.get(sessionId);
            if (session.isOpen()) {
                try {
                    session.sendMessage(textMessage);
                } catch (IOException e) {
                    System.out.println("Failed to send message to session " + sessionId + ": " + e.getMessage());
                }
            }
        }
    }

    public void addSession(WebSocketSession session) {
        sessions.put(session.getId(), session);
    }
}