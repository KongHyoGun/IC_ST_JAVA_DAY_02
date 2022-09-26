package Home_day04;

import java.util.ArrayList;
import java.util.Scanner;

public class M_mannger {

	private String LoginID;

	public String getLoginID() {
		return LoginID;
	}

	M_info Member = null;
	ArrayList<M_info> list = new ArrayList<M_info>();
	Scanner sc = new Scanner(System.in);

	public int ShowMenu() {

		if (LoginID == null) {
			System.out.println("1.회원가입 2.로그인 3.종료");
			System.out.println(">>");
		} else {
			System.out.println("1.내정보 2.로그아웃 3.프로필수정 4.계정탈퇴 5.종료");
			System.out.println(">>");
		}

		return (sc.nextInt());

	}

	public int LogInCheck() {
		int idx = -1;

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(LoginID)) {
				idx = i;
			}
		}

		return idx;

	}

	public String IDcheck() {
		String id = null;
		int idx = -1;

		while (true) {
			System.out.println("사용하실 아이디를 입력해주세요");
			id = sc.next();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null) {
					if (list.get(i).getId().equals(id)) {
						idx = i;
					}
				}
			}
			if (idx > -1) {
				System.out.println("중복된 아이디입니다.");
				idx = -1;
			} else {
				break;
			}

		}

		return id;
	}

	public void InsertMember() {

		Member = new M_info();

		System.out.println("사용하실 이름을 입력해주세요");
		Member.setName(sc.next());

		String id = IDcheck();
		Member.setId(id);

		System.out.println("사용하실 비밀번호를 입력해주세요");
		Member.setPw(sc.next());

		if (Member.getName().equals(null) && Member.getPw().equals(null)) {
			System.out.println("입력을 옳바르게 해주십쇼");
		} else
			System.out.println("회원가입에 성공하였습니다.");
		list.add(Member);

	}

	public void Login() {
		int count = 0 ;
		int idx = -1;
		while (true) {
			System.out.println("\n아이디 비밀번호를 입력해주세요");
			System.out.println("아이디를 입력하세요:");
			String id = sc.next();
			System.out.println("비밀번호를 입력하세요:");
			String pw = sc.next();

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getId().equals(id) && list.get(i).getPw().equals(pw)) {
					idx = i;
				}
			}
			if (idx > -1) {
				System.out.println("환영합니다.");
				LoginID = list.get(idx).getId();
				break;
			} else {
				System.out.println("아이디 또는 비밀번호가 옳바르지 못합니다.");
				count ++;
				
			}
			if(count == 5) {
				System.out.println("\n아이디 또는 비밀번호 입력실패가 5회 감지되어 초기화면으로 돌아갑니다.");
				break;
			}
		}

	}

	public void MyInfo() {
		int idx = -1;

		idx = LogInCheck();

		System.out.println("---------------------------------");
		System.out.println("이름\t아이디\t비밀번호");
		System.out.print(list.get(idx).getName());
		System.out.print("\t" + list.get(idx).getId());
		System.out.println("\t" + list.get(idx).getPw());

	}

	public void LogOut() {
		LoginID = null;
	}

	public void changeInfo() {
		int idx = -1;

		idx = LogInCheck();

		if (idx > -1) {
			System.out.println("수정하실 이름을 입력해주세요");
			list.get(idx).setName(sc.next());
		}
	}

	public void secession() {
		int idx = -1;
		int count= 0;
		idx = LogInCheck();

		while (true) {
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.println("아이디:");
			String id = sc.next();
			System.out.println("비밀번호:");
			String pw = sc.next();

			if (list.get(idx).getId().equals(id) && list.get(idx).getPw().equals(pw)) {
				System.out.println("계정이 정상적으로 탈퇴되었습니다.");
				list.remove(idx);
				LoginID=null;
				break;
			} else {
				System.out.println("아이디 또는 비밀번호가 옳바르지 못합니다.");
				count++;
			}
			if(count ==5) {
				System.out.println("\n아이디 또는 비밀번호 입력실패가 5회 감지되어 초기화면으로 돌아갑니다.");
				break;
			}

		}
	}

}
