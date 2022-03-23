package com.accounting.dao.impl;

import com.accounting.dao.CustomerDao;
import com.accounting.model.Customer;

import java.util.List;

import static com.accounting.dao.JpaUtil.performReturningWithinPersistenceContext;
import static com.accounting.dao.JpaUtil.performWithinPersistenceContext;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void saveCustomer(Customer customer) {
        performWithinPersistenceContext(em -> em.persist(customer));
    }

    @Override
    public List<Customer> findAllCustomers() {
        return performReturningWithinPersistenceContext(em ->
                em.createQuery("select c from Customer c", Customer.class).getResultList()
        );
    }

    @Override
    public Customer findCustomerByName(String name) {
        return performReturningWithinPersistenceContext(em ->
                em.createQuery("select c from Customer c where c.name = :name", Customer.class)
                        .setParameter("name", name)
                        .getSingleResult()
        );
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return performReturningWithinPersistenceContext(em -> em.merge(customer));
    }

    @Override
    public void removeCustomer(Customer customer) {
        performWithinPersistenceContext(em -> {
            Customer managedCustomer = em.merge(customer);
            em.remove(managedCustomer);
        });
    }
}