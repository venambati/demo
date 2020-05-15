package com.odx.test.restservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.odx.test.restservices.entities.Palindrome;

@Repository
public interface PalindromicRepository extends JpaRepository<Palindrome, Long>{

}
