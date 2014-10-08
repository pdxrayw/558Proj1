/* Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 */



public class Quiz {
	
	public static void main(String[] args) {
		//Variables
		int[] randomQuestionOrder;
		int[] randomOptionsOrder; //will include random spot of answer
		//Objects
		ExclusiveRandomOrder randomOrder = new ExclusiveRandomOrder();
		
		HardCodedQuestions hard_coded_questions = new HardCodedQuestions();
		//randomQuestionOrder = 
		randomQuestionOrder = randomOrder.generateRandomOrder(HardCodedQuestions.sNumberOfQuestions);
		randomOptionsOrder= randomOrder.generateRandomOrder(HardCodedQuestions.sNumberOfOptions+1);

		Question[] quiz_questions = new Question[HardCodedQuestions.sNumberOfQuestions];
		
		
		loadAllQuestions(hard_coded_questions, quiz_questions, randomQuestionOrder);
		
		
		//displayQuestion(quiz_questions[1]);
		startQuiz(quiz_questions);
//		quiz_questions[0] = new Question();
//		quiz_questions[0].setMquestionText("First question");
//		//quiz_questions[0].question_text = "First question";
//		System.out.println("a quiz " + quiz_questions[0].getMquestionText());
//		// TODO Auto-generated method stub
//		//System.out.println("What we need is a " + phrase);
//		System.out.println("a quiz ");
		/*
		 * create the quiz 
		 * 
		 * display the quiz
		 * 	Display question and all possible answers
		 * 	Prompt for answer
		 * check the quiz
		 * 	after last question 
		 * 	calculate results how many right and percentage
		 * 	display results you got 5 out of 10 questions right
		 * 	display percentage score 
		 */
		
		
		//System.out.println("a quiz " + makeQuestions().getMquestionText());
	}
	/**
	 * This function cycles through all of the "harcoded" questions and answers
	 * and loads the relevant data into the class Question
	 * 
	 * @param question_text
	 * @return
	 */
	static void loadAllQuestions(HardCodedQuestions hCQuestionsIn, Question[] questionsIn, int[] questionOrder){
		int randomIndex; //temp for random version of index
		for (int i = 0; i < hCQuestionsIn.sNumberOfQuestions; i++){
			randomIndex = questionOrder[i];
			questionsIn[i] = new Question();
			questionsIn[i].setMquestionText(hCQuestionsIn.hardCodedQuestions[randomIndex]);
			questionsIn[i].setManswer(hCQuestionsIn.hardCodedAnswers[randomIndex]);			
			questionsIn[i].setMoptions(hCQuestionsIn.allHardCodedOptions[randomIndex]);
			
			
			//Here might be a good place to randomize the answers/options
			//however if I do in when I display the test then I can still
			//keep track of the answer as well and I only have do Randomize
			//that data in one place
			
		}//end for i loop
		 
	}
	
	static void displayQuestion(Question question){
		String[] options = question.getoptions();
		System.out.println("Question " + question.getMquestionText());
		System.out.println("Answer " + question.getManswer());
		for (int i = 0; i < Question.sNumberOfOption;){
			System.out.println("Options " + options[i]);
			i++;
		}//end for i
	}
	static void startQuiz(Question allQuestions[]){
		for (int i=0; i < Question.sNumberOfQuestions;){
			displayQuestion(allQuestions[i]);
			//prompt for answer
			
			//check answer
			i++;
		}//end for i
	}

}
