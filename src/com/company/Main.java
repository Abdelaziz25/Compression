package com.company;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        if (args[0].equals("c")) {
            double Start = System.currentTimeMillis();
            String filename = args[1];
            ReadFile read = new ReadFile();
            ArrayList<Byte> BytesOfFile = new ArrayList<>();
            BytesOfFile = read.readfile(filename);
            int n = Integer.parseInt(args[2]);
            PathName makepathname = new PathName();
            String newpath = makepathname.path(filename, n);
            HashMap<ArrayList<String>, Integer> FrequencyTable = new LinkedHashMap<>();
            DictionaryFrequency Frequency = new DictionaryFrequency();
            FrequencyTable = Frequency.frequncy(BytesOfFile,n);
            HashMap<byte[], String> ByteFrequencyTable = new LinkedHashMap<>();
            Converting convert = new Converting();
            ByteFrequencyTable = convert.convertToArrayByte(FrequencyTable);
            File myobj = new File(newpath);
            BufferedOutputStream bufferOutput = null;
            FileOutputStream fileOutput = new FileOutputStream(myobj);
            ObjectOutputStream objectOutputstream = new ObjectOutputStream(fileOutput);
            objectOutputstream.writeObject(ByteFrequencyTable);
            BuildHuffmanTree BuildTree = new BuildHuffmanTree();
            HashMap<ArrayList<String>, String> CodeOFfrequency = new HashMap<>();
            CodeOFfrequency = BuildTree.BuildTree(FrequencyTable);
            bufferOutput = new BufferedOutputStream(fileOutput);
            WriteToFile write = new WriteToFile();
            write.write(bufferOutput, CodeOFfrequency, BytesOfFile,n);
            double End = System.currentTimeMillis();
            double ExcutationTime = End - Start;
            System.out.println("Compression finish");
            System.out.println("Total Time in milliSeconds: " + ExcutationTime);
        } else if (args[0].equals("d")) {
            double Start = System.currentTimeMillis();
            File myobj = new File(args[1]);
            String path = args[1];
            PathName NewPathName = new PathName();
            String Path = NewPathName.Path(path);
            FileInputStream fileInput = new FileInputStream(myobj);
            ObjectInputStream objectInputstream = new ObjectInputStream(fileInput);
            BufferedInputStream bufferInput = new BufferedInputStream(fileInput);
            HashMap<byte[], String> ByteFrequency = new LinkedHashMap<>();
            ByteFrequency = (HashMap<byte[], String>) objectInputstream.readObject();
            HashMap<ArrayList<String>, String> FrequecnyTable = new LinkedHashMap<>();
            Converting convert = new Converting();
            FrequecnyTable = convert.ConvertArrayByteToString(ByteFrequency);
            System.out.println(FrequecnyTable);
            ArrayList<Byte> BytesOfFile = new ArrayList<>();
            ReadFile readbyte = new ReadFile();
            BytesOfFile = readbyte.readByte(bufferInput);
            Converting convert2 = new Converting();
            String binaryOfBytesFile = convert2.convertByteToString(BytesOfFile);
            System.out.println(binaryOfBytesFile);
            objectInputstream.close();
            File myobj2 = new File(Path);
            BufferedOutputStream bufferOutput = null;
            FileOutputStream fileOutput = new FileOutputStream(myobj2);
            bufferOutput = new BufferedOutputStream(fileOutput);
            ArrayList<ArrayList<String>> DecomposedFile = new ArrayList<>();
            BuildHuffmanTree buildTree = new BuildHuffmanTree();
            DecomposedFile = buildTree.BuildDecomposedTree(FrequecnyTable, binaryOfBytesFile);
            WriteToFile writeDecomposed = new WriteToFile();
            writeDecomposed.WriteDecompsedFile(DecomposedFile, bufferOutput);
            double End = System.currentTimeMillis();
            double ExcutationTime = End - Start;
            System.out.println("decompression finish");
            System.out.println("Total Time in milliSeconds: " + ExcutationTime);
        }
    }
}
