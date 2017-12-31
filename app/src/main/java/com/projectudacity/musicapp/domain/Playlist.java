package com.projectudacity.musicapp.domain;

/**
 * Created by brunodocarmo on 30/12/17.
 */

public class Playlist {

    private int image;
    private String name;

    @Override
    public String toString() {
        return "Playlist{" + ", name='" + name + '\'' + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
