package main;

import java.util.HashMap;

public class SymbolTable {
	public SymbolTable() {
		table.put("SP", 0);
		table.put("LCL", 1);
		table.put("ARG", 2);
		table.put("THIS", 3);
		table.put("THAT", 4);
		table.put("SCREEN", 16384);
		table.put("KBD", 24576);
		
		for (int i=0; i < 16; i++) {
			table.put("R" + Integer.toString(i), i);
		}
		
		nextVariableAddress = 16;
	}
	
	public void addValue(String symbol, int lineNum) {
		table.put(symbol, lineNum);
	}
	
	public int getValue(String symbol) {
		if (table.get(symbol)==null)
			table.put(symbol, nextVariableAddress++);
		return table.get(symbol);
	}
	
	private HashMap<String, Integer> table = new HashMap<String, Integer>();
	private int nextVariableAddress;
}
