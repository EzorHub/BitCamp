package com.bit.dao;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	public void insert(String name) {
		System.out.println(name+"의 정보를 등록했습니다.");
	}
	public List<String> listMember(){
		List<String> list = new ArrayList<String>();
		list.add("라이언");
		list.add("무지");
		list.add("콘");
		list.add("프로도");
		list.add("튜브");
		System.out.println("회원목록: "+list);
		//System.out.println("맨마지막 자료: "+list.get(100)); // 의도적 예외발생시키기!
		return list;
				
	}

}
