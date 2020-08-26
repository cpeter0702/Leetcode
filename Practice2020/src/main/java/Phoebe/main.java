package Phoebe;

import java.util.ArrayList;
import java.util.List;

public class main {

	private static List<String> inputCommendsData() {
		List<String> inputCommendsData = new ArrayList<String>();
		inputCommendsData.add("5 5");
		inputCommendsData.add("1 2 N");
		inputCommendsData.add("LMLMLMLMM");
		inputCommendsData.add("3 3 E");
		inputCommendsData.add("MMRMMRMRRM");

		return inputCommendsData;
	}

	// 把答案印出來
	public static void printAnswer(List<Rovers> ansList) {
		for (Rovers rover : ansList) {
			System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection());
		}
	}

	public static void main(String[] args) {

		MarsRovers marsRovers = new MarsRovers();
		List<String> inputCommendsData = inputCommendsData();
		List<Rovers> answerList = null;
		
		try {
			answerList = marsRovers.doMarsExploring(inputCommendsData);
			
		} catch (NumberFormatException ne) {
			answerList = new ArrayList<Rovers>();
			ne.printStackTrace();
		} catch (IllegalArgumentException ie) {
			answerList = new ArrayList<Rovers>();
			ie.printStackTrace();
		} catch (Exception e) {
			answerList = new ArrayList<Rovers>();
			e.printStackTrace();
		}
		
		printAnswer(answerList);

	}

}
