package com.ingeniouscontraptions.games.gamebook.domain.book;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EntryNumber {

    private final int number;

    private EntryNumber(int number) {
        this.number = number;
    }

    public static EntryNumber of(int number) {
        return new EntryNumber(number);
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
        EntryNumber rhs = (EntryNumber) obj;
        return new EqualsBuilder()
                .append(number, rhs.number)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(number)
                .toHashCode();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

}
