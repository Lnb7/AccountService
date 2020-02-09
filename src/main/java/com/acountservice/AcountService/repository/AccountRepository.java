package com.acountservice.AcountService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acountservice.AcountService.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
