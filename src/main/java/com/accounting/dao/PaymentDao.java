package com.accounting.dao;

import com.accounting.model.Payment;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentDao {

    void savePayment(Payment payment);

    List<Payment> findAllPayments();

    Payment updatePayment(Payment payment);

    void removePayment(Payment payment);

    List<Payment> findAllByContract(Long contractId);

    List<Payment> findAllByCustomer(Long customerId);

    List<Payment> findAllAmountMoreThan(Long customerId, BigDecimal amount);
}
