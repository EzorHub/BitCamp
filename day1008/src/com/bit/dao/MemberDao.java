package com.bit.dao;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {
	public void insert(String name) {
		System.out.println(name+"�� ������ ����߽��ϴ�.");
	}
	public List<String> listMember(){
		List<String> list = new ArrayList<String>();
		list.add("���̾�");
		list.add("����");
		list.add("��");
		list.add("���ε�");
		list.add("Ʃ��");
		System.out.println("ȸ�����: "+list);
		//System.out.println("�Ǹ����� �ڷ�: "+list.get(100)); // �ǵ��� ���ܹ߻���Ű��!
		return list;
				
	}

}
