package com.chat.db;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.chat.vo.BitMemberVo;
import com.chat.vo.ChatVo;
import com.chat.vo.GoodsVo;
import com.chat.vo.Jumun;
import com.chat.vo.JumunDetailVo;
import com.chat.vo.JumunVo;
import com.chat.vo.ScheduleVo;

public class DBManager {
	
	public static SqlSessionFactory factory;
	static {
		try {
			Reader reader
			= Resources.getResourceAsReader("com/chat/db/dbConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	//----------------2019/09/24---------------------
	public static int insertSchedule(ScheduleVo s) {
		int re = 0;
		SqlSession session = factory.openSession(true);
		re = session.insert("schedule.insert", s);
		session.close();		
		return re;
	}
	
	public static List<ScheduleVo> listSchedule(){
		List<ScheduleVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("schedule.listAll");
		session.close();
		
		return list;
		
	}	

	
	
	//------------------------------------------------------------------
	public static List<GoodsVo> listPage(HashMap map){
		List<GoodsVo> list = null;
		System.out.println(3);
		SqlSession session = factory.openSession();	
		list = session.selectList("goods.listPage", map);
		return list;
	}
	
	
	public static int goodsCount() {
		int cnt = 0;
		SqlSession session = factory.openSession();
		cnt = session.selectOne("goods.count");
		session.close();
		return cnt;
	}
	
	public static List<GoodsVo> listGoods(){
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.listGoods");
		session.close();
		return list;
	}
	
	//------------------------------------------------------------------
	/*
	 * public static List<BitMemberVo> listAll(){ List<ChatVo> list = null;
	 * SqlSession session = factory.openSession(); list =
	 * session.selectList("chat.listAll"); session.close(); return list; }
	 */
	
	public static int insertChat(ChatVo c) {
		int re = 0;
		SqlSession session = factory.openSession(true);
		re = session.insert("chat.insert", c);
		session.close();
		return re;
	}
	
	
	//----------------2019/09/25---------------------

	public static List<GoodsVo> goodsInfo() {
		// TODO Auto-generated method stub
		List<GoodsVo> list = null;
		SqlSession session = factory.openSession();
		list = session.selectList("goods.goodsInfo");
		session.close();
		return list;
	}
	
	//----------------2019/09/26---------------------
	 public static int insertJumun(Jumun jumun)
	    {
	        int r = 0;
	        int re  = 0;
	        SqlSession session = factory.openSession();
	        int no = session.selectOne("nextJumunNo");
	        JumunVo jumunVo = new JumunVo();
	        jumunVo.setNo(no);
	        jumunVo.setTotal(jumun.getTotal());
	        jumunVo.setCustid(jumun.getCustid());
	        
	        re += session.insert("goods.insertJumun", jumunVo);
	         
	        ArrayList<JumunDetailVo> list = jumun.getJumunList();
	        for(JumunDetailVo vo:list)
	        {
	            vo.setJumun_no(no);
	            session.insert("goods.insertJumunDetail", vo);
	            re += session.update("goods.updateGoodsQty", vo);
	        }
	         
	        if(re == list.size()+1)
	        {
	            session.commit();
	            r= 1;
	        }
	        else
	        {
	            session.rollback();
	        }
	        session.close();
	         
	        return r;
	    }
	 
		//----------------2019/10/01---------------------
	 
	 public static List<BitMemberVo> listAll(){
		 List<BitMemberVo> list = null;
		 SqlSession session = factory.openSession();
		 list = session.selectList("bit.listAll");
		 System.out.println("listsiZe: "+list.size());
		 session.close();
		 return list; 
	 }
	     
}
