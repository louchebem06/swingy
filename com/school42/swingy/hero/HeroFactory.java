package com.school42.swingy.hero;

import com.school42.swingy.hero.heros.Leprechaun;
import com.school42.swingy.hero.heros.Orc;

public class HeroFactory {
	public static Hero newHero(String type, String name) {
		switch(type) {
			case "Leprechaun":
				return (new Leprechaun(name));
			case "Orc":
				return (new Orc(name));
		}
		return (null);
	}
}
