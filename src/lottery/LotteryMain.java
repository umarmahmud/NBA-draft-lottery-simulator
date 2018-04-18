package lottery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.util.Pair;

public class LotteryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// measure conditional probabilities (two teams can't get the same pick)
		// deal with nulls
		// read from file
		
		Map <String, List<Pair<Integer, Double>>> t = new HashMap<>();
		t.put("Knicks", new ArrayList<Pair<Integer, Double>>());
		List<Pair<Integer, Double>> teamsList = t.get("Knicks");
		Pair<Integer, Double> pairOne = new Pair<>(1, .10);
		Pair<Integer, Double> pairTwo = new Pair<>(2, .90);
		// Pair<Integer, Double> pairThree = new Pair<>(3, null);
		teamsList.add(pairOne);
		teamsList.add(pairTwo);
		// teamsList.add(pairThree);
		System.out.println(t);
		LotteryPick lp = new LotteryPick(t, 1999);
		System.out.println(lp.lotteryPickCalculator());
	}
}
