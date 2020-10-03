package com.drivercontainer;
import com.utilitiescontainer.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		PriorityQueue<String> bobsDiner = new PriorityQueue<String>();
		bobsDiner.put("McCoy", 10);
		bobsDiner.put("James");
		bobsDiner.put("Arthur");
		System.out.println(bobsDiner.toString());
		bobsDiner.put("Hal");
		bobsDiner.put("Erica");
		bobsDiner.put("Bill");
		bobsDiner.put("Malinda");
		bobsDiner.put("Clifton");
		bobsDiner.put("Steve");
		bobsDiner.put("Matthew");
		bobsDiner.put("Tim");
		bobsDiner.put("Hideo Kojima");
		//Triggers Array Expansion
		bobsDiner.put("Will");
		bobsDiner.put("Bill");
		System.out.println(bobsDiner.toString());
		bobsDiner.put("Jimmy", 4);
		System.out.println(bobsDiner.toString());
		bobsDiner.put("Linas Torvalds", -1);
		System.out.println(bobsDiner.toString());
		
	}

}
