package unit_2_robotOOP;
import becker.robots.*;
import java.util.*;

public class MazeBot extends RobotSE{
	
	//Visited array to use amongst all methods
	private boolean[][] vis = new boolean[MazeRunner.gridHeight][MazeRunner.gridLength];
	private ArrayList<>
	
	//Constructor
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
		
	}
	

	
	private void
	
}
