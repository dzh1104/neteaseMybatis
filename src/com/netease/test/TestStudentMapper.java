package com.netease.test;

import com.netease.entity.Address;
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

//	查询某个学生
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

//  查询单个学生 (使用了转换器)
public static void queryStudentByStunoWithConvert() throws IOException {
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	//	接口中的方法 -> SQL语句
	Student student = mapper.queryStudentByStunoWithConvert(1);
	
	System.out.println(student);
	
	sqlSession.close();
}

//	增加学生 (带转换器)
public static void addStudentWithConvert() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
//	stuSex 属性 设置为 true，增加成功 数据库对应的值 应该是 1
	Student student = new Student(8, "huzi", 30, "d9", true);
	
	StudentMapper sqlSessionMapper = sqlSession.getMapper(StudentMapper.class);
	sqlSessionMapper.addStudentWithConvert(student);
	//	由于事务提交类型是 JDBC，所以要手动提交
	sqlSession.commit();
	
	System.out.println("增加成功");
	
	sqlSession.close();
	
}


//	查询某个学生
public static void queryStudentByStuname() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	//	接口中的方法 -> SQL语句
	Student student = mapper.queryStudentByStuname("huzi");
	
	System.out.println(student);
	
	sqlSession.close();
}

public static void queryStudentsOrderByColumn() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	//	String statement = "com.netease.entity.studentMapper.queryAllStudents";
	//
	//	List<Student> students = sqlSession.selectList(statement);
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	//	根据接口中的方法 自动对应 SQL语句
	List<Student> students = mapper.queryStudentsOrderByColumn("stuno");
	
	/**
	 * 通过sqlSession对象获取接口(sqlSession.getMapper(接口.class))，再调用该接口中的方法，程序会自动执行该方法对应的SQL
	 * */
	
	System.out.println(students);
	
	sqlSession.close();
	
}

public static void queryStudentsBystuageOrstuname() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	Student student = new Student();
//	student.setStuName("huzi");

//	方式一:
//	select * from student where stuage = #{stuAge} or stuname like #{stuName}
//	student.setStuName("%hu%");

//	方式二:
//	select * from student where stuage = #{stuAge} or stuname like '%${stuName}%'
	student.setStuName("hu");
	student.setStuAge(18);
	
	//	根据接口中的方法 自动对应 SQL语句
	List<Student> students = mapper.queryStudentsBystuageOrstuname(student);
	
	/**
	 * 通过sqlSession对象获取接口(sqlSession.getMapper(接口.class))，再调用该接口中的方法，程序会自动执行该方法对应的SQL
	 * */
	
	System.out.println(students);
	
	sqlSession.close();
	
}

//  根据地址查学生
public static void queryStudentByaddress() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	Student student = new Student();
	
	Address address = new Address();
	address.setHomeAddress("bj");
	address.setSchoolAddress("bj");
	
	student.setAddress(address);
	
	//	根据接口中的方法 自动对应 SQL语句
//	List<Student> students = mapper.queryStudentByaddress(address);
	List<Student> students = mapper.queryStudentByaddress(student);
	
	/**
	 * 通过sqlSession对象获取接口(sqlSession.getMapper(接口.class))，再调用该接口中的方法，程序会自动执行该方法对应的SQL
	 * */
	
	System.out.println(students);
	
	sqlSession.close();
	
}


public static void main(String[] args) throws IOException {
//	queryAllStudents();
//
//	queryStudentByStuno();
//
//	updateStudentByStuno();
//
//	queryAllStudents();
	
//	queryStudentByStunoWithConvert();
	
//	addStudentWithConvert();
	
//	queryStudentByStuname();
	
//	queryStudentsOrderByColumn();
	
//	queryStudentsBystuageOrstuname();
	
	queryStudentByaddress();
}

}
