package model;

import java.util.ArrayList;

public class Quiz {
	private String name;
	private String description;
	private String category;
	private String type;
	private ArrayList<Question> questions;
	
	public Quiz(String Name, String Descrip, String Categ, String Type){
		name = Name;
		description = Descrip;
		category = Categ;
		type = Type;
		questions = new ArrayList<Question>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String Name){
		name = Name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String Descrip){
		description = Descrip;
	}
	
	public String getCategory(){
		return category;
	}
	
	public void setCategory(String Categ){
		category = Categ;
	}
	
	public String getType(){
		return type;
	}
	
	public void setType(String Type){
		type = Type;
	}
	
	public ArrayList<Question> getQuestions(){
		return questions;
	}
	
	public void addQuestion(Question question){
		questions.add(question);
	}
	
	public void deleteQuestion(int num){
		questions.remove(num);
	}
	
}
