package edu.neu.bookmanager.service;

import java.util.List;

import edu.neu.bookmanager.domain.Tweet;

public interface TweetService {
	
	public void addTweet(Tweet tweet);
	public List<Tweet> listTweets();
	public Tweet getTweet(Integer id);
	public void removeTweet(Integer id);
}
