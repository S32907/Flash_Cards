package org.example.flash_cards;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService {

    private final EntryRepository entryRepository;

    @Value("${pl.edu.pja.tpo02.filename}")
    private String fileName;

    public FileService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    @PostConstruct
    public void init() {
        try {
            loadFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
        try(FileWriter writer = new FileWriter(fileName)){
            for (Entry entry : entryRepository.findAll()) {
                writer.write(entry.getEnglish() + "," + entry.getGerman() + "," + entry.getPolish());
                writer.write(System.lineSeparator());
            }
        }catch (IOException e) {
            throw new RuntimeException("Error occurred while saving file", e);
        }
    }


}
