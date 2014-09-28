package edu.ucuccs.ucumycampus;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AutocompleteCustomArrayAdapterD extends ArrayAdapter<MyObjectD> {

	public class DBAdapter {

	}

	final String TAG = "AutocompleteCustomArrayAdapterD.java";

	Context mContextD;
	int layoutResourceIdD;
	MyObjectD data[] = null;

	public AutocompleteCustomArrayAdapterD(Context mContextD,
			int layoutResourceIdD, MyObjectD[] data) {

		super(mContextD, layoutResourceIdD, data);

		this.layoutResourceIdD = layoutResourceIdD;
		this.mContextD = mContextD;
		this.data = data;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		try {

			/*
			 * The convertView argument is essentially a "ScrapView" as
			 * described is Lucas post
			 * http://lucasr.org/2012/04/05/performance-tips
			 * -for-androids-listview/ It will have a non-null value when
			 * ListView is asking you recycle the row layout. So, when
			 * convertView is not null, you should simply update its contents
			 * instead of inflating a new row layout.
			 */
			if (convertView == null) {
				// inflate the layout
				LayoutInflater inflater = ((DirectionCampus) mContextD)
						.getLayoutInflater();

				convertView = inflater.inflate(layoutResourceIdD, parent,
						false);

			}

			// object item based on the position
			MyObjectD objectItemD = data[position];

			// get the TextView and then set the text (item name) and tag (item
			// ID) values
			TextView textViewItemD = (TextView) convertView
					.findViewById(R.id.textViewItemD);
			textViewItemD.setText(objectItemD.objectNameD);

			
			TextView textViewItemD1 = (TextView) convertView
					.findViewById(R.id.textViewItemD1);
			textViewItemD1.setText(objectItemD.objectNameD);
			
			// in case you want to add some style, you can do something like:
			textViewItemD.setBackgroundColor(Color.BLUE);
			textViewItemD.setTextColor(Color.WHITE);
			
			textViewItemD1.setBackgroundColor(Color.BLUE);
			textViewItemD1.setTextColor(Color.WHITE);

			// #3C88FA

			// CYAN

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return convertView;

	}
}