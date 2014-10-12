package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

			myAutoCompleteDir.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View arg1,
						int pos, long id) {

					RelativeLayout rl = (RelativeLayout) arg1;
					TextView tv = (TextView) rl.getChildAt(0);
					myAutoCompleteDir.setText(tv.getText().toString());
				}
			});
			btnGetDirection.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					dbcon.open();

					long consave = dbcon.method_savecondir(myAutoCompleteDir
							.getText().toString(), myAutoCompleteLoc.getText()
							.toString());
					if (consave > 0) {
						Toast.makeText(getApplicationContext(),
								"SAVE IN HISTORY", Toast.LENGTH_LONG).show();

						searchDadarToBuilding();
						searchAVRToBuilding();
						searchArtsBuilding2ToBuilding();
						searchHonnasanHallToBuilding();
						searchAccountancyToBuilding();
						searchBadarBuildingToBuilding();
						searchArtsToBuilding();
						searchScienceBuiltingToBuilding();
						searchDevelopmentCenterToBuilding();
						searchReadingCenter();
						searchFourRoomBuildingToBuilding();
						searchNewBuildingToBuilding();
						searchGreenhome2ToBuilding();
						searchOrata2BuildingToBuilding();
						searchOrataBuildingToBuilding();
						searchAirPlaneToBuilding();

					} else {

						Toast.makeText(getApplicationContext(), "NO SAVED",
								Toast.LENGTH_LONG).show();

					}
					dbcon.close();
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

		databaseH.createD(new MyObjectD("AMADEO PEREZ BUILDING"));
		databaseH.createD(new MyObjectD("ROOM 1"));
		databaseH.createD(new MyObjectD("ROOM 2"));
		databaseH.createD(new MyObjectD("ROOM 3"));
		databaseH.createD(new MyObjectD("ROOM 4"));
		databaseH.createD(new MyObjectD("ROOM 5"));
		databaseH.createD(new MyObjectD("ROOM 6"));
		databaseH.createD(new MyObjectD("NSTP ROOM"));
		databaseH.createD(new MyObjectD("AVR/ AUDIO VISUAL ROOM"));

		// ARTS AND SCIENCES BUILDING 2
		// FIRST FLOOR
		databaseH.createD(new MyObjectD("ARTS AND SCIENCES BUILDING 2"));
		databaseH.createD(new MyObjectD("ROOM 8"));
		databaseH.createD(new MyObjectD("ROOM 9"));
		databaseH.createD(new MyObjectD("ROOM 10"));
		databaseH.createD(new MyObjectD("ROOM 11"));
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("ROOM 12"));
		databaseH.createD(new MyObjectD("ROOM 13"));
		databaseH.createD(new MyObjectD("ROOM 14"));
		databaseH.createD(new MyObjectD("ROOM 15"));
		databaseH.createD(new MyObjectD("ROOM 16"));

		// HONASSAN HALL
		databaseH.createD(new MyObjectD("HONNASAN HALL"));

		// ACCOUNTANCY BUILDING
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("ACCOUNTANCY BUILDING"));
		databaseH.createD(new MyObjectD("A17"));
		databaseH.createD(new MyObjectD("A18"));
		databaseH.createD(new MyObjectD("A19"));
		databaseH.createD(new MyObjectD("A20"));

		// BADAR BUILDING
		// FIRST FLOOR
		databaseH.createD(new MyObjectD("BADAR BUILDING"));
		databaseH.createD(new MyObjectD("B21"));
		databaseH.createD(new MyObjectD("B22"));
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("B23"));
		databaseH.createD(new MyObjectD("B24"));

		// ARTS AND SCIENCES BUILDING
		// FIRST FLOOR
		databaseH.createD(new MyObjectD("ARTS AND SCIENCES BUILDING"));
		databaseH.createD(new MyObjectD("29"));
		databaseH.createD(new MyObjectD("30 TYPING LABORATORY"));
		databaseH.createD(new MyObjectD("31"));
		databaseH.createD(new MyObjectD("32 BAKING LABORATORY"));
		databaseH.createD(new MyObjectD("33CCLab2"));
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("34"));
		databaseH.createD(new MyObjectD("35"));
		databaseH.createD(new MyObjectD("36CGLab"));
		databaseH.createD(new MyObjectD("37FBSLab"));
		databaseH.createD(new MyObjectD("38CCLab"));

		// SCIENCE BUILDING
		// FIRST FLOOR
		databaseH.createD(new MyObjectD("SCIENCE BUILDING"));
		databaseH.createD(new MyObjectD("39 SL4"));
		databaseH.createD(new MyObjectD("40 SL5"));
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("41 CLINICAL SKILLS LAB"));
		databaseH.createD(new MyObjectD("42 CLINICAL SKILLS LAB"));
		databaseH.createD(new MyObjectD("43 CLINICAL SKILLS LAB"));

		// UNIVERSITY CANTEEN
		databaseH.createD(new MyObjectD("44"));
		databaseH.createD(new MyObjectD("45"));

		// DEVELOPMENT CENTER
		databaseH.createD(new MyObjectD("DEVELOPMENT CENTER"));

		// READING CENTER
		databaseH.createD(new MyObjectD("READING CENTER"));

		// FOUR ROOMS BUILDING
		databaseH.createD(new MyObjectD("FOUR ROOMS BUILDING"));
		databaseH.createD(new MyObjectD("46 SOCIAL WORK"));
		databaseH.createD(new MyObjectD("ROOM 47A"));
		databaseH.createD(new MyObjectD("ROOM 47B"));
		databaseH.createD(new MyObjectD("ROOM 48"));
		databaseH.createD(new MyObjectD("ROOM 49"));
		databaseH.createD(new MyObjectD("ROOM 50"));
		databaseH.createD(new MyObjectD("ROOM 51"));

		// NEW BUILDING
		// FIRST FLOOR
		databaseH.createD(new MyObjectD("NEW BUILDING"));
		databaseH.createD(new MyObjectD("CHEMICAL LABORATORY"));
		databaseH.createD(new MyObjectD("NB52"));
		databaseH.createD(new MyObjectD("NB53 BioLab"));
		databaseH.createD(new MyObjectD("NB54 CHLab"));
		databaseH.createD(new MyObjectD("NB55 PHLab"));
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("NB56"));
		databaseH.createD(new MyObjectD("NB57"));
		databaseH.createD(new MyObjectD("NB58"));
		databaseH.createD(new MyObjectD("NB59"));
		databaseH.createD(new MyObjectD("NB60"));
		// THIRD FLOOR
		databaseH.createD(new MyObjectD("NB61 COMPLAB"));
		databaseH.createD(new MyObjectD("NB62 COMPLAB"));
		databaseH.createD(new MyObjectD("NB63 COMPLAB"));
		databaseH.createD(new MyObjectD("NB64 COMPLAB"));
		databaseH.createD(new MyObjectD("NB65 COMPLAB"));
		// FOURTH FLOOR
		databaseH.createD(new MyObjectD("NB66"));
		databaseH.createD(new MyObjectD("NB67"));
		databaseH.createD(new MyObjectD("NB68"));
		databaseH.createD(new MyObjectD("NB69"));
		databaseH.createD(new MyObjectD("NB70"));

		// GREENHOME
		databaseH.createD(new MyObjectD("GREENHOME"));

		// GREENHOME 2
		databaseH.createD(new MyObjectD("GREENHOME 2"));

		// ORATA 2
		// FIRST FLOOR
		databaseH.createD(new MyObjectD("ORATA 2 BUILDING"));
		databaseH.createD(new MyObjectD("OB2 80"));
		databaseH.createD(new MyObjectD("OB2 81"));
		databaseH.createD(new MyObjectD("OB2 82"));
		databaseH.createD(new MyObjectD("OB2 83"));
		// SECOND FLOOR
		databaseH.createD(new MyObjectD("OB2 L1"));
		databaseH.createD(new MyObjectD("OB2 L2"));
		databaseH.createD(new MyObjectD("OB2 84A"));
		databaseH.createD(new MyObjectD("OB2 84B"));
		databaseH.createD(new MyObjectD("OB2 85"));
		databaseH.createD(new MyObjectD("OB2 86"));
		databaseH.createD(new MyObjectD("OB2 87A"));
		databaseH.createD(new MyObjectD("OB2 87B"));
		// THIRD FLOOR
		databaseH.createD(new MyObjectD("OB2 L3"));
		databaseH.createD(new MyObjectD("OB2 L4"));
		databaseH.createD(new MyObjectD("OB2 88"));
		databaseH.createD(new MyObjectD("OB2 89"));
		databaseH.createD(new MyObjectD("OB2 90"));
		databaseH.createD(new MyObjectD("OB2 91"));
		databaseH.createD(new MyObjectD("OB2 92"));
		databaseH.createD(new MyObjectD("OB2 93"));

		// ORATA 1
		// THIRD FLOOR
		databaseH.createD(new MyObjectD("ORATA BUILDING"));
		databaseH.createD(new MyObjectD("OB 71"));
		databaseH.createD(new MyObjectD("OB 72"));
		databaseH.createD(new MyObjectD("OB 73"));
		databaseH.createD(new MyObjectD("OB 74"));
		databaseH.createD(new MyObjectD("OB 75"));
		// FOURTH FLOOR
		databaseH.createD(new MyObjectD("OB 76"));
		databaseH.createD(new MyObjectD("OB 77"));
		databaseH.createD(new MyObjectD("OB 78"));
		databaseH.createD(new MyObjectD("OB 79"));
		databaseH.createD(new MyObjectD("OB 80"));

		// AIRPLANE
		databaseH.createD(new MyObjectD("AIRPLANE"));

		// CRIMINALISTIC
		databaseH.createD(new MyObjectD("25 CRIME LAB"));
		databaseH.createD(new MyObjectD("26 CRIME LAB"));
		databaseH.createD(new MyObjectD("27 CRIME LAB"));
		databaseH.createD(new MyObjectD("28 CRIME LAB"));

		// ENGINEERING LABORATORY
		databaseH.createD(new MyObjectD("ENGINEERING LABORATORY"));
		databaseH.createD(new MyObjectD("MP 81"));
		databaseH.createD(new MyObjectD("MP 82"));
		databaseH.createD(new MyObjectD("MP 83"));
		databaseH.createD(new MyObjectD("ME LABORATORY"));

		// GYMNASIUM
		databaseH.createD(new MyObjectD("GYMNASIUM"));

	}

	public void searchDadarToBuilding() {
		Bitmap NB61bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		
		if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Intent intent = new Intent();
			intent.setClass(DirectionCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", NB61bitmap);
			startActivity(intent);
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AMADEO PEREZ BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}

	}

	public void searchAVRToBuilding() {
		if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("AVR/ AUDIO VISUAL ROOM")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();

		}
	}

	public void searchArtsBuilding2ToBuilding() {

		if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchHonnasanHallToBuilding() {

		if (((myAutoCompleteLoc.getText().toString().equals("HONNASAN HALL")) && (myAutoCompleteDir
				.getText().toString().equals("ORATA BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("ORATA BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("ORATA 2 BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("ORATA 2 BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("NEW BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("NEW BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("GYMNASIUM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("GYMNASIUM")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("BADAR BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("BADAR BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("AIRPLANE")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("AIRPLANE")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("AMADEO PEREZ BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("AMADEO PEREZ BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("HONNASAN HALL")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("HONNASAN HALL")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchAccountancyToBuilding() {
		if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ACCOUNTANCY BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchBadarBuildingToBuilding() {

		if (((myAutoCompleteLoc.getText().toString().equals("BADAR BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ORATA BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ORATA BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ORATA 2 BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ORATA 2 BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("NEW BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("NEW BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GYMNASIUM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GYMNASIUM")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AIRPLANE")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AIRPLANE")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AMADEO PEREZ BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AMADEO PEREZ BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("BADAR BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("BADAR BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchArtsToBuilding() {
		if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDINGG")) && (myAutoCompleteDir
				.getText().toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDINGG")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDINGG")) && (myAutoCompleteDir
				.getText().toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDINGG")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDINGG")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ARTS AND SCIENCES BUILDINGG")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchScienceBuiltingToBuilding() {

		if (((myAutoCompleteLoc.getText().toString().equals("SCIENCE BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("SCIENCE BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("SCIENCE BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("SCIENCE BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("SCIENCE BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("SCIENCE BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("SCIENCE BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("SCIENCE BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("SCIENCE BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("SCIENCE BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchDevelopmentCenterToBuilding() {

		if (((myAutoCompleteLoc.getText().toString()
				.equals("DEVELOPMENT CENTER")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("DEVELOPMENT CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("DEVELOPMENT CENTER")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("DEVELOPMENT CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("DEVELOPMENT CENTER")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("DEVELOPMENT CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("DEVELOPMENT CENTER")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("DEVELOPMENT CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchReadingCenter() {

		if (((myAutoCompleteLoc.getText().toString().equals("READING CENTER")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("READING CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("READING CENTER")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("READING CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("READING CENTER")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("READING CENTER")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchFourRoomBuildingToBuilding() {
		if (((myAutoCompleteLoc.getText().toString()
				.equals("FOUR ROOMS BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("FOUR ROOMS BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("FOUR ROOMS BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("FOUR ROOMS BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();

		}
	}

	public void searchNewBuildingToBuilding() {

		if (((myAutoCompleteLoc.getText().toString().equals("NEW BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("GYMNASIUM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GYMNASIUM")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AIRPLANE")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AIRPLANE")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AMADEO PEREZ BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AMADEO PEREZ BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("NEW BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("NEW BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchGreenhome2ToBuilding() {
		if (((myAutoCompleteLoc.getText().toString().equals("GREENHOME 2")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("GREENHOME 2")) && (myAutoCompleteLoc.getText()
						.toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchOrata2BuildingToBuilding() {
		if (((myAutoCompleteLoc.getText().toString().equals("ORATA 2 BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("NEW BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("NEW BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GYMNASIUM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GYMNASIUM")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AIRPLANE")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AIRPLANE")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AMADEO PEREZ BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AMADEO PEREZ BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA 2 BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA 2 BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}

	}

	public void searchOrataBuildingToBuilding() {

		if (((myAutoCompleteLoc.getText().toString().equals("ORATA BUILDING")) && (myAutoCompleteDir
				.getText().toString().equals("ORATA 2 BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ORATA 2 BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("NEW BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("NEW BUILDING")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GYMNASIUM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GYMNASIUM")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AIRPLANE")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AIRPLANE")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME")))) {

		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AMADEO PEREZ BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AMADEO PEREZ BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("SCIENCE BUILDINGG")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString()
				.equals("ORATA BUILDING")) && (myAutoCompleteDir.getText()
				.toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString()
						.equals("ORATA BUILDING")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchAirPlaneToBuilding() {
		if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME")))) {

		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("AMADEO PEREZ BUILDING")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("AMADEO PEREZ BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("AVR/ AUDIO VISUAL ROOM")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING 2")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("ACCOUNTANCY BUILDING")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("ACCOUNTANCY BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("ARTS AND SCIENCES BUILDING")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString()
						.equals("ARTS AND SCIENCES BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("SCIENCE BUILDING")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("SCIENCE BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("DEVELOPMENT CENTER")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("DEVELOPMENT CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("READING CENTER")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("READING CENTER")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("FOUR ROOMS BUILDING")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("FOUR ROOMS BUILDING")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("GREENHOME 2")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("GREENHOME 2")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		} else if (((myAutoCompleteLoc.getText().toString().equals("AIRPLANE")) && (myAutoCompleteDir
				.getText().toString().equals("ENGINEERING LABORATORY")))
				|| ((myAutoCompleteDir.getText().toString().equals("AIRPLANE")) && (myAutoCompleteLoc
						.getText().toString().equals("ENGINEERING LABORATORY")))) {
			Toast.makeText(getApplicationContext(), "no direction yet",
					Toast.LENGTH_LONG).show();
		}
	}
}