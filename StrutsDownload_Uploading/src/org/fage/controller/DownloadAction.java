package org.fage.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;
import org.fage.dao.UserFileDao;
import org.fage.domain.UserFile;

import com.opensymphony.xwork2.ActionSupport;


public class DownloadAction extends ActionSupport{
	private InputStream in;
	private UserFile userFile;
	
	public InputStream getDownloadFile(){
        //return ServletActionContext.getServletContext().getResourceAsStream("upload/1.png");
		return in;
	}
    
    @Override
    public String execute() throws Exception{
    	UserFileDao dao = new UserFileDao();
		userFile = dao.get("IntelliJ.txt");
		in = new FileInputStream(new File(userFile.getUrl()));
        return SUCCESS;
    }

	public UserFile getUserFile() {
		return userFile;
	}

	public void setUserFile(UserFile userFile) {
		this.userFile = userFile;
	}

    
    
}
