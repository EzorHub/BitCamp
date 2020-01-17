package com.bit.goodsTest.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bit.goodsTest.vo.GoodsVo;

/*db(mybaties)와 연동전 바로 임의의 arrayList로해보기*/
@Repository
public class GoodsDao {

	public ArrayList<GoodsVo> listAll() {
		ArrayList<GoodsVo> list = new ArrayList<GoodsVo>();
		list.add(new GoodsVo(1, "떡볶이", 3000, 2, "tbk.jpg"));
		list.add(new GoodsVo(2, "오뎅", 2500, 2, "od.jpg"));
		list.add(new GoodsVo(3, "순대", 3000, 1, "sd.jpg"));
		return list;
	}

}
