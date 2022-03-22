package com.accounting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "sum")
    private BigDecimal sum;

    @Column(name = "comment")
    private String comment;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Payment> payments = new ArrayList<>();

    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setContract(this);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", sum=" + sum +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", customer=" + customer.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Contract)) {
            return false;
        }
        Contract contract = (Contract) o;
        return Objects.equals(getId(), contract.getId()) && Objects.equals(getName(), contract.getName()) && Objects.equals(getSubject(), contract.getSubject()) && Objects.equals(getSum(), contract.getSum()) && Objects.equals(getDate(), contract.getDate()) && Objects.equals(getCustomer(), contract.getCustomer()) && Objects.equals(getPayments(), contract.getPayments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSubject(), getSum(), getDate(), getCustomer(), getPayments());
    }
}