package org.adox.app.util;

public class StringUtils {
	
	private StringUtils() {

	}

	public static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}

}