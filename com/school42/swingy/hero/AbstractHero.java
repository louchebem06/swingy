package com.school42.swingy.hero;

public abstract class AbstractHero implements Hero {
	protected String _name;
	protected String _className;
	protected Integer _level;
	protected Double _xp;
	protected Double _attack;
	protected Double _defense;
	protected Double _hitPoints;

	protected Artefacs _weapon;
	protected Artefacs _armor;
	protected Artefacs _helm;

	protected AbstractHero(String name, String className, Double attack, Double defence, Double hitPoints) {
		_name = name;
		_className = className;
		_level = 0;
		_xp = 0.0;
		_attack = attack;
		_defense = defence;
		_hitPoints = hitPoints;
		_weapon = null;
		_armor = null;
		_helm = null;
	}

	protected AbstractHero(AbstractHero hero) {
		_name = hero._name;
		_className = hero._className;
		_level = hero._level;
		_xp = hero._xp;
		_attack = hero._attack;
		_defense = hero._defense;
		_hitPoints = hero._hitPoints;
		_weapon = hero._weapon;
		_armor = hero._armor;
		_helm = hero._helm;
	}

	public String toString() {
		return (_name);
	}

	public String getName() {
		return (_name);
	}

	public String getClassName() {
		return (_className);
	}

	public Integer getLevel() {
		return (_level);
	}

	public Double getXp() {
		return (_xp);
	}

	public Double getAttack() {
		return (_attack + _weapon.getValue());
	}

	public Double getDefense() {
		return (_defense + _armor.getValue());
	}

	public Double getHitPoint() {
		return (_hitPoints + _helm.getValue());
	}

	public void setWeapon(Artefacs weapon) {
		if (weapon.getType() == "weapon")
			_weapon = weapon;
	}

	public void setHelm(Artefacs helm) {
		if (helm.getType() == "helm")
			_helm = helm;
	}

	public void setArmor(Artefacs armor) {
		if (armor.getType() == "armor")
			_armor = armor;
	}
}
