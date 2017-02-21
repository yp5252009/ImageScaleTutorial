package me.ghui.imagescaledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
	ImageView imgLeft;
	ImageView imgMid;
	ImageView imgRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgLeft = (ImageView) findViewById(R.id.img_left);
		imgMid = (ImageView) findViewById(R.id.img_mid);
		imgRight = (ImageView) findViewById(R.id.img_right);
	}

	public void fitxy(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.FIT_XY);
		imgMid.setScaleType(ImageView.ScaleType.FIT_XY);
		imgRight.setScaleType(ImageView.ScaleType.FIT_XY);
	}

	public void fitStart(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.FIT_START);
		imgMid.setScaleType(ImageView.ScaleType.FIT_START);
		imgRight.setScaleType(ImageView.ScaleType.FIT_START);
	}

	public void fitCenter(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imgMid.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imgRight.setScaleType(ImageView.ScaleType.FIT_CENTER);
	}

	public void fitEnd(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.FIT_END);
		imgMid.setScaleType(ImageView.ScaleType.FIT_END);
		imgRight.setScaleType(ImageView.ScaleType.FIT_END);
	}

	public void center(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.CENTER);
		imgMid.setScaleType(ImageView.ScaleType.CENTER);
		imgRight.setScaleType(ImageView.ScaleType.CENTER);
	}

	public void center_crop(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imgMid.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imgRight.setScaleType(ImageView.ScaleType.CENTER_CROP);
	}

	public void center_inside(View view) {
		imgLeft.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imgMid.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		imgRight.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
	}

	public void matrix(View view) {
		startActivity(new Intent(this, MatrixActivity.class));
	}
}
