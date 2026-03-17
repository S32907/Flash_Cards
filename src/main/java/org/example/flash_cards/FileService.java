package org.example.flash_cards;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    private EntryRepository entryRepository;
    @Value("${org.example.flash_cards.SaveFile}")
    private String fileName;

    public FileService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public void loadFromFile() throws IOException {
        Files.lines(Paths.get(fileName))
                .map(line -> line.split(","))
                .forEach(parts -> {
                    Entry entry = new Entry(parts[0], parts[1], parts[2]);
                    entryRepository.add(entry);
                });
    }

    public void saveToFile() throws IOException {
        List<Entry> entries = entryRepository.findAll();

        List<String> lines = entries.stream()
                .map(e -> e.getPolish() + "," + e.getEnglish() + "," + e.getGerman())
                .toList();

        Files.write(Paths.get(fileName), lines);
    }

}
