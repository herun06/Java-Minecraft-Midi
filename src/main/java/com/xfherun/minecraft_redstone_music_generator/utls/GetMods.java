/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.utils.FileUtil;
import main.java.com.xfherun.jmci.utils.Sleep;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GetMods
{
    private static JDialog jDialog;
    private static JLabel iLoveFireman;

    private GetMods()
    {
    }

    private static void init()
    {
        jDialog = new JDialog();
        jDialog.setTitle("准备中...");
        jDialog.setSize(400, 200);
        jDialog.setLayout(null);
        jDialog.setLocationRelativeTo(MainWindow.getMainWindow());
        jDialog.setResizable(false);
        jDialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        iLoveFireman = new JLabel("准备中...");
        iLoveFireman.setBounds(0, 0, jDialog.getWidth() - 16, jDialog.getHeight() - 39);
        iLoveFireman.setOpaque(true);
        iLoveFireman.setBackground(new Color(45, 45, 45, 255));
        iLoveFireman.setForeground(Color.decode("#eeeeee"));
        iLoveFireman.setFont(new Font("新宋体", 0, 15));
        iLoveFireman.setVerticalAlignment(SwingConstants.CENTER);
        iLoveFireman.setHorizontalAlignment(SwingConstants.CENTER);
        jDialog.getContentPane().add(iLoveFireman);

        jDialog.setModal(true);
        jDialog.setVisible(true);
    }

    private static void updateProgress(String message)
    {
        if (jDialog != null)
        {
            jDialog.setTitle(message);
            iLoveFireman.setText(message);
            XFLog.debug(message);
        }
    }

    private static void closeWindow()
    {
        if (jDialog != null)
        {
            jDialog.setVisible(false);
            MainWindow.setIsRunJMCSFile(true);
        }
    }

    private static void last()
    {
        updateProgress("完成！");
        Sleep.sleep(new Random().nextInt(1000, 2345));
    }

    private static void deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if (file.isFile())
        {
            file.delete();
            XFLog.info("已删除: " + file);
        }
        else
        {
            File[] files = file.listFiles();
            if (files == null)
            {
                file.delete();
                XFLog.info("已删除: " + file);
            }
            else
            {
                for (int i = 0; i < files.length; i++) deleteDir(files[i].getAbsolutePath());
                file.delete();
                XFLog.info("已删除: " + file);
            }
        }
    }

    private static void clearAllCaches()
    {
        XFLog.info("清除缓存");
        File cache = new File("cache/resources_cache/main/resources/run/close_the_mods").getAbsoluteFile();
        deleteDir(String.valueOf(cache));
        XFLog.info("缓存清除成功");
    }

    private static String[] getFileTypeAndName(String name)
    {
        return new String[]{name.substring(0, name.lastIndexOf(".")), name.substring(name.lastIndexOf("."))};
    }

    public static void getAll(final ArrayList<String> arrayList, final File saveFile)
    {
        Thread runnable = new Thread()
        {
            public void run()
            {
                XFLog.info("开始提取");
                ArrayList<String> mods = new ArrayList<>();
                File newFile = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    for (String modPath : arrayList)
                    {
                        String fileName = modPath.replace("\\", "/").substring(modPath.lastIndexOf("/") + 1);
                        if (getFileTypeAndName(fileName)[1].equalsIgnoreCase(".jar"))
                        {
                            FileUtil.loadRecourseFromJar(modPath, newFile.toString(), GetMods.class);
                            mods.add(fileName);
                            updateProgress("提取模组: " + fileName);
                            XFLog.info("提取的模组: " + fileName);
                        }
                        else XFLog.info("无效的文件: " + fileName);
                    }
                }
                catch (IOException e)
                {
                    String str = "";
                    XFLog.warn(str, e);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "警告", 2);
                    updateProgress("清除缓存");
                    clearAllCaches();
                    last();
                    closeWindow();
                    return;
                }
                XFLog.info("提取成功, 开始压缩");
                updateProgress("提取成功, 开始压缩");
                File[] modFiles = new File[mods.size()];
                for (int i = 0; i < mods.size(); i++)
                {
                    String fileName = mods.get(i);
                    modFiles[i] = new File("cache/resources_cache/main/resources/run/close_the_mods/" + fileName).getAbsoluteFile();
                }
                boolean flag = CompressDirUtil.addMultipleFilesToThePackage(saveFile, modFiles);
                if (flag)
                {
                    XFLog.info("模组提取成功, 保存至: " + saveFile);
                    updateProgress("清除缓存");
                    clearAllCaches();
                    last();
                    closeWindow();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "模组提取成功, 保存至: " + saveFile,
                            "提示", 1);
                }
                else
                {
                    XFLog.info("模组提取失败");
                    updateProgress("清除缓存");
                    clearAllCaches();
                    last();
                    closeWindow();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "模组提取失败",
                            "警告", 2);
                }
            }
        };
        runnable.start();
        init();
    }
}
