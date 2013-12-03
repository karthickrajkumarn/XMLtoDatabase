package com.uk.aisl.guidewire.shredder;

import java.util.ArrayList;

public class Column {
	private String columnName;
	private String xpath;
	private String type;
	private ArrayList<String> values;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getXpath() {
		return xpath;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void addValue(String value) {
		if (this.values == null) {
			this.values = new ArrayList<String>();
		}
		this.values.add(value);
	}

	public ArrayList<String> getValues() {
		ArrayList<String> tempValues = this.values;
		this.values = null;
		return tempValues;
	}
}
