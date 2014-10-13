/* File name HardCodedQuestions.java
 *  
 * Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 * This file contains the several hard coded string 
 * elements for the purposes of populating class
 * Question objects with data. Using this as a separate
 * class from class Question allowed me to better
 * encapsulate class question for later use, i.e. read
 * from a file or database.   
 * 
 *******Dependencies******
 * 	None
 *  
 *
 */

/**
 * @author Ray Williams
 * Created this class just as a separate data structure to hold all of
 * the actual question data in a hard coded format. 
 */
public class HardCodedQuestions {
	//static class variables
	static int sNumberOfQuestions = 10;
	static int sNumberOfOptions = 4;
	//A set of hard coded questions and answers along with possible answers
	//cycle through all questions and initialize the array of Questions
	//for each question increment the number of questions so the quiz can
	//be scored.
	
	//What follows for all the hardcoded data is one line per 
	//	question
	//	answer
	//	each of the four options
	String[] hardCodedQuestions = {
			"question1",
			"question2",
			"question3",
			"question4",
			"question5",
			"question6",
			"question7",
			"question8",
			"question9",
			"question10"
	};//End of hard coded questions
	
	
	String[] hardCodedAnswers = {
			"answers1",
			"answer2",
			"answer3",
			"answer4",
			"answer5",
			"answer6",
			"answer7",
			"answer8",
			"answer9",
			"answer10"
	};//End of hard coded answers
	
	
	/**
	 *What follows is 4 potential options for each question 
	 *The answer will obviously be displayed along with the
	 *options, however it has a separate data variable.
	 */
	/*
	 *Hard coded options to display along with the answer.
	 *I have elected to lay out the answer options in the following way
	 *for enhanced readability. This gives, one option per line for each
	 *question, rather than having them lumped together like this:
	 *
	 * String[][] hardCodedOptions = { {0, 0, 0, 0, 0},
     *               {1, 1, 1, 1, 1},
     *               {2, 2, 2, 2, 2},
     *               {3, 3, 3, 3, 3},
     *               {4, 4, 4, 4, 4} };
	 * 
	 * Not that there is anything wrong with this, I just wanted the code
	 * to be cleaner and easier to read, despite the extra scrolling:)
	 */
	String[] hardCodedOption1 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption2 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption3 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption4 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption5 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption6 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption7= {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption8 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption9 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	String[] hardCodedOption10 = {
			"Option1",
			"Option2",
			"Option3",
			"Option4"			
	};//end of options string
	
	//String array to hold all of the options
	//Finally, a little housekeeping to neatly  place the options in a 2d array.
	String[][] allHardCodedOptions = {
			hardCodedOption1,
			hardCodedOption2,
			hardCodedOption3,
			hardCodedOption4,
			hardCodedOption5,
			hardCodedOption6,
			hardCodedOption7,
			hardCodedOption8,
			hardCodedOption9,
			hardCodedOption10
	};
	
}
