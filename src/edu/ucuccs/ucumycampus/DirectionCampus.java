package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DirectionCampus extends Activity {

	/*
	 * Change to type CustomAutoCompleteView instead of AutoCompleteTextView
	 * since we are extending to customize the view and disable filter The same
	 * with the XML view, type will be CustomAutoCompleteView
	 */

	DBAdapter dbcon = new DBAdapter(this);
	CustomAutoCompleteView myAutoCompleteDir, myAutoCompleteLoc;

	// adapter for auto-complete
	ArrayAdapter<MyObjectD> myAdapterD;

	// for database operations
	DatabaseHandler databaseH;
	Button btnGetDirection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_direction_campus);

		try {

			// instantiate database handler
			databaseH = new DatabaseHandler(DirectionCampus.this);

			// put sample data to database
			insertSampleDataD();

			// autocompletetextview is in activity_main.xml
			myAutoCompleteDir = (CustomAutoCompleteView) findViewById(R.id.myautocompleteDir);
			myAutoCompleteLoc = (CustomAutoCompleteView) findViewById(R.id.myautocompleteLoc);
			btnGetDirection = (Button) findViewById(R.id.btnGetDirection);
			
			btnGetDirection.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					dbcon.open();

					long consave = dbcon.method_savecondir(myAutoCompleteDir
							.getText().toString(),myAutoCompleteLoc.getText().toString());

					if (consave > 0) {

						Toast.makeText(getApplicationContext(), "SAVED IN HISTORY",
								Toast.LENGTH_LONG).show();

						

					} else {

						Toast.makeText(getApplicationContext(), "NOT SAVED",
								Toast.LENGTH_LONG).show();
					}
					dbcon.close();
				}
			});
					
			myAutoCompleteDir.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View arg1,
						int pos, long id) {

					RelativeLayout rl = (RelativeLayout) arg1;
					TextView tv = (TextView) rl.getChildAt(0);
					myAutoCompleteDir.setText(tv.getText().toString());

				}

			});

			myAutoCompleteLoc.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View arg1,
						int pos, long id) {

					RelativeLayout rl = (RelativeLayout) arg1;
					TextView tv = (TextView) rl.getChildAt(0);
					myAutoCompleteLoc.setText(tv.getText().toString());

				}

			});

			// add the listener so it will tries to suggest while the user types
			myAutoCompleteDir
					.addTextChangedListener(new CustomAutoCompleteTextChangedListenerD(
							this));
			myAutoCompleteLoc
					.addTextChangedListener(new CustomAutoCompleteTextChangedListenerD(
							this));

			// ObjectItemData has no value at first
			MyObjectD[] ObjectItemDataD = new MyObjectD[0];

			// set the custom ArrayAdapter
			myAdapterD = new AutocompleteCustomArrayAdapterD(this,
					R.layout.list_view_row_d, ObjectItemDataD);
			myAutoCompleteDir.setAdapter(myAdapterD);
			myAutoCompleteLoc.setAdapter(myAdapterD);

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertSampleDataD() {

		// CREATE
		// HONNASAN HALL
		databaseH.createD(new MyObjectD("17A"));
		databaseH.createD(new MyObjectD("18A"));
		databaseH.createD(new MyObjectD("19A"));
		databaseH.createD(new MyObjectD("20A"));

		// BADAR BUILDING
		databaseH.createD(new MyObjectD("Room 21"));
		databaseH.createD(new MyObjectD("Room 22"));
		databaseH.createD(new MyObjectD("Room 23"));
		databaseH.createD(new MyObjectD("Room 24"));

		// ORATA 2
		// first floor
		databaseH.createD(new MyObjectD("OB2 81"));
		databaseH.createD(new MyObjectD("OB2 82"));
		databaseH.createD(new MyObjectD("OB2 83"));
		// second floor
		databaseH.createD(new MyObjectD("OBL 1"));
		databaseH.createD(new MyObjectD("OB2 84A"));
		databaseH.createD(new MyObjectD("OB2 84B"));
		databaseH.createD(new MyObjectD("OB2 84C"));
		databaseH.createD(new MyObjectD("OB2 85"));
		databaseH.createD(new MyObjectD("OB2 86"));
		databaseH.createD(new MyObjectD("OB2 87A"));
		databaseH.createD(new MyObjectD("OB2 87B"));
		databaseH.createD(new MyObjectD("OB2 L2"));
		// third floor
		databaseH.createD(new MyObjectD("OB2 L3"));
		databaseH.createD(new MyObjectD("OB2 88"));
		databaseH.createD(new MyObjectD("OB2 89"));
		databaseH.createD(new MyObjectD("OB2 90"));
		databaseH.createD(new MyObjectD("OB2 91"));
		databaseH.createD(new MyObjectD("OB2 92"));
		databaseH.createD(new MyObjectD("OB2 93"));

		// ORATA 1
		// first floor
		databaseH.createD(new MyObjectD("Circulation section"));
		databaseH.createD(new MyObjectD("Periodical"));
		databaseH.createD(new MyObjectD("Reference Section"));
		// second floor
		databaseH.createD(new MyObjectD("Regelation"));
		databaseH.createD(new MyObjectD("Thesis"));
		databaseH.createD(new MyObjectD("GS"));
		databaseH.createD(new MyObjectD("Archives Section"));
		databaseH.createD(new MyObjectD("Multimedia Room"));
		databaseH.createD(new MyObjectD("Internet"));
		databaseH.createD(new MyObjectD("Law library"));
		// third floor
		databaseH.createD(new MyObjectD("OB 71"));
		databaseH.createD(new MyObjectD("OB 72"));
		databaseH.createD(new MyObjectD("OB 73"));
		databaseH.createD(new MyObjectD("OB 74"));
		databaseH.createD(new MyObjectD("OB 75"));
		// fourth floor
		databaseH.createD(new MyObjectD("OB 76"));
		databaseH.createD(new MyObjectD("OB 77"));
		databaseH.createD(new MyObjectD("OB 78"));
		databaseH.createD(new MyObjectD("OB 79"));
		databaseH.createD(new MyObjectD("OB 80"));

		// NEW BUILDING
		// first floor
		databaseH.createD(new MyObjectD("NB 51"));
		databaseH.createD(new MyObjectD("NB 52"));
		databaseH.createD(new MyObjectD("NB 53"));
		databaseH.createD(new MyObjectD("NB 54"));
		databaseH.createD(new MyObjectD("NB 55"));
		databaseH.createD(new MyObjectD("Chemical Laboratory"));
		databaseH.createD(new MyObjectD("REQUITION"));
		databaseH.createD(new MyObjectD("STOCK ROOM"));
		// second floor
		databaseH.createD(new MyObjectD("NB 56"));
		databaseH.createD(new MyObjectD("NB 57"));
		databaseH.createD(new MyObjectD("NB 58"));
		databaseH.createD(new MyObjectD("NB 59"));
		databaseH.createD(new MyObjectD("NB 60"));
		// third floor
		databaseH.createD(new MyObjectD("NB61 COMPLAB"));
		databaseH.createD(new MyObjectD("NB62 COMPLAB"));
		databaseH.createD(new MyObjectD("NB63 COMPLAB"));
		databaseH.createD(new MyObjectD("NB64 COMPLAB"));
		databaseH.createD(new MyObjectD("NB65 COMPLAB"));
		// fourth floor
		databaseH.createD(new MyObjectD("NB 66"));
		databaseH.createD(new MyObjectD("NB 67"));
		databaseH.createD(new MyObjectD("NB 68"));
		databaseH.createD(new MyObjectD("NB 69"));
		databaseH.createD(new MyObjectD("NB 70"));

		// AIRPLANE
		databaseH.createD(new MyObjectD("AP1"));
		databaseH.createD(new MyObjectD("AP2"));
		databaseH.createD(new MyObjectD("AP3"));
		databaseH.createD(new MyObjectD("AP4"));
		databaseH.createD(new MyObjectD("AP5"));

		// sa may gilid
		databaseH.createD(new MyObjectD("ROOM 1"));
		databaseH.createD(new MyObjectD("ROOM 2"));
		databaseH.createD(new MyObjectD("ROOM 3"));
		databaseH.createD(new MyObjectD("ROOM 4"));
		databaseH.createD(new MyObjectD("ROOM 5"));
		databaseH.createD(new MyObjectD("ROOM 6"));
		databaseH.createD(new MyObjectD("ROOM 7"));
		databaseH.createD(new MyObjectD("ROOM 8"));
		databaseH.createD(new MyObjectD("ROOM 9"));
		databaseH.createD(new MyObjectD("ROOM 10"));
		databaseH.createD(new MyObjectD("GUIDANCE"));
		databaseH.createD(new MyObjectD("OSA"));
		// second floor
		databaseH.createD(new MyObjectD("11"));
		databaseH.createD(new MyObjectD("12"));
		databaseH.createD(new MyObjectD("13"));
		databaseH.createD(new MyObjectD("14"));
		databaseH.createD(new MyObjectD("15"));
		databaseH.createD(new MyObjectD("16"));
		databaseH.createD(new MyObjectD("ID ROOM"));
		databaseH.createD(new MyObjectD("CIM"));

		// EDUCATION BUILDING
		databaseH.createD(new MyObjectD("46SWRM"));
		databaseH.createD(new MyObjectD("47A"));
		databaseH.createD(new MyObjectD("47B"));
		databaseH.createD(new MyObjectD("48"));
		databaseH.createD(new MyObjectD("49"));
		databaseH.createD(new MyObjectD("50"));
		databaseH.createD(new MyObjectD("51"));

		// CRIMINALISTIC
		databaseH.createD(new MyObjectD("ROOM 25"));
		databaseH.createD(new MyObjectD("ROOM 26"));
		databaseH.createD(new MyObjectD("ROOM 27"));
		databaseH.createD(new MyObjectD("ROOM 28"));

		// CREATE
		// HONNASAN HALL
		databaseH.createD(new MyObjectD("HONNASAN HALL"));
		// BADAR BUILDING
		databaseH.createD(new MyObjectD("BADAR BUILDING"));
		// ORATA 2
		databaseH.createD(new MyObjectD("ORATA 2"));
		// ORATA 1
		databaseH.createD(new MyObjectD("ORATA 1"));
		// NEW BUILDING
		// first floor
		databaseH.createD(new MyObjectD("NEW BUILDING"));

	}
}