package com.example.nguyenduongquochuylab;

public class Contributor {
    private String name;
    private String score;

    public Contributor(String name, String score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
