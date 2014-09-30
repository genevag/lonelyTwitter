package ca.ualberta.cs.lonelytwitter.test;

import java.util.ArrayList;
import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;

public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public TweetListModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	public void testFiveIsFive() {
		assertEquals(5, 5);
	}
	
	public void testTweetListModel() {
		TweetListModel tlm = new TweetListModel();
	}
	
	public void testAdd() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		assertTrue(tlm.hasTweet(t));
	}
	
	public void testAddTweet() {
		Date date = new Date();
		LonelyTweetModel t = new LonelyTweetModel("Hello", date);
		TweetListModel tlm = new TweetListModel();
		
		tlm.add(t);
		
		Boolean error = false;
		try {
			tlm.add(t);
		} catch (IllegalArgumentException e) {
			error = true;
		}
		assertTrue(error);
		
		LonelyTweetModel t2 = new LonelyTweetModel("Hello", date);
		error = false;
		try {
			tlm.add(t2);
		} catch (IllegalArgumentException e) {
			error = true;
		}
		assertTrue(error);

	}
	
	public void testGetTweets() {
		Date date = new Date();
		LonelyTweetModel t = new LonelyTweetModel("Hello", date);
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		
		ArrayList<LonelyTweetModel> tweetList = new ArrayList<LonelyTweetModel>();
		tweetList.add(t);
		assertEquals(tweetList, tlm.getTweets());
		
		Date date2 = new Date();
		date2.setTime(date.getTime() - 12345);
		LonelyTweetModel t2 = new LonelyTweetModel("World", date2);
		tlm.add(t2);
		
		tweetList.add(0,t2);
		assertEquals(tweetList, tlm.getTweets());
		
		Date date3 = new Date();
		date3.setTime(date.getTime() - 500);
		LonelyTweetModel t3 = new LonelyTweetModel("!", date3);
		tlm.add(t3);
		
		tweetList.add(1,t3);
		assertEquals(tweetList,tlm.getTweets());
	}
	
	public void testHasTweet() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
	
		LonelyTweetModel t2 = new LonelyTweetModel("Hello");
		assertEquals(t, t2);
		assertNotSame(t, t2);
		
		assertTrue(tlm.hasTweet(t));
		assertFalse(tlm.hasTweet(t2));
	}
	
	public void testRemove() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		
		tlm.remove(t);
		assertFalse(tlm.hasTweet(t));
	}
	
	public void testGetCount() {
		LonelyTweetModel t = new LonelyTweetModel("Hello");
		TweetListModel tlm = new TweetListModel();
		tlm.add(t);
		assertEquals("Count not corect", 1, tlm.getCount());
	}
}
