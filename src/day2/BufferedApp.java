package day2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedApp {

	public static void main(String[] args) throws IOException{
		System.out.println("버퍼를 사용하지 않고 읽고 쓰기 시작");
		long startTime = System.currentTimeMillis();
		
		FileInputStream fis1 = new FileInputStream("src/day2/song.mp4");
		FileOutputStream fos1 = new FileOutputStream("src/day3/song4.mp4");
		
		int value = 0;
		while((value=fis1.read()) != -1) {
			fos1.write(value);
		}
	
		fis1.close();
		fos1.close();
	
		long endTime = System.currentTimeMillis();
		System.out.println("버퍼를 사용하지 않고 읽고 쓰기 종료");
		System.out.println("버퍼를 사용하지 않은 경우 소요시간: " + (endTime - startTime) + "밀리초" );
		
		
		System.out.println("버퍼를 사용해서 읽고 쓰기 시작");
		startTime = System.currentTimeMillis();
		
		FileInputStream fis2 = new FileInputStream("src/day2/song.mp4");
		FileOutputStream fos2 = new FileOutputStream("src/day2/song3.mp4");
		
		BufferedInputStream in = new BufferedInputStream(fis2);
		BufferedOutputStream out = new BufferedOutputStream(fos2);
		
		int value2 = 0;
		while((value2=in.read()) != -1) {
			out.write(value2);
		}
		
		in.close();
		out.close();
		
		endTime = System.currentTimeMillis();
		System.out.println("버퍼를 사용해서 읽고 쓰기 종료");
		System.out.println("버퍼를 사용하지 않은 경우 소요시간: " + (endTime - startTime) + "밀리초");
	
	}
}
