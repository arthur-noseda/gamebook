package com.ingeniouscontraptions.games.gamebook.domain;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.notNull;
import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.positive;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class GoldPieces implements Comparable<GoldPieces> {

    private final int amount;

    private GoldPieces(int amount) {
        this.amount = positive(amount, "amount");
    }

    public static GoldPieces of(int amount) {
        return new GoldPieces(amount);
    }

    public GoldPieces add(GoldPieces goldPieces) {
        return GoldPieces.of(amount + goldPieces.amount);
    }

    public GoldPieces subtract(GoldPieces goldPieces) {
        return GoldPieces.of(amount - goldPieces.amount);
    }

    @Override
    public int compareTo(GoldPieces o) {
        notNull(o, "o is required.");
        return new CompareToBuilder()
                .append(amount, o.amount)
                .toComparison();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        GoldPieces rhs = (GoldPieces) obj;
        return new EqualsBuilder()
                .append(amount, rhs.amount)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(amount)
                .toHashCode();
    }

    @Override
    public String toString() {
        return String.format("%d gold pieces", amount);
    }

}
