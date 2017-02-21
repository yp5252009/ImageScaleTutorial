package me.ghui.imagescaledemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by ghui on 20/02/2017.
 */

public class AlignedImageView extends ImageView {

	private AlignType alignType;

	public AlignedImageView(Context context) {
		super(context);
		init(context, null);
	}

	public AlignedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public AlignedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet attrs) {
		//default scaleType is matrix
		setScaleType(ScaleType.MATRIX);
		if (attrs != null) {
			TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AlignedImageView, 0, 0);
			try {
				alignType = AlignType.values()[(typedArray.getInt(R.styleable.AlignedImageView_alignType, 0))];
			}finally {
				typedArray.recycle();
			}
		}
	}

	public void setAlignType(AlignType alignType) {
		this.alignType = alignType;
	}

	@Override
	protected boolean setFrame(int l, int t, int r, int b) {
		boolean changed = super.setFrame(l, t, r, b);
		if (getScaleType() == ScaleType.MATRIX && changed) {
			Matrix matrix = getImageMatrix();
			float scaleFactor = getWidth() / (float) getDrawable().getIntrinsicWidth();
			if (alignType == AlignType.TOP) {
				matrix.setScale(scaleFactor, scaleFactor, 0, 0);
			} else if (alignType == AlignType.BOTTOM) {
				matrix.setTranslate(0, getHeight() - getDrawable().getIntrinsicHeight());
//			matrix.setScale(scaleFactor, scaleFactor, 0, getHeight());
				matrix.postScale(scaleFactor, scaleFactor, 0, getHeight());
			}
			setImageMatrix(matrix);
		}
		return changed;
	}

	public enum AlignType {
		TOP(0),
		BOTTOM(1);

		AlignType(int ni) {
			nativeInt = ni;
		}
		final int nativeInt;
	}

}
