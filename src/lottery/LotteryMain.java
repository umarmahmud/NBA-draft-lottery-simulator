package lottery;
import java.util.HashMap;
import java.util.Map;

public class LotteryMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> myTeam = new HashMap<>();
		
		myTeam.put("myteam", 100);
		
		LotteryPick thisYear = new LotteryPick(myTeam, 1999);
		
		System.out.println(thisYear.lotteryPickCalculator());
		
	}

}
