package pairmatching.util;

import java.util.Arrays;
import java.util.List;

public class Validator {
	private final static List<String> functions = Arrays.asList("1","2","3","Q");
	private final static List<String> rematchAnswers = Arrays.asList("예", "아니오");

	public static void validateFunctionType(String function) {

		if(!functions.contains(function)) {
			throw new IllegalArgumentException("[ERROR] 존재하지 않는 기능입니다.");
		}
	}

	public static void validateMatchingInfoAmount(String[] matchingInfo) {
		if(matchingInfo.length != 3) {
			throw new IllegalArgumentException("[ERROR] 매칭 정보는 '과정','레벨','미션' 총 3가지가 입력되어야 합니다.");
		}
	}

	public static void validateReMatchAnswer(String answer) {
		if(!rematchAnswers.contains(answer)) {
			throw new IllegalArgumentException("[ERROR] '예' 또는 '아니오' 중 하나의 응답만 가능합니다.");
		}
	}
}
