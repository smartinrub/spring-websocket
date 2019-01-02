package org.smartinrubio.springwebsocket.config;

import org.smartinrubio.springwebsocket.websocket.WebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@ComponentScan("org.smartinrubio.springwebsocket.websocket")
public class WebSocketConfig implements WebSocketConfigurer {


    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {

        webSocketHandlerRegistry.addHandler(socketHandler(), "/socketHandler");
    }

    @Bean
    public org.springframework.web.socket.WebSocketHandler socketHandler() {
        return new WebSocketHandler();
    }

}
