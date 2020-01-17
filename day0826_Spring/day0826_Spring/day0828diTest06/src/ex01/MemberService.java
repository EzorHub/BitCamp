package ex01;

public class MemberService {

	private UpdateInfo info;
	//has a 관계!

	public void setInfo(UpdateInfo info) {
		this.info = info;
	}
	
	public boolean update(String memberId) {
		System.out.println(memberId+"의 정보를 "
				+ info.getId()+"로 수정했습니다.");
		return true;
	}
}
