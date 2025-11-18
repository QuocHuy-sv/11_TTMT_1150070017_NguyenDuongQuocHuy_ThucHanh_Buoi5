package com.example.nguyenduongquochuylab;

public class OsItem {
    private String name;
    private String description;
    private int iconResId;

    public OsItem(String name, String description, int iconResId) {
        this.name = name;
        this.description = description;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getIconResId() {
        return iconResId;
    }
}
