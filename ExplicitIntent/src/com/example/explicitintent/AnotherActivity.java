package com.example.explicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AnotherActivity extends Activity{
	private TextView tvInfo;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_another);
		tvInfo=(TextView)findViewById(R.id.tvInfo);
		Intent intent=getIntent();
		if(intent!=null){
			String data=intent.getStringExtra("data");
			if(data!=null){
				tvInfo.setText("接收到的数据是:"+data);
			}
		}
	}
}
