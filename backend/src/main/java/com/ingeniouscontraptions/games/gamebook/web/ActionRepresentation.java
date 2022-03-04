package com.ingeniouscontraptions.games.gamebook.web;

import com.ingeniouscontraptions.games.gamebook.domain.book.Action;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ActionRepresentation {

    private String label;

    private int hash;

    public ActionRepresentation() {
    }

    public ActionRepresentation(Action a) {
        this.label = toLabel(a);
        this.hash = a.hashCode();
    }

    private String toLabel(Action a) {
        return Stream.of(StringUtils.splitByCharacterTypeCamelCase(a.getClass().getSimpleName()))
                .collect(Collectors.joining(" "));
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
