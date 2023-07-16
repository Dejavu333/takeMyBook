package com.elte.fsz.takemybook.domain;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
	BRONZE_BOOKMARK("Bronze Bookmark"),SILVER_BOOKMARK("Silver Bookmark"),GOLD_BOOKMARK("Gold Bookmark");

	private final String name;
	private Rank(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static Map<Rank, String> toMap() {
		return Stream.of(values()).collect(Collectors.toMap(g -> g, g -> g.name));
	}
}
