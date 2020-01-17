package ex11;

public class WriteArticleService {

	private MemberDao dao;

	public void setDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public void insert() {
		dao.insertMember();
	}
}
