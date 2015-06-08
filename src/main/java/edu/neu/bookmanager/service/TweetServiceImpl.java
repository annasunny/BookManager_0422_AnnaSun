package edu.neu.bookmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.bookmanager.dao.TweetDAO;
import edu.neu.bookmanager.domain.Tweet;

@Service
public class TweetServiceImpl implements TweetService {
	
	@Autowired
	private TweetDAO tweetDAO;
	
	@Override
	@Transactional
	public void addTweet(Tweet tweet) {
		tweetDAO.addTweet(tweet);
	}

	@Override
	@Transactional
	public List<Tweet> listTweets() {
		return tweetDAO.listTweets();
	}

	@Override
	@Transactional
	public Tweet getTweet(Integer id) {
		return tweetDAO.getTweet(id);
	}

	@Override
	@Transactional
	public void removeTweet(Integer id) {
		tweetDAO.removeTweet(id);
	}
}
