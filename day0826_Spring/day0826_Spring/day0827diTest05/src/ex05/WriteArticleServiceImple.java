package ex05;

public class WriteArticleServiceImple {
	private ArticleDao articleDao;
	//���������� �ٿ��� ���� �����Ǿ��־����
	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
		
	public void insert() {
		articleDao.insert();
	}


	
}
