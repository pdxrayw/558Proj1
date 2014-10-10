import java.util.Scanner;

/* Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 */


////TODO clean up all commented out debug code
////TODO clean up and standardize all comments
public class Quiz {
	//*******Statics  declaration*********
	
	//sIntOfLetter_a - once set, this should not be allow to change
	//having the value set at runtime in case different systems
	//cast the char 'a' to something besides what my system casts it to
	//which is 97. Should be the same for all systems, it's jsut unicode
	//but who knows what if in 100 years unicode is changed. HAHAHA.
	final static int sIntOfLetter_a = (int)'a';
	static int sScore = 0;//Init to 0, increment from there.
	static int sCurrentQuestion = 0;//Keep track of the question the user is on
	//******variable declaration*******
	int[] randomQuestionOrder;
	
	//*******instance declaration*******
	Question[] quiz_questions;
	HardCodedQuestions hard_coded_questions;
		
	public static void main(String[] args) {
		//*****Instances*****
		//thisQuiz instance createdTo access non static member variables called by main
		Quiz thisQuiz = new Quiz();
				
		ExclusiveRandomOrder randomOrder = new ExclusiveRandomOrder();
		thisQuiz.hard_coded_questions = new HardCodedQuestions();
		thisQuiz.quiz_questions = new Question[HardCodedQuestions.sNumberOfQuestions];

		//Generate random order of questions and assign.
		thisQuiz.randomQuestionOrder = randomOrder.generateRandomOrder(HardCodedQuestions.sNumberOfQuestions);
		
		//****What follows is a simplified version of program flow****
		/* 
		 * Display Greeting 
		 * Prompt for "ready to start quiz?"
		 * Display Quiz
		 * 	Loop through all questions
		 * 		Display question( display questions in random order)
		 * 		Display options and answer(display answer/options in random order)
		 * 		Prompt for answer(planned on a,b,c,d,e, but, 1,2,3,4,5 might be just as good)
		 * 		Validate user input
		 * 		Check answer correct
		 * 		Display result
		 * 		++ score if correct
		 * 	Check if last question
		 * After last question
		 *Display score as follows
		 *x/y where x incremented score and y is total number of questions
		 *Calculate percentage
		 *Display calculated percentage xx.xx%
		 *Display salutation
		 *Execution ends
		 */
		
		//**********************************
		//*****Start of function calls.*****
		//**********************************
		
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
	 * @param hCQuestionsIn
	 * @param questionsIn
	 * @param questionOrder
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
	
	
	//There is a lot going on in this function
	//I have delegated many tasks to functions
	//keeping what I see as the core part of
	//displaying within the actual function.
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
	
	
	
	int[] makeOptionOrderRandom(){
		int[] randomOptionsOrder; //will include random spot of answer
		ExclusiveRandomOrder randomOrder = new ExclusiveRandomOrder();
		randomOptionsOrder= randomOrder.generateRandomOrder(HardCodedQuestions.sNumberOfOptions+1);
		return randomOptionsOrder;
	}//End function makeOptionOrderRandom
	
	
	
	
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
	 * Checks the char against desired user input 
	 * a,b,c,d,e returns false if Good else true
	 * @param charToBeChecked
	 * @return false if Good
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
	
	
	
	double calculateScorePrecentage(){
		double percentageScore;
		//casts both scoring int values as doubles and calculates percent
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
