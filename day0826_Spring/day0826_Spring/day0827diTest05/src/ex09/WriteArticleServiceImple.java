package ex09;

public class WriteArticleServiceImple {
	private ArticleDao articleDao;

	
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
		
	public void insert() {
		articleDao.insert();
	}


	
}
