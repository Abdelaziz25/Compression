package com.company;

import java.util.*;

public class BuildHuffmanTree {
    public HashMap<ArrayList<String>, String> BuildTree(HashMap<ArrayList<String>, Integer> FrequencyTable) {
        PriorityQueue<Huffman_Tree> pQueue = new PriorityQueue<Huffman_Tree>(new Comparator<Huffman_Tree>() {
            @Override
            public int compare(Huffman_Tree o1, Huffman_Tree o2) {
                if (o1.value < o2.value) {
                    return -1;
                } else if (o1.value > o2.value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Iterator iterator = FrequencyTable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            Integer value = (Integer) me2.getValue();
            ArrayList<String> key = (ArrayList<String>) me2.getKey();
            Huffman_Tree newode = new Huffman_Tree(key, value);
            pQueue.add(newode);
        }
        operations hufmman_tree = new operations();
        while (pQueue.size() != 1) {
            Huffman_Tree node1 = pQueue.poll();
            Huffman_Tree node2 = pQueue.poll();
            ArrayList<String> sum2 = new ArrayList<>();
            sum2.addAll(node1.key);
            sum2.addAll(node2.key);
            Huffman_Tree newnode = new Huffman_Tree(sum2, node1.value + node2.value);
            newnode.left = node1;
            newnode.right = node2;
            pQueue.add(newnode);
        }
        HashMap<ArrayList<String>, String> CodeOfFrequency = new HashMap<>();
        CodeOfFrequency = hufmman_tree.BulidComposedCode(pQueue.poll(), FrequencyTable);
        return CodeOfFrequency;
    }

    public ArrayList<ArrayList<String>> BuildDecomposedTree(HashMap<ArrayList<String>, String> FrequencyTable, String binaryOfByteFile) {
        PriorityQueue<Huffman_Tree> pQueue = new PriorityQueue<Huffman_Tree>(new Comparator<Huffman_Tree>() {
            @Override
            public int compare(Huffman_Tree o1, Huffman_Tree o2) {
                if (o1.value < o2.value) {
                    return -1;
                } else if (o1.value > o2.value) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Iterator iterator = FrequencyTable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            ArrayList<String> key = (ArrayList<String>) me2.getKey();
            Integer value = Integer.parseInt((String) me2.getValue());
            Huffman_Tree newNode = new Huffman_Tree(key, value);
            pQueue.add(newNode);
        }
        operations hufmman_tree = new operations();
        while (pQueue.size() != 1) {
            Huffman_Tree node1 = pQueue.poll();
            Huffman_Tree node2 = pQueue.poll();
            ArrayList<String> sum = new ArrayList<>();
            sum.addAll(node1.key);
            sum.addAll(node2.key);
            Huffman_Tree newNode = new Huffman_Tree(sum, node1.value + node2.value);
            newNode.left = node1;
            newNode.right = node2;
            pQueue.add(newNode);
        }
        ArrayList<ArrayList<String>> DecomposedFile = new ArrayList<>();
        DecomposedFile = hufmman_tree.RetirevingBytes(pQueue.poll(), binaryOfByteFile);
        return DecomposedFile;
    }
}
