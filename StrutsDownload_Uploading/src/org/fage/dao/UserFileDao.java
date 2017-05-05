package org.fage.dao;

import org.fage.domain.UserFile;
import org.fage.utils.SessionUtils;
import org.hibernate.Session;

public class UserFileDao {
	
	public void add(UserFile userFile){
		Session session = SessionUtils.getCurrentSession();
		session.beginTransaction();
		session.save(userFile);
		session.getTransaction().commit();
	}
	
	public UserFile get(String fileName){
		Session session = SessionUtils.getCurrentSession();
		session.beginTransaction();
		UserFile uf = (UserFile) session.createQuery("from UserFile uf where uf.fileName=?").setString(0, fileName).uniqueResult();
		session.getTransaction().commit();
		return uf;
	}
	
}
