package Leetcode;

public class No005_LongestPalindromicSubstring {
	private int getSinglePalidromeDistence(String s, int leftPt, int rightPt) {
		boolean isContinue = true;
		int count = 0;
		while (isContinue) {
			if (leftPt < 0 || rightPt >= s.length()) {
				break;
			}

			if (s.charAt(leftPt) == s.charAt(rightPt)) {
				isContinue = true;
				leftPt -= 1;
				rightPt += 1;
				count += 1;
			} else {
				isContinue = false;
			}

		}

		return count;
	}

	public String longestPalindrome(String s) {

		if (s == null || s.length() <= 0) {
			return s;
		}

		String ans = "";

		for (int middlePt = 0; middlePt < s.length(); middlePt++) {

			int oddDistence = getSinglePalidromeDistence(s, middlePt - 1, middlePt + 1);
			int evenDistence = getSinglePalidromeDistence(s, middlePt, middlePt + 1);
			String oddStr = s.substring(middlePt - oddDistence, middlePt + oddDistence + 1);
			String evenStr = s.substring(middlePt - evenDistence + 1, middlePt + evenDistence + 1);
			String thisLongest = oddStr.length() > evenStr.length() ? oddStr : evenStr;

			if (thisLongest.length() > ans.length()) {
				ans = thisLongest;
			}

		}

		return ans;

	}
}
