/* File name ExclusiveRandomOrder.java
 *  
 * Raymond Williams
 * Project 1 for ECE 588
 * Fall 2014
 * Prof. Roy Kravitz
 * 
 * This file contains the class ExclusiveRandomOrder
 * 
 *******Dependencies******
 * 	None
 *****External Sources****
 * One external source was used in the function generateRandomOrder()<BR>
 * I needed a quick way to init all items in an array found this:<BR>
 * Arrays.fill(array, -1);<BR>
 * <BR> 
 * From <http://stackoverflow.com/questions/10078867/how-to-initialize-all-the-elements-of-an-array-to-any-specific-value-in-java><BR> 
 */

import java.util.Arrays;
import java.util.Random;


/**
 * 
 * This class generates an exclusively random order for
 * the index numbers or an array. All possible index
 * numbers are represented only once.<BR>
 * <BR>
 * Creates an array of size maxRandoms consisting of
 * random index numbers use for indexing an array in
 * random order.
 * 
 * @author Ray Williams
 *  
 */
public class ExclusiveRandomOrder {
	private int[] arrayOfIndexNumbers;
	private int maxIndex;
	
	
	/**
	 * Returns a exclusively random index set for an array
	 * of size maxRandoms. Basically all possible index
	 * numbers are represented only once. 
	 * <BR>
	 * <BR>
	 * ****Credit Oliver Charlesworth for external source****<BR>
	 * One external source was used in the function generateRandomOrder()<BR>
	 * I needed a quick way to init all items in an array found this:<BR>
	 * Arrays.fill(array, -1);<BR>
	 * <BR> 
	 * From <http://stackoverflow.com/questions/10078867/how-to-initialize-all-the-elements-of-an-array-to-any-specific-value-in-java><BR> 
	 * 
	 * 
	 * @param maxRandoms Maximum size of the array you want to randomize
	 * @return An array of size maxRandoms consisting of random index
	 * numbers.
	 */
	public int[] generateRandomOrder(int maxRandoms){
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
	 * notExclusive(int, int[]) cycles through all previously
	 * generated random index to make sure it doesn't already exist 
	 * @param randomInt
	 * @param exclusives
	 * @return false if Exclusive, else true
	 */
	private boolean notExclusive(int randomInt, int[] exclusives){
	    for (int i = 0; i < maxIndex; i++){
	    	if (randomInt == exclusives[i]) return true;
	    }		
		return false;
	}//end notExclusive
	
}//end class
