package com.peisia.db;

	// 매개변수를 모아놓은곳이 Dto
public class Dto {
	public String no;         
	public String title;      
	public String id;         
	public String datetime;   
	public String hit;        
	public String text;       
	public String replyCount;
	public String replyOri;
	public Dto(String title, String id, String text) {
		this.title = title;
		this.id = id;
		this.text = text;
	}  
	//alt + shift + s 코드 자동 삽입
	public Dto(String no, String title, String id, String datetime, String hit, String text, String replyCount,
			String replyOri) {
		this.no = no;
		this.title = title;
		this.id = id;
		this.datetime = datetime;
		this.hit = hit;
		this.text = text;
		this.replyCount = replyCount;
		this.replyOri = replyOri;
	}
	public Dto(String title, String text) {
		this.title = title;
		this.text = text;
	}
	public String getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getId() {
		return id;
	}
	
}
