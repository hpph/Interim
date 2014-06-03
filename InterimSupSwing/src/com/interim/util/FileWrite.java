package com.interim.util;

import java.io.*;

public class FileWrite {
        public static void writeToFile(String text, String file, String charSplit) {
                try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
                                        file), true));
                        
                        String[] texts = text.split(charSplit);
                        for(String line : texts){ 
                        	line.replace(charSplit,"");
	                        bw.write(line);
	                        bw.newLine();
                        }
                        bw.close();
                } catch (Exception e) {
                }
        }

}