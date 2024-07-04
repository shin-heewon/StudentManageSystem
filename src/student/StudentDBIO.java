package student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lib.ObjectDBIO;

/*쿼리가 작동되도록 함*/
public abstract class StudentDBIO extends ObjectDBIO implements StudentIO{

  public ArrayList<Student> getStudentList(){
    ArrayList<Student> stuList = new ArrayList<Student>();
    String query = "SELECT * FROM STUDENT";
    ResultSet rs = null;

    try{
      rs = super.execute(query, rs);//response 요청
      while (rs.next()){//패치?, 2중for문 중 바깥for에 해당, 임시객체로 받아옴

        int sno = rs.getInt("sno");//받아오려는 컬럼 인덱스 번호 혹은 컬럼명으로 받아옴
        String name = rs.getString(2);
        int korea = rs.getInt(3);
        int english = rs.getInt(4);
        int math = rs.getInt(5);
        int science = rs.getInt(6);
        int total = rs.getInt("total");
        double avg = rs.getDouble("average");
        String grade = rs.getString("grade");

        Student student = new Student(sno, name, korea, english, math, science, total, avg, grade);//임시객체에서 받은걸 안전하게 student객체에 담아 저장
        stuList.add(student);

      }//while end
      rs.close();
      super.close();//커넥션 닫음!
    }catch (SQLException e){
      System.err.println(e.getMessage());
      e.printStackTrace();
    }
    return stuList;
  }

  public ArrayList<Student> searchStudent(String sno){
    ArrayList<Student> searchStudent = new ArrayList<Student>();
    return null;
  }

  public ArrayList<Student> getSortedStudent(){
    ArrayList<Student> sortStudent = new ArrayList<Student>();
    return null;
  }

  public boolean insertStudent(Student student){

    String name = student.getName();
    int kor = student.getRecord()[0];
    int eng = student.getRecord()[1];
    int math = student.getRecord()[2];
    int sci = student.getRecord()[3];
    int total = student.getTotal();
    double avg = student.getAverage();
    String grade = student.getGrade();

    String query = "INSERT INTO STUDENT VALUES(null,'"+name+"',"
        +kor+","+eng+","+math+","+sci+", '"+grade+"',"+total+","+avg+")";//sno는 autoincreament이기 때문에 직접 입력하지 않음!!

    String query2 = "INSERT INTO STUDENT VALUES('"
        + name + "', "
        + kor + ", "
        + eng + ", "
        + math + ", "
        + sci + ", '"
        + grade + "', "
        + total + ", "
        + avg + ")";

      super.execute(query2);

    return false;
  }
}
