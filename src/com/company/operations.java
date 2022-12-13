package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class operations {
    HashMap<ArrayList<String>, Integer> CodeOFfrequency = new HashMap<>();
    HashMap<ArrayList<String>, String> HelpingArray = new HashMap<>();

    void inorder(Huffman_Tree temp, String Code) {
        if (temp == null)
            return;
        if (CodeOFfrequency.containsKey(temp.key) && CodeOFfrequency.containsValue(temp.value) && temp.left == null && temp.right == null) {
            this.HelpingArray.put(temp.key, Code);
        }
        inorder(temp.left, Code + "0");
        inorder(temp.right, Code + "1");
    }

    public HashMap<ArrayList<String>, String> BulidComposedCode(Huffman_Tree temp, HashMap<ArrayList<String>, Integer> FrequencyTable) {
        CodeOFfrequency = FrequencyTable;
        inorder(temp, "");
        return this.HelpingArray;
    }

    ArrayList<ArrayList<String>> RetirevingBytes(Huffman_Tree temp, String Code) {
        Huffman_Tree temp2 = temp;
        ArrayList<ArrayList<String>> DecomposedFile = new ArrayList<>();
        for (int i = 0; i < Code.length(); i++) {
            if (Code.charAt(i) == '0') {
                if (temp != null) {
                    temp = temp.left;
                    if (temp != null) {
                        if (temp.left == null && temp.right == null) {
                            ArrayList<String> Temp = new ArrayList<>();
                            Temp = temp.key;
                            DecomposedFile.add(Temp);
                            temp = temp2;
                        }
                    } else {
                        temp = temp2;
                    }
                } else {
                    temp = temp2;
                }
            } else if (Code.charAt(i) == '1') {
                if (temp != null) {
                    temp = temp.right;
                    if (temp != null) {
                        if (temp.left == null && temp.right == null) {
                            ArrayList<String> Temp = new ArrayList<>();
                            Temp = temp.key;
                            DecomposedFile.add(Temp);
                            temp = temp2;
                        }
                    } else {
                        temp = temp2;
                        temp = temp.right;
                    }

                } else {
                    temp = temp2;
                    temp = temp.right;
                }

            }

        }
        return DecomposedFile;
    }

}