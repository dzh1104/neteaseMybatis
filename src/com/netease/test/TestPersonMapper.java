package com.netease.test;

import com.netease.entity.Person;
import com.netease.entity.Student;
import com.netease.mapper.PersonMapper;
import com.netease.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class TestPersonMapper {
//	查询某个人
public static void queryPersonByUid() throws IOException {
	
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
	//	接口中的方法 -> SQL语句
	Person person = mapper.queryPersonByUid(2);
	
	System.out.println(person);
	
	sqlSession.close();
}

public static void main(String[] args) throws IOException {
	queryPersonByUid();
}
	
}
