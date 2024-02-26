package com.game.adv;

import java.util.Scanner;

public class Game {

	Scanner myScanner = new Scanner(System.in);
	Scanner enterScanner = new Scanner(System.in);
	int playerHP;
	String playerName;
	String playerWeapon;
	int choice;
	int monsterHP;

	int silverRing;

	public static void main(String[] args) {

		Game dublin;
		dublin = new Game();

		dublin.playerSetUp();
		dublin.townGate();
	}

	public void playerSetUp() {

		playerHP = 10;
		monsterHP = 15;

		playerWeapon = "Knife";

		System.out.println("------------------------------------------------------------------");
	    System.out.println("Welcome to the world of Aethel!");
	    System.out.println("Aethel is a land filled with danger and adventure.");

		
		System.out.println("Please enter your name:");
		
		playerName = myScanner.nextLine();

		System.out.println("Hello " + playerName);
		
		System.out.println("embarked on a quest to become a trustworthy.");
	    System.out.println("Prepare to face perilous challenges, forge powerful alliances,");
	    System.out.println("and ultimately shape your own destiny in Aethel.\nLET'S START\n");
	    System.out.println("------------------------------------------------------------------");

	    System.out.println("**Your Spirit**: " + playerHP);
		System.out.println("**Your Weapon**: " + playerWeapon);

	}

	public void townGate() {

		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at the gate of the town.");
		System.out.println("A guard is standing in front of you.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Attack the guard");
		System.out.println("3: Leave");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			if (silverRing == 1) {
				ending();
			} else {
				System.out.println("Guard: (Raises an eyebrow) Hold on, " + playerName + ". Never heard that name before. What brings you to Elvenford?");
				System.out.println("Guard: (Looks you up and down) We've had to be cautious lately. Not everyone who comes knocking has good intentions.");
				enterScanner.nextLine();
				townGate();
			}

		} else if (choice == 2) {
			playerHP = playerHP - 1;
			System.out.println(
					"Guard: \"Stop! This is no place for reckless actions!\"\r\n" + 
					"\r\n" + 
					"The guard lunges forward, his fist connecting squarely with your jaw. You stumble back, feeling a sharp pain shoot through your head. Disoriented and in pain, you momentarily falter, feeling the fight drain from you. \n(You receive 1 damage)\n");
			System.out.println("**Your Spirit**: " + playerHP);
			enterScanner.nextLine();
			townGate();
		} else if (choice == 3) {
			crossRoad();
		} else if (choice != 1 && choice != 2 && choice != 3) {
		    System.out.println("Invalid input. Please enter 1, 2, or 3.");
		    townGate();
		} else {
			townGate();
		}
	}

	public void crossRoad() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
		System.out.println("1: Go north");
		System.out.println("2: Go east");
		System.out.println("3: Go south");
		System.out.println("4: Go west");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			north();
		} else if (choice == 2) {
			east();
		} else if (choice == 3) {
			townGate();
		} else if (choice == 4) {
			west();
		} else {
			crossRoad();
		}
	}

	public void north() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("There is a river. You drink the water and rest at the riverside.");
		System.out.println("Your Spirit is recovered.");
		playerHP = playerHP + 1;
		System.out.println("**Your Spirit**: " + playerHP);
		System.out.println("\n\n1: Go back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			crossRoad();
		} else {
			north();
		}
	}

	public void east() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You walked into a forest and found a Long Sword!");
		playerWeapon = "Long Sword";
		System.out.println("Your Weapon: " + playerWeapon);
		System.out.println("\n\n1: Go back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			crossRoad();
		} else {
			east();
		}
	}

	public void west() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You encounter a goblin!\n");
		System.out.println("1: Fight");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			fight();
		} else if (choice == 2) {
			crossRoad();
		} else {
			west();
		}
	}

	public void fight() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("**Your Spirit**: " + playerHP);
		System.out.println("Monster Spirit: " + monsterHP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = myScanner.nextInt();

		if (choice == 1) {
			attack();
		} else if (choice == 2) {
			crossRoad();
		} else {
			fight();
		}
	}

	public void attack() {
		int playerDamage = 0;

		if (playerWeapon.equals("Knife")) {
			playerDamage = new java.util.Random().nextInt(5);
		} else if (playerWeapon.equals("Long Sword")) {
			playerDamage = new java.util.Random().nextInt(8);
		}

		System.out.println("You attacked the monster and gave " + playerDamage + " damage!");

		monsterHP = monsterHP - playerDamage;

		System.out.println("Monster HP: " + monsterHP);

		if (monsterHP < 1) {
			win();
		} else if (monsterHP > 0) {
			int monsterDamage = 0;

			monsterDamage = new java.util.Random().nextInt(4);

			System.out.println("The monster attacked you and gave " + monsterDamage + " damage!");

			playerHP = playerHP - monsterDamage;

			System.out.println("Player HP: " + playerHP);

			if (playerHP < 1) {
				dead();
			} else if (playerHP > 0) {
				fight();
			}
		}

	}

	public void dead() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("The goblin's blade finds its mark. You are defeated.\r\n" + 
				"\r\n" + 
				"**Game Over**");
		System.out.println("\n------------------------------------------------------------------\n");

	}

	public void win() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the monster!");
		System.out.println("The monster dropped a ring!");
		System.out.println("You obtaind a silver ring!\n\n");
		System.out.println("1: Go east");
		System.out.println("\n------------------------------------------------------------------\n");

		silverRing = 1;

		choice = myScanner.nextInt();
		if (choice == 1) {
			crossRoad();
		} else {
			win();
		}

	}

	public void ending() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Guard: (Eyes widen in surprise) \"Oh, you killed that goblin?! Incredible! We haven't had anyone brave enough to face that beast in years. It seems you're much more than just a stranger.\"\r\n" + 
				"\r\n" + 
				"(Guard leans closer, lowering his voice) \"Word on the wind whispers of a darkness stirring beyond the mountains. We could use someone with your courage here in town. Welcome, stranger, to the haven of Elvenford. Consider this a new beginning.\"\r\n" + 
				"\r\n" + 
				"(Guard smiles, offering a warm hand) \"Let's head inside. I'll introduce you to the others and get you settled in. There's much to tell you about Elvenford and the challenges we face.\"");
		System.out.println("\n\n           THE END                    ");
		System.out.println("\n------------------------------------------------------------------\n");
	}
}