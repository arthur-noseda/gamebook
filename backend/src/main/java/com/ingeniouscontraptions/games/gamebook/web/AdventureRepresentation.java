package com.ingeniouscontraptions.games.gamebook.web;

import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.encounter.Encounter;

import java.util.List;
import java.util.stream.Collectors;

public class AdventureRepresentation {

    private final Adventure adventure;

    public AdventureRepresentation(Adventure adventure) {
        this.adventure = adventure;
    }

    public String getEntryNumber() {
        return adventure.getEntryNumber().toString();
    }

    public String getText() {
        return adventure.getText();
    }

    public HeroRepresentation getHero() {
        return new HeroRepresentation(adventure.getHero());
    }

    public Monster getMonster() {
        return adventure.getMonster();
    }

    public Encounter getEncounter() {
        return adventure.getEncounter();
    }

    public List<ActionRepresentation> getActions() {
        return adventure.getActions().stream()
                .filter(a -> a.isAllowed(adventure))
                .map(ActionRepresentation::new)
                .collect(Collectors.toList());
    }

}
