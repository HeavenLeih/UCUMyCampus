package edu.ucuccs.ucumycampus;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DirectionHistory extends Activity {

	DBAdapter dbcon = new DBAdapter(this);
	// declaration
	ListView myListDir;
	Button btnClearDir;

	// arraylist

	ArrayList<String> arraylist = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_direction_history);

		btnClearDir = (Button) findViewById(R.id.btnClearDir);
		myListDir= (ListView) findViewById(R.id.myListDir);

		// adapter
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arraylist);
		myListDir.setAdapter(adapter);

		btnClearDir.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				dbcon.open();

				dbcon.method_deleteAlldir();
				Toast.makeText(getApplicationContext(),
						"SUCCESSFULLY DELETED THE RECORDS", Toast.LENGTH_LONG)
						.show();

				populateList();

			}
		});
		dbcon.open();
		populateList();
	}

	// show all
	protected void populateList() {
		// TODO Auto-generated method stub
		Cursor c = dbcon.method_showallrecordsdir();
		adapter.clear();
		adapter.notifyDataSetChanged();

		if (c.moveToFirst()) {
			do {
				adapter.add(c.getString(0).toString() + ""
						+ c.getString(1).toString() + ""
						+ c.getString(2).toString() + "");

			} while (c.moveToNext());
		}
	}
}