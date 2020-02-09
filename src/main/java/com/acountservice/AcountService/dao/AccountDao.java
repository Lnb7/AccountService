package com.acountservice.AcountService.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acountservice.AcountService.model.Account;
import com.acountservice.AcountService.repository.AccountRepository;

@Service
public class AccountDao {

	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> findAll(){
		return accountRepository.findAll();
	}
	
	public Account findById(Long id) {
		return accountRepository.findById(id).get();
	}
	
	public Account save(Account acc) {
		return accountRepository.save(acc);
	}
	
	public void delete(Long id) {
		accountRepository.deleteById(id);
	}
}
