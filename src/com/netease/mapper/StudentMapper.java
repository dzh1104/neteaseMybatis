package com.netease.mapper;

import com.netease.entity.Student;

import java.util.List;

//  操作mybatis的接口
public interface StudentMapper {
/**
 * mybatis约定及基于动态代理方式的增删改查
 *
 * 约定大于配置
 *
 * 约定的目标 -- 省略statement，即 根据 约定，直接定位出SQL语句
 * */

/**
 * 接口中的方法必须遵循以下约定
 * 1. 方法名 和 mapper.xml文件中标签的 id 值 相同
 * 2. 方法的输入参数 和 mapper.xml 文件中标签的 parameterType 类型一致 (如果mapper.xml的标签中没有parameterType，则说明方法中没有输入参数)
 * 3. 方法的返回值 和 mapper.xml 文件中标签的 resultTyep 类型一致 (无论查询结果是一个还是多个，在mapper
 * .xml标签中的resultType中只写一个，如果没有resultType，则说明方法的返回值为 void)
 *
 * 除了以上约定，要实现 接口中的方法和 mapper.xml 中 SQL标签一一对应，还需要以下1点:
 * 1.namespace的值 就是 接口的全类名(接口 和 mapper.xml 一一对应)
 *
 * 匹配的过程(约定的过程)
 *  1) 根据 接口名 找到 maper.xml文件(根据的是namespace == 接口全类名)
 *  2) 根绝 接口的方法名 找到 mapper.xml文件中的SQL标签(方法名 == SQL标签Id值)
 *
 *  以上两点可以保证 -- 当我们 调用 接口中的方法时，程序能自动定位到 某一个 mapper.xml文件中的SQL标签
 *
 * 习惯 -- SQL映射文件(mapper.xml) 和 接口 放在同一个包中 (注意修改mybatis的配置文件中 加载 mapper.xml文件的路径)
 *
 * 以上，可以通过接口的方法 取得 SQL语句
 *
 * 执行
 *  StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
 * 	//	接口中的方法 -> SQL语句
 * 	Student student = mapper.queryStudentByStuno(1);
 */

//  查询某个学生
Student queryStudentByStuno(int stuno);

//  查询所有学生
List<Student> queryAllStudents();

//  增加学生
void addStudent(Student student);

//  删除学生
void deleteStudentByStuno(int stuno);

//  修改学生
void updateStudentByStuno(Student student);

}
