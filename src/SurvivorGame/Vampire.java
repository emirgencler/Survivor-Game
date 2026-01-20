package SurvivorGame;

import java.util.Random;

public class Vampire extends Obstacle {
	
	private int water,food,stone;
	private Random random=new Random();
	

	
	public Vampire() {
	super("Vampire",1,14,7);
	this.stone=random.nextInt(2);
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



	public int getStone() {
		return stone;
	}



	public void setStone(int stone) {
		this.stone = stone;
	}
	

}
