package com.school42.swingy.hero;

import java.awt.Point;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.school42.swingy.artefac.*;

public interface Hero {
	public String getName();
	public String getClassName();
	public Integer getLevel();
	public Double getXp();
	public Double getAttack();
	public Double getDefense();
	public Double getHitPoint();
	public void setArtefac(Artefacs item);
	public void setArtefac(Artefacs item, boolean readDB);
	public Artefacs getArmor();
	public Artefacs getWeapon();
	public Artefacs getHelm();
	public int getSizeMap();
	public void addXp(double xp);
	public void setId(int id);
	public int getId();
	public void insert();
	public JLabel getNameLabel();
	public JLabel getLevelLabel();
	public JLabel getXpLabel();
	public JLabel getAttackLabel();
	public JLabel getDefenseLabel();
	public JLabel getClassNameLabel();
	public JLabel getHitPointLabel();
	public JLabel getWeaponLabel();
	public JLabel getArmorLabel();
	public JLabel getHelmLabel();
	public JLabel getPointLabel();
	public String toString();
	public ImageIcon getIcon(int size);
	public Point getPoint();
	public void setPoint(int x, int y);
	public Hero clone();
	public boolean isAlive();
	public String attack(Hero hero);
	public void setHitPoint(double hitPoint);
}
