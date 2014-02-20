package com.example.demoone;

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

	private Button btn_login, btn_regist; // 按钮变量声明
	private EditText et_userphone, et_password; // 编辑框变量声明
	private String userPhone, password;

	// Activity生命周期开始
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_and_regist); // 加载当前Activity显示的页面
		initView(); // 初始化View
	}

	/**
	 * 初始化View
	 */
	private void initView() {
		// 通过R文件映射找到activity_login_and_regist.xml上面相应的控件名称，然后赋予声明的变量
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_regist = (Button) findViewById(R.id.btn_regist);
		et_userphone = (EditText) findViewById(R.id.et_userphone);
		et_password = (EditText) findViewById(R.id.et_password);

		// 对登录按钮设置相应的点击监听
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				userPhone = et_userphone.getText().toString(); // 获取输入框中的值
				password = et_password.getText().toString();

				if (userPhone.equals("") || password.equals("")) {
					Toast toast = Toast.makeText(LoginAndRegistActivity.this,
							"用户名密码请填完整", Toast.LENGTH_SHORT);
					toast.show();
				} // 验证用户名密码是否为空
				else {
					if (userPhone.equals("123") || password.equals("123")) {
						// 实现Activity跳转意图，从LoginAndRegistActivity跳转至MainActivity
						Intent intent = new Intent(LoginAndRegistActivity.this,
								MainActivity.class);
						startActivity(intent);
						// 结束当前Activity
						finish();
						Toast toast = Toast.makeText(
								LoginAndRegistActivity.this, "登录成功",
								Toast.LENGTH_SHORT);
						toast.show();
					} else {
						Toast toast = Toast.makeText(
								LoginAndRegistActivity.this, "用户名或密码错误",
								Toast.LENGTH_SHORT);
						toast.show();
					}
				}// 验证用户名密码正确性
			}
		});

		// 对注册按钮设置相应的点击监听
		btn_regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// 实现Activity跳转意图，从LoginAndRegistActivity跳转至MainActivity
				Intent intent = new Intent(LoginAndRegistActivity.this,
						MainActivity.class);
				startActivity(intent);
				// 结束当前Activity
				finish();

			}
		});
	}
}
