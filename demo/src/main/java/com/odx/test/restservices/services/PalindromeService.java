package com.odx.test.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odx.test.restservices.entities.Palindrome;
import com.odx.test.restservices.repositories.PalindromicRepository;

@Service
public class PalindromeService {

	@Autowired
	private PalindromicRepository palindromicRepository;

	public List<Palindrome> getAllPalindromes() {

		return palindromicRepository.findAll();

	}

	public Palindrome createPalindrome(Palindrome palindrome) {
		palindrome.setPalindrome(longestPalindrome(palindrome.getPalindrome()));
		return palindromicRepository.save(palindrome);
	}

	public Optional<Palindrome> getPalindromeById(Long id) throws PalindromeNotFoundException {
		Optional<Palindrome> palindrome = palindromicRepository.findById(id);

		if (!palindrome.isPresent()) {
			throw new PalindromeNotFoundException("Palindrome Not found in Palindrome Repository");
		}

		return palindrome;
	}
	
	private String longestPalindrome(String s) {
        String longest_str = "";
        int maxlen = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalindrome(s.substring(i, j+1))){
                    if((j+1-i)>maxlen){
                        maxlen = j+1-i;
                        longest_str = s.substring(i, j+1);
                    }
                }
            }
        }
        return longest_str;
	}
	    
    private boolean isPalindrome(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
