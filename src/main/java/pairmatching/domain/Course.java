package pairmatching.domain;

import java.util.Arrays;

public enum Course {
	BACKEND("백엔드"),
	FRONTEND("프론트엔드"),
	;

	private final String courseName;

	Course(String courseName) {
		this.courseName = courseName;
	}

	public static Course findByName(String courseName) {
		return Arrays.stream(values())
			.filter(c -> c.courseName.equals(courseName))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 Course 입니다."));
	}
}
