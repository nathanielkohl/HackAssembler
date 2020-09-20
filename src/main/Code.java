package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Code {
	public Code(File file) {
		this.file = file;
	}

	public ArrayList<String> translate() {
		firstPass();
		return secondPass();
	}
	
	// On first pass, scan through text, parsing each line and saving any labels to symbol table
	private void firstPass() {
		LineParser p = new LineParser();
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = reader.readLine();
			while (line != null) {
				ParsedLine pl = p.parseLine(line, instructions.size(), table);
				if (pl instanceof Instruction) instructions.add((Instruction) pl);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> secondPass() {
		ArrayList<String> binaryLines = new ArrayList<String>();
		
		for (Instruction i : instructions) {
			binaryLines.add(i.getBinary());
		}
		
		return binaryLines;
	}
	
	private File file;
	private ArrayList<Instruction> instructions = new ArrayList<Instruction>();
	private SymbolTable table = new SymbolTable();
}
