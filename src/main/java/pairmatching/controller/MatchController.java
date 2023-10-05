package pairmatching.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.Mission;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;
import pairmatching.util.CrewNameReader;

public class MatchController {

	private final InputView inputView;
	private final OutputView outputView;
	private Map<MatchingInfo, Matching> pairs = new HashMap<>();

	public MatchController(InputView inputView, OutputView outputView) {
		this.inputView = inputView;
		this.outputView = outputView;
		Crews.addCrew(Course.BACKEND, new Crew(CrewNameReader.readBackendCrewNames()));
		Crews.addCrew(Course.FRONTEND, new Crew(CrewNameReader.readFrontendCrewNames()));
	}

	public void run() {
		selectFunction();
	}

	private void selectFunction() {
		String function = "";
		while (!function.equals("Q")) {
			function = readFunction();
			if (function.equals("1")) {
				matchPairs();
			} else if (function.equals("2")) {
				showPairs();
			} else if(function.equals("3")) {
				resetPairs();
			}
		}
	}

	private String readFunction() {
		String function;
		try {
			function = inputView.readFunction();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			function = readFunction();
		}
		return function;
	}

	private void matchPairs() {
		MatchingInfo matchingInfo = readMatchingInfo();
		if (pairsContainsKey(matchingInfo)) {
			if (doRematch()) {
				pairs.remove(matchingInfo);
				match(matchingInfo);
			}
			return;
		}
		match(matchingInfo);
	}

	private boolean pairsContainsKey(MatchingInfo matchingInfo) {
		for (MatchingInfo key : pairs.keySet()) {
			if (key.getCourse().equals(matchingInfo.getCourse()) &&
				key.getMission().equals(matchingInfo.getMission())) {
				return true;
			}
		}
		return false;
	}

	private void showPairs() {
		MatchingInfo matchingInfo = readMatchingInfo();

		try {
			validateMatchingDataExist(matchingInfo);
			outputView.printMatchingResult(findMatchingResult(matchingInfo));

		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			showPairs();
		}
	}

	private Matching findMatchingResult(MatchingInfo matchingInfo) {
		MatchingInfo pairMatchingInfo = pairs.keySet().stream()
			.filter(k -> k.getCourse().equals(matchingInfo.getCourse()))
			.filter(k -> k.getMission().equals(matchingInfo.getMission()))
			.findAny()
			.get();

		return pairs.get(pairMatchingInfo);
	}

	private void validateMatchingDataExist(MatchingInfo matchingInfo) {
		if (!pairsContainsKey(matchingInfo)) {
			throw new IllegalArgumentException("[ERROR] 매칭 이력이 없습니다.");
		}
	}

	private MatchingInfo readMatchingInfo() {
		MatchingInfo matchingInfo;
		try {
			matchingInfo = inputView.readMatchingInfo();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			matchingInfo = readMatchingInfo();
		}
		return matchingInfo;
	}

	private void resetPairs() {
		pairs = new HashMap<>();
		outputView.printPairResetMessage();
	}

	private boolean doRematch() {
		boolean doRematch;
		try {
			doRematch = inputView.readDoRematch();
		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			doRematch = doRematch();
		}
		return doRematch;
	}

	private void match(MatchingInfo matchingInfo) {
		Matching matchingResult = Matching.match(matchingInfo);

		pairs.put(matchingInfo, matchingResult);
		outputView.printMatchingResult(matchingResult);
	}
}
