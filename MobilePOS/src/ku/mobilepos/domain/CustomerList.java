package ku.mobilepos.domain;

import java.util.List;

public interface CustomerList {
	public void addCustomer(Customer c);
	public void removeCustomer(String cusId);
	public Customer getCustomerByName(String cusName);
	public Customer getCustomerById(String cusId);
	public Customer getCustomerByPhoneNo(String cusPhoneNo);
	public List<Customer> getCustomerList();
	public boolean isEmpty();

}
