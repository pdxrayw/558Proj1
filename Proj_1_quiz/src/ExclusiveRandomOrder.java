import java.util.Arrays;
import java.util.Random;

/**
 * 
 */

/**
 * @author Ray
 * Returns a randomly ordered exclusive index list
 * constructor takes a max number 
 * @params
 * 
 */
public class ExclusiveRandomOrder {
	private int[] arrayOfIndexNumbers;
	private int maxIndex;
	
		
	int[] generateRandomOrder(int maxRandoms){
		maxIndex = maxRandoms;
		Random randomQuestion = new Random();
		int[] exclusiveInts = new int[maxIndex];
		Arrays.fill(exclusiveInts, -1);//need to initialize all to a number not already part of the index or 
		int randomIndex = randomQuestion.nextInt(maxIndex);//initialize with the first random number
				
	    for (int i = 0; i < maxIndex; i++){
	    	//The following while loop will generate a new random number if not exclusive.
	    	while((notExclusive(randomIndex, exclusiveInts))){
	    		randomIndex = randomQuestion.nextInt(maxIndex);
	    	}
	    	exclusiveInts[i] = randomIndex;
	    	//the following is for debugging
	    	//System.out.println("Number " + i + ";" + randomIndex);
	    	
	    }
	    return exclusiveInts;
	}
	
	/**
	 * 
	 * @param randomInt
	 * @param exclusives
	 * @return false if Exclusive, else true
	 */
	boolean notExclusive(int randomInt, int[] exclusives){
	    for (int i = 0; i < maxIndex; i++){
	    	if (randomInt == exclusives[i]) return true;
	    }		
		return false;
	}//end notExclusive
	
}//end class
