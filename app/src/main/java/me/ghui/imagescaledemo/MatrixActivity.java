package me.ghui.imagescaledemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MatrixActivity extends AppCompatActivity {
	private AlignedImageView imgView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_matrix);
		imgView = (AlignedImageView) findViewById(R.id.img);
		imgView.setScaleType(ImageView.ScaleType.MATRIX);
	}

	public void alignBottomWidthMatch(View view) {
		imgView.setAlignType(AlignedImageView.AlignType.BOTTOM);
	}

	public void alignTopWidthMatch(View view) {

	}
}
