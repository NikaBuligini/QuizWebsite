package model;

/**
 * class inaxavs user-is shesaxeb sachiro yvela informacias
 */
public class User {
	
	// cvladebi
	private String userName;
	private String f_name;
	private String l_name;
	private String birthday;
	private String eMail;
	private String question;
	private String answer;
	
	
	/**
	 * konstruqtori.
	 * 
	 * @param user
	 * @param firstName	saxeli
	 * @param lastName	gvari
	 * @param birthday	dabadebis tarigi
	 * @param mail	momxmareblis maili
	 * @param question	kitxva im shemtxvevistvis tu daaviwyda paroli
	 * @param answer	kitxvaze pasuxi
	 */
	public User(String user, String firstName, String lastName, String birthday,
			String mail, String question, String answer){
		this.userName = user;
		setFirstName(firstName);
		setLastName(lastName);
		setBirthday(birthday);
		setEMail(mail);
		setQuestion(question, answer);
	}
	
	
	/*
	 * amas ar chirderba shecvlis metodi da agar vuwer
	 */
	public String getUsername(){
		return userName;
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
	
	
	/**
	 * @return abrunebs dabadebis tarigs
	 */
	public String getBirthday(){
		return birthday;
	}
	
	/**
	 * cvlis dabadebis tarigs
	 */
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	
	/**
	 * @return abrunebs momxmareblis e-mails
	 */
	public String getEMail(){
		return eMail;
	}
	
	/**
	 * metodi sachiroa eMail-is shesacvlelad
	 * @param eMail axali eMail
	 */
	public void setEMail(String eMail){
		this.eMail = eMail;
	}
	
	
	/**
	 * @return abrunebs kitxvas
	 */
	public String getQuestion(){
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
	public void setQuestion(String question, String answer){
		this.question = question;
		this.answer = answer;
	}
}
