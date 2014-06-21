package model;

public class Notification {
	
	private int ID;
	private User author;
	private String text;
	private boolean isChallenge;
	
	public Notification(int ID, User author, String text, boolean isChallenge){
		this.ID = ID;
		this.author = author;
		this.text = text;
		this.isChallenge = isChallenge;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getName() {
		return author.getFirstName() + " " + author.getLastName();
	}
	
	public int getAuthorID() {
		return author.getID();
	}
	
	public String getImage() {
		return author.getImage();
	}
	
	public String getText() {
		return text;
	}
	
	public boolean isChallenge() {
		return isChallenge;
	}
}
