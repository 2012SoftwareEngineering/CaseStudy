package com.example.demoone;

import domain.businessEntity.systemManagement.User;
import domain.businessService.systemManagement.ISystemManagementService;
import domain.businessService.systemManagement.SystemManagementService;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginAndRegistActivity extends Activity {

	private Button btn_login, btn_regist; // ��ť��������
	private EditText et_userphone, et_password; // �༭���������
	private String userPhone, password;
	private ISystemManagementService service;

	// Activity�������ڿ�ʼ
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_regist); // ���ص�ǰActivity��ʾ��ҳ��
		service = new SystemManagementService();
		initView(); // ��ʼ��View
	}

	/**
	 * ��ʼ��View
	 */
	private void initView() {
		// ͨ��R�ļ�ӳ���ҵ�activity_login_and_regist.xml������Ӧ�Ŀؼ����ƣ�Ȼ���������ı���
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_regist = (Button) findViewById(R.id.btn_regist);
		et_userphone = (EditText) findViewById(R.id.et_userphone);
		et_password = (EditText) findViewById(R.id.et_password);

		// �Ե�¼��ť������Ӧ�ĵ������
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userPhone = et_userphone.getText().toString(); // ��ȡ������е�ֵ
				password = et_password.getText().toString();

				if (userPhone.equals("") || password.equals("")) {
					Toast toast = Toast.makeText(LoginAndRegistActivity.this,
							"�û���������������", Toast.LENGTH_SHORT);
					toast.show();
				} // ��֤�û��������Ƿ�Ϊ��
				else {
					if (login(userPhone,password)) {
						// ʵ��Activity��ת��ͼ����LoginAndRegistActivity��ת��MainActivity
						Intent intent = new Intent(LoginAndRegistActivity.this,
								MainActivity.class);
						Bundle bundle = new Bundle();
						bundle.putString("phone", userPhone);
						intent.putExtras(bundle);
						startActivity(intent);
						// ������ǰActivity
						finish();
						Toast toast = Toast.makeText(
								LoginAndRegistActivity.this, "��¼�ɹ�",
								Toast.LENGTH_SHORT);
						toast.show();
					} else {
						Toast toast = Toast.makeText(
								LoginAndRegistActivity.this, "�û������������",
								Toast.LENGTH_SHORT);
						toast.show();
					}
				}// ��֤�û���������ȷ��
			}
		});

		// ��ע�ᰴť������Ӧ�ĵ������
		btn_regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// ʵ��Activity��ת��ͼ����LoginAndRegistActivity��ת��MainActivity
				Intent intent = new Intent(LoginAndRegistActivity.this,
						EditActivity.class);
				startActivity(intent);
				// ������ǰActivity
				finish();

			}
		});
	}
	public boolean login(String phone,String password) {
		User user=service.findUserByPhone(phone);
		if(user.getPassword().equals(password))
			return true;
		else {
			return false;
		}
	}
}
