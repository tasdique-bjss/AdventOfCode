package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
	final List<String> lines;
	
	public FileReader(Class<?> cls, String fileName) {
		lines = new ArrayList<>();
		try (InputStreamReader stream = new InputStreamReader(cls.getResourceAsStream(fileName), "UTF-8")) {
			try (BufferedReader r = new BufferedReader(stream)) {
				lines.addAll(r.lines().collect(Collectors.toList()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> getLines() {
		return lines;
	}
	
	public List<BigDecimal> getLinesAsBds() {
		return getLines().stream().map(s -> new BigDecimal(s)).collect(Collectors.toList());
	}
}
