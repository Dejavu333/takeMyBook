package com.elte.fsz.takemybook.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Language {
    HUNGARIAN("Hungarian"),
    ENGLISH("English"),
    GERMAN("German"),
    FRENCH("French"),
    OTHER("Other");

    private final String name;
    private Language(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<Language, String> toMap() {
        return Stream.of(values()).collect(Collectors.toMap(g -> g, g -> g.name));
    }
}
