package edu.ucuccs.ucumycampus;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class CustomAutoCompleteTextChangedListener implements TextWatcher {

	public static final String TAG = "CustomAutoCompleteTextChangedListener.java";
	Context context;

	public CustomAutoCompleteTextChangedListener(Context context) {
		this.context = context;
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence userInput, int start, int before,
			int count) {

		try {

			// if you want to see in the logcat what the user types
			Log.e(TAG, "User input: " + userInput);

			LocationCampus locationCamp = ((LocationCampus) context);

			// update the adapater
			locationCamp.myAdapter.notifyDataSetChanged();

			// get suggestions from the database
			MyObject[] myObjs = locationCamp.databaseH.read(userInput
					.toString());

			// update the adapter
			locationCamp.myAdapter = new AutocompleteCustomArrayAdapter(
					locationCamp, R.layout.list_view_row, myObjs);

			locationCamp.myAutoComplete.setAdapter(locationCamp.myAdapter);

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}