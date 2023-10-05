package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Matching {
	private List<List<String>> matchingData;

	public Matching(List<List<String>> matchingData) {
		this.matchingData = matchingData;
	}

	public List<List<String>> getData() {
		return matchingData;
	}

	public static Matching match(MatchingInfo matchingInfo){
		Crew crew = Crews.getCrew(matchingInfo.getCourse());
		List<String> crewNames = Randoms.shuffle(crew.getCrewNames());

		if (crewNames.size() % 2 == 0) {
			return evenCaseMatching(crewNames);
		}
		return oddCaseMatching(crewNames);
	}
	private static Matching oddCaseMatching(List<String> crewNames) {
		List<List<String>> pair = new ArrayList<>();

		for (int i = 0; i < crewNames.size(); i+=2) {
			List<String> matchedCrewNames = new ArrayList<>();
			if (i == crewNames.size() - 3) {
				matchedCrewNames.add(crewNames.get(i));
				matchedCrewNames.add(crewNames.get(i+1));
				matchedCrewNames.add(crewNames.get(i+2));
				pair.add(matchedCrewNames);
				break;
			}
			matchedCrewNames.add(crewNames.get(i));
			matchedCrewNames.add(crewNames.get(i+1));
			pair.add(matchedCrewNames);
		}
		return new Matching(pair);
	}

	private static Matching evenCaseMatching(List<String> crewNames) {
		List<List<String>> pair = new ArrayList<>();

		for (int i = 0; i < crewNames.size(); i+=2) {
			List<String> matchedCrewNames = new ArrayList<>();

			matchedCrewNames.add(crewNames.get(i));
			matchedCrewNames.add(crewNames.get(i+1));
			pair.add(matchedCrewNames);
		}
		return new Matching(pair);
	}
}
