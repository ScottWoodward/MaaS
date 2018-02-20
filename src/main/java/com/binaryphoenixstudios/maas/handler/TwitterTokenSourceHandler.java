package com.binaryphoenixstudios.maas.handler;

import com.binaryphoenixstudios.maas.config.TwitterConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class TwitterTokenSourceHandler extends AbstractTokenSourceHandler implements TokenSourceHandler
{
	@Autowired
	protected TwitterConfiguration twitterConfiguration;

	@Override
	protected List<String> getStringsFromSource(String source)
	{
		List<String> strings = new ArrayList<>();

		Twitter twitter = getTwitter();

		try
		{
			for (int i = 0; i < 5; i++)
			{
				List<Status> tweets = twitter.getUserTimeline(source, new Paging(i + 1, 200));
				for (Status tweet : tweets)
				{
					if (!tweet.isRetweet() && !tweet.isTruncated())
					{
						strings.add(tweet.getText());
					}
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return strings;
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
