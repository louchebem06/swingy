package com.school42.swingy.console;

import com.school42.swingy.Main;
import com.school42.swingy.Utils;
import com.school42.swingy.artefac.Artefac;
import com.school42.swingy.hero.Hero;

import java.util.Vector;

public class ConsoleGame {

	private void printDataHero(Hero hero) {
		System.out.println("ID: " + hero.getId());
		System.out.println(hero.getNameLabel().getText());
		System.out.println(hero.getLevelLabel().getText());
		System.out.println(hero.getAttackLabel().getText());
		System.out.println(hero.getDefenseLabel().getText());
		System.out.println(hero.getHitPointLabel().getText());
		System.out.println(hero.getWeaponLabel().getText());
		System.out.println(hero.getArmorLabel().getText());
		System.out.println(hero.getHelmLabel().getText());
		System.out.println(hero.getXpLabel().getText());
		System.out.println(hero.getClassNameLabel().getText());
	}

	private void printHero() {
		Vector<Hero> heros = Main.getAllHero();

		if (heros.size() == 0) {
			System.out.println("No hero found");
			return ;
		}
		for (Hero hero : Main.getAllHero()) {
			printDataHero(hero);
			System.out.println();
		}
	}

	private void mainMenu() {
		System.out.println("1. Create hero");
		System.out.println("2. View hero");
		System.out.println("3. Select hero");
		System.out.println("4. Exit");
		String input = System.console().readLine("Choice: ");
		System.out.println();
		switch (input) {
			case "1":
				createHero();
				break;
			case "2":
				printHero();
				break;
			case "3":
				printHero();
				selectHero();
				break;
			case "4":
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input");
				break;
		}
	}

	private void createHero() {
		String name = System.console().readLine("Enter name: ");
		Vector<String> classHero = Main.getClassHero();
		for (int i = 0; i < classHero.size(); i++) {
			System.out.println(i + 1 + ". " + classHero.get(i));
		}
		String input = System.console().readLine("Choice class: ");
		System.out.println();
		try {
			int choice = Integer.parseInt(input);
			if (choice < 1 || choice > classHero.size()) {
				System.out.println("Invalid input");
				return ;
			}
			if (!Utils.addHero(Main.getAllHero(), name, classHero.get(choice - 1), classHero))
				System.out.println("Invalid input\n");
			else
				System.out.println("Hero created\n");
		} catch (Exception e) {
			System.out.println("Invalid input\n");
		}
	}

	private void selectHero() {
		String input = System.console().readLine("Select hero: ");
		System.out.println();
		try {
			int id = Integer.parseInt(input);
			for (Hero hero : Main.getAllHero()) {
				if (hero.getId() == id) {
					Main.setCurrentHero(hero);
					launchGame();
					return ;
				}
			}
			System.out.println("Hero not found\n");
		} catch (Exception e) {
			System.out.println("Invalid input\n");
		}
	}

	private void launchGame() {
		Utils.setupGame();
		while (true) {
			System.out.println("1. View Stats");
			System.out.println("2. Move");
			System.out.println("3. Exit");
			String input = System.console().readLine("Choice: ");
			System.out.println();
			switch (input) {
				case "1":
					printDataHero(Main.getCurrentHero());
					System.out.println(Main.getCurrentHero().getPointLabel().getText());
					System.out.println();
					break;
				case "2":
					move();
					break;
				case "3":
					System.exit(0);
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}
	}

	private void move() {
		boolean moveState = true;
		System.out.println(Main.getCurrentHero().getPointLabel().getText());
		System.out.println("1. North");
		System.out.println("2. South");
		System.out.println("3. East");
		System.out.println("4. West");
		String input = System.console().readLine("Choice: ");
		System.out.println();
		switch (input) {
			case "1":
				moveState = Utils.heroMove("north");
				break;
			case "2":
				moveState = Utils.heroMove("south");
				break;
			case "3":
				moveState = Utils.heroMove("east");
				break;
			case "4":
				moveState = Utils.heroMove("west");
				break;
			default:
				System.out.println("Invalid input\n");
				break;
		}
		if (!moveState) {
			System.out.println("Your finish this level\n");
			mainMenu();
			return ;
		}
		System.out.println("Your move to " + Main.getCurrentHero().getPointLabel().getText() + "\n");
		if (Utils.checkIsEnemyPosition()) {
			System.out.println("You meet an enemy\n");
			figth();
		}
	}

	private void figth() {
		boolean run = true;
		while (true) {
			System.out.println("1. Attack");
			if (run)
				System.out.println("2. Run");
			String input = System.console().readLine("Choice: ");
			System.out.println();
			switch (input) {
				case "1":
					if (Utils.figth(Main.getCurrentHero().clone(), Main.getCurrentEnemy().clone())) {
						System.out.println();
						dropItem(Main.getCurrentEnemy().getWeapon());
						dropItem(Main.getCurrentEnemy().getArmor());
						dropItem(Main.getCurrentEnemy().getHelm());
						return ;
					}
					Utils.resetPositionPlayer();
					System.out.println("You position is reset\n");
					return ;
				case "2":
					if (run) {
						if (Utils.run()) {
							System.out.println("You run away\n");
							return;
						}
						System.out.println("You can't run away\n");
						run = false;
						break;
					}
				default:
					System.out.println("Invalid input\n");
					break;
			}
		}
	}

	private void dropItem(Artefac item) {
		if (item == null)
			return ;
		while (true) {
			System.out.println("You actual item " + Main.getCurrentHero().getWeaponLabel().getText());
			System.out.println("You actual item " + Main.getCurrentHero().getArmorLabel().getText());
			System.out.println("You actual item " + Main.getCurrentHero().getHelmLabel().getText());
			System.out.println("You get " + item + " " + item.getType());
			System.out.println("1. Equip");
			System.out.println("2. Drop");
			String input = System.console().readLine("Choice: ");
			System.out.println();
			switch (input) {
				case "1":
					Main.getCurrentHero().setArtefac(item);
					return ;
				case "2":
					return ;
				default:
					System.out.println("Invalid input\n");
					break;
			}
		}
	}

	public ConsoleGame() {
		Main.setConsole();
		while (true) {
			mainMenu();
		}
	}

}
