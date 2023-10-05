package pairmatching;

import pairmatching.controller.MatchController;

public class Application {
    public static void main(String[] args) {
        MatchController controller = new MatchController();

        controller.run();
    }
}
