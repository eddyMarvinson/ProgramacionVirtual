package com.example.recetas;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsItem extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details_item);

		Bundle param = getIntent().getExtras();
		String ms = param.getString("helado");
		showResult(ms);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.details_item, menu);
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

	public String cargarArchivo(InputStream a) throws IOException {
		ByteArrayOutputStream vdatos = new ByteArrayOutputStream();
		byte[] vbyte = new byte[512];
		int largo = 0;
		while ((largo = a.read(vbyte)) > 0) {
			vdatos.write(vbyte, 0, largo);

		}
		return new String(vdatos.toByteArray());
	}

	public void showResult(String s) {
		ImageView img = (ImageView) findViewById(R.id.imageView2);
		TextView text1 = (TextView) findViewById(R.id.textView1);
		TextView text2 = (TextView) findViewById(R.id.textView2);
		int imgHelado[] = { R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};

		AssetManager pam = getAssets();
		InputStream f = null;
		try {
			f = pam.open("recetas.txt");
			String res = cargarArchivo(f);
			String data[] = res.split("Titulo:");
			String info = "";
			for (int i = 0; i < data.length; i++) {
				if (data[i].contains(s)) {
					info = data[i];
				}
			}
			if(s.equals("Helado de yogur, chocolate y brownie"))
				img.setImageResource(imgHelado[0]);
			else if (s.equals("Helado de Vainilla y galletas Oreo"))
				img.setImageResource(imgHelado[1]);
			else if (s.equals("Sandwich de helado casero con galletas de chocolate"))
				img.setImageResource(imgHelado[2]);
			else
				img.setImageResource(imgHelado[3]);
			text1.setMovementMethod(new ScrollingMovementMethod());
			text1.setText(info);
			text2.setText(s);
		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), 1).show();
		}
	}

	public void back(View v) {
		finish();
	}
}
