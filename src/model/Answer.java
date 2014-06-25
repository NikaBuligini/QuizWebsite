package model;

public class Answer {
	private String answer;
	private int score;
	private int ID;
	
	public Answer(String ans, int scr){
		answer = ans;
		score = scr;
	}
	
	
	public void setAnswer(String newAnswer){
		answer = newAnswer;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int scr){
		score = scr;
	}
	
	public void setID(int id){
		ID = id;
	}
	
	public int getID(){
		return ID;
	}

}
