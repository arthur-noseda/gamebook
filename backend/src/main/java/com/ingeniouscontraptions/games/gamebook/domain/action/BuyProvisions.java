package com.ingeniouscontraptions.games.gamebook.domain.action;

import com.ingeniouscontraptions.games.gamebook.domain.GoldPieces;
import com.ingeniouscontraptions.games.gamebook.domain.Hero;
import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import com.ingeniouscontraptions.games.gamebook.domain.book.Adventure;
import com.ingeniouscontraptions.games.gamebook.domain.die.Die;

public class BuyProvisions implements Action {

    private int quantity;

    private final GoldPieces price;

    public BuyProvisions(int quantity, GoldPieces price) {
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public boolean isAllowed(Adventure adventure) {
        return adventure.getHero().getPouch().canAfford(price) && quantity > 0;
    }

    @Override
    public void resolve(Adventure adventure, Die die) {
        Hero hero = adventure.getHero();
        hero.getPouch().pay(price);
        hero.getProvisions().add(1);
        quantity--;
    }

}
