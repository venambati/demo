package com.odx.test.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.odx.test.restservices.entities.Palindrome;
import com.odx.test.restservices.services.PalindromeNotFoundException;
import com.odx.test.restservices.services.PalindromeService;


@RestController
@RequestMapping(value = "/palindromes")
public class PalindromeController {

	@Autowired
	private PalindromeService palindromeService;

	@GetMapping
	public List<Palindrome> getAllPalindromes() {

		return palindromeService.getAllPalindromes();

	}

	@PostMapping
	public ResponseEntity<Void> createPalindrome(@RequestBody Palindrome palindrome) {
			palindromeService.createPalindrome(palindrome);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public Palindrome getPalindromeById(@PathVariable("id") Long id) {
		try {
			Optional<Palindrome> palindromeOptional =  palindromeService.getPalindromeById(id);
			return palindromeOptional.get();
		} catch (PalindromeNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
}
