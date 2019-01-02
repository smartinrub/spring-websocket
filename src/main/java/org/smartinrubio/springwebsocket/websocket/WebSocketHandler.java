package org.smartinrubio.springwebsocket.websocket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.logging.Logger;

public class WebSocketHandler extends AbstractWebSocketHandler {

    private static final Logger LOGGER = Logger.getLogger(WebSocketHandler.class.getName());

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOGGER.info("Receive message: " + message.getPayload());

        Thread.sleep(2000);

        session.sendMessage(new TextMessage("World!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        LOGGER.info("Connection established");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        LOGGER.info("Connection closed. Status: " + status);
    }
}
