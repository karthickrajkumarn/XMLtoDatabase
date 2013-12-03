package com.uk.aisl.guidewire.shredder;

import java.util.ArrayList;

public class Table {
	
	private String tableName;
	private String xpathROOT;
	private ArrayList<Column> columns;

	public Table() {
		this.columns = new ArrayList<Column>();
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getXpathROOT() {
		return xpathROOT;
	}

	public void setXpathROOT(String xpathROOT) {
		this.xpathROOT = xpathROOT;
	}

	public void addColumn(Column column) {
		this.columns.add(column);
	}
	
	public ArrayList<Column> getColumns(){
		return this.columns;
	}
}
