package com.lihg.library.tableview;

import android.graphics.Color;

public class YTableItemAttr {

    private int textSize;
    private int textMarginTop;
    private int textColor;
    private int imageWidth;
    private int imageHeight;

    public YTableItemAttr() {
        this.textSize = 10;
        this.textMarginTop = 3;
        this.textColor = Color.BLACK;
        this.imageWidth = -2;
        this.imageHeight = -2;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    public int getTextMarginTop() {
        return textMarginTop;
    }

    public void setTextMarginTop(int textMarginTop) {
        this.textMarginTop = textMarginTop;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }
}
