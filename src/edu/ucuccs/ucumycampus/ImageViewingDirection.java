package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ImageViewingDirection extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		 Bitmap bitmap1 = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
		  

			setContentView(R.layout.image_viewing_direction);
		  ImageView viewBitmap1 = (ImageView)findViewById(R.id.bitmapview1);
		  
		  viewBitmap1.setImageBitmap(bitmap1);
		  
		 }
}
