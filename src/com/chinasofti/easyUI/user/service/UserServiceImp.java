package com.chinasofti.easyUI.user.service;

import java.util.List;

import com.chinasofti.easyUI.user.dao.UserDao;
import com.chinasofti.easyUI.user.dao.UserDaoImp;
import com.chinasofti.easyUI.user.entity.User;

public class UserServiceImp implements UserService{
	UserDao dao=new UserDaoImp();
	@Override
	public List<User> queryAllUser() {
		// TODO Auto-generated method stub
		return dao.queryAllUser();
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public User queryOneUser(int u_id) {
		// TODO Auto-generated method stub
		return dao.queryOneUser(u_id);
	}

	@Override
	public boolean deleteUser(int u_id) {
		// TODO Auto-generated method stub
		return dao.deleteUser(u_id);
	}

}
