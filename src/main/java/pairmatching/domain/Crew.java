package pairmatching.domain;

import java.util.List;

public class Crew {

	private List<String> crewNames;

	public Crew(List<String> crewNames) {
		this.crewNames = crewNames;
	}

	public List<String> getCrewNames() {
		return crewNames;
	}
}
