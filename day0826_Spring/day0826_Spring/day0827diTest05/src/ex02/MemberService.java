package ex02;
//memberService ��ü�� �����ϴ� xml���� - main�޼ҵ� ���� ���Ȯ��
public class MemberService {
	private Member member;

	public MemberService(Member member) {
		super();
		this.member = member;
	}
	public void service() {
		//���ø����̼ǿ��� member ��ü�� ���񽺸� �������ְ� ����?
		member.info();
	}
}
