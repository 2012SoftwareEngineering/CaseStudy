package com.example.demoone;

import domain.businessEntity.systemManagement.User;
import domain.businessService.systemManagement.ISystemManagementService;
import domain.businessService.systemManagement.SystemManagementService;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv_username;
	private TextView tv_phone;
	private TextView tv_email;
	private TextView tv_professional;
	private ISystemManagementService service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		service = new SystemManagementService();
		initView();
	}
	public void initView(){
		tv_username = (TextView) findViewById(R.id.tv_watch_card_info_name);
		tv_email = (TextView) findViewById(R.id.tv_watch_card_info_email);
		tv_phone = (TextView) findViewById(R.id.tv_watch_card_info_mobilephone);
		tv_professional = (TextView) findViewById(R.id.tv_watch_card_info_professional);
		
		Bundle bundle = getIntent().getExtras();
		User user = service.findUserByPhone(bundle.getString("phone"));
		tv_username.setText(user.getUsername());
		tv_email.setText(user.getEmail());
		tv_professional.setText(user.getUserProfessional());
		tv_phone.setText(user.getUserPhone());
	}
}
