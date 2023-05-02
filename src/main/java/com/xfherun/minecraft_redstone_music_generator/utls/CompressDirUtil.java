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
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressDirUtil
{

    public static void zippark(String inputFile, String outputFile) throws IOException
    {
        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputFile));
        //创建缓存输出流
        BufferedOutputStream bos = new BufferedOutputStream(out);
        File input = new File(inputFile);
        compress(out, bos, input, null);
        bos.close();
        out.close();//要注意关闭流，不是会导致最终结果出现问题
    }

    public static void compress(ZipOutputStream out, BufferedOutputStream bos, File input, String name) throws IOException
    {
        if (name == null)
        {
            name = input.getName();
        }
        //如果输入的文件名称为文件夹,需要遍历里面的文件及文件夹下文件遍历;如果是文件就只需要将该文件进行压缩
        if (input.isDirectory())
        {
            File[] files = input.listFiles();

            if (files.length == 0)
            {//当该文件夹为空时,只需要将该目录存入压缩文件中即可
                out.putNextEntry(new ZipEntry(name + "/"));
            }
            else
            {
                for (int i = 0; i < files.length; i++)
                {
                    compress(out, bos, files[i], name + "/" + files[i].getName());
                }
            }
        }
        else
        {
            out.putNextEntry(new ZipEntry(name));
            FileInputStream fos = new FileInputStream(input);
            BufferedInputStream bis = new BufferedInputStream(fos);
            int len;
            byte[] bf = new byte[1024];
            while ((len = bis.read(bf)) != -1)
            {
                bos.write(bf, 0, len);
                bos.flush();
            }
            bis.close();
            fos.close();
        }
    }

    public static boolean compressFileToZip(String compresspath)
    {
        boolean bool = false;
        try
        {
            ZipOutputStream zipOutput = null;
            File file = new File(compresspath);
            if (file.isDirectory())
            {
                zipOutput = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(compresspath + ".zip")));
                compressZip(zipOutput, file, "");
            }
            else
            {
                zipOutput = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(compresspath.substring(0, compresspath.lastIndexOf(".")) + ".zip")));
                zipOFile(zipOutput, file);
            }
            zipOutput.closeEntry();
            zipOutput.close();
            bool = true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return bool;
    }

    private static void compressZip(ZipOutputStream zipOutput, File file, String suffixpath)
    {
        File[] listFiles = file.listFiles();
        for (File fi : listFiles)
        {
            if (fi.isDirectory())
            {
                if (suffixpath.equals(""))
                {
                    compressZip(zipOutput, fi, fi.getName());
                    XFLog.info("扫描文件或目录: " + fi.getAbsolutePath());
                }
                else
                {
                    compressZip(zipOutput, fi, suffixpath + File.separator + fi.getName());
                    XFLog.info("扫描文件或目录: " + fi.getAbsolutePath());
                }
            }
            else
            {
                zip(zipOutput, fi, suffixpath);
                XFLog.info("扫描文件或目录: " + fi.getAbsolutePath());
            }
        }
    }

    public static boolean addMultipleFilesToThePackage(File saveDir, File... files)
    {
        boolean flag = false;
        try
        {
            ZipOutputStream zipOutput = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(saveDir)));
            flag = addMultipleFilesToPackage(zipOutput, files, "");
        }
        catch (FileNotFoundException e)
        {
            XFLog.err("", e);
            return flag;
        }
        return flag;
    }

    private static boolean addMultipleFilesToPackage(ZipOutputStream zipOutput, File[] files, String suffixPath)
    {
        boolean flag = false;
        for (File file : files)
        {
            try
            {
                zip(zipOutput, file, suffixPath);
                XFLog.info("扫描文件或目录: " + file.getAbsolutePath());
                flag = true;
            }
            catch (Exception e)
            {
                XFLog.err("", e);
                return flag;
            }
        }
        return flag;
    }

    public static void zip(ZipOutputStream zipOutput, File file, String suffixpath)
    {
        try
        {
            ZipEntry zEntry = null;
            if (suffixpath.equals(""))
            {
                zEntry = new ZipEntry(file.getName());
            }
            else
            {
                zEntry = new ZipEntry(suffixpath + File.separator + file.getName());
            }
            zipOutput.putNextEntry(zEntry);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = bis.read(buffer)) != -1)
            {
                zipOutput.write(buffer, 0, read);
            }
            bis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void zipOFile(ZipOutputStream zipOutput, File file)
    {
        try
        {
            ZipEntry zEntry = new ZipEntry(file.getName());
            zipOutput.putNextEntry(zEntry);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            int read = 0;
            while ((read = bis.read(buffer)) != -1)
            {
                zipOutput.write(buffer, 0, read);
            }
            bis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}