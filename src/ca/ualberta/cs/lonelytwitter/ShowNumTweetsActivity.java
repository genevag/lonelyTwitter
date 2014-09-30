package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ShowNumTweetsActivity extends LonelyTwitterActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView view = (TextView) findViewById(R.id.numOfTweets);
		String str = Integer.toString(super.tweets.size());
		//view.setText(Integer.toString(super.tweets.size()));
		setContentView(R.layout.activity_show_num_tweets);
		
	}

}
