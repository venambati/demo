package com.odx.test.restservices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "palindromes")
public class Palindrome {

	public String getPalindrome() {
		return palindrome;
	}

	public void setPalindrome(String palindrome) {
		this.palindrome = palindrome;
	}

	@Id
	@GeneratedValue
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "PALINDROME")
	private String palindrome;

	public Palindrome() {
		
	}
	public Palindrome(Long id, String palindrome) {
		super();
		this.id = id;
		this.palindrome = palindrome;
	}

}
