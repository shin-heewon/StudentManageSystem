package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**/
public abstract class ObjectDBIO {

  private Connection connection = null;//서버가 줌

  private String db_url = "jdbc:mysql://localhost:3306/employees";
  private String db_id = "root";
  private String db_pwd = "mysql";


  /*db_url, db_id, db_pwd setter,getter*/

  public void setDb_url(String db_url) {
    this.db_url = db_url;
  }

  public void setDb_id(String db_id) {
    this.db_id = db_id;
  }

  public void setDb_pwd(String db_pwd) {
    this.db_pwd = db_pwd;
  }

  /*DB Connect*/
  private boolean open(){
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");//mysql 드라이버가 있는지 없는지 검사(새 프로젝트 생성 시에 라이브러리에 추가 매번 해주기!)
      connection = DriverManager.getConnection(db_url, db_id, db_pwd);//driverManager에게 connection 요청
      return true;

    }catch (ClassNotFoundException e){//드라이버가 없을 경우 먼저 체크한 후에 db로 던짐
      System.err.println(e.getMessage());
      return false;
    }catch(SQLException e){//db문제 메시지 출력
      System.err.println(e.getMessage());
      return false;
    }
  }


  /*DB Disconnect*/
  protected boolean close(){
    try {
      connection.close();
      return true;
    }catch (SQLException e){
      System.err.println(e.getMessage());//close 하다가 문제가 생기면 메시지를 출력해서 사용자를 안심시킨다.
      return false;
    }
  }



  /*query 실행시 search => select 쿼리문*/
  //select문은 레코드 단위로 response를 받음 => ResultSet이 필요함!
  protected ResultSet execute(String query, ResultSet rs){
    try {
      open();//connection 요청 메소드 실행
      Statement obj = connection.createStatement();
      rs = obj.executeQuery(query);//작성한 쿼리문을 던지고 받음
      close();//사용 후 커넥션 닫음

    }catch (SQLException e){
      System.err.println(e.getMessage());
    }
    return rs;//
  }


  /*query 실행 insert, delete, update 쿼리문*/
  protected boolean execute(String query){
    boolean result1 = false;
    try {
      open();//커넥션 요청
      Statement obj = connection.createStatement();
      int result = obj.executeUpdate(query);//작성한 쿼리 던짐
      if(result ==1){
        result1=true;
      }else {
        result1 = false;
      }
      close();//사용 후 닫음
    }catch (SQLException e){
      System.err.println(e.getMessage());
      return result1;
    }
    return result1;
  }

}
