package org.gmjm.snapbid.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Profile("local")
@Configuration
@EnableWebSocketMessageBroker
public class LocalWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{


	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/")
			.setAllowedOrigins("http://localhost:8080/websockets")
			.withSockJS()
			.setClientLibraryUrl("//cdn.jsdelivr.net/sockjs/1/sockjs.min.js");
	}




	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic", "/queue");
	}
}
