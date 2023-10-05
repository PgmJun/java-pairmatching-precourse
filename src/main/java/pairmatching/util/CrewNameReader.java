package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewNameReader {
	private CrewNameReader() {
	}

	private static BufferedReader br;
	private static final String BACKEND_CREW_PATH = "src/main/resources/backend-crew.md";
	private static final String FRONTEND_CREW_PATH = "src/main/resources/frontend-crew.md";

	public static List<String> readBackendCrewNames() {
		return readCrewNames(BACKEND_CREW_PATH);
	}

	public static List<String> readFrontendCrewNames() {
		return readCrewNames(FRONTEND_CREW_PATH);
	}

	private static List<String> readCrewNames(String crewFilePath) {
		List<String> crewNames = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader(crewFilePath));
			String crewName;
			while ((crewName = br.readLine()) != null) {
				crewNames.add(crewName);
			}

			return crewNames;
		} catch (IOException e) {
			throw new IllegalArgumentException("[ERROR] 파일 입출력 오류");
		}
	}
}
