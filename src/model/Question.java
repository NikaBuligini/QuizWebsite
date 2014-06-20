package model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	public List<String> answer = new ArrayList<String>();
	String question;
	String ImageName;

	Question(String text, String Image) {
		question = text;
		ImageName=Image;
		
	}
	
	void setQuestion(String text){
		question=text;
	}
	
	String getQuestion(String text ){
		return text; 
	}
	
	void setImage(String Image){
		ImageName=Image;
	}
	 
	String getImage(String Image){
		return Image;
	}
	
	
	boolean IsAnswer(String t){
		for(int i=0; i<=answer.size(); i++){
			if(t.equals(answer.get(i))) return true;
		}
		return false;
	}
	
	void getAnswer(){
		answer.get(0);
	}
}
