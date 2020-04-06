package test;

import java.io.*;

public class Files {

	public static String toString(String path) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		InputStream input = Files.class.getResourceAsStream(path);
		int len;
		byte[] buffer = new byte[1024];
		try {
			while ((len = input.read(buffer)) != -1)
				outputStream.write(buffer, 0, len);
			return new String(outputStream.toByteArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}
