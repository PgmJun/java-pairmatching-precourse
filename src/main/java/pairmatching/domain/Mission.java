package pairmatching.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Mission {

	RACING(Level.LEVEL1, "자동차경주"), LOTTO(Level.LEVEL1, "로또"), BASEBALL(Level.LEVEL1, "숫자야구게임"),
	BASKET(Level.LEVEL2, "장바구니"), PAYMENT(Level.LEVEL2, "결제"), SUBWAY(Level.LEVEL2, "지하철노선도"),
	PERFORMANCE_IMPROVE(Level.LEVEL4, "성능개선"), DEPLOY(Level.LEVEL4, "배포"),
	;
	private final Level level;
	private final String missionName;

	Mission(Level level, String missionName) {
		this.level = level;
		this.missionName = missionName;
	}

	public Level getLevel() {
		return level;
	}

	public static Mission findByName(String missionName) {
		return Arrays.stream(values())
			.filter(m -> m.missionName.equals(missionName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 Mission 입니다."));
	}
}
