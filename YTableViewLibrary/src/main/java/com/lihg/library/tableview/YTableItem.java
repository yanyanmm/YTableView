package com.lihg.library.tableview;

public class YTableItem {

    private int imageResId;
    private int textResId;
    private String text;

    public YTableItem(int imageResId) {
        this.imageResId = imageResId;
    }

    public YTableItem(int imageResId, int textResId) {
        this.imageResId = imageResId;
        this.textResId = textResId;
    }

    public YTableItem(int imageResId, String text) {
        this.imageResId = imageResId;
        this.text = text;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getTextResId() {
        return textResId;
    }

    public String getText() {
        return text;
    }
}
