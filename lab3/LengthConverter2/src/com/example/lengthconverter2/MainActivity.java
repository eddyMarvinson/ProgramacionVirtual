package com.example.lengthconverter2;

import java.math.BigDecimal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void changeValue(View v) {
		PopupMenu p = new PopupMenu(this, v);
		p.setOnMenuItemClickListener(this);
		p.inflate(R.menu.popup_one);
		p.show();
	}

	public boolean onMenuItemClick(MenuItem item) {
		Button b1 = (Button) this.findViewById(R.id.button1);

		switch (item.getItemId()) {
		case R.id.item1:
			b1.setText("kilometro(km)");
			return true;
		case R.id.item2:
			b1.setText("metro(m)");
			return true;
		case R.id.item3:
			b1.setText("decimetro(dm)");
			return true;
		case R.id.item4:
			b1.setText("centimetro(cm)");
			return true;
		case R.id.item5:
			b1.setText("milimetro(mm)");
			return true;
		case R.id.item6:
			b1.setText("micrometro(um)");
			return true;
		case R.id.item7:
			b1.setText("nanometro(nm)");
			return true;
		case R.id.item8:
			b1.setText("angstrom(A)");
			break;
		}
		return false;
	}

	public void init(View v) {
		EditText t0 = (EditText) this.findViewById(R.id.editInput1);
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t2 = (EditText) this.findViewById(R.id.editText2);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		EditText t4 = (EditText) this.findViewById(R.id.editText4);
		EditText t5 = (EditText) this.findViewById(R.id.editText5);
		EditText t6 = (EditText) this.findViewById(R.id.editText6);
		EditText t7 = (EditText) this.findViewById(R.id.editText7);
		EditText t8 = (EditText) this.findViewById(R.id.editText8);
		Button b1 = (Button) this.findViewById(R.id.button1);

		t0.setText("");
		t1.setText("");
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
		t6.setText("");
		t7.setText("");
		t1.setText("");
		t8.setText("");
		b1.setText("metro(m)");

	}

	public void convert(View v) {
		EditText t0 = (EditText) this.findViewById(R.id.editInput1);
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t2 = (EditText) this.findViewById(R.id.editText2);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		EditText t4 = (EditText) this.findViewById(R.id.editText4);
		EditText t5 = (EditText) this.findViewById(R.id.editText5);
		EditText t6 = (EditText) this.findViewById(R.id.editText6);
		EditText t7 = (EditText) this.findViewById(R.id.editText7);
		EditText t8 = (EditText) this.findViewById(R.id.editText8);
		Button b1 = (Button) this.findViewById(R.id.button1);

		String labels[] = { "kilometro(km)", "metro(m)", "decimetro(dm)", "centimetro(cm)", "milimetro(mm)",
				"micrometro(um)", "nanometro(nm)", "angstrom(A)" };
		long arr[] = { 0, 3, 4, 5, 6, 9, 12, 13 };

		int x = 0;
		double value = Double.parseDouble(t0.getText().toString());
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].equals(b1.getText().toString())) {
				x = i;
				break;
			}
		}
		double bd[] = new double[8];
		bd[x] = value;
		for (int i = x + 1; i < bd.length; i++) {
			bd[i] = bd[x] * Math.pow(10, arr[i] - arr[x]);
		}
		for (int i = x - 1; i >= 0; i--) {
			bd[i] = bd[x] * Math.pow(10, arr[i] - arr[x]);
		}

		t1.setText(String.format("%.2f", bd[0]));
		t2.setText(String.format("%.2f", bd[1]));
		t3.setText(String.format("%.2f", bd[2]));
		t4.setText(String.format("%.2f", bd[3]));
		t5.setText(String.format("%.2f", bd[4]));
		t6.setText(String.format("%.2f", bd[5]));
		t7.setText(String.format("%.2f", bd[6]));
		t8.setText(String.format("%.2f", bd[7]));
	}
}
