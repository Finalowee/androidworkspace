package com.panchuang.xml_serilalizer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import com.panchuang.xml_serilalizer.model.*;

import android.app.Activity;
import android.os.Bundle;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	private List<Message> smsList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		smsList = new ArrayList<Message>();
		for(int i = 0; i < 10 ; i ++){
			Message sms = new Message("兰"+i,"2015.10.1"+i,"13"+i,"1");
			smsList.add(sms);
		}
	}
	
	public void click(View v){
		XmlSerializer xs = Xml.newSerializer();
		try{
			FileOutputStream file = new FileOutputStream(new File("sdcard/sms2.xml"));
			//指定xml生成的编码类型
			xs.setOutput(file, "utf-8");
			//指定头结点中的encoding属性的值
			xs.startDocument("utf-8", true);
			xs.startTag(null, "Message");
			for(Message sms : smsList){
				xs.startTag(null, "sms");
				xs.startTag(null, "body");
				xs.text(sms.getBody());
				xs.endTag(null, "body");
				
				xs.startTag(null, "date");
				xs.text(sms.getDate());
				xs.endTag(null, "date");
				
				xs.startTag(null, "address");
				xs.text(sms.getAddress());
				xs.endTag(null, "address");
				
				xs.startTag(null, "type");
				xs.text(sms.getType());
				xs.endTag(null, "type");
				xs.endTag(null, "sms");
			}
			xs.endTag(null, "Message");
			xs.endDocument();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}