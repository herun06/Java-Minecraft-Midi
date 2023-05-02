/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.xfherun.xflog.XFLog;
import sun.net.www.protocol.file.FileURLConnection;

public class FileUtil
{
    public static void loadRecourseFromJarByFolder(String folderPath, String targetFolderPath, Class clazz) throws IOException
    {
        XFLog.info("loadRecourseFromJarByFolder();");
        URL url = clazz.getResource(folderPath);
        URLConnection urlConnection = url.openConnection();
        if (urlConnection instanceof FileURLConnection)
        {
            copyFileResources(url, folderPath, targetFolderPath, clazz);
        }
        else if (urlConnection instanceof JarURLConnection)
        {
            copyJarResources((JarURLConnection) urlConnection, folderPath, targetFolderPath, clazz);
        }
    }

    private static void copyFileResources(URL url, String folderPath, String targetFolderPath, Class clazz) throws IOException
    {
        XFLog.info("copyFileResources();");
        File root = new File(url.getPath());
        if (root.isDirectory())
        {
            File[] files = root.listFiles();
            for (File file : files)
            {
                if (file.isDirectory())
                {
                    loadRecourseFromJarByFolder(folderPath + "/" + file.getName(), targetFolderPath, clazz);
                }
                else
                {
                    loadRecourseFromJar(folderPath + "/" + file.getName(), folderPath, clazz);
                }
            }
        }
    }

    private static void copyJarResources(JarURLConnection jarURLConnection, String folderPath, String targetFolderPath, Class clazz) throws IOException
    {
        XFLog.info("copyJarResources();");
        JarFile jarFile = jarURLConnection.getJarFile();
        Enumeration<JarEntry> entrys = jarFile.entries();
        while (entrys.hasMoreElements())
        {
            JarEntry entry = entrys.nextElement();
            if (entry.getName().startsWith(jarURLConnection.getEntryName()) && !entry.getName().endsWith("/"))
            {
                loadRecourseFromJar("/" + entry.getName(), targetFolderPath, clazz);
            }
        }
        jarFile.close();
    }

    public static void loadRecourseFromJar(String path, String recourseFolder, Class clazz) throws IOException
    {
        XFLog.info("loadRecourseFromJar();");
        XFLog.info("申请缓存空间: " + path);
        if (!path.startsWith("/"))
        {
            XFLog.warn("The path has to be absolute (start with '/').");
            throw new IllegalArgumentException("The path has to be absolute (start with '/').");
        }

        if (path.endsWith("/"))
        {
            XFLog.warn("The path has to be absolute (cat not end with '/').");
            throw new IllegalArgumentException("The path has to be absolute (cat not end with '/').");
        }

        int index = path.lastIndexOf('/');

        String filename = path.substring(index + 1);
        String folderPath = recourseFolder + path.substring(0, index + 1);

        // If the folder does not exist yet, it will be created. If the folder
        // exists already, it will be ignored
        File dir = new File(folderPath);
        if (!dir.exists())
        {
            dir.mkdirs();
        }

        // If the file does not exist yet, it will be created. If the file
        // exists already, it will be ignored
        filename = folderPath + filename;
        File file = new File(filename);

        if (!file.exists() && !file.createNewFile())
        {
            XFLog.warn("create file :{} failed .fileName:" + filename);
            throw new RuntimeException("create file :{} failed .fileName:" + filename);
        }

        // Prepare buffer for data copying
        byte[] buffer = new byte[1024];
        int readBytes;

        // Open and check input stream
        URL url = clazz.getResource(path);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();

        if (is == null)
        {
            XFLog.warn("File " + path + " was not found inside JAR.");
            throw new FileNotFoundException("File " + path + " was not found inside JAR.");
        }
        OutputStream os = new FileOutputStream(file);
        try
        {
            while ((readBytes = is.read(buffer)) != -1)
            {
                os.write(buffer, 0, readBytes);
            }
        }
        finally
        {
            os.close();
            is.close();
        }
    }
}