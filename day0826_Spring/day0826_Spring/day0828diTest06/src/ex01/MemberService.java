package ex01;

public class MemberService {

	private UpdateInfo info;
	//has a ����!

	public void setInfo(UpdateInfo info) {
		this.info = info;
	}
	
	public boolean update(String memberId) {
		System.out.println(memberId+"�� ������ "
				+ info.getId()+"�� �����߽��ϴ�.");
		return true;
	}
}
