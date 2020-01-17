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
