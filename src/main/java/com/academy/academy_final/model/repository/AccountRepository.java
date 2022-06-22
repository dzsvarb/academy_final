package com.academy.academy_final.model.repository;

import com.academy.academy_final.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Account getAccountByAccountNumber(Integer accountNumber);

}
