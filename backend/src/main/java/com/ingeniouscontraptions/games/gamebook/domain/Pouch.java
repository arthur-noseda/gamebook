package com.ingeniouscontraptions.games.gamebook.domain;

import com.ingeniouscontraptions.games.gamebook.domain.commons.MathUtils;

public class Pouch {

    private GoldPieces goldPieces;

    private Pouch(GoldPieces goldPieces) {
        this.goldPieces = goldPieces;
    }

    public static Pouch of(GoldPieces goldPieces) {
        return new Pouch(goldPieces);
    }

    public GoldPieces getGoldPieces() {
        return goldPieces;
    }

    public void gain(GoldPieces goldPiecesGained) {
        goldPieces = goldPieces.add(goldPiecesGained);
    }

    public boolean canAfford(GoldPieces price) {
        return MathUtils.greaterThanOrEqualTo(goldPieces, price);
    }

    public void pay(GoldPieces price) {
        if (!canAfford(price)) {
            throw new IllegalArgumentException(String.format("Cannot pay %s.", price));
        }
        goldPieces = goldPieces.subtract(price);
    }

    public void loseUpTo(GoldPieces goldPiecesLost) {
        if (MathUtils.greaterThan(goldPieces, goldPiecesLost)) {
            pay(goldPiecesLost);
        } else {
            empty();
        }
    }

    public void empty() {
        goldPieces = GoldPieces.of(0);
    }

    public boolean isEmpty() {
        return goldPieces.equals(GoldPieces.of(0));
    }

}
