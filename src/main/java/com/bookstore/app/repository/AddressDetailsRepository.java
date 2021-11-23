package com.bookstore.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.app.entity.AddressDetails;
import com.bookstore.app.entity.UserEntity;

@Repository
public interface AddressDetailsRepository extends JpaRepository<AddressDetails, Integer> {
	public AddressDetails findByUserAndType(UserEntity user, int type);
}
