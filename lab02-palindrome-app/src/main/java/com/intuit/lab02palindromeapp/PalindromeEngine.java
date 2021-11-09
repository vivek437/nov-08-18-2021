package com.intuit.lab02palindromeapp;

import org.springframework.stereotype.Component;

@Component
public class PalindromeEngine {
    public boolean isPalindrome(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        String reversedWord = stringBuilder.reverse().toString();
        return word.equalsIgnoreCase(reversedWord);
    }
}
