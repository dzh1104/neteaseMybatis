package com.netease.convert;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型转换器(boolean - number) 步骤:
 *  1) 创建转换器 -- 需要实现TypeHandler接口
 *      通过阅读源码发现，此接口有一个实现类 BaseTypeHandler，因此，要实现转换器有2种选择
 *          a.实现接口TypeHander接口
 *          b.继承BaseTypeHandler类
 *
 *  2)在mybatis配置文件中 配置
 * */
public class BooleanAndIntConvert extends BaseTypeHandler<Boolean> {

// java(boolean) -> DB(int)

/**
 *
 * @param preparedStatement PreparedStatement对象
 * @param i PreparedStatement对象操作参数的位置
 * @param aBoolean java值
 * @param jdbcType jdbc操作的数据库类型
 * @throws SQLException
 */
@Override
public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
	if(aBoolean) {
		preparedStatement.setInt(i, 1);
	} else {
		preparedStatement.setInt(i, 0);
	}
}

// DB(int) -> java(boolean)
@Override
public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
//	通过列名取值
	int anInt = resultSet.getInt(s);
//	if (anInt == 1) {
//		return true;
//	} else {
//		return false;
//	}
	return anInt == 1 ? true : false;
}

// DB(int) -> java(boolean)
@Override
public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
//	通过列的下标取值
	int anInt = resultSet.getInt(i);
	return anInt == 1 ? true : false;
}

// DB(int) -> java(boolean)
@Override
public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
	int anInt = callableStatement.getInt(i);
	return anInt == 1 ? true : false;
}

}
