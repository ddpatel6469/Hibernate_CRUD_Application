package com.marlabs.session.examples.withannotations;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CustomerImpl implements ICustomer {

	private static Configuration configuration = null;
	private static SessionFactory sf = null;

	static {
		System.out.println("Loading the hibernate configuration");
//		configuration = new Configuration();
		configuration = new AnnotationConfiguration();
		configuration.configure();
		sf = configuration.buildSessionFactory();
		System.out.println("Hibernate configuration loaded successfully");
	}

	@Override
	public void saveCustomer(final NewCustomer customer) { // Transient State
		// TODO Auto-generated method stub
		final String METHOD_NAME = "saveCustomer";
		System.out.println("Method Invoked : " + METHOD_NAME + customer);

		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = session.save(customer);
			session.persist(customer); // Persistant State
			transaction.commit();
			System.out.println("customer object persisted " + id);
//			System.out.println("customer object persisted");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
					// Detached State
					System.out.println("From finally Block-Customer Object: " + customer);
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void getCustomer(final int customerId) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
//			Customer customer = (Customer) session.load(Customer.class, customerId);
			NewCustomer customer = (NewCustomer) session.get(NewCustomer.class, customerId);
			System.out.println("*****************************************");
			System.out.println("Record you are looking for : " + customer);
			System.out.println("*****************************************");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateCustomer(NewCustomer customer) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
//			Serializable id = session.save(customer);
			session.update(customer);
			transaction.commit();
//			System.out.println("customer object persisted " + id);
			System.out.println("customer object updated");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void removeCustomer(NewCustomer customer) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
//			Serializable id = session.save(customer);
			session.delete(customer);
			System.out.println("Customer Object " + customer); // Detached State
			transaction.commit();
//			System.out.println("customer object persisted " + id);
			System.out.println("customer object deleted");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

}
