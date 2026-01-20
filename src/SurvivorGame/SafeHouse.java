/*
 * SafeHouse
 * ----------
 * Non-combat safe zone for the player.
 *
 * Responsibilities:
 * - Allows short rest using food and water (limited healing, capped by max HP)
 * - Shelter can be upgraded using wood, cobble stone and glass
 * - Win condition is triggered when shelter reaches level 4
 * - After winning, player may continue in Endless Mode or exit the game
 */

package SurvivorGame;


public class SafeHouse extends NormalLoc {
	private static final int WIN_LEVEL = 4;
	private static final int MAX_LEVEL = 8;

	protected SafeHouse(Character character) {
		super(character);
	
	}

	
	boolean getLocation() {
	    while (true) {
	        System.out.println("\n --SAFE HOUSE--");
	        System.out.println("HP: " + character.getHealth() + " / " + character.getFirstHealth());
	        System.out.println("Shelter Level: " + character.getInventory().getShelterLevel());

	        System.out.println("Food: " + character.getInventory().getFood()
	                + " | Water: " + character.getInventory().getWater()
	                + " | Wood: " + character.getInventory().getWood()
	                + " | Cobble: " + character.getInventory().getCobbleStone()
	                + " | Glass: " + character.getInventory().getGlass());



	        int lvl = character.getInventory().getShelterLevel();
	        int restHeal = 15 + (lvl - 1) * 10; 
	        
	     // Short Rest:
	     // - Uses food and water
	     // - Healing is limited and cannot exceed max HP
	     // - Designed to prevent infinite full-heal abuse


	        System.out.println("\n1) Short Rest (cost: 1 Food + 1 Water) -> +" + restHeal + " HP (max " + character.getFirstHealth() + ")");
	        System.out.println("2) Upgrade Shelter (uses Wood + Cobble + Glass)");
	        System.out.println("3) Leave (Back to menu)");


	        int c = new java.util.Scanner(System.in).nextInt();

	        if (c == 1) {
	            if (character.getInventory().getFood() >= 1 && character.getInventory().getWater() >= 1) {
	                character.getInventory().setFood(character.getInventory().getFood() - 1);
	                character.getInventory().setWater(character.getInventory().getWater() - 1);
	                double newHp = Math.min(character.getFirstHealth(), character.getHealth() + restHeal);
	                character.setHealth(newHp);
	                System.out.println("You rested. +" + restHeal + " HP!");

	            } else {
	                System.out.println("Not enough Food/Water!");
	            }
	        } 
	     // Shelter Upgrade:
	     // - Consumes wood, cobble stone and glass
	     // - Shelter level increases progressively
	     // - Higher levels require more resources

	        else if (c == 2) {
	        	int level = character.getInventory().getShelterLevel();
	        	if (level >= MAX_LEVEL) {
	        	    System.out.println("Shelter is already at MAX level (" + MAX_LEVEL + ")!");
	        	    continue;
	        	}

	        	// Upgrade costs by level (1->2, 2->3, ..., 7->8)
	        	int[] woodCost   = { 5,  8, 12, 17, 23, 30, 38 };
	        	int[] cobbleCost = { 3,  5,  8, 12, 17, 23, 30 };
	        	int[] glassCost  = { 2,  4,  6,  9, 13, 18, 24 };

	        	int needWood   = woodCost[level - 1];
	        	int needCobble = cobbleCost[level - 1];
	        	int needGlass  = glassCost[level - 1];


	        	System.out.println("Upgrade cost -> Wood: " + needWood + ", Cobble: " + needCobble + ", Glass: " + needGlass);

	        	if (character.getInventory().getWood() >= needWood
	        	        && character.getInventory().getCobbleStone() >= needCobble
	        	        && character.getInventory().getGlass() >= needGlass) {

	        	    character.getInventory().setWood(character.getInventory().getWood() - needWood);
	        	    character.getInventory().setCobbleStone(character.getInventory().getCobbleStone() - needCobble);
	        	    character.getInventory().setGlass(character.getInventory().getGlass() - needGlass);

	        	    character.getInventory().setShelterLevel(level + 1);
	        	    System.out.println("Shelter upgraded to Level " + character.getInventory().getShelterLevel() + "!");
	        	    
	        	 // WIN CONDITION:
	        	 // Triggered once when shelter reaches level 4.
	        	 // Player can choose to exit the game or continue in Endless Mode.

	        	    if (character.getInventory().getShelterLevel() == WIN_LEVEL) {

	        	        System.out.println("\n========================");
	        	        System.out.println("CONGRATULATIONS!");
	        	        System.out.println("Your Shelter reached Level " + WIN_LEVEL + "!");
	        	        System.out.println("========================\n");

	        	        System.out.println("1) Keep playing (Endless Mode)");
	        	        System.out.println("2) Exit game");

	        	        int choice = new java.util.Scanner(System.in).nextInt();
	        	        while (choice != 1 && choice != 2) {
	        	            System.out.println("Enter a valid choice!");
	        	            choice = new java.util.Scanner(System.in).nextInt();
	        	        }

	        	        if (choice == 2) {
	        	            System.out.println("Thanks for playing!");
	        	            return false;
	        	        } else {
	        	            System.out.println("Endless mode activated. Keep surviving!");
	        	            
	        	        }
	        	    }

	        	} else {
	        	    System.out.println("Not enough materials to upgrade!");
	        	}

	        } else if (c == 3) {
	            System.out.println("Leaving Safe House...");
	            return true; 
	        } else {
	            System.out.println("Invalid choice!");
	        }
	    }
	}



}
