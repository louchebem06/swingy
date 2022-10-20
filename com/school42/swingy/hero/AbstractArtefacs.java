package com.school42.swingy.hero;

public abstract class AbstractArtefacs implements Artefacs {
	protected String 	_type;
	protected String 	_name;
	protected Double	_value;

	protected AbstractArtefacs(String type, String name, Double value) {
		_type = type;
		_name = name;
		_value = value;
	}

	protected AbstractArtefacs(AbstractArtefacs artefacs) {
		_type = artefacs._type;
		_name = artefacs._name;
		_value = artefacs._value;
	}

	public String toString() {
		return (getName() + " (" + getValue() + ")");
	}

	public String getType() {
		return (_type);
	}

	public String getName() {
		return (_name);
	}

	public Double getValue() {
		return (_value);
	}
}
