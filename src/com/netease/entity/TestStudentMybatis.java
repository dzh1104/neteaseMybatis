package com.netease.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestStudentMybatis {
	
	/**
	 * 注意事项:
	 *  1) 如果使用的事务方式是JDBC，则需要手动commit提交，即sqlSession.commit();
	 *  2) 所有的标签 <select></select> <update></update>，都必须有sql语句，但是sql参数值可选
	 *      sql有参数: sqlSession.insert(statement, 参数值);
	 *      sql无参数  sqlSession.insert(statement);
	 * */

//	查询单个学生
public static void queryStudentByStuno() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	String statement = "com.netease.entity.studentMapper.queryStudentByStuno";
	
	Student student = sqlSession.selectOne(statement, 1);
	
	System.out.println(student);
	
	sqlSession.close();
	
}

//	查询全部学生
public static void queryAllStudents() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	String statement = "com.netease.entity.studentMapper.queryAllStudents";
	
	List<Student> students = sqlSession.selectList(statement);
	
	System.out.println(students);
	
	sqlSession.close();
	
}

//	增加学生
public static void addStudent() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	String statement = "com.netease.entity.studentMapper.addStudent";
	
	Student student = new Student(4, "mazi", 18, "b1");
	
	int count = sqlSession.insert(statement, student);
	
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("增加" + count + "个学生");
	
	sqlSession.close();
	
}

//	删除学生
public static void deleteStudentByStuno() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	String statement = "com.netease.entity.studentMapper.deleteStudentByStuno";
	
	int count = sqlSession.delete(statement, 3);
	
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("删除" + count + "个学生");
	
	sqlSession.close();
	
}

//	修改学生
public static void updateStudentByStuno() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	String statement = "com.netease.entity.studentMapper.updateStudentByStuno";
	
	//	修改的参数
	Student student = new Student();
	//	修改哪个人，where stuno = ?
	student.setStuNo(1);
	//	修改成什么样子？
	student.setStuAge(44);
	student.setGraName("lxs");
	student.setGraName("s2");
	
	//	执行
	int count = sqlSession.update(statement, student);
	
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("修改" + count + "个学生");
	
	sqlSession.close();
	
}

public static void main(String[] args) throws IOException {
	//	queryStudentByStuno();
	queryAllStudents();
	
	//	addStudent();
	
	deleteStudentByStuno();
	
	//	手动提交事务后，这条查询才能多条记录
	queryAllStudents();
}

}
