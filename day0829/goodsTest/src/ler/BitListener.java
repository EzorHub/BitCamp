package ler;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class BitListener
 *
 */
@WebListener
public class BitListener implements HttpSessionListener {
	
	//���� ��¥�� �ð��� ���� ��� - date....��
	long start;
	

    /**
     * Default constructor. 
     */
    public BitListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("���ο� ����� �湮!");
    	start = System.currentTimeMillis();
    	System.out.println("��û�ð�"+start);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // �����ı�ɶ�
    	long end = System.currentTimeMillis();
    	long delay = end - start;
    	System.out.println("�ӹ��� �ð�: "+delay);
    }
	
}
