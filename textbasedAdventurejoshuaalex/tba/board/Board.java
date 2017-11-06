package board;

import rooms.Hallway;
import rooms.Room;

public class Board {


    private Hallway[][][] schoolMap;



    public Board(Hallway[][][] schoolMap)
    {
        this.schoolMap = schoolMap;
    }
    /*
     * Prints out the map in a readable format using a for loop inside a for loop.
     * The outside loop for the floor, and the inside loop for the rooms in the floor.
     */
    public void printMap()
    {

    	for(Hallway[][] floor:schoolMap) {
    		System.out.println("floorx");
    		for(Hallway[] row : floor)
    		{
    			for (Hallway room : row)
	            {
	                room.print();
	            }
	            System.out.println();
	        }
    		System.out.println();
	    }
    }
    public Hallway[][][] getSchoolMap() {
        return schoolMap;
    }

    public void setSchoolMap(Hallway[][][] schoolMap) {
        this.schoolMap = schoolMap;
    }

    
}
