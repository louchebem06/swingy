package com.school42.swingy.hero;

import com.school42.swingy.hero.artefacs.Sword;

public class ArtefacsFactory {
	public static Artefacs newArtefacs(String type) {
		switch (type) {
			case "Sword":
				return (new Sword());
		}
		return (null);
	}
}
