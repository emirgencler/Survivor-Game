/*
 * ToolStore
 * ---------
 * Handles all in-game purchases and productions.
 *
 * Includes:
 * - Weapon and armor purchases
 * - Resource stores (food, water, wood, cobble stone)
 * - Glass production using sand
 *
 * All equipment bonuses are stored in Inventory
 * and applied during combat via BattleLoc.
 */

package SurvivorGame;

import java.util.Scanner;

public class ToolStore extends NormalLoc {
	private boolean knife;
	private boolean sword;
	private boolean excalibur;
	private boolean leatherArmor;
	private boolean woodenArmor;
	private boolean ironArmor;
	private int armor;
	private int weaponDamage;
	private Character character;

	
	ToolStore(Character character) {
		super(character);
		this.character = character;
		this.knife=false;
		this.sword=false;
		this.excalibur=false;
		this.ironArmor=false;
		this.leatherArmor=false;
		this.woodenArmor=false;
		this.armor=0;
		this.weaponDamage=0;
		
		
	}


	public int getArmor() {
		return armor;
	}



	public void setArmor(int armor) {
		this.armor = armor;
	}



	public int getWeaponDamage() {
		return weaponDamage;
	}



	public void setWeaponDamage(int weaponDamage) {
		this.weaponDamage = weaponDamage;
	}



	public boolean isKnife() {
		return knife;
	}
	public void setKnife(boolean knife) {
		this.knife=knife;
	}

	public boolean isSword() {
		return sword;
	}
	public void setSword(boolean sword) {
		this.sword = sword;
	}
	public boolean isExcalibur() {
		return excalibur;
	}
	public void setExcalibur(boolean excalibur) {
		this.excalibur = excalibur;
	}
	public boolean isLeatherArmor() {
		return leatherArmor;
	}
	public void setLeatherArmor(boolean leatherArmor) {
		this.leatherArmor = leatherArmor;
	}
	public boolean isWoodenArmor() {
		return woodenArmor;
	}
	public void setWoodenArmor(boolean woodenArmor) {
		this.woodenArmor = woodenArmor;
	}
	public boolean isIronArmor() {
		return ironArmor;
	}
	public void setIronArmor(boolean ironArmor) {
		this.ironArmor = ironArmor;
	}



	
	
	
	Scanner scanner=new Scanner(System.in);
	
	boolean getLocation() {

	    while (true) {
	        System.out.println("Welcome to the store");
	        System.out.println("Enter the choice");
	        System.out.println("1.Normal Store");
	        System.out.println("2.Tool Store");
	        System.out.println("3.Exit (Back to menu)");

	        int choice1 = scanner.nextInt();
	        while (choice1 != 1 && choice1 != 2 && choice1 != 3) {
	            System.out.println("Enter a valid number");
	            choice1 = scanner.nextInt();
	        }

	        if (choice1 == 3) {
	            System.out.println("Leaving the store...");
	            return true; 
	        }

	        choiceSystem1(choice1);
	       
	    }
	}

	public void choiceSystem1(int choice) {
		
		Inventory inv1 = character.getInventory();

		if(choice ==1) {
			System.out.println("Welcome to the Normal Store");
			System.out.println("--------");
			System.out.println("Enter the choice ");
			System.out.println("1.Wood Shelf");
			System.out.println("2.Cobble Bar");
			System.out.println("3.Glass Production");
			System.out.println("4.Water Temple");
			System.out.println("5.Food Store");
			int number =scanner.nextInt();
			switch(number) {
			
			// Wood Shelf:
			// Buy/Sell wood.
			// Wood is mainly used for shelter upgrades in SafeHouse.
			case 1 : System.out.println("Welcome to the Wood Shelf");
			System.out.println("1.Buy");
			System.out.println("2.Sell");
			System.out.println("Enter your choice");
			int choice1 = scanner.nextInt();
			while(choice1 !=1 && choice1 !=2) {
				System.out.println("Enter a valid number");
				choice1= scanner.nextInt();
			}
			if(choice1==1) {
				if(character.getMoney()>=5) {
				
				System.out.println("You've just bought a wood");
				inv1.setWood(inv1.getWood()+1);
				character.setMoney(character.getMoney()-5);;
				System.out.println("Your current money: " + character.getMoney());
				System.out.println("Your current wood in your inventory: " + inv1.getWood());
				}
				else { System.out.println("Not enough money");
				System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			else if (choice1==2) {
				
				if(inv1.getWood()>0) {
				System.out.println("You've just sell a wood");
				inv1.setWood(inv1.getWood()-1);
				character.setMoney(character.getMoney()+5);;}
				else {System.out.println("Not enough wood to sell");
				System.out.println("Your current wood in your inventory: " + inv1.getWood());
				}
			}
			
			System.out.println();
			System.out.println("To continue shopping please press 1");
			System.out.println("To finish shopping please press 2");
			int press= scanner.nextInt();
			while(press!=1 && press != 2) {
				System.out.println("Enter a valid number..");
				press=scanner.nextInt();
			}
			if(press==1) {
				System.out.println("Continue to shopping");
				System.out.println();
				return;
			}
			else if(press==2) {
			System.out.println("Going back to menu..");
			System.out.println();
			return;
			}
			break;
			
			// Cobble Bar:
			// Buy/Sell cobble stone.
			// Cobble stone is used together with wood and glass for shelter upgrades.
			case 2 : System.out.println("Welcome to the Cobble Bar ");
			System.out.println("1.Buy");
			System.out.println("2.Sell");
			System.out.println("Enter your choice");
			int choice2 = scanner.nextInt();
			while(choice2!=1 && choice2 !=2) {
				System.out.println("Enter a valid number");
				choice2= scanner.nextInt();
			}
			if(choice2==1) {
				
				if(character.getMoney()>=10) {
				System.out.println("You've just bought a cobble stone");
				inv1.setCobbleStone(inv1.getCobbleStone()+1);
				character.setMoney(character.getMoney()-10);
				System.out.println("Your current money: " + character.getMoney());
				System.out.println("Your current cobble stone in your inventory: " + inv1.getCobbleStone());
				}
				else {System.out.println("Not enough money");
				System.out.println("Your current money: " + character.getMoney());
				}
			}
			else if (choice2==2) {
				if(inv1.getCobbleStone()>0) {
				System.out.println("You've just sell a cobble stone");
				inv1.setCobbleStone(inv1.getCobbleStone()-1);
				character.setMoney(character.getMoney()+10);;}
				else {System.out.println("Not enough cobble stone to sell");
				System.out.println("Your current cobble stone in yur inventory: " + inv1.getCobbleStone());
				}
			}
			System.out.println();
			System.out.println("To continue shopping please press 1");
			System.out.println("To finish shopping please press 2");
			press= scanner.nextInt();
			while(press!=1 && press != 2) {
				System.out.println("Enter a valid number..");
				press=scanner.nextInt();
			}
			if(press==1) {
				System.out.println("Continue to shopping");
				System.out.println();
				return;
			}
			else if(press==2) {
			System.out.println("Going back to menu..");
			System.out.println();
			return;
			}
			
			break;
			
			// Glass Production:
			// - Converts sand into glass (2 sand -> 1 glass)
			// - Used mainly for shelter upgrades

			case 3:
			    System.out.println("Glass Production ");
			    System.out.println("For 1 glass production, you need 2 sands");
			    System.out.println("Enter a production number");
			    int product = scanner.nextInt();

			    if (product <= 0) {
			        System.out.println("Invalid production number!");
			        break;
			    }

			    int neededSand = product * 2;

			    if (inv1.getSand() >= neededSand) {
			        inv1.setSand(inv1.getSand() - neededSand);
			        inv1.setGlass(inv1.getGlass() + product);

			        System.out.println("Sands turned to the glasses");
			        System.out.println("Your current sand in your inventory: " + inv1.getSand());
			        System.out.println("Your current glass in your inventory: " + inv1.getGlass());
			    } else {
			        System.out.println("You don't have enough sands..");
			        System.out.println("Needed: " + neededSand + " | You have: " + inv1.getSand());
			        System.out.println("Your current glass in your inventory: " + inv1.getGlass());
			    }

			    System.out.println();
			    System.out.println("To continue shopping please press 1");
			    System.out.println("To finish shopping please press 2");
			    press = scanner.nextInt();
			    while (press != 1 && press != 2) {
			        System.out.println("Enter a valid number..");
			        press = scanner.nextInt();
			    }
			    if (press == 1) {
			        System.out.println("Continue to shopping");
			        System.out.println();
			        return;
			    } else {
			        System.out.println("Going back to menu..");
			        System.out.println();
			        return;
			    }

			 // Water Temple:
			 // Buy water.
			 // Water is used with food for Short Rest in SafeHouse.
			case 4 : System.out.println("Welcome to the Water Temple ");
			if(character.getMoney()>=1) {
			System.out.println("You've just bought a water");
			inv1.setWater(inv1.getWater()+1);
			character.setMoney(character.getMoney()-1);
			System.out.println("Your current money: " + character.getMoney());
			System.out.println("Your current water in your inventory: " + inv1.getWater());
			}
			else {System.out.println("Not enough money");}
			
			System.out.println();
			System.out.println("To continue shopping please press 1");
			System.out.println("To finish shopping please press 2");
			press= scanner.nextInt();
			while(press!=1 && press != 2) {
				System.out.println("Enter a valid number..");
				press=scanner.nextInt();
			}
			if(press==1) {
				System.out.println("Continue to shopping");
				System.out.println();
				return;
			}
			else if(press==2) {
			System.out.println("Going back to menu..");
			System.out.println();
			return;
			}
			break;
			
			// Food Store:
			// Buy food.
			// Food is used with water for Short Rest in SafeHouse.
			case 5 : System.out.println("Welcome to the Food Store ");
			if(character.getMoney()>=2) {
			System.out.println("You've just bought a food");
			inv1.setFood(inv1.getFood()+1);
			character.setMoney(character.getMoney()-2);
			System.out.println("Your current money: " + character.getMoney());
			System.out.println("Your current food in your inventory: " + inv1.getFood());
			}
			else {
				System.out.println("You don't have enough money");
				System.out.println("Your current money: " + character.getMoney());
			}
			System.out.println();
			System.out.println("To continue shopping please press 1");
			System.out.println("To finish shopping please press 2");
			press= scanner.nextInt();
			while(press!=1 && press != 2) {
				System.out.println("Enter a valid number..");
				press=scanner.nextInt();
			}
			if(press==1) {
				System.out.println("Continue to shopping");
				System.out.println();
				return;
			}
			else if(press==2) {
			System.out.println("Going back to menu..");
			System.out.println();
			return;
			}
			break;
			}	
		}
		else if(choice==2) {
			System.out.println("Welcome to the Normal Store");
			System.out.println();
			System.out.println("1.Weapon");
			System.out.println("2.Armor");
			System.out.println("Enter your choice..");
			int choice11 = scanner.nextInt();
			switch(choice11) {
			// Weapon Purchase:
			// - Only one weapon can be active at a time
			// - Weapon damage bonus is stored in Inventory
			case 1: System.out.println("You choose to buy a weapon..");
			System.out.println("1. Knife ---- 2 damage ---- 20 gold");
			System.out.println("2. Sword ---- 6 damage ---- 35 gold");
			System.out.println("3. Excalibur  10 damage --- 50 gold");
			System.out.println("Enter your choice...");
			int choice12= scanner.nextInt();
			while(choice12!=1 && choice12!=2 && choice12!=3) {
				System.out.println("Enter a valid number..");
				choice12=scanner.nextInt();
			}

			if(choice12==1) {
				if(character.getMoney()>=20) {
					System.out.println("You've just bought a knife ");
					knife = true; sword = false; excalibur = false;
					inv1.setMyDamage(2);
					character.setMoney(character.getMoney()-20);
					weaponDamage = 2;
					System.out.println();
					System.out.println("To continue shopping please press 1");
					System.out.println("To finish shopping please press 2");
					int press= scanner.nextInt();
					while(press!=1 && press != 2) {
						System.out.println("Enter a valid number..");
						press=scanner.nextInt();
					}
					if(press==1) {
						System.out.println("Continue to shopping");
						System.out.println();
						return;
					}
					else if(press==2) {
					System.out.println("Going back to menu..");
					System.out.println();
					return;
					}
					
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			else if(choice12==2) {
				if(character.getMoney()>=35) {
					System.out.println("You've just bought a sword ");
					sword = true; knife = false; excalibur = false;
					inv1.setMyDamage(6);
					character.setMoney(character.getMoney()-35);
					weaponDamage = 6;

					System.out.println("Your current money: " + character.getMoney());
					
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			else if(choice12==3) {
				if(character.getMoney()>=50) {
					System.out.println("You've just bought an excalibur ");
					excalibur = true; knife = false; sword = false;
					inv1.setMyDamage(10);
					character.setMoney(character.getMoney()-50);
					weaponDamage = 10;

					System.out.println("Your current money: " + character.getMoney());
					
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			System.out.println();
			System.out.println("To continue shopping please press 1");
			System.out.println("To finish shopping please press 2");
			int press= scanner.nextInt();
			while(press!=1 && press != 2) {
				System.out.println("Enter a valid number..");
				press=scanner.nextInt();
			}
			if(press==1) {
				System.out.println("Continue to shopping");
				System.out.println();
				return;
			}
			else if(press==2) {
			System.out.println("Going back to menu..");
			System.out.println();
			return;
			}
			break;
			
			// Armor Purchase:
			// - Only one armor can be active at a time
			// - Armor health bonus is stored in Inventory

			case 2: System.out.println("You choose to buy an armor");
			System.out.println("1. Leather Armor ---- 3 armor ---- 15 gold");
			System.out.println("2. Wooden Armor---- 6 armor ---- 25 gold");
			System.out.println("3. Iron Armor ----  10 armor --- 45 gold");
			System.out.println("Enter your choice...");
			int choice13= scanner.nextInt();
			while(choice13!=1 && choice13!=2 && choice13!=3) {
				System.out.println("Enter a valid number..");
				choice13=scanner.nextInt();
			}
			if(choice13==1) {
				if(character.getMoney()>=15) {
					System.out.println("You've just bought a Leather Armor ");
					leatherArmor = true; woodenArmor = false; ironArmor = false;
					inv1.setMyHealth(3);
					character.setMoney(character.getMoney()-15);
					armor = 3;

					System.out.println("Your current money: " + character.getMoney());
					
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			else if(choice13==2) {
				if(character.getMoney()>=25) {
					System.out.println("You've just bought a Wooden Armor ");
					woodenArmor = true; leatherArmor = false; ironArmor = false;
					inv1.setMyHealth(6);
					character.setMoney(character.getMoney()-25);
					armor = 6;

					System.out.println("Your current money: " + character.getMoney());
					
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			else if(choice13==3) {
				if(character.getMoney()>=45) {
					System.out.println("You've just bought an Iron Armor ");
					ironArmor = true; leatherArmor = false; woodenArmor = false;
					inv1.setMyHealth(10);
					character.setMoney(character.getMoney()-45);
					armor = 10;

					System.out.println("Your current money: " + character.getMoney());
					
				}
				else {
					System.out.println("You don't have enough money");
					System.out.println("Your current money: " + character.getMoney());
				}
				
			}
			System.out.println();
			System.out.println("To continue shopping please press 1");
			System.out.println("To finish shopping please press 2");
			press= scanner.nextInt();
			while(press!=1 && press != 2) {
				System.out.println("Enter a valid number..");
				press=scanner.nextInt();
			}
			if(press==1) {
				System.out.println("Continue to shopping");
				System.out.println();
				return;
			}
			else if(press==2) {
			System.out.println("Going back to menu..");
			System.out.println();
			return;
			}
			break;
			}
			
			
		}
		
	}
	

}
