package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
    public ArrayList<Byte> readfile(String filename) {
        ArrayList<Byte> BytesOfFile = new ArrayList<>();
        try ( FileInputStream fileInput = new FileInputStream(filename);
              BufferedInputStream bufferInput = new BufferedInputStream(fileInput)) {
            int Temp;
            while ((Temp = bufferInput.read()) != -1) {
                BytesOfFile.add((byte) Temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BytesOfFile;
    }

    public ArrayList<Byte> readByte(BufferedInputStream bufferInput) throws IOException {
        ArrayList<Byte> BytesOfFile = new ArrayList<>();
        int Temp;
        while ((Temp = bufferInput.read()) != -1) {
            BytesOfFile.add((byte) Temp);
        }
        return BytesOfFile;
    }
}
