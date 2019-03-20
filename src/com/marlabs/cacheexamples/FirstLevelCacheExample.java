package com.marlabs.cacheexamples;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class FirstLevelCacheExample {

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
		System.out.println("I am from first level cache example");
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
			Session session1 = sf.openSession();
			CustomerCache customer3 = (CustomerCache) session1.get(CustomerCache.class, 107);
			System.out.println("******************************************");
			System.out.println(customer3);
			System.out.println("******************************************");

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

}
