package Phoebe;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoversTest {

	@Test
	public void turnLeftNormalTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers rover = new Rovers(1, 1, 'E');
		marsRovers.turnLeft(rover);
		Assert.assertEquals('N', rover.getDirection());

		rover = new Rovers(1, 1, 'S');
		marsRovers.turnLeft(rover);
		Assert.assertEquals('E', rover.getDirection());

		rover = new Rovers(1, 1, 'W');
		marsRovers.turnLeft(rover);
		Assert.assertEquals('S', rover.getDirection());

		rover = new Rovers(1, 1, 'N');
		marsRovers.turnLeft(rover);
		Assert.assertEquals('W', rover.getDirection());

	}

	@Test(expected = IllegalArgumentException.class)
	public void turnLeftExceptionTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers rover = new Rovers(1, 1, 'K');
		marsRovers.turnLeft(rover);
	}

	@Test
	public void turnRightNormalTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers rover = new Rovers(1, 1, 'E');
		marsRovers.turnRight(rover);
		Assert.assertEquals('S', rover.getDirection());

		rover = new Rovers(1, 1, 'S');
		marsRovers.turnRight(rover);
		Assert.assertEquals('W', rover.getDirection());

		rover = new Rovers(1, 1, 'W');
		marsRovers.turnRight(rover);
		Assert.assertEquals('N', rover.getDirection());

		rover = new Rovers(1, 1, 'N');
		marsRovers.turnRight(rover);
		Assert.assertEquals('E', rover.getDirection());

	}

	@Test(expected = IllegalArgumentException.class)
	public void turnRightExceptionTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers rover = new Rovers(1, 1, 'K');
		marsRovers.turnRight(rover);
	}

	@Test
	public void moveForwardNormalTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers rover = new Rovers(1, 1, 'E');
		marsRovers.moveForward(rover);
		Assert.assertEquals('E', rover.getDirection());
		Assert.assertEquals(2, rover.getX());

		rover = new Rovers(1, 1, 'S');
		marsRovers.moveForward(rover);
		Assert.assertEquals('S', rover.getDirection());
		Assert.assertEquals(0, rover.getY());

		rover = new Rovers(1, 1, 'W');
		marsRovers.moveForward(rover);
		Assert.assertEquals('W', rover.getDirection());
		Assert.assertEquals(0, rover.getX());

		rover = new Rovers(1, 1, 'N');
		marsRovers.moveForward(rover);
		Assert.assertEquals('N', rover.getDirection());
		Assert.assertEquals(2, rover.getY());

	}

	@Test
	public void decodeDirectionCommendsTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers basePt = new Rovers(1, 2, 'N');
		String commends = "LMLMLMLMM";
		Rovers rover = marsRovers.decodeDirectionCommends(basePt, commends);
		Assert.assertEquals(1, rover.getX());
		Assert.assertEquals(3, rover.getY());
		Assert.assertEquals('N', rover.getDirection());

		basePt = new Rovers(3, 3, 'E');
		commends = "MMRMMRMRRM";
		rover = marsRovers.decodeDirectionCommends(basePt, commends);
		Assert.assertEquals(5, rover.getX());
		Assert.assertEquals(1, rover.getY());
		Assert.assertEquals('E', rover.getDirection());
		
		basePt = new Rovers(3, 3, 'E');
		commends = null;
		rover = marsRovers.decodeDirectionCommends(basePt, commends);
		Assert.assertEquals(3, rover.getX());
		Assert.assertEquals(3, rover.getY());
		Assert.assertEquals('E', rover.getDirection());
		
		basePt = new Rovers(3, 3, 'E');
		commends = "";
		rover = marsRovers.decodeDirectionCommends(basePt, commends);
		Assert.assertEquals(3, rover.getX());
		Assert.assertEquals(3, rover.getY());
		Assert.assertEquals('E', rover.getDirection());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void decodeDirectionCommendsExceptionTesting() {
		MarsRovers marsRovers = new MarsRovers();
		Rovers basePt = new Rovers(1, 2, 'N');
		String commends = "aabbaba";
		marsRovers.decodeDirectionCommends(basePt, commends);
		
		basePt = new Rovers(3, 3, 'Q');
		commends = "MMRMMRMRRM";
		marsRovers.decodeDirectionCommends(basePt, commends);
		
	}

	@Test
	public void decodeStartPtTesting() {
		MarsRovers marsRovers = new MarsRovers();
		String commends = "1 2 N";
		Rovers rover = marsRovers.decodeStartPt(commends);
		Assert.assertEquals(1, rover.getX());
		Assert.assertEquals(2, rover.getY());
		Assert.assertEquals('N', rover.getDirection());
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void decodeStartPtException1Testing() {
		MarsRovers marsRovers = new MarsRovers();
		String commends = null;
		marsRovers.decodeStartPt(commends);
		
		marsRovers = new MarsRovers();
		commends = "";
		marsRovers.decodeStartPt(commends);
		
		marsRovers = new MarsRovers();
		commends = "1 2N";
		marsRovers.decodeStartPt(commends);
		
		marsRovers = new MarsRovers();
		commends = "1 2 U";
		marsRovers.decodeStartPt(commends);
		
		marsRovers = new MarsRovers();
		commends = "1 2 LG";
		marsRovers.decodeStartPt(commends);
		
	}
	
	@Test(expected = NumberFormatException.class)
	public void decodeStartPtException2Testing() {
		MarsRovers marsRovers = new MarsRovers();
		String commends = "Q Q E";
		marsRovers.decodeStartPt(commends);
		
	}
	
	@Test
	public void doMarsExploring() {
		MarsRovers marsRovers = new MarsRovers();
		List<String> inputCommendsData = new ArrayList<String>();
		inputCommendsData.add("5 5");
		inputCommendsData.add("1 2 N");
		inputCommendsData.add("LMLMLMLMM");
		inputCommendsData.add("3 3 E");
		inputCommendsData.add("MMRMMRMRRM");
		
		List<Rovers> ansList = marsRovers.doMarsExploring(inputCommendsData);
		Assert.assertEquals(2, ansList.size());
		Assert.assertEquals(1, ansList.get(0).getX());
		Assert.assertEquals(3, ansList.get(0).getY());
		Assert.assertEquals('N', ansList.get(0).getDirection());
		Assert.assertEquals(5, ansList.get(1).getX());
		Assert.assertEquals(1, ansList.get(1).getY());
		Assert.assertEquals('E', ansList.get(1).getDirection());
		
		inputCommendsData = null;
		ansList = marsRovers.doMarsExploring(inputCommendsData);
		Assert.assertEquals(0, ansList.size());
		
		
	}

}
