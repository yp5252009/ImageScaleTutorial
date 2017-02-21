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
		if (attrs != null) {
			TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.AlignedImageView, 0, 0);
			try {
				alignType = AlignType.values()[(typedArray.getInt(R.styleable.AlignedImageView_alignType, AlignType.TOP.nativeInt))];
			}finally {
				typedArray.recycle();
			}
		}
	}

	/**
	 *
	 * @param alignType left, top, right or bottom, default is top
	 */
	public void setAlignType(AlignType alignType) {
		this.alignType = alignType;
		requestLayout();
		invalidate();
	}

	@Override
	protected boolean setFrame(int l, int t, int r, int b) {
		boolean changed = super.setFrame(l, t, r, b);
		if (getScaleType() == ScaleType.MATRIX) transformMatrix();
		return changed;
	}

	private void transformMatrix() {
		Matrix matrix = getImageMatrix();
		matrix.reset();
		float h = getHeight();
		float w = getWidth();
		float ch = getDrawable().getIntrinsicHeight();
		float cw = getDrawable().getIntrinsicWidth();
		float widthScaleFactor = w / cw;
		float heightScaleFactor = h / ch;
		if (alignType == AlignType.LEFT) {
			matrix.postScale(heightScaleFactor, heightScaleFactor, 0, 0);
		} else if (alignType == AlignType.RIGHT) {
			matrix.postTranslate(w - cw, 0);
			matrix.postScale(heightScaleFactor, heightScaleFactor, w, 0);
		} else if (alignType == AlignType.BOTTOM) {
			matrix.postTranslate(0, h - ch);
			matrix.postScale(widthScaleFactor, widthScaleFactor, 0, h);
		} else { //default is top
			matrix.postScale(widthScaleFactor, widthScaleFactor, 0, 0);
		}
		setImageMatrix(matrix);
	}

	public enum AlignType {
		LEFT(0),
		TOP(1),
		RIGHT(2),
		BOTTOM(3);

		AlignType(int ni) {
			nativeInt = ni;
		}
		final int nativeInt;
	}

}
