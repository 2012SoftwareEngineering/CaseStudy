package com.example.listview;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapt extends BaseAdapter {
	private List<Friend> friend_list;
	private Context context;
    private RelativeLayout item;
	public MyAdapt(Context context, List<Friend> friend_list) {
		this.friend_list = friend_list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return (friend_list == null) ? 0 : friend_list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return friend_list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public class ViewModel {
		ImageView imageView;
		TextView txt_username;
		TextView txt_message;
		TextView txt_date;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final Friend friend = (Friend) getItem(position);
		ViewModel viewModel = null;
		Log.d("MyBaseAdapter", "新建convertView,position=" + position);
		convertView = LayoutInflater.from(context).inflate(R.layout.item_chat,
				null);

		viewModel = new ViewModel();
		
		viewModel.txt_username = (TextView) convertView
				.findViewById(R.id.txt_username);
		viewModel.txt_message = (TextView) convertView
				.findViewById(R.id.txt_message);
		viewModel.txt_date = (TextView) convertView.findViewById(R.id.txt_date);
		viewModel.imageView=(ImageView) convertView.findViewById(R.id.imageView1);
		item=(RelativeLayout)convertView.findViewById(R.id.item);
		convertView.setTag(viewModel);
				
		viewModel.txt_username.setText(friend.getUserName());
		String massage=friend.getMassage();
		if(massage.length()>15)
		{
			massage=friend.getMassage().substring(0, 20)+"...";
		}
		viewModel.txt_message.setText(massage);
		viewModel.txt_date.setText(friend.getDate());
		viewModel.imageView.setImageResource(friend.getImageId());
		
		 //对ListView中的每一行信息配置OnClick事件  
        convertView.setOnClickListener(new OnClickListener(){  
  
            @Override  
            public void onClick(View v) {  
                Toast.makeText(context,   
                        "[convertView.setOnClickListener]点击了"+friend.getUserName(),   
                        Toast.LENGTH_SHORT).show();  
               // item.setBackground(context.getResources().getDrawable(R.drawable.item_bg));
               // item.setBackgroundColor(context.getResources().getColor(R.color.bg_blue));
            }  
              
        });
		
		return convertView;
	}

}
