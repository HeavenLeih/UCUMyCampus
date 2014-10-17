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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LocationCampus extends Activity {

	/*
	 * Change to type CustomAutoCompleteView instead of AutoCompleteTextView
	 * since we are extending to customize the view and disable filter The same
	 * with the XML view, type will be CustomAutoCompleteView
	 */
	DBAdapter dbcon = new DBAdapter(this);
	CustomAutoCompleteView myAutoComplete;

	// adapter for auto-complete
	ArrayAdapter<MyObject> myAdapter;

	// for database operations
	DatabaseHandler databaseH;
	ImageView btnSearchLoc;

	String locationD;
	Integer lid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_location_campus);

		try {

			// instantiate database handler
			databaseH = new DatabaseHandler(LocationCampus.this);

			// put sample data to database
			insertSampleData();

			// autocompletetextview is in activity_main.xml
			myAutoComplete = (CustomAutoCompleteView) findViewById(R.id.myautocomplete);
			btnSearchLoc = (ImageView) findViewById(R.id.btnSearchLoc);
			btnSearchLoc.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					// locationD = myAutoComplete.getText().toString();

					dbcon.open();

					long consave1 = dbcon.method_savecon(myAutoComplete
							.getText().toString());

					if (consave1 > 0) {

						Toast.makeText(getApplicationContext(),
								"SAVED IN HISTORY", Toast.LENGTH_LONG).show();

						// METHOD FOR ALL BUILDINGS AND CLASSROOMS
						searchHonasanHallBuilding();
						searchAmadeoPerezBuilding();
						searchArtsAndScienceBuilding2();
						searchAccountancyBuilding();
						searchBadarBuilding();
						searchArtsAndScienceBuilding();
						searchScienceBuilding();
						searchRooms44_45();
						searchDevRead();
						searchFourRoomsBuilding();
						searchNewBuilding();
						searchGreenHome();
						searchOrataBuilding();
						searchOrata2Building();
						searchAirplane();
						searchAVR();
						searchCrime();
						searchGym();
						searchEngineeringLab();

					} else {
						Toast.makeText(getApplicationContext(), "NOT SAVED",
								Toast.LENGTH_LONG).show();
					}

					dbcon.close();
				}
			});

			myAutoComplete.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View arg1,
						int pos, long id) {
					RelativeLayout rl = (RelativeLayout) arg1;
					TextView tv = (TextView) rl.getChildAt(0);
					myAutoComplete.setText(tv.getText().toString());
				}
			});
			// add the listener so it will tries to suggest while the user types
			myAutoComplete
					.addTextChangedListener(new CustomAutoCompleteTextChangedListener(
							this));
			// ObjectItemData has no value at first
			MyObject[] ObjectItemData = new MyObject[0];
			// set the custom ArrayAdapter
			myAdapter = new AutocompleteCustomArrayAdapter(this,
					R.layout.list_view_row, ObjectItemData);
			myAutoComplete.setAdapter(myAdapter);
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertSampleData() {
		// AMADEO R. PEREZ JR. BUILDING
		databaseH.create(new MyObject("AMADEO PEREZ BUILDING"));
		databaseH.create(new MyObject("ROOM 1"));
		databaseH.create(new MyObject("ROOM 2"));
		databaseH.create(new MyObject("ROOM 3"));
		databaseH.create(new MyObject("ROOM 4"));
		databaseH.create(new MyObject("ROOM 5"));
		databaseH.create(new MyObject("ROOM 6"));
		databaseH.create(new MyObject("NSTP ROOM"));
		databaseH.create(new MyObject("AVR/ AUDIO VISUAL ROOM"));

		// ARTS AND SCIENCES BUILDING 2
		// FIRST FLOOR
		databaseH.create(new MyObject("ARTS AND SCIENCES BUILDING 2"));
		databaseH.create(new MyObject("ROOM 8"));
		databaseH.create(new MyObject("ROOM 9"));
		databaseH.create(new MyObject("ROOM 10"));
		databaseH.create(new MyObject("ROOM 11"));
		// SECOND FLOOR
		databaseH.create(new MyObject("ROOM 12"));
		databaseH.create(new MyObject("ROOM 13"));
		databaseH.create(new MyObject("ROOM 14"));
		databaseH.create(new MyObject("ROOM 15"));
		databaseH.create(new MyObject("ROOM 16"));

		// HONASSAN HALL
		databaseH.create(new MyObject("HONNASAN HALL"));

		// ACCOUNTANCY BUILDING
		// SECOND FLOOR
		databaseH.create(new MyObject("ACCOUNTANCY BUILDING"));
		databaseH.create(new MyObject("A17"));
		databaseH.create(new MyObject("A18"));
		databaseH.create(new MyObject("A19"));
		databaseH.create(new MyObject("A20"));

		// BADAR BUILDING
		// FIRST FLOOR
		databaseH.create(new MyObject("BADAR BUILDING"));
		databaseH.create(new MyObject("B21"));
		databaseH.create(new MyObject("B22"));
		// SECOND FLOOR
		databaseH.create(new MyObject("B23"));
		databaseH.create(new MyObject("B24"));

		// ARTS AND SCIENCES BUILDING
		// FIRST FLOOR
		databaseH.create(new MyObject("ARTS AND SCIENCES BUILDING"));
		databaseH.create(new MyObject("29"));
		databaseH.create(new MyObject("30 TYPING LABORATORY"));
		databaseH.create(new MyObject("31"));
		databaseH.create(new MyObject("32 BAKING LABORATORY"));
		databaseH.create(new MyObject("33CCLab2"));
		// SECOND FLOOR
		databaseH.create(new MyObject("34"));
		databaseH.create(new MyObject("35"));
		databaseH.create(new MyObject("36CGLab"));
		databaseH.create(new MyObject("37FBSLab"));
		databaseH.create(new MyObject("38CCLab"));

		// SCIENCE BUILDING
		// FIRST FLOOR
		databaseH.create(new MyObject("SCIENCE BUILDING"));
		databaseH.create(new MyObject("39 SL4"));
		databaseH.create(new MyObject("40 SL5"));
		// SECOND FLOOR
		databaseH.create(new MyObject("41 CLINICAL SKILLS LAB"));
		databaseH.create(new MyObject("42 CLINICAL SKILLS LAB"));
		databaseH.create(new MyObject("43 CLINICAL SKILLS LAB"));

		// UNIVERSITY CANTEEN
		databaseH.create(new MyObject("44"));
		databaseH.create(new MyObject("45"));

		// DEVELOPMENT CENTER
		databaseH.create(new MyObject("DEVELOPMENT CENTER"));

		// READING CENTER
		databaseH.create(new MyObject("READING CENTER"));

		// FOUR ROOMS BUILDING
		databaseH.create(new MyObject("FOUR ROOMS BUILDING"));
		databaseH.create(new MyObject("46 SOCIAL WORK"));
		databaseH.create(new MyObject("ROOM 47A"));
		databaseH.create(new MyObject("ROOM 47B"));
		databaseH.create(new MyObject("ROOM 48"));
		databaseH.create(new MyObject("ROOM 49"));
		databaseH.create(new MyObject("ROOM 50"));
		databaseH.create(new MyObject("ROOM 51"));

		// NEW BUILDING
		// FIRST FLOOR
		databaseH.create(new MyObject("NEW BUILDING"));
		databaseH.create(new MyObject("CHEMICAL LABORATORY"));
		databaseH.create(new MyObject("NB52"));
		databaseH.create(new MyObject("NB53 BioLab"));
		databaseH.create(new MyObject("NB54 CHLab"));
		databaseH.create(new MyObject("NB55 PHLab"));
		// SECOND FLOOR
		databaseH.create(new MyObject("NB56"));
		databaseH.create(new MyObject("NB57"));
		databaseH.create(new MyObject("NB58"));
		databaseH.create(new MyObject("NB59"));
		databaseH.create(new MyObject("NB60"));
		// THIRD FLOOR
		databaseH.create(new MyObject("NB61 COMPLAB"));
		databaseH.create(new MyObject("NB62 COMPLAB"));
		databaseH.create(new MyObject("NB63 COMPLAB"));
		databaseH.create(new MyObject("NB64 COMPLAB"));
		databaseH.create(new MyObject("NB65 COMPLAB"));
		// FOURTH FLOOR
		databaseH.create(new MyObject("NB66"));
		databaseH.create(new MyObject("NB67"));
		databaseH.create(new MyObject("NB68"));
		databaseH.create(new MyObject("NB69"));
		databaseH.create(new MyObject("NB70"));

		// GREENHOME
		databaseH.create(new MyObject("GREENHOME"));

		// GREENHOME 2
		databaseH.create(new MyObject("GREENHOME 2"));

		// ORATA 2
		// FIRST FLOOR
		databaseH.create(new MyObject("ORATA 2 BUILDING"));
		databaseH.create(new MyObject("OB2 80"));
		databaseH.create(new MyObject("OB2 81"));
		databaseH.create(new MyObject("OB2 82"));
		databaseH.create(new MyObject("OB2 83"));
		// SECOND FLOOR
		databaseH.create(new MyObject("OB2 L1"));
		databaseH.create(new MyObject("OB2 L2"));
		databaseH.create(new MyObject("OB2 84A"));
		databaseH.create(new MyObject("OB2 84B"));
		databaseH.create(new MyObject("OB2 85"));
		databaseH.create(new MyObject("OB2 86"));
		databaseH.create(new MyObject("OB2 87A"));
		databaseH.create(new MyObject("OB2 87B"));
		// THIRD FLOOR
		databaseH.create(new MyObject("OB2 L3"));
		databaseH.create(new MyObject("OB2 L4"));
		databaseH.create(new MyObject("OB2 88"));
		databaseH.create(new MyObject("OB2 89"));
		databaseH.create(new MyObject("OB2 90"));
		databaseH.create(new MyObject("OB2 91"));
		databaseH.create(new MyObject("OB2 92"));
		databaseH.create(new MyObject("OB2 93"));

		// ORATA 1
		// THIRD FLOOR
		databaseH.create(new MyObject("ORATA BUILDING"));
		databaseH.create(new MyObject("OB 71"));
		databaseH.create(new MyObject("OB 72"));
		databaseH.create(new MyObject("OB 73"));
		databaseH.create(new MyObject("OB 74"));
		databaseH.create(new MyObject("OB 75"));
		// FOURTH FLOOR
		databaseH.create(new MyObject("OB 76"));
		databaseH.create(new MyObject("OB 77"));
		databaseH.create(new MyObject("OB 78"));
		databaseH.create(new MyObject("OB 79"));
		databaseH.create(new MyObject("OB 80"));

		// AIRPLANE
		databaseH.create(new MyObject("AIRPLANE"));

		// CRIMINALISTIC
		databaseH.create(new MyObject("25 CRIME LAB"));
		databaseH.create(new MyObject("26 CRIME LAB"));
		databaseH.create(new MyObject("27 CRIME LAB"));
		databaseH.create(new MyObject("28 CRIME LAB"));

		// ENGINEERING LABORATORY
		databaseH.create(new MyObject("ENGINEERING LABORATORY"));
		databaseH.create(new MyObject("MP 81"));
		databaseH.create(new MyObject("MP 82"));
		databaseH.create(new MyObject("MP 83"));
		databaseH.create(new MyObject("ME LABORATORY"));

		// GYMNASIUM
		databaseH.create(new MyObject("GYMNASIUM"));
	}

	public void searchAmadeoPerezBuilding() {
		Bitmap amadeobitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdamadeo);
		Bitmap room1bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom1);
		Bitmap room2bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom2);
		Bitmap room3bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom3);
		Bitmap room4bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom4);
		Bitmap room5bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom5);
		Bitmap room6bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom6);
		Bitmap room8bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom8);

		if (myAutoComplete.getText().toString().equals("AMADEO PEREZ BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", amadeobitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 1")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room1bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 2")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room2bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 3")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room3bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 4")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room4bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 5")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room5bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 6")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room6bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 8")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room8bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"AMADEO R. PEREZ JR. BUILDING", Toast.LENGTH_LONG).show();
			// done
		}
	}

	public void searchHonasanHallBuilding() {
		Bitmap honabitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdhonasan);
		if (myAutoComplete.getText().toString().equals("HONNASAN HALL")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", honabitmap);
			startActivity(intent);
			// done
		}
	}

	public void searchArtsAndScienceBuilding2() {
		Bitmap room9bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom9);
		Bitmap room10bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom10);
		Bitmap room11bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom11);
		// Bitmap room12bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room8);//wala pa image
		// Bitmap room13bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room8);//wala pa image
		// Bitmap room14bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room8);//wala pa image
		// Bitmap room15bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room8);//wala pa image
		// Bitmap room16bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room8);//wala pa image
		// Bitmap nstpbitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.nstp);

		if (myAutoComplete.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING 2")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room9bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("ROOM 9")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room9bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING 2", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 10")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room10bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING 2", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 11")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room11bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING 2", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 12")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room12bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("ROOM 13")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room13bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("ROOM 14")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room14bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("ROOM 15")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room15bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("ROOM 16")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room16bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NSTP ROOM")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room11bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchAccountancyBuilding() {
		Bitmap accountancybitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdacb);
		// Bitmap A17bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		// Bitmap A18bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		// Bitmap A19bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		// Bitmap A20bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		if (myAutoComplete.getText().toString().equals("ACCOUNTANCY BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", accountancybitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("A17")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", A17bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("A18")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", A18bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("A19")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", A19bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("A20")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", A20bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchBadarBuilding() {
		Bitmap badarbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdbadar);
		// Bitmap B21bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		// Bitmap B22bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		Bitmap B23bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmb23);
		Bitmap B24bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmb24);
		if (myAutoComplete.getText().toString().equals("BADAR BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", badarbitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("B21")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", B21bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("B22")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", B22bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("B23")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", B23bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "BADAR BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("B24")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", B24bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "BADAR BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		}
	}

	public void searchArtsAndScienceBuilding() {
		// Bitmap artsbitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		Bitmap room29bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom29);
		Bitmap room30bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmtypingroom);
		Bitmap room31bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom31);
		Bitmap bakingbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmbaking);
		Bitmap commercialbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmcommercial);
		// Bitmap room34bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room34);
		// Bitmap room35bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room35);
		// Bitmap room36bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room36);
		// Bitmap room37bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room37);
		// Bitmap room38bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.room38);
		if (myAutoComplete.getText().toString()
				.equals("ARTS AND SCIENCES BUILDING")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", artsbitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("29")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room29bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString()
				.equals("30 TYPING LABORATORY")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room30bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("31")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room31bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString()
				.equals("32 BAKING LABORATORY")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", bakingbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("33CCLab2")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", commercialbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(),
					"ARTS AND SCIENCES BUILDING", Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("34")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room34bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("35")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room35bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("36CGLab")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room36bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("37FBSLab")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room37bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("38CCLab")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", room38bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchScienceBuilding() {
		Bitmap sciencebitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdscien);
		if (myAutoComplete.getText().toString().equals("SCIENCE BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", sciencebitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("39 SL4")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("40 SL5")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString()
				.equals("41 CLINICAL SKILLS LAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString()
				.equals("42 CLINICAL SKILLS LAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString()
				.equals("43 CLINICAL SKILLS LAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchRooms44_45() {
		// Bitmap NB61bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.ic_launcher);
		if (myAutoComplete.getText().toString().equals("44")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("45")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchDevRead() {
		Bitmap readbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdreading);
		if (myAutoComplete.getText().toString().equals("READING CENTER")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", readbitmap);
			startActivity(intent);
			// done
		}
	}

	public void searchFourRoomsBuilding() {
		Bitmap fourbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdfour);
		Bitmap room48bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom48);
		Bitmap room47abitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom47a);
		Bitmap room47bbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom47b);
		Bitmap room49bbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmmaproom49);
		Bitmap room50bbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmmaproom50);
		Bitmap room51bbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmmaproom51);
		Bitmap socialbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmsocialworks);
		if (myAutoComplete.getText().toString().equals("FOUR ROOMS BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", fourbitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 48")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room48bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 49")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room49bbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 50")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room50bbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 51")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room51bbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 47B")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room47bbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("ROOM 47A")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room47abitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("46 SOCIAL WORK")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", socialbitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "FOUR ROOMS BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		}
	}

	public void searchNewBuilding() {
		Bitmap newbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdnb);
		// Bitmap chemicalbitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.chemicallab);
		Bitmap nb55bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmpharmlab);
		Bitmap nb54bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmchemistrylab);
		if (myAutoComplete.getText().toString().equals("NEW BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", newbitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString()
				.equals("CHEMICAL LABORATORY")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", nb55bitmap);
			startActivity(intent);
		} else if (myAutoComplete.getText().toString().equals("NB52")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB53 BioLab")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB54 CHLab")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", nb54bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "NEW BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("NB55 PHLab")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", nb55bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "NEW BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("NB56")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB57")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB58")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB59")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB60")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB61 COMPLAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB62 COMPLAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB63 COMPLAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB64 COMPLAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB65 COMPLAB")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB66")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB67")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB68")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB69")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("NB70")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchGreenHome() {
		Bitmap greenbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdgreen);
		Bitmap green1bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdgreen);

		if (myAutoComplete.getText().toString().equals("GREENHOME")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", greenbitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("GREENHOME 2")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", green1bitmap);
			startActivity(intent);
			// done
		}
	}

	public void searchOrataBuilding() {
		Bitmap obbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdob);
		if (myAutoComplete.getText().toString().equals("ORATA BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", obbitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("OB 71")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 72")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 73")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 74")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 75")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 76")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 77")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 78")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 79")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB 80")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchOrata2Building() {
		Bitmap ob2bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdob2);
		if (myAutoComplete.getText().toString().equals("ORATA 2 BUILDING")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", ob2bitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("OB2 80")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 81")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 82")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 83")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// /intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 L1")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 L2")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 84A")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 84B")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 85")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 86")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 87A")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 87B")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 L3")) {
			// /Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 L4")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 88")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 89")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 90")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 91")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 92")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("OB2 93")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchAirplane() {
		Bitmap planebitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdplane);
		if (myAutoComplete.getText().toString().equals("AIRPLANE")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", planebitmap);
			startActivity(intent);
		}
	}

	public void searchAVR() {
		Bitmap avrbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdavr);

		if (myAutoComplete.getText().toString()
				.equals("AVR/ AUDIO VISUAL ROOM")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", avrbitmap);
			startActivity(intent);
		}
	}

	public void searchCrime() {
		Bitmap room25bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom25);
		Bitmap room26bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom26);
		Bitmap room27bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom27);
		Bitmap room28bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmroom28);

		if (myAutoComplete.getText().toString().equals("25 CRIME LAB")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room25bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "CRIMINALISTIC BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("26 CRIME LAB")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room26bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "CRIMINALISTIC BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("27 CRIME LAB")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room27bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "CRIMINALISTIC BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		} else if (myAutoComplete.getText().toString().equals("28 CRIME LAB")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", room28bitmap);
			startActivity(intent);
			Toast.makeText(getApplicationContext(), "CRIMINALISTIC BUILDING",
					Toast.LENGTH_LONG).show();
			// done
		}
	}

	public void searchEngineeringLab() {
		Bitmap engibitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.rmengineerlab);

		if (myAutoComplete.getText().toString()
				.equals("ENGINEERING LABORATORY")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", engibitmap);
			startActivity(intent);
			// done
		} else if (myAutoComplete.getText().toString().equals("MP 81")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("MP 82")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("MP 83")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		} else if (myAutoComplete.getText().toString().equals("ME LABORATORY")) {
			// Intent intent = new Intent();
			// intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			// intent.putExtra("Bitmap", NB61bitmap);
			// startActivity(intent);
			Toast.makeText(getApplicationContext(), "no location yet",
					Toast.LENGTH_LONG).show();
		}
	}

	public void searchGym() {
		Bitmap gymbitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.bdgym);

		if (myAutoComplete.getText().toString().equals("GYMNASIUM")) {
			Intent intent = new Intent();
			intent.setClass(LocationCampus.this, ImageViewingLocation.class);
			intent.putExtra("Bitmap", gymbitmap);
			startActivity(intent);
		}
	}
}