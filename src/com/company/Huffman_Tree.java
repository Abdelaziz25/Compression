package com.company;

import java.util.ArrayList;


public class Huffman_Tree {
    ArrayList<String> key;
    Integer value;
    Huffman_Tree left;
    Huffman_Tree right;

    Huffman_Tree(ArrayList<String> key, Integer value) {
        this.key = key;
        this.value = value;
        right = null;
        left = null;
    }
}
