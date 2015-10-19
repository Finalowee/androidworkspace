package com.panchuang.login;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText et_name;
	private EditText et_passwd;
	private CheckBox cb;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et_name = (EditText)findViewById(R.id.et_name);
		et_passwd = (EditText)findViewById(R.id.et_passwd);
		cb = (CheckBox)findViewById(R.id.cb);
		sp = getSharedPreferences("info",MODE_PRIVATE);
		readAccount();
	}
	
	public void readAccount(){
		try{
		String name = sp.getString("name", "");
		String passwd = sp.getString("passwd", "");
		
		et_name.setText(name);
		et_passwd.setText(passwd);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void bt_login(View v){
		String name = et_name.getText().toString();
		String passwd = et_passwd.getText().toString();
		
		if(cb.isChecked()){
			
			Editor ed = sp.edit();
			ed.putString("name", name);
			ed.putString("passwd", passwd);
			
			ed.commit();
			Toast.makeText(this, "��½�ɹ�", 1).show();
		}
	} 
}
