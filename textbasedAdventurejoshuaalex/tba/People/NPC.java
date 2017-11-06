package People;

import Items.Item;

public class NPC extends Person {
	public String dialougue;   
	public String description;
	
	public NPC(String name, String location, Item item, String dialouge, String description){
		super(name,location,item);
		this.dialougue = dialouge;
		this.description = description;
		
	}
	
}
