package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import db.DBManager;
import vo.BoardVo;

@Repository
public class BoardDao {

	public List<BoardVo> listAll(){
		return DBManager.listAll();
	}
	
	public int insert(BoardVo b) {
		return DBManager.insertBoard(b);
	}
	
	public int getNextNo() {
		return DBManager.getNextNo();
	}
	
	public BoardVo detail(int no) {
		return DBManager.detailBoard(no);
	}

	public void updateStep(int b_ref, int b_step) {
		//답글 증가시켜주는 것
		DBManager.updateStep(b_ref, b_step);		
	}
	public int updateBoard(BoardVo b) {
		return DBManager.updateBoard(b);
	}
	public int deleteBoard(int no, String pwd) {
		return DBManager.deleteBoard(no, pwd);
	}
	
	public List<BoardVo> searchBoard(HashMap map){
		
		return DBManager.searchBoard(map);
	}
	
	
}
