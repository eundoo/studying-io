package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * 학생과 관련된 실직적인 업무를 처리하는 기능을 제공한다.
 * 
 * 		모든 학생 조회 기능
 * 		학생정보 검색 기능
 * 		신규학생정보 추가기능
 * 
 * 	- 대부분은 Service클래스는 데이터에 대한 직접적인 CRUD기능을 가지고 있는 Repository객체가 필요하다.
 */

public class StudentService {

	//그 전에 학생정보를 모두 불러와야 할거아니야
	//객체를 생성하자마자 Student정보를 다 담아놓은것은 만든것
	private StudentRepository repository = new StudentRepository();

	//모든 학생정보를 제공하는 서비스
	//ArrayList배열 하나하나가 Student타입인거야
	public ArrayList<Student> getAllStudentList() {
		//Student객체를 모두 저장하고 있는 ArrayList객체의 참조값을 반환한다.
		ArrayList<Student> students = repository.getAllStudent();
		return null;
		//위에 두 줄 처럼 적거나 
		//return repository.getAllStudent(); 이렇게 리턴값으로만 줘도 된다.
	}
	
	//이름으로 학생정보를 조회하는 서비스
	public Student findStudent(String name) {
		Student student = repository.getStudentByName(name);
		if(student == null) {
			throw new StudentException("["+ name +"] 과 일치하는 학생정보가 없습니다.");
		}
		return student;
	}

	//새로운 학생정보를 추가하는 서비스
	public void addNewStudent(Student student) {
		//동일한 학생이 있는지 확인하고 예외발생 시키기
		//동일한 학생이 없으면 repository의 insertStudent(student)메소드 실행하기
		repository.insertStudent(student);
	}
	
	//이름으로 학생정보를 삭제하는 서비스
	public void removeStudent(String name) {
		Student student = repository.getStudentByName(name);
		if(student == null) {
			throw new StudentException("[" + name + "]과 일치하는 학생정보가 존재하지 않습니다.");
		}
		repository.removeStudentByName(name);
		}
	
	//성적순으로 학생정보를 정렬해서 제공하는 서비스
	   @SuppressWarnings("unchecked")
	   public ArrayList<Student> getStudentsRanking(){
	      ArrayList<Student> originalStudents = repository.getAllStudent();
	      if(originalStudents.isEmpty()) {
	         throw new StudentException("학생정보가 존재하지 않습니다.");
	      }
	      
	      //원본 ArrayList<Student>를 복제한다.
	      ArrayList<Student> cloneStudents = (ArrayList<Student>) originalStudents.clone();
	      //Collections.sort(cloneStudents);   	//총점에 대한 오름차순으로 정렬됨
	      Collections.reverse(cloneStudents);   //총점에 대한 내림차순으로 정렬됨
	      
	      return cloneStudents;
	}
	//모든 학생정보를 파일로 저장하는 서비스
	public void saveAllStudentData() {
		repository.saveData();
	}

}
