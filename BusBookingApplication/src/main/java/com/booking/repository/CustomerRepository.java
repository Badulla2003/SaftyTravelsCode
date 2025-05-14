package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.booking.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM CUSTOMERS_TABLE WHERE CUSTOMER_ID=?1",nativeQuery = true)
	public int deleteCustomer(Integer customerId);
}
