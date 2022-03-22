package com.accounting.dao.impl;

import com.accounting.dao.ContractDao;
import com.accounting.model.Contract;

import java.util.List;

import static com.accounting.dao.JpaUtil.performReturningWithinPersistenceContext;
import static com.accounting.dao.JpaUtil.performWithinPersistenceContext;

public class ContractDaoImpl implements ContractDao {

    @Override
    public void saveContract(Contract contract) {
        performWithinPersistenceContext(em -> em.persist(contract));
    }

    @Override
    public List<Contract> findAllContracts() {
        return performReturningWithinPersistenceContext(em ->
                em.createQuery("select c from Contract c", Contract.class).getResultList()
        );
    }

    @Override
    public Contract findContractById(Long id) {
        return performReturningWithinPersistenceContext(em ->
                em.createQuery("select c from Contract c where c.id = :id", Contract.class)
                        .setParameter("id", id)
                        .getSingleResult()
        );
    }

    @Override
    public Contract updateContract(Contract contract) {
        return performReturningWithinPersistenceContext(em -> em.merge(contract));
    }

    @Override
    public void removeContract(Contract contract) {
        performWithinPersistenceContext(em -> {
            Contract managedContract = em.merge(contract);
            em.remove(managedContract);
        });
    }
}