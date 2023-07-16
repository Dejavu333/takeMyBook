package com.elte.fsz.takemybook.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Genre {
    SCI_FI("Sci-fi"),
    ADVENTURE("Adventure"),
    CRIME("Crime"),
    FANTASY("Fantasy"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    THRILLER("Thriller"),
    MYSTERY("Mystery"),
    DRAMA("Drama"),
    SCIENCE("Science"),
    SPORT("Sport"),
    BIOGRAPHY("Biography"),
    HISTORY("History"),
    HUMOR("Humor"),
    ESSAYS("Essays"),
    RELIGION("Religion"),
    TALE("Tale"),
    POETRY("Poetry"),
    OTHER("Other");

    private final String name;
    private Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<Genre, String> toMap() {
        return Stream.of(values()).collect(Collectors.toMap(g -> g, g -> g.name));
    }

}


