package _01_MurderOfCrows;

import java.util.ArrayList;
import java.util.Random;

public class MurderOfCrows {

    ArrayList<Crow> theMurder = new ArrayList<Crow>();
    boolean diamondPresent = false;
    public static void main(String[] args) {
        MurderOfCrows murderOfCrows = new MurderOfCrows();
        murderOfCrows.initializeCrows();
        murderOfCrows.findTheDiamond();
       
    }

    private void findTheDiamond() {
        // 1. One of the Crows has eaten the diamond. You need to search
        //    through the stomach of each Crow, then print the name of the
        //    guilty Crow.
    	int numbersOfCrows = 0;
    	for(int i = 0; i < theMurder.size(); i++) {
    		for(int j = 0; j < theMurder.get(i).getStomachContents().size(); j++ ) {
    			if(theMurder.get(i).getStomachContents().get(j) .equals("diamond")) {
    				diamondPresent = true;
    				System.out.println(theMurder.get(i).getName());
    				System.out.println(numbersOfCrows + " crows were innocent before you killed them");
    				break;
    			}
    			else {
    				numbersOfCrows += 1;
    			}
    			
    	}
    		if(diamondPresent) {
    			
    			break;
    		}
    		
    	}
        // 2. How many innocent crows had to die before the diamond was found?

    }

    private void initializeCrows() {
        theMurder.add(new Crow("Rok"));
        theMurder.add(new Crow("Merle"));
        theMurder.add(new Crow("Poe"));
        theMurder.add(new Crow("Grenwyn"));
        theMurder.add(new Crow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++)
            this.stomachContents.add(getRandomCrowFood());
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }
}
