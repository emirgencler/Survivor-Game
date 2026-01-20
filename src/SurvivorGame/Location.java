package SurvivorGame;

public abstract class Location extends Character {
	Character character;
	String name;
	protected Location(Character character) {
		this.character=character;
		
	}
	void location() {
		
	}
	
	abstract boolean getLocation();

}
