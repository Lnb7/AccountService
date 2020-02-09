package com.acountservice.AcountService.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acountservice.AcountService.dao.AccountDao;
import com.acountservice.AcountService.model.Account;

@RestController
@RequestMapping("/bank")
public class AccountController {

	@Autowired
	AccountDao accountDao;
	
	@GetMapping("/account")
	public List<Account> findAllAccount(){
		return accountDao.findAll();
	}
	
	@GetMapping("/account/{id}")
	public Account findAccountById(@PathVariable(value = "id")Long id) {
		return accountDao.findById(id);
	}
	
	@PostMapping("/account")
	public Account saveAccount(@Valid @RequestBody Account acc) {
		return accountDao.save(acc);
	}
	
	@PutMapping("/account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id")Long id, @Valid @RequestBody Account acc ){
		
		Account findAcc = accountDao.findById(id);
		
		if(findAcc == null ) {
			ResponseEntity.notFound().build();
		}
		
		findAcc.setAmount(acc.getAmount());
		findAcc.setType(acc.getType());
		
		Account updateAcc = accountDao.save(findAcc);
		return ResponseEntity.ok().body(updateAcc);
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<Account> deleteAccount(Long id){
		
		Account findAcc = accountDao.findById(id);
		
		if(findAcc == null ) {
			ResponseEntity.notFound().build();
		}
		accountDao.delete(id);
		return ResponseEntity.ok().build();
		
	}
}
