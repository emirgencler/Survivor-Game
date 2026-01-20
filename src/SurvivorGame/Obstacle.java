package SurvivorGame;

public  class Obstacle  {
	protected String name;
	protected double damage,award,health;
	public Obstacle(String name, double damage, double health, double award) {
		
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.award=award;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}
	public double getAward() {
		return award;
	}
	public void setAward(double award) {
		this.award = award;
	}
	public double getHealth() {
		return health;
	}
	public void setHealth(double health) {
		this.health = health;
	}
	
	
	
	

}
