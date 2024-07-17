package edu.csueb.android.zoodirectory;

import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private String description;
    private int thumbnail;
    private int image;

    public Animal(String name, String description, int thumbnail, int image) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public int getImage() {
        return image;
    }
}
