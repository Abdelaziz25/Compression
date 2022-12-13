package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class DictionaryFrequency {
    public HashMap<ArrayList<String>, Integer> frequncy(ArrayList<Byte> BytesOfFile, int n) {
        HashMap<ArrayList<String>, Integer> characters = new LinkedHashMap<>();
        ArrayList<String> bytesOfFile = new ArrayList<>();
        for (int i = 0; i < BytesOfFile.size(); i++) {
            if (bytesOfFile.size() < n) {
                bytesOfFile.add(String.valueOf(BytesOfFile.get(i)));
            }
            if (bytesOfFile.size() == n || i == BytesOfFile.size() - 1) {
                if (characters.containsKey(bytesOfFile)) {
                    int index = characters.get(bytesOfFile);
                    characters.replace(bytesOfFile, index + 1);
                } else {
                    characters.put(bytesOfFile, 1);
                }
                bytesOfFile = new ArrayList<>();
            }
        }
        return characters;
    }
}
