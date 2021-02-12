package com.example.whatever;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	//TextView text1;
	//TextView text2;
	//TextView text3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//text1 = (TextView) this.findViewById(R.id.textView1);
		//text2 = (TextView) this.findViewById(R.id.textView2);
		//text3 = (TextView) this.findViewById(R.id.textView3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void changeRed(View v) {
		TextView text1 = (TextView) this.findViewById(R.id.textView1);
		TextView text2 = (TextView) this.findViewById(R.id.textView2);
		TextView text3 = (TextView) this.findViewById(R.id.textView3);
		text1.setTextColor(Color.RED);
		text2.setTextColor(Color.YELLOW);
		text3.setTextColor(Color.GREEN);
	}

	public void changeYellow(View v) {
		TextView text1 = (TextView) this.findViewById(R.id.textView1);
		TextView text2 = (TextView) this.findViewById(R.id.textView2);
		TextView text3 = (TextView) this.findViewById(R.id.textView3);
		text1.setTextColor(Color.YELLOW);
		text2.setTextColor(Color.GREEN);
		text3.setTextColor(Color.RED);
	}

	public void changeGreen(View v) {
		TextView text1 = (TextView) this.findViewById(R.id.textView1);
		TextView text2 = (TextView) this.findViewById(R.id.textView2);
		TextView text3 = (TextView) this.findViewById(R.id.textView3);
		text1.setTextColor(Color.GREEN);
		text2.setTextColor(Color.RED);
		text3.setTextColor(Color.YELLOW);
	}
}
