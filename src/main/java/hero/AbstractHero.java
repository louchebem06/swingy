package main.java.hero;

import java.lang.Math;

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

	protected double _factorAttack;
	protected double _factorDefense;
	protected double _factorHitPoints;

	protected int _id;

	protected AbstractHero(String name, String className, Double attack,
							Double defence, Double hitPoints, int lvl, double xp,
							double factorAttack, double factorDefense, double factorHitPoints) {
		_name = name;
		_className = className;
		_level = lvl;
		_xp = xp;
		_attack = attack + (lvl * factorAttack);
		_defense = defence + (lvl * factorDefense);
		_hitPoints = hitPoints + (lvl * factorHitPoints);
		_weapon = null;
		_armor = null;
		_helm = null;
		_factorAttack = factorAttack;
		_factorDefense = factorDefense;
		_factorHitPoints = factorHitPoints;
		_id = 0;
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
		_factorAttack = hero._factorAttack;
		_factorDefense = hero._factorDefense;
		_factorHitPoints = hero._factorHitPoints;
	}

	public String toString() {
		return (getName() + " <" + getClassName() + ">");
	}

	public String getName() {
		return (_name);
	}

	public String getClassName() {
		return (_className);
	}

	private double calcLevel(int lvl) {
		double xp = Math.pow((lvl * 1000) + (lvl - 1), 2) * 450;
		return (xp);
	}

	private void levelUp() {
		_level++;
		_attack += _level * _factorAttack;
		_defense += _level * _factorDefense;
		_hitPoints += _level * _factorHitPoints;
	}

	public void addXp(int xp) {
		_xp += xp;
		getLevel();
	}

	public Integer getLevel() {
		while (_xp >= calcLevel(_level))
			levelUp();
		return (_level);
	}

	public int getSizeMap() {
		return ((getLevel() - 1) * 5 + 10 - (getLevel() % 2));
	}

	public Double getXp() {
		return (_xp);
	}

	public Double getAttack() {
		if (_weapon != null)
			return (_attack + _weapon.getValue());
		return (_attack);
	}

	public Double getDefense() {
		if (_armor != null)
			return (_defense + _armor.getValue());
		return (_defense);
	}

	public Double getHitPoint() {
		if (_helm != null)
			return (_hitPoints + _helm.getValue());
		return (_hitPoints);
	}

	public Artefacs getWeapon() {
		return (_weapon);
	}

	public Artefacs getHelm() {
		return (_helm);
	}

	public Artefacs getArmor() {
		return (_armor);
	}

	public Boolean setWeapon(Artefacs weapon) {
		if (weapon.getType() == "weapon") {
			_weapon = weapon;
			return (true);
		}
		return (false);
	}

	public Boolean setHelm(Artefacs helm) {
		if (helm.getType() == "helm") {
			_helm = helm;
			return (true);
		}
		return (false);
	}

	public Boolean setArmor(Artefacs armor) {
		if (armor.getType() == "armor") {
			_armor = armor;
			return (true);
		}
		return (false);
	}

	public String getStat() {
		String stat;

		stat = "\t== STATS (DEBUG ID DB:" + getId() + ") ==\n";
		stat += "NAME:\t" + getName() + "\n";
		stat += "CLASS:\t" + getClassName() + "\n";
		stat += "LEVEL:\t" + getLevel() + "\n";
		stat += "XP:\t" + getXp() + "\n";
		stat += "ATTACK:\t" + getAttack() + "\n";
		stat += "DEFENSE:\t" + getDefense() + "\n";
		stat += "HITPOINTS:\t" + getHitPoint() + "\n";

		stat += "\n\t== ITEMS ==\n";
		stat += "WEAPON:\t";
		if (getWeapon() == null)
			stat += "not equiped\n";
		else
			stat += getWeapon() + "\n";
		stat += "ARMOR:\t";
		if (getArmor() == null)
			stat += "not equiped\n";
		else
			stat += getArmor() + "\n";
		stat += "HELM:\t";
		if (getHelm() == null)
			stat += "not equiped\n";
		else
			stat += getHelm() + "\n";

		return (stat);
	}

	public void setId(int id) { _id  = id; }

	public int getId() { return (_id); }

}
