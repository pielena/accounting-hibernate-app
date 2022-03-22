package com.accounting.dao.impl;

import com.accounting.dao.PaymentDao;
import com.accounting.model.Payment;

import java.math.BigDecimal;
import java.util.List;

import static com.accounting.dao.JpaUtil.performReturningWithinPersistenceContext;
import static com.accounting.dao.JpaUtil.performWithinPersistenceContext;

public class PaymentDaoImpl implements PaymentDao {

    @Override
    public void savePayment(Payment payment) {
        performWithinPersistenceContext(em -> em.persist(payment));
    }

    @Override
    public List<Payment> findAllPayments() {
        return performReturningWithinPersistenceContext(em ->
                em.createQuery("select p from Payment p", Payment.class).getResultList()
        );
    }

    @Override
    public Payment updatePayment(Payment payment) {
        return performReturningWithinPersistenceContext(entityManager -> entityManager.merge(payment));
    }

    @Override
    public void removePayment(Payment payment) {
        performWithinPersistenceContext(em -> {
            Payment managedPayment = em.merge(payment);
            em.remove(managedPayment);
        });
    }

    @Override
    public List<Payment> findAllByContract(Long contractId) {
        return performReturningWithinPersistenceContext(em ->
                em
                        .createQuery("select p from Payment p where p.contract.id = :contract_id", Payment.class)
                        .setParameter("contract_id", contractId)
                        .getResultList()
        );
    }

    @Override
    public List<Payment> findAllByCustomer(Long customerId) {
        return performReturningWithinPersistenceContext(em ->
                em
                        .createQuery("select p from Payment p join fetch p.contract where p.contract.customer.id = :customer_id", Payment.class)
                        .setParameter("customer_id", customerId)
                        .getResultList()
        );
    }

    @Override
    public List<Payment> findAllAmountMoreThan(Long customerId, BigDecimal amount) {
        return performReturningWithinPersistenceContext(em ->
                em
                        .createQuery("select p from Payment p join fetch p.contract where p.contract.customer.id = :customer_id and p.amountOfMoney > :amount_of_money", Payment.class)
                        .setParameter("customer_id", customerId)
                        .setParameter("amount_of_money", amount)
                        .getResultList()
        );
    }
}