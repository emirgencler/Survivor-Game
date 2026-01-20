/*
 * BattleLoc
 * ---------
 * Base class for all combat locations.
 *
 * Handles:
 * - Turn-based combat logic
 * - Damage calculation using character stats and inventory bonuses
 * - Dodge/avoid mechanics
 * - Reward distribution after combat
 */

package SurvivorGame;

import java.util.Random;
import java.util.Scanner;


public class BattleLoc extends Location{
	Scanner scanner= new Scanner(System.in);
	Obstacle obstacle;
	Random random = new Random();
	
	
	private int enemyDam;
	private boolean hiddenEnemy;
	private double totalHealth,totalDamage,enemyHealth,money;
	private int woodOrStoneOrSand,food,water;
	
	Inventory inv = new Inventory();



	
	public BattleLoc(Character character ,String name,Obstacle obstacle) {
		super(character);
		this.obstacle=obstacle;
		this.name=name;
		this.enemyHealth=obstacle.getHealth();
		
		double weaponBonus = character.getInventory().getMyDamage();
		double armorBonus  = character.getInventory().getMyHealth();

		this.totalDamage = character.getDamagePoint() + weaponBonus;
		this.totalHealth = character.getHealth() + armorBonus;

		
		
	
	}
	
	public boolean getLocation() {
	    int ans = 0;
	    
	    do {
	        System.out.println("Choose a difficulty level");
	        System.out.println("-----");
	        System.out.println("1.Easy");
	        System.out.println("2.Medium");
	        System.out.println("3.Hard");
	        System.out.println("4.Impossible");

	        int difficulty = scanner.nextInt();
	        while (difficulty != 1 && difficulty != 2 && difficulty != 3 && difficulty != 4) {
	            System.out.println("Please enter a valid number");
	            difficulty = scanner.nextInt();
	        }

	        combat(difficulty);

	        if (totalHealth <= 0) {
	            System.out.println("GAME OVER!");
	            System.out.println("YOU LOST");
	            character.setHealth(0);
	            return false; 
	        }
	        double armorBonus = character.getInventory().getMyHealth();
	        character.setHealth(Math.max(0, totalHealth - armorBonus));

	      
	        System.out.println("Congrats! You survived!");
	        System.out.println("Your Awards");
	        System.out.println("----");
	        System.out.println(money + " money");
	        System.out.println(food + " food");
	        System.out.println(water + " water");

	        
	        if ("Vampire".equals(obstacle.getName())) {
	            System.out.println("Cobble Stone: " + woodOrStoneOrSand);
	        } else if ("Zombie".equals(obstacle.getName())) {
	            System.out.println("Wood: " + woodOrStoneOrSand);
	        } else if ("Big Slime".equals(obstacle.getName())) {
	            System.out.println("Sand: " + woodOrStoneOrSand);
	        }

	       
	        character.setMoney(character.getMoney() + money);
	        character.getInventory().setFood(character.getInventory().getFood() + food);
	        character.getInventory().setWater(character.getInventory().getWater() + water);

	        if ("Vampire".equals(obstacle.getName())) {
	            character.getInventory().setCobbleStone(
	                    character.getInventory().getCobbleStone() + woodOrStoneOrSand
	            );
	        } else if ("Zombie".equals(obstacle.getName())) {
	            character.getInventory().setWood(
	                    character.getInventory().getWood() + woodOrStoneOrSand
	            );
	        } else if ("Big Slime".equals(obstacle.getName())) {
	            character.getInventory().setSand(
	                    character.getInventory().getSand() + woodOrStoneOrSand
	            );
	        }

	        System.out.println("Would you like to fight again?");
	        System.out.println("1.Yes");
	        System.out.println("2.No");
	        ans = scanner.nextInt();

	       
	        armorBonus = character.getInventory().getMyHealth();
	        this.totalHealth = character.getHealth() + armorBonus;


	    } while (ans == 1);

	    System.out.println();
	    System.out.println("Going back to the Safe House..");

	  
	    new SafeHouse(this.character).getLocation();

	    return true; 
	}

		
			
	

		public void combat(int diffuculty) {
			
			
			if(diffuculty==1) {
				System.out.println("LEVEL: EASY");
				System.out.println("There are " + obstacle.getName() + "'s out there.. BE CAREFUL!");
				System.out.println();
				
				battle(3);}
				
			
			else if(diffuculty==2){
				System.out.println("LEVEL:MEDIUM");
				System.out.println("There are " + obstacle.getName() + "'s out there.. BE CAREFUL!");
				System.out.println();
				battle(5);
					}
				
			
			else if(diffuculty==3) {
				System.out.println("LEVEL: HARD");
				System.out.println("There are " + obstacle.getName() + "'s out there.. BE CAREFUL!");
				System.out.println();
				battle(7);
								
							}
						
					
				
			else if(diffuculty==4) {
				System.out.println("LEVEL: IMPOSSIBLE!!!");
				System.out.println("There are " + obstacle.getName() + "'s out there.. BE CAREFUL!");
				System.out.println();
				battle(10);
					}
				
					
				
			}
		
		
		

		
		public void hiddenEnemy() {
			hiddenEnemy=random.nextBoolean();
			
			if(hiddenEnemy==true) {
				System.out.println();
				System.out.println(obstacle.getName() + " attacked you..");
				System.out.println("You didn't see that coming..");
				System.out.println("---");
				totalHealth=totalHealth-obstacle.getDamage();
				System.out.println("Your current health: " + Math.max(0, totalHealth));

			}
		}
		public void battle(int diff) {
		    for (int i = 0; i < diff; i++) {

		      
		        enemyHealth = obstacle.getHealth();

		        hiddenEnemy();
		        enemyDam = random.nextInt(9);

		        // Combat Loop:
		        // Continues until either the player or the enemy is defeated
		        while (enemyHealth > 0 && totalHealth > 0) {

		            System.out.println();
		            System.out.println("Attack the enemy!");
		            System.out.println("--");
		            System.out.println("Great shot! You attacked the enemy");
		            enemyHealth = enemyHealth - totalDamage;
		            System.out.println(obstacle.getName() + "'s health: " + Math.max(0, enemyHealth));

		            
		            if (enemyHealth <= 0) {

		                money = money + obstacle.getAward();

		                switch (obstacle.getName()) {
		                    case "Vampire":
		                        Vampire vampire = new Vampire();
		                        food = food + vampire.getFood();
		                        water = water + vampire.getWater();
		                        woodOrStoneOrSand = woodOrStoneOrSand + vampire.getStone();
		                        System.out.println("GOOD JOB!");
		                        System.out.println("YOU KILLED THE VAMPIRE");
		                        break;

		                    case "Zombie":
		                        Zombie zombie = new Zombie();
		                        food = food + zombie.getFood();
		                        water = water + zombie.getWater();
		                        woodOrStoneOrSand = woodOrStoneOrSand + zombie.getWood();
		                        System.out.println("GOOD JOB!");
		                        System.out.println("YOU KILLED THE ZOMBIE");
		                        break;

		                    case "Big Slime":
		                        BigSlime b = new BigSlime();
		                        food = food + b.getFood();
		                        water = water + b.getWater();
		                        woodOrStoneOrSand = woodOrStoneOrSand + b.getSand();
		                        System.out.println("GOOD JOB");
		                        System.out.println("YOU KILLED THE BIG SLIME");
		                        break;
		                }

		                break; 
		            }

		            // Dodge Mechanic:
		            // Enemy attack may be avoided based on random chance
		            if (enemyDam == 0) {
		                System.out.println("GOOD MOVE! ");
		                System.out.println("YOU AVOID THE  " + obstacle.getName() + "'s attack without a scratch");
		                System.out.println("---");
		                System.out.println("Your current health: " + Math.max(0, totalHealth));
		            } else {
		                System.out.println("WATCH YOUR BACK!");
		                System.out.println(obstacle.getName() + " ATTACKED YOU!");
		                totalHealth = totalHealth - obstacle.getDamage();
		                System.out.println("---");
		                System.out.println("Your current health: " + Math.max(0, totalHealth));
		                System.out.println();
		            }
		        }

		        
		        if (totalHealth <= 0) {
		            System.out.println("YOUR CURRENT HEALTH: 0");
		            System.out.println("YOU COULDN'T SURVIVE..");
		            break;
		        }
		    }
		}

		}
		
	
		

