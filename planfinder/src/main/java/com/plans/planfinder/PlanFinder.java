package com.plans.planfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.plans.planfinder.model.ComboPlan;
import com.plans.planfinder.model.Plan;
import com.plans.planfinder.model.WeightedPlan;

public class PlanFinder {

	public ComboPlan findPlans(List<Plan> allPlans, List<String> requiredFeatures) {
		List<WeightedPlan> matchedPlans = filterAllMatchedPlans(allPlans, requiredFeatures);
		Comparator<WeightedPlan> comparator = (o1, o2) -> {
			int comp = Integer.compare(o2.getWeight(), o1.getWeight());
			if (comp != 0)
				return comp;
			return Double.compare(o1.getPrice(), o2.getPrice());
		};
		Collections.sort(matchedPlans, comparator);
//		System.out.println("Sorted " + matchedPlans.toString());
		ComboPlan singleMatchBest = findAllMatched(matchedPlans, requiredFeatures);
		if (singleMatchBest != null) {
			return singleMatchBest;
		}
		ComboPlan bestPlans = findBestPlans(matchedPlans, requiredFeatures);
		return bestPlans;
	}

	private ComboPlan findBestPlans(List<WeightedPlan> matchedPlans, List<String> requiredFeatures) {
		List<ComboPlan> comboPlans = new ArrayList<>();
		for (int i = 0; i < matchedPlans.size(); i++) {
			ComboPlan comboPlan = new ComboPlan();
			comboPlan.getPlans().add(matchedPlans.get(i).getName());
			comboPlan.setPrice(matchedPlans.get(i).getPrice());
			comboPlan.getFeatures().addAll(matchedPlans.get(i).getMatchedFeatures());
			for (int j = 0; j < matchedPlans.size(); j++) {
				if(i!=j) {
					boolean isNewPlanContainsFeatures = false;
					for (String newFeature : matchedPlans.get(j).getMatchedFeatures()) {
						if (!comboPlan.getFeatures().contains(newFeature) && requiredFeatures.contains(newFeature)) {
							comboPlan.getFeatures().add(newFeature);
							isNewPlanContainsFeatures = true;
						}
					}
					if (isNewPlanContainsFeatures) {
						comboPlan.getPlans().add(matchedPlans.get(j).getName());
						comboPlan.setPrice(comboPlan.getPrice() + matchedPlans.get(j).getPrice());
					}
				}
				
			}
			if (comboPlan.getFeatures().size() == requiredFeatures.size()) {
				comboPlans.add(comboPlan);
			}
		}
//		System.out.println(comboPlans);
		return finalComboPlan(comboPlans);
	}

	private ComboPlan finalComboPlan(List<ComboPlan> comboPlans) {
		Comparator<ComboPlan> comparator = (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice());
		return comboPlans.stream().sorted(comparator).findFirst().get();
	}

	private ComboPlan findAllMatched(List<WeightedPlan> matchedPlans, List<String> requiredFeatures) {
		List<WeightedPlan> allMatchedPlans = matchedPlans.stream().filter(p -> p.getWeight() == requiredFeatures.size())
				.collect(Collectors.toList());
		if (!allMatchedPlans.isEmpty()) {
			WeightedPlan plan = null;
			for (WeightedPlan weightedPlan : allMatchedPlans) {
				if (plan == null) {
					plan = weightedPlan;
					continue;
				}
				if (weightedPlan.getPrice() < plan.getPrice())
					plan = weightedPlan;
			}
			ComboPlan comboPlan = new ComboPlan();
			comboPlan.setFeatures(plan.getMatchedFeatures());
			comboPlan.setPrice(plan.getPrice());
			comboPlan.setPlans(Arrays.asList(plan.getName()));
			return comboPlan;
		}
		return null;
	}

	private List<WeightedPlan> filterAllMatchedPlans(List<Plan> allPlans, List<String> requiredFeatures) {
		List<WeightedPlan> plans = new ArrayList();
		for (Plan plan : allPlans) {
			List<String> matchedFeatures = new ArrayList<>();
			for (String feature : requiredFeatures) {
				if (plan.getFeatures().contains(feature)) {
					matchedFeatures.add(feature);
				}
			}
			if (!matchedFeatures.isEmpty())
				plans.add(convertPlan(plan, matchedFeatures));

		}
		return plans;
	}

	private WeightedPlan convertPlan(Plan plan, List<String> features) {
		WeightedPlan weightedPlan = new WeightedPlan();
		weightedPlan.setName(plan.getName());
		weightedPlan.setPrice(plan.getPrice());
		weightedPlan.setWeight(features.size());
		weightedPlan.setMatchedFeatures(features);
		return weightedPlan;
	}

}
