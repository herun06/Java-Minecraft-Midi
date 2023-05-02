/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadAndWriteXFHerunConfig
{
    private static Map<String, String> map;

    private ReadAndWriteXFHerunConfig()
    {
    }

    public static Map<String, String>  read(File file)
    {
        map = new HashMap<>();
        String s = ReadTextFile.readAllToString(file);
        return startSplit(s);
    }

    public static Map<String, String>  read(String file)
    {
        return read(new File(file));
    }

    private static Map<String, String> startSplit(String text)
    {
        ArrayList<Integer> hkhIndex = new ArrayList<>();
        ArrayList<String> blockArrayList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c == '{') hkhIndex.add(i);
            if (c == '}') hkhIndex.add(i);
        }
        for (int i = 0; i < hkhIndex.size(); i += 2)
        {
            int startIndex = hkhIndex.get(i) + 1;
            int endIndex = hkhIndex.get(i + 1);
            String result = text.substring(startIndex, endIndex);
            blockArrayList.add(result);
        }

        // 解析每一个用花括号的配置
        for (int i = 0; i < blockArrayList.size(); i++)
        {
            ArrayList<String> spanArrayList = new ArrayList<>();
            String chunkBlockString = blockArrayList.get(i);
            int start = 0;
            int end = 0;
            int count = 0;
            for (int j = 0; j < chunkBlockString.length(); j++)
            {
                char c = chunkBlockString.charAt(j);
                if (c == ';')
                {
                    end = j;
                    String result = chunkBlockString.substring(start, end);
                    spanArrayList.add(result);
                    count++;
                }
                if (count != 0) start = end + 1;
            }

            for (int j = 0; j < spanArrayList.size(); j++)
            {
                // 开始分割等号左右边的字符
                String lineConfigContent = spanArrayList.get(j);
                int eqPos = -1;
                int eqCount = 0;
                for (int k = 0; k < lineConfigContent.length(); k++)
                {
                    char c = lineConfigContent.charAt(k);
                    if (c == '=')
                    {
                        eqPos = k;
                        eqCount++;
                    }
                }
                if (eqCount == 1)
                {
                    if (eqPos != -1)
                    {
                        String keyNameTemp = lineConfigContent.substring(0, eqPos);
                        String keyValueTemp = lineConfigContent.substring(eqPos + 1, lineConfigContent.length());
                        ArrayList<Integer> keyNameIndex = new ArrayList<>();
                        ArrayList<Integer> keyValueIndex = new ArrayList<>();
                        for (int c1 = 0; c1 < keyNameTemp.length(); c1++)
                        {
                            char c = keyNameTemp.charAt(c1);
                            if (c == '"') keyNameIndex.add(c1);
                        }
                        for (int c2 = 0; c2 < keyValueTemp.length(); c2++)
                        {
                            char c = keyValueTemp.charAt(c2);
                            if (c == '"') keyValueIndex.add(c2);
                        }
                        if (keyNameIndex.size() == 2 && keyValueIndex.size() == 2)
                        {
                            int keyNameIndexLeft = keyNameIndex.get(i) + 1;
                            int keyNameIndexRight = keyNameIndex.get(i + 1);
                            int keyValueIndexLeft = keyValueIndex.get(i) + 1;
                            int keyValueIndexRight = keyValueIndex.get(i + 1);
                            String keyName = keyNameTemp.substring(keyNameIndexLeft, keyNameIndexRight);
                            String keyValue = keyValueTemp.substring(keyValueIndexLeft, keyValueIndexRight);
                            map.put(keyName, keyValue);
                        }
                    }
                }
            }
        }
        return map;
    }
}
