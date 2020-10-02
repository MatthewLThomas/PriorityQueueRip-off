package com.utilitiescontainer;

public class PriorityQueue<C> {
	
	
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int DEFAULT_PRIORITY = 5; // Lowest Priority
	
														// Object Array				Priority Array
	private static Object[][] priorityQueue = new Object[ DEFAULT_INITIAL_CAPACITY ][2];
	//put method to put stuff into arrays, Default Priority = findPriority();
	public void put(C input) {
		int location = findLocation();
		priorityQueue[location][0] = input;
		priorityQueue[location][1] = DEFAULT_PRIORITY;
		sortByPriority();
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

	public int findLocation() { //Finds current location and if needed expands array 
	int location=0;
		for(int i=0; i<priorityQueue.length; i++) {
			if(priorityQueue[i][0] != null) {
				location++;
				
			}
		}
		if (location > priorityQueue.length-1) { // expands array	
			System.out.println("Old Array Length ="+priorityQueue.length);
			Object[][] tempPQ = new Object[priorityQueue.length * 2][86];
			for(int i = 0; i<priorityQueue.length; i++) {
				tempPQ[i][0] = priorityQueue[i][0];
				tempPQ[i][1] = priorityQueue[i][1];
				
			}
			priorityQueue = tempPQ;		
			System.out.println("New Array Length ="+priorityQueue.length);
			}
		return location;
			
	}
	//Sort by Priority
	public void sortByPriority() {
		//Bubble Sort
		
		int n = priorityQueue.length;
		for (int i = 0; i< n-1; i++) {
			for(int j = 0; j < n-1; j++) {
				if(priorityQueue[j][1] != null && priorityQueue[j+1][1] != null) {
					if((int) priorityQueue[j][1] > (int) priorityQueue[j+1][1]) {
						//swap arr[j+1] and arr[j]
						Object temp = priorityQueue[j][0];
						Object temp1 = priorityQueue[j][1];
						
						priorityQueue[j][0] = priorityQueue[j+1][0];
						priorityQueue[j][1] = priorityQueue[j+1][1];
						priorityQueue[j+1][0] = temp;
						priorityQueue[j+1][1] = temp1;
						
					
					}
				}
			}
			
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
		// fills in any Null with element after it, replace element after it with Null store in temp array
		// return temp array
		public Object[][] fixArray() {
			Object[][] tempArr = new Object[priorityQueue.length][2];
			for (int i = 0; i<priorityQueue.length-1; i++) {
				if (priorityQueue[i][0] == null) {
					tempArr[i][0] = priorityQueue[i+1][0];
					tempArr[i][1] = priorityQueue[i+1][1];
					priorityQueue[i+1][0] = null;
					priorityQueue[i+1][1] = null;
				}
			}
			return tempArr;
		}
		
		
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("--------------------\n");
		for(int i = 0; i<priorityQueue.length; i++)
			if (priorityQueue[i][1] != null) {
				sb.append(priorityQueue[i][0].toString());
				sb.append(": ");
				sb.append(priorityQueue[i][1].toString());
				sb.append("\n");
				
				
			}
		sb.append("--------------------\n");
		return sb.toString();
	}
	
	
	
}
