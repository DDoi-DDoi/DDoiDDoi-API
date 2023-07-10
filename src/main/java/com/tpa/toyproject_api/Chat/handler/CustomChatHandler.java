package com.tpa.toyproject_api.Chat.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class CustomChatHandler extends TextWebSocketHandler {

    private ChatHandler chatHandler;

    @Autowired
    public void setChatHandler(ChatHandler chatHandler) {
        this.chatHandler = chatHandler;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        chatHandler.addSession(session);
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            chatHandler.handleMessage(session, textMessage);
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        chatHandler.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        chatHandler.handleConnectionClosed(session, closeStatus);
    }
}
