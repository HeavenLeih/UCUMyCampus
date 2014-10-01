package edu.ucuccs.ucumycampus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
ImageView btnBegin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnBegin=(ImageView) findViewById(R.id.btnBegin);
		
		btnBegin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent menuGo = new Intent (MainActivity.this, MenuCampus.class);
				startActivity(menuGo);
			}});
		
		btnBegin.setImageBitmap(highlightImage(BitmapFactory.decodeResource(getResources(), R.drawable.btnbegin)));
	 }
	 public Bitmap highlightImage(Bitmap src) {
	  // create new bitmap, which will be painted and becomes result image
	  Bitmap bmOut = Bitmap.createBitmap(src.getWidth() + 96, src.getHeight() + 96, Bitmap.Config.ARGB_8888);
	  // setup canvas for painting
	  Canvas canvas = new Canvas(bmOut);
	  // setup default color
	  canvas.drawColor(0, PorterDuff.Mode.CLEAR);
	  // create a blur paint for capturing alpha
	  Paint ptBlur = new Paint();
	  ptBlur.setMaskFilter(new BlurMaskFilter(15, Blur.NORMAL));
	  int[] offsetXY = new int[2];
	  // capture alpha into a bitmap
	  Bitmap bmAlpha = src.extractAlpha(ptBlur, offsetXY);
	  // create a color paint
	  Paint ptAlphaColor = new Paint();
	  ptAlphaColor.setColor(0xFFFFFFFF);
	  // paint color for captured alpha region (bitmap)
	  canvas.drawBitmap(bmAlpha, offsetXY[0], offsetXY[1], ptAlphaColor);
	  // free memory
	  bmAlpha.recycle();
	 
	  // paint the image source
	  canvas.drawBitmap(src, 0, 0, null);
	 
	  // return out final image
	  return bmOut;
	 
	 }
		
		
	


}
