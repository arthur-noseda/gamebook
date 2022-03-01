package com.ingeniouscontraptions.games.gamebook.domain;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.notNull;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class AttackStrength implements Comparable<AttackStrength> {

    private final int value;

    public AttackStrength(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(AttackStrength o) {
        notNull(o, "o is required.");
        return new CompareToBuilder().append(value, o.value).toComparison();
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
        AttackStrength rhs = (AttackStrength) obj;
        return new EqualsBuilder()
                .append(value, rhs.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
