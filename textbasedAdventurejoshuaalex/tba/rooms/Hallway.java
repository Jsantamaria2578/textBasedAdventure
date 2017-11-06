package rooms;

import People.NPC;
import Items.Item;

public class Hallway extends Room {

    public String[] doorlocations;
    private boolean player;
    public String description;
    private int items;
    private boolean itemExist;
    private boolean explored;
    public String roomtext;
    public boolean boss;
    private NPC people;
    private String dialougue;
    private String persondescription;

	public Hallway(NPC people,String dialougue, String persondescription,boolean itemExist, Item items, int x, int y,String[]doorLocations, boolean player,String description,boolean explored)
    {
        super(people, items, x, y);
        this.doorlocations = doorLocations;
        this.player = player;
        this.description = description;
        this.itemExist = itemExist;
        this.explored = explored;
        this.dialougue = dialougue;
        this.persondescription = persondescription;
        if(this.itemExist)
    		this.roomtext = this.description + " " + this.generateAllDirection() + "Theres an " + this.persondescription + ". they say " + this.dialougue + "." + " You see an something in the corner of the room";
    	else
    		this.roomtext = this.description + " " + this.generateAllDirection();
    }
	
	public Hallway(int x, int y,String[]doorLocations, boolean player,String description,boolean explored, boolean boss)
    {
        super(null, null, x, y);
        this.doorlocations = doorLocations;
        this.player = player;
        this.description = description;
        this.itemExist = itemExist;
        this.explored = explored;
        if(this.itemExist)
    		this.roomtext = this.description + " " + this.generateAllDirection() + "Theres an " + this.persondescription + ". they say " + this.dialougue + "." + "  You see an something in the corner of the room";
    	else
    		this.roomtext = this.description + " " + this.generateAllDirection();
        this.boss = boss;
    }
	/*
	 * For each room in the 3D array, it continuously reprints the map based on the room object's fields.
	 * Based on the boolean fields of the room objects, the method prints different versions to let the 
	 * player know where they have explored and where they are currently located.
	 */
    public void print()
    {
        if (this.player)
        {
            System.out.print("[ P ]");
        }
        else if (this.explored)
        {
            System.out.print("[ H ]");
        }
        else
        {
            System.out.print("[   ]");
        }

    }
    /*
     * Toggles the room object's field player from true to false and vice versa so that the print method
     * can properly print out the map.
     */
    public void togglePlayer() {
    	this.player = !this.player;
    }
    /*
     * Toggles the room object's field explored from true to false that the print method
     * can properly print out the map.
     */
    public void toggleExplore() {
    	this.explored = true;
    }
    public String toString()
    {
    	boolean[] doors = this.getDoors();
    	String response = "This room is a hallway. It has doors to the ";
    	if (doors[0])
    	{
    		response += "N";
    	}
    	
    	if(doors[1]) {
    		response += " and E";
    	}
    	
    	if (doors[2]) {
    		response += " and S";
    	}
    	
    	if (doors[3]) {
    		response += " and W";
    	}
    	
    	return response;
    }
    /*
     * A general method that takes into consideration the the length of the doorlocations array. 
     * Based on the length, it tells the player where doors are located.
     * 
     * @return String that tells the user where doors are located in the current room. 
     */
    public String generateAllDirection() {
    	if(doorlocations.length == 1) {
    		return "An entrance can be seen to the" + doorlocations[0];
    	}
    	if(doorlocations.length == 2)
    		return "Theres an entrance to the " + doorlocations[0] + " and " + doorlocations[1] + ".";
    	if(doorlocations.length == 3)
    		return "You see many entrances, one to the " + doorlocations[0] + ", the " + doorlocations[1] + ", and " + doorlocations[2] + ".";
    	if(doorlocations.length == 4)
    		return "You see many entrances, one to the " + doorlocations[0] + ", the " + doorlocations[1] + ", the " + doorlocations[2] + ", and " + doorlocations[3] + ".";
    	return null;
    	} 
}
    	

