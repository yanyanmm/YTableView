package com.lihg.library.tableview;

public class YTableItem {

    private int tag;
    private int imageResId;
    private String image;
    private int textResId;
    private String text;

    public YTableItem() {}

    public YTableItem(int tag, int imageResId, int textResId) {
        this.tag = tag;
        this.imageResId = imageResId;
        this.textResId = textResId;
    }


    public YTableItem(int tag, String image, String text) {
        this.tag = tag;
        this.imageResId = imageResId;
        this.image = image;
        this.textResId = textResId;
        this.text = text;
    }

    public YTableItem(int tag, int imageResId, String image, int textResId, String text) {
        this.tag = tag;
        this.imageResId = imageResId;
        this.image = image;
        this.textResId = textResId;
        this.text = text;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
