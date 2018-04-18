package lottery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.math3.distribution.*;
import org.apache.commons.math3.util.*;

public class LotteryPick {
	// http://www.tankathon.com/pick_odds
	
	// key in pair represents pick number, value represents odds of getting that pick
	private Map<String, List<Pair<Integer, Double>>> teams;
	private int draftYear;
	
	public LotteryPick (Map<String, List<Pair<Integer, Double>>> teams, int draftYear) {
		this.teams = teams;
		this.draftYear = draftYear;
	}
	
	public Map<String, List<Pair<Integer, Double>>> getTeams() {
		return teams;
	}
	
	public void setTeams(Map<String, List<Pair<Integer, Double>>> teams) {
		this.teams = teams;
	}
	
	public int getdraftYear() {
		return draftYear;
	}
	
	public void setdraftYear(int draftYear) {
		this.draftYear = draftYear;
	}
	
	private boolean validProbabilityDistribution() {
		boolean flag = true;
		
		for (Map.Entry<String, List<Pair<Integer, Double>>> entry : this.teams.entrySet()) {
			if (flag = false) {
				break;
			}
			List<Pair<Integer, Double>> vals = entry.getValue();
			Double sum = 0.00;
			for (int i = 0; i < vals.size(); i++) {
				double probability = vals.get(i).getValue();
				if (vals.get(i).getValue() == null) {
					// deal w/ null values here
				}
				sum += probability;
			}
			// System.out.println(sum);
			if (sum.equals(1.0)) {
				flag = true;
			} else {
				flag = false;
				break;
				}
			}
		
		return flag;
	}
	
	public Map<String, Integer> lotteryPickCalculator() throws IllegalArgumentException {
		Map<String, Integer> finalResult = new HashMap<>();
		
		if (!this.validProbabilityDistribution()) {
			throw new IllegalArgumentException();
		}
		
		// use EnumeratedDistribution
		for (Map.Entry<String, List<Pair<Integer, Double>>> entry : this.teams.entrySet()) {
			EnumeratedDistribution<Integer> enumDist = new EnumeratedDistribution<>(entry.getValue());
			Integer pickNumber = enumDist.sample();
			finalResult.put(entry.getKey(), pickNumber);
		}
		
		return finalResult;
	}
}



