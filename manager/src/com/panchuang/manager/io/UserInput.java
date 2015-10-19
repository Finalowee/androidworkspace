package com.panchuang.manager.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//读取用户键盘输入
public class UserInput {
	private BufferedReader bufferedReader;
	
	public UserInput() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public String getInputLine(){
		String inputLine = "sdddddd";
		try {
			inputLine = bufferedReader.readLine();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return inputLine;
		
	}
}
