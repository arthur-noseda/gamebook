package com.ingeniouscontraptions.games.gamebook.book;

import com.ingeniouscontraptions.games.gamebook.domain.GoldPieces;
import com.ingeniouscontraptions.games.gamebook.domain.Monster;
import com.ingeniouscontraptions.games.gamebook.domain.Score;
import com.ingeniouscontraptions.games.gamebook.domain.action.*;
import com.ingeniouscontraptions.games.gamebook.domain.book.Entry;
import com.ingeniouscontraptions.games.gamebook.domain.book.EntryNumber;
import com.ingeniouscontraptions.games.gamebook.domain.book.Gamebook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class TestFeaturesGamebook implements Gamebook {

    private final List<Entry> entries;

    TestFeaturesGamebook() {
        entries = new ArrayList<>();
        entries.add(Entry.of(EntryNumber.of(1),
                "Fight the ogre",
                new Monster(Score.of(8), Score.of(7)), List.of(StartBattle.INSTANCE, TestLuck.INSTANCE, MakeAdjustments.INSTANCE, NextRound.INSTANCE, Turn.to(EntryNumber.of(2), EntryCleared.INSTANCE))));
        entries.add(Entry.of(EntryNumber.of(2),
                "Pay toll",
                new PayToll(GoldPieces.of(2), EntryNumber.of(3))));
        entries.add(Entry.of(EntryNumber.of(3),
                "Eat provisions?",
                List.of(new EatProvisions(), Turn.to(EntryNumber.of(4)))));
        entries.add(Entry.of(EntryNumber.of(4),
                "Buy provisions?",
                List.of(new BuyProvisions(1, GoldPieces.of(2)), Turn.to(EntryNumber.of(5)))));
        entries.add(Entry.of(EntryNumber.of(5), "Congratulations!"));
    }

    @Override
    public Entry findEntry(EntryNumber number) {
        return entries.stream()
                .filter(s -> s.getNumber().equals(number))
                .findFirst()
                .orElseThrow();
    }

}
