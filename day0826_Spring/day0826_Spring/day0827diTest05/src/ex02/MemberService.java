package ex02;
//memberService 객체를 제공하는 xml제공 - main메소드 만들어서 결과확인
public class MemberService {
	private Member member;

	public MemberService(Member member) {
		super();
		this.member = member;
	}
	public void service() {
		//어플리케이션에게 member 객체의 서비스를 제공해주고 싶음?
		member.info();
	}
}
