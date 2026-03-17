package org.example.flash_cards;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class EntryRepository {

    private final List<Entry> entries = new ArrayList<>();

    //add new entry to the list
    public void add(Entry entry) {
        entries.add(entry);
    }

    //return list with all entries
    public List<Entry> findAll() {
        return entries;
    }

    //get random entry from the list
    public Entry randomEntry() {
        if (entries.isEmpty()) {
            throw new NoSuchElementException("No entries found");
        }
        return entries.get(new Random().nextInt(entries.size()));
    }

}
