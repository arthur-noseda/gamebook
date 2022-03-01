package com.ingeniouscontraptions.games.gamebook.service;

import com.ingeniouscontraptions.games.gamebook.domain.die.Die;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
class DieImpl implements Die {

    private final Random random;

    DieImpl() {
        random = new Random();
    }

    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }

}
