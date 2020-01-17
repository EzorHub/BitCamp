package dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import db.GoodsManager;
import vo.GoodsVo;

@Repository
public class GoodsDao {
	
	public int deleteGoods(int no) {
		return GoodsManager.deleteGoods(no);
	}
	public int updateGoods(GoodsVo g) {
		return GoodsManager.updateGoods(g);
	}
	public GoodsVo detailGoods(int no) {
		return GoodsManager.detailGoods(no);
	}

	public int insertGoods(GoodsVo g) {
		return GoodsManager.insertGoods(g);
	}
	public List<GoodsVo> listAll(){
		return GoodsManager.listAll();
	}
	public List<GoodsVo> searchGoods(HashMap map){		
		return GoodsManager.search(map);
	}
	public int getCount(HashMap map) {
		// TODO Auto-generated method stub
		return GoodsManager.getCount(map);
	}
	
}
