package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class AnagramController {
	
	/**
	 * TESTING: Answer to a simple GET request
	 * @param name
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/get")
	public ResponseEntity<Anagram> responseGet(@RequestParam(value="name", defaultValue="World") String name) {
		
		Anagram response = new Anagram("GET - Response", String.format("It's working! Hello %s!", name), false);
		
		return new ResponseEntity<Anagram>(response, HttpStatus.OK);
	}
	
	/**
	 * Check anagram and answer to a POST request
	 * @param request
	 * @return ResponseEntity
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public ResponseEntity<Anagram> responsePost(@RequestBody Anagram request) {
		
		Map<Character, Integer> source_map = new HashMap<Character, Integer>();
		source_map = toMap(request.getSource(), source_map);
		
		Map<Character, Integer> target_map = new HashMap<Character, Integer>();
		target_map = toMap(request.getTarget(), target_map);
		
		Anagram response = new Anagram(request.getSource(), request.getTarget(), false);
		
		if(source_map.equals(target_map)) {
			response.setAnagram(true);
		}
		
		return new ResponseEntity<Anagram>(response, HttpStatus.OK);
	}
	
	/**
	 * Insert text in to map (key->letter, value->appearances)
	 * @param text
	 * @param map
	 * @return
	 */
	public Map<Character, Integer> toMap(String text, Map<Character, Integer> map) {
		for(int i=0; i<text.length(); i++) {
			char tmp_letter = text.charAt(i);			
			if(map.containsKey(tmp_letter)) {
				int value = (int) map.get(tmp_letter);
				value++;
				map.put(tmp_letter, value);
			}
			else {
				if((tmp_letter >= 'a' &&tmp_letter <= 'z') || (tmp_letter >= 'A' && tmp_letter <= 'Z')){
					map.put(tmp_letter, 1);
				}				
			}
		}
		return map;
	}
	
}
