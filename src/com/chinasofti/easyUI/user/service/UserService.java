package com.chinasofti.easyUI.user.service;

import java.util.List;

import com.chinasofti.easyUI.user.entity.User;

public interface UserService {

	public List<User> queryAllUser();
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public User queryOneUser(int u_id);
	public boolean deleteUser(int u_id);
}
