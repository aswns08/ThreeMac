package java63.servlets.test04.dao;

import java.util.HashMap;
import java.util.List;

import java63.servlets.test04.domain.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class StudentDao {
	@Autowired
	SqlSessionFactory sqlSessionFactory;

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}//setSqlSessionFactory

	public StudentDao() {}

	public Student selectOne(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne(
					"java63.servlets.test04.dao.StudentDao.selectOne", 
					no);
		} finally {
			sqlSession.close();
		}
	}//selectOne

	public void update(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.update(
					"java63.servlets.test04.dao.StudentDao.update", student);
			sqlSession.commit();	
		} finally {
			sqlSession.close();
		}

	}//update

	public void delete(int no) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.delete(
					"java63.servlets.test04.dao.StudentDao.delete", no);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
	}//delete

	public List<Student> selectList(int pageNo, int pageSize) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("startIndex", ((pageNo - 1) * pageSize));
		paramMap.put("pageSize", pageSize);

		try {
			return sqlSession.selectList(
					"java63.servlets.test04.dao.StudentDao.selectList",
					paramMap);
		} finally {
			sqlSession.close();
		}

	}//studentselectList

	public void insert(Student student) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			sqlSession.insert(
					"java63.servlets.test04.dao.StudentDao.insert", student);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}//insert

}
