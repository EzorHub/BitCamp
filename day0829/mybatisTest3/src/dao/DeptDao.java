package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import db.DeptManager;
import vo.DeptVo;

@Repository
public class DeptDao {

	public List<DeptVo> listAll(){
		
		return DeptManager.listAll();
	}

}
