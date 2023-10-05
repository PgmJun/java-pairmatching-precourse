package pairmatching.controller;

import java.util.List;

import pairmatching.util.CrewNameReader;

public class MatchController {

	public void run() {
		List<String> backendCrewNames = CrewNameReader.readBackendCrewNames();
		List<String> frontendCrewNames = CrewNameReader.readFrontendCrewNames();
	}
}
