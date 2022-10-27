package com.school42.swingy.hero;

import java.awt.Image;
import java.lang.Math;
import java.text.*;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.school42.swingy.artefac.*;
import com.school42.swingy.database.DatabaseHero;

public abstract class AbstractHero {

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

	protected JLabel	_nameLabel = new JLabel();
	protected JLabel	_classNameLabel = new JLabel();
	protected JLabel	_levelLabel = new JLabel();
	protected JLabel	_xpLabel = new JLabel();
	protected JLabel	_attackLabel = new JLabel();
	protected JLabel	_defenseLabel = new JLabel();
	protected JLabel	_hitPointsLabel = new JLabel();
	protected JLabel	_weaponLabel = new JLabel();
	protected JLabel	_armorLabel = new JLabel();
	protected JLabel	_helmLabel = new JLabel();
	protected JLabel _pointLabel = new JLabel();

	protected Point	_point = new Point(2,2);

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
		setPoint(getSizeMap() / 2, getSizeMap() / 2);
		updateLabel();
	}

	private void updateLabel() {
		_nameLabel.setText("Name: " + getName());
		_classNameLabel.setText("Class: " + getClassName());
		_levelLabel.setText("Level: " + getLevel());
		_xpLabel.setText("XP: " + df.format(getXp()));
		_attackLabel.setText("Attack: " + df.format(getAttack()));
		_defenseLabel.setText("Defense: " + df.format(getDefense()));
		_hitPointsLabel.setText("Hit Points: " + df.format(getHitPoint()));
		_weaponLabel.setText("Weapon: " + (_weapon == null ? "not equiped" : _weapon.toString()));
		_armorLabel.setText("Armor: " + (_armor == null ? "not equiped" : _armor.toString()));
		_helmLabel.setText("Helm: " + (_helm == null ? "not equiped" : _helm.toString()) );
		_pointLabel.setText("Position: (" + _point.x + "," + _point.y  + ")");
	}

	public void insert() { _db.insert((Hero)this); }

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
		_db.update((Hero)this);
		updateLabel();
	}

	public void setArtefac(Artefacs item) { setArtefac(item, false); }

	public void setArtefac(Artefacs item, boolean readDB) {
		if (item == null)
			return ;
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
		if (!readDB)
			_db.update((Hero)this);
		updateLabel();
	}

	public void setId(int id) { _id  = id; }

	public void setPoint(int x, int y) {
		_point.setLocation(x, y);
		updateLabel();
	};

	public Integer getLevel() {
		boolean levelChange = false;
	
		while (_xp >= calcLevel(_level)) {
			levelUp();
			levelChange = true;
		}
		if (levelChange) {
			_db.update((Hero)this);
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

	public JLabel getPointLabel() { return (_pointLabel); }

	public Point getPoint() { return (_point); }

	public ImageIcon getIcon(int size) {
		String imgName = getClassName().toLowerCase() + ".jpg";
		ImageIcon warlock = new ImageIcon(getClass().getClassLoader().getResource(imgName));
		Image img = warlock.getImage();
		Image newimg = img.getScaledInstance(size, size, Image.SCALE_SMOOTH);
		return (new ImageIcon(newimg));
	};

	public boolean isAlive() { return (getHitPoint() > 0.0); }

	public void setHitPoint(double hitPoint) { _hitPoints = hitPoint; }

	public String attack(Hero hero) {
		double damage = getAttack() - hero.getDefense();
		if (damage <= 0)
			damage = 0.001;
		hero.setHitPoint(hero.getHitPoint() - damage);
		return (df.format(damage));
	}

}
