package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

/**
 * Template class for MazeRunner class
 * @author Eric Feng
 * @version April 10 2025
 */
public class SimpleMazeBot extends RobotSE{
	
	//Visited array to use amongst all methods, and a path containing the past directions for backtracking
	private boolean[][] vis = new boolean[MazeRunner.gridHeight][MazeRunner.gridLength];
	private ArrayList<Direction> path = new ArrayList<Direction>(); //current robot path
	
	
	/**
	 * Constructor method for creating a SimpleMazeBot
	 * @param c c is the city
	 * @param ave ave is the vertical numbers (rows)
	 * @param street street is the horizontal numbers (columns)
	 * @param d d is the initial direction the robot is facing
	 */
	public SimpleMazeBot(City c, int ave, int street, Direction d) {
		super(c, ave, street, d); //calls the parent's constructor
		this.visitStart(ave, street);
	}
	
	/**
	 * add the starting node to the visited array
	 * @param x x is the starting position street
	 * @param y y is the starting position avenue
	 */
	private void visitStart(int x, int y) {
		this.vis[x][y] = true;
	}
	
	/**
	 * main command to start the robot traversal of the maze
	 */
	public void run() {
		while (! this.canPickThing()) {
			this.newPosition();
			System.out.println(this.path.size());
		}
	}
	

	/**
	 * main logic for tarversing to a new position
	 * if the robot can move to 1 new node, it will go to that one node and return
	 * if it cant go anywhere else, it will backtrack
	 */
	private void newPosition() {
        for (int i = 0; i < 4; i++) { //Rotate 360 degrees
        	int[] directions = getDirections(this.getDirection());
    		int nr = this.getStreet() + directions[0];
    		int nc = this.getAvenue() + directions[1];
    		
    		//If the robot can move to the next node and it's not been visited before
        	if (this.frontIsClear() && ! vis[nr][nc]) {
        		this.vis[nr][nc] = true;
        		this.path.add(this.getDirection());
        		this.move();
        		return;
        	}
        	
        	this.turnRight();
        }
        
        //Backtrack if no other nodes can be traversed to
        this.moveOppositeDirection(this.path.remove(this.path.size()-1));
	}
	
	/**
	 * Main logic for backtracking
	 * @param d d is the direction taken to get to the current position (e.g. top of stack)
	 */
	private void moveOppositeDirection(Direction d) {
		/*
		 * If the path arraylist contained pairs of coordinates the code would look something like this:
		 * int dx = top of stack[0] - this.x, dy = top of stack[1] - this.y
		 * if (dx == -1 && dy == 0) {
		 * 		go north (note we don't need to reverse the direction because we're subtracting
		 * 		the current coordinate from the top of the stack
		 * }
		 */
		
		if (d == Direction.NORTH) {
			this.turnSouth();
		} else if (d == Direction.EAST) {
			this.turnWest();
		} else if (d == Direction.SOUTH) {
			this.turnNorth();
		} else if (d == Direction.WEST) {
			this.turnEast();
		}
		this.move();
	}
	
	/**
	 * returns a pair of integers to use for tracking visited nodes
	 * @param d direction to move forward are mark visited
	 * @return returns a pair of integers
	 */
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
