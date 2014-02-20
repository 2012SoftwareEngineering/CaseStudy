package com.example.demoone;

import domain.businessEntity.systemManagement.User;
import domain.businessService.systemManagement.ISystemManagementService;
import domain.businessService.systemManagement.SystemManagementService;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class EditActivity extends Activity {

	private EditText edit_userName, edit_userPhone, edit_userTel,
			edit_userEmail, edit_userQQ, edit_userProfessional,
			edit_userAddress;
	private ImageButton imageBtn_save;
	private ISystemManagementService service;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//ʵ����SystemManagementServcie
		service = new SystemManagementService();
		//��ʼ��view
		initView();
		/**
		 * ���������������Ӧ���
		 */
		imageBtn_save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				User user = new User();
				//ʹ��getText������ȡ�༭��ؼ�������
				user.setUsername(edit_userName.getText().toString());
				user.setUserPhone(edit_userPhone.getText().toString());
				user.setEmail(edit_userEmail.getText().toString());
				user.setUserProfessional(edit_userProfessional.getText().toString()); 
				
			}
		});
	}
	
	private void initView()
	{
		edit_userName = (EditText) findViewById(R.id.edit_userName);
		edit_userPhone = (EditText) findViewById(R.id.edit_userPhone);
		edit_userEmail = (EditText) findViewById(R.id.edit_userEmail);
		edit_userProfessional = (EditText) findViewById(R.id.edit_userProfessional);
		imageBtn_save = (ImageButton) findViewById(R.id.imageBtn_save);
	}
	
	
}
