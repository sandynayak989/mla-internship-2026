package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HQLTest {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		String hql1 = "from Customer";
		String hql = "delete from Customer where c_id= :id";
		Query q= session.createQuery(hql);
		q.setParameter("id", 3);
		int row = q.executeUpdate();
		
		Query<Customer> dt = session.createQuery(hql1,Customer.class);
		List<Customer> list = dt.getResultList();
		System.out.println("Hql Result");
		list.forEach(System.out::println);
		
		t.commit();
		session.close();
	}

}
