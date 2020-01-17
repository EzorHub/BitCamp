package ex05;

public class WriteArticleServiceImple {
	private ArticleDao articleDao;
	//순서상으로 다오가 먼저 생성되어있어야함
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
		
	public void insert() {
		articleDao.insert();
	}


	
}
