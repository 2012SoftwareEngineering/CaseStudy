package com.example.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewActivity extends Activity {

	private ListView chat_list;
	private List<Friend> friend_list;
	private ListViewActivity listViewActivity;
	private MyAdapt myAdapt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview);
		listViewActivity = this;
		chat_list = (ListView) findViewById(R.id.chat_list);
		// œ‘ æListView
		initList();
		showByMyBaseAdapter();
	}

	public void initList() {
		friend_list = new ArrayList<Friend>();
		friend_list.add(new Friend(R.drawable.image1, "Zeus",
				"Back up your address", "6:00PM"));
		friend_list.add(new Friend(R.drawable.image2, "Metis",
				"upload address book to server", "3/27/14"));
		friend_list.add(new Friend(R.drawable.image3, "Themis", "Moments",
				"3/27/14"));
		friend_list.add(new Friend(R.drawable.image4, "Eurynome",
				"Scan QR Code", "3/22/14"));
		friend_list.add(new Friend(R.drawable.image5, "Demeter",
				"Back up your address", "3/21/14"));
		friend_list.add(new Friend(R.drawable.image6, "Mnemosyne",
				"Sticker shop", "3/21/14"));
		friend_list.add(new Friend(R.drawable.image7, "Hera",
				"Reecommended friends", "3/20/14"));
	}

	public void showByMyBaseAdapter() {
		myAdapt = new MyAdapt(this, friend_list);
		chat_list.setAdapter(myAdapt);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
