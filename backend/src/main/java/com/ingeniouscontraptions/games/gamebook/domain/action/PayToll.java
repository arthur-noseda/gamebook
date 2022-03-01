package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.GoldPieces;
import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.book.EntryNumber;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class PayToll implements Action {

    private final GoldPieces price;

    private final EntryNumber destination;

    public PayToll(GoldPieces price, EntryNumber destination) {
        this.price = price;
        this.destination = destination;
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        return adventure.getHero().getPouch().canAfford(price);
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        adventure.getHero().getPouch().pay(price);
        adventure.turnTo(destination);
    }

}
