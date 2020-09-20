package main;

import java.util.HashMap;

public class CInstruction extends Instruction {
	
	public CInstruction() {
		destMap = new HashMap<String, String>() {
			{
				put("",		"000");
				put("M",	"001");
				put("D",	"010");
				put("MD",	"011");
				put("A",	"100");
				put("AM",	"101");
				put("AD",	"110");
				put("AMD",	"111");
			}
		};
		
		exprMap = new HashMap<String, String>() {
			{
				put("0", 	"0101010");
				put("1", 	"0111111");
				put("-1",	"0111010");
				put("D", 	"0001100");
				put("A", 	"0110000");
				put("M", 	"1110000");
				put("!D", 	"0001101");
				put("!A", 	"0110001");
				put("!M", 	"1110001");
				put("-D", 	"0001111");
				put("-A", 	"0110011");
				put("-M", 	"1110011");
				put("D+1", 	"0011111");
				put("A+1", 	"0110111");
				put("M+1",	"1110111");
				put("D-1",	"0001110");
				put("A-1",	"0110010");
				put("M-1", 	"1110010");
				put("D+A", 	"0000010");
				put("D+M", 	"1000010");
				put("D-A", 	"0010011");
				put("D-M", 	"1010011");
				put("A-D",	"0000111");
				put("M-D",	"1000111");
				put("D&A", 	"0000000");
				put("D&M", 	"1000000");
				put("D|A",	"0010101");
				put("D|M",	"1010101");
			}
		};
				
		jmpMap = new HashMap<String, String>() {
			{
				put("", 	"000");
				put("JGT",	"001");
				put("JEQ",	"010");
				put("JGE",	"011");
				put("JLT", 	"100");
				put("JNE",	"101");
				put("JLE",	"110");
				put("JMP",	"111");
			}
		};
	}

	public void setParts(String dest, String expr, String jmp) {
		this.dest = dest;
		this.expr = expr;
		this.jmp = jmp;
	}
	
	public String getDest() {
		return dest;
	}
	public String getExpr() {
		return expr;
	}
	public String getJmp() {
		return jmp;
	}
	
	public String getBinary() {
		
		return "111" + exprMap.get(expr) + destMap.get(dest) + jmpMap.get(jmp);
	}
	
	private String dest;
	private String expr;
	private String jmp;
	
	private HashMap<String, String> destMap;
	private HashMap<String, String> exprMap;
	private HashMap<String, String> jmpMap;
}
