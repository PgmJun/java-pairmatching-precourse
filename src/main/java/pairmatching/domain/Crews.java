package pairmatching.domain;

import java.util.HashMap;
import java.util.Map;

public class Crews {
	private static final Map<Course, Crew> crewNames = new HashMap<>();

	public static void addCrew(Course course, Crew crew) {
		crewNames.put(course, crew);
	}

	public static Crew getCrew(Course course) {
		return crewNames.get(course);
	}

}
