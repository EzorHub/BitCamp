package com.ajaxTest.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ajaxTest.db.DBManager;
import com.ajaxTest.vo.GoodsVo;

@Repository
public class GoodsDao {

	public List<GoodsVo> listAll(){
		return DBManager.listAll();
	}
}
