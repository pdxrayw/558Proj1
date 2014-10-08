
public class Question {
	String question_text;
	String possible_answers[];
	char answer;
	
	//constructor only to pre-set all data to null values
	Question(){
		question_text = null;
		possible_answers = null;
		answer = '-';
		
	}
	
	boolean set_question(String question_in){
		
		question_text = question_in;
		if (question_text != null)return true;
		return false;
		
	}
	boolean set_possible_answers(String answers_in[]){
		boolean set = false;
		
		return set;
		
	}
	boolean set_correct_answer (char correct_answer_in){
	boolean set = false;
	 
	return set;
	
	}
	Question get_question(int questionnumb){
		
		
		return this;
	}
		
	void get_answers(int questionnumb){
		//should return the 5 possible answers
	}
	
	
}//end class Question
