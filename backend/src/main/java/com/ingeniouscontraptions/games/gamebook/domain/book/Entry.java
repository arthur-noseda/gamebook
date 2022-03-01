package com.ingeniouscontraptions.games.gamebook.domain.book;

import java.util.List;

import com.ingeniouscontraptions.games.gamebook.domain.Monster;

public class Entry {

    private final EntryNumber number;

    private final String text;

    private final Monster monster;

    private final List<Action> actions;

    private Entry(EntryNumber number, String text, Monster monster, List<Action> actions) {
        this.number = number;
        this.text = text;
        this.monster = monster;
        this.actions = actions;
    }

    public static Entry of(EntryNumber number, String text) {
        return new Entry(number, text, null, List.of());
    }

    public static Entry of(EntryNumber number, String text, Action action) {
        return new Entry(number, text, null, List.of(action));
    }

    public static Entry of(EntryNumber number, String text, List<Action> actions) {
        return new Entry(number, text, null, actions);
    }

    public static Entry of(EntryNumber number, String text, Monster monster, List<Action> actions) {
        return new Entry(number, text, monster, actions);
    }

    public EntryNumber getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public List<Action> getActions() {
        return actions;
    }

    public Monster getMonster() {
        return monster;
    }

}
