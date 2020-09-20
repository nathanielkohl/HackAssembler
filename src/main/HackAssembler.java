package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HackAssembler {
	
	public static void main(String[] args) {
		File[] files = {new File("Add.asm"), new File("Max.asm"), new File("Pong.asm"), new File("Rect.asm")};
		
		for (File file : files) {
			String filename = file.getName().split("\\.")[0];
			
			Code c = new Code(file);
			
			ArrayList<String> binaryLines = c.translate();
			
			FileWriter writer;
			try {
				writer = new FileWriter(filename + ".hack");
				for (String line : binaryLines) {
					writer.write(line + System.lineSeparator());
				}
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
