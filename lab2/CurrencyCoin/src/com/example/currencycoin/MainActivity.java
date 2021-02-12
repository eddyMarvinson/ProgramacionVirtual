package com.example.currencycoin;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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

	public void init(View v) {
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t2 = (EditText) this.findViewById(R.id.editText2);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		EditText t4 = (EditText) this.findViewById(R.id.editText4);
		EditText t5 = (EditText) this.findViewById(R.id.editText5);
		EditText t6 = (EditText) this.findViewById(R.id.editText6);
		EditText t7 = (EditText) this.findViewById(R.id.editText7);
		EditText t8 = (EditText) this.findViewById(R.id.editText8);

		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t8.setText("");

	}

	public void convert(View v) {
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t2 = (EditText) this.findViewById(R.id.editText2);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		EditText t4 = (EditText) this.findViewById(R.id.editText4);
		EditText t5 = (EditText) this.findViewById(R.id.editText5);
		EditText t6 = (EditText) this.findViewById(R.id.editText6);
		EditText t7 = (EditText) this.findViewById(R.id.editText7);
		EditText t8 = (EditText) this.findViewById(R.id.editText8);

		double value = Float.parseFloat(t1.getText().toString());
		t2.setText(String.format("%.2f", (double) (value / 6.96)));
		t3.setText(String.format("%.2f", (double) (value / 7.52)));
		t4.setText(String.format("%.2f", (double) (value / 2.23)));
		t5.setText(String.format("%.2f", (double) (value / 0.011354)));
		t6.setText(String.format("%.2f", (double) (value / 2.2852)));
		t7.setText(String.format("%.2f", (double) (value / 1.1379)));
		t8.setText(String.format("%.2f", (double) (value / 0.05849034)));
	}
}
