package pairmatching.domain;

import static pairmatching.constant.ErrorMessage.*;

public class MatchingInfo {
	private Course course;
	private Level level;
	private Mission mission;

	public MatchingInfo(String courseName, String levelName, String missionName) {
		this.course = Course.findByName(courseName);
		this.level = Level.findByName(levelName);
		this.mission = Mission.findByName(missionName);
		if (!mission.getLevel().equals(level)) {
			throw new IllegalArgumentException(UNMATCHED_LEVEL_AND_MISSION_ERROR_MESSAGE);
		}
	}

	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public Mission getMission() {
		return mission;
	}
}
