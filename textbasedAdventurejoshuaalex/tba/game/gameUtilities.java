package game;

import rooms.Hallway;
import rooms.Room;

public class gameUtilities {
	/*
	 * Based on the two int parameters which represent the players x and y positions in the array,
	 * the method returns a string array that contains a list of posible directions where doors
	 * can be located in the room that the player is currently in.
	 * 
	 * @param y the y position of the player in the array
	 * @param x the x position of the player in the array
	 */
	public static String[] findDoors(int y, int x) {
		if(x == 2) {
			if( y == 2) {
				String[] tempstring = {"North","West"};
				return tempstring;
			}
			else if(y == 0) {
				String[] tempstring = {"South","West"};
				return tempstring;
			}
			else {
				String[] tempstring = {"North","West","South"};
				return tempstring;
			}
		}
		else if(x == 0) {
			if( y ==2) {
				String[] tempstring = {"North","East"};
				return tempstring;
			}
			else if(y == 0) {
				String[] tempstring = {"South","East"};
				return tempstring;
			}
			else {
				String[] tempstring = {"North","East","South"};
				return tempstring;
			}
		}
		else {
			if(y == 2) {
				String[] tempstring = {"North","East","West"};
				return tempstring;
			}
			else if(y == 0) {
				String[] tempstring = {"South","East","West"};
				return tempstring;
			}
		}
		String[] tempstring = {"North","East","South","West"};
		return tempstring;
	}
		/*
		 * This general method allows the program to search for keywords that are typed into the console.
		 * It takes in the two string parameters, statement and goal, and an int parameter and uses it to 
		 * return the position of the keyword.
		 * 
		 * @param statement The entire statement that is typed into the console by the user
		 * @param goal The keyword that is being looked for
		 * @param startPos Where the keyword search starts from
		 * @return An integer that represents the position of the keyword
		 */
		public static int findKeyword(String statement, String goal,int startPos) {
			String phrase = statement.trim().toLowerCase();
			goal = goal.toLowerCase();
			
			// The only change to incorporate the startPos is in
			// the line below
			int psn = phrase.indexOf(goal, startPos);
			
			// Refinement--make sure the goal isn't part of a
			// word
			while (psn >= 0) {
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0) {
			before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length()) {
			after = phrase.substring(
			  psn + goal.length(),
			  psn + goal.length() + 1);
			}
			
			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
			.compareTo("z") > 0)) // before is not a
			// letter
			&& ((after.compareTo("a") < 0) || (after
			.compareTo("z") > 0))) {
			return psn; 
			}
			
			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);
			}
			return -1;
			}
		/*
		 * A method that searches for rooms in the current room the player is in.
		 * Takes in a string parameter and a hallway object called room. Based on that, 
		 * returns a boolean which determines whether the a door is present in that direction
		 * of the room.
		 * 
		 * @param doordirection A string that tells the method which way to look for doors
		 * @param room A hallway object that represents each room
		 */
		public static boolean findDoor(String doordirection,Hallway room) {
			for(int i = 0;i < room.doorlocations.length; i ++) {
				if(room.doorlocations[i].equals("doordirection")){
					return true;
			 }
			}
			return false;
				
		
		}
		
		/*
		 * The following four methods below returns a boolean that tells the user
		 * whether or not there is a door in a specific direction based on the hallway object
		 * parameter
		 * 
		 * @param room A hallway object that represents each room
		 * @return a boolean using the findDoor method which tells the user if there is a door or not
		 */
		public static boolean findDoorNorth(Hallway room) {
			return findDoor("North",room);
				
		}
		
		public static boolean findDoorSouth(Hallway room) {
			return findDoor("South",room);
				
		}
		
		public static boolean findDoorWest(Hallway room) {
			return findDoor("West",room);
				
		}
		
		public static boolean findDoorEast(Hallway room) {
			return findDoor("East",room);
				
		}
}
