package ui.caseStudy;

import com.example.demoone.R;

import domain.businessEntity.systemManagement.User;
import domain.businessService.systemManagement.ISystemManagementService;
import domain.businessService.systemManagement.SystemManagementService;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	private TextView tv_username;
	private TextView tv_phone;
	private TextView tv_email;
	private TextView tv_professional;
	private ISystemManagementService service;
	private SharedPreferences sp_userPhone;
	private String userPhone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 实例化service
		service = new SystemManagementService();
		initView();
	}

	public void initView() {
		tv_username = (TextView) findViewById(R.id.tv_watch_card_info_name);
		tv_email = (TextView) findViewById(R.id.tv_watch_card_info_email);
		tv_phone = (TextView) findViewById(R.id.tv_watch_card_info_mobilephone);
		tv_professional = (TextView) findViewById(R.id.tv_watch_card_info_professional);
		// 通过配置文件来获取数据
		sp_userPhone = getSharedPreferences("login_and_regist", MODE_PRIVATE);
		userPhone = sp_userPhone.getString("userPhone", "");
		User user = service.findUserByPhone(userPhone);
		// 设置TextView的内容
		tv_username.setText(user.getUsername());
		tv_email.setText(user.getEmail());
		tv_professional.setText(user.getUserProfessional());
		tv_phone.setText(user.getUserPhone());
	}
}
