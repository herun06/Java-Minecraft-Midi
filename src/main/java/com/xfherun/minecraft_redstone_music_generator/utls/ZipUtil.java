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
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ZipUtil
{
    public static void unZip(String sourceFilename, String targetDir) throws IOException
    {
        unZip(new File(sourceFilename), targetDir);
    }

    public static void unZip(File sourceFile, String targetDir) throws IOException
    {
        long start = System.currentTimeMillis();
        if (!sourceFile.exists())
        {
            throw new FileNotFoundException("cannot find the file = " + sourceFile.getPath());
        }
        ZipFile zipFile = null;
        try
        {
            zipFile = new ZipFile(sourceFile, Charset.forName("GBK"));
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements())
            {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                if (entry.isDirectory())
                {
                    String dirPath = targetDir + "/" + entry.getName();
                    createDirIfNotExist(dirPath);
                }
                else
                {
                    File targetFile = new File(targetDir + "/" + entry.getName());
                    createFileIfNotExist(targetFile);
                    InputStream is = null;
                    FileOutputStream fos = null;
                    try
                    {
                        is = zipFile.getInputStream(entry);
                        fos = new FileOutputStream(targetFile);
                        int len;
                        byte[] buf = new byte[1024];
                        while ((len = is.read(buf)) != -1)
                        {
                            fos.write(buf, 0, len);
                        }
                    }
                    finally
                    {
                        try
                        {
                            fos.close();
                        }
                        catch (Exception e)
                        {
                            XFLog.warn("close FileOutputStream exception", e);
                        }
                        try
                        {
                            is.close();
                        }
                        catch (Exception e)
                        {
                            XFLog.warn("close InputStream exception", e);
                        }
                    }
                }
            }
            XFLog.info("解压完成，耗时：" + (System.currentTimeMillis() - start) + " ms");
        }
        finally
        {
            if (zipFile != null)
            {
                try
                {
                    zipFile.close();
                }
                catch (IOException e)
                {
                    XFLog.warn("close zipFile exception", e);
                }
            }
        }
    }

    public static void createDirIfNotExist(String path)
    {
        File file = new File(path);
        createDirIfNotExist(file);
    }

    public static void createDirIfNotExist(File file)
    {
        if (!file.exists())
        {
            file.mkdirs();
        }
    }

    public static void createFileIfNotExist(File file) throws IOException
    {
        createParentDirIfNotExist(file);
        file.createNewFile();
    }

//    public static void createParentDirIfNotExist(String filename){
//        File file = new File(filename);
//        createParentDirIfNotExist(file);
//    }

    public static void createParentDirIfNotExist(File file)
    {
        createDirIfNotExist(file.getParentFile());
    }
}
