package com.chinasofti.easyUI.user.dao;

import java.util.List;

import com.chinasofti.easyUI.user.entity.User;

public interface UserDao {
	public List<User> queryAllUser();
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public User queryOneUser(int u_id);
	public boolean deleteUser(int u_id);
}
