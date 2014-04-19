package com.example.ui.fragments;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.domain.IService.IBicycleService;
import com.example.domain.IService.IMealCardService;
import com.example.domain.IService.IStudentService;
import com.example.domain.service.BicycleService;
import com.example.domain.service.MealCardService;
import com.example.domain.service.StudentService;
import com.example.model.Bicycle;
import com.example.model.MealCard;
import com.example.model.Student;
import com.example.ui.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

	private IMealCardService mService;
	private IStudentService sService;
	private IBicycleService bService;
	private Student student;
	private Bicycle b;
	private MealCard m;
	public PlaceholderFragment() {
		student=new Student();
		student.setStudentID(1);
		m=new MealCard();
		b=new Bicycle();
		m.setMealCardID(5);
		b.setBicycleID(5);
		student.setMealCard(m);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mService=new MealCardService();
		sService=new StudentService();
		bService=new BicycleService();
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		MealCard mealCard=null;
		try {
			mealCard=mService.getMealCardByStudent(student);
			sService.addStudnet(student);
//			mService.addMealCard(m);
//			bService.addBicycle(b);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rootView;
	}
}
