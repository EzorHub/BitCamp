package ex01;

public class WriteArticleServiceImple {
	private ArticleDao articleDato;
	//���������� �ٿ��� ���� �����Ǿ��־����
	public WriteArticleServiceImple(ArticleDao articleDao) {
		super();
		this.articleDato = articleDao;
	}
	
	public void insert() {
		articleDato.insert();
	}
}
