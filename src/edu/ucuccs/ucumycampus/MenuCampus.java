package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MenuCampus extends Activity {
	ImageView btnLocation, btnMap, btnHistory, btnDirection;
	
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
				Intent locationGo = new Intent(
						MenuCampus.this,
						LocationCampus.class);
				startActivity(locationGo);
			}
		});

		btnMap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent MapGo = new Intent(MenuCampus.this,
						MapCampus.class);
				startActivity(MapGo);
			}
		});

		btnHistory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent HistoryGo = new Intent(
						MenuCampus.this,
						History.class);
				startActivity(HistoryGo);
			}
		});

		btnDirection.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent DirectionGo = new Intent(
						MenuCampus.this,
						DirectionCampus.class);
				startActivity(DirectionGo);
			}
		});
	}
	}
