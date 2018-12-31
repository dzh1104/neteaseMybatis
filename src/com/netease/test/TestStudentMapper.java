package com.netease.test;

import com.netease.entity.Student;
import com.netease.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class TestStudentMapper {

public static void queryStudentByStuno() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	//	接口中的方法 -> SQL语句
	Student student = mapper.queryStudentByStuno(1);
	
	System.out.println(student);
	
	sqlSession.close();
}

//	查询全部学生
public static void queryAllStudents() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	//	String statement = "com.netease.entity.studentMapper.queryAllStudents";
	//
	//	List<Student> students = sqlSession.selectList(statement);
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
//	根据接口中的方法 自动对应 SQL语句
	List<Student> students = mapper.queryAllStudents();
	
	/**
	 * 通过sqlSession对象获取接口(sqlSession.getMapper(接口.class))，再调用该接口中的方法，程序会自动执行该方法对应的SQL
	 * */
	
	System.out.println(students);
	
	sqlSession.close();
	
}

//	增加学生
public static void addStudent() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	
	Student student = new Student(4, "xiaoliu", 16, "b6");
	
	StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
	sqlSessionMapper.addStudent(student);
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("增加成功");
	
	sqlSession.close();
	
}

//	删除学生
public static void deleteStudentByStuno() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
	sqlSessionMapper.deleteStudentByStuno(2);
	
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("删除成功");
	
	sqlSession.close();
	
}

//	修改学生
public static void updateStudentByStuno() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	//	修改的参数
	Student student = new Student();
	//	修改哪个人，where stuno = ?
	student.setStuNo(1);
	//	修改成什么样子？
	student.setStuAge(44);
	student.setStuName("lxs");
	student.setGraName("s2345");
	
	//	执行
	StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
	sqlSessionMapper.updateStudentByStuno(student);
	
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("修改成功");
	
	sqlSession.close();
	
}

public static void main(String[] args) throws IOException {
	queryAllStudents();
	
	queryStudentByStuno();
	
	updateStudentByStuno();
	
	queryAllStudents();
}

}
