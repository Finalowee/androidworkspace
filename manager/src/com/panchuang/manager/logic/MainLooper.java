package com.panchuang.manager.logic;

import com.panchuang.manager.io.UserInput;

public class MainLooper {
	private boolean flag = true;
	public UserInput userInput;
	public MainLooper() {
		userInput = new UserInput();
	}
	
	public void loop(){
		while (flag){
			String input = userInput.getInputLine();
			System.out.println(input);
		}
	}
}
