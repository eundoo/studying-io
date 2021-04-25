package day3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class BridgeStreamApp {

	public static void main(String[] args) {
		
		URL url = new URL("http~");
		//1byte 씩 읽어오는 스트림 획득
		InputStream is = url.openStream();
		//1글자씩 읽어오는 스트림과 연결
		InputStreamReader isr = new InputStreamReader(is);
		//1줄씩 읽어오는 스트림과 연결
		BufferedReader reader = new BufferedReader(isr);
		
		String text = null;
		while((text=reader.readLine()) != null) {
			System.out.println(text);
		}

	}

}
