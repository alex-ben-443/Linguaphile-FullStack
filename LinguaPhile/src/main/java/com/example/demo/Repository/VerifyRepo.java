package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.VerifyModel;

@Repository
public interface VerifyRepo extends JpaRepository<VerifyModel, Long> {
	VerifyModel findByusername(String username);
}
