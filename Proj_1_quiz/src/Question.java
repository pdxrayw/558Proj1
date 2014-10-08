
public class Question {
	String mquestionText;
	String mpossibleAnswers[];
	char manswer;
	
	
	
	//the eclipse generated constructor is next
	/**
	 * @param mquestionText
	 * @param mpossibleAnswers
	 * @param manswer
	 */
	public Question(String mquestionText, String[] mpossibleAnswers,
			char manswer) {
		this.mquestionText = mquestionText;
		this.mpossibleAnswers = mpossibleAnswers;
		this.manswer = manswer;
	}


	
	//constructor pre-set all data to null values
	//will change constructor to init to passed in values
	Question(){
		mquestionText = null;
		mpossibleAnswers = null;
		manswer = '-';
		
	}


	//***Eclipse generated getters and setters below***
	/**
	 * @return the mquestionText
	 */
	public String getMquestionText() {
		return mquestionText;
	}



	/**
	 * @param mquestionText the mquestionText to set
	 */
	public void setMquestionText(String mquestionText) {
		this.mquestionText = mquestionText;
	}



	/**
	 * @return the mpossibleAnswers
	 */
	public String[] getMpossibleAnswers() {
		return mpossibleAnswers;
	}



	/**
	 * @param mpossibleAnswers the mpossibleAnswers to set
	 */
	public void setMpossibleAnswers(String[] mpossibleAnswers) {
		this.mpossibleAnswers = mpossibleAnswers;
	}



	/**
	 * @return the manswer
	 */
	public char getManswer() {
		return manswer;
	}



	/**
	 * @param manswer the manswer to set
	 */
	public void setManswer(char manswer) {
		this.manswer = manswer;
	}

	//***End eclipe generated getters and setters ****

	
	
	
}//end class Question
