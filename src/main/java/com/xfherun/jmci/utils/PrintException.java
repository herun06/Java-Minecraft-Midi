package main.java.com.xfherun.jmci.utils;

import java.io.*;
import java.util.ArrayList;

public class PrintException {
    private PrintException() {
    }

    public static String getException(Throwable e, String version) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String rr = sw.toString();
        File file = new File("__cache__");
        if (!file.mkdirs()) if (file.mkdirs()) ;
        WriteFile.writeStringToFile("__cache__/error.dat", rr, "UTF-8");
        ArrayList<String> list = null;
        if (new File("__cache__/error.dat").exists()) {
            list = ReadTextFile.readAll(new File("__cache__/error.dat"));
            new File("__cache__/error.dat").deleteOnExit();
        }
        int indexArray = 4;
        String className = "";
        StackTraceElement stackTraceElement = null;
        if (version == null) version = "?";
        else if (version.equals("")) version = "?";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            try {
                stackTraceElement = Thread.currentThread().getStackTrace()[indexArray];
                className = stackTraceElement.getFileName();
            } catch (Exception ex) {
                className = "?";
            }
            String rrr = " ~[" + className + ":" + version + "]";
            if (i < (list.size() - 1)) {
                int stringIndex = list.get(i).indexOf("\tat ");
                if (stringIndex != - 1) sb.append(list.get(i)).append(rrr).append("\n");
                else sb.append(list.get(i)).append("\n");
            }
            else {
                int stringIndex = list.get(i).indexOf("\tat ");
                if (stringIndex != -1) sb.append(list.get(i)).append(rrr);
                else sb.append(list.get(i));
            }
        }
        // System.err.println(sb);
        return sb.toString();
    }
}
