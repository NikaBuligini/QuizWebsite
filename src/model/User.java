package model;

/**
 * class inaxavs user-is shesaxeb sachiro yvela informacias
 */
public class User {
	
	// cvladebi
	private String f_name;
	private String l_name;
	private int gender;
	private int question;
	private String answer;
	private String image;
	private int id;
	
	
	/**
	 * konstruqtori.
	 * 
	 * @param user
	 * @param firstName	saxeli
	 * @param lastName	gvari
	 * @param question	kitxva im shemtxvevistvis tu daaviwyda paroli
	 * @param answer	kitxvaze pasuxi
	 */
	public User(String firstname, String lastname, int genderID, int questionID, String answer, String image){
		setFirstName(firstname);
		setLastName(lastname);
		setGenderID(genderID);
		setQuestion(questionID, answer);
		setImage(image);
		id = 0;
	}
	
	
	
	/**
	 * @return abrunebs firstname-s
	 */
	public String getFirstName(){
		return f_name;
	}
	
	/**
	 * firstname-s shecvla
	 */
	public void setFirstName(String firstname){
		this.f_name = firstname;
	}
	
	/**
	 * @return abrunebs gvars
	 */
	public String getLastName(){
		return l_name;
	}
	
	/**
	 * gvaris shecvla
	 */
	public void setLastName(String lastname){
		this.l_name = lastname;
	}
	
	
	public int getGenderID(){
		return gender;
	}
	
	private void setGenderID(int gender){
		this.gender = gender;
	}
	
	
	/**
	 * @return abrunebs kitxvas
	 */
	public int getQuestionID(){
		return question;
	}
	
	/**
	 * @return abrunebs kitxvaze pasuxs
	 */
	public String getAnswer(){
		return answer;
	}
	
	
	/**
	 * kitxvis shecvla (kitxvis shecvlisas aucileblad unda sheicvalos pasuxic)
	 */
	public void setQuestion(int questionID, String answer){
		this.question = questionID;
		this.answer = answer;
	}
	
	public String getImage(){
		return image;
	}
	
	public void setImage(String image){
		this.image = image;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int id){
		this.id = id;
	}
}
