package com.uk.aisl.guidewire.shredder.model;

import java.util.HashMap;

/**
 * Wraps the XML pay load along with the other select values from the source database.
 * 
 * @author Karl Parry
 *
 */
public class XMLReturn {
	
	private String xmlPayload;
	private HashMap<String,String> variableMap;
	
	public XMLReturn(HashMap<String,String> variableMap, String xmlPayload){
		this.xmlPayload = xmlPayload;
		this.setVariableMap(variableMap);
	}

	public String getXmlPayload() {
		return xmlPayload;
	}

	public void setXmlPayload(String xmlPayload) {
		this.xmlPayload = xmlPayload;
	}

	public HashMap<String,String> getVariableMap() {
		return variableMap;
	}

	public void setVariableMap(HashMap<String,String> variableMap) {
		this.variableMap = variableMap;
	}
	
}
