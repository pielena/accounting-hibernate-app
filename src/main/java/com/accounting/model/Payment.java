package com.accounting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "money_amount")
    private BigDecimal moneyAmount;

    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", moneyAmount=" + moneyAmount +
                ", time=" + time +
                ", contract=" + contract.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Payment)) {
            return false;
        }
        Payment payment = (Payment) o;
        return Objects.equals(getId(), payment.getId()) && Objects.equals(getMoneyAmount(), payment.getMoneyAmount()) && Objects.equals(getTime(), payment.getTime()) && Objects.equals(getContract(), payment.getContract());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMoneyAmount(), getTime(), getContract());
    }
}