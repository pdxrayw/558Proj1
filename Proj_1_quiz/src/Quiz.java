/* Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 */



public class Quiz {
	public static void main(String[] args) {
		int num_of_questions = 0;
		// A set of hard coded questions and answers along with possible answers
		//cycle through all questions and initialize the array of Questions
		//for each quesitonincriment the number of questions so the quiz can be scored
		String[] hardcoded_questions = {
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
		};//end of hardcoded questions
		String[] hardcoded_answers = {
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
		};//end of hardcoded answers
		//Hardcoded possible answers to display
		String[] hardcoded_possible_answers1 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers2 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers3 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers4 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers5 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers6 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers7= {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers8 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers9 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		String[] hardcoded_possible_answers10 = {
				"possibleanswers1",
				"possibleanswer2",
				"possibleanswer3",
				"possibleanswer4",
				"possibleanswer5"
		};//end of hardcoded Possible answers1
		
		
		
		Question[] quiz_questions = new Question[10];
		quiz_questions[0] = new Question();
		quiz_questions[0].setMquestionText("First question");
		//quiz_questions[0].question_text = "First question";
		System.out.println("a quiz " + quiz_questions[0].mquestionText);
		// TODO Auto-generated method stub
		//System.out.println("What we need is a " + phrase);
		System.out.println("a quiz ");
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
		
		
		System.out.println("a quiz " + makeQuestions().mquestionText);
	}
	
	boolean loadAllQuestions(String[] question_text/*,other strings string*/ ){
			return true;
}
	
	static Question makeQuestions(){
		
		Question nameofquestion = new Question();
		nameofquestion.setMquestionText("hardcoded question example");
		return nameofquestion;
		//nameofquestion
	}

}
