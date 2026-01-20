package SurvivorGame;

import java.util.Random;

public class Zombie extends Obstacle {
	private int water,food,wood;
	private Random random = new Random();
	

	
	public Zombie() {
	super("Zombie",3,10,4);
	this.wood=random.nextInt(3);
	this.food=random.nextInt(2);
	this.water=random.nextInt(3);
	
		
	}



	public int getWater() {
		return water;
	}



	public void setWater(int water) {
		this.water = water;
	}



	public int getFood() {
		return food;
	}



	public void setFood(int food) {
		this.food = food;
	}



	public int getWood() {
		return wood;
	}



	public void setWood(int wood) {
		this.wood = wood;
	}

}
