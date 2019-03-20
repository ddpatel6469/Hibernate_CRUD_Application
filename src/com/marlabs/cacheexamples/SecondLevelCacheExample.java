package com.marlabs.cacheexamples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class SecondLevelCacheExample {
	private static Configuration configuration = null;
	private static SessionFactory sf = null;

	static {

		System.out.println("Loading the hibernate configuration");
//			configuration = new Configuration();
		configuration = new AnnotationConfiguration();
		configuration.configure();
		sf = configuration.buildSessionFactory();
		System.out.println("Hibernate configuration loaded successfully");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("I am from SecondLevelCacheExample !!!");
		try {
			Session session = sf.openSession();
			CustomerCache customer = (CustomerCache) session.get(CustomerCache.class, 107);
			System.out.println("******************************************");
			System.out.println("Customer Object First Time Call");
			System.out.println(customer);
			System.out.println("******************************************");
			CustomerCache customer2 = (CustomerCache) session.get(CustomerCache.class, 107);
			System.out.println("******************************************");
			System.out.println("Customer Object Second Time Call");
			System.out.println(customer2);
			System.out.println("******************************************");
			session.close();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Waiting for 5 seconds");
			Session session1 = sf.openSession();
			CustomerCache customer3 = (CustomerCache) session1.get(CustomerCache.class, 107);
			System.out.println("******************************************");
			System.out.println("Customer Object Third Time Call After Closing the Session");
			System.out.println("Loading From Second Level Cache");
			System.out.println(customer3);
			System.out.println("******************************************");
			session1.close();

			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Session session2 = sf.openSession();
			CustomerCache customer4 = (CustomerCache) session2.get(CustomerCache.class, 107);
			System.out.println("************************************");
			System.out.println("Customer Object 4th Time Call After Closing the Session1");
			System.out.println("Loading From Data Base ");
			System.out.println(customer4);
			System.out.println("*************************************");
			session2.close();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
