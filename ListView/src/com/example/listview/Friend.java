package com.example.listview;

public class Friend {

	private int imageId;
	private String userName;
	private String massage;
	private String date;

	public Friend(int imageId, String userName, String massage, String date) {
		this.imageId = imageId;
		this.userName = userName;
		this.massage = massage;
		this.date = date;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
