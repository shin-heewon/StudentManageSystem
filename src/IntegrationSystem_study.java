
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import student.Student;
import student.StudentManager;

public class IntegrationSystem_study {

	static StudentManager stuManager = StudentManager.getInstance();


  //	 콘솔 입력 버퍼 생성 -> static:전체 클래스에서 공용으로 사용하겠다.
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//stream형태의 입력기기로부터 들어오는 데이터의 흐름을 입력 받는 클래스
	//reader : 문자열 행태로 읽겠다는 의미

  public static void main(String[] args) throws IOException {
		IntegrationSystem_study Instance = new IntegrationSystem_study();
		String buffer = null;

		while (true) {
			System.out.println("====== [ 메뉴를 선택 하세요 ] ======");
			System.out.println("1. 학생 관리 시스템");
			System.out.println("2. 시스템 종료");
			System.out.println("--------------------------------");

			int nSel = System.in.read() - 48;
			System.in.skip(System.in.available());

			switch (nSel) {

				case 1:
					while (true) {
						System.out.println("======= [ 학생 관리 시스템 ] =======");
						System.out.println("1. 학생 추가");
						System.out.println("2. 학생 전체 보기");
						System.out.println("3. 학생 검색");
						System.out.println("4. 학생 석차순으로 보기");
						System.out.println("5. 이전으로");
						System.out.println("--------------------------------");
						nSel = System.in.read() - 48;
						System.in.skip(System.in.available());
						switch (nSel) {
							case 1:
								Instance.insertStudent();
								continue;
							case 2:
								Instance.getStudentList();
								continue;
							case 3:
								Instance.searchStudent();
								continue;
							case 4:
								Instance.sortedStudent();
								continue;
							case 5:
								break;
							default:
								continue;
						}
						break;
					}
					continue;
				case 3:
					break;
				default:
					continue;
			}
			break;
		}
	}

  /*학생 정보 입력 기능( 학생 객체(student VO) 생성 후 삽입(저장)*/
  public void insertStudent() throws IOException{
		System.out.println("데이터를 입력하세요! : 이름, 국어, 영어, 수학, 과학");
		System.out.println("입력 종료 : exit");
		System.out.println("=======================================================");

		String buffer = null;
		String name = null;
		Student student = null;



		//라인 입력 받아서 exit가 아닐 때까지 반복!
		while (!(buffer = br.readLine()).equals("exit")) {
			try {
				//토큰 구분자를 등록해서 학생 객체 생성
				StringTokenizer st = new StringTokenizer(buffer, ",");//콤마로 구분해서 ssg 90 90 90 90 이런식으로 담을 수 있다

				/*System.out.println("=============String Tokenizer Start====================");
				while (st.hasMoreTokens()){
					System.out.println(st.nextToken());
				}*/

				if ((st.nextToken()) != null) {//첫 번째 토큰이 존재한다면
					name = st.nextToken().trim();//name변수에 첫번째 토큰 값이 이름 저장

					//성적을 토큰 단위로 읽어내서 저장
					int[] record = new int[4];
					record[0] = Integer.parseInt(st.nextToken().trim());
					record[1] = Integer.parseInt(st.nextToken().trim());
					record[2] = Integer.parseInt(st.nextToken().trim());
					record[3] = Integer.parseInt(st.nextToken().trim());

					//읽어낸 토큰들을 VO인 학생객체에 옮겨 담는다.
					student = new Student(name, record[0], record[1], record[2], record[3]);
					stuManager.insertStudent(student);
				}
			} catch (NoSuchElementException e) {
				System.out.println("입력 형식에 알맞지 않은 입력입니다. 다시 입력해 주세요!");
				continue;//다시 while문으로 되돌아감
			} catch (NumberFormatException e) {
				System.out.println("성적 입력은 숫자로만 입력 가능합니다. 다시 입력해주세요!");
				continue;
			}

		}//end while
		System.out.println("학생 정보 입력이 완료되었습니다.");

  }

	/*학생 석차 처리 기능*/
  public void sortedStudent() {

  }

	/*2번 메뉴 : 학생 전체 보기 기능*/
  public void getStudentList() {

  }

	/*3번 메뉴 : 학생의 학번으로 검색하여 정보 조회 가능*/
  public void searchStudent() {

  }


  }
