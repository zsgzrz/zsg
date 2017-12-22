package com.chinasofti.easyUI.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.chinasofti.easyUI.user.entity.User;
import com.chinasofti.easyUI.user.utils.MybatisUtils;

public class UserDaoImp implements UserDao {

	public List<User> queryAllUser() {
		SqlSession sqlSession = MybatisUtils.getSqlSession(false);
		List<User> list = sqlSession.selectList("com.chinasofti.easyUI.user.entity.userMapper.queryAllUser");
		return list;
	}

	@Override
	public boolean addUser(User user) {
		SqlSession sqlSession = MybatisUtils.getSqlSession(true);
		int insert = sqlSession.insert("com.chinasofti.easyUI.user.entity.userMapper.addUser",user);
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		SqlSession sqlSession = MybatisUtils.getSqlSession(true);
		sqlSession.update("com.chinasofti.easyUI.user.entity.userMapper.updateUser", user);
		return false;
	}

	@Override
	public User queryOneUser(int u_id) {
		SqlSession sqlSession = MybatisUtils.getSqlSession(false);
		
		return sqlSession.selectOne("com.chinasofti.easyUI.user.entity.userMapper.queryOneUser", u_id);
	}

	@Override
	public boolean deleteUser(int u_id) {
		
		SqlSession sqlSession = MybatisUtils.getSqlSession(true);	
		sqlSession.delete("com.chinasofti.easyUI.user.entity.userMapper.deleteUser", u_id);
		return false;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new UserDaoImp().deleteUser(5));
	}
	

}
