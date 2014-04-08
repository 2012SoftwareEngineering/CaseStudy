package com.example.actionbarfragement_demo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuFragment extends Fragment {

	private TextView txt_friend_list, txt_discover;
	private  MenuFragment menuFragment;
	private FragmentManager fragmentManager;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		menuFragment=this;
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_menu, null);
		
		txt_friend_list=(TextView) view.findViewById(R.id.txt_friend_list);
		txt_friend_list.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				menuFragment.getActivity().setContentView(R.layout.fragment_two);
				fragmentManager=menuFragment.getActivity().getFragmentManager();
				SecondFragment secondFragment=new SecondFragment();
				fragmentManager.beginTransaction().replace(R.id.content_frame, secondFragment).commit();
				((MainActivity)menuFragment.getActivity()).mDrawerLayout.closeDrawers();
			}
		});
		
		txt_discover=(TextView) view.findViewById(R.id.txt_discover);
		txt_discover.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//menuFragment.getActivity().setContentView(R.layout.fragment_one);
				fragmentManager=menuFragment.getActivity().getFragmentManager();
				FirstFragment firstFragment=new FirstFragment();
				fragmentManager.beginTransaction().replace(R.id.content_frame, firstFragment).commit();
				menuFragment.getActivity().closeContextMenu();
				((MainActivity)menuFragment.getActivity()).mDrawerLayout.closeDrawers();
			}
		});
		
		return view;
	}
}
