package com.panchuang.manager.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

import com.panchuang.manager.model.User;
public class IOUtils {
	
	//装载资源文件函数
	public static Properties loadProperties(String fileName,String dir){
		Properties pro = new Properties();
		
		String propertiesDir = System.getProperty("user.dir");
		String propertiesPath = propertiesDir + File.separator + dir + File.separator + fileName;
		
		try {
			InputStream in = new FileInputStream(propertiesPath);
			pro.load(in);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return pro;
	}
	
	//装载用户数据文件
	static RandomAccessFile randomAccessFile;

	public static RandomAccessFile loadUserInfo(String fileName,String dir){
		
		String projectPath = System.getProperty("user.dir");
		String userInfoPath = projectPath + File.separator + dir + File.separator + fileName;	
		
		try {
			randomAccessFile = new RandomAccessFile(userInfoPath,"rw");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		return randomAccessFile;
	}	
	
	//写入用户信息
	public int id = 0; 
	public boolean addUserInfo(User user){
		this.id++;
		this.id = user.id;
		
		String s = user.toString();
		try {
			randomAccessFile.seek(randomAccessFile.length());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			randomAccessFile.writeUTF(s);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;			
		}
	}
}
