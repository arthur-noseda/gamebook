package com.ingeniouscontraptions.games.gamebook.domain.book;

import java.util.List;

import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

public class Adventure {

    private final Hero hero;

    private final Gamebook gamebook;

    private Entry currentEntry;

    private Encounter encounter;

    private Adventure(Hero hero, Gamebook gamebook) {
        this.hero = hero;
        this.gamebook = gamebook;
        turnTo(EntryNumber.of(1));
    }

    public static Adventure start(Hero hero, Gamebook gamebook) {
        return new Adventure(hero, gamebook);
    }

    public Hero getHero() {
        return hero;
    }

    public EntryNumber getEntryNumber() {
        return currentEntry.getNumber();
    }

    public String getText() {
        return currentEntry.getText();
    }

    public void turnTo(EntryNumber number) {
        this.currentEntry = gamebook.findEntry(number);
        encounter = null;
    }

    public List<Action> getActions() {
        return currentEntry.getActions();
    }

    public Monster getMonster() {
        return currentEntry.getMonster();
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

}
