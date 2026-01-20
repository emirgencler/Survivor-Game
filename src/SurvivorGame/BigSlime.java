package SurvivorGame;

import java.util.Random;

public class BigSlime extends Obstacle  {
	private int water,food,sand;
	private Random random = new Random();
	

	
	public BigSlime() {
	super("Big Slime",5,20,12);
	this.sand=random.nextInt(2);
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



	public int getSand() {
		return sand;
	}



	public void setSand(int sand) {
		this.sand = sand;
	}
	

}
