package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/*
 * 파일 데이터 로드 ->  ArrayList에 저장
 * 학생데이터(ArrayList에 저장된) 파일에 저장
 * 학생데이터에 대한 CRUD기능을 제공한다.
 * 		-Create 
 * 			새로운 학생정보를 ArrayList에 저장한다.
 * 		-Read
 * 			ArrayList에 저장된 학생정보를 찾아서 반환한다.
 * 		-Update
 * 			ArrayList에 저장된 학생정보를 변경한다.
 * 		-Delete
 * 			ArrayList에 저장된 학생정보를 삭제한다.
 *				void removeStudentByName(String name)
 * 	
 */

public class StudentRepository {

	private ArrayList<Student> students = new ArrayList<Student>();
	
	public StudentRepository() {
		//객체 생성 직후에 생성자 메소드가 실행되기 때문에,
		//StudentRepositry객체가 생성된 후 loadDate()메소드를 실행함
		//따라서, StudentRepository객체가 생성된 후 텍스트 파일의 내용을 읽어서
		//Student객체에 담고, 그 Student객체를 ArrayList객체에 추가한다.
		
		loadData();
	}
	//텍스트데이터를 읽어서 students가 참조하는 ArrayList객체에 저장한다.
	//private로 한 이유는 loadData를 다른데에서 부를 일이 없어서 
	private void loadData() {	
		//여기 두줄은 이제 하나씩 읽는거를 BufferedReadr를 사용해서 
		//한 단락?씩 읽어오는거고
		try(FileReader fileReader = new FileReader("src/day1/students.txt");
				BufferedReader reader = new BufferedReader(fileReader);) {
			
			String text = null;
			while ((text = reader.readLine()) != null) {
				//1.text변수에 저장된 문자열을 ,를 구분자로 자른다 -> String[]이 획득됨
				String[] values = text.split(",");
				//2.String[] 배열의 0번째부터 3번째까지 값을 가져와서 
				//	(hint)숫자로 적혀있어도 문자이다. -> 숫자로 바꿔줘야한다.
				//	적절한 변수에 대입한다.
				String name = values[0];
				int kor = Integer.parseInt(values[1]);	//kor <- 100 <- Integer.parseInt("100")
				int eng = Integer.parseInt(values[2]);	//eng <- 100 <- Integer.parseInt("100")
				int math = Integer.parseInt(values[3]);	//math <- 100 <- Integer.parseInt("100")
				
				//3. 2번에서 획득한 이름,국어,영어,수학점수를 Student객체에 생성해서 담는다.
				Student student = new Student(name, kor, eng, math);
				//Student객체 <- name:"지민", kor:100 eng:100, math:100, total:300, average:100
				
				//4.학생성적정보가 들어있는 Student객체를 students참조변수가 참조하는 
				//  ArrayList 객체에 추가한다.
				students.add(student);
				//students <- [Student객체주소값]
				//students <- [Student객체주소값,Student객체주소값]
				//students <- [Student객체주소값,Student객체주소값,Student객체주소값]
				//students <- [Student객체주소값,Student객체주소값,Student객체주소값,Student객체주소값]
				//students <- [Student객체주소값,Student객체주소값,Student객체주소값,Student객체주소값,Student객체주소값]
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	//students가 참조하는 ArrayList객체에 저장된 학생정보를 파일로 저장한다.
	public void saveData() {
		try (PrintWriter writer = new PrintWriter("src/day1/students.txt")) {
			for (Student student : students) {
					//학생정보를 하나씩 하나씩 StringBuilder객체에 내부저장소에 추가한다.
					StringBuilder sb = new StringBuilder();
					sb.append(student.getName())
					.append(",")
					// sb -> ["지민", ","]
					.append(student.getKor())
					// sb -> ["지민", ",",100]
					.append(",")
					// sb -> ["지민", ",",100, ","]
					.append(student.getEng())
					// sb -> ["지민", ",",100, ",", 100]
					.append(",")
					// sb -> ["지민", ",",100, ",", 100, ","]
					.append(student.getMath());
					// sb -> ["지민", ",",100, ",", 100, "," 100]
					//StringBuilder객체의 내부저장소에 추가된 값을 하나의 문자열로 획득한다.
				
				String text = sb.toString();
				//text -> "김유신,100,100,100"
				writer.println(text);
				//PrintWriter객체의 println()메소드를 사용해서 text변수에 저장된 문자열을 파일에 기록한다.
			
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//모든 학생정보를 반환한다.
	public ArrayList<Student> getAllStudent() {
		//Student객체를 모두 저장하고 있는 ArrayList객체의 참조값을 반환한다.
		//Students 참조변수가 그 참조값을 가지고 있으므로, students변수의 값을 반환한다.
		return students;
	}
	
	//지정된 학생정보를 추가한다.
	public void insertStudent(Student student) {
		students.add(student);
	}
	
	//지정된 이름의 학생정보를 반환한다.
	public Student getStudentByName(String name) {
		for(Student student : students) {
			if(student.getName().equals(name)) {
				return student;
			}
		}
		//이름이 일치하는 학생정보가 "없을때" null이 변환된다.
		return null;
	}
	
	//지정된 이름의 학생정보를 삭제한다.
	public void removeStudentByName(String name) {
		Iterator<Student> iter = students.iterator();
		while(iter.hasNext()) {
			Student student = iter.next();
			if(student.getName().equals(name)) {
				iter.remove();
				break;
			}
		}
	}
	
}
