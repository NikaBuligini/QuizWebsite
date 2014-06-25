package model;

import java.util.ArrayList;

public class Quiz {
	private String title;
	private String description;
	private boolean isRandom;
	private boolean immediateCorrection;
	private boolean onePage;
	private ArrayList<Question> questions;
	private int CreatorID;
	private int CategoryID;

	public Quiz(String title, String description, boolean random, boolean correction, 
			boolean onePage, int creatorID, int categoryID) {
		this.title = title;
		this.description = description;
		this.isRandom = random;
		this.immediateCorrection = correction;
		this.onePage = onePage;
		this.CreatorID = creatorID;
		this.CategoryID = categoryID;
		questions = new ArrayList<Question>();
	}

	public String getName() {
		return title;
	}

	public int getCreatorID() {
		return CreatorID;
	}

	public void setCreatorID(int ID) {
		CreatorID = ID;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int ID) {
		CategoryID = ID;
	}

	public void setName(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String Descrip) {
		description = Descrip;
	}

	public boolean getRandom() {
		return isRandom;
	}

	public boolean getCorrection() {
		return immediateCorrection;
	}

	public boolean getOnePage() {
		return onePage;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public void deleteQuestion(int num) {
		questions.remove(num);
	}

}
