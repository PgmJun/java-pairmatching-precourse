package pairmatching.util;

import static pairmatching.constant.MatchConstant.*;
import static pairmatching.constant.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;

public class Validator {
	private final static List<String> functions = Arrays.asList(MATCH_PAIR, SHOW_PAIR, RESET_PAIR, QUIT);
	private final static List<String> rematchAnswers = Arrays.asList(YES, NO);

	public static void validateFunctionType(String function) {

		if (!functions.contains(function)) {
			throw new IllegalArgumentException(FUNCTION_TYPE_ERROR_MESSAGE);
		}
	}

	public static void validateMatchingInfoAmount(String[] matchingInfo) {
		if (matchingInfo.length != MATCHING_INFO_SIZE) {
			throw new IllegalArgumentException(MATCHING_INFO_ERROR_MESSAGE);
		}
	}

	public static void validateReMatchAnswer(String answer) {
		if (!rematchAnswers.contains(answer)) {
			throw new IllegalArgumentException(REMATCH_ANSWER_ERROR_MESSAGE);
		}
	}
}
