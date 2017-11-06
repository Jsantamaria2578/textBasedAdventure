package game;

import Items.Item;
import rooms.*;
import java.util.Scanner;

import People.Human;
import People.NPC;
import board.Board;

public class GameRunner {

	//Generates a 3x3x3 map while randomizing the coordinates of the player and the coordinates of the boss
    public static void main (String[] args)
    {	
    	 String[] randomRoomDescriptions = {"A small room with a foul smell.","A cold room with many meats.","The room is mostly empty aside from the boxes inside of it.","You see many humans when you enter the room, its packed, luckily they dont see you."};
    	 String[] randomNpcDescripion = {"A young tato,poor thing, hasnt even grown his buds","A sweet potato, hes not one of your kind","Oh gods, its a potato stripped of everything, hes been turned into a fry","You vomit a little,its, its a chip"};
    	 String[] randomNpcDialouge = {"I'm,I'm scared, please save me","They, they took my family","Dead, I want them all dead","nothing","help me"};
    	 int[] playerCords = {(int) (Math.random() * 3), (int) ( Math.random() * 3)};
    	 int[] bossCords = {(int) (Math.random() * 3), (int) ( Math.random() * 3)};
    	 int[] bossCords2 = {(int) (Math.random() * 3), (int) ( Math.random() * 3)};
    	 int[] bossCords3 = {(int) (Math.random() * 3), (int) ( Math.random() * 3)};
    	Hallway[][][] map = new Hallway[3][3][3];
        for(int x = 0; x < map.length; x++) {
        	Hallway[][] floor = map[x];
	        for (int j = 0; j<map.length; j++)
	        {
	        	Hallway[] row = floor[j];
	            for (int i = 0; i<row.length;i++)
	            {	
	            	Item items = new Item("fork",true);
	                String[] doors = gameUtilities.findDoors(j,i);
	                NPC people = new NPC("test1","doesnt matter",items,randomNpcDialouge[(int) (Math.random() * randomNpcDialouge.length)], randomNpcDescripion[(int) (Math.random() * randomNpcDescripion.length)]);
	                		// for reference again public NPC(String name, String location, String item, String dialouge, String description){
	                if(j == playerCords[0]&& i == playerCords[1] && x == 0)
	                	row[i] = new Hallway(people,people.dialougue,people.description, true, items, i, j,doors,true, randomRoomDescriptions[(int) (Math.random() * randomRoomDescriptions.length)], true);
	                // my hallway for reference 	public Hallway(Person[] people, Item[] items, int x, int y,String[]doorLocations, boolean player)
	                if (j == bossCords[0]&& i == bossCords[1] && x == 0)
	                	row[i] = new Hallway(i, j,doors,false, "Its an employee!? He stands in the way of the staircase leading up! What will you do!", false,true);
	                if (j == bossCords2[0]&& i == bossCords2[1] && x == 1)
	                	row[i] = new Hallway(i, j,doors,false, "There he is the man who loaded all those innocent potatoes in the truck, how will you deal with this one?", false,true);
	                if (j == bossCords3[0]&& i == bossCords3[1] && x == 2)
	                	row[i] = new Hallway(i, j,doors,false,"there he is, the man who demanded all the potatoes, you can tell by the money in his hands and the logo, the two yellow arches on his shirt, nows your chance to avenge your bretherin", false,true);
	                else
	                	row[i] = new Hallway(people,people.dialougue,people.description,true, items, i, j,doors,false, randomRoomDescriptions[(int) (Math.random() * randomRoomDescriptions.length)], false);
	            }
	            
	        }
        }
        Board tech = new Board(map);
        gameUtilities gameUtilities = new gameUtilities();
        // Completely ignores player input and forwards the story
        Item playerbag = new Item("not a potato",true);
        boolean gameOn = true;
        Human player1 = new Human("spud","doesntmatter", playerbag);
        Scanner in = new Scanner(System.in);
        System.out.println("Hello there, welcome to the start of your journey! Are you a boy or a girl?");
        in.next();
        System.out.println("I see, your a potato, thats perfect you'll fit right in to this story,Whats your name?");
        in.next();
        System.out.println("Spud, thats an oddly convinient name for this story.");
        System.out.println("Now spud, are you ready to start your journey?.");
        in.next();
        System.out.println("Great lets get started!");
        System.out.println("Spud, thats an oddly convinient name for this story.");
        System.out.println("You are a potato. But not any normal potato for you see you were born with special powers");
        System.out.println("You were born with the powers of sight, the common sense of a human, rolling, and opposable buds!");
        System.out.println("You see that many potatos have been being abducted, you notice that they are being put in");
        System.out.println("boxes being loaded into a mysterious truck, you've never seen the logo before.");
        System.out.println("Will you follow the truck, or will you sneak aboard it?");
        String FirstDecision = "Will you follow the truck, or will you sneak aboard it?";
        String response1 = in.next();
        if(gameUtilities.findKeyword(response1,"sneak",0) != -1 || gameUtilities.findKeyword(response1,"board",0) != -1 ) {
        	System.out.println("You try to hop aboard the truck, you realize you dont have any real legs, luckily one of the");
        	System.out.println("the people loading the truck think you fell and throw you in there.");
        	System.out.println("Your fellow potatos sit in silence with you, all fearing the unknown");
        	System.out.println("Eventually the truck opens up revealing a harsh light,you being thrown in so carelessly");
        	System.out.println("You roll away and witness the people from afar");
        }
        else if(gameUtilities.findKeyword(response1,"follow",0) != -1) {
        	System.out.println("You decided to follow the truck? Good luck there spud.");
        	System.out.println("2 hours later");
        	System.out.println("Thanks to the heavy traffic you manage to keep up with the truck.");
        	System.out.println("You watch the same person who loaded the truck from afar");
        }
        else {
        	System.out.println("Im not sure what you said but the truck left, better start rolling now");
        	System.out.println("2 hours later");
        	System.out.println("Thanks to the heavy traffic you manage to keep up with the truck.");
        	System.out.println("You watch the same person who loaded the truck from afar");
        }
        System.out.println("You cant see clearly but they are taking it into the back of some building");
    	System.out.println("The building smells of... OH GOD, potatos, being burned and tortured");
    	System.out.println("Out of the corner of your eye, you spot your brother and rush into the building");
    	System.out.println("You cant find your brother and run around everywhere, your lost, but not before");
    	System.out.println("you realize, you have no brother.");
    	System.out.println("It might have not been your brother, but it could have been someone elses brother and you must save them.");
    	int posx = playerCords[0];
 	    int posy = playerCords[1];
 	    int posz = 0;
    	while(gameOn)
        {
         //   map[0][0].addOccupant(player1)
            tech.printMap();
            System.out.println(map[posz][posx][posy].roomtext);
            map[posz][posx][posy].togglePlayer();
            map[posz][posx][posy].toggleExplore();
            if(map[posz][posx][posy].boss) {
            	String decision = in.next();
            	if(decision.equals("nothing")) {
            		System.out.println("You stand still thinking what will you do to him but while you think the employee walks away, you advance to the next floor");
            		posz++;
            		map[posz][posx][posy].togglePlayer();
            	}
            	else if(decision.equals("fight") || decision.equals("attack")) {
            		System.out.println("You rolled towards the employee aggresivly. Not even looking the employee kicks you away. You land in front of the staircase stunned from the kick. The employee walks forward, again not looking, and attempts to squash you only to slip and fall down the stiars. Your work here is done");
            		posz++;
            		map[posz][posx][posy].togglePlayer();
            	}
            	else {
            		System.out.println("I dont know what you said but it appears that didnt matter as you sneak by the employee and up the stairs, conserving your energy for the real fight");
            		posz++;
            		map[posz][posx][posy].togglePlayer();
            	}
            }
            else if(map[posz][posx][posy].boss) {	
            	String decision = in.next();
            	if(decision.equals("nothing")) {
            		System.out.println("The man falls for your trap and picks you up, now that you have him in the palms of your buds what will you do?");
            		String decision2 = in.next();
            		if(decision2.equals("nothing")) {
                		System.out.println("He is examining you so closely he doesnt notice he has one more step, trips and falls, hes not dead but he will remember this pain!");
                		posz++;
                		map[posz][posx][posy].togglePlayer();
                	}
            		else if(decision2.equals("attack")) {
                		System.out.println("In struggling out of the mans grip you break free and drop, he attempts to capture only to fall over, he lays down in defeat, unconcious, you spare him knowing that this battle will harm his pride and will be crueler than death");
                		posz++;
                		map[posz][posx][posy].togglePlayer();
                	}
            		else {
            			System.out.println("That plan is so ingenious i didnt understand! However, while you were telling me it the man threw you in the trash and walked away, somehow you managed to climb out, you'll enact your revenge on him another day");
                		posz++;
                		map[posz][posx][posy].togglePlayer();
            		}
            			
            	}
            	else if(decision.equals("fight") || decision.equals("attack")) {
            		System.out.println("You roll along the floor accidentally bursting a kethup packet. The man cleverly dodges the packet but slips on the ketchup! He stumbles into a window and falls. Another sould claimed in vengance!");
            		posz++;
            		map[posz][posx][posy].togglePlayer();
            	}
            	else {
            		System.out.println("I couldnt make out your ingenous plan, however it appears the man has picked you up and threw you behind him to the next flight of stairs, all according to plan!");
            		posz++;
            		map[posz][posx][posy].togglePlayer();
            	}
            }
            else if(map[posz][posx][posy].boss) {
            	String decision = in.next();
            	if(decision.equals("nothing")) {
            		System.out.println("You stop, thinking to yourself, this man also has a family, kids, a wive, he was just trying to feed himself, he no not what he did. He took your families-");
            		System.out.println("He, he picks you up, oh god, you hear him mumbling to himself, he opens his mouth and eats your heart in one chomp. Your taste was so bad he stopped obtaining");
            		System.out.println("potatoes from that farm altogether, your death saved millions!");
            		gameOn = false;
            	}
            	else if(decision.equals("fight") || decision.equals("attack")) {
            		System.out.println("You roll towards him, empowered by the souls of all the potatos lost. Your rage blinds you and you accidentally bump into a plant, which bumps into a shelf into two other shelves that blocked the door and trapped the boss underneath");
            		System.out.println("You and him are trapped, as you grow rotten you watch as noone helps this boss, he killed your family to feed others, so he will die knowing what hunger, what sadness feels like. You have avenged your bretherin");
            		gameOn = false;
            	}
            	else {
            		System.out.println("Hmm, whatever you just said, i didnt hear it, but judging by your tone it sounded very prfound, however your just gonna walk away?");
            		System.out.println("Oh I understand, what occured wasnt an good/evil, it was a conflict of sacrafices, this man must do this to survive, to protect his family, your family is but a grain of sand in his eyes. To realize that, you truly are a wise potato");
            	gameOn = false;
            	}
            }
            else {
	            String direction = in.next();
	            if(direction.equals("west") && posy - 1 != -1) {
	    			posy = posy - 1;
	    		}
	    		else if(direction.equals("east") && posy + 1 != 3) {
	    			posy = posy + 1;
	    		}
	    		else if(direction.equals("north") && posx - 1 != -1) {
	    			posx = posx - 1;
	    		}
	    		else if(direction.equals("south") && posx + 1 != 3) {
	    			posx = posx + 1;
	    		}
	    		else 
	    			System.out.println("what did you say?" );
	    		map[posz][posx][posy].togglePlayer();
	    		
	            
            }
            
            
            //gameOn = false;

        }
		in.close();
		}

}

