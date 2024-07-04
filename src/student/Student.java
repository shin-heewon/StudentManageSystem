package student;

public class Student {

  private int sno;
  private String name;
  private int[] record = new int[4];//학생 정보(각 과목 점수)을 저장할 공간
  private int total;
  private double average;
  private String grade;
  private int rank = -1;
  static enum GRADE{A,B,C,D,F};


  public Student(){}

  /*각각의 값들을 받아와서 makeScores()를 하기 위한 생성자*/
  public Student(String name, int korea, int english, int math, int science){
    //생성자 : 인스턴스 멤버의 초기화
    this.sno = sno;
    this.name = name;
    this.record[0] = korea;
    this.record[1] = english;
    this.record[2] = math;
    this.record[3] = science;

    this.makeScores();

  }

  /*데이터베이스에서 값을 받아와서 저장하는 용도, Student객체를 만들기 위한 생성자*/
  public Student(int sno, String name, int korea, int english, int math, int science,int total, double average, String grade){
    this.sno = sno;
    this.name = name;
    this.record[0] = korea;
    this.record[1] = english;
    this.record[2] = math;
    this.record[3] = science;
    this.total = total;
    this.average = average;
    this.grade = grade;


  }

  /*합계와 평균을 구할 메소드*/
  private void makeScores() {
    for(int score : record){//향상된 for문이 성능 향상에 더 좋다. 이터레이터
      this.total += score;
    }
    this.average = (double) this.total/record.length;
    this.makeGrade();
  }


  //enum이용해서 등급 매기기
  private void makeGrade() {
    int base = (int) average / 10;

    switch (base){
      case 10, 9 -> grade = GRADE.A.toString();
      case 8 -> grade = GRADE.B.toString();
      case 7 -> grade = GRADE.C.toString();
      case 6 -> grade = GRADE.D.toString();
      default -> grade = GRADE.F.toString();

    }


  }

  /*getter*/
  public int getSno() {
    return sno;
  }

  public String getName() {
    return name;
  }

  public int[] getRecord() {
    return record;
  }

  public int getTotal() {
    return total;
  }

  public double getAverage() {
    return average;
  }

  public String getGrade() {
    return grade;
  }

  public int getRank() {
    return rank;
  }

  /*setter*/
  public void setRank(int rank) {
    this.rank = rank;
  }
}
