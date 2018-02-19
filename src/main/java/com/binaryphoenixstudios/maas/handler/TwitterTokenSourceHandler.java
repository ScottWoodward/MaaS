package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.config.TwitterConfiguration;
import com.binaryphoenixstudios.maas.dto.TokenDTO;
import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterTokenSourceHandler extends AbstractTokenSourceHandler implements TokenSourceHandler
{
	@Autowired protected TwitterConfiguration twitterConfiguration;
	
	@Override
	public List<TokenDTO> getTokens(String source, int numberOfPreviousDependantTokens)
	{
		List<TokenDTO> tokens = new ArrayList<>();
		//Get the JSON from Wikipedia's API and pull out the body HTML from the JSON.
		
		Twitter twitter = getTwitter();
		try
		{
			List<Status> tweets = twitter.getUserTimeline(source);
			for (Status tweet : tweets)
			{
				List<Sentence> sentences = new ArrayList<>();
				
				sentences.addAll(new Document(tweet.getText()).sentences());
				
				for (Sentence sentence : sentences)
				{
					tokens.addAll(convertStringsToTokens(sentence.words(), numberOfPreviousDependantTokens));
					
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return tokens;
	}
	
	protected Twitter getTwitter()
	{
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey(twitterConfiguration.getConsumerKey())
				.setOAuthConsumerSecret(twitterConfiguration.getConsumerSecret())
				.setOAuthAccessToken(twitterConfiguration.getAccessToken())
				.setOAuthAccessTokenSecret(twitterConfiguration.getAccessTokenSecret());
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
	}
}
