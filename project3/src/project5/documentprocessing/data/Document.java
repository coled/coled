package project5.documentprocessing.data;

import project5.documentprocessing.reader.DocumentReader;

/*
* [Document].java
* Author: [Cole Downing]
* Submission Date: [7-26-13]
*
* Purpose: A brief paragraph description of the program. 
* What does it do? How does it do it? *
* 
* This program contains variables and methods for the class Document.
* 
* Statement of Academic Honesty:
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


public class Document {

	public Word[] words;			// An array of Word objects representing the words in this document.
	String[] ignore= new String [0];	   // An array of Strings that should be ignored when this document is processed.
	DocumentReader d;	  // A DocumentReader from which to read the lines of the document.
	int unique;		         // An integer which counts the number of unique words seen.
	int numOfLines;		    // An integer that stores the numbers of lines in the document.

	
	public Document(String url) {
		
		DocumentReader read= new DocumentReader(url); // main problem is here. why is words array never getting initialized?
		
		this.d = read;
		
		 words = new Word[10];
		processDocument();
		sort();
	}

	public Document(String url, String[] ignore) {

	for(int i=0; i < ignore.length; i++){
		ignore [i] = ignore [i];
	}
		// maybe add other lines from first constructor?
	}

	public int getWordsSize() {
		int size;
		size = words.length;
		return size;
	}

	public int getWordCount() {
		int notIgnored = words.length - ignore.length;
		return notIgnored;
	}

	public int getLineCount() {
		return numOfLines;
	}

	private void expandWords() {
		Word[] newArray = new Word[words.length * 2];
	for(int i =0; i < words.length; i++){
		newArray[i] = words [i];
		words = newArray;
	}

	}

	private void shrink()  {
		Word[] newArray = new Word[unique];
		for(int i=0; i<unique; i++){
			newArray [i] = words[i];
			words = newArray;
		}
	

	}

	private String stripPunctuation(String w) {
		for(int i=0; i<w.length(); i++)
		{
			char c = w.charAt(i);
			if(( (int)c < 65 && (int)c > 90 )||((int)c < 97 && (int)c > 122 ))
			{
				w.replace(c, ' ');
			}
		}
	return w;
	}

	public  boolean seenWord(String w) {
		boolean seenWord=false;
		
		for(int i=0; i<this.words.length; i++)
		{
		String s= this.words[i].getWordValue();
		if(s.equalsIgnoreCase(w))
			{
			seenWord=true;
			}
		}
		return seenWord;
	}

	private void sort() {
		int minIdx;
		Word temp;
		this.shrink();
		for (int i = 0; i < this.words.length; i++) {
			minIdx = i;
			for (int j = i+1; j < this.words.length; j++) {
				if (this.words[j].compareTo(this.words[minIdx]) < 0) {
					minIdx = j ;
				}
			}
			temp = this.words[minIdx];
			this.words[minIdx] = this.words[i];
			this.words[i] = temp;
		}
	}


	private int findWord(String w) {
		int result=-1;
		
		for(int i=0; i<words.length; i++)
		{
		String s= words[i].getWordValue();
		if(s.equalsIgnoreCase(w))
			{
			result=i;
			}
		
		}
		return result;
	}

	
	private  void addWord(String w) {
		for(int i =0; i<words.length; i++)
		{
		if(this.seenWord(w)==false)
		{
			Word newWord = new Word(w);
			words[i]= newWord;
		}
		else
			Word.freq++;
		}
	}

	
	private void processDocument() {
		String line="";
		line.equals(d);
		String[] lineWords = line.split(" ");
	for(int i=0; i< lineWords.length; i++)
	{
		 for(int j=0; j< ignore.length; j++)
		{
			if(!lineWords[i].equalsIgnoreCase(ignore[i]))
			{
				this.addWord(lineWords[i]);
			}
			
		}
	}
	}

	public String toString() {
		StringBuffer sb= new StringBuffer();
		sb.append("Line Count: " + numOfLines+ " Word Count: "+ unique+ "\n");
		
		for(int i=0; i<words.length; i++){
			sb.append("Word: " + words[i]+ "Frequecy: " + words[i].freq + "\n");
		}
		
		
		return sb.toString();
	}

}
