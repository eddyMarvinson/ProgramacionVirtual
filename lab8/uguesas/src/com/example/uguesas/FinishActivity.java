package com.example.uguesas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FinishActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finish);
		Bundle param = getIntent().getExtras();
		String ms = param.getString("Pedidos");
		showText(ms);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.finish, menu);
		return true;
	}

	public void back(View v) {
		finish();
	}

	public void showText(String s) {
		TextView t5 = (TextView) findViewById(R.id.textView5);
		TextView t6 = (TextView) findViewById(R.id.textView6);
		TextView t7 = (TextView) findViewById(R.id.textView7);
		TextView t8 = (TextView) findViewById(R.id.textView8);

		String menuFood[] = { "H.Normal", "H. 1/2 Kilo", "H. c/huevo", "H. c/fideitos", "H. Doble", "H. Gemelas",
				"H. MariJuana", "H. c/vegetales", "H. Pollo c/papas" };
		double values[] = { 12, 18, 13.5, 15, 18, 21, 25, 15, 12 };

		double ans = 0.00;
		String a = "Hamburguesa\n";
		String b = "Cantidad\n";
		String c = "Precio\n";

		String arr1[] = s.split(";");
		double total = 0.00;
		for (int i = 0; i < arr1.length; i++) {
			String arr2[] = arr1[i].split(":");
			int x = Integer.parseInt(arr2[0]);
			int y = Integer.parseInt(arr2[1]);

			a += menuFood[x];
			a += "\n";

			b += Integer.toString(y);
			b += "\n";

			c += Double.toString(y * values[x]);
			c += "\n";
			total += y * values[x];
		}
		String d = "Total a pagar: ";
		d += Double.toString(total);
		t5.setText(a);
		t6.setText(b);
		t7.setText(c);
		t8.setText(d);
	}
}
