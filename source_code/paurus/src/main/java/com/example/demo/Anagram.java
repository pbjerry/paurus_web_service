package com.example.demo;

public class Anagram {

    private String source;
    private String target;
    private boolean anagram;
    
    public Anagram() {
    	
    }
    
    public Anagram(String source, String target) {
    	this.source = source;
    	this.target = target;
    }

    public Anagram(String source, String target, boolean anagram) {
        this.source = source;
        this.target = target;
        this.anagram = anagram;
    }

    public String getSource() {
        return source;
    }
    
    public void setSource(String source) {
    	this.source = source;
    }

    public String getTarget() {
        return target;
    }
    
    public void setTarget(String target) {
    	this.target = target;
    }
    
    public boolean getAnagram() {
    	return anagram;
    }
    
    public void setAnagram(boolean anagram) {
    	this.anagram = anagram;
    }
}