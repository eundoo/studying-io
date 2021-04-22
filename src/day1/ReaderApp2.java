package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderApp2 {

	public static void main(String[] args) {
		
		try(FileReader fileReader = new FileReader("src/day1/students.txt"); 
				BufferedReader reader = new BufferedReader(fileReader)) {
			
			//글을 어디까지 읽어와야 되는지 모르잖어 글서 이걸 쓰는거다.
			String text = null;
			//readLine()으로 읽어온 텍스트를 text변수에 대입하고, 그 값이 null이 아닐때 까지 반복한다.
			//읽어와서 텍스트에 담은게 null이 아니여야 되는거야
			while((text = reader.readLine()) != null) {
				//System.out.println(text);
				
				//text					//values
				//"지민,100,100,100" ->  {"지민,100,100,100"}
										//values에 [0] [1] 문자, 숫자 이 데이터가 다 다르잖어 
										//이거는 다르게 처리해야되는거라서 향상된for문사용 안돼
										//동일한 데이터일때만 가능한거야 향상된for문은
				//근데 text는 1이랑0,0이 붙어있는 문자가 연결된거야 
				
				String[] values = text.split(",");
//				for (String value : values) {	
//				}
				//그래서 values에 있는걸 꺼내려거든 Integer로 변환후에 해야되는거야
				String name = values[0];
				int kor = Integer.parseInt(values[1]);
				int eng = Integer.parseInt(values[2]);
				int math = Integer.parseInt(values[3]);
				//그래서 기본적으로 값이 뭐가 나오는지 알아야됨 for문을 안쓰고 하나하나 
				//출력하기 때문에
				System.out.println("학생이름: " + name);
				System.out.println("국어점수: " + kor);
				System.out.println("영어점수: "  + eng);
				System.out.println("수학점수: " + math);
				System.out.println("---------------------------------------");
				
			}
			
		} catch(IOException e) {
			//try catch를 했다면 어디서 에러났는지 확인하기 위해서 
			//e.printStackTrace();를 꼭 써줘야 한다.
			e.printStackTrace();
		}

	}

}
