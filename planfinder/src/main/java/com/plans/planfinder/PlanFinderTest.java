package com.plans.planfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.plans.planfinder.model.ComboPlan;
import com.plans.planfinder.model.Plan;



/**
 * Hello world!
 *
 */
public class PlanFinderTest {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader fileReader = new FileReader(new File(args[0]));
		//FileReader fileReader = new FileReader(new File("plans.txt"));
		//Scanner scanner = new Scanner(new File("plans.txt"));// Take this file name from Args
		Scanner scanner = new Scanner(fileReader);// Take this file name from Args
		Scanner console = new Scanner(System.in);
		 
		List<Plan> plans = new ArrayList<>();
		while(scanner.hasNext()) {
			String planStr = scanner.nextLine();
			String[] planArr = planStr.split(",");
			plans.add(getPlan(planArr));
		}
		/*
		 * System.out.println("Enter the commaseparted plan="); String input =
		 * console.nextLine();
		 */
		 String[] stringArray = args[1].split(",");
	    
	
		//List<String> features = Arrays.asList("email","voice","admin");//Take this features from Args
	    List<String> features = Arrays.asList(stringArray);
		
		PlanFinder finder = new PlanFinder();
		ComboPlan bestPlans = finder.findPlans(plans, features);
		System.out.println(bestPlans);
		
	}
	
	private static Plan getPlan(String[] planArr){
		Plan plan = new Plan();
		plan.setName(planArr[0]);
		plan.setPrice(Double.parseDouble(planArr[1]));
		List<String> features = new ArrayList<>();
		for(int i=2;i<planArr.length;i++) {
			features.add(planArr[i]);
		}
		plan.setFeatures(features);
		return plan;
	}
}
