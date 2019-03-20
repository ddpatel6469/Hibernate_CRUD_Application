package com.marlabs.session.examples.withannotations;

public interface ICustomer {

	public abstract void saveCustomer(final NewCustomer customer);

	public abstract void getCustomer(final int customerId);

	public abstract void updateCustomer(final NewCustomer customer);

	public abstract void removeCustomer(final NewCustomer customer);
}
