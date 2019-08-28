package com.lihg.library.tableview;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class YTableItemView extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;

    public YTableItemView(Context context) {
        super(context);
        this.setOrientation(VERTICAL);
        this.setGravity(Gravity.CENTER);
        this.setClickable(true);
        this.setClipChildren(false);

        mImageView = new ImageView(context);
        mImageView.setLayoutParams(new LayoutParams(-2, -2));
        this.addView(mImageView);

        mTextView = new TextView(context);
        mTextView.setLayoutParams(new LayoutParams(-2, -2));
        mTextView.setSingleLine();
        this.addView(mTextView);
    }

    public void setTableItem(YTableItem tableItem, YTableItemAttr tableItemAttr) {
        if (tableItem.getImageResId() != 0) {
            mImageView.setImageResource(tableItem.getImageResId());
        }
        mImageView.setLayoutParams(new LayoutParams(tableItemAttr.getImageWidth(), tableItemAttr.getImageHeight()));
        LayoutParams params = new LayoutParams(-2, -2);
        params.topMargin = tableItemAttr.getTextMarginTop();
        params.leftMargin = params.rightMargin = params.topMargin;
        mTextView.setLayoutParams(params);
        mTextView.setTextColor(tableItemAttr.getTextColor());
        mTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, tableItemAttr.getTextSize());
        if (tableItem.getTextResId() != 0) {
            mTextView.setText(tableItem.getTextResId());
        }
        if (tableItem.getText() != null) {
            mTextView.setText(tableItem.getText());
        }
    }

    public ImageView getImageView() {
        return mImageView;
    }

    public TextView getTextView() {
        return mTextView;
    }
}
