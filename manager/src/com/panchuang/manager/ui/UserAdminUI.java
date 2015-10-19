package com.panchuang.manager.ui;

import java.util.Properties;

import com.panchuang.manager.io.IOUtils;
import com.panchuang.manager.model.User;

public class UserAdminUI {
	private static Properties properties = null;
	
	static{
		properties = IOUtils.loadProperties("help.properties", "res");
	}
	
	public void getHelpInfo(String key){
		System.out.println(properties.getProperty(key));
	}
	
	public void systemStart(){
		getHelpInfo("menu");
	}
	public void addHelp(){
		getHelpInfo("add_user");
	}
	public void deleteHelp(){
		getHelpInfo("delete_user");
	}
	public void updateHelp(){
		getHelpInfo("update_userr");
	}
	public void queryHelp(){
		getHelpInfo("query_user");
	}
	
	public void displayUserInfo(User user){
		System.out.println(user.toString());
	}
}
