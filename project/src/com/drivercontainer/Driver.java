package com.drivercontainer;
import com.utilitiescontainer.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> bobsDiner = new PriorityQueue<String>();
		bobsDiner.put("James");
		bobsDiner.put("Arthur");
		bobsDiner.put("Hal");
		bobsDiner.put("Erica");
		bobsDiner.put("Bill");
		bobsDiner.put("Malinda");
		bobsDiner.put("Clifton");
		bobsDiner.put("Steve");
		bobsDiner.put("Matthew");
		bobsDiner.put("Tim");
		bobsDiner.put("Hideo Kojima");
		bobsDiner.put("Will");
		bobsDiner.put("Bill");
		bobsDiner.toString();
		bobsDiner.put("Linas Torvalds", 1);
		bobsDiner.toString();

	}

}
