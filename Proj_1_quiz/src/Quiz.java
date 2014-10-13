/* File name Quiz.java
 *  
 * Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 * This file contains the "main" function for project one
 * 
 *******Dependencies******
 * 	ExclusiveRandomOrder.java
 * 	HardCodedQuestions.java
 * 	Question.java
 * 
 *****External Sources****
 * One external source was used in the function CalculateScorePercentage()<BR>
 * Specifically converting an int to a double with two decimal<BR>
 * points of precision <BR>
 * Found this: <BR>
 * How to round a double to 2 decimals- credit to: mkyong
 * double newKB = Math.round(kilobytes*100.0)/100.0; System.out.println("kilobytes (Math.round) : " + newKB);<BR>
 *<BR>
 * From http://www.mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/<BR>
 *
 */

import java.util.Scanner;

////TODO clean up all commented out debug code
////TODO clean up and standardize all comments


/**
 * A simple quiz application
 * 
 * @author Ray Williams
 * @version 1.0 	
 * 
 * 
 * 	  
 */
public class Quiz {
	//*******Statics  declaration*********
	
	//sIntOfLetter_a - once set, this should not be allow to change
	//having the value set at runtime in case different systems
	//cast the char 'a' to something besides what my system casts it to
	//which is 97. Should be the same for all systems, it's just unicode
	//but who knows what if in 100 years unicode is changed. HAHAHA.		
	/**
	 * Holds the ASCII value or the char 'a'
	 * Calculated at run time for portability
	 * not that it should change, but...
	 */
	final static int sIntOfLetter_a = (int)'a';
	
	/**
	 * Running and final score of the quiz
	 * Init to 0 and increment by one for each correct answer
	 */
	static int sScore = 0;//Init to 0, increment from there.
	
	/**
	 * Keep track of the users current question number while
	 * taking the quiz.
	 */
	static int sCurrentQuestion = 0;
	
	//******variable declaration*******	
	private int[] randomQuestionOrder;
	
	//*******Object instance declarations*******	
	private Question[] quiz_questions;
	
	private HardCodedQuestions hard_coded_questions;
		
	/**
	 * ****Simple program flow****<BR>
	 * <BR>		 
	 * Display Greeting<BR>
	 * Load the hard coded questions into an array of Question objects <BR>
	 * in a random order <BR>
	 * Prompt - Ready to start quiz?<BR>
	 * Display Quiz<BR>
	 * 	-Loop through all questions<BR>
	 * 		--Display question<BR>
	 * 		--Display options and answer(display answer/options in random order)<BR>
	 * 		--Prompt for answer, options are a,b,c,d,e<BR>
	 * 		--Validate user input<BR>
	 * 		--Check answer correct<BR>
	 * 		--Display result<BR>
	 * 		--Score ++ if correct<BR>
	 * 	-Check if last question<BR>
	 * After last question<BR>
	 * Display score as follows<BR>
	 * x/y where x incremented score and y is total number of questions<BR>
	 * Calculate percentage<BR>
	 * Display calculated percentage<BR>
	 * Display salutation<BR>
	 * Execution ends<BR>
	 * <BR>
	 * 
	 * @author Ray Williams
	 * @version 1.0	 
	 * @param args - Not used.
	 */
	public static void main(String[] args) {
		//*****Instances*****
		//thisQuiz instance createdTo access non static member variables called by main
		Quiz thisQuiz = new Quiz();
				
		ExclusiveRandomOrder randomOrder = new ExclusiveRandomOrder();
		thisQuiz.hard_coded_questions = new HardCodedQuestions();
		thisQuiz.quiz_questions = new Question[HardCodedQuestions.sNumberOfQuestions];

		//Generate random order of questions and assign.
		thisQuiz.randomQuestionOrder = randomOrder.generateRandomOrder(HardCodedQuestions.sNumberOfQuestions);
				
		//**********************************
		//*****Start of function calls.*****
		//**********************************
		
		//Display greeting
			System.out.println("Welcome to Ray Williams's quiz for Project 1");	
			System.out.println("");
		//Load each question with one of the now randomly ordered
		//hard coded question.
		thisQuiz.loadAllQuestions(thisQuiz.hard_coded_questions, thisQuiz.quiz_questions, thisQuiz.randomQuestionOrder);
		
		//Prompt user, start?
		thisQuiz.UserIsReadToStart();
		
		//Starting the quiz
		thisQuiz.runQuiz(thisQuiz.quiz_questions);
		
		//Display salutation
		System.out.println("");
		System.out.println("GoodBye");	
	}//****End function main*****
	
	
	
	/**
	 * Halts execution until user hits enter key to start the quiz.
	 */
	void UserIsReadToStart() {
		Scanner scan = new Scanner( System.in );
		System.out.println("Press the <Enter> key when you are ready to start the quiz <Enter> ");		
		System.out.println("");
		String userSelectionString = scan.nextLine();//throw-away input
		System.out.println("...Starting!");
		System.out.println("");
	}//End UserIsReadToStart
	
	
	/**
	 * This function cycles through all of the  hard coded questions and answers
	 * loading the relevant data into the class Question in a random order
	 * provided by field "questionOrder"
	 * 
	 * 
	 * @param hCQuestionsIn data class holding hard coded strings to load into
	 * class Question.
	 * @param questionsIn - Array Objects of the class Question 
	 * @param questionOrder - The random order for which to load the 
	 * Question data. 
	 */	
	void loadAllQuestions(HardCodedQuestions hCQuestionsIn, Question[] questionsIn, int[] questionOrder){
		//Temporary placeholder for random version of index
		//just for readability could have easily put in-line.
		int randomIndex; 
		
		for (int i = 0; i < hCQuestionsIn.sNumberOfQuestions; i++){
			randomIndex = questionOrder[i];
			questionsIn[i] = new Question();
			questionsIn[i].setMquestionText(hCQuestionsIn.hardCodedQuestions[randomIndex]);
			questionsIn[i].setManswer(hCQuestionsIn.hardCodedAnswers[randomIndex]);			
			questionsIn[i].setMoptions(hCQuestionsIn.allHardCodedOptions[randomIndex]);	
		}//end for i loop		 
	}//End loadAllQuestions
	
	
	
	/**
	 * Display one question at a time along with the
	 * answer and options, mixed in random order.
	 * due to the random order, the options will not
	 * display in the same order from question to
	 * question or from one program execution to the
	 * next. <BR>
	 * <BR> 
	 * There was a lot going on in this function
	 * I have delegated many tasks to functions
	 * keeping what I see as the core part of
	 * displaying within the actual function.
	 * 
	 * @param question instance of the current question
	 * to be display to the user.
	 * 
	 * @return tokenOfAnswer the option letter of the
	 * actual answer is held during display for use in
	 * checking against user input later.
	 */
	char displayQuestion(Question question){
		char tokenOfAnswer = 'q';//Init to satisfy an error of may not get initialized, OK fine...
		char charCast;
		
		int[] randomOrderOfOptions = makeOptionOrderRandom(); 
		String[] options = new String [5]; 
		
		//Place all options and the correct answer in one array. 
		//First the options, and last the answer (Last index will be the answer token)
		System.arraycopy(question.getoptions(), 0, options, 0, Question.sNumberOfOptions);
		options[Question.sNumberOfOptions] = question.getManswer();
		System.out.println("QUESTION " + Quiz.sCurrentQuestion +//split into two lines
				" of " + Question.sNumberOfQuestions);
		System.out.println(question.getMquestionText());
		
		//Loop through all possible options and the answer and
		//display them together in a random order recalculated
		//anew for each question. 
		for (int i = 0; i < (Question.sNumberOfOptions + 1); i++){
			charCast = (char)(sIntOfLetter_a + i);			
			if (randomOrderOfOptions[i] == Question.sNumberOfOptions)
				tokenOfAnswer = charCast;
			System.out.println(charCast + " " + options[(randomOrderOfOptions[i])]);
		}//end for i
		
		//Since the answer token is here have to pass it back
		//to be checked against user input 
		return tokenOfAnswer;		
	}//End function displayQuestion
	
	
	
	/**
	 * Create a random order for which to display the answer options
	 * to the user at run time. 
	 * @return an array holding the random ordered index numbers
	 * for each question of the array.<BR>	 * 
	 */
	int[] makeOptionOrderRandom(){
		int[] randomOptionsOrder; //will include random spot of answer
		ExclusiveRandomOrder randomOrder = new ExclusiveRandomOrder();
		randomOptionsOrder= randomOrder.generateRandomOrder(HardCodedQuestions.sNumberOfOptions+1);
		return randomOptionsOrder;
	}//End function makeOptionOrderRandom
	
		
	
	/**
	 * Prompts user for an answer from options a through e.<BR>	 * 
	 * Validates user input, if not prompts for valid input again  
	 * 
	 * @return the validated answer selected by the user
	 */
	char getUserInput(){
		Scanner scan = new Scanner( System.in );//from Lecture 3 page 25		
				
		System.out.print( "Select your answer and press the Enter key a, b, c, d or e >> " );
		String userSelectionString = scan.next( );
		//I'm going to check for more than one character of input as well as validate 
		//that one char. I will allow for capital letters by just converting to lower
		//case before checking
		char userSelectionChar = userSelectionString.charAt( 0 );
		userSelectionChar = Character.toLowerCase(userSelectionChar);
		while(inputNotValid(userSelectionChar)){//continue to prompt for good input with appropriate error message
			System.out.println("");//blank line for readability
			System.out.println("************Invalid selection************");
			System.out.println("");//blank line for readability
			System.out.println( "Please select one of the following a, b, c, d or e then press <Enter> key >" );
			System.out.print( "Enter your selection now >> " );
			userSelectionString = scan.next( );
			userSelectionChar = userSelectionString.charAt( 0 );
		}
		System.out.println( "You entered: " + userSelectionChar);
		return userSelectionChar;
	}//End function getUserInput
	
	/**
	 * The actual user validation function. 
	 * validates charToBeChecked against desired user input 
	 * of: a,b,c,d,e. returns false if good else true
	 * Do to the negative name of the function a return
	 * of false is double negative i.e. true from an
	 * operating standpoint.
	 * @param charToBeChecked User input to check for validity
	 * @return false if valid, else true
	 */
	boolean inputNotValid(char charToBeChecked){
		int numberOfGoodInputs = 5;
		char[] goodInput = {'a', 'b', 'c', 'd', 'e'};
		for (int i = 0; i < numberOfGoodInputs; i++){
			//returns false if it finds good input
			if (goodInput[i] == charToBeChecked) return false; 
		}// end for i loop
		//Invalid input will return true
		return true;
	}//End function inputNotValid
	
	/**
	 * Check userAnswer against actualAnswer.
	 * @param userAnswer - selection of user
	 * @param actualAnswer - correct answer 
	 * @return true if they match, (answer correct), else false
	 */
	boolean answerCorrect(char userAnswer, char actualAnswer){
		if (userAnswer == actualAnswer){//if user entered the correct answer
			//Increment the static score variable. The Quiz.part isn't required
			//I only included it so the reader knows absolutely that it is a static
			//field of the class Quiz
			Quiz.sScore ++;
			return true;
		}
		 return false;//answer not correct
	}//End function answerCorrect
	
	 
	 
	/**
	 * Displays the current score of quiz for user.
	 * called after each question is answered to
	 * update user on progress.
	 */
	void displayScore(){		
		System.out.println("");//blank line for readability
		//System.out.println below is split to multiple lines for 
		//readability
		//
		//Actual output is formatted to look like this:
		//     "Current score: out of attempted
		System.out.println(
			"Current score: " + sScore +
			" correct, out of " + 
			Quiz.sCurrentQuestion + 
			" answered.");
		System.out.println("");//blank line for readability of displayed output				
	}//End function displayScore
	
		
	/**
	 * Just as the name implies.<BR>
	 * However, I added code to provide additional 
	 * precision for quizzes with a length that are
	 * not a factor of 10 rather than just rounding
	 * to a whole number.<BR>
	 * Example:<BR> 
	 * A score of 6 out of 10 will be 60.0%<BR>
	 * While a score of 1 out of 13 will be 33.33%<BR>
	 * Lastly, a score of 2 out of 13 will be 66.67%.<BR>
	 * So, the function correctly rounds to the one
	 * hundredth place.<BR>
	 * <BR>
	 * Now while this makes little difference for the
	 * few question numbers in this application, for
	 * however quizzes of significant length the
	 * precision could mean a B grade as opposed to a
	 * B+ grade.<BR>
	 * <BR>
	 * ****Credit mkyong for external source****<BR>
	 * One external source was used in this function<BR>
	 * Specifically for converting an int to a double with two decimal<BR>
	 * points of precision <BR>
	 * Found this: <BR>  credit to: mkyong
	 * double newKB = Math.round(kilobytes*100.0)/100.0; System.out.println("kilobytes (Math.round) : " + newKB);<BR>
	 * <BR>
	 * From http://www.mkyong.com/java/how-to-round-double-float-value-to-2-decimal-points-in-java/<BR>
	 *
	 * @return the percentage score with one or two points or
	 * precision as describe above.
	 */
	double calculateScorePrecentage(){
		double percentageScore;
		//Casts both scoring int values as doubles and calculates percent
		//% = 100.00 * score/total # of questions
		
		//The following is to provide one or two points of precision
		//past the decimal point. While it's not necessary for any
		//score out of 10 total, because it will always be a factor
		//of 10. However, I have put in place, statics to allow for 
		//the total number of questions to change easily. Then the
		//percentage score would no longer calculate to a factor of
		//ten. This implementation makes the function more reusable.
		percentageScore = (((double)(100.00*sScore))/((double)(Question.sNumberOfQuestions)));		
		percentageScore = Math.round(percentageScore*100.00)/100.00;//Gives one or two points of precision past decimal
		
		return percentageScore;
	}//End calculateScorePrecentage
		
	
	/**
	 * Outputs the final number of correct answers to the user
	 * after the last question is answered. Also displays the
	 * percentage score accurate to one or two decimal places.<BR>
	 * (See function double calculateScorePrecentage() for a
	 * complete explanation of precision.)<BR>
	 * <BR>
	 * Example of output<BR>
	 * ********************<BR>
	 * Final score is: 2/3<BR>
	 *   ** Grade 66.67% **<BR>
	 * ********************<BR>
	 * <BR>
	 * Explanation of above output:<BR>
	 * 2 questions out of 3 total were answered correctly, giving a percentage grade of 66.67%.
	 */
	void displayFinalScore(){		
		System.out.println("");//blank line for readability
		System.out.println("********************");
		System.out.println(
				"Final score is: " + sScore +
				"/" + Quiz.sCurrentQuestion);
		System.out.print("  ** Grade ");
		System.out.print(calculateScorePrecentage());
		System.out.println("% **");
		System.out.println("********************");
	}//End function displayFinalScore
	
	/**
	 * This function is the meat of the quiz portion of the 
	 * application. It stores the token for the correct answer.
	 * It calls all the functions to<BR>
	 * - Display each question and answer options on the screen<BR> 
	 * - Asks for and collects the user's answer<BR>
	 * - Checks if the answer is correct and informs the user<BR>
	 * Finally at the end of the quiz:<BR>
	 * - The total score and percent grade are presented to the user.<BR>
	 * 
	 * @param allQuestions is an array of length sNumberOfQuestions
	 * that holds all of the object instances of class question.
	 */
	void runQuiz(Question allQuestions[]){
		char tokenOfAnswer;
		for (int i=0; i < Question.sNumberOfQuestions; i++){
			char userSelectedAnswer;
			
			Quiz.sCurrentQuestion ++;
			tokenOfAnswer = displayQuestion(allQuestions[i]);
			//prompt for answer
			userSelectedAnswer = getUserInput();			
			
			checkForAnswer(userSelectedAnswer, tokenOfAnswer);
			
			displayScore();			
		}//end for i
		
		//Notify that the test is complete
		System.out.println("===========================================================");
		System.out.println("Quiz complete");
		//the quiz is over calculate the final percentage grade
		displayFinalScore();
		
		//***The quiz is over***
	}//End function runQuiz

	/**
	 * checks the user's selected answer with the actual answer.
	 * if correct, gives the user a "kudos type message" and
	 * incrimetns the static Quiz variable sScore
	 * 
	 * @param userSelectedAnswer user input of answer selection
	 * @param tokenOfAnswer the char of the correct answer for
	 * the given question.
	 * 
	 * there is no return because I chose to make the over all score
	 * of the quiz a static variable as stated above sScore.
	 */
	void checkForAnswer(char userSelectedAnswer, char tokenOfAnswer) {		
		if(answerCorrect(userSelectedAnswer, tokenOfAnswer)){
			System.out.println("");//output blank line for readability
			System.out.println("Good job! The correct answer is: " + tokenOfAnswer);
		}
		else{
			//I'm considering displaying the Text of the answer as well
			//as the letter. I will if there is time.
			System.out.println("");//output blank line for readability
			System.out.println("I'm sorry, the correct answer is: " + tokenOfAnswer);
		}// End if/else			
	}//End of function checkForAnswer
	
}//******End of Class Quiz******
