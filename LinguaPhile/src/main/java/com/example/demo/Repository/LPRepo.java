package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.LPModel;

@Repository
public interface LPRepo extends JpaRepository<LPModel, Long> {
	
}
