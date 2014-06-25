package model;

import java.util.ArrayList;

public class Question {
	
	private ArrayList<Answer> answers;
	private String text;
	private String image;
	
	public Question(String text, String image) {
		this.text = text;
		this.image = image;
		answers = new ArrayList<Answer>();
	}
	
	
	public void setQuestion(String newText) {
		this.text = newText;
	}
	
	public String getQuestion() {
		return text; 
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	 
	public String getImage() {
		return image;
	}
	
	public Answer getAnswer(int index) {
		if (index < 0 || index >= answers.size())
			return null;
		
		return answers.get(index);
	}
	
	
	public void setAnswer(int index, Answer e) {
		if (index < 0 || index >= answers.size())
			return;
		
		answers.set(index, e);
	}
	
	public void addAnswer(Answer e) {
		answers.add(e);
	}
	
	public ArrayList<Answer> getAllAnswers() {
		return answers;
	}
}
