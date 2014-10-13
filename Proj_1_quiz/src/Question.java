/* File name Question.java
 *  
 * Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 * This file contains the class Question
 * 
 *******Dependencies******
 * 	None
 * 
 * 
 *
 */


/**
 * The Question class has three main fields:<BR>
 * mquestionText; The question being asked
 * moptions[]; Four wrong answer options
 * manswer; One correct answer
 * 
 * @author Ray Williams
 *
 */
public class Question {
	
	//count of how many questions there are in a given quiz.
	static int sNumberOfQuestions = 0;
	static int sNumberOfOptions = 4;//4 wrong options to be display with one correct
	
	private String mquestionText;//The question being asked
	private String moptions[]; //Four wrong answer options
	private String manswer;//One correct answer
		

	//***Eclipse generated getters and setters below***
	/**
	 * @return mquestionText - The question
	 */
	public String getMquestionText() {
		return mquestionText;
	}

	/**
	 * @param mquestionText the mquestionText to set
	 */
	public void setMquestionText(String mquestionText) {
		this.mquestionText = mquestionText;
		sNumberOfQuestions ++;
	}


	/**
	 * @return the moptions - An array of 4 wrong answers to be displayed
	 * with the correct answer.
	 */
	public String[] getoptions() {
		return moptions;
	}


	/**
	 * @param moptions the moptions to set four wrong options
	 */
	public void setMoptions(String[] moptions) {
		this.moptions = moptions;
	}


	/**
	 * @return the manswer - The correct answer to the question.
	 */
	public String getManswer() {
		return manswer;
	}

	/**
	 * @param manswer - Set the correct answer to the question.
	 */
	public void setManswer(String manswer) {
		this.manswer = manswer;
	}

	//***End eclipe generated getters and setters ****

	
	
	
}//end class Question
