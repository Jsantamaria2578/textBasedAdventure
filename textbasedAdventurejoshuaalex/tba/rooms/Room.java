package rooms;

import Items.Item;

import java.util.Arrays;

import People.NPC;

public abstract class Room {

    public static String roomtext;
	private boolean[] doors;
    private NPC occupants;
    private Item items;
    public boolean explored;
    private int x, y;

    public Room (NPC occupants, Item items, int x, int y)
    {
    	this.x = x;
    	this.y = y;
        this.doors = doors;
        this.occupants = occupants;
        this.items = items;
        this.explored = false;
    }

    public  NPC getOccupants() {
        return occupants;
    }


    public boolean[] getDoors()
    {
    	return doors;
    }
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    public abstract void print();
    public abstract String generateAllDirection();
    public static String generateOneDirection(String door) {
    	return ""; /*might not need this after all"*/
}





}
