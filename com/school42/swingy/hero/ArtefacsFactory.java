package com.school42.swingy.hero;

import com.school42.swingy.hero.artefacs.*;

public class ArtefacsFactory {
	public static Artefacs newArtefacs(String type, double value) {
		switch (type) {
			case "Sword":
				return (new Sword(value));
		}
		return (null);
	}
}
