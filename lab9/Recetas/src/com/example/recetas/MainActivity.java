package com.example.recetas;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listview = (ListView) findViewById(R.id.listView1);
		ArrayList<String> listaHelados = new ArrayList<String>();
		listaHelados.add("Helado de yogur, chocolate y brownie");
		listaHelados.add("Helado de Vainilla y galletas Oreo");
		listaHelados.add("Sandwich de helado casero con galletas de chocolate");
		listaHelados.add("Helado de platano, nueces y chocolate");

		ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaHelados);
		listview.setAdapter(adaptador);

		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				String message = parent.getItemAtPosition(position).toString();
				cambiarLayout(message);
			}
		});
	}

	public void cambiarLayout(String s) {
		Intent pFinish = new Intent(this, DetailsItem.class);
		pFinish.putExtra("helado", s);
		startActivity(pFinish);
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

}
