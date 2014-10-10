
public class Question {
	
	static int sNumberOfQuestions = 0;
	static int sNumberOfOptions = 4;
	
	private String mquestionText;
	private String moptions[];
	private String manswer;
	
	

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
		sNumberOfQuestions ++;
	}


	/**
	 * @return the moptions
	 */
	public String[] getoptions() {
		return moptions;
	}



	/**
	 * @param moptions the moptions to set
	 */
	public void setMoptions(String[] moptions) {
		this.moptions = moptions;
	}



	/**
	 * @return the manswer
	 */
	public String getManswer() {
		return manswer;
	}



	/**
	 * @param manswer the manswer to set
	 */
	public void setManswer(String manswer) {
		this.manswer = manswer;
	}

	//***End eclipe generated getters and setters ****

	
	
	
}//end class Question
