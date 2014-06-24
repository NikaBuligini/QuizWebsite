package model;

import java.sql.Timestamp;

public class Comment {
	private String text;
	private User user;
	private int quiz_id;
	private int id;
	private Timestamp date;

	public Comment(int id, String text, User user, int quiz_id){
		this.setId(id);
		this.setText(text);
		this.setUser(user);
		this.setQuizId(quiz_id);
	}
	
	public Comment(int id, String text, User user, int quiz_id, Timestamp date){
		this.setId(id);
		this.setText(text);
		this.setUser(user);
		this.setQuizId(quiz_id);
		this.setDate(date);
	}
	
	public Comment(String text, User user, int quiz_id){
		this.setText(text);
		this.setUser(user);
		this.setQuizId(quiz_id);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuizId() {
		return quiz_id;
	}

	public void setQuizId(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
