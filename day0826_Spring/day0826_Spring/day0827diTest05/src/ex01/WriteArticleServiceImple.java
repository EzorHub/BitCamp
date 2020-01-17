package ex01;

public class WriteArticleServiceImple {
	private ArticleDao articleDato;
	//순서상으로 다오가 먼저 생성되어있어야함
	public WriteArticleServiceImple(ArticleDao articleDao) {
		super();
		this.articleDato = articleDao;
	}
	
	public void insert() {
		articleDato.insert();
	}
}
