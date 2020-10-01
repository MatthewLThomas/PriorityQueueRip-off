package com.utilitiescontainer;

public class PriorityQueue<C> {
	
	
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int DEFAULT_PRIORITY = 9; // Lowest Priority
	
														// Object Array				Priority Array
	private static Object[][] priorityQueue = new Object[ DEFAULT_INITIAL_CAPACITY ][2];
	//put method to put stuff into arrays, Default Priority = findPriority();
	public void put(C input) {
		int location = findLocation();
		priorityQueue[location][0] = input;
		priorityQueue[location][1] = DEFAULT_PRIORITY;
		
	}
	public void put(C input, int priority) {
		int location = findLocation();
		priorityQueue[location][0] = input;
		priorityQueue[location][1] = priority;
		sortByPriority();
	}
	//To Find Priority, check within array check for non-null value add to a counter, "Priority"
	//		If Priority == array.lenght()
	//			make array size bigger by 2x

	public int findLocation() { //Finds current default priority and if needed expands array 
	int location=0;
		for(int i=0; i<priorityQueue.length; i++) {
			if(priorityQueue[i][0] != null) {
				location++;
				
			}
		}
		if (location > priorityQueue.length-1) { // expands array	
			Object[][] tempPQ = new Object[priorityQueue.length * 2][86];
			for(int i = 0; i<priorityQueue.length; i++) {
				tempPQ[i][0] = priorityQueue[i][0];
				tempPQ[i][1] = priorityQueue[i][1];
				
			}
			priorityQueue = tempPQ;		
			}
		return location;
			
	}
	//Sort by Priority
	public void sortByPriority() {
		//Selection Sort
		int l = priorityQueue.length;
		int minIndex = 0;
		for (int i = 0; i< l-1; i++) {
			// Find the minimum element in arr[I...N]
			minIndex = i;
			for(int j = 0; j < l; j++) {
				if(priorityQueue[j][1] != null && priorityQueue[minIndex][1] != null) {
					int b = (int) priorityQueue[j][1];
					int c = (int) priorityQueue[minIndex][1];
					if(b<c) {
						minIndex = j;
					}
				}
			}
			// and place it at the beginning of [I...N]
			
			System.out.println(i);
			Object temp = priorityQueue[minIndex][0];
			Object temp1 = priorityQueue[minIndex][1];
			priorityQueue[minIndex][0] = priorityQueue[i][0];
			priorityQueue[minIndex][1] = priorityQueue[i][1];
			priorityQueue[i][0] = temp;
			priorityQueue[i][1] = temp1;
		}
	}
	
	//remove Most important element from array, call fixArray into priorityQueue	
	//	if no element to remove, throw out of bounds exception
	@SuppressWarnings("unchecked")
	public C remove() {
		Object returnC = priorityQueue[0][0];
		priorityQueue[0][0] = null;
		priorityQueue[0][1] = null;
		priorityQueue = fixArray();
		return (C)returnC;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<priorityQueue.length; i++)
			if (priorityQueue[i][1] != null) {
				sb.append(priorityQueue[i][1].toString());
			}
		return sb.toString();
	}
	
	//fixArray(){ fixes holes in array}
	//	creates temp. array
	// fills in any Null with element after it, replace element after it with Null store in temp array
	// return temp array
	public Object[][] fixArray() {
		Object[][] tempArr = new Object[priorityQueue.length][2];
		for (int i = 0; i<priorityQueue.length; i++) {
			if (priorityQueue[i][0] == null) {
				tempArr[i][0] = priorityQueue[i+1][0];
				tempArr[i][1] = priorityQueue[i+1][1];
				priorityQueue[i+1][0] = null;
				priorityQueue[i+1][1] = null;
			}
		}
		return tempArr;
	}
	
	
	
}
