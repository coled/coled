package project5.documentprocessing;

import project5.documentprocessing.data.Document;


/*
* [DocumentProcessor].java
* Author: [Cole Downing]
* Submission Date: [7-26-13]
*
* Purpose: A brief paragraph description of the program. 
* What does it do? How does it do it? *
* 
* This program contains the main method for the program.
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



public class DocumentProcessor {

	public static void main(String[] args) {
		if (args.length == 1) {
			Document d = new Document(args[0]);					
			System.out.println(d);
		}
		else {
			System.out.println("Must provide an url as command-line argument.");
		}

	}

}
