/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.utils.FileUtil;
import main.java.com.xfherun.jmci.utils.Sleep;
import main.java.com.xfherun.jmci.utils.WriteFile;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.ProgressBarWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.ClickedConnect;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class JMCIFileToMinecraftFunctionOnesFile
{
    private static Thread runnable;

    private JMCIFileToMinecraftFunctionOnesFile()
    {
    }

    public static void deleteDir(String dirPath)
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

    public static void startRead(final File jmciFile, String name, File minecraftPath)
    {
        runnable = new Thread()
        {
            public void run()
            {
                XFLog.info("开始读取JMCI文件: " + jmciFile);
                ArrayList<ArrayList<String[]>> arrayLists = StartReadJMCIFileContentData.JNI_OPEN(jmciFile);
                XFLog.info("开始写入文件");
                for (int xfy = 0; xfy < arrayLists.size(); xfy++)
                {
                    ArrayList<String[]> arrayList = arrayLists.get(xfy);
                    if (xfy > 0)
                    {
                        StringBuilder stringBuilder = new StringBuilder();
                        File mcfunctionFile = new File("cache/space/" + name + "/xfherun_redstone_music/" + xfy + ".mcfunction");
                        for (int j = 0; j < arrayList.size(); j++)
                        {
                            String[] strings = arrayList.get(j);
                            for (int jjj = 0; jjj < strings.length; jjj++)
                            {
                                String string = strings[jjj];
                                if (!string.equals("NONE"))
                                {
                                    if (jjj < (strings.length - 1)) stringBuilder.append(string).append(" ");
                                    else stringBuilder.append(string).append("\n");
                                }
                            }
                            if (strings.length >= 4)
                                if (strings[1].equalsIgnoreCase("noteopen"))
                                    stringBuilder.append(MinecraftRedstoneMusicEffect.pianoKeyDownEffect(Integer.parseInt(strings[2]), Integer.parseInt(strings[3]))).append("\n");
                            if (strings.length >= 3)
                                if (strings[1].equalsIgnoreCase("noteclose"))
                                    stringBuilder.append(MinecraftRedstoneMusicEffect.pianoKeyUPEffect(Integer.parseInt(strings[3]))).append("\n");
                        }
                        if (xfy < (arrayLists.size() - 1))
                        {
                            stringBuilder.append("gamerule gameLoopFunction xfherun_redstone_music:" + (xfy + 1)).append("\n");
                            WriteFile.writeStringToFile(mcfunctionFile.getAbsolutePath(), stringBuilder.toString(), "UTF-8");
                        }
                        else
                        {
                            stringBuilder.append("gamerule gameLoopFunction xfherun_redstone_music:none").append("\n");
                            WriteFile.writeStringToFile(mcfunctionFile.getAbsolutePath(), stringBuilder.toString(), "UTF-8");
                        }
                        int bfb = (int) ((double) xfy / (double) arrayLists.size() * 100.0);
                        XFLog.info("写入进度: " + bfb + "%");
                        ProgressBarWindow.updateProgress("写入进度: " + bfb + "%", bfb);
                    }
                }
                XFLog.info("文件写入完毕！");
                ProgressBarWindow.updateProgress("文件写入完毕!", 99);

                XFLog.info("开始压缩");
                ProgressBarWindow.updateProgress("压缩中...", 99);
                CompressDirUtil.compressFileToZip(new File("cache/space/" + name).getAbsolutePath());
                XFLog.info("压缩完毕！");
                XFLog.info("最后的操作");
                ProgressBarWindow.updateProgress("最后的操作...", 99);
                XFLog.info("开始创建缓存空间");
                File nameFile = new File("cache/space/" + name + ".zip").getAbsoluteFile();
                File copyTo = new File(minecraftPath + "/JMCI_JMCP").getAbsoluteFile();
                if (!copyTo.exists()) copyTo.mkdirs();
                File tt = new File(copyTo + "/mcf_" + name + ".zip");
                Path of = Path.of(copyTo.toString() + "/mcf_" + name + ".zip");
                if (!tt.exists())
                {
                    try
                    {
                        Files.copy(Path.of(nameFile.toString()), of);
                    }
                    catch (IOException e)
                    {
                        XFLog.warn("创建失败！", e);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "创建失败, 生成失败！",
                                "警告", 2);
                        return;
                    }
                    XFLog.info("创建完毕！ 开始清空缓存");
                    ProgressBarWindow.updateProgress("清除缓存...", 99);
                    clearCaches();
                    String str1 = "生成成功！保存在: {0}" + new File(copyTo + "/mcf_" + name + ".zip").getAbsoluteFile().getAbsolutePath();
                    XFLog.info(str1.replace("{0}", ""));
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            str1.replace("{0}", "\n"), "提示", 1);
                }
                else
                {
                    XFLog.info("文件: " + tt + " 已存在, 是否要替换？");
                    int option = JOptionPane.showConfirmDialog(MainWindow.getMainWindow(), "文件: " + tt + " 已存在, 是否要替换？",
                            "警告", 0, 2);
                    if (option == 0)
                    {
                        XFLog.info("开始删除文件: " + tt);
                        tt.delete();
                        XFLog.info("文件: " + tt + "删除完毕！");
                        XFLog.info("开始创建.........");
                        try
                        {
                            Files.copy(Path.of(nameFile.toString()), of);
                        }
                        catch (IOException e)
                        {
                            XFLog.warn("创建失败！", e);
                            clearCaches();
                            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "创建失败, 生成失败！",
                                    "警告", 2);
                            return;
                        }
                        XFLog.info("创建完毕！ 开始清空缓存");
                        ProgressBarWindow.updateProgress("清除缓存...", 99);
                        clearCaches();
                        String str2 = "生成成功！保存在: {0}" + new File(copyTo + "/mcf_" + name + ".zip").getAbsoluteFile().getAbsolutePath();
                        XFLog.info(str2.replace("{0}", ""));
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                str2.replace("{0}", "\n"), "提示", 1);
                    }
                    else
                    {
                        XFLog.info("取消生成");
                        XFLog.info("删除缓存");
                        ProgressBarWindow.updateProgress("清除缓存...", 99);
                        clearCaches();
                        String str3 = "生成取消！ 生成失败!";
                        XFLog.info(str3.replace("{0}", ""));
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                str3.replace("{0}", "\n"), "警告", 2);
                    }
                }
            }
        };
        runnable.start();
        ProgressBarWindow.init(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                XFLog.info("开始终止生成");
                ProgressBarWindow.getPushButton().setEnabled(false);
                runnable.stop();
                XFLog.info("清除缓存");
                clearCaches();
                runnable = null;
                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                        "生成终止, 生成失败！",
                        "警告", 2);
            }
        });
    }

    private static void clearCaches()
    {
        ProgressBarWindow.updateProgress("清除缓存...", 99);
        clearAll();
        ProgressBarWindow.updateProgress("完成...", 100);
        Sleep.sleep(new Random().nextInt(1000, 3020));
        ProgressBarWindow.getMainWindow().setVisible(false);
    }

    public static void clearAll()
    {
        XFLog.info("清空缓存");
        deleteDir("cache/resources_cache/main");
        File[] space = new File("cache/space").listFiles();
        for (int i = 0; i < space.length; i++)
        {
            File file = space[i];
            if (file.isDirectory()) deleteDir(file.getAbsolutePath());
            else file.delete();
        }
        XFLog.info("完成！！！");
    }
}
