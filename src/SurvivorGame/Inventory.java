package SurvivorGame;



public class Inventory {
	private int wood,cobbleStone,water,food,glass,sand;
	private double myHealth,myDamage;
	private int shelterLevel;

	
	
	public Inventory(){
		this.wood=0;
		this.cobbleStone=0;
		this.water=50;
		this.food=25;
		this.glass=0;
		this.shelterLevel=1;
		
	}
	
	
	
	
	public void gettingReady() {
	 
	}

	
	public void gettingReady(ToolStore t) {
	    if (t.isKnife()) {
	        myDamage += 2;
	    } else if (t.isSword()) {
	        myDamage += 6;
	    } else if (t.isExcalibur()) {
	        myDamage += 10;
	    }

	    if (t.isLeatherArmor()) {
	        myHealth += 3;
	    } else if (t.isWoodenArmor()) {
	        myHealth += 6;
	    } else if (t.isIronArmor()) {
	        myHealth += 10;
	    }
	}







	public double getMyHealth() {
		return myHealth;
	}



	public void setMyHealth(double myHealth) {
		this.myHealth = myHealth;
	}



	public double getMyDamage() {
		return myDamage;
	}



	public void setMyDamage(double myDamage) {
		this.myDamage = myDamage;
	}



	public int getSand() {
		return sand;
	}


	public void setSand(int sand) {
		this.sand = sand;
	}


	public int getWood() {
		return wood;
	}

	public void setWood(int wood) {
		this.wood = wood;
	}

	public int getCobbleStone() {
		return cobbleStone;
	}

	public void setCobbleStone(int cobbleStone) {
		this.cobbleStone = cobbleStone;
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

	public int getGlass() {
		return glass;
	}

	public void setGlass(int glass) {
		this.glass = glass;
	}
	
	public int getShelterLevel() {
	    return shelterLevel;
	}

	public void setShelterLevel(int shelterLevel) {
	    this.shelterLevel = shelterLevel;
	}


	

}
