package com.example.currencycoinlevel3;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener {
	View currentView;

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
		currentView = v;
		PopupMenu p = new PopupMenu(this, v);
		p.setOnMenuItemClickListener(this);
		p.inflate(R.menu.popup_one);
		p.show();
	}

	public boolean onMenuItemClick(MenuItem item) {
		Button b1 = (Button) this.findViewById(R.id.button1);
		Button b2 = (Button) this.findViewById(R.id.button2);
		switch (item.getItemId()) {
		case R.id.item1:
			if (currentView.getId() == R.id.button1)
				b1.setText("Bolivianos");
			else
				b2.setText("Bolivianos");
			return true;
		case R.id.item2:
			if (currentView.getId() == R.id.button1)
				b1.setText("Dolares");
			else
				b2.setText("Dolares");
			return true;
		case R.id.item3:
			if (currentView.getId() == R.id.button1)
				b1.setText("Euros");
			else
				b2.setText("Euros");
			return true;
		case R.id.item4:
			if (currentView.getId() == R.id.button1)
				b1.setText("Soles");
			else
				b2.setText("Soles");
			return true;
		case R.id.item5:
			if (currentView.getId() == R.id.button1)
				b1.setText("Pesos Chile");
			else
				b2.setText("Pesos Chile");
			return true;
		case R.id.item6:
			if (currentView.getId() == R.id.button1)
				b1.setText("Reales Brasil");
			else
				b2.setText("Reales Brasil");
			return true;
		case R.id.item7:
			if (currentView.getId() == R.id.button1)
				b1.setText("Yuan China");
			else
				b2.setText("Yuan China");
			return true;
		case R.id.item8:
			if (currentView.getId() == R.id.button1)
				b1.setText("Yen Japon");
			else
				b2.setText("Yen Japon");
			break;
		}
		return false;
	}

	public void init(View v) {
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		Button b1 = (Button) this.findViewById(R.id.button1);
		Button b2 = (Button) this.findViewById(R.id.button2);

		t1.setText("");
		t3.setText("");
		b1.setText("Bolivianos");
		b2.setText("Dolares");

	}

	public void convert(View v) {
		EditText t1 = (EditText) this.findViewById(R.id.editText1);
		EditText t3 = (EditText) this.findViewById(R.id.editText3);
		Button b1 = (Button) this.findViewById(R.id.button1);
		Button b2 = (Button) this.findViewById(R.id.button2);

		double value = Double.parseDouble(t1.getText().toString());

		String labels[] = { "Bolivianos", "Dolares", "Euros", "Soles", "Pesos Chile", "Reales Brasil", "Yuan China",
				"Yen Japon" };

		String a = b1.getText().toString();
		String b = b2.getText().toString();
		double exchangeRate[] = { 6.90, 1.00, 0.84, 3.56, 779.60, 5.93, 6.87, 105.36 };

		int x = 0;
		int y = 0;

		for (int i = 0; i < labels.length; i++) {
			if (labels[i].equals(a))
				x = i;
			if (labels[i].equals(b))
				y = i;
		}

		value = (double) ((double) (value / exchangeRate[x]) * exchangeRate[y]);
		t3.setText(String.format("%.2f", (double) value));

	}

}
