package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class History extends Activity {
Button btnHistoryLoc, btnHistoryDir;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_history);
		
		btnHistoryLoc=(Button)findViewById(R.id.btnHistoryLoc);
		
		btnHistoryDir=(Button)findViewById(R.id.btnHistoryDir);
		
		btnHistoryLoc.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent HistoryLocGo=new Intent (History.this, HistoryCampus.class);
				startActivity(HistoryLocGo);
			}});
		
		btnHistoryDir.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent HistoryDirGo=new Intent (History.this, DirectionHistory.class);
				startActivity(HistoryDirGo);
			}});
	}

	
}
