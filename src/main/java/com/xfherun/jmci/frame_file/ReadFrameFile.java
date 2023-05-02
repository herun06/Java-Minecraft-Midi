/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.frame_file;

import com.xfherun.xflog.XFLog;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class ReadFrameFile
{
    private ReadFrameFile()
    {
    }

    private static String getFileType(File file)
    {
        XFLog.info("获取文件的类型: " + file.getAbsolutePath());
        String fileString = file.toString();
        int dotPos = -1;
        for (int i = 0; i < fileString.length(); i++)
        {
            char c = fileString.charAt(i);
            if (c == '.') dotPos = i;
        }
        if (dotPos != -1)
        {
            XFLog.info("文件类型: " + fileString.substring(dotPos, fileString.length()));
            return fileString.substring(dotPos, fileString.length());
        }
        else
        {
            XFLog.info("文件类型: null");
            return null;
        }
    }

    private static String fillZero(int num, int lengrh)
    {
        XFLog.info("补零操作: " + num + ", " + lengrh);
        String n = String.valueOf(num);
        int len = lengrh - n.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) stringBuilder.append("0");
        XFLog.info("结果: " + stringBuilder.toString() + num);
        return stringBuilder.toString() + num;
    }

    public static String show2(String jmciFileData)
    {
        return jmciFileData;
    }

    public static ArrayList<String> show(String jmciFileData)
    {
        XFLog.info("显示帧JMCi文件: " + jmciFileData);
        StringBuilder hexShow = new StringBuilder();
        ArrayList<String> charHex = new ArrayList<>();
        ArrayList<String> block = new ArrayList<>();
        int hexLength = 2;
        for (int i = 0; i < jmciFileData.length(); i++)
        {
            char c = jmciFileData.charAt(i);
            String hex = Integer.toHexString(c);
            if (hex.length() != hexLength)
            {
                StringBuilder stringBuilder = new StringBuilder();
                int len = hexLength - hex.length();
                for (int j = 0; j < len; j++) stringBuilder.append("0");
                hex = (stringBuilder.toString() + hex);
            }
            charHex.add(hex);
        }
        int col = 0;
        int col2 = 0;
        int intLength = 10;
        int c = 0;
        int currentIndex = 0;
        int blockIndex = 0;
        hexShow.append("").append(fillZero(c, intLength)).append("    ");
        for (int i = 0; i < charHex.size(); i++, c++, blockIndex++)
        {
            String hex = charHex.get(i);
            if (col < 8)
            {
                if (col != (4 - 1))
                {
                    hexShow.append("").append(hex).append(" ");
                    col++;
                }
                else
                {
                    hexShow.append("").append(hex).append(" ");
                    col++;
                }
            }
            else
            {
                hexShow.append("").append(hex).append("    ");
                for (int j = 0; j < 8; j++, currentIndex++)
                {
                    if (j < 7)
                    {
                        hexShow.append(String.valueOf(jmciFileData.charAt(currentIndex)).replace("\n", ".").replace("\r", ".").replace("\t", "."));
                        col2++;
                    }
                    else
                        hexShow.append(String.valueOf(jmciFileData.charAt(currentIndex)).replace("\n", ".").replace("\r", ".").replace("\t", ".")).append("\n").append(fillZero((c + 1), intLength)).append("    ");
                }
                col = 0;
            }
            if (blockIndex > 500)
            {
                block.add(hexShow.toString());
                hexShow = new StringBuilder();
                blockIndex = 0;
            }
        }
        int lastIndex = 8 - (col - 1);
        if (lastIndex != 0)
        {
            for (int i = 0; i < lastIndex; i++)
            {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < hexLength; j++) sb.append("0");
                if (i < (lastIndex - 1)) hexShow.append(sb.toString() + " ");
                else hexShow.append(sb.toString());
            }
            hexShow.append("" + "    ");
            for (int j = 0; j < 8; j++, currentIndex++)
            {
                if (j < 7)
                {
                    hexShow.append(String.valueOf(jmciFileData.charAt(currentIndex)).replace("\n", ".").replace("\r", ".").replace("\t", "."));
                    col2++;
                }
                else
                    hexShow.append(String.valueOf(jmciFileData.charAt(currentIndex)).replace("\n", ".").replace("\r", ".").replace("\t", "."));
            }
            block.add(hexShow.toString());
        }
        XFLog.info("Result: " + block);
        return block;
    }
}
