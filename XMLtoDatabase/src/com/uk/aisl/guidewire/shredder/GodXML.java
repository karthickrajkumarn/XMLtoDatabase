package com.uk.aisl.guidewire.shredder;

import com.ximpleware.AutoPilot;
import com.ximpleware.NavException;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import com.ximpleware.XPathEvalException;
import com.ximpleware.XPathParseException;

public class GodXML {

	public static XMLObject parseGodXML(String path) {
		XMLObject xml = new XMLObject();
		VTDGen vg = new VTDGen();
		if (vg.parseFile(path, false)) {
			// parsing succeeded
			try {
				VTDNav vn = vg.getNav();

				AutoPilot ap = new AutoPilot();
				ap.selectXPath("//shredder/table");
				ap.bind(vn);

				int tableROOT = -1;
				while ((tableROOT = ap.evalXPath()) != -1) {
					xml.addTable(GodXML.fillInTable(tableROOT, vn));
				}
				ap.resetXPath();
			} catch (XPathEvalException | NavException | XPathParseException e) {
				System.err.println("Failed to parse the table of GodXML");
				e.printStackTrace();
			}

		} else {
			xml = null;
		}
		return xml;
	}

	private static Table fillInTable(int tableROOT, VTDNav vn) throws XPathParseException, XPathEvalException,
			NavException {
		Table table = new Table();

		AutoPilot apName = new AutoPilot();
		apName.selectXPath("name");
		apName.bind(vn);
		table.setTableName(apName.evalXPathToString());
		apName.resetXPath();
		
		AutoPilot apROOT = new AutoPilot();
		apROOT.selectXPath("rootxpath");
		apROOT.bind(vn);
		table.setXpathROOT(apROOT.evalXPathToString());
		apROOT.resetXPath();

		AutoPilot ap = new AutoPilot();
		ap.selectXPath("column");
		ap.bind(vn);
		
		while (ap.evalXPath() != -1) {
			Column column = new Column();
			
			AutoPilot name = new AutoPilot();
			name.selectXPath("name");
			name.bind(vn);
			column.setColumnName(name.evalXPathToString());
			name.resetXPath();
			
			AutoPilot xpath = new AutoPilot();
			xpath.selectXPath("xpath");
			xpath.bind(vn);
			column.setXpath(xpath.evalXPathToString());
			xpath.resetXPath();
			
			AutoPilot type = new AutoPilot();
			type.selectXPath("type");
			type.bind(vn);
			column.setType(type.evalXPathToString());
			type.resetXPath();
			
			table.addColumn(column);
		}

		return table;
	}
}
