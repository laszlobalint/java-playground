package DesignPatterns;

public class Main {

    public static void main(String[] args) {
	    Character shrek = new Character("Shrek", "Over the ocean");
	    Character donkey = new Character("Donkey", "Szabadka");
	    Carriage carriage = new Carriage();
	    carriage.addObserver(shrek);
	    carriage.addObserver(donkey);
	    carriage.arrive("Pub");
	    carriage.arrive("Csantavér");
	    carriage.arrive("Police station");
	    carriage.arrive("Jail");
	    carriage.arrive("Over the ocean");
	    carriage.arrive("Port");
	    carriage.arrive("Szabadka");
    }
}
