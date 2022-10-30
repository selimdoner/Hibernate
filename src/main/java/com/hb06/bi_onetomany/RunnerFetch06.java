package com.hb06.bi_onetomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

	public static void main(String[] args) {

		
		Configuration con=new  Configuration().configure("hibernate.cfg.xml").
				   addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session= sf.openSession();
		
		Transaction tx= session.beginTransaction();
		
	    
//		Student06 student= session.get(Student06.class, 1001);
//		
//		System.out.println(student);
		
//        Book06 book= session.get(Book06.class, 101);
//		
//		System.out.println(book);
		
		
//		String sqlQuery1="SELECT s.student_name, b.bookname FROM student06 s INNER JOIN book06 b ON s.id=b.student_id";
//		
//		List<Object[]> resultList1=  session.createSQLQuery(sqlQuery1).getResultList();
//		
//		for (Object[] r : resultList1) {
//			System.out.println(Arrays.toString(r));
//		}
		
		
//		String hqlQuery1="SELECT s.name,b.bookName FROM Student06 s INNER JOIN FETCH Book06 b ON s.id=b.student";
//		
//		List<Object[]> resultList2= session.createQuery(hqlQuery1).getResultList();
//		
//		for (Object[] objects : resultList2) {
//			System.out.println(Arrays.toString(objects));
//			
//			System.out.println(objects[0] +"----"+objects[1]);
//		}
		
		
//		String hqlQuery2="SELECT s.name,b.bookName FROM Student06 s LEFT JOIN FETCH Book06 b ON s.id=b.student";
//		
//		List<Object[]> resultList3= session.createQuery(hqlQuery2).getResultList();
//		
//		for (Object[] objects : resultList3) {
//			System.out.println(Arrays.toString(objects));
//		}
		
		
//		String hqlQuery3="SELECT s.name,b.bookName FROM Student06 s RIGHT JOIN FETCH Book06 b ON s.id=b.student";
//		
//		List<Object[]> resultList4= session.createQuery(hqlQuery3).getResultList();
//		
//		for (Object[] objects : resultList4) {
//			System.out.println(Arrays.toString(objects));
//		}
		
		
//		String sqlQuery2="DELETE FROM book06";
//		int numOfRec1= session.createSQLQuery(sqlQuery2).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec);
		
		
//		String hqlQuery4="DELETE FROM Book06";
//		int numOfRec2= session.createQuery(hqlQuery4).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec);
		
		
//		String hqlQuery5="DELETE FROM Book06 b WHERE b.bookName='John''s Art Book'";
//		int numOfRec3= session.createQuery(hqlQuery5).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec3);
		
		//delete a book HqlQuery with the given student id 
//		String hqlQuery6="DELETE FROM Book06 b WHERE b.student=1001";
//		int numOfRec4=session.createQuery(hqlQuery6).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec4);

		
//		String hqlQuery7="DELETE Student06 s WHERE s.id=1003";
//		int numOfRec5=session.createQuery(hqlQuery7).executeUpdate();
//		System.out.println("Effected Row Count:"+numOfRec5);
		
		
		
//		Student06 foundStudent= session.get(Student06.class, 1002);
//		session.delete(foundStudent);
		
		
		//Orphan removal
//		Student06 foundStudent1= session.get(Student06.class, 1001);
//		
//		System.out.println(foundStudent1);
//		
//		foundStudent1.getBookList().set(0, null);
		//Orphan removal
		
	
		//-------------Analysis QUERY JOIN, JOIN-FETCH
		
		
//		 select
//	        student06x0_.id as id1_1_,
//	        student06x0_.grade as grade2_1_,
//	        student06x0_.student_name as student_3_1_ 
//	    from
//	        Student06 student06x0_ 
//	    inner join
//	        Book06 book06x1_ 
//	            on (
//	                student06x0_.id=book06x1_.student_id
//	            )
		
//		
		String hqlQuery1="SELECT s FROM Student06 s INNER JOIN FETCH Book06 b ON s.id=b.student where  b.bookName LIKE '%Book%'";
		
		List<Student06> resultList2= session.createQuery(hqlQuery1,Student06.class).getResultList();
		
		//----------------------

//		 select
//	        student06x0_.id as id1_1_,
//	        student06x0_.grade as grade2_1_,
//	        student06x0_.student_name as student_3_1_ 
//	    from
//	        Student06 student06x0_ 
//	    inner join
//	        Book06 booklist1_ 
//	            on student06x0_.id=booklist1_.student_id
		
		
		
//		String hqlQuery1="SELECT s FROM Student06 s JOIN s.bookList";	
//		List<Student06> resultList2= session.createQuery(hqlQuery1,Student06.class).getResultList();
		
		//----------------------
//		   select
//	        student06x0_.id as id1_1_0_,
//	        booklist1_.id as id1_0_1_,
//	        student06x0_.grade as grade2_1_0_,
//	        student06x0_.student_name as student_3_1_0_,
//	        booklist1_.bookName as bookname2_0_1_,
//	        booklist1_.student_id as student_3_0_1_,
//	        booklist1_.student_id as student_3_0_0__,
//	        booklist1_.id as id1_0_0__ 
//	    from
//	        Student06 student06x0_ 
//	    inner join
//	        Book06 booklist1_ 
//	            on student06x0_.id=booklist1_.student_id

//		String hqlQuery1="SELECT s FROM Student06 s JOIN FETCH s.bookList";		
//		List<Student06> resultList2= session.createQuery(hqlQuery1,Student06.class).getResultList();
		
		
		//----------------------
		
		
//		String hqlQuery1="SELECT s FROM Student06 s LEFT JOIN FETCH s.bookList";		
//		List<Student06> resultList2= session.createQuery(hqlQuery1,Student06.class).getResultList();
		
		
		/*
		 *     select
        student06x0_.id as id1_1_,
        student06x0_.grade as grade2_1_,
        student06x0_.student_name as student_3_1_ 
    from
        Student06 student06x0_ 
    inner join
        Book06 booklist1_ 
            on student06x0_.id=booklist1_.student_id 
    where
        booklist1_.bookName like '%book%'
		 */
		
//		String hqlQuery1="SELECT s FROM Student06 s JOIN s.bookList b WHERE b.bookName LIKE '%book%'";		
//		List<Student06> resultList2= session.createQuery(hqlQuery1,Student06.class).getResultList();
		
		
		
		
		/*
		 *    select
        student06x0_.id as id1_1_0_,
        booklist1_.id as id1_0_1_,
        student06x0_.grade as grade2_1_0_,
        student06x0_.student_name as student_3_1_0_,
        booklist1_.bookName as bookname2_0_1_,
        booklist1_.student_id as student_3_0_1_ 
    from
        Student06 student06x0_ 
    left outer join
        Book06 booklist1_ 
            on student06x0_.id=booklist1_.student_id 
    where
        student06x0_.student_name='John Coffee'
		 */
		
		//LEFT JOIN deyimi , JOIN deyimine benzer . Temel fark, bir LEFT JOIN ifadesinin, ifadenin sol tarafýnda baþvurulan varlýk veya tablonun tüm satýrlarýný içermesidir.
		//Bunu aþaðýdaki örnekte, adý "John Coffee" olan tüm öðrencileri ve Kitaplarýný seçmek için kullanýyorum . Veritabaný belirli bir Öðrenci için bir Kitap içeriyorsa, 
		//sorgu onu Object[] içindeki ikinci öðe olarak döndürür . 
		//Aksi takdirde, bu dizi öðesi null olur .
		//Basit bir JOIN ifadesi yalnýzca Kitabý olan studentlarý döndürür . Object[] öðesinin ikinci öðesi asla boþ olmaz.
//		String hqlQuery1="SELECT s,b FROM Student06 s LEFT JOIN s.bookList b WHERE s.name='John Coffee'";		
//		List<Object[]> resultList2= session.createQuery(hqlQuery1).getResultList();
		

//		Hibernate: 
//		    select
//		        student06x0_.id as id1_1_0_,
//		        booklist1_.id as id1_0_1_,
//		        student06x0_.grade as grade2_1_0_,
//		        student06x0_.student_name as student_3_1_0_,
//		        booklist1_.bookName as bookname2_0_1_,
//		        booklist1_.student_id as student_3_0_1_,
//		        booklist1_.student_id as student_3_0_0__,
//		        booklist1_.id as id1_0_0__ 
//		    from
//		        Student06 student06x0_ 
//		    inner join
//		        Book06 booklist1_ 
//		            on student06x0_.id=booklist1_.student_id 
//		    where
//		        booklist1_.bookName like '%book%'
		
//		String hqlQuery1="SELECT s FROM Student06 s JOIN FETCH  s.bookList b WHERE b.bookName LIKE '%Book%'";		
//		List<Student06> resultList2= session.createQuery(hqlQuery1,Student06.class).getResultList();
		
//		for (Student06 student06 : resultList2) {
//			System.out.println(student06);
//		}
		
		//
		//it makes data to write into database, makes data permanent 
		tx.commit();
		
		//we have to call session close to release connection
		session.close();
		sf.close();
		
		
	}

}
