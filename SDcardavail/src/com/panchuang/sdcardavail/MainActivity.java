package com.panchuang.sdcardavail;

import java.io.File;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.format.Formatter;
import android.widget.TextView;

public class MainActivity extends Activity {

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		File path = Environment.getExternalStorageDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSizeLong();
		long totalBlocks = stat.getBlockCountLong();
		long availableBlocks = stat.getAvailableBlocksLong();
		
		TextView tv_sd_avail = (TextView)findViewById(R.id.tv_sd_avail);
		tv_sd_avail.setText(formatSize(availableBlocks*blockSize));
	}

	private String formatSize(long size){
		return Formatter.formatFileSize(this, size);
	}
}
