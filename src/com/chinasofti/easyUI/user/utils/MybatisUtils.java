package com.chinasofti.easyUI.user.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory factory;
	static{
		factory=new SqlSessionFactoryBuilder().build(MybatisUtils.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
	}
	public static SqlSession getSqlSession(boolean flag){
		return factory.openSession(flag);
	}
}
