package com.example.demoone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

public class EditActivity extends Activity {

	private EditText edit_userName, edit_userPhone, edit_userTel,
			edit_userEmail, edit_userQQ, edit_userProfessional,
			edit_userAddress;
	private ImageButton imageBtn_save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		
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
