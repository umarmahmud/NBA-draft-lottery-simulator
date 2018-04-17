package lottery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class LotteryPick {
	
	// need new DS - Map<Integer, Map<String, Double>> draft;
	// Integer is for pick number, String is team, Double is weight (probability)
	// http://www.tankathon.com/pick_odds
	
	private Map<String, List<Double>> teams;
	private int draftYear;
	
	public LotteryPick (Map<String, List<Double>> teams, int draftYear) {
		this.teams = teams;
		this.draftYear = draftYear;
	}
	
	public Map<String, List<Double>> getTeams() {
		return teams;
	}
	
	public void setTeams(Map<String, List<Double>> teams) {
		this.teams = teams;
	}
	
	public int getdraftYear() {
		return draftYear;
	}
	
	public void setdraftYear(int draftYear) {
		this.draftYear = draftYear;
	}
	
	private boolean validOdds() {
		
		// don't use this.team.values; it returns a collection
		
		boolean flag;
		
		this.teams.forEach((k, v) -> {
			List<Double> totList = this.teams.get(k);
			if (totList.stream().reduce(0.0, (a, b) -> (a + b)) == 100.0) {
				flag = true;
			} else {
				flag = false;
			}
		});
		// add horizontal sum of values; both should equal 100
		
		
		return flag;
	}
	
	public Map<String, List<Double>> lotteryPickCalculator() throws IllegalArgumentException {
		Random random = new Random();
		
		if (!this.validOdds()) {
			throw new IllegalArgumentException();
		}
		
		// use EnumeratedDistribution
		this.teams.forEach((k, v) -> {
			this.teams.put(k, random.nextInt(14));
		});
		return this.teams;
	}
}



