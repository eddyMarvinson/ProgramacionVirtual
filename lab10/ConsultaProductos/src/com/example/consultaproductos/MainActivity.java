package com.example.consultaproductos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
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

	public void find(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		EditText edit4 = (EditText) findViewById(R.id.editText4);
		EditText edit5 = (EditText) findViewById(R.id.editText5);
		EditText edit6 = (EditText) findViewById(R.id.editText6);

		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "No hay memoria SD card", Toast.LENGTH_LONG).show();
			finish();
		}
		File dir = Environment.getExternalStorageDirectory();
		File pt = new File(dir.getAbsolutePath() + File.separator + "productos.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pt));
			String linea;
			boolean sw = true;
			while ((linea = lector.readLine()) != null) {
				linea += ";";
				String arr[] = linea.split(";");
				if (arr[0].equals(edit1.getText().toString())) {
					edit2.setText(arr[1]);
					edit3.setText(arr[2]);
					edit4.setText(arr[3]);
					edit5.setText(arr[4]);
					edit6.setText(arr[5]);
					sw = false;
				}
			}
			lector.close();
			if (sw)
				Toast.makeText(this, "No encontrado", Toast.LENGTH_LONG).show();
		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	public void clean(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		EditText edit4 = (EditText) findViewById(R.id.editText4);
		EditText edit5 = (EditText) findViewById(R.id.editText5);
		EditText edit6 = (EditText) findViewById(R.id.editText6);
		edit1.setText("");
		edit2.setText("");
		edit3.setText("");
		edit4.setText("");
		edit5.setText("");
		edit6.setText("");
	}

}
