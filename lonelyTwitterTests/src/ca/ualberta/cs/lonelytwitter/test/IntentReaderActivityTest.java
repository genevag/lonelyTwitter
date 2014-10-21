package ca.ualberta.cs.lonelytwitter.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}

	public void testSendText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("test string ", activity.getText());
	}
	
	public void testDoubleText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("test string test string ", activity.getText());
	}
	
	public void testDisplayText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "test string ");
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("test string ", widget.getText());	
	}
	
	public void testDisplayTextDirect() throws Throwable {
		getActivity();
		
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				widget.setText("test string ");
			}
		});
		
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("test string ", widget.getText());
	}
	
	public void testReverseText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, "this is a test");
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.REVERSE);
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertEquals("tset a si siht", activity.getText());
	}
	
	public void testDefaultMessage() throws Throwable{
		Intent intent = new Intent();
		setActivityIntent(intent);
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		assertTrue("this is the default message" !=  activity.getText());
		
		runTestOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				IntentReaderActivity activity = (IntentReaderActivity) getActivity();
				TextView widget = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
				assertEquals("this is the default message", widget.getText());
			}
		});
	}
	
	public void testTextViewVisible() {
		IntentReaderActivity activity = (IntentReaderActivity) getActivity();
		TextView widget = (TextView) activity.getWindow().getDecorView().findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), widget); // ?
	}
	
}
