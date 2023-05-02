package main.java.com.xfherun.jmci.utils;

import java.io.*;

public class WriteFile {
    private WriteFile() {
    }

    public static void writeTextFile(File filePath, String text) {
        writeStringToFile(String.valueOf(filePath), text, "UTF-8");
    }

    public static boolean writeStringToFile(String fileName, String content, String enc) {
        File file = new File(fileName);

        try {
            OutputStreamWriter os = null;
            if (enc == null || enc.length() == 0) {
                os = new OutputStreamWriter(new FileOutputStream(file));
            } else {
                os = new OutputStreamWriter(new FileOutputStream(file), enc);
            }
            os.write(content);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
