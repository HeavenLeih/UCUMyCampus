package edu.ucuccs.ucumycampus;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class HistoryCampus extends Activity {

	DBAdapter dbcon = new DBAdapter(this);
	// declaration
	ListView myListLoc;
	Button btnClearLoc;

	// arraylist

	ArrayList<String> arraylist = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_history_campus);

		btnClearLoc = (Button) findViewById(R.id.btnClearLoc);
		myListLoc = (ListView) findViewById(R.id.myListLoc);

		// adapter
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, arraylist);
		myListLoc.setAdapter(adapter);

		btnClearLoc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				dbcon.open();

				dbcon.method_deleteAll();
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
		Cursor c = dbcon.method_showallrecords();
		adapter.clear();
		adapter.notifyDataSetChanged();

		if (c.moveToFirst()) {
			do {
				adapter.add(c.getString(0).toString() + ""
						+ c.getString(1).toString() + "");

			} while (c.moveToNext());
		}
	}
}