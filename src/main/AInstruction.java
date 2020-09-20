package main;

public class AInstruction extends Instruction {
	public AInstruction(String text, SymbolTable table) {
		setText(text);
		this.table = table;
	}


	public int getAddress() {
		return address;
	}
	
	public void setAddress(int address) {
		this.address = address;
	}
	
	public String getBinary() {
		int address;
		
		if (!isNumeric(getText())) {
			address = table.getValue(getText());
		} else {
			address = Integer.parseInt(getText());
		}
		
		String binaryAddress = Integer.toBinaryString(address);
		return ("0000000000000000" + binaryAddress).substring(binaryAddress.length());
	}
	
	private boolean isNumeric(String str) { 
		try {  
			Integer.parseInt(str);  
			return true;
		} catch(NumberFormatException e){  
			return false;  
		}  
	}
	
	private int address;
	private SymbolTable table;
}
