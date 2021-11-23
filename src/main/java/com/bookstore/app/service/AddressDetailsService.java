package com.bookstore.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.app.dto.AddressDetailsDto;
import com.bookstore.app.entity.AddressDetails;
import com.bookstore.app.entity.UserEntity;
import com.bookstore.app.repository.AddressDetailsRepository;
import com.bookstore.app.repository.UserRepository;

@Service
public class AddressDetailsService {

	@Autowired
	AddressDetailsRepository detailsRepository;

	@Autowired
	UserRepository userRepo;

	public String add(AddressDetailsDto detailsDto, int userId) {
		UserEntity user = userRepo.getById(userId);
		AddressDetails addressDetails = detailsRepository.findByUserAndType(user, detailsDto.getType());
		if (user != null) {
			if (addressDetails == null) {
				addressDetails = new AddressDetails(detailsDto.getName(), detailsDto.getPincode(),
						detailsDto.getLocality(), detailsDto.getAddress(), detailsDto.getCity(),
						detailsDto.getLandmark(), detailsDto.getType(), user);
				detailsRepository.save(addressDetails);
			}else {
				addressDetails.setName(detailsDto.getName());
				addressDetails.setPincode(detailsDto.getPincode());
				addressDetails.setLocality(detailsDto.getLocality());
				addressDetails.setAddress(detailsDto.getAddress());
				addressDetails.setCity(detailsDto.getCity());
				addressDetails.setLandmark(detailsDto.getLandmark());
				detailsRepository.save(addressDetails);
			}
			
			return "updated";
		} else
			return "user not found";
	}
	
	public AddressDetails get(int userId, int type) {
		UserEntity user = userRepo.getById(userId);
		if(user!=null) {
			return detailsRepository.findByUserAndType(user, type);
		}else {
			return null;
		}
	}
}
