package com.chat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chat.db.DBManager;
import com.chat.vo.ScheduleVo;

@Repository
public class ScheduleDao {
	
	public int insert(ScheduleVo s) {
		return DBManager.insertSchedule(s);
	}
	public List<ScheduleVo> listAll(){
		return DBManager.listSchedule();
	}
	

}
