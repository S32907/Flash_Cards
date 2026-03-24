package org.example.flash_cards;


import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.Scanner;

@Controller
public class FlashcardsController {

    //fields
    private final FileService fileService;

    private final EntryRepository repository;

    private final DisplayService displayService;

    public FlashcardsController(EntryRepository repository, DisplayService displayService, FileService fileService) {
        this.repository = repository;
        this.displayService = displayService;
        this.fileService = fileService;
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("================");
            System.out.println("1. Add word");
            System.out.println("2. Show all");
            System.out.println("3. Test");
            System.out.println("0. Exit");
            System.out.println("================");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addWord(scanner);
                case 2 -> showAll();
                case 3 -> test(scanner);
                case 0 -> {
                    fileService.saveToFile();
                    System.exit(0);
                }
            }
        }
    }

    private void addWord(Scanner scanner) {
        System.out.println("English:");
        String en = scanner.nextLine();

        System.out.println("German:");
        String ge = scanner.nextLine();

        System.out.println("Polish:");
        String pl = scanner.nextLine();

        repository.add(new Entry(en, ge, pl));
    }

    private void showAll() {
        System.out.println("English German Polish");
        repository.findAll().forEach(e ->
                System.out.println(
                     displayService.format(e.getEnglish()) + " --- " +
                     displayService.format(e.getGerman()) + " --- " +
                     displayService.format(e.getPolish())
                )
        );
    }

    private void test(Scanner scanner) {

            Entry entry = repository.randomEntry();
            System.out.println("Translate: " + displayService.format(entry.getEnglish()));

            String ge = scanner.nextLine();
            String pl = scanner.nextLine();

            if (ge.equalsIgnoreCase(entry.getGerman()) &&
                    pl.equalsIgnoreCase(entry.getPolish())) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
    }
}