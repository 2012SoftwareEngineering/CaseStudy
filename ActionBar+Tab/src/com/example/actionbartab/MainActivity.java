package com.example.actionbartab;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	List<View> listViews;
	MainActivity mainActivity; // 当前的Activity
	@SuppressWarnings("deprecation")
	LocalActivityManager manager = null; // Activity管理
	TextView tvTab1, tvTab2, tvTab3; // 顶部标签
	TabHost tabHost = null;
	private ViewPager pager = null; // 分页

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// 管理当前的Activity
		manager = new LocalActivityManager(this, true);
		manager.dispatchCreate(savedInstanceState);
		mainActivity=this;
		// 找到标签管理
		tabHost = (TabHost) findViewById(R.id.tabhost);
		tabHost.setup();
		// 使其管理当前的Activity
		tabHost.setup(manager);

		// 找到xml上的分页
		pager = (ViewPager) findViewById(R.id.viewpager);

		// 用来存放三个不同的activity页面
		listViews = new ArrayList<View>();

		// 通过意图来获取要被添加的三个Activity的页面，然后加入的list中
		Intent intent_main = new Intent(MainActivity.this, FirstActivity.class);
		listViews.add(getView("FirstActivity", intent_main));

		Intent intent_main2 = new Intent(MainActivity.this,
				SecondActivity.class);
		listViews.add(getView("SecondActivity", intent_main2));

		Intent intent_main3 = new Intent(MainActivity.this, ThirdActivity.class);
		listViews.add(getView("ThirdActivity", intent_main3));

		// 这里开始是来设置顶部标签的颜色，字体，内容等信息
		RelativeLayout tabIndicator1 = (RelativeLayout) LayoutInflater.from(
				this).inflate(R.layout.tabwidget, null);
		// 这里可以设置标签栏的样式，自定义样式时用
		tvTab1 = (TextView) tabIndicator1.findViewById(R.id.tv_title);
		tvTab1.setText("个人信息");
		tvTab1.setTextColor(this.getResources().getColor(R.color.main_red));
		RelativeLayout tabIndicator2 = (RelativeLayout) LayoutInflater.from(
				this).inflate(R.layout.tabwidget, null);
		tvTab2 = (TextView) tabIndicator2.findViewById(R.id.tv_title);
		tvTab2.setText("好友列表");
		RelativeLayout tabIndicator3 = (RelativeLayout) LayoutInflater.from(
				this).inflate(R.layout.tabwidget, null);
		tvTab3 = (TextView) tabIndicator3.findViewById(R.id.tv_title);
		tvTab3.setText("设置");

		tabHost.addTab(tabHost.newTabSpec("A").setIndicator(tabIndicator1)
				.setContent(intent_main));
		tabHost.addTab(tabHost.newTabSpec("B").setIndicator(tabIndicator2)
				.setContent(intent_main2));
		tabHost.addTab(tabHost.newTabSpec("C").setIndicator(tabIndicator3)
				.setContent(intent_main3));

		// 设置监听
		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
			@Override
			public void onTabChanged(String tabId) {
				if ("A".equals(tabId)) {
					tvTab1.setTextColor(mainActivity.getResources().getColor(
							R.color.main_red));
					tvTab2.setTextColor(mainActivity.getResources().getColor(
							R.color.black));
					tvTab3.setTextColor(mainActivity.getResources().getColor(
							R.color.black));
					pager.setCurrentItem(0);

				}
				if ("B".equals(tabId)) {
					tvTab1.setTextColor(mainActivity.getResources().getColor(
							R.color.black));
					tvTab2.setTextColor(mainActivity.getResources().getColor(
							R.color.main_red));
					tvTab3.setTextColor(mainActivity.getResources().getColor(
							R.color.black));
					pager.setCurrentItem(1);

				}
				if ("C".equals(tabId)) {
					tvTab1.setTextColor(mainActivity.getResources().getColor(
							R.color.black));
					tvTab2.setTextColor(mainActivity.getResources().getColor(
							R.color.black));
					tvTab3.setTextColor(mainActivity.getResources().getColor(
							R.color.main_red));
					pager.setCurrentItem(2);

				}
			}
		});
		// 设置每一页要显示的内容
		pager.setAdapter(new MyPageAdapter(listViews));
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				tabHost.setCurrentTab(position);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	private class MyPageAdapter extends PagerAdapter {

		private List<View> list;

		private MyPageAdapter(List<View> list) {
			this.list = list;
		}

		// 移走之前的页面
		@Override
		public void destroyItem(ViewGroup view, int position, Object arg2) {
			ViewPager pViewPager = ((ViewPager) view);
			pViewPager.removeView(list.get(position));
		}

		@Override
		public void finishUpdate(View arg0) {
		}

		@Override
		public int getCount() {
			return list.size();
		}

		// 加入新的页面
		@Override
		public Object instantiateItem(ViewGroup view, int position) {
			ViewPager pViewPager = ((ViewPager) view);
			pViewPager.addView(list.get(position));
			return list.get(position);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

	}

	@SuppressWarnings("deprecation")
	private View getView(String id, Intent intent) {
		Log.d("EyeAndroid", "getView() called! id = " + id);
		return manager.startActivity(id, intent).getDecorView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
