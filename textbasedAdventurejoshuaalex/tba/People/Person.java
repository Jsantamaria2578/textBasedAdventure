package People;

import Items.Item;

public abstract class Person {
	private String location;
	private Item item;
	
	Person(String name, String location, Item item){
		this.location = location;
		this.item = item;
	}
	
	
}
 