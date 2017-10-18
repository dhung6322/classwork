package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
		wednesdayMethods();
	}
	private void wednesdayMethods() {
		int[] diceRolls = new int [10000000];
		populate(diceRolls);
		int[] data = longestConsecutiveSeqAndIndex(diceRolls);
		int longest = data[0];
		System.out.println("The longest sequence is " + longest + " rolls."
				+ " It happened on roll # " + data[1] + " the sequence was: "
				+ Arrays.toString(subArray(diceRolls, data[1], data[0])) + ".");
	}
	/**
	 * BIG IDEA:
	 * Usually a method returns ONE piece of data (i.e. 'int', 'boolean', etc)
	 * IF we ever want more than one piece of data one way of doing that 
	 * is by using an array, as you see here, a method that return the length
	 * of the sequence and its START position (both ints)
	 * @param arr
	 * @return
	 */
	private int[] longestConsecutiveSeqAndIndex(int[] arr) {
		int[] data = new int[2];
		data[0] = 1;
		int currentCount = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + currentCount < arr.length && 
				isConsecutive(arr,i,i+currentCount)) {
				currentCount ++;
			}
			if(currentCount > data[0]) {
				data[0] = currentCount;
				//also store the index where this sequence started
				data[1] = i;
			}
			i = i + currentCount - 1;
			currentCount = 1;
		}
		return data;
	}
	private void tuesdayMethods() {
		int[] orderTest = {1,2,3,4,5,1,6,7,8,9,10,11,12,13,2,4,1,2,3,4,5,6,7,8,9};
		//cycleThrough(orderTest, 5);
		//System.out.println(Arrays.toString(orderTest));
		System.out.println(longestConsecutiveSequence(orderTest) + " is the longest consecutive sequence");
	}
	private int longestConsecutiveSequence(int[] arr) {
		int sum = 1;
		int currentCount = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + currentCount < arr.length && 
				isConsecutive(arr,i,i+currentCount)) {
				currentCount ++;
			}
			if(currentCount > sum) {
				sum = currentCount;
			}
			i = i + currentCount - 1;
			currentCount = 1;
		}
		return sum;
	}
	private boolean isConsecutive(int[] arr, int start, int end) {
		for(int i = start; i < end; i++) {
			if(arr[i] + 1 != arr[i+1]) {
				return false;
			}	
		}
		return true;
	}

	private void cycleThrough(int[] orderTest, int n) {
		for(int i = 0; i < n; i++) {
			frontToBack(orderTest);
		}
	}
	private void frontToBack(int[] arr) {
		int x = arr[0];
		for (int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = x;
	}
	private void warmUpMethods() {
		int[] orderTest = {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest,3,4)));
	}
	public void cardMethods() {
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		for(int i = 0; i < values.length; i++) {
			values[i] = ""+(i+1);
		}
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
	}
	private String[] printDeck() {
		String[] deck = new String[52];
		int index = 0;
		for(String suit: suits) {
			for(String value : values) {
				deck[index] = value + " of "+ suit;
				index++;
			}
		}
		return deck;
	}
	public void reverseOrder(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			swap(arr,i,arr.length-1-i);
		}
	}
	public int[] subArray(int[] arr, int psn, int length) {
	int[] sub = new int[length];
	for(int i = 0; i <length; i ++) {
		sub[i] = arr[i+psn];
	}
	return sub;
	}
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr,i,(int)(Math.random()*arr.length));
		}
	}
	//swaps elements at i and j
	private void swap(int[] arr, int i, int j) {
		int placeholder = arr[i];
		arr[i] = arr[j];
		arr[j] = placeholder;
	}
	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1);
		}
	}
	private void countOccurences(int[] arr, int start, int end) {
		int[] counter = new int [end - start + 1];
		for(int value: arr)
		{
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("The value " + (i + start) + " was rolled " 
					+ counter[i] + " times");
		}
	}
	//this method populates arr with results from rolling 2 dice
	private void populate(int[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = diceRoll(2);
		}
	}

	public void arrayNotes() {
		//Two ways to construct an array:
				int[] firstWay = {0,1,2,3,4,5};
				//this way will only work with the declaration
				/* will not work:
				firstWay = {6,7,8,9,10}
				*/
				
				String[] secondWay = new String[5];
				//you have to add them manually at each index
				//secondWay[0] = 1;
				//secondWay[1] = 10;
				
				//TWO WAYS TO ITERATE THROUGH AN ARRAY;
				for(int i = 0; i < secondWay.length; i ++) {
					System.out.println("The #" + i + " element is " + secondWay[i]);
				}
				//"For each int in secondWay"
				for(String value: secondWay) {
					System.out.println("Element is " + value);
				}
	}

	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//2. Size can not be changed
		
		/* 3. Elements of an array are REFERENCES to objects In
		 * other words, changing an element of an array changes the reference,
		 * not the object.
		*/
		}
	/*
	 * returns the result after rolling n number of dice
	 */
	public int diceRoll(int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int dRoll = (int)(Math.random() * 6) + 1;
			sum += dRoll;
		}
		return sum;
	}
}
