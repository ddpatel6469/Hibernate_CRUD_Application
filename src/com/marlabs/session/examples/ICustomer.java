package com.marlabs.session.examples;

public interface ICustomer {

	public abstract void saveCustomer(final Customer customer);

	public abstract void getCustomer(final int customerId);

	public abstract void updateCustomer(final Customer customer);

	public abstract void removeCustomer(final Customer customer);
}
