package main;

public class Label extends ParsedLine {
	public Label(String label) {
		setText(label);
	}
	
	public void addToTable(int nextLine, SymbolTable table) {
		table.addValue(getText(), nextLine);
	}
}
