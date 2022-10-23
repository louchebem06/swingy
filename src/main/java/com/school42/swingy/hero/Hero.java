package com.school42.swingy.hero;

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
	public Artefacs getArmor();
	public Artefacs getWeapon();
	public Artefacs getHelm();
	public String getStat();
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
}
