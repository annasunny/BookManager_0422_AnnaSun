package edu.neu.bookmanager.dao;

import java.util.List;

import edu.neu.bookmanager.domain.Tweet;

public interface TweetDAO {
	
	public void addTweet(Tweet tweet);
	public List<Tweet> listTweets();
	public Tweet getTweet(Integer id);
	public void removeTweet(Integer id);
}
