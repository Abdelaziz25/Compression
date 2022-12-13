package com.company;

public class PathName {
    public String path(String filename, int n) {
        int Temp = filename.lastIndexOf("\\");
        String Path = filename.substring(0, Temp + 1);
        String filename2 = filename.substring(Temp + 1);
        String id = "19015941." + n + ".";
        String last = ".hc";
        String file = id + filename2 + last;
        String newpath = Path + file;
        return newpath;
    }

    public String Path(String path) {
        int Temp = path.lastIndexOf("\\");
        String file = path.substring(0, Temp + 1);
        String name = path.substring(Temp + 1);
        int Temp2 = name.lastIndexOf(".");
        String temp = name.substring(0, Temp2);
        int Temp3 = temp.lastIndexOf(".");
        String filename = temp.substring(Temp3);
        String Newfiles = temp.substring(0, Temp3);
        int Temp4 = Newfiles.lastIndexOf(".");
        String last = Newfiles.substring(Temp4);
        String extracted = "extracted";
        String NewFile = extracted + last + filename;
        String Path = file + NewFile;
        return Path;
    }
}
