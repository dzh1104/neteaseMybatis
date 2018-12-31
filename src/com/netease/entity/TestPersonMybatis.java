package com.netease.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class TestPersonMybatis {

public static void main(String[] args) throws IOException {
	//	加载Mybatis配置文件（为了访问数据库）
	//	将硬盘中的配置文件，读到内存中，变成一个Reader对象
	Reader reader = Resources.getResourceAsReader("config.xml");
	
	/**
	 * 文件路径:
	 *  config.xml位于不同目录下时，上面对应的地址写法分别如下:
	 *      src => config.xml
	 *      src/com => com/config.xml
	 *      src/com/netease => com/netease/config.xml
	 */
	
	/**
	 * mybatis的官方文档: http://www.mybatis.org/mybatis-3/zh/index.html
	 * 可下载 mybatis-3.4.6.jar
	 *
	 * mysql-connector-java-8.0.13.jar 数据库驱动jar包的下载，可去maven仓库
	 *  License	GPL 2.0
	 *  Categories	MySQL Drivers
	 *  Organization	Oracle Corporation
	 *  HomePage	http://dev.mysql.com/doc/connector-j/en/
	 *  Date	(Sep 27, 2018)
	 *  Files	jar (2.0 MB)  View All
	 *  Repositories	Central
	 *  Used By	3,289 artifacts
	 *
	 * 上面的 Files jar，点击可下载jar包
	 */
	
	//	SqlSessionFactory
	//	在通过reader对象，创建出一个 sqlSessionFactory 对象，进而创建 sqlSession 来操作数据库
	//	第二个参数可指定 数据库的运行环境
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
	
	//	sqlSession(mybatis需要sqlSession来操作数据库) - connection(JDBC需要connection来操作数据库)
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	//	namespace + id，取得 sql语句
	String statement = "com.netease.entity.personMapper.queryPersonById";
	
	//	执行sql语句，传入参数，并获取结果
	Person person = sqlSession.selectOne(statement, 1);
	System.out.println(person.toString());
	
	//	关闭资源
	sqlSession.close();
}

}
