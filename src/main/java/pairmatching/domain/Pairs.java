package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Pairs {
	private Map<MatchingInfo, Matching> pairs;

	public Pairs() {
		pairs = new HashMap<>();
	}

	public Matching findMatchingResult(MatchingInfo matchingInfo) {
		validateMatchingDataExist(matchingInfo);
		MatchingInfo pairMatchingInfo = findMatchingInfo(matchingInfo);

		return pairs.get(pairMatchingInfo);
	}

	public void remove(MatchingInfo matchingInfo) {
		MatchingInfo pairMatchingInfo = findMatchingInfo(matchingInfo);

		pairs.remove(pairMatchingInfo);
	}

	public void add(MatchingInfo matchingInfo, Matching matchingResult) {
		pairs.put(matchingInfo, matchingResult);
	}

	public void reset() {
		pairs = new HashMap<>();
	}

	public boolean containsMatchingInfo(MatchingInfo matchingInfo) {
		for (MatchingInfo info : pairs.keySet()) {
			if (info.getCourse().equals(matchingInfo.getCourse()) &&
				info.getMission().equals(matchingInfo.getMission()) &&
				info.getMission().getLevel().equals(matchingInfo.getLevel())){
				return true;
			}
		}
		return false;
	}

	private void validateMatchingDataExist(MatchingInfo matchingInfo) {
		if (!containsMatchingInfo(matchingInfo)) {
			throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
		}
	}

	private MatchingInfo findMatchingInfo(MatchingInfo matchingInfo) {
		return pairs.keySet().stream()
			.filter(k -> k.getCourse().equals(matchingInfo.getCourse()))
			.filter(k -> k.getMission().equals(matchingInfo.getMission()))
			.filter(k -> k.getLevel().equals(matchingInfo.getLevel()))
			.findAny()
			.get();
	}
}
