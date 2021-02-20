package com.example.uguesas;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	int arrBuys[];
	int p;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		arrBuys = new int[9];
		Arrays.fill(arrBuys, 0);
		p = 0;
		Button butt3 = (Button) this.findViewById(R.id.button3);
		butt3.setEnabled(false);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void update(View v){
		ImageView img1 = (ImageView) this.findViewById(R.id.imageView1);
		EditText edit1 = (EditText) this.findViewById(R.id.editText1);
		EditText edit2 = (EditText) this.findViewById(R.id.editText2);
		Button butt3 = (Button) this.findViewById(R.id.button3);
		TextView text1 = (TextView) this.findViewById(R.id.textView1);

		switch (v.getId()) {
			case R.id.button1:
			p = (p == 0 ? 8 : p - 1);
			break;

			case R.id.button2:
			arrBuys[p]++;
			break;

			case R.id.button3:
			arrBuys[p]--;
			break;

			case R.id.button4:
			p = (p + 1) % 9;
			break;

			case R.id.button6:
			arrBuys = new int[9];
			Arrays.fill(arrBuys, 0);
			p = 0;
			break;

		}
		
		int imgFood[] = {R.drawable.hnormal, R.drawable.hmediokilo, R.drawable.hconhuevo, R.drawable.hconfideitos, R.drawable.hdoble, R.drawable.hgemelas, R.drawable.hmariajuana, R.drawable.hvegetal, R.drawable.hpollo};
		String menuFood[] = { "H. Normal 12 Bs.", "H. 1/2 Kilo 18 Bs.", "H. c/huevo 13.5 Bs", "H. c/fideitos 15 Bs.", "H. Doble 18 Bs.", "H. Gemelas 21 Bs.",
				"H. MariJuana 25 Bs.", "H. c/vegetales 15 Bs.", "H. Pollo c/papas 12 Bs." };

		text1.setText(menuFood[p]);
		edit1.setText(arrBuys[p] + "");
		img1.setImageResource(imgFood[p]);

		if (arrBuys[p] > 0) 
			butt3.setEnabled(true);
		else
			butt3.setEnabled(false);
		
		double values[] = {12, 18, 13.5, 15, 18, 21, 25, 15, 12};
		double ans = 0.00;
		for (int i = 0; i < values.length; ++i) {
			ans += (values[i] * arrBuys[i]);			
		}
		edit2.setText(ans + "");
	}


	public void finish(View v) {
		String message = "";
		for (int i = 0; i < arrBuys.length; i++) {
			if(arrBuys[i] != 0) {
				message += Integer.toString(i);
				message += ":";
				message += Integer.toString(arrBuys[i]);
				message += ";";
			}
		}
		Intent pFinish = new Intent(this, FinishActivity.class);
		pFinish.putExtra("Pedidos", message);
		startActivity(pFinish);
	}
}
