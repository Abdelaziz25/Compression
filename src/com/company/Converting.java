package com.company;

import java.util.*;

public class Converting {
    public HashMap<byte[], String> convertToArrayByte(HashMap<ArrayList<String>, Integer> FrequencyTable) {
        HashMap<byte[], String> ByteFrequencyTable = new LinkedHashMap<>();
        Iterator iterator = FrequencyTable.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            Integer value = (Integer) me2.getValue();
            ArrayList<String> Temp = new ArrayList<>();
            Temp = (ArrayList<String>) me2.getKey();
            byte x = 0;
            byte[] temp = new byte[Temp.size()];
            for (int i = 0; i < Temp.size(); i++) {
                x = Byte.parseByte(Temp.get(i));
                temp[i] = x;
            }
            ByteFrequencyTable.put(temp, String.valueOf(value));
        }
        return ByteFrequencyTable;
    }

    public HashMap<ArrayList<String>, String> ConvertArrayByteToString(HashMap<byte[], String> ByteFrequency) {
        HashMap<ArrayList<String>, String> FrequencyTable = new LinkedHashMap<>();
        Iterator iterator = ByteFrequency.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator.next();
            byte[] Temp = (byte[]) me2.getKey();
            String value = String.valueOf(me2.getValue());
            ArrayList<String> temp = new ArrayList<>();
            for (int i = 0; i < Temp.length; i++) {
                temp.add(String.valueOf(Temp[i]));
            }
            FrequencyTable.put(temp, String.valueOf(value));
        }
        return FrequencyTable;
    }

    public String convertByteToString(ArrayList<Byte> BytesOfFile) {
        StringBuilder binaryOfBytesFile = new StringBuilder();
        int len = BytesOfFile.get(BytesOfFile.size() - 1);
        for (int i = 0; i < BytesOfFile.size() - 1; i++) {
            System.out.println(i);
            if (i != BytesOfFile.size() - 2) {
                binaryOfBytesFile.append(String.format("%8s", Integer.toString(BytesOfFile.get(i) & 0xFF, 2)).replace(' ', '0'));
            } else {
                String temp = String.format("%8s", Integer.toString(BytesOfFile.get(i) & 0xFF, 2)).replace(' ', '0');
                boolean flag = false;
                if (len < 8) {
                    for (int k = temp.length() - 1; k >= 0; k--) {
                        System.out.println("there");
                        if (flag == true) {
                            binaryOfBytesFile.append(temp.substring(0, k + 1));
                            break;
                        }
                        if (temp.charAt(k) == '1') {
                            flag = true;
                        }
                    }
                } else {
                    binaryOfBytesFile.append(temp);
                }
            }

        }
        return binaryOfBytesFile.toString();
    }
}
