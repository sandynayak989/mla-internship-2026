package com.test;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CustomerDao {
	public static Session getDBSession() {
		Session session = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			SessionFactory sf = cfg.buildSessionFactory();
			session = sf.openSession();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}
	
	public void saveCustomer(Customer cst) {
		Session session = CustomerDao.getDBSession();
		Transaction t =  session.beginTransaction();
		session.persist(cst);
		t.commit();
		//CustomerDao.getDBSession().close();
	}
	
	public List<Customer> getAllCustomers(){
		//List<Customer> custData = new ArrayList<>();
		Query<Customer> q = CustomerDao.getDBSession().createQuery("from Customer");
		List<Customer> custData = q.list();
		return custData;
	}
	
	public void updateCustomer(Customer cst) {
		Session session = CustomerDao.getDBSession();
		Transaction t = session.beginTransaction();
		Customer obj = session.find(Customer.class, cst.getC_id());
		obj.setC_name(cst.getC_name());
		obj.setC_city(cst.getC_city());
		
		session.persist(obj);
		t.commit();
	}
	
	public void deleteCustomer(Customer cst) {
		Session session = CustomerDao.getDBSession();
		Transaction t = session.beginTransaction();
		session.remove(cst);
		t.commit();
		session.close();
	}
}
