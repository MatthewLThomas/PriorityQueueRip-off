package com.utilitiescontainer;

public class PriorityQueue<C> {
	
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int DEFAULT_PRIORITY = 0; // Lowest Priority
														// Object Array				Priority Array
	private static Object[][] priorityQueue = new Object[ DEFAULT_INITIAL_CAPACITY ][2];
	//put method to put stuff into arrays, Default Priority = findPriority();
	public void put(C input) {
		priorityQueue[findLocation()][0] = input;
		priorityQueue[findLocation()][1] = DEFAULT_PRIORITY;
		
	}
	public void put(C input, int priority) {
		priorityQueue[findLocation()][0] = input;
		priorityQueue[findLocation()][1] = priority;
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
		if (location == priorityQueue.length) { // expands array	
			Object[][] tempPQ = new Object[priorityQueue.length * 2][0];
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
		
		int l = priorityQueue.length;
		int minIndex = 0;
		for (int i = 0; i< l-1; i++) {
			// Find the minimum element in arr[X...N]
			minIndex = i;
			for(int j = 0; j < l; j++) {
				if((Integer)priorityQueue[j][1] < (Integer)priorityQueue[minIndex][1]) {
					minIndex = j;
				}
				}
			// and place it at the beginning of [X...N]
			Object[][] temp = new Object[1][2]; 
			temp[0][0] = priorityQueue[minIndex][0];
			temp[0][1] = priorityQueue[minIndex][1];
			priorityQueue[minIndex][0] = priorityQueue[i][0];
			priorityQueue[minIndex][1] = priorityQueue[i][1];
			priorityQueue[i][0] = temp[0][0];
			priorityQueue[i][1] = temp[0][1];
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
	
	
	
	
	//fixArray(){ fixes holes in array}
	//	creates temp. array
	// fills in any Null with element after it, relpace element after it with Null store in temp array
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
