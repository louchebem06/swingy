package com.school42.swingy.hero;

import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.school42.swingy.artefac.*;
 public interface Hero {
	String getName();
	String getClassName();
	Integer getLevel();
	Double getXp();
	Double getAttack();
	Double getDefense();
	Double getHitPoint();
	void setArtefac(Artefac item);
	void setArtefac(Artefac item, boolean readDB);
	Artefac getArmor();
	Artefac getWeapon();
	Artefac getHelm();
	int getSizeMap();
	void addXp(double xp);
	void setId(int id);
	int getId();
	void insert();
	JLabel getNameLabel();
	JLabel getLevelLabel();
	JLabel getXpLabel();
	JLabel getAttackLabel();
	JLabel getDefenseLabel();
	JLabel getClassNameLabel();
	JLabel getHitPointLabel();
	JLabel getWeaponLabel();
	JLabel getArmorLabel();
	JLabel getHelmLabel();
	JLabel getPointLabel();
	String toString();
	ImageIcon getIcon(int size);
	Point getPoint();
	void setPoint(int x, int y);
	Hero clone();
	boolean isAlive();
	String attack(Hero hero);
	void setHitPoint(double hitPoint);
}
