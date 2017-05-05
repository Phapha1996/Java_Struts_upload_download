package org.fage.domain;

import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="t_userfile")
public class UserFile implements Serializable{
	private int id;
	private String title;
	private String fileName;
	private String url;
	
	
	public UserFile(){
		
	}
	public UserFile(String title,String fileName,String url){
		this.fileName = fileName;
		this.title = title;
		this.url = url;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getUrl() {
		return url;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
}
