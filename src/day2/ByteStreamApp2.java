package day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ByteStreamApp2 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://t1.daumcdn.net/movie/355cd8a765ae6ce5e3afe5da5c1edc671ebe7353");

		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("src/day2/플립.jpg");
		
		BufferedInputStream bis = new BufferedInputStream(in);
		BufferedOutputStream bos = new BufferedOutputStream(out);
		
		int value = 0;
		while ((value=bis.read()) != -1) {
			bos.write(value);
		}
		bos.close();
	
	}

}
