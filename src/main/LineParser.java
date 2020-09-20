package main;

public class LineParser {
	public ParsedLine parseLine(String line, int lineNum, SymbolTable table) {
		// trim line and get rid of comments
		line = line.trim();
		int comment = line.indexOf("//");
		if (comment > -1) line = line.substring(0, comment);
		
		if (line.length()==0) {
			return handleComment(line);
			
		} else if (line.charAt(0) == '(' && line.charAt(line.length()-1)==')') {
			return handleLabel(line, lineNum, table);
			
		} else if (line.charAt(0)=='@') {
			return handleAInstruction(line, table);
			
		} else {
			// Note: Last statement needs more robust error checking
			return handleCInstruction(line);
		}
	}
	
	private AInstruction handleAInstruction(String line, SymbolTable table) {
		String text = line.substring(1);
		
		AInstruction a = new AInstruction(text, table);
		
		return a;
	}
	
	// Handles CInstructions and returns a CInstruction object
	private CInstruction handleCInstruction(String line) {
		CInstruction c = new CInstruction();
		String dest = "";
		String expr = "";
		String jmp = "";
		
		String[] parts = line.split(";");
		
		if (parts.length > 1) {
			jmp = parts[1].trim().replaceAll("\\s", "");
		} else {
			jmp = "";
		}
		
		String[] subParts = parts[0].split("=");
		
		if (subParts.length > 1) {
			expr = subParts[1].trim().replaceAll("\\s", "");
			dest = subParts[0].trim().replaceAll("\\s", "");
		} else {
			expr = subParts[0].trim().replaceAll("\\s", "");
		}
		
		c.setParts(dest, expr, jmp);
		
		return c;
	}
	
	// Handles labels and returns a Label object
	private Label handleLabel(String line, int lineNum, SymbolTable table) {
		Label l = new Label(line.substring(1, line.length()-1));
		l.addToTable(lineNum, table);
		return l;
	}
	
	// Handles comments and returns a Comment object, which is basically an empty placeholder (null object design pattern)
	private Comment handleComment(String line) {
		Comment c = new Comment();
		c.setText("");
		return (Comment) c;
	}
}
