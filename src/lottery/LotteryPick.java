package lottery;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class LotteryPick {
	
	// need new DS - Map<Integer, Map<String, Double>> draft;
	// Integer is for pick number, String is team, Double is weight (probability)
	// http://www.tankathon.com/pick_odds
	
	private Map<String, Integer> teams;
	private int draftYear;
	
	public LotteryPick(Map<String, Integer> teams, int draftYear) {
		this.teams = teams;
		this.draftYear = draftYear;
	}
	
	public Map<String, Integer> getTeams() {
		return teams;
	}
	
	public void setTeams(Map<String, Integer> teams) {
		this.teams = teams;
	}
	
	public int getdraftYear() {
		return draftYear;
	}
	
	public void setdraftYear(int draftYear) {
		this.draftYear = draftYear;
	}
	
	private boolean validOdds() {
		Collection<Integer> chances = this.teams.values();
		// add horizontal sum of values; both should equal 100
		
		if (chances.stream().reduce(0, (a,b) -> a + b) == 100) {
			return true;
		}
		return false;
	}
	
	public Map<String, Integer> lotteryPickCalculator() throws IllegalArgumentException {
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



