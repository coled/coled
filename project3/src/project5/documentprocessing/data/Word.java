package project5.documentprocessing.data;

/*
* [Word].java
* Author: [Cole Downing]
* Submission Date: [7-26-13]
*
* Purpose: A brief paragraph description of the * program. What does it do? How does it do it? *
* Statement of Academic Honesty:
*
* This program contains instance variables and methods for the Word class. 
*
* The following code represents my own work. I have neither
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on a programming project created by the Department of
* Computer Science at the University of Georgia. Any publishing
* of source code for this project is strictly prohibited without
* written consent from the Department of Computer Science. */

public class Word implements Comparable<Word> {

	// Add the instance variables, constructor, and instance methods

	public  String word; // added static
	
	public static  int freq; // added static
	 
	Word(String w){
		this.word = w;
	}
	
	public String getWordValue(){ // added static
		return word;
	}
	
	public int getFrequency(){
		return freq;
	}
	
	public void incrementFrequency(){
		freq++;
	}
	
	public boolean equals(Word w){
		boolean equals = false;
		if(this.word.equalsIgnoreCase(w.word)){
			equals = true;
		}
		return equals;
	}

	public int compareTo(Word w) {
		int result= this.word.compareTo(w.word);
		return result;
	}
}

