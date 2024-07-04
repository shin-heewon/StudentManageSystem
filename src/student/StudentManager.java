package student;


import java.util.ArrayList;

public class StudentManager extends StudentDBIO{
  //싱글톤으로 객체를 생성한다.=> 매니저를 통해서만 객체를 생성, 접근할 수 있도록 한다.
  //private static final으로 선언하는 것이 싱글톤 규칙!
  private static final StudentManager instance = new StudentManager();

  private StudentManager(){}//외부에서 접근할 수 없도록 디폴트 생성자를 private로 만들어준다.

  public static StudentManager getInstance(){

    return instance;
  }

  /*학생 정보 입력 기능*/
  public boolean insertStudent(Student student){//학생의 정보를 파라미터로 받음

    return false;
  }


  /*학생 석차 처리 기능*/
  public ArrayList<Student> getSortedStudent() {

    return new ArrayList<>();
  }

  /*2번 메뉴 : 학생 전체 보기 기능*/
  //제너릭<>을 이용하여 저장소에 Student객체만 저장하도록 함(타입 제한)
  public ArrayList<Student> getStudentList() {

    return new ArrayList<>();
  }

  /*3번 메뉴 : 학생의 학번으로 검색하여 정보 조회 가능*/
  public ArrayList<Student> searchStudent(String sno) {

    return new ArrayList<>();
  }



}
