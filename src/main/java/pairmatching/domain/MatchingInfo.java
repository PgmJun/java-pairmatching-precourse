package pairmatching.domain;

public class MatchingInfo {
	private Course course;
	private Level level;
	private Mission mission;

	public MatchingInfo(String courseName, String levelName, String missionName) {
		this.course = Course.findByName(courseName);
		this.level = Level.findByName(levelName);
		this.mission = Mission.findByName(missionName);
		if (!mission.getLevel().equals(level)) {
			throw new IllegalArgumentException("[ERROR] 레벨과 미션이 일치하지 않습니다.");
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
