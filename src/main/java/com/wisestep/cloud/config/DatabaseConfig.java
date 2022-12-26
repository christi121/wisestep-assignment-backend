/**
 * @Project wisestep-assignment-service
 * @Package com.wisestep.cloud.config
 * @File DatabaseConfig.java
 */
package com.wisestep.cloud.config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;

/**
 * @Author Aniket Lahiri
 *
 */
@EnableElasticsearchRepositories(basePackages = "com.wisestep.cloud.repository")
@Configuration
public class DatabaseConfig {

	@Autowired
	ElasticSearchDBConnectionProperties properties;
	
	@Bean
	public ElasticsearchClient getESClient() throws IOException {
		SSLContext sslContext = TransportUtils
		    .sslContextFromCaFingerprint(properties.getFingerprint());

		BasicCredentialsProvider credsProv = new BasicCredentialsProvider(); 
		credsProv.setCredentials(
		    AuthScope.ANY, new UsernamePasswordCredentials(properties.getUsername(), properties.getPassword())
		);

		RestClient restClient = RestClient
		    .builder(new HttpHost(properties.getHost(), Integer.parseInt(properties.getPort()), "https")) 
		    .setHttpClientConfigCallback(hc -> hc
		        .setSSLContext(sslContext) 
		        .setDefaultCredentialsProvider(credsProv).setConnectionTimeToLive(2, TimeUnit.SECONDS)
		    )
		    .build();

		ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
		ElasticsearchClient client = new ElasticsearchClient(transport);
		return client;
	}

}
