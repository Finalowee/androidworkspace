package com.panchuang.manager;

import com.panchuang.manager.io.IOUtils;
import com.panchuang.manager.model.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IOUtils.loadUserInfo("userInfo.txt", "res");
		User u = new User(3,"zhangsan",20,"male",10000);
		IOUtils io = new IOUtils();
		io.addUserInfo(u);
	}
}
