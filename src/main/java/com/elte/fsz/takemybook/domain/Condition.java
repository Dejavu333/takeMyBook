package com.elte.fsz.takemybook.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Condition {
    FACTORY_NEW("Factory New"),
    MINIMAL_WEAR("Minimal Wear"),
    FIELD_TESTED("Field Tested"),
    WELL_WORN("Well Worn"),
    BATTLE_SCARRED("Battle Scared");

    private final String name;
    private Condition(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<Condition, String> toMap() {
        return Stream.of(values()).collect(Collectors.toMap(g -> g, g -> g.name));
    }
}
