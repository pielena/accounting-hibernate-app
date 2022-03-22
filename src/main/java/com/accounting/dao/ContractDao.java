package com.accounting.dao;

import com.accounting.model.Contract;

import java.util.List;

public interface ContractDao {

    void saveContract(Contract contract);

    List<Contract> findAllContracts();

    Contract findContractById(Long id);

    Contract updateContract(Contract contract);

    void removeContract(Contract contract);
}
