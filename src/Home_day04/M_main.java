package Home_day04;

public class M_main {

	public static void main(String[] args) {

		M_mannger member = new M_mannger ();
		boolean run = true;
		while(run) {
			
			switch (member.ShowMenu()) {
			case 1:
				if(member.getLoginID() == null) {
					member.InsertMember();
				}else {
					member.MyInfo();
				}
				break;
				
			case 2:
				if(member.getLoginID() == null) {
					member.Login();
				}else {
					member.LogOut();
				}
				break;
				
			case 3:
				if(member.getLoginID() != null) {
					member.changeInfo();
				}else {
					System.out.println("프로그램을 종료합니다");
					run = false;
				}
				break;
				
			case 4:
				if(member.getLoginID() != null) {
					member.secession();
				}else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;
				
			case 5:
				if(member.getLoginID() != null) {
					System.out.println("프로그램을 종료합니다");
					run = false;
				}else {
					System.out.println("잘못 입력하셨습니다");
				}
				break;


			default:
				System.out.println("잘못 입력하셨습니다");
				break;
			}
		}
		
		System.out.println("프로그램이 정상적으로 종료되었습니다.");
	}
	

}
