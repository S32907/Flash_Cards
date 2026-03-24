package org.example.flash_cards;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("lower")
public class LowercaseDisplayService implements DisplayService {

    @Override
    public String format(String text) {
        return text.toLowerCase();
    }
}