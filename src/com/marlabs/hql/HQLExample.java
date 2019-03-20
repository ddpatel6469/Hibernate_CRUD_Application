package com.marlabs.hql;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HQLExample {

	private static Configuration configuration = null;
	private static SessionFactory sf = null;

	static {
		System.out.println("Loading the hibernate configuration");
		configuration = new Configuration();
		configuration.configure();
		sf = configuration.buildSessionFactory();
		System.out.println("Hibernate configuration loaded successfully");
	}

	public static void saveEmployeeObject() {
		final String METHOD_NAME = "saveCustomer";
		System.out.println("Method Invoked : " + METHOD_NAME);
		Session session = null;
		try {
			Employee employee = new Employee();
			employee.setDepartmentNumber(10);
			employee.setEmpName("BBB");
			employee.setEmpSalary(9000);
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			Serializable id = session.save(employee);
			transaction.commit();
			System.out.println("employee object persisted " + id);
//			System.out.println("customer object persisted");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
					// Detached State
				}
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}

	public static void hqlQueryExampleMethod() {
		System.out.println("From HQLQueryExample Method");
		Session session = null;
		// select * from employeehql ==> SQL
		session = sf.openSession();
		Query query = session.createQuery("FROM Employee ");
		List<Employee> emplist = query.list();
		System.out.println("**************************************************************************************");
		for (Employee employee : emplist) {
			System.out.println(employee);
		}
		System.out.println("**************************************************************************************");
		System.out.println("Trying for Protection");
		query = session.createQuery("SELECT e.empNumber,e.empName,e.departmentNumber FROM Employee e");
		List<Object[]> empRows = query.list();
		System.out.println("**************************************************************************************");
		for (Object[] empProps : empRows) {
			System.out.println(empProps[0] + "\t" + empProps[1] + "\t" + empProps[2]);
		}
		System.out.println("**************************************************************************************");

		System.out.println("Result From Select Query and Where Clause");
		query = session.createQuery(
				"SELECT e.empNumber,e.empName,e.empSalary,e.departmentNumber FROM Employee e WHERE e.departmentNumber=10");
		empRows = query.list();
		System.out.println("*****************************");
		for (Object[] empProps : empRows) {
			System.out.println(empProps[0] + "\t" + empProps[1] + "\t" + empProps[2] + "\t" + empProps[3]);
		}
		System.out.println("*****************************");

		System.out.println("Result From Select Query and Where Clause And Order By");
		query = session.createQuery(
				"SELECT e.empNumber,e.empName,e.empSalary,e.departmentNumber FROM Employee e WHERE e.departmentNumber=30 ORDER BY e.empSalary DESC");
		empRows = query.list();
		System.out.println("*****************************");
		for (Object[] empProps : empRows) {
			System.out.println(empProps[0] + "\t" + empProps[1] + "\t" + empProps[2] + "\t" + empProps[3]);
		}
		System.out.println("*****************************");

		System.out.println("*****************************");
		System.out.println("Result From Select Query Group By");
		query = session.createQuery("SELECT COUNT(e.empName),e.empName FROM Employee e GROUP BY e.empName");
		empRows = query.list();
		System.out.println("*****************************");
		for (Object[] empProps : empRows) {
			System.out.println(empProps[0] + "\t" + empProps[1]);
		}
		System.out.println("*****************************");
	}

	@SuppressWarnings("unchecked")
	public static void hqlQueryParameters() {
		System.out.println("From HQLQueryParameters Example Method");
		Session session = null;
		// SELECT *FROM EMPLOYEEHQL ==> SQL
		session = sf.openSession();
		System.out.println("***************************");
		System.out.println("Positional Query Parameters");
		System.out.println("***************************");
		Query query = session.createQuery(
				"SELECT e.empNumber,e.empName,e.empSalary,e.departmentNumber FROM Employee e WHERE e.departmentNumber=?");
		query.setParameter(0, 10);
		List<Object[]> empRows = query.list();
		System.out.println("*****************************");
		for (Object[] empProps : empRows) {
			System.out.println(empProps[0] + "\t" + empProps[1] + "\t" + empProps[2] + "\t" + empProps[3]);
		}
		System.out.println("***************************");
		System.out.println("Named Query Parameters");
		System.out.println("***************************");
		query = session.createQuery(
				"SELECT e.empNumber,e.empName,e.empSalary,e.departmentNumber FROM Employee e WHERE e.departmentNumber=:departmentNumber");
		query.setInteger("departmentNumber", 20);
		empRows = query.list();
		System.out.println("*****************************");
		for (Object[] empProps : empRows) {
			System.out.println(empProps[0] + "\t" + empProps[1] + "\t" + empProps[2] + "\t" + empProps[3]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("I am from HQLExample Main Method");
//		saveEmployeeObject();
//		hqlQueryExampleMethod();
		hqlQueryParameters();
		System.out.println("I am from End of HQLExample Main Method");

	}

}
