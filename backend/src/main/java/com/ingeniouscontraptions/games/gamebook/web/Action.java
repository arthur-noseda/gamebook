package com.ingeniouscontraptions.games.gamebook.web;

import javax.validation.constraints.NotNull;

public class Action {

    private String label;

    private int hash;

    public Action() {
    }

    public Action(String label, int hash) {
        this.label = label;
        this.hash = hash;
    }

    public String getLabel() {
        return label;
    }

    @NotNull
    public int getHash() {
        return hash;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

}
