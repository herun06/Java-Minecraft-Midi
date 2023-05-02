/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.utils.ReadTextFile;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.list.ListAction;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReadJMCPFile
{
    private static String[] keyword = {
            "@project_name",
            "@file_name",
            "@create_time",
            "@update_time",
            "@minecraft_path",
            "@jmci_path",
            "@jmci_title",
            "@jmci_subtitle",
            "@minecraft_function_name"
    };

    private ReadJMCPFile()
    {
    }

    public static void read(File filePath)
    {
        XFLog.info("开始读取JMCP工程文件: " + filePath.getAbsolutePath());
        String strings = ReadTextFile.readAllToString(filePath);
        ArrayList<String> lineCommand = new ArrayList<>();
        int temp_start = 0;
        int temp_end = 0;
        int temp_count = 0;
        for (int i = 0; i < strings.length(); i++)
        {
            char c = strings.charAt(i);
            if (c == ';')
            {
                temp_end = i;
                String temp = strings.substring(temp_start, temp_end);
                lineCommand.add(temp);
                temp_count++;
            }
            if (temp_count != 0) temp_start = temp_end + 1;
        }

        ArrayList<String[]> map = new ArrayList<>();
        for (int i = 0; i < lineCommand.size(); i++)
        {
            String xfy_119 = lineCommand.get(i);
            int pos = -1;
            int count = 0;
            for (int j = 0; j < xfy_119.length(); j++)
            {
                char c = xfy_119.charAt(j);
                if (c == '=')
                {
                    pos = j;
                    count++;
                }
            }
            if (count == 1)
                if (pos != -1)
                {
                    String keyName = xfy_119.substring(0, pos);
                    String keyValue = xfy_119.substring(pos + 1, xfy_119.length());
                    String[] arr = {keyName, keyValue};
                    map.add(arr);
                }
        }
        Map<String, String> map2 = new HashMap<>();
        for (int i = 0; i < map.size(); i++)
        {
            String[] kva = map.get(i);
            String keyName = kva[0];
            String keyValue = kva[1];
            for (int j = 0; j < keyword.length; j++)
            {
                if (keyName.equalsIgnoreCase(keyword[j]))
                {
                    map2.put(keyName, keyValue);
                    break;
                }
            }
        }
        XFLog.info("读取完毕, 开始整理内容");
        String at_project_name = map2.get("@project_name");
        String at_file_name = map2.get("@file_name");
        String at_create_time = map2.get("@create_time");
        String at_update_time = map2.get("@update_time");
        String at_minecraft_path = map2.get("@minecraft_path");
        String at_jmci_path = map2.get("@jmci_path");
        String at_jmci_title = map2.get("@jmci_title");
        String at_jmci_subtitle = map2.get("@jmci_subtitle");
        String at_minecraft_function_name = map2.get("@minecraft_function_name");
        if (at_file_name.equalsIgnoreCase(filePath.getName().substring(0, filePath.getName().indexOf("."))))
        {
            XFLog.info("整理完毕, 开始将项添加至列表");
            Object[] datas = new Object[]
                    {
                            at_project_name,
                            filePath.getName().substring(0, filePath.getName().indexOf(".")),
                            at_create_time,
                            at_update_time,
                            at_minecraft_path,
                            at_jmci_path,
                            at_jmci_title,
                            at_jmci_subtitle,
                            at_minecraft_function_name,
                            filePath
                    };
            MainWindow.updateSaveList(
                    datas,
                    at_project_name, filePath.getName().substring(0, filePath.getName().indexOf(".")), at_create_time, at_update_time, new ListAction()
                    {
                        @Override
                        public void accept(int buttonType)
                        {
                            if (buttonType == 0)
                            {
                                XFLog.info("准备打开工程: " + at_project_name + ", 路径: " + filePath.getAbsolutePath());
                                try
                                {
                                    boolean run = OpenJMCPFileAndReadToWindow.run(datas);
                                    if (run)
                                    {
                                        XFLog.info("工程: " + at_project_name + " 打开完毕！");
                                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "工程: " + at_project_name + " 打开成功！", "提示", 1);
                                    }
                                    else
                                    {
                                        XFLog.warn("工程: " + at_project_name + " 打开失败！");
                                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "工程: " + at_project_name + " 打开失败！", "警告", 2);
                                    }
                                }
                                catch (Exception e)
                                {
                                    XFLog.warn("工程: " + at_project_name + " 打开失败！", e);
                                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "工程: " + at_project_name + " 打开失败！", "警告", 2);
                                }
                            }
                            if (buttonType == 1)
                            {
                                XFLog.info("准备打开工程: " + at_project_name + ", 路径: " + filePath.getAbsolutePath());
                                String str = "你确定要删除该工程吗？ \n名称: '" + at_project_name + "'\n路径: '" + filePath.getAbsolutePath() + "'";
                                String str2 = "该工程已删除 \n名称: '" + at_project_name + "'\n路径: '" + filePath.getAbsolutePath() + "'";
                                XFLog.info(str);
                                int option = JOptionPane.showConfirmDialog(MainWindow.getMainWindow(),
                                        str, "警告", 2);
                                if (option == 0)
                                {
                                    boolean delete = filePath.delete();
                                    if (delete)
                                    {
                                        XFLog.info(str2);
                                        XFLog.info("成功删除工程: " + at_project_name + ", 路径: " + filePath.getAbsolutePath());
                                        MainWindow.updateJMCP();
                                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str2, "提示", 1);
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "文件: " + filePath + " 删除失败！", "提示", 2);
                                        XFLog.info("文件: " + filePath + " 删除失败！");
                                    }
                                }
                            }
                        }
                    }
            );
            XFLog.info("项添加完毕！返回值: Success");
        }
        else XFLog.warn("文件添加失败, 可能这个文件: " + filePath.getAbsolutePath() + " 已被更改或损坏！");
    }
}
