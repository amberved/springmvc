package com.amberved.springmvc.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.amberved.springmvc.model.Student;

@Component
public class StudentDAO {

	// Dummy database. Initialize with some dummy values.
	private static List<Student> customers;
	{
	    	System.out.println("CustomerDAO::customers");

		customers = new ArrayList();
		customers.add(new Student(1, "A", "B", "A.B@gmail.com", "111-111-1111"));
		customers.add(new Student(2, "C", "D", "C.D@gmail.com", "222-222-2222"));
		customers.add(new Student(3, "E", "F", "E.F@gmail.com", "333-333-3333"));
		customers.add(new Student(System.currentTimeMillis(), "Amber", "Ved", "a.b@gmail.com", "444-444-4444"));
	}

	/**
	 * Returns list of customers from dummy database.
	 * 
	 * @return list of customers
	 */
	public List list() {
		return customers;
	}

	/**
	 * Return customer object for given id from dummy database. If customer is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            customer id
	 * @return customer object for given id
	 */
	public Student get(Long id) {
	    	System.out.println("CustomerDAO::get");

		for (Student c : customers) {
			if (c.getId().equals(id)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Create new customer in dummy database. Updates the id and insert new
	 * customer in list.
	 * 
	 * @param customer
	 *            Customer object
	 * @return customer object with updated id
	 */
	public Student create(Student customer) {
	    	System.out.println("CustomerDAO::create");

		customer.setId(System.currentTimeMillis());
		customers.add(customer);
		return customer;
	}

	/**
	 * Delete the customer object from dummy database. If customer not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the customer id
	 * @return id of deleted customer object
	 */
	public Long delete(Long id) {
	    	System.out.println("CustomerDAO::delete");

		for (Student c : customers) {
			if (c.getId().equals(id)) {
				customers.remove(c);
				return id;
			}
		}

		return null;
	}

	/**
	 * Update the customer object for given id in dummy database. If customer
	 * not exists, returns null
	 * 
	 * @param id
	 * @param customer
	 * @return customer object with id
	 */
	public Student update(Long id, Student customer) {
	    	System.out.println("CustomerDAO::update");

		for (Student c : customers) {
			if (c.getId().equals(id)) {
				customer.setId(c.getId());
				customers.remove(c);
				customers.add(customer);
				return customer;
			}
		}

		return null;
	}

}