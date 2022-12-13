package com.company;

import java.util.ArrayList;

public class DivideArraytoNBytes {
    public ArrayList<ArrayList<String>> Divide(ArrayList<Byte> BytesOfFile, int n) {
        ArrayList<ArrayList<String>> DividedNbytes = new ArrayList<>();
        int j = 0;
        System.out.println(BytesOfFile.size());
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 0; i < BytesOfFile.size(); i++) {
            if (j < n) {
                temp.add(String.valueOf(BytesOfFile.get(i)));
                j++;
            } else {
                j = 0;
                DividedNbytes.add(temp);
                temp = new ArrayList<>();
                temp.add(String.valueOf(BytesOfFile.get(i)));
                if (i == BytesOfFile.size() - n) {
                    DividedNbytes.add(temp);
                }
                j++;
            }
        }
        return DividedNbytes;
    }
}
