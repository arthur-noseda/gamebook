package com.ingeniouscontraptions.games.gamebook.domain.die;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.notNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordingDie implements Die {

    private final Die die;

    private final List<Integer> rolls;

    public RecordingDie(Die die) {
        this.die = notNull(die, "die");
        rolls = new ArrayList<>();
    }

    public int roll() {
        int roll = die.roll();
        rolls.add(roll);
        return roll;
    }

    public List<Integer> getRolls() {
        return Collections.unmodifiableList(rolls);
    }

    public void reset() {
        rolls.clear();
    }

}
