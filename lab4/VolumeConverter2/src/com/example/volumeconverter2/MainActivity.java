package com.example.volumeconverter2;

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
			b1.setText("decimetro cubico");
			return true;
		case R.id.item2:
			b1.setText("centimetro cubico");
			return true;
		case R.id.item3:
			b1.setText("metro cubico");
			return true;
		case R.id.item4:
			b1.setText("pulgada cubica");
			return true;
		case R.id.item5:
			b1.setText("pie cubico");
			return true;
		case R.id.item6:
			b1.setText("mililitro");
			return true;
		case R.id.item7:
			b1.setText("galon");
			return true;
		case R.id.item8:
			b1.setText("litro");
			break;
		}
		return false;
	}

	public void init(View v) {
		EditText t0 = (EditText) this.findViewById(R.id.editInput0);
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
		b1.setText("litro");

	}

	public void convert(View v) {
		EditText t0 = (EditText) this.findViewById(R.id.editInput0);
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t2 = (EditText) this.findViewById(R.id.editText2);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		EditText t4 = (EditText) this.findViewById(R.id.editText4);
		EditText t5 = (EditText) this.findViewById(R.id.editText5);
		EditText t6 = (EditText) this.findViewById(R.id.editText6);
		EditText t7 = (EditText) this.findViewById(R.id.editText7);
		EditText t8 = (EditText) this.findViewById(R.id.editText8);
		Button b1 = (Button) this.findViewById(R.id.button1);

		String labels[] = { "decimetro cubico", "centimetro cubico", "metro cubico", "pulgada cubica", "pie cubico",
				"mililitro cubico", "galon", "litro" };
		int x = 0;
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].equals(b1.getText().toString())) {
				x = i;
				break;
			}
		}
		double value = Double.parseDouble(t0.getText().toString());

		double tableConv[][] = { { 1, 1000, 0.001, 61.0237, 0.0353, 1000, 0.22, 1 },
				{ 0.001, 1, 1e-6, 6.102e-2, 3.531e-5, 1, 2.2e-4, 1e-3 },
				{ 1000, 1e6, 1, 6.102e4, 35.31, 1e6, 220, 1000 },
				{ 0.0164, 16.39, 1.639e-5, 1, 5.787e-4, 16.39, 3.605e-3, 1.639e-2 },
				{ 28.32, 2.832e4, 2.832e-2, 1728, 1, 28320, 6.2288, 28.32 },
				{ 0.001, 1, 1e-6, 0.06102, 3.531e-5, 1, 2.2e-4, 0.001 },
				{ 4.546, 4546, 4.546e-3, 277.419, 0.1605, 4546, 1, 4.546 },
				{ 1, 1000, 1e-3, 61.02, 3.531e-2, 1000, 0.22, 1 } };

		t1.setText(String.format("%.6f", value * tableConv[x][0]));
		t2.setText(String.format("%.6f", value * tableConv[x][1]));
		t3.setText(String.format("%.6f", value * tableConv[x][2]));
		t4.setText(String.format("%.6f", value * tableConv[x][3]));
		t5.setText(String.format("%.6f", value * tableConv[x][4]));
		t6.setText(String.format("%.6f", value * tableConv[x][5]));
		t7.setText(String.format("%.6f", value * tableConv[x][6]));
		t8.setText(String.format("%.6f", value * tableConv[x][7]));
	}
}
