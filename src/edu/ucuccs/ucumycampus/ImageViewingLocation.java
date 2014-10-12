package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewingLocation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
		  

			setContentView(R.layout.image_viewing_location);
		  ImageView viewBitmap = (ImageView)findViewById(R.id.bitmapview);
		  
		  viewBitmap.setImageBitmap(bitmap);
		  
		 }
}
