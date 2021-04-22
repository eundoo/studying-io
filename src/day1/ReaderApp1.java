package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderApp1 {

	public static void main(String[] args) {
		//이 try안에 두줄이 조립하는 과정이다.
		//FileReader fileReader = new FileReader("src.day1/students.txt")) {
		//BufferedReader reader = new BufferedReader(fileReader);
		//이미지 참조
		try (FileReader fileReader = new FileReader("src/day1/students.txt");
			BufferedReader reader = new BufferedReader(fileReader);) {
			
			//String readLine()
			//텍스트를 한 줄씩 읽어서 반환한다.
			//더 이상 읽어올 텍스트가 없으면 null을 반환한다.
			String text1 = reader.readLine();
			String text2 = reader.readLine();
			String text3 = reader.readLine();
			String text4 = reader.readLine();
			String text5 = reader.readLine();
			String text6 = reader.readLine();
			String text7 = reader.readLine();
			
			System.out.println(text1);
			System.out.println(text2);
			System.out.println(text3);
			System.out.println(text4);
			System.out.println(text5);
			System.out.println(text6);
			System.out.println(text7);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
 		//BufferedReader이녀석은 보조 String이다.
		//Reader가 하나씩 읽어올때 한 줄 씩 해주는 역할을 제공한다.
	}

}
