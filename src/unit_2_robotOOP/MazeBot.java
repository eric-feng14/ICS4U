package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Template class for MazeRunner class
 * @author Eric Feng
 * @version April 10 2025
 */
public class MazeBot extends RobotSE{
	
	//Visited array to use amongst all methods
	private boolean[][] vis = new boolean[MazeRunner.gridHeight][MazeRunner.gridLength];
	private ArrayList<Direction> path = new ArrayList<Direction>(); //current robot path
	
	
	/**
	 * Constructor method for creating a mazerunner robot
	 * @param c c is the city
	 * @param ave ave is the horizontal nums
	 * @param street street is the vertical nums
	 * @param d d is the initial direction the robot is facing
	 */
	public MazeBot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
		visitStart(ave, street);
	}
	
	/**
	 * add the starting node to the visited 2d array
	 * @param x x value of the starting position
	 * @param y y value of the starting position
	 */
	private void visitStart(int x, int y) {
		vis[x][y] = true;
	}
	
	/**
	 * main command to start the robot traversal of the maze
	 */
	public void run() {
		while (! this.canPickThing()) {
			Direction dir = newPosition();
			if (dir == null) { //start backtracking
				dir = getOppositeDirection(this.path.remove(this.path.size()-1));
			}
			this.moveToPosition(dir);
		}
	}
	
	private void moveToPosition(Direction d) {
		if (d == Direction.NORTH) {
			this.turnNorth();
		} else if (d == Direction.EAST) {
			this.turnEast();
		} else if (d == Direction.SOUTH) {
			this.turnSouth();
		} else if (d == Direction.WEST) {
			this.turnWest();
		}
		
		this.move();
	}
	
	/**
	 * returns null if no new position could be found
	 * otherwise returns a valid position to go to next
	 * @return a valid direction for the robot to continue to
	 */
	private Direction newPosition() {
        for (int i = 0; i < 4; i++) { //Rotate 360 degrees
        	int[] directions = getDirections(this.getDirection());
    		int nr = this.getStreet() + directions[0];
    		int nc = this.getAvenue() + directions[1];
    		
        	if (this.frontIsClear() && ! vis[nr][nc]) {
        		this.vis[nr][nc] = true;
        		this.path.add(this.getDirection());
        		return this.getDirection();
        	}
        	
        	this.turnRight();
        }
        return null;
	}
	
	private Direction getOppositeDirection(Direction d) {
		if (d == Direction.NORTH) {
			return Direction.SOUTH;
		} else if (d == Direction.EAST) {
			return Direction.WEST;
		} else if (d == Direction.SOUTH) {
			return Direction.NORTH;
		} else if (d == Direction.WEST) {
			return Direction.EAST;
		}
		return null;
	}
	
	private int[] getDirections(Direction d) {
		int[] arr = new int[2];
		if (d == Direction.NORTH) {
			arr[0] = -1;
			arr[1] = 0;
		} else if (d == Direction.EAST) {
			arr[0] = 0;
			arr[1] = 1;
		} else if (d == Direction.SOUTH) {
			arr[0] = 1;
			arr[1] = 0;
		} else if (d == Direction.WEST) {
			arr[0] = 0;
			arr[1] = -1;
		}
		return arr;
		
	}
	
	/**
	 * turns the robot west
	 */
	private void turnWest() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.NORTH) {
			this.turnLeft();
		} else if (dir == Direction.EAST) {
			this.turnAround();
		} else if (dir == Direction.SOUTH) {
			this.turnRight();
		}
	}
	
	/**
	 * turns the robot south
	 */
	private void turnSouth() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.WEST) {
			this.turnLeft();
		} else if (dir == Direction.NORTH) {
			this.turnAround();
		} else if (dir == Direction.EAST) {
			this.turnRight();
		}
	}
	
	/**
	 * turns the robot east
	 */
	private void turnEast() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.SOUTH) {
			this.turnLeft();
		} else if (dir == Direction.WEST) {
			this.turnAround();
		} else if (dir == Direction.NORTH) {
			this.turnRight();
		}
	}
	
	/**
	 * turns the robot north
	 */
	private void turnNorth() {
		Direction dir = this.getDirection();
		
		if (dir == Direction.EAST) {
			this.turnLeft();
		} else if (dir == Direction.SOUTH) {
			this.turnAround();
		} else if (dir == Direction.WEST) {
			this.turnRight();
		}
	}
	
}
