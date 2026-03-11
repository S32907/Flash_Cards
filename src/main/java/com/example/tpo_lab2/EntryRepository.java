package com.example.tpo_lab2;

import java.util.ArrayList;
import java.util.List;

public class EntryRepository {

    private ArrayList<Entry> Words = new ArrayList<>();


    public void addWord(Entry word) {
        Words.add(word);
    }
}
