package com.hb07.manytomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

	public static void main(String[] args) {
		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
		Student07 student= session.get(Student07.class, 1001);
        
		//System.out.println(student);
		
//		for (Book07 book : student.getBookList()) {
//			System.out.println(book);
//			
//			for (Student07 std  : book.getStudents()) {
//				System.out.println(std);
//			}
//			
//		}
		
		
//		String hqlQuery1="SELECT s.name FROM Student07 s";
//		List<Object[]> resulList1= session.createQuery(hqlQuery1).getResultList();
//		System.out.println(resulList1);

		String hqlQuery2="SELECT s.name,b.bookName FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=1001";
		List<Object[]> resultList2= session.createQuery(hqlQuery2).getResultList();

		for (Object[] objects : resultList2) {
			System.out.println(Arrays.toString(objects));
		}
		
		//
		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();

	}

}
