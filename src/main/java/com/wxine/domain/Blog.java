package com.wxine.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog {
	
	@Id
	private String id;
	private String title;
	private String blogcontent;
	private Timestamp ctime;
	
	public Blog() {
	}
	public Blog(String id, String title, String blogcontent, Timestamp ctime) {
		this.id = id;
		this.title = title;
		this.blogcontent = blogcontent;
		this.ctime = ctime;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBlogcontent() {
		return blogcontent;
	}
	public void setBlogcontent(String blogcontent) {
		this.blogcontent = blogcontent;
	}
	public Timestamp getCtime() {
		return ctime;
	}
	public void setCtime(Timestamp ctime) {
		this.ctime = ctime;
	}

	
}
