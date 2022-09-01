package com.school42.swingy.game;

public class Game {
	private static String _mode;

	private static String _launchMode(String av[]) throws Exception {
		if (av.length != 1)
			throw new Exception("Please input console or gui");
		if (av[0].equals("console") || av[0].equals("gui"))
			return (av[0]);
		throw new Exception(av[0] + " != console or gui");
	}

	public static void main(String argv[]) {
		try {
			_mode = _launchMode(argv);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		System.out.println(_mode);
	}

}
