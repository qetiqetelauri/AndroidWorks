package com.example.work_6;

public class Program {
    private String ImageLink,Progr;

    public Program() {
    }

    public Program(String imageLink, String progr) {
        ImageLink = imageLink;
        Progr = progr;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }

    public String getProgr() {
        return Progr;
    }

    public void setProgr(String progr) {
        Progr = progr;
    }
}
