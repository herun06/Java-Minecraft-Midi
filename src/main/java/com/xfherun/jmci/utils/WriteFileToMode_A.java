/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WriteFileToMode_A
{
    public static void write(String path, String encoding)
    {
        String filePath = path;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 1; i <= 1000; i++)
        {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("key_" + i, "value_" + i);
            list.add(map);
        }
        try
        {
            File file = new File(filePath);
            FileOutputStream fos = null;
            if (!file.exists())
            {
                file.createNewFile();
                fos = new FileOutputStream(file);
            }
            else
            {
                fos = new FileOutputStream(file, true);
            }
            OutputStreamWriter osw = new OutputStreamWriter(fos, encoding);

            for (Map<String, Object> map : list)
            {
                for (Map.Entry<String, Object> entry : map.entrySet())
                {
                    String str = entry.getKey() + "=" + entry.getValue();
                    osw.write(str + ",");
                }
                osw.write("\r\n");
            }
            osw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
