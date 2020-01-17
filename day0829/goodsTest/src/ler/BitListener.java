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
	
	//현재 날짜와 시간에 대한 방법 - date....등
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
    	System.out.println("새로운 사용자 방문!");
    	start = System.currentTimeMillis();
    	System.out.println("요청시간"+start);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // 세션파기될때
    	long end = System.currentTimeMillis();
    	long delay = end - start;
    	System.out.println("머무른 시간: "+delay);
    }
	
}
