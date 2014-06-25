package model;

public class Answer {
	static String answer;
	static int score;
	static int ID;
	
	public Answer(String ans, int scr){
		answer = ans;
		score = scr;
	}
	
	
	public static void setAnswer(String newAnswer){
		answer = newAnswer;
	}
	
	public static String getAnswer(){
		return answer;
	}
	
	public static int getScore(){
		return score;
	}
	
	public static void setScore(int scr){
		score = scr;
	}
	
	public static void setID(int id){
		ID = id;
	}
	
	public static int getID(){
		return ID;
	}
}
