package SurvivorGame;

public abstract class NormalLoc extends Location{
	
	Character characterr=new Character();
	protected NormalLoc(Character player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	abstract boolean getLocation();
	

}
