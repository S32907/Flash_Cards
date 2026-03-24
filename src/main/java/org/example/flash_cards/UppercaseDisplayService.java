package org.example.flash_cards;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("upper")
public class UppercaseDisplayService implements DisplayService {

    @Override
    public String format(String text) {
        return text.toUpperCase();
    }
}