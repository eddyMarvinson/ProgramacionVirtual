package com.example.consultaplanilla;

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

	public void query(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit6 = (EditText) findViewById(R.id.editText6);
		EditText edit7 = (EditText) findViewById(R.id.editText7);
		EditText edit8 = (EditText) findViewById(R.id.editText8);
		EditText edit9 = (EditText) findViewById(R.id.editText9);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		EditText edit4 = (EditText) findViewById(R.id.editText4);
		EditText edit5 = (EditText) findViewById(R.id.editText5);

		edit2.setText("");
		edit3.setText("");
		edit4.setText("");
		edit5.setText("");
		edit6.setText("");
		edit7.setText("");
		edit8.setText("");
		edit9.setText("");
		
		String ci = edit1.getText().toString();

		if (queryDatos(ci)) {
			queryCargoBasico(ci);
			queryBonos(ci);
			queryDescuentos(ci);
			int basico = Integer.parseInt(edit6.getText().toString());
			int bono = Integer.parseInt(edit7.getText().toString());
			int descuento = Integer.parseInt(edit8.getText().toString());
			int pagable = basico + bono - descuento;
			edit9.setText("" + pagable);
		}
	}

	public boolean queryDatos(String s) {

		String a[] = { "", "", "" };

		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "No hay memoria SD card", Toast.LENGTH_LONG).show();
			finish();
		}
		File dir = Environment.getExternalStorageDirectory();
		File pt = new File(dir.getAbsolutePath() + File.separator + "personal.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pt));
			String linea;
			boolean sw = true;

			while ((linea = lector.readLine()) != null) {
				linea += ";";
				String arr[] = linea.split(";");
				if (arr[0].equals(s)) {
					sw = false;
					a = arr;
					break;
				}
			}
			lector.close();
			if (sw) {
				Toast.makeText(this, "personal no encontrado", Toast.LENGTH_LONG).show();
				return false;
			}

		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		EditText edit4 = (EditText) findViewById(R.id.editText4);
		edit2.setText(a[1]);
		edit3.setText(a[2]);
		edit4.setText(a[3]);
		return true;
	}

	public void queryBonos(String s) {
		int ans = 0;

		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "No hay memoria SD card", Toast.LENGTH_LONG).show();
			finish();
		}
		File dir = Environment.getExternalStorageDirectory();
		File pt = new File(dir.getAbsolutePath() + File.separator + "bonos.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pt));
			String linea;
			while ((linea = lector.readLine()) != null) {
				linea += ";";
				String arr[] = linea.split(";");
				if (arr[1].equals(s)) {
					ans += Integer.parseInt(arr[2]);
				}
			}
			lector.close();

		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		EditText edit7 = (EditText) findViewById(R.id.editText7);
		edit7.setText(Integer.toString(ans));

	}

	public void queryDescuentos(String s) {
		int ans = 0;

		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "No hay memoria SD card", Toast.LENGTH_LONG).show();
			finish();
		}
		File dir = Environment.getExternalStorageDirectory();
		File pt = new File(dir.getAbsolutePath() + File.separator + "descuentos.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pt));
			String linea;
			while ((linea = lector.readLine()) != null) {
				linea += ";";
				String arr[] = linea.split(";");
				if (arr[1].equals(s)) {
					ans += Integer.parseInt(arr[2]);
				}
			}
			lector.close();

		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		EditText edit8 = (EditText) findViewById(R.id.editText8);
		edit8.setText(Integer.toString(ans));

	}

	public void queryCargoBasico(String s) {
		String ans = "";
		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "No hay memoria SD card", Toast.LENGTH_LONG).show();
			finish();
		}
		File dir = Environment.getExternalStorageDirectory();
		File pt = new File(dir.getAbsolutePath() + File.separator + "planilla.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pt));
			String linea;
			while ((linea = lector.readLine()) != null) {
				linea += ";";
				String arr[] = linea.split(";");
				if (arr[1].equals(s)) {
					ans = arr[2];
					break;
				}
			}
			lector.close();

		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
		EditText edit5 = (EditText) findViewById(R.id.editText5);
		EditText edit6 = (EditText) findViewById(R.id.editText6);
		String tmp[] = queryCargos(ans);

		edit5.setText(tmp[0]);
		edit6.setText(tmp[1]);

	}

	public String[] queryCargos(String s) {
		String ans[] = { "", "" };
		String estado = Environment.getExternalStorageState();
		if (!estado.equals(Environment.MEDIA_MOUNTED)) {
			Toast.makeText(this, "No hay memoria SD card", Toast.LENGTH_LONG).show();
			finish();
		}
		File dir = Environment.getExternalStorageDirectory();
		File pt = new File(dir.getAbsolutePath() + File.separator + "cargos.txt");
		try {
			BufferedReader lector = new BufferedReader(new FileReader(pt));
			String linea;
			while ((linea = lector.readLine()) != null) {
				linea += ";";
				String arr[] = linea.split(";");
				if (arr[0].equals(s)) {
					ans[0] = arr[1];
					ans[1] = arr[2];
					break;
				}
			}
			lector.close();

		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}

		return ans;
	}

	public void clean(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		EditText edit4 = (EditText) findViewById(R.id.editText4);
		EditText edit5 = (EditText) findViewById(R.id.editText5);
		EditText edit6 = (EditText) findViewById(R.id.editText6);
		EditText edit7 = (EditText) findViewById(R.id.editText7);
		EditText edit8 = (EditText) findViewById(R.id.editText8);
		EditText edit9 = (EditText) findViewById(R.id.editText9);

		edit1.setText("");
		edit2.setText("");
		edit3.setText("");
		edit4.setText("");
		edit5.setText("");
		edit6.setText("");
		edit7.setText("");
		edit8.setText("");
		edit9.setText("");
	}
}