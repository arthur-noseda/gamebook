package com.ingeniouscontraptions.games.gamebook.domain;

import static com.ingeniouscontraptions.games.gamebook.domain.commons.Preconditions.positive;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Provisions {

    private final List<Ration> rations;

    private Provisions(List<Ration> rations) {
        this.rations = rations;
    }

    public static Provisions of(int numberOfMeals) {
        return new Provisions(IntStream.range(0, positive(numberOfMeals, "numberOfMeals"))
                .mapToObj(i -> new Ration())
                .collect(Collectors.toList()));
    }

    private boolean hasProvisions() {
        return !rations.isEmpty();
    }

    public void add(int numberOfMealsAdded) {
        IntStream.range(0, positive(numberOfMealsAdded, "numberOfMealsAdded"))
                .forEach(i -> rations.add(new Ration()));
    }

    public Ration take() {
        if (!hasProvisions()) {
            throw new IllegalStateException("No provisions left.");
        }
        return rations.remove(rations.size() - 1);
    }

    public int getNumberOfMeals() {
        return rations.size();
    }

}
