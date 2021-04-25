package day3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class StandardInputApp {

	public static void main(String[] args) {
		
		//Scanner와 표준입력 스트림을 연결해서 키보드 입력값 읽어오기
		Scanner sc = new Scanner(System.in);
		System.out.println("메세지를 입력하세요");
		String text = sc.nextLine();
		System.out.println("입력메세지: " + text);
		sc.close();
		
		//Scanner와 표준입력스트림을 연결해서 키보드 입력값 읽어오기
//		Scanner sc = new Scanner(System.in);
//		System.out.println("메세지를 입력하세요");
//		String text = sc.nextLine();
//		System.out.println("입력메세지: " + text);
//		sc.close();
		
		//BufferedReader, InputStreamReader와 표준입력스트림을 연결해서 키보드 입력값 읽어오기
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader reader = new BufferedReader(isr);
		
		//프로그램 <- BufferedReader <- InputStreamReader <- InputSream <- 키보드
		System.out.println("메세지를 입력하세요");
		String text = reader.readLine();
		System.out.println("입력메세지: " + text);
	}

}
