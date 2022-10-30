package com.hb05.uni_onetomany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {

	public static void main(String[] args) {

		
		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
	    
//		Student05 student= session.get(Student05.class, 1001);
//		
//		System.out.println(student);
		
		
		String hqlQuery1="SELECT b.name FROM Student06 s inner join s.bookList b where s.id=1001";
		List<Object> resultList2= session.createQuery(hqlQuery1).getResultList();
		resultList2.forEach(o->System.out.println(o.toString()));
		

		//
		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();
		
		
	}

}
