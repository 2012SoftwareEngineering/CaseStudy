package app;


import foundation.data.DataHelper;
import android.app.Application;


/**
 * 
 * @author 2011级软工
 * 
 */
public class MyApplication extends Application {

	// 数据库助手
	public static DataHelper DATAHELPER;

	// 数据库名
	public static String DATAFILENAME = "myApp.db";

	@Override
	public void onCreate() {

		super.onCreate();
		// 初始化全局变量
		DATAHELPER = new DataHelper(getApplicationContext(), DATAFILENAME);
	}
}
