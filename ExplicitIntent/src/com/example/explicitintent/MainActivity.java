package com.example.explicitintent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnTransit;
	private Button btnTransitWithData;
	private Button btnTransitForResult;
	private Button btnTransitAnotherApp;
	private final int REQUEST_FOR_RESULT=1;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewsById();
		initOnClick();
	}
	private void findViewsById(){
		btnTransit=(Button)findViewById(R.id.btnTransit);
		btnTransitWithData=(Button)findViewById(R.id.btnTransitWithData);
		btnTransitForResult=(Button)findViewById(R.id.btnTransitForResult);
		btnTransitAnotherApp=(Button)findViewById(R.id.btnTransitAnotherApp);
	}
	private void initOnClick(){
		btnTransit.setOnClickListener(this);
		btnTransitWithData.setOnClickListener(this);
		btnTransitForResult.setOnClickListener(this);
		btnTransitAnotherApp.setOnClickListener(this);
	}
	public void onClick(View v) {
		int viewId=v.getId();
		switch(viewId){
		case R.id.btnTransit:
			transitWithoutData();
			break;
		case R.id.btnTransitWithData:
			transitWithData();
			break;
		case R.id.btnTransitForResult:
			
			break;
		case R.id.btnTransitAnotherApp:
			transitToAnotherApp();			
			break;
		}
	}
	private void transitForResult(){
		Intent intentForResult=new Intent(this,ActivityForResult.class);
		startActivityForResult(intentForResult, REQUEST_FOR_RESULT);
	}
	private void transitWithData() {
		Intent intentWithData=new Intent(this,AnotherActivity.class);
		intentWithData.putExtra("data", "MainActivityData");
		startActivity(intentWithData);
	}
	private void transitWithoutData() {
		Intent intent=new Intent(this,AnotherActivity.class);
		startActivity(intent);
	}
	   private void transitToAnotherApp() {
	        Intent intent = new Intent();
	 /** 方法一  */
//	         intent.setComponent(new ComponentName("com.example.explicitintentantoherapp",
//	         "com.example.explicitintentantoherapp.MainActivity"));
	 /** 方法二 */
	        // 在指定包名和完全限定类名时，也可以调用更加便利的setClassName方法
	        intent.setClassName("com.example.explicitintentantoherapp", "com.example.explicitintentantoherapp.MainActivity");
	 
	        startActivity(intent);
	    }
}
