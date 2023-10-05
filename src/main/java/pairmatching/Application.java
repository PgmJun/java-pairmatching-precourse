package pairmatching;

import pairmatching.controller.MatchController;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);
        MatchController controller = new MatchController(inputView, outputView);

        controller.run();
    }
}
