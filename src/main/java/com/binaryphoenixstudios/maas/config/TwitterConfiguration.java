package com.binaryphoenixstudios.maas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Configuration class that loads properties from a classpath properties file for Twitter access.
 *
 * @author Scott Woodward
 * @since 1.0
 */
@Component
@ConfigurationProperties
@PropertySource("classpath:twitter.properties")
public class TwitterConfiguration
{
	@Value("${oauth.consumerKey}")
	protected String consumerKey;
	
	@Value("${oauth.consumerSecret}")
	protected String consumerSecret;
	
	@Value("${oauth.accessToken}")
	protected String accessToken;
	
	@Value("${oauth.accessTokenSecret}")
	protected String accessTokenSecret;
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Getters & Setters
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getConsumerKey()
	{
		return consumerKey;
	}
	
	public void setConsumerKey(String consumerKey)
	{
		this.consumerKey = consumerKey;
	}
	
	public String getConsumerSecret()
	{
		return consumerSecret;
	}
	
	public void setConsumerSecret(String consumerSecret)
	{
		this.consumerSecret = consumerSecret;
	}
	
	public String getAccessToken()
	{
		return accessToken;
	}
	
	public void setAccessToken(String accessToken)
	{
		this.accessToken = accessToken;
	}
	
	public String getAccessTokenSecret()
	{
		return accessTokenSecret;
	}
	
	public void setAccessTokenSecret(String accessTokenSecret)
	{
		this.accessTokenSecret = accessTokenSecret;
	}
}
