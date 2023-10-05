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
		MatchingInfo pairMatchingInfo = findMatchingInfo(matchingInfo);

		return pairs.get(pairMatchingInfo);
	}

	public Set<MatchingInfo> getMatchingInfos() {
		return pairs.keySet();
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

	private MatchingInfo findMatchingInfo(MatchingInfo matchingInfo) {
		return pairs.keySet().stream()
			.filter(k -> k.getCourse().equals(matchingInfo.getCourse()))
			.filter(k -> k.getMission().equals(matchingInfo.getMission()))
			.findAny()
			.get();
	}
}
