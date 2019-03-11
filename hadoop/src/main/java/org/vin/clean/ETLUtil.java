package org.vin.clean;


public class ETLUtil {

	private static final String SEPERATOR = "\t";

	public static String oriString2ETLString(String ori) {

		String[] splits = ori.split("\t");
		if (splits.length < 9) {
			return null;
		}
		StringBuilder etlString = new StringBuilder();
		splits[3].replace(" ", "");
		for (int i = 0; i < splits.length; i++) {
			if (i < 9) {
				if (i == splits.length - 1) {
					etlString.append(splits[i]);
				} else {
					etlString.append(splits[i] + SEPERATOR);
				}
			} else {
				if (i == splits.length - 1) {
					etlString.append(splits[i]);
				} else {
					etlString.append(splits[i] + "&");
				}
			}
		}

		return etlString.toString();
	}


}
