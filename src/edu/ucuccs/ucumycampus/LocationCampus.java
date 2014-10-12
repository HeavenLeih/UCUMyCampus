package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
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

					if (myAutoComplete.getText().toString().equals(null)) {
						Toast.makeText(getApplicationContext(),
								"please select", Toast.LENGTH_LONG).show();

					}

					else {
						dbcon.open();

						long consave1 = dbcon.method_savecon(myAutoComplete
								.getText().toString());

						if (consave1 > 0) {

							Toast.makeText(getApplicationContext(),
									"SAVED IN HISTORY", Toast.LENGTH_LONG)
									.show();

							if (myAutoComplete.getText().toString()
									.equals("HONNASAN HALL")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this,
										HonnasanHallCampus.class);
								startActivity(HonnasanGo);
								// //////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("AMADEO PEREZ BUILDING")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this, APBuilding.class);
								startActivity(HonnasanGo);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 1")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room1.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 2")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room2.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 3")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room3.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 4")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room4.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 5")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room5.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 6")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room6.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 8")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room8.class);
								startActivity(Room1Go);
								// ////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("ARTS AND SCIENCES BUILDING 2")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, ASBuilding2.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 9")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room9.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 10")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room10.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 11")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room11.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 12")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room12.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 13")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room13.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 14")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room14.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 15")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room15.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 16")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room16.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NSTP ROOM")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, NSTP_ROOM.class);
								startActivity(Room1Go);
								// /////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("ACCOUNTANCY BUILDING")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this,
										AccountncyBuilding.class);
								startActivity(HonnasanGo);
							} else if (myAutoComplete.getText().toString()
									.equals("A17")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this, Room17A.class);
								startActivity(HonnasanGo);
							} else if (myAutoComplete.getText().toString()
									.equals("A18")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this, Room18A.class);
								startActivity(HonnasanGo);
							} else if (myAutoComplete.getText().toString()
									.equals("A19")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this, Room19A.class);
								startActivity(HonnasanGo);
							} else if (myAutoComplete.getText().toString()
									.equals("A20")) {
								Intent HonnasanGo = new Intent(
										LocationCampus.this, Room20A.class);
								startActivity(HonnasanGo);
								// //////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("BADAR BUILDING")) {
								Intent BadarGo = new Intent(
										LocationCampus.this,
										BadarBuildingCampus.class);
								startActivity(BadarGo);
							} else if (myAutoComplete.getText().toString()
									.equals("B21")) {
								Intent BadarGo = new Intent(
										LocationCampus.this, Room21.class);
								startActivity(BadarGo);
							} else if (myAutoComplete.getText().toString()
									.equals("B22")) {
								Intent BadarGo = new Intent(
										LocationCampus.this, Room22.class);
								startActivity(BadarGo);
							} else if (myAutoComplete.getText().toString()
									.equals("B23")) {
								Intent BadarGo = new Intent(
										LocationCampus.this, Room23.class);
								startActivity(BadarGo);
							} else if (myAutoComplete.getText().toString()
									.equals("B24")) {
								Intent BadarGo = new Intent(
										LocationCampus.this, Room24.class);
								startActivity(BadarGo);
								// ///////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("ARTS AND SCIENCES BUILDING")) {
								Intent NewBuildingGo = new Intent(
										LocationCampus.this, ASBuilding.class);
								startActivity(NewBuildingGo);
							} else if (myAutoComplete.getText().toString()
									.equals("29")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room29.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("30 TYPING LABORATORY")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, TypingRoom.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("31")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room31.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("32 BAKING LABORATORY")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Baking_Room.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("33CCLab2")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										CommercialCooking.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("34")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room34.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("35")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room35.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("36CGLab")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room36.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("37FBSLab")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room37.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("38CCLab")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room38.class);
								startActivity(Room1Go);
								// //////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("SCIENCE BUILDING")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this,
										ScienceBuilding.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("39 SL4")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room39.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("40 SL5")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room40.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("41 CLINICAL SKILLS LAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room41.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("42 CLINICAL SKILLS LAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room42.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("43 CLINICAL SKILLS LAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room43.class);
								startActivity(Orata2Go);
								// ////////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("44")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room44.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("45")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Room45.class);
								startActivity(Orata2Go);
								// ///////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("DEVELOPMENT CENTER")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, DevCenter.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("READING CENTER")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, ReadCenter.class);
								startActivity(Orata2Go);
								// /////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("FOUR ROOMS BUILDING")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										FourRoomBuilding.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 48")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room48.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 49")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room49.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 50")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room50.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 51")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room51.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 47B")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room47B.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ROOM 47A")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room47A.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("46 SOCIAL WORK")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, SocialWork.class);
								startActivity(Room1Go);
								// /////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("NEW BUILDING")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this,
										NewBuildingCampus.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("CHEMICAL LABORATORY")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, ChemicalLaboratory.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB52")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb52.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB53 BioLab")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb53.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB54 CHLab")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb54.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB55 PHLab")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb55.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB56")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb56.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB57")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb57.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB58")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb58.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB59")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb59.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB60")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb60.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB61 COMPLAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb61.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB62 COMPLAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb62.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB63 COMPLAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb63.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB64 COMPLAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb64.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB65 COMPLAB")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb65.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB66")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb66.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB67")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb67.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB68")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb68.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB69")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb69.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("NB70")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Nb70.class);
								startActivity(Orata2Go);
								// ////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("GREENHOME")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, GreenHome.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("GREENHOME 2")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, GreenHome2.class);
								startActivity(Room1Go);
								// ///////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("ORATA BUILDING")) {
								Intent Orata1Go = new Intent(
										LocationCampus.this,
										Orata1Building.class);
								startActivity(Orata1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 71")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob71.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 72")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob72.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 73")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob73.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 74")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob74.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 75")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob75.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 76")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob76.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 77")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob77.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 78")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob78.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 79")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob79.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB 80")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob80.class);
								startActivity(Orata2Go);
								// //////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("ORATA 2 BUILDING")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this,
										Orata2Building.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 80")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob280.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 81")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob281.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 82")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob282.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 83")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob283.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 L1")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob2L1.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 L2")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob2L2.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 84A")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob284A.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 84B")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob284B.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 85")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob285.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 86")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob286.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 87A")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob287A.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 87B")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob287B.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 L3")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob2L3.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 L4")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob2L4.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 88")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob288.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 89")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob289.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 90")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob290.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 91")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob291.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 92")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob292.class);
								startActivity(Orata2Go);
							} else if (myAutoComplete.getText().toString()
									.equals("OB2 93")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Ob293.class);
								startActivity(Orata2Go);
								// /////////////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("AIRPLANE")) {
								Intent Orata2Go = new Intent(
										LocationCampus.this, Airplane.class);
								startActivity(Orata2Go);
								// ///////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("AVR/ AUDIO VISUAL ROOM")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										AudioVisualRoom.class);
								startActivity(Room1Go);
								// /////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("25 CRIME LAB")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room25.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("26 CRIME LAB")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room26.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("27 CRIME LAB")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room27.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("28 CRIME LAB")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Room28.class);
								startActivity(Room1Go);
								// ///////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("ENGINEERING LABORATORY")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, EngLab.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("MP 81")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										MP81.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("MP 82")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										MP82.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("MP 83")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										MP83.class);
								startActivity(Room1Go);
							} else if (myAutoComplete.getText().toString()
									.equals("ME LABORATORY")) {
								Intent Room1Go = new Intent(
										LocationCampus.this,
										MELab.class);
								startActivity(Room1Go);
								// ////////////////////////////////////////////////////////////
							} else if (myAutoComplete.getText().toString()
									.equals("GYMNASIUM")) {
								Intent Room1Go = new Intent(
										LocationCampus.this, Gymnasium.class);
								startActivity(Room1Go);
							}
						} else {
							Toast.makeText(getApplicationContext(),
									"NOT SAVED", Toast.LENGTH_LONG).show();
						}
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
}