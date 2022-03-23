package com.accounting.dao;

import com.accounting.model.Customer;

import java.util.List;

public interface CustomerDao {

    void saveCustomer(Customer customer);

    List<Customer> findAllCustomers();

    Customer findCustomerByName(String name);

    Customer updateCustomer(Customer customer);

    void removeCustomer(Customer customer);
}
