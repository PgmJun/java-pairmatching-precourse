package pairmatching.domain;

import java.util.Arrays;

public enum Level {
	LEVEL1("레벨1"),
	LEVEL2("레벨2"),
	LEVEL3("레벨3"),
	LEVEL4("레벨4"),
	LEVEL5("레벨5"),
	;

	private final String levelName;

	Level(String levelName) {
		this.levelName = levelName;
	}

	public static Level findByName(String levelName) {
		return Arrays.stream(values())
			.filter(l -> l.levelName.equals(levelName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 Level 입니다."));
	}
}
