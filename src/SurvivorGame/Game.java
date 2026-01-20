package SurvivorGame;

import java.util.Scanner;

public class Game {
	Character character = new Character();
	Location location;
	Scanner scanner = new Scanner(System.in);
	boolean firstStart=true;
	
	
    

	
	public Game(String Pname) {
	    
		}
		
	
	
	
	public void start() {

	    while (true) {
	        character.characterInfo(character);
	        System.out.println();
	        System.out.println("WELCOME! ");
	        System.out.println();
	        System.out.println("Choose a place to go");
	        System.out.println("1.Safe House");
	        System.out.println("2.Cave");
	        System.out.println("3.Forest");
	        System.out.println("4.Beach");
	        System.out.println("5.Tool Store");
	        System.out.println("0.Exit");
	        System.out.println("Enter your choice");

	        int choice = scanner.nextInt();

	        if (choice == 0) {
	            System.out.println("Bye!");
	            break;
	        }

	        switch(choice) {
	            case 1: location = new SafeHouse(character); break;
	            case 2: location = new Cave(character); break;
	            case 3: location = new Forest(character); break;
	            case 4: location = new Beach(character); break;
	            case 5: location = new ToolStore(character); break;
	            default:
	                System.out.println("Please enter a valid number!");
	                continue;
	        }

	        boolean result = location.getLocation();
	        if (!result) {
	            System.out.println("Going back to the safe house...");
	            new SafeHouse(this.character).getLocation();
	            continue; 
	        }

	    }
	}

	
	 public void createCha() {
		 character.createACharacter();	 }
	 
	
		
		
		

}
