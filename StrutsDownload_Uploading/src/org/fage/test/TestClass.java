package org.fage.test;

import org.fage.utils.SessionUtils;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestClass {
	@Test
	public void test(){
		SessionFactory s = SessionUtils.getSessionFactory();
		s.close();
	}
}
