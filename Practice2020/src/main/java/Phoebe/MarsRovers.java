package Phoebe;

import java.util.ArrayList;
import java.util.List;

public class MarsRovers {

	public  final char E = 'E'; // East
	private final char S = 'S'; // South
	private final char W = 'W'; // West
	private final char N = 'N'; // North
	private final char L = 'L'; // Left
	private final char R = 'R'; // Right
	private final char M = 'M'; // Move Forward
	private final String SPLITBY = " ";

	// start to exploring Mars
	public List<Rovers> doMarsExploring(List<String> inputCommendsData) throws IllegalArgumentException, NumberFormatException{
		// 決定 最後回傳是一個list, 裡面裝的是一個一個 Rovers答案
		List<Rovers> returnList = new ArrayList<Rovers>();
		if (inputCommendsData == null) {
			return returnList;
		}
		
		Rovers startPt = null;

		// 用for loop 一行一行的把指令讀出來
		for (int i = 0; i < inputCommendsData.size(); i++) {
			if (i == 0) {
				continue;
			}

			// 單數行 = 起始位置資訊
			if (i % 2 == 1) {
				// 解析成我們要的資料型態 (Rovers), 然後運行到下一行的時候給 decodeCommends 用
				// 下一個單數行的時候, 新的起始點就會蓋掉舊的了
				startPt = decodeStartPt(inputCommendsData.get(i));

				// 雙數行 = 左左右右前前的指令
			} else {
				// 1. 以單數行的起始點為基礎進行左左右右前前
				Rovers finalPt = decodeDirectionCommends(startPt, inputCommendsData.get(i));
				// 2. 得到最後的答案之後再把它加到list裡面, 最後一起回傳
				returnList.add(finalPt);

				// 一般會這樣寫, 怕你不好看懂所以拆解上上面兩個步驟
//				returnList.add(decodeCommends(startPt, inputCommendsData.get(i)));
			}
		}
		// 把裝滿答案的List回傳回去
		return returnList;
	}

	// decode commend line 1 ex: 1 2 N
	public Rovers decodeStartPt(String inputCommends) {
		if (inputCommends == null) {
			throw new IllegalArgumentException("Please Provide the Start Position of Rovers");
		}

		// 把指令用空格把他隔成 string array
		String[] commendArray = inputCommends.split(SPLITBY);
		if (commendArray.length != 3) {
			throw new IllegalArgumentException("Please Provide a suitable Position of Rovers ex: (1 2 N): " + inputCommends);
		}
		
		char direction = commendArray[2].charAt(0);
		if (direction != E && direction != S && direction != W && direction != N) {
			throw new IllegalArgumentException("Please Provide a suitable direction of Rovers ex: (1 2 N): " + inputCommends);
		}
		
		// 把每一個訊息放到我們的Rovers裡面帶著走
		Rovers rover = new Rovers(
				Integer.parseInt(commendArray[0]), 	// 第一個 = x
				Integer.parseInt(commendArray[1]), 	// 第二個 = y
				direction 							// 第三個 = 方向
		);

		// 把這個起始點回傳回去
		return rover;
	}

	// decode commend line 2 ex: LMLMLMLMM
	public Rovers decodeDirectionCommends(Rovers basePt, String commends) {
		if (commends == null) {
			return basePt;
		}
		
		// 把指令一個一個讀出來
		for (int i = 0; i < commends.length(); i++) {
			
			// 如果是Ｌ就左轉
			if (commends.charAt(i) == L) {
				this.turnLeft(basePt);
			// 如果是R就右轉
			} else if (commends.charAt(i) == R) {
				this.turnRight(basePt);
			// 剩下就是M = 前進一格
			} else if (commends.charAt(i) == M) {
				this.moveForward(basePt);
			} else {
				throw new IllegalArgumentException("Incorrect Direction Commends: " + commends);
			}
		}

		return basePt;
	}

	// move forward
	public Rovers moveForward(Rovers preRover) {
		// 面向東邊往前 = x + 1
		if (preRover.getDirection() == E) {
			preRover.setX(preRover.getX() + 1);
		// 面向南邊往前 = y - 1
		} else if (preRover.getDirection() == S) {
			preRover.setY(preRover.getY() - 1);
		// 面向西邊往前 = x - 1
		} else if (preRover.getDirection() == W) {
			preRover.setX(preRover.getX() - 1);
		// 面向北邊往前 = y + 1
		} else if (preRover.getDirection() == N) {
			preRover.setY(preRover.getY() + 1);
		} else {
			throw new IllegalArgumentException("Function moveForward: Incorrect Direction Commends");
		}

		return preRover;
	}

	// turn right
	public Rovers turnRight(Rovers preRover) {
		// 面向東邊右轉 = 面南邊 
		if (preRover.getDirection() == E) {
			preRover.setDirection(S);
		// 面向南邊右轉 = 面西邊
		} else if (preRover.getDirection() == S) {
			preRover.setDirection(W);
		// 面向西邊右轉 = 面北邊
		} else if (preRover.getDirection() == W) {
			preRover.setDirection(N);
		// 面向北邊右轉 = 面東邊
		} else if (preRover.getDirection() == N){
			preRover.setDirection(E);
		} else {
			throw new IllegalArgumentException("Function turnRight: Incorrect Direction Commends");
		}

		return preRover;
	}

	// turn left
	public Rovers turnLeft(Rovers preRover) {
		// 面向東邊左轉 = 面北邊
		if (preRover.getDirection() == E) {
			preRover.setDirection(N);
		// 面向南邊左轉 = 面西邊
		} else if (preRover.getDirection() == S) {
			preRover.setDirection(E);
		// 面向西邊左轉 = 面南邊
		} else if (preRover.getDirection() == W) {
			preRover.setDirection(S);
		// 面向北邊左轉 = 面西邊
		} else if (preRover.getDirection() == N){
			preRover.setDirection(W);
		} else {
			throw new IllegalArgumentException("Function turnLeft: Incorrect Direction Commends");
		}

		return preRover;
	}
}
