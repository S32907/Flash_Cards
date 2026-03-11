package com.example.tpo_lab2;

public class Entry {
    private String English;
    private String Polish;
    private String German;


    public Entry(String English, String Polish, String German) {
        this.English = English;
        this.Polish = Polish;
        this.German = German;
    }


    public String getEnglish() {
        return English;
    }

    public String getPolish() {
        return Polish;
    }

    public String getGerman() {
        return German;
    }
}
