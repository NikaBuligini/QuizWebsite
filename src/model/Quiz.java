package model;

import java.util.ArrayList;

public class Quiz {
	private static String name;
	private static String description;
	private static String category;
	private static String type;
	private static ArrayList<Question> questions;
	
	public Quiz(String Name, String Descrip, String Categ, String Type){
		name = Name;
		description = Descrip;
		category = Categ;
		type = Type;
		questions = new ArrayList<Question>();
	}
	
	public static String getName(){
		return name;
	}
	
	public static void setName(String Name){
		name = Name;
	}
	
	public static String getDescription(){
		return description;
	}
	
	public static void setDescription(String Descrip){
		description = Descrip;
	}
	
	public static String getCategory(){
		return category;
	}
	
	public static void setCategory(String Categ){
		category = Categ;
	}
	
	public static String getType(){
		return type;
	}
	
	public static void setType(String Type){
		type = Type;
	}
	
	public static ArrayList<Question> getQuestions(){
		return questions;
	}
	
	public static void addQuestion(Question question){
		questions.add(question);
	}
	
	public static void deleteQuestion(int num){
		questions.remove(num);
	}
	
}
