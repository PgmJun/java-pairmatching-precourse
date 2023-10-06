package pairmatching.controller;

import static pairmatching.constant.MatchConstant.*;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Crews;
import pairmatching.domain.Matching;
import pairmatching.domain.MatchingInfo;
import pairmatching.domain.Pairs;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;
import pairmatching.util.CrewNameReader;

public class MatchController {

	private final InputView inputView;
	private final OutputView outputView;
	Pairs pairs = new Pairs();

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
		while (!function.equals(QUIT)) {
			function = readFunction();
			if (function.equals(MATCH_PAIR)) {
				matchPairs();
			} else if (function.equals(SHOW_PAIR)) {
				showPairs();
			} else if(function.equals(RESET_PAIR)) {
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

	private void matchPairs() {
		MatchingInfo matchingInfo = readMatchingInfo();
		if (pairs.containsMatchingInfo(matchingInfo)) {
			if (doRematch()) {
				pairs.remove(matchingInfo);
				match(matchingInfo);
			}
			return;
		}
		match(matchingInfo);
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

		pairs.add(matchingInfo, matchingResult);
		outputView.printMatchingResult(matchingResult);
	}

	private void showPairs() {
		MatchingInfo matchingInfo = readMatchingInfo();

		try {
			outputView.printMatchingResult(pairs.findMatchingResult(matchingInfo));

		} catch (IllegalArgumentException e) {
			outputView.printErrorMessage(e);
			showPairs();
		}
	}

	private void resetPairs() {
		pairs.reset();
		outputView.printPairResetMessage();
	}
}
