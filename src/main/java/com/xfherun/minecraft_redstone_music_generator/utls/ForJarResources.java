/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ForJarResources
{
    private ForJarResources()
    {
    }

    public static ArrayList<String> for_(String dir)
    {
        XFLog.info("开始遍历文件目录: " + dir);
        ArrayList<String> list = new ArrayList<>();

        ClassLoader loader = ForJarResources.class.getClassLoader();
        InputStream input = loader.getResourceAsStream("main/resources/" + dir);
        assert input != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        XFLog.info("loader -> " + loader);
        XFLog.info("input -> " + input);
        XFLog.info("reader -> " + reader);

        String line;
        try
        {
            while ((line = reader.readLine()) != null)
            {
                String file = "main/resources/" + dir + "/" + line;
                list.add(file);
                XFLog.info("搜索到的文件: " + file);
            }
        }
        catch (Exception e)
        {
            XFLog.err("", e);
        }
        if (list.size() != 0) return list;
        else return null;
    }

    private static boolean isFile(String path)
    {
        int i = path.lastIndexOf(".");
        if (i == -1) return false;
        return true;
    }
}
