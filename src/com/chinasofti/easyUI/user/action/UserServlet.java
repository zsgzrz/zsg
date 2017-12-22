package com.chinasofti.easyUI.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.chinasofti.easyUI.user.entity.User;
import com.chinasofti.easyUI.user.service.UserServiceImp;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String method = request.getParameter("method");
		if("queryAllUser".equals(method)){
			queryAllUser(response);
		}else if("addUser".equals(method)){
			addUser(request,response);
			
		}else if("updateUser".equals(method)){
			
			User user = new User(Integer.parseInt(request.getParameter("u_id")),request.getParameter("u_name"), request.getParameter("u_loginName"), request.getParameter("u_password"), request.getParameter("u_age")==null?0:Integer.parseInt(request.getParameter("u_age")), request.getParameter("u_sex"));
			System.err.println(user.getU_id());
			new UserServiceImp().updateUser(user);
			String str = "{\"status\":\"ok\",\"message\":\"用户保存操作成功!\"}";
			response.getWriter().print(str);
		}else if("deleteUser".equals(method)){
			new UserServiceImp().deleteUser(Integer.parseInt(request.getParameter("u_id")));
			String str = "{\"status\":\"ok\",\"message\":\"用户保存操作成功!\"}";
			response.getWriter().print(str);
		}
		/*private Integer u_id;
		private String u_name;
		private String u_loginName;
		private String u_password;
		private Integer u_age;
		private String u_sex;*/
	}

	private void addUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		try {
			User user = new User(request.getParameter("u_name"), request.getParameter("u_loginName"), request.getParameter("u_password"), request.getParameter("u_age")==null?0:Integer.parseInt(request.getParameter("u_age")), request.getParameter("u_sex"));
			new UserServiceImp().addUser(user);
			String str = "{\"status\":\"ok\",\"message\":\"用户保存操作成功!\"}";
			response.getWriter().print(str);
		} catch (IOException e) {
			String str = "{\"status\":\"fail\",\"message\":\"用户保存操作失败!\"}";
			response.getWriter().write(str);
			e.printStackTrace();
		}
	}

	private void queryAllUser(HttpServletResponse response) throws IOException {
		List<User> list = new UserServiceImp().queryAllUser();
		String slist = JSONArray.fromObject(list).toString();
		response.getWriter().print(slist);
	}
	
	
}
