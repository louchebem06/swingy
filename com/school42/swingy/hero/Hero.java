package com.school42.swingy.hero;

public interface Hero {
	public String getName();
	public String getClassName();
	public Integer getLevel();
	public Double getXp();
	public Double getAttack();
	public Double getDefense();
	public Double getHitPoint();
	public Boolean setWeapon(Artefacs weapon);
	public Boolean setHelm(Artefacs Helm);
	public Boolean setArmor(Artefacs Armor);
	public Artefacs getArmor();
	public Artefacs getWeapon();
	public Artefacs getHelm();
	public String getStat();
	public int getSizeMap();
	public void addXp(int xp);
}
