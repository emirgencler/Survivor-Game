package SurvivorGame;

import java.util.Scanner;

public class Character {
	private String chaName;
	protected double damagePoint;
	protected double health;
	protected boolean damageDealer;
	protected boolean evolotion;
	private double firstHealth;
	protected double money=100;
	private Inventory inventory = new Inventory();
	
	public Character(String chaName,double  health,double damagePoint) {
		this.chaName=chaName;
		this.damagePoint=damagePoint;
		this.health=health;
	
	}
	

	public Inventory getInventory() {
	    return inventory;
	}

	public Character() {}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getMoney() {
		return money;
	}
	
	
	
	public double getDamagePoint() {
		return damagePoint;}
	public void setDamagePoint(double damagePoint) {
		this.damagePoint = damagePoint;
	}
	public void setDamageDealer(boolean damageDealer) {
		this.damageDealer = damageDealer;
	}
	public void setEvolotion(boolean evolotion) {
		this.evolotion = evolotion;
	}
	public boolean getDamageDealer() {
		return damageDealer;
	}
	public boolean getEvolotion() {
		return evolotion;
	}
	
	
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}
	public double getFirstHealth() {
		return firstHealth;
	}
	
	
	public void characterInfo(Character character) {
		System.out.println("Character name: " + chaName);
		System.out.println("-----");
		System.out.println("Damage: " + damagePoint);
		System.out.println("Health: " + health);
		if(evolotion==true) {
			System.out.println(chaName + " has an evolotion");
			System.out.println("Evolotion: Increases damage dealt by 10%");
			System.out.println();
			
		}
		else if(damageDealer==true) {
			System.out.println(chaName + " has a damage dealer ability");
			System.out.println("Damage dealer: Reduces damage taken by %10");
			System.out.println();
		}
		
		
		
	}
	public void selectCha(String character) {
		System.out.println("Choose a character");
		
		
	}
	public void createACharacter(){
	    Scanner input = new Scanner(System.in);

	    System.out.print("Enter character's name: ");
	    String cName = input.nextLine();

	    System.out.println("\nSelect difficulty preset:");
	    System.out.println("1) Casual   (Health=55, Damage=8,  Money=40)");
	    System.out.println("2) Normal   (Health=45, Damage=6,  Money=30)");
	    System.out.println("3) Hard     (Health=38, Damage=5,  Money=25)");
	    int diff = input.nextInt();

	    double heal;
	    int dam;
	    int mon;

	    switch (diff) {
	        case 1: // Casual
	            heal = 55;
	            dam = 8;
	            mon = 40;
	            break;
	        case 2: // Normal
	            heal = 45;
	            dam = 6;
	            mon = 30;
	            break;
	        case 3: // Hard
	            heal = 38;
	            dam = 5;
	            mon = 25;
	            break;
	        default:
	            System.out.println("Invalid choice. Defaulting to Normal.");
	            heal = 45;
	            dam = 6;
	            mon = 30;
	            break;
	    }

	  
	    this.getInventory().setMyDamage(0);
	    this.getInventory().setMyHealth(0);


	    System.out.println("Enter " + cName + "'s feature:");
	    System.out.println("1) Damage dealer (+10% health)");
	    System.out.println("2) Alchemist (+20% money)");
	    System.out.println("3) Berserker (+30% damage)");
	    System.out.println("4) Vampire (+40% health)");
	    int choice = input.nextInt();

	    if(choice == 1){
	        heal = heal + heal * 1 / 10.0;
	    } else if(choice == 2){
	        mon = mon + mon * 2 / 10;
	    } else if(choice == 3){
	        dam = dam + dam * 3 / 10;
	    } else if(choice == 4){
	        heal = heal + heal * 4 / 10.0;
	    }

	    this.chaName = cName;
	    this.health = heal;
	    this.damagePoint = dam;
	    this.money = mon;
	    this.firstHealth=heal;
	}

	

}
