package org.example.flash_cards;

public class Entry {
    //fields
    private String English;
    private String German;
    private String Polish;

    //constructor
    public Entry(String eng, String ger, String pol) {
        English = eng;
        German = ger;
        Polish = pol;
    }

    //getters
    public String getEnglish() {
        return English;
    }

    public String getGerman() {
        return German;
    }

    public String getPolish() {
        return Polish;
    }

    //setters
    public void setEnglish(String english) {
        English = english;
    }

    public void setGerman(String german) {
        German = german;
    }

    public void setPolish(String polish) {
        Polish = polish;
    }
}
