package com.example.basedatosin;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

	public void clean(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		TextView text5 = (TextView) findViewById(R.id.textView5);
		edit1.setText("");
		edit2.setText("");
		edit3.setText("");
		text5.setText("");
	}

	public void insert(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);

		String qcod = edit1.getText().toString();
		String qdes = edit2.getText().toString();
		String pventa = edit3.getText().toString();
		
		Productos db = null;
		try {
			db = new Productos(MainActivity.this);
			db.apertura();
			long resultado = db.Insertar(qcod, qdes, pventa);
			if (resultado == -1)
				Toast.makeText(this, "No insertado", 1).show();
			else
				Toast.makeText(this, "Correcto!", 1).show();
		} catch (Exception e) {
			Toast.makeText(this, "Error insert", 1).show();
		} finally {
			db.cerrar();
		}
	}

	public void find(View v) {
		EditText edit1 = (EditText) findViewById(R.id.editText1);
		EditText edit2 = (EditText) findViewById(R.id.editText2);
		EditText edit3 = (EditText) findViewById(R.id.editText3);
		Productos db = null;
		try {
			db = new Productos(MainActivity.this);
			db.apertura();
			String resultado = db.Buscar(edit1.getText().toString());
			if (resultado.isEmpty()) {
				Toast.makeText(this, "No Encontrado", 1).show();
			} else {
				String arr[] = resultado.split(" ");
				edit2.setText(arr[1]);
				edit3.setText(arr[2]);
			}
		} catch (Exception e) {
			Toast.makeText(this, "Error find", 1).show();
		} finally {
			db.cerrar();
		}

	}

	public void show(View v) {
		Productos db = null;
		try {
			db = new Productos(MainActivity.this);
			db.apertura();
			String resultado = db.Listar();
			TextView text5 = (TextView) findViewById(R.id.textView5);
			text5.setMovementMethod(new ScrollingMovementMethod());
			text5.setText(resultado);
		} catch (Exception e) {
			Toast.makeText(this, "error show", 1).show();
		} finally {
			db.cerrar();
		}
	}
}
