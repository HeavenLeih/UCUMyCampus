package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MenuCampus extends Activity {
	ImageView btnLocation, btnMap, btnHistory, btnDirection;
	private static final int ALERT_DIALOG1Loc = 1;
	private static final int ALERT_DIALOG2Map = 2;
	private static final int ALERT_DIALOG3His = 3;
	private static final int ALERT_DIALOG4Dir = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_menu_campus);

		btnLocation = (ImageView) findViewById(R.id.btnLocation);
		btnMap = (ImageView) findViewById(R.id.btnMap);
		btnHistory = (ImageView) findViewById(R.id.btnHistory);
		btnDirection = (ImageView) findViewById(R.id.btnDirection);

		btnLocation.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(ALERT_DIALOG1Loc);
			}
		});

		btnMap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(ALERT_DIALOG2Map);
			}
		});

		btnHistory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(ALERT_DIALOG3His);
			}
		});

		btnDirection.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(ALERT_DIALOG4Dir);
			}
		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		AlertDialog.Builder builder;
		switch (id) {
		case ALERT_DIALOG1Loc:
			builder = new AlertDialog.Builder(this);
			builder.setMessage(
					"LOCATION\nIt refers to all Classroom and Buildings!\nPress OK to go to the Location")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent locationGo = new Intent(
											MenuCampus.this,
											LocationCampus.class);
									startActivity(locationGo);
								}
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			dialog = builder.create();
			break;
			
		case ALERT_DIALOG2Map:
			builder = new AlertDialog.Builder(this);
			builder.setMessage("MAP\nIt shows the Map of UCU Campus!\nPress OK to go to the Map")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent MapGo = new Intent(MenuCampus.this,
											MapCampus.class);
									startActivity(MapGo);
								}
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									//MenuCampus.this.finish();
									dialog.cancel();
								}
							});
			dialog = builder.create();
			break;
			
		case ALERT_DIALOG3His:
			builder = new AlertDialog.Builder(this);
			builder.setMessage("HISTORY\nIt shows the Map of UCU Campus!\nPress OK to go to History")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent HistoryGo = new Intent(
											MenuCampus.this,
											HistoryCampus.class);
									startActivity(HistoryGo);
								}
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			dialog = builder.create();
			break;

		case ALERT_DIALOG4Dir:
			builder = new AlertDialog.Builder(this);
			builder.setMessage("HISTORY\nIt shows the Map of UCU Campus!\nPress OK to go to Direction")
					.setCancelable(false)
					.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent DirectionGo = new Intent(
											MenuCampus.this,
											DirectionCampus.class);
									startActivity(DirectionGo);
								}
							})
					.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			dialog = builder.create();
			break;

		default:
			dialog = null;
		}
		return dialog;

	}
}
