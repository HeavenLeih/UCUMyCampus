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
					
				
					else{
						dbcon.open();

						long consave1 = dbcon.method_savecon(myAutoComplete
								.getText().toString());
					 if (consave1 > 0) {

						Toast.makeText(getApplicationContext(),
								"SAVED IN HISTORY", Toast.LENGTH_LONG).show();
						// ////////////////////////////////BUILDINGS INTENT
						if (myAutoComplete.getText().toString()
								.equals("HONNASAN HALL")) {
							Intent HonnasanGo = new Intent(LocationCampus.this,
									HonnasanHallCampus.class);
							startActivity(HonnasanGo);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 17A")) {
							Intent HonnasanGo = new Intent(LocationCampus.this,
									Room17A.class);
							startActivity(HonnasanGo);

						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 18A")) {
							Intent HonnasanGo = new Intent(LocationCampus.this,
									Room18A.class);
							startActivity(HonnasanGo);

						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 19A")) {
							Intent HonnasanGo = new Intent(LocationCampus.this,
									Room19A.class);
							startActivity(HonnasanGo);

						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 20A")) {
							Intent HonnasanGo = new Intent(LocationCampus.this,
									Room20A.class);
							startActivity(HonnasanGo);

							// ////END OF HONNASAN ROOM

							// ///BADAR BUILDING
						} else if (myAutoComplete.getText().toString()
								.equals("BADAR BUILDING")) {
							Intent BadarGo = new Intent(LocationCampus.this,
									BadarBuildingCampus.class);
							startActivity(BadarGo);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 21")) {
							Intent BadarGo = new Intent(LocationCampus.this,
									Room21.class);
							startActivity(BadarGo);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 22")) {
							Intent BadarGo = new Intent(LocationCampus.this,
									Room22.class);
							startActivity(BadarGo);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 23")) {
							Intent BadarGo = new Intent(LocationCampus.this,
									Room23.class);
							startActivity(BadarGo);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 24")) {
							Intent BadarGo = new Intent(LocationCampus.this,
									Room24.class);
							startActivity(BadarGo);
						} // //END OF BADAR BUILDING
						else if (myAutoComplete.getText().toString()
								.equals("NEW BUILDING")) {
							Intent NewBuildingGo = new Intent(
									LocationCampus.this,
									NewBuildingCampus.class);
							startActivity(NewBuildingGo);
						}
						// FIRS FLOOR NEW BUILDING
						else if (myAutoComplete.getText().toString()
								.equals("NB 51")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb51.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 52")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb52.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 53")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb53.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 54")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb54.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 55")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb55.class);
							startActivity(Orata2Go);
						}// SECOND FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("NB 56")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb56.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 57")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb57.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 58")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb58.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 59")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb59.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 60")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb60.class);
							startActivity(Orata2Go);
						}// THIRD FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("NB61 COMPLAB")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb61.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB62 COMPLAB")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb62.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB63 COMPLAB")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb63.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB64 COMPLAB")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb64.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB65 COMPLAB")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb65.class);
							startActivity(Orata2Go);
						}// FOURTH FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("NB 66")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb66.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 67")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb67.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 68")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb68.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 69")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb69.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NB 70")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Nb70.class);
							startActivity(Orata2Go);
						}// // END OF NB
							// AIRPLAINE
						else if (myAutoComplete.getText().toString()
								.equals("AIRPLANE")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Airplane.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("AP1")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ap1.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("AP2")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ap2.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("AP3")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ap3.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("AP4")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ap4.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("AP5")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ap5.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ORATA 1 BUILDING")) {
							Intent Orata1Go = new Intent(LocationCampus.this,
									Orata1Building.class);
							startActivity(Orata1Go);
						}
						// /THIRD FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("OB 71")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob71.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 72")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob72.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 73")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob73.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 74")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob74.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 75")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob75.class);
							startActivity(Orata2Go);
						}// 4th FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("OB 76")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob76.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 77")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob77.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 78")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob78.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 79")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob79.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB 80")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob80.class);
							startActivity(Orata2Go);
						}
						// END OF ORATA 1
						else if (myAutoComplete.getText().toString()
								.equals("ORATA 2 BUILDING")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Orata2Building.class);
							startActivity(Orata2Go);
						}// FIRST FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("OB2 81")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob281.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 82")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob282.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 83")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob283.class);
							startActivity(Orata2Go);
						}// SECOND FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("OB2 L1")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob2L1.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 L2")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob2L2.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 84A")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob284A.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 84B")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob284B.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 84C")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob284C.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 85")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob285.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 86")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob286.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 87A")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob287A.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 87B")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob287B.class);
							startActivity(Orata2Go);
						}// ORATA 2 .. THIRD FLOOR
						else if (myAutoComplete.getText().toString()
								.equals("OB2 L3")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob2L3.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 88")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob288.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 89")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob289.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 90")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob290.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 91")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob291.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 92")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob292.class);
							startActivity(Orata2Go);
						} else if (myAutoComplete.getText().toString()
								.equals("OB2 93")) {
							Intent Orata2Go = new Intent(LocationCampus.this,
									Ob293.class);
							startActivity(Orata2Go);
						}// /////ENDS OF ORATA 2
							// /////////////////////////////////////MGA ROOMS
							// INTENT
						else if (myAutoComplete.getText().toString()
								.equals("ROOM 1")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room1.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 2")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room2.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 3")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room3.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 4")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room4.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 5")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room5.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 6")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room6.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 7")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room7.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 8")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room8.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 9")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room9.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 10")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room10.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 11")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room11.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 12")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room12.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 13")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room13.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 14")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room14.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 15")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room15.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 16")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room16.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("NSTP ROOM")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									NSTP_ROOM.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("AVR/ AUDIO VISUAL ROOM")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									AudioVisualRoom.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 25")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room25.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 26")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room26.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 27")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room27.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 28")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room28.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 29")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room29.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ACCRE ROOM")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									ACCRE_ROOM.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("TYPING ROOM")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									TypingRoom.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 31")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room31.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("BAKING ROOM")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Baking_Room.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("COMMERCIAL COOKING")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									CommercialCooking.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 48")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room48.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 49")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room49.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 50")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room50.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 51")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room51.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 47B")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room47B.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ROOM 47A")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Room47A.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("SOCIAL WORK")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									SocialWork.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("UCU BOTIKA")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									UcuBotika.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("BIO LABORATORY")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									BioLaboratory.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("CHEMISTRY LABORATORY")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									ChemistryLaboratory.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("CHEMICAL LABORATORY")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									ChemicalLaboratory.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("PHARMACEUTICAL LABORATORY")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									PharmaceuticalLaboratory.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("ENGINEERING LABORATORY")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									EngineeringLaboratory.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("GYMNASIUM")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									Gymnasium.class);
							startActivity(Room1Go);
						} else if (myAutoComplete.getText().toString()
								.equals("GREENHOME")) {
							Intent Room1Go = new Intent(LocationCampus.this,
									GreenHome.class);
							startActivity(Room1Go);
						}
					} else {
						Toast.makeText(getApplicationContext(), "NOT SAVED",
								Toast.LENGTH_LONG).show();
					}}
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
		// CREATE
		// HONNASAN HALL = NOT INCLUDE = GO TO HONNASAN BUILDING AND IT WILL
		// TOAST ONLY THE LOCATION OF A CERTAIN ROOM // DONE
		databaseH.create(new MyObject("ROOM 17A"));
		databaseH.create(new MyObject("ROOM 18A"));
		databaseH.create(new MyObject("ROOM 19A"));
		databaseH.create(new MyObject("ROOM 20A"));
		// BADAR BUILDING // DONE
		databaseH.create(new MyObject("ROOM 21"));
		databaseH.create(new MyObject("ROOM 22"));
		databaseH.create(new MyObject("ROOM 23"));
		databaseH.create(new MyObject("ROOM 24"));
		// ORATA 2
		// first floor// DONE
		databaseH.create(new MyObject("OB2 81"));
		databaseH.create(new MyObject("OB2 82"));
		databaseH.create(new MyObject("OB2 83"));
		// second floor = DONE
		databaseH.create(new MyObject("OB2 L1"));
		databaseH.create(new MyObject("OB2 84A"));
		databaseH.create(new MyObject("OB2 84B"));
		databaseH.create(new MyObject("OB2 84C"));
		databaseH.create(new MyObject("OB2 85"));
		databaseH.create(new MyObject("OB2 86"));
		databaseH.create(new MyObject("OB2 87A"));
		databaseH.create(new MyObject("OB2 87B"));
		databaseH.create(new MyObject("OB2 L2"));
		// third floor == DONE
		databaseH.create(new MyObject("OB2 L3"));
		databaseH.create(new MyObject("OB2 88"));
		databaseH.create(new MyObject("OB2 89"));
		databaseH.create(new MyObject("OB2 90"));
		databaseH.create(new MyObject("OB2 91"));
		databaseH.create(new MyObject("OB2 92"));
		databaseH.create(new MyObject("OB2 93"));
		// ORATA 1
		// third floor == DONE
		databaseH.create(new MyObject("OB 71"));
		databaseH.create(new MyObject("OB 72"));
		databaseH.create(new MyObject("OB 73"));
		databaseH.create(new MyObject("OB 74"));
		databaseH.create(new MyObject("OB 75"));
		// fourth floor == // DONE
		databaseH.create(new MyObject("OB 76"));
		databaseH.create(new MyObject("OB 77"));
		databaseH.create(new MyObject("OB 78"));
		databaseH.create(new MyObject("OB 79"));
		databaseH.create(new MyObject("OB 80"));
		// NEW BUILDING
		// first floor == DONE
		databaseH.create(new MyObject("NB 51"));
		databaseH.create(new MyObject("NB 52"));
		databaseH.create(new MyObject("NB 53"));
		databaseH.create(new MyObject("NB 54"));
		databaseH.create(new MyObject("NB 55"));
		// second floor == DONE
		databaseH.create(new MyObject("NB 56"));
		databaseH.create(new MyObject("NB 57"));
		databaseH.create(new MyObject("NB 58"));
		databaseH.create(new MyObject("NB 59"));
		databaseH.create(new MyObject("NB 60"));
		// third floor == DONE
		databaseH.create(new MyObject("NB61 COMPLAB"));
		databaseH.create(new MyObject("NB62 COMPLAB"));
		databaseH.create(new MyObject("NB63 COMPLAB"));
		databaseH.create(new MyObject("NB64 COMPLAB"));
		databaseH.create(new MyObject("NB65 COMPLAB"));
		// fourth floor = DONE
		databaseH.create(new MyObject("NB 66"));
		databaseH.create(new MyObject("NB 67"));
		databaseH.create(new MyObject("NB 68"));
		databaseH.create(new MyObject("NB 69"));
		databaseH.create(new MyObject("NB 70"));
		// AIRPLANE == DONE
		databaseH.create(new MyObject("AP1"));
		databaseH.create(new MyObject("AP2"));
		databaseH.create(new MyObject("AP3"));
		databaseH.create(new MyObject("AP4"));
		databaseH.create(new MyObject("AP5"));
		// sa may gilid = USE INTENT HERE // DONE
		databaseH.create(new MyObject("ROOM 1"));
		databaseH.create(new MyObject("ROOM 2"));
		databaseH.create(new MyObject("ROOM 3"));
		databaseH.create(new MyObject("ROOM 4"));
		databaseH.create(new MyObject("ROOM 5"));
		databaseH.create(new MyObject("ROOM 6"));
		databaseH.create(new MyObject("ROOM 7"));
		databaseH.create(new MyObject("ROOM 8"));
		databaseH.create(new MyObject("ROOM 9"));
		databaseH.create(new MyObject("ROOM 10"));
		databaseH.create(new MyObject("ROOM 11"));
		databaseH.create(new MyObject("NSTP ROOM"));
		databaseH.create(new MyObject("AVR/ AUDIO VISUAL ROOM"));
		// second floor // DONE
		databaseH.create(new MyObject("ROOM 12"));
		databaseH.create(new MyObject("ROOM 13"));
		databaseH.create(new MyObject("ROOM 14"));
		databaseH.create(new MyObject("ROOM 15"));
		databaseH.create(new MyObject("ROOM 16"));
		// EDUCATION BUILDING // DONE
		databaseH.create(new MyObject("SOCIAL WORK"));
		databaseH.create(new MyObject("ROOM 47A"));
		databaseH.create(new MyObject("ROOM 47B"));
		databaseH.create(new MyObject("ROOM 48"));
		databaseH.create(new MyObject("ROOM 49"));
		databaseH.create(new MyObject("ROOM 50"));
		databaseH.create(new MyObject("ROOM 51"));
		// OTHERS // DONE
		databaseH.create(new MyObject("UCU BOTIKA"));
		databaseH.create(new MyObject("BIO LABORATORY"));
		databaseH.create(new MyObject("CHEMISTRY LABORATORY"));
		databaseH.create(new MyObject("PHARMACEUTICAL LABORATORY"));
		databaseH.create(new MyObject("CHEMICAL LABORATORY"));
		databaseH.create(new MyObject("ENGINEERING LABORATORY"));
		databaseH.create(new MyObject("GREENHOME"));
		// CRIMINALISTIC // DONE
		databaseH.create(new MyObject("ROOM 25"));
		databaseH.create(new MyObject("ROOM 26"));
		databaseH.create(new MyObject("ROOM 27"));
		databaseH.create(new MyObject("ROOM 28"));
		databaseH.create(new MyObject("ROOM 29"));
		databaseH.create(new MyObject("ACCRE ROOM"));
		databaseH.create(new MyObject("TYPING ROOM"));
		databaseH.create(new MyObject("ROOM 31"));
		databaseH.create(new MyObject("BAKING ROOM"));
		databaseH.create(new MyObject("COMMERCIAL COOKING"));
		// BUILDINGS // DONE
		databaseH.create(new MyObject("HONNASAN HALL"));
		databaseH.create(new MyObject("BADAR BUILDING"));
		databaseH.create(new MyObject("ORATA 2 BUILDING"));
		databaseH.create(new MyObject("ORATA 1 BUILDING"));
		databaseH.create(new MyObject("NEW BUILDING"));
		databaseH.create(new MyObject("GYMNASIUM"));
		databaseH.create(new MyObject("AIRPLANE"));
	}
}