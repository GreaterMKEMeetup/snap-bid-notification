package org.gmjm.snapbid.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Profile("cloud")
@Configuration
@EnableWebSocketMessageBroker
public class CloudWebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{

	@Value("${cloud.services.rabbitmq.connection.host}")
	String relayHost;

	@Value("${cloud.services.snap-bid-relay.connection.virtualhost}")
	String virtualHost;

	@Value("${cloud.services.snap-bid-relay.connection.username}")
	String login;

	@Value("${cloud.services.snap-bid-relay.connection.password}")
	String passcode;

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/")
			.setAllowedOrigins("https://snap-bid-web.cfapps.io/websockets")
			.withSockJS()
			.setClientLibraryUrl("//cdn.jsdelivr.net/sockjs/1/sockjs.min.js");
	}




	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableStompBrokerRelay("/topic", "/queue")
			.setRelayHost(relayHost)
			.setVirtualHost(virtualHost)
			.setSystemLogin(login)
			.setClientLogin(login)
			.setClientPasscode(passcode)
			.setSystemPasscode(passcode);


	}
}
