package com.example.crypto;

import android.widget.ImageView;

public class ParseItem {
    private String imageurl;
    private String nameofcurrency;
    private String value;

    public String getImageurl(ImageView icon) {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getNameofcurrency() {
        return nameofcurrency;
    }

    public void setNameofcurrency(String nameofcurrency) {
        this.nameofcurrency = nameofcurrency;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ParseItem(String imageurl, String nameofcurrency, String value) {
        this.imageurl = imageurl;
        this.nameofcurrency = nameofcurrency;
        this.value = value;
    }

    public ParseItem() {
    }
}
