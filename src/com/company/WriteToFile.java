package com.company;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WriteToFile {
    public void write(BufferedOutputStream bufferOutput, HashMap<ArrayList<String>, String> CodeOFfrequency, ArrayList<Byte> DividedNbytes, int n) throws IOException {
        StringBuilder Temp = new StringBuilder();
        ArrayList<String> helping = new ArrayList<>();
        for (int i = 0; i < DividedNbytes.size(); i++) {
            if (helping.size() < n) {
                helping.add(String.valueOf(DividedNbytes.get(i)));
            }
            if (helping.size() == n || i == DividedNbytes.size() - 1) {
                Temp.append(CodeOFfrequency.get(helping));
                if (Temp.length() == 8) {
                    byte x = (byte) Integer.parseInt(Temp.toString(), 2);
                    bufferOutput.write(x);
                    Temp = new StringBuilder();
                } else if (Temp.length() > 8) {
                    String Temp2 = Temp.substring(0, 8);
                    String Temp3 = Temp.substring(8);
                    Temp = new StringBuilder(Temp3);
                    byte x = (byte) Integer.parseInt(Temp2, 2);
                    bufferOutput.write(x);
                }
                helping = new ArrayList<>();
            }
        }
        if (Temp.length() <= 8 && !Temp.toString().equals("")) {
            int h = 0;
            int len = Temp.length();
            while (Temp.length() != 8) {
                if (h == 0) {
                    Temp.append("1");
                    h++;
                } else {
                    Temp.append("0");
                }
            }
            byte x = (byte) Integer.parseInt(Temp.toString(), 2);
            bufferOutput.write(x);
            bufferOutput.write(Integer.parseInt(String.valueOf(len)));
        } else if (Temp.length() > 8) {
            String Temp2 = Temp.substring(0, 8);
            StringBuilder Temp3 = new StringBuilder(Temp.substring(8));
            int len = Temp3.length();
            byte x = (byte) Integer.parseInt(Temp2, 2);
            bufferOutput.write(x);
            int h = 0;
            while (Temp3.length() != 8) {
                if (h == 0) {
                    Temp3.append("1");
                    h++;
                } else {
                    Temp3.append("0");
                }
            }
            x = (byte) Integer.parseInt(Temp3.toString(), 2);
            bufferOutput.write(x);
            bufferOutput.write(Integer.parseInt(String.valueOf(len)));
        }
        bufferOutput.close();
    }

    public void WriteDecompsedFile(ArrayList<ArrayList<String>> DecomposedFile, BufferedOutputStream bufferOutput) throws IOException {
        for (int i = 0; i < DecomposedFile.size(); i++) {
            byte x;
            ArrayList<String> WriteTofile = DecomposedFile.get(i);
            for (int k = 0; k < WriteTofile.size(); k++) {
                x = Byte.parseByte(WriteTofile.get(k));
                bufferOutput.write(x);
            }
        }
        bufferOutput.close();
    }
}
