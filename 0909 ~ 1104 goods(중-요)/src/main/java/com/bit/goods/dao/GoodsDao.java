package com.bit.goods.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.goods.db.DBManager;
import com.bit.goods.vo.GoodsVo;

@Repository
public class GoodsDao {

	public List<GoodsVo> listAll(){
		return DBManager.listAll();
	}
	
	public GoodsVo getGoods(int no) {
		return DBManager.getGoods(no);
	}
	
	public int getNextNo() {
		return DBManager.getNextNo();
	}
	public int insertGoods(GoodsVo g) {
		return DBManager.insertGoods(g);				
	}
}

*cafe_notice 우선은 null;

String cafe_name = "", cafe_info = "", cafe_loc = "", cafe_phone = "", cafe_hrs = "", 
cafe_notice = "", cafe_cp = "", cafe_rp = "";
int seats = 0;

