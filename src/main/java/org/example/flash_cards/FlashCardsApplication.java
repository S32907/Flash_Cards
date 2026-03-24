package org.example.flash_cards;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@PropertySource("classpath:config.properties")
public class FlashCardsApplication implements CommandLineRunner {

    private final FlashcardsController controller;

    public FlashCardsApplication(FlashcardsController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(FlashCardsApplication.class, args);
    }

    @Override
    public void run(String... args) throws IOException {
        controller.start();

    }
}
