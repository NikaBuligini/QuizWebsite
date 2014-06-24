package model;

import java.util.ArrayList;

public class Quiz {
	private String name;
	private String description;
	private String category;
	private boolean isRandom;
	private boolean immediateCorrection;
	private boolean onePage;
	private boolean allowPractice;
	private ArrayList<Question> questions;
	private int CreatorID;
	private int CategoryID;

	public Quiz(String name, String description, boolean random,
			boolean correction, boolean onePage, boolean practice,
			int creatorID, int categoryID) {
		this.name = name;
		this.description = description;
		this.isRandom = random;
		this.immediateCorrection = correction;
		this.onePage = onePage;
		this.allowPractice = practice;
		this.CreatorID = creatorID;
		this.CategoryID = categoryID;
		questions = new ArrayList<Question>();
	}

	public String getName() {
		return name;
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

	public void setName(String Name) {
		name = Name;
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

	public boolean getPractice() {
		return allowPractice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String Categ) {
		category = Categ;
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
