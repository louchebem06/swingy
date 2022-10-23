package com.school42.swingy.hero;

import java.lang.Math;
import java.text.*;

import javax.swing.JLabel;

import com.school42.swingy.artefac.*;
import com.school42.swingy.database.DatabaseHero;

public abstract class AbstractHero implements Hero {

	protected int		_id = 0;

	protected String	_name;
	protected String	_className;
	protected Integer	_level;
	protected Double	_xp;
	protected Double	_attack;
	protected Double	_defense;
	protected Double	_hitPoints;

	protected Artefacs	_weapon = null;
	protected Artefacs	_armor = null;
	protected Artefacs	_helm = null;

	protected double	_factorAttack;
	protected double	_factorDefense;
	protected double	_factorHitPoints;

	protected DatabaseHero	_db = new DatabaseHero();

	private JLabel	_nameLabel = new JLabel();
	private JLabel	_classNameLabel = new JLabel();
	private JLabel	_levelLabel = new JLabel();
	private JLabel	_xpLabel = new JLabel();
	private JLabel	_attackLabel = new JLabel();
	private JLabel	_defenseLabel = new JLabel();
	private JLabel	_hitPointsLabel = new JLabel();
	private JLabel	_weaponLabel = new JLabel();
	private JLabel	_armorLabel = new JLabel();
	private JLabel	_helmLabel = new JLabel();

	private static final DecimalFormat	df = new DecimalFormat("0.00");

	protected AbstractHero(String name, String className, Double attack,
							Double defence, Double hitPoints, int lvl,
							double xp, double factorAttack,
							double factorDefense, double factorHitPoints)
	{
		_name = name;
		_className = className;
		_level = lvl;
		_xp = xp;
		_attack = attack + (lvl * factorAttack);
		_defense = defence + (lvl * factorDefense);
		_hitPoints = hitPoints + (lvl * factorHitPoints);
		_factorAttack = factorAttack;
		_factorDefense = factorDefense;
		_factorHitPoints = factorHitPoints;
		updateLabel();
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
		_id = hero._id;
	}

	private void updateLabel() {
		_nameLabel.setText("Name: " + _name);
		_classNameLabel.setText("Class: " + _className);
		_levelLabel.setText("Level: " + _level);
		_xpLabel.setText("XP: " + df.format(_xp));
		_attackLabel.setText("Attack: " + df.format(_attack));
		_defenseLabel.setText("Defense: " + df.format(_defense));
		_hitPointsLabel.setText("Hit Points: " + df.format(_hitPoints));
		_weaponLabel.setText("Weapon: " + (_weapon == null ? "not equiped" : _weapon.toString()));
		_armorLabel.setText("Armor: " + (_armor == null ? "not equiped" : _armor.toString()));
		_helmLabel.setText("Helm: " + (_helm == null ? "not equiped" : _helm.toString()) );
	}

	public void insert() { _db.insert(this); }

	public String toString() { return (getName() + " <" + getClassName() + ">"); }

	private double calcLevel(int lvl) { return (lvl * 1000 + Math.pow(lvl - 1, 2) * 450); }

	private void levelUp() {
		_level++;
		_attack += _level * _factorAttack;
		_defense += _level * _factorDefense;
		_hitPoints += _level * _factorHitPoints;
	}

	public void addXp(double xp) {
		_xp += xp;
		getLevel();
		_db.update(this);
		updateLabel();
	}

	public void setArtefac(Artefacs item) {
		switch (item.getType()) {
			case "weapon":
				_weapon = item;
				break;
			case "armor":
				_armor = item;
				break;
			case "helm":
				_helm = item;
				break;
		}
		_db.update(this);
		updateLabel();
	}

	public void setId(int id) { _id  = id; }

	public Integer getLevel() {
		boolean levelChange = false;
	
		while (_xp >= calcLevel(_level)) {
			levelUp();
			levelChange = true;
		}
		if (levelChange) {
			_db.update(this);
			updateLabel();
		}
		return (_level);
	}

	public int getSizeMap() { return ((getLevel() - 1) * 5 + 10 - (getLevel() % 2)); }

	public Double getXp() { return (_xp); }

	public Double getAttack() { return (_weapon != null ? (_attack + _weapon.getValue()) : _attack); }

	public Double getDefense() { return (_armor != null ? (_defense + _armor.getValue()) : _defense); }

	public Double getHitPoint() { return (_helm != null ? (_hitPoints + _helm.getValue()) : _hitPoints); }

	public Artefacs getWeapon() { return (_weapon); }

	public Artefacs getHelm() { return (_helm); }

	public Artefacs getArmor() {return (_armor); }

	public String getName() { return (_name); }

	public String getClassName() { return (_className); }

	public int getId() { return (_id); }

	public JLabel getNameLabel() { return (_nameLabel); }

	public JLabel getClassNameLabel() { return (_classNameLabel); }

	public JLabel getLevelLabel() { return (_levelLabel); }

	public JLabel getXpLabel() { return (_xpLabel); }

	public JLabel getAttackLabel() { return (_attackLabel); }

	public JLabel getDefenseLabel() { return (_defenseLabel); }
	
	public JLabel getHitPointLabel() { return (_hitPointsLabel); }

	public JLabel getWeaponLabel() { return (_weaponLabel); }

	public JLabel getArmorLabel() { return (_armorLabel); }

	public JLabel getHelmLabel() { return (_helmLabel); }

	public String getStat() {
		String stat;

		stat = "\t== STATS ==\n";
		stat += "NAME:\t" + getName() + "\n";
		stat += "CLASS:\t" + getClassName() + "\n";
		stat += "LEVEL:\t" + getLevel() + "\n";
		stat += "XP:\t" + df.format(getXp()) + "\n";
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

}
