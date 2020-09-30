package com.utilitiescontainer;

public class PriorityQueue<C> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private static final int DEFAULT_PRIORITY = 0;
	private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
	static Object[][] priorityQueue = new Object[ DEFAULT_INITIAL_CAPACITY ][2];
	//put method to put stuff into arrays, Default Priority = findPriority();
	public void put(C input) {
		priorityQueue[findDefaultPriority()][0] = input;
		priorityQueue[findDefaultPriority()][1] = DEFAULT_PRIORITY;
		
	}
	public void put(C input, int priority) {
		priorityQueue[findDefaultPriority()][0] = input;
		priorityQueue[findDefaultPriority()][1] = priority;
		sortByPriority();
	}
	//To Find Priority, check within array check for non-null value add to a counter, "Priority"
	//		If Priority == array.lenght()
	//			make array size bigger by 2x

	public int findDefaultPriority() { //Finds current default priority and if needed expands array 
		int priority=0;
		for(int i=0; i<priorityQueue.length; i++) {
			if(priorityQueue[i][0] != null) {
				priority++;
			}
		}
		if (priority == priorityQueue.length) { // expands array	
			Object[][] tempPQ = new Object[priorityQueue.length * 2][0];
			for(int i = 0; i<priorityQueue.length; i++) {
				tempPQ[i][0] = priorityQueue[i][0];
				tempPQ[i][1] = priorityQueue[i][1];
			}
			priorityQueue = tempPQ;		
			}
		return priority;
			
	}
	//Sort by Priority
	public void sortByPriority() {
		
	}
	
	//remove Most important element from array, call fixArray into priorityQueue	
	//	if no element to remove, throw out of bounds exception
	
	
	
	
	
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
