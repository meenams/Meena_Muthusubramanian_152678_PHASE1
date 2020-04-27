package com.cg.spring.PaymentWalletSpring.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.PaymentWalletSpring.dto.Customer;

@Repository("paymentwallet")
public interface PaymentWalletRepo extends CrudRepository<Customer, String> {

}
