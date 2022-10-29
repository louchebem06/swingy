package com.school42.swingy.artefac;

import java.text.DecimalFormat;

public abstract class AbstractArtefac implements Artefac {

	protected String 	_type;
	protected String 	_name;
	protected Double	_value;

	private static final DecimalFormat	df = new DecimalFormat("0.00");

	protected AbstractArtefac(String type, String name, Double value) {
		_type = type;
		_name = name;
		_value = value;
	}

	protected AbstractArtefac(AbstractArtefac artefac) {
		_type = artefac._type;
		_name = artefac._name;
		_value = artefac._value;
	}

	public String toString() {
		return (getName() + " (" + df.format(getValue()) + ")");
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
