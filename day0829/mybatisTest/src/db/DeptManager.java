package db;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import vo.DeptVo;

public class DeptManager {
	private static SqlSessionFactory factory;
	static {
		try {
			
			Reader reader
			= Resources.getResourceAsReader("db/a.xml"); //ȯ�漳�����ϸ���ġ ���� - sql��ɾ���� �������
			//�� ȯ������ ��û - �������� �޾ƿ�
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close(); //reader���� ��
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<DeptVo> listAll(){ //list�� ��ƿðž�
		List<DeptVo> list = null;
		//sql������ �������� ���丮�� ���� ���;���
		SqlSession session = factory.openSession(); 
		list = session.selectList("dept.selectAll");
		session.close();
		return list;
	}
}
