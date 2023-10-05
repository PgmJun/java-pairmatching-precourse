package pairmatching.ui;

import java.util.List;
import java.util.StringJoiner;

import pairmatching.domain.Matching;

public class OutputView {

	public void printSelectFunctionMessage() {
		System.out.println("기능을 선택하세요.\n"
			+ "1. 페어 매칭\n"
			+ "2. 페어 조회\n"
			+ "3. 페어 초기화\n"
			+ "Q. 종료");
	}

	public void printPairMatchingInfoMessage() {
		printEnter();
		System.out.println("#############################################\n"
			+ "과정: 백엔드 | 프론트엔드\n"
			+ "미션:\n"
			+ "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n"
			+ "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n"
			+ "  - 레벨3: \n"
			+ "  - 레벨4: 성능개선 | 배포\n"
			+ "  - 레벨5: \n"
			+ "############################################\n"
			+ "과정, 레벨, 미션을 선택하세요.\n"
			+ "ex) 백엔드, 레벨1, 자동차경주");
	}

	public void printRematchingQuestionMessage() {
		System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n"
			+ "예 | 아니오");
	}

	public void printMatchingResult(Matching matchingResult) {
		printEnter();
		System.out.println("페어 매칭 결과입니다.");
		StringJoiner joiner;
		for (List<String> pair : matchingResult.getData()) {
			joiner = new StringJoiner(" : ");

			for (String name : pair) {
				joiner.add(name);
			}
			System.out.println(joiner);
		}
	}

	public void printPairResetMessage() {
		printEnter();
		System.out.println("초기화 되었습니다.");
	}

	public void printErrorMessage(Exception e) {
		System.out.println(e.getMessage());
	}

	private void printEnter() {
		System.out.println();
	}
}
