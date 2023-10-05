package pairmatching.ui;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.MatchingInfo;
import pairmatching.util.Validator;

public class InputView {
	private final OutputView outputView;

	public InputView(OutputView outputView) {
		this.outputView = outputView;
	}

	public String readFunction() {
		outputView.printSelectFunctionMessage();
		String function = Console.readLine();

		Validator.validateFunctionType(function);
		return function;
	}

	public MatchingInfo readMatchingInfo() {
		outputView.printPairMatchingInfoMessage();
		String[] matchingInfo = Console.readLine().split(", ");

		Validator.validateMatchingInfoAmount(matchingInfo);
		return new MatchingInfo(matchingInfo[0], matchingInfo[1], matchingInfo[2]);
	}

	public boolean readDoRematch() {
		outputView.printRematchingQuestionMessage();
		String rematchAnswer = Console.readLine();

		Validator.validateReMatchAnswer(rematchAnswer);
		if(rematchAnswer.equals("예")) {
			return true;
		}
		return false;
	}
}
