package com.example.cachogame;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

	int diceImages[] = { R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
			R.drawable.six };
	int randNumbers[] = new int[5];

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		Button butt2 = (Button) this.findViewById(R.id.button2);
		ImageView img1 = (ImageView) this.findViewById(R.id.imageView1);
		ImageView img2 = (ImageView) this.findViewById(R.id.imageView2);
		ImageView img3 = (ImageView) this.findViewById(R.id.imageView3);
		ImageView img4 = (ImageView) this.findViewById(R.id.imageView4);
		ImageView img5 = (ImageView) this.findViewById(R.id.imageView5);
		img1.setClickable(false);
		img2.setClickable(false);
		img3.setClickable(false);
		img4.setClickable(false);
		img5.setClickable(false);
		butt2.setEnabled(false);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void throwDice(View v) {
		Button butt1 = (Button) this.findViewById(R.id.button1);
		Button butt2 = (Button) this.findViewById(R.id.button2);
		EditText edit1 = (EditText) this.findViewById(R.id.editText1);
		ImageView img1 = (ImageView) this.findViewById(R.id.imageView1);
		ImageView img2 = (ImageView) this.findViewById(R.id.imageView2);
		ImageView img3 = (ImageView) this.findViewById(R.id.imageView3);
		ImageView img4 = (ImageView) this.findViewById(R.id.imageView4);
		ImageView img5 = (ImageView) this.findViewById(R.id.imageView5);

		for (int i = 0; i < randNumbers.length; i++) {
			randNumbers[i] = (int) (Math.random() * 6);
		}

		edit1.setText("SI");
		img1.setImageResource(diceImages[randNumbers[0]]);
		img2.setImageResource(diceImages[randNumbers[1]]);
		img3.setImageResource(diceImages[randNumbers[2]]);
		img4.setImageResource(diceImages[randNumbers[3]]);
		img5.setImageResource(diceImages[randNumbers[4]]);

		calculate();

		butt1.setEnabled(false);
		butt2.setEnabled(true);
		img1.setClickable(true);
		img2.setClickable(true);
		img3.setClickable(true);
		img4.setClickable(true);
		img5.setClickable(true);
	}

	public void calculate() {
		EditText edit2 = (EditText) this.findViewById(R.id.editText2);
		EditText edit3 = (EditText) this.findViewById(R.id.editText3);
		EditText edit4 = (EditText) this.findViewById(R.id.editText4);
		EditText edit5 = (EditText) this.findViewById(R.id.editText5);

		int cnt[] = {0, 0, 0, 0, 0, 0};
		for (int i = 0; i < randNumbers.length; i++) {
			cnt[randNumbers[i]]++;
		}
		Arrays.sort(cnt);

		int esc[] = { 0, 1, 1, 1, 1, 1 };
		int full[] = { 0, 0, 0, 0, 2, 3 };
		int poker[] = { 0, 0, 0, 0, 1, 4 };
		int dor[] = { 0, 0, 0, 0, 0, 5 };

		if (Arrays.equals(esc, cnt))
			edit2.setText("SI");
		else
			edit2.setText("NO");

		if (Arrays.equals(full, cnt))
			edit3.setText("SI");
		else
			edit3.setText("NO");

		if (Arrays.equals(poker, cnt))
			edit4.setText("SI");
		else
			edit4.setText("NO");

		if (Arrays.equals(dor, cnt))
			edit5.setText("SI");
		else
			edit5.setText("NO");
	}

	public void changeDice(View v) {
		ImageView img1 = (ImageView) this.findViewById(R.id.imageView1);
		ImageView img2 = (ImageView) this.findViewById(R.id.imageView2);
		ImageView img3 = (ImageView) this.findViewById(R.id.imageView3);
		ImageView img4 = (ImageView) this.findViewById(R.id.imageView4);
		ImageView img5 = (ImageView) this.findViewById(R.id.imageView5);
		EditText edit1 = (EditText) this.findViewById(R.id.editText1);
		switch (v.getId()) {
		case R.id.imageView1:
			img1 = (ImageView) this.findViewById(R.id.imageView1);
			randNumbers[0] = changeValue(randNumbers[0]);
			img1.setImageResource(diceImages[randNumbers[0]]);
			break;
		case R.id.imageView2:
			img2 = (ImageView) this.findViewById(R.id.imageView2);
			randNumbers[1] = changeValue(randNumbers[1]);
			img2.setImageResource(diceImages[randNumbers[1]]);
			break;
		case R.id.imageView3:
			img3 = (ImageView) this.findViewById(R.id.imageView3);
			randNumbers[2] = changeValue(randNumbers[2]);
			img3.setImageResource(diceImages[randNumbers[2]]);
			break;
		case R.id.imageView4:
			img4 = (ImageView) this.findViewById(R.id.imageView4);
			randNumbers[3] = changeValue(randNumbers[3]);
			img4.setImageResource(diceImages[randNumbers[3]]);
			break;
		case R.id.imageView5:
			img5 = (ImageView) this.findViewById(R.id.imageView5);
			randNumbers[4] = changeValue(randNumbers[4]);
			img5.setImageResource(diceImages[randNumbers[4]]);
			break;
		default:
			break;
		}

		calculate();
		edit1.setText("NO");
		img1.setClickable(false);
		img2.setClickable(false);
		img3.setClickable(false);
		img4.setClickable(false);
		img5.setClickable(false);
	}

	public int changeValue(int x) {
		switch (x) {
		case 0:
			return 5;
		case 1:
			return 4;
		case 2:
			return 3;
		case 3:
			return 2;
		case 4:
			return 1;
		case 5:
			return 0;
		}
		return -1;
	}

	public void reset(View v) {
		Button butt1 = (Button) this.findViewById(R.id.button1);
		Button butt2 = (Button) this.findViewById(R.id.button2);
		EditText edit1 = (EditText) this.findViewById(R.id.editText1);
		EditText edit2 = (EditText) this.findViewById(R.id.editText2);
		EditText edit3 = (EditText) this.findViewById(R.id.editText3);
		EditText edit4 = (EditText) this.findViewById(R.id.editText4);
		EditText edit5 = (EditText) this.findViewById(R.id.editText5);
		ImageView img1 = (ImageView) this.findViewById(R.id.imageView1);
		ImageView img2 = (ImageView) this.findViewById(R.id.imageView2);
		ImageView img3 = (ImageView) this.findViewById(R.id.imageView3);
		ImageView img4 = (ImageView) this.findViewById(R.id.imageView4);
		ImageView img5 = (ImageView) this.findViewById(R.id.imageView5);

		edit1.setText("");
		edit2.setText("");
		edit3.setText("");
		edit4.setText("");
		edit5.setText("");
		img1.setImageResource(R.drawable.zero);
		img2.setImageResource(R.drawable.zero);
		img3.setImageResource(R.drawable.zero);
		img4.setImageResource(R.drawable.zero);
		img5.setImageResource(R.drawable.zero);
		img1.setClickable(false);
		img2.setClickable(false);
		img3.setClickable(false);
		img4.setClickable(false);
		img5.setClickable(false);
		butt1.setEnabled(true);
		butt2.setEnabled(false);
	}
}
