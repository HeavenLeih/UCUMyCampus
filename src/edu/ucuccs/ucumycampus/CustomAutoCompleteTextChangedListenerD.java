package edu.ucuccs.ucumycampus;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class CustomAutoCompleteTextChangedListenerD implements TextWatcher {

	public static final String TAG = "CustomAutoCompleteTextChangedListenerD.java";
	Context context;

	public CustomAutoCompleteTextChangedListenerD(Context context) {
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

			DirectionCampus directionCamp = ((DirectionCampus) context);

			// update the adapater
			directionCamp.myAdapterD.notifyDataSetChanged();

			// get suggestions from the database
			MyObjectD[] myObjsD = directionCamp.databaseH.readD(userInput
					.toString());

			// update the adapter
			directionCamp.myAdapterD = new AutocompleteCustomArrayAdapterD(
					directionCamp, R.layout.list_view_row_d, myObjsD);
			directionCamp.myAutoCompleteDir.setAdapter(directionCamp.myAdapterD);

			directionCamp.myAutoCompleteLoc.setAdapter(directionCamp.myAdapterD);

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}