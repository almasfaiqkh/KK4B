package com.xirpl4.project_kk4b.ui.home;

public class DataNote {

    int image;
    String time;
    String title;
    String subtitle;

    public DataNote(int image, String time, String title, String subtitle) {
        this.image = image;
        this.time = time;
        this.title = title;
        this.subtitle = subtitle;
    }

    public int getImage() {
        return image;
    }

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }
}