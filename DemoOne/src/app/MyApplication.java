package app;


import foundation.data.DataHelper;
import android.app.Application;


/**
 * 
 * @author 2011����
 * 
 */
public class MyApplication extends Application {

	// ���ݿ�����
	public static DataHelper DATAHELPER;

	// ���ݿ���
	public static String DATAFILENAME = "myApp.db";

	@Override
	public void onCreate() {

		super.onCreate();
		// ��ʼ��ȫ�ֱ���
		DATAHELPER = new DataHelper(getApplicationContext(), DATAFILENAME);
	}
}
