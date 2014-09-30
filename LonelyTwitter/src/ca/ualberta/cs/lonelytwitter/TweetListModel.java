package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TweetListModel {

	private ArrayList<LonelyTweetModel> tweets;
		
	public TweetListModel() {
		super();
		this.tweets = new ArrayList<LonelyTweetModel>();
	}

	public void add(LonelyTweetModel t) {
		if (tweets.contains(t)) {
			throw new IllegalArgumentException("Duplicate tweet");
		}
		tweets.add(t);
	}

	public boolean hasTweet(LonelyTweetModel t) {
		for (LonelyTweetModel tweet : tweets) {
			if (tweet == t) {
				return true;
			}
		}
		return false;
	}

	public int getCount() {
		return tweets.size();
	}

	public ArrayList<LonelyTweetModel> getTweets() {
		Comparator<LonelyTweetModel> comparator = new Comparator<LonelyTweetModel>() {
			
			public int compare(LonelyTweetModel lhs, LonelyTweetModel rhs) {
				return lhs.getTimestamp().compareTo(rhs.getTimestamp());
			}
		};
		Collections.sort(tweets, comparator);
		
		return tweets;
	}

	public void remove(LonelyTweetModel t) {
		tweets.remove(t);
	}

	
}
