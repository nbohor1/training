package com.bdb;

import java.time.Duration;

import javax.net.ssl.SSLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class WebClientConfig {

	@Value("${app.endpoint.serviceURL}")
	private String serviceURL;
	
	@Bean(name = "RestClientConfig")
	public WebClient getWebClient() throws SSLException
	{
		
		  SslContext sslContext;
		  
		//Registra inicio configuracion webClient
		//logService.generateLogApplication("INICIANDO CONFIGURACION WEBCLIENT","getWebClient", "", getClass());
		  System.out.println("INICIANDO CONFIGURACION WEBCLIENT");
		
			  sslContext = SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.
						 INSTANCE) .build();
		  
		HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext)).responseTimeout(Duration.ofMillis(15000)).compress(true);
		final ClientHttpConnector clientConnector = new ReactorClientHttpConnector(httpClient);
		
		WebClient webClient = WebClient.builder()
				.baseUrl(serviceURL)
				.clientConnector(clientConnector)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT_ENCODING, "gzip,deflate")
				.build();
		
		//Registra fin configuracion webClient
		//logService.generateLogApplication("FINALIZA CONFIGURACION WEBCLIENT","getWebClient", "", getClass());
		System.out.println("FINALIZA CONFIGURACION WEBCLIENT");
		
		return webClient;
	}
}
