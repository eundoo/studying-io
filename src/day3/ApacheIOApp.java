package day3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class ApacheIOApp {

	public static void main(String[] args) throws IOException{
		File src = new File("src/day3/song.mp4");
		File dest = new File("src/day3/song_copy.mp4");
		
		FileUtils.copyFile(src,dest);
		
		URL url = new URL("http");
		InputStream in = url.openStream();
		FileOutputStream out = new FileOutputStream("src/day3/photo.jpg");
		
		IOUtils.copy(in, out);

	}

}
