package com.marlabs.session.examples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerImpl implements ICustomer {

	private static Configuration configuration = null;
	private static SessionFactory sf = null;

	static {
		System.out.println("Loading the hibernate configuration");
		configuration = new Configuration();
		configuration.configure();
		sf = configuration.buildSessionFactory();
		System.out.println("Hibernate configuration loaded successfully");
	}

	@Override
	public void saveCustomer(final Customer customer) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
//			session.save(customer);
			session.persist(customer);
			transaction.commit();
//			System.out.println("customer object persisted " + id);
			System.out.println("customer object persisted");
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
	public void getCustomer(final int customerId) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
//			Customer customer = (Customer) session.load(Customer.class, customerId);
			Customer customer = (Customer) session.get(Customer.class, customerId);
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
	public void updateCustomer(Customer customer) {
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
	public void removeCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
//			Serializable id = session.save(customer);
			session.delete(customer);
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
