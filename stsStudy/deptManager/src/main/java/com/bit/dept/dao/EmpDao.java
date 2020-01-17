package com.bit.dept.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bit.dept.db.DBManager;
import com.bit.dept.vo.SearchVo;

@Repository
public class EmpDao {

	public List<SearchVo> searchEmp(String name){
		return DBManager.searchList(name);
	}
}
