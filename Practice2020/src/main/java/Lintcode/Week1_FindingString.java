package Lintcode;

//输入: source = "source" ， target = "target"
//输出:-1	
//样例解释: 如果source里没有包含target的内容，返回-1

//输入: source = "abcdabcdefg" ，target = "bcd"
//输出: 1	
//样例解释: 如果source里包含target的内容，返回target在source里第一次出现的位置


public class Week1_FindingString {
	
	public static int findingString(String source, String target ) {
		if(source == null || source.length() <= 0 || target == null || target.length() <= 0) {
			return -1;
		}
		
		int returnPosition = -1;
		boolean isMatch = false;
		
		for (int i = 0 ; i < source.length(); i++) {
			for (int j = 0 ; j < target.length(); j++) {
				if(source.charAt(i) != target.charAt(j)) {
					break;
				}
				
				if(j == target.length() - 1) {
					System.out.println("i: " + i);
					System.out.println("i: " + j);
					returnPosition = i - target.length() + 1;
					isMatch = true;
				}
				
				i += 1;
			}
			
			if(isMatch) {
				break;
			}
		}
		
		return returnPosition;
	}
	
	public static void main(String[] args) {
		String source = "abcdabcdefg";
		String target = "bcd";
		
		int ans = findingString(source, target);
		
		System.out.println("Ans: " + ans);
	}
}
