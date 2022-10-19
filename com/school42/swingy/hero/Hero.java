package com.school42.swingy.hero;

public interface Hero {
	public String getName();
	public String getClassName();
	public Integer getLevel();
	public Double getXp();
	public Double getAttack();
	public Double getDefense();
	public Double getHitPoint();
	public void setWeapon(Artefacs weapon);
	public void setHelm(Artefacs Helm);
	public void setArmor(Artefacs Armor);
	public Artefacs getArmor();
	public Artefacs getWeapon();
	public Artefacs getHelm();
}
