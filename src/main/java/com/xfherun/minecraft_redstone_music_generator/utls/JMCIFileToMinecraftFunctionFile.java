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
import main.java.com.xfherun.jmci.utils.CompileMIDISourceFileTool;
import main.java.com.xfherun.jmci.utils.FileUtil;
import main.java.com.xfherun.jmci.utils.Sleep;
import main.java.com.xfherun.jmci.utils.WriteFile;
import main.java.com.xfherun.minecraft_redstone_music_generator.thread.UpdateWindow2;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.ProgressBarWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.ClickedConnect;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JMCIFileToMinecraftFunctionFile
{
    private static Thread runnable;

    private JMCIFileToMinecraftFunctionFile()
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

    public static void startRead(final File file, final File root2, String name, String mcp, String mainTitle, String subTitle)
    {
        File root = new File(root2 + "/xfherun_redstone_music");
        runnable = new Thread()
        {
            public void run()
            {
                XFLog.info("开始创建存档");
                File newFile2 = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    FileUtil.loadRecourseFromJar("/main/resources/run/saves/xfherun.zip", newFile2.toString(), JMCIFileToMinecraftFunctionFile.class);
                }
                catch (Exception e)
                {
                    String str = "存档添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }
                XFLog.info("创建存档缓存区");
                File saveFile = new File("cache/resources_cache/main/resources/run/saves/xfherun.zip").getAbsoluteFile();
                try
                {
                    XFLog.info("文件: " + saveFile + (!saveFile.exists() ? "不存在" : "存在"));
                    File copyTo = new File("cache/space/" + name + "/saves/" + name + ".zip").getAbsoluteFile();
                    Files.copy(Path.of(saveFile.toString()), Path.of(copyTo.toString()));

                    XFLog.info("解压存档");
                    ZipUtil.unZip(new File("cache/space/" + name + "/saves/" + name + ".zip").getAbsoluteFile(), String.valueOf(new File("cache/space/" + name + "/saves").getAbsoluteFile()));
                    boolean b = new File("cache/space/" + name + "/saves/xfherun").getAbsoluteFile().renameTo(new File("cache/space/" + name + "/saves/" + name).getAbsoluteFile());
                    if (b)
                    {
                        XFLog.info("重名成功: " + new File("cache/space/" + name + "/saves/xfherun").getAbsoluteFile() + " :: " + new File("cache/space/" + name + "/saves/" + name).getAbsoluteFile());
                        XFLog.info("清除缓存");
                        File temp = new File("cache/space/" + name + "/saves/" + name + ".zip").getAbsoluteFile();
                        if (temp.delete()) XFLog.info("缓存文件清除成功！");
                        else XFLog.info("缓存文件清除失败, 可能没有该缓存！");
                    }
                    else
                    {
                        XFLog.info("重名失败: " + new File("cache/space/" + name + "/saves/xfherun").getAbsoluteFile() + " :: " + new File("cache/space/" + name + "/saves/" + name).getAbsoluteFile());
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "存档创建失败！ 生成失败！", "错误", 0);
                        return;
                    }
                }
                catch (IOException e)
                {
                    XFLog.warn("存档创建失败！", e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "存档创建失败！ 生成失败！", "错误", 0);
                    return;
                }

                boolean mkdirs = root.mkdirs();
                if (mkdirs) XFLog.info("存档创建成功");
                else
                {
                    XFLog.warn("存档创建失败！", new RuntimeException("File: " + root.getAbsoluteFile() + " create fail."));
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "存档创建失败！ 生成失败！", "错误", 0);
                    return;
                }
                XFLog.info("开始读取JMCI文件: " + file);
                ArrayList<ArrayList<String[]>> arrayLists = StartReadJMCIFileContentData.JNI_OPEN(file);
                XFLog.info("开始写入文件");
                for (int xfy = 0; xfy < arrayLists.size(); xfy++)
                {
                    ArrayList<String[]> arrayList = arrayLists.get(xfy);
                    if (xfy > 0)
                    {
                        StringBuilder stringBuilder = new StringBuilder();
                        File mcfunctionFile = new File(root + "/" + xfy + ".mcfunction");
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
                            stringBuilder.append("gamerule gameLoopFunction xfherun_redstone_music:none").append("\n").append("tickrate 20.0");
                            WriteFile.writeStringToFile(mcfunctionFile.getAbsolutePath(), stringBuilder.toString(), "UTF-8");
                        }
                        int bfb = (int) ((double) xfy / (double) arrayLists.size() * 100.0);
                        XFLog.info("写入进度: " + bfb + "%");
                        ProgressBarWindow.updateProgress("写入进度: " + bfb + "%", bfb);
                    }
                    else
                    {
                        String[] strings = arrayList.get(0);
                        double tick = Double.parseDouble(strings[1]);
                        XFLog.info("写入入口文件: " + root2 + "/main");
                        File mainFile = new File(root2 + "/main");
                        File mainFile2 = new File(root2 + "/main/start.mcfunction");
                        File mainFile3 = new File(root2 + "/main/stop.mcfunction");
                        File mainFile4 = new File(root2 + "/main/song_attr.mcfunction");
                        XFLog.debug("Command: tickrate " + tick);
                        mainFile.mkdirs();
                        WriteFile.writeStringToFile(mainFile2.getAbsolutePath(), "tickrate " + tick + "\ntitle @a title {\"text\":\"" + mainTitle + "\",\"color\":\"blue\"}\ntitle @a subtitle {\"text\":\"" + subTitle + "\",\"color\":\"yellow\"}\ngamerule gameLoopFunction xfherun_redstone_music:1", "UTF-8");
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder clearAll = new StringBuilder();
                        clearAll.append("function build_piano_keys:destroy_piano_keys").append("\n").append("function build_piano_keys:build_piano_keys").append("\n").append("tickrate 20.0");
                        for (int channel = 0; channel < 16; channel++)
                            for (int pitch = 0; pitch < 128; pitch++)
                                stringBuilder.append("midiout noteclose " + channel + " " + pitch + " 0").append("\n");
                        WriteFile.writeStringToFile(mainFile3.getAbsolutePath(), "gamerule gameLoopFunction none\n" + stringBuilder + "\n" + clearAll, "UTF-8");
                        StringBuilder sb = new StringBuilder();
                        sb.append("say @a [xfherun-jmci-to-jmcp-jmcs]: song name -> " + mainTitle).append("\n");
                        sb.append("say @a [xfherun-jmci-to-jmcp-jmcs]: song tickrate -> " + tick).append("\n");
                        sb.append("say @a [xfherun-jmci-to-jmcp-jmcs]: song generator author -> xfherun::何润").append("\n");
                        WriteFile.writeStringToFile(mainFile4.getAbsolutePath(), sb.toString(), "UTF-8");
                    }
                }

                XFLog.info("文件写入完毕！");
                ProgressBarWindow.updateProgress("文件写入完毕!", 99);

                XFLog.info("添加模组中...");
                ProgressBarWindow.updateProgress("添加模组中...", 99);
                File newFile = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    /*FileUtil.loadRecourseFromJar("/main/resources/run/mods/aperture-1.7-devHexA-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/BetterFps-1.4.8.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/BiomesOPlenty-1.12.2-7.0.1.2445-universal.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/chameleon-1.1.1-devHexA.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/ChickenChunks-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/chiselsandbits-14.17.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/CodeChickenLib-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/commander-1.1-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/CubicChunks-1.12.2-0.0.1208.0-SNAPSHOT-all.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/CubicWorldGen-1.12.2-0.0.152.0-SNAPSHOT-all.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/decorative-1.0.0.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/DrZharks+MoCreatures+Mod-12.0.5.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/emoticons-1.0.2-1.12.2-dist.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/extendedreach-1.1-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/ExtendPolyphonyLimit-1.3-for1.8-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/furniture-6.3.1-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/horror_untitled_map-1.0.0.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/Keystrokes-7.0 (1.12.2).jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/Logger-1.2.1.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/malisiscore-1.12.2-6.5.1.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/malisisdoors-1.12.2-7.3.0.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/mcdl-1.0.0.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/mclib-2.3.6-devHexA-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/mdxlib-3.0.0.20.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/metamorph-1.2.12-devHexA-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/Midi Out.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/midic-1.0.0.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/OpenEye.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/OptiFine_1.12.2_HD_U_F5.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/pianoblock1.0.0-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/replaymod-1.12.2-2.5.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/TEST.py", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/thutcore-1.12.2-5.16.3.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/thuttech-1.12.2-6.0.16.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                    FileUtil.loadRecourseFromJar("/main/resources/run/mods/TickrateChanger-Mod-1.12.2.jar", newFile.toString(), JMCIFileToMinecraftFunctionFile.class);*/
                    // ArrayList<String> arrayList = ForJarResources.for_("run/mods");
                    ArrayList<String> arrayList = new ArrayList<>();
                    String path = "/main/resources/run/mods/";
                    arrayList.add(path + "BetterFps-1.4.8.jar");
                    arrayList.add(path + "ChickenChunks-1.12.2.jar");
                    arrayList.add(path + "CodeChickenLib-1.12.2.jar");
                    arrayList.add(path + "ExtendPolyphonyLimit-1.3-for1.8-1.12.2.jar");
                    arrayList.add(path + "Midi Out.jar");
                    arrayList.add(path + "OptiFine_1.12.2_HD_U_F5.jar");
                    arrayList.add(path + "TEST.py");
                    arrayList.add(path + "TickrateChanger-Mod-1.12.2.jar");
                    if (arrayList == null)
                    {
                        String str = "模组添加失败!, 因为 \" arrayList \" is null";
                        XFLog.warn(str);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }
                    else for (String s : arrayList)
                    {
                        FileUtil.loadRecourseFromJar(s, newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                        XFLog.info("添加模组: " + s.replace("\\", "/").substring(s.lastIndexOf("/") + 1));
                    }
                }
                catch (Exception e)
                {
                    String str = "模组添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }

                File[] modFiles = new File("cache/resources_cache/main/resources/run/mods").getAbsoluteFile().listFiles();
                double zong = modFiles.length;
                ProgressBarWindow.updateProgress("创建模组进度: " + 0 + "%", 0);
                for (int i = 0; i < modFiles.length; i++)
                {
                    File modFile = modFiles[i];
                    try
                    {
                        String fileType = modFile.toString().substring(modFile.toString().length() - 4, modFile.toString().length());
                        if (fileType.equalsIgnoreCase(".jar"))
                        {
                            File copyTo = new File("cache/space/" + name + "/mods/" + modFile.getName()).getAbsoluteFile();
                            Files.copy(Path.of(modFile.toString()), Path.of(copyTo.toString()));
                        }
                        else XFLog.warn("未知文件: " + modFile + " 无法添加。。。。");
                    }
                    catch (IOException e)
                    {
                        XFLog.warn("模组创建失败！", e);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "模组创建失败！ 生成失败！", "错误", 0);
                        return;
                    }
                    int bfb = (int) ((double) i / (double) zong * 100.0);
                    XFLog.info("创建模组进度: " + bfb + "%");
                    ProgressBarWindow.updateProgress("创建模组进度: " + bfb + "%", bfb);
                }
                XFLog.info("模组添加成功^_^!!!");

                XFLog.info("清空缓存");
                deleteDir("cache/resources_cache/main");

                XFLog.info("添加材质包中...");
                ProgressBarWindow.updateProgress("添加材质包中...", 99);

                XFLog.info("获取材质包链接....");
                File newFile3 = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    FileUtil.loadRecourseFromJar("/main/resources/run/resourcepacks/xfherun_piano_resources.zip", newFile3.toString(), JMCIFileToMinecraftFunctionFile.class);
                }
                catch (IOException e)
                {
                    String str = "材质包添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }

                XFLog.info("开始创建材质包缓存空间");
                File resourceFiles = new File("cache/resources_cache/main/resources/run/resourcepacks/xfherun_piano_resources.zip").getAbsoluteFile();
                File copyTo = new File("cache/space/" + name + "/resourcePacks/" + resourceFiles.getName()).getAbsoluteFile();
                try
                {
                    Files.copy(Path.of(resourceFiles.toString()), Path.of(copyTo.toString()));
                }
                catch (IOException e)
                {
                    String str = "材质包添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }
                ProgressBarWindow.updateProgress("添加完毕... 开始压缩", 99);

                XFLog.info("清空缓存");
                deleteDir("cache/resources_cache/main");

                XFLog.info("最后的操作");
                try
                {
                    CompressDirUtil.compressFileToZip("cache/space/" + name);
                }
                catch (Exception e)
                {
                    XFLog.warn("压缩文件失败！", e);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "压缩文件失败, 生成失败！",
                            "警告", 2);
                    return;
                }

                File mcr = new File(mcp + "/JMCI_JMCP");
                File srcFile = new File(mcr + "/" + name + ".zip").getAbsoluteFile();
                XFLog.info("扫描是否有相同的文件");
                if (!srcFile.exists())
                {
                    XFLog.info("发现文件不存在: " + srcFile);
                    if (!mcr.exists()) mcr.mkdirs();
                    try
                    {
                        Files.copy(Path.of("cache/space/" + name + ".zip"), Path.of(mcr.toString() + "/" + name + ".zip"));
                    }
                    catch (Exception e)
                    {
                        XFLog.warn("创建失败！", e);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "创建失败, 生成失败！",
                                "警告", 2);
                        return;
                    }

                    XFLog.info("添加成功......");
                    ProgressBarWindow.updateProgress("添加成功", 100);

                    XFLog.info("清空缓存");
                    clearCaches();

                    String str = "生成成功！保存在: {0}" + new File(mcr + "/" + name + ".zip").getAbsoluteFile().getAbsolutePath();
                    XFLog.info(str.replace("{0}", ""));
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            str.replace("{0}", "\n"), "提示", 1);
                }
                else
                {
                    XFLog.info("发现文件存在: " + srcFile);
                    String str = "发现文件冲突: {0}" + srcFile + "{1}是否要替换？";
                    XFLog.warn(str.replace("{0}", "").replace("{1}", ""));
                    int option = JOptionPane.showConfirmDialog(MainWindow.getMainWindow(),
                            str.replace("{0}", "\n").replace("{1}", "\n"),
                            "警告", 0, 2);
                    if (option == 0)
                    {
                        XFLog.info("替换原有的文件: " + srcFile);
                        XFLog.info("删除文件: " + srcFile);
                        boolean delete = srcFile.delete();
                        if (delete) XFLog.info("文件: " + srcFile + "删除完毕!");
                        else XFLog.warn("文件: " + srcFile + "删除失败!");
                        if (!mcr.exists()) mcr.mkdirs();
                        try
                        {
                            Files.copy(Path.of("cache/space/" + name + ".zip"), Path.of(mcr.toString() + "/" + name + ".zip"));
                        }
                        catch (Exception e)
                        {
                            XFLog.warn("创建失败！", e);
                            clearCaches();
                            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "创建失败, 生成失败！",
                                    "警告", 2);
                            return;
                        }

                        XFLog.info("添加成功......");
                        ProgressBarWindow.updateProgress("添加成功", 100);

                        XFLog.info("清空缓存");
                        clearCaches();

                        String str2 = "生成成功！保存在: {0}" + new File(mcr + "/" + name + ".zip").getAbsoluteFile().getAbsolutePath();
                        XFLog.info(str2.replace("{0}", ""));
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                str2.replace("{0}", "\n"), "提示", 1);
                    }
                    else
                    {
                        XFLog.info("清空缓存");
                        clearCaches();

                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "取消创建, 生成失败！",
                                "警告", 2);
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

    public static void startRead2(final File file, final File root2, String name, String mcp, String mainTitle, String subTitle)
    {
        File root = new File(root2 + "/xfherun_redstone_music");
        runnable = new Thread()
        {
            public void run()
            {
                XFLog.info("开始创建存档");
                File newFile2 = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    FileUtil.loadRecourseFromJar("/main/resources/run/saves/xfherun.zip", newFile2.toString(), JMCIFileToMinecraftFunctionFile.class);
                }
                catch (Exception e)
                {
                    String str = "存档添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }
                XFLog.info("创建存档缓存区");
                File saveFile = new File("cache/resources_cache/main/resources/run/saves/xfherun.zip").getAbsoluteFile();
                try
                {
                    XFLog.info("文件: " + saveFile + (!saveFile.exists() ? "不存在" : "存在"));
                    File copyTo = new File("cache/space/" + name + "/saves/" + name + ".zip").getAbsoluteFile();
                    Files.copy(Path.of(saveFile.toString()), Path.of(copyTo.toString()));

                    XFLog.info("解压存档");
                    ZipUtil.unZip(new File("cache/space/" + name + "/saves/" + name + ".zip").getAbsoluteFile(), String.valueOf(new File("cache/space/" + name + "/saves").getAbsoluteFile()));
                    boolean b = new File("cache/space/" + name + "/saves/xfherun").getAbsoluteFile().renameTo(new File("cache/space/" + name + "/saves/" + name).getAbsoluteFile());
                    if (b)
                    {
                        XFLog.info("重名成功: " + new File("cache/space/" + name + "/saves/xfherun").getAbsoluteFile() + " :: " + new File("cache/space/" + name + "/saves/" + name).getAbsoluteFile());
                        XFLog.info("清除缓存");
                        File temp = new File("cache/space/" + name + "/saves/" + name + ".zip").getAbsoluteFile();
                        if (temp.delete()) XFLog.info("缓存文件清除成功！");
                        else XFLog.info("缓存文件清除失败, 可能没有该缓存！");
                    }
                    else
                    {
                        XFLog.info("重名失败: " + new File("cache/space/" + name + "/saves/xfherun").getAbsoluteFile() + " :: " + new File("cache/space/" + name + "/saves/" + name).getAbsoluteFile());
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "存档创建失败！ 生成失败！", "错误", 0);
                        return;
                    }
                }
                catch (IOException e)
                {
                    XFLog.warn("存档创建失败！", e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "存档创建失败！ 生成失败！", "错误", 0);
                    return;
                }

                boolean mkdirs = root.mkdirs();
                if (mkdirs) XFLog.info("存档创建成功");
                else
                {
                    XFLog.warn("存档创建失败！", new RuntimeException("File: " + root.getAbsoluteFile() + " create fail."));
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "存档创建失败！ 生成失败！", "错误", 0);
                    return;
                }
                XFLog.info("开始读取JMCI文件: " + file);
                ArrayList<ArrayList<String[]>> arrayLists = StartReadJMCIFileContentData.JNI_OPEN(file);
                XFLog.info("开始写入文件");
                for (int xfy = 0; xfy < arrayLists.size(); xfy++)
                {
                    ArrayList<String[]> arrayList = arrayLists.get(xfy);
                    if (xfy > 0)
                    {
                        StringBuilder stringBuilder = new StringBuilder();
                        File mcfunctionFile = new File(root + "/" + xfy + ".mcfunction");
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
                            stringBuilder.append("gamerule gameLoopFunction xfherun_redstone_music:xfherun_redstone_music/" + (xfy + 1)).append("\n");
                            WriteFile.writeStringToFile(mcfunctionFile.getAbsolutePath(), stringBuilder.toString(), "UTF-8");
                        }
                        else
                        {
                            stringBuilder.append("gamerule gameLoopFunction none").append("\n").append("tickrate 20.0").append("\n");
                            WriteFile.writeStringToFile(mcfunctionFile.getAbsolutePath(), stringBuilder.toString(), "UTF-8");
                        }
                        int bfb = (int) ((double) xfy / (double) arrayLists.size() * 100.0);
                        XFLog.info("写入进度: " + bfb + "%");
                        ProgressBarWindow.updateProgress("写入进度: " + bfb + "%", bfb);
                    }
                    else
                    {
                        String[] strings = arrayList.get(0);
                        double tick = Double.parseDouble(strings[1]);
                        XFLog.info("写入入口文件: " + root2 + "/main");
                        File mainFile = new File(root2 + "/main");
                        File mainFile2 = new File(root2 + "/main/start.mcfunction");
                        File mainFile3 = new File(root2 + "/main/stop.mcfunction");
                        File mainFile4 = new File(root2 + "/main/song_attr.mcfunction");
                        XFLog.debug("Command: tickrate " + tick);
                        mainFile.mkdirs();
                        WriteFile.writeStringToFile(mainFile2.getAbsolutePath(), "tickrate " + tick + "\ntitle @a title {\"text\":\"" + mainTitle + "\",\"color\":\"blue\"}\ntitle @a subtitle {\"text\":\"" + subTitle + "\",\"color\":\"yellow\"}\ngamerule gameLoopFunction xfherun_redstone_music:xfherun_redstone_music/1", "UTF-8");
                        StringBuilder stringBuilder = new StringBuilder();
                        StringBuilder clearAll = new StringBuilder();
                        clearAll.append("function build_piano_keys:destroy_piano_keys").append("\n").append("function build_piano_keys:build_piano_keys").append("\n").append("tickrate 20.0");
                        for (int channel = 0; channel < 16; channel++)
                            for (int pitch = 0; pitch < 128; pitch++)
                                stringBuilder.append("midiout noteclose " + channel + " " + pitch + " 0").append("\n");
                        WriteFile.writeStringToFile(mainFile3.getAbsolutePath(), "gamerule gameLoopFunction none\n" + stringBuilder + "\n" + clearAll, "UTF-8");
                        StringBuilder sb = new StringBuilder();
                        sb.append("say @a [xfherun-jmci-to-jmcp-jmcs]: song name -> " + mainTitle).append("\n");
                        sb.append("say @a [xfherun-jmci-to-jmcp-jmcs]: song tickrate -> " + tick).append("\n");
                        sb.append("say @a [xfherun-jmci-to-jmcp-jmcs]: song generator author -> xfherun::何润").append("\n");
                        WriteFile.writeStringToFile(mainFile4.getAbsolutePath(), sb.toString(), "UTF-8");
                    }
                }

                XFLog.info("文件写入完毕！");
                ProgressBarWindow.updateProgress("文件写入完毕!", 99);

                XFLog.info("添加模组中...");
                ProgressBarWindow.updateProgress("添加模组中...", 99);
                File newFile = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    // ArrayList<String> arrayList = ForJarResources.for_("run/mods");
                    ArrayList<String> arrayList = new ArrayList<>();
                    String path = "/main/resources/run/mods/";
                    arrayList.add(path + "BetterFps-1.4.8.jar");
                    arrayList.add(path + "ChickenChunks-1.12.2.jar");
                    arrayList.add(path + "CodeChickenLib-1.12.2.jar");
                    arrayList.add(path + "ExtendPolyphonyLimit-1.3-for1.8-1.12.2.jar");
                    arrayList.add(path + "Midi Out.jar");
                    arrayList.add(path + "OptiFine_1.12.2_HD_U_F5.jar");
                    arrayList.add(path + "TEST.py");
                    arrayList.add(path + "TickrateChanger-Mod-1.12.2.jar");
                    if (arrayList == null)
                    {
                        String str = "模组添加失败!, 因为 \" arrayList \" is null";
                        XFLog.warn(str);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }
                    else for (String s : arrayList)
                    {
                        FileUtil.loadRecourseFromJar(s, newFile.toString(), JMCIFileToMinecraftFunctionFile.class);
                        XFLog.info("添加模组: " + s.replace("\\", "/").substring(s.lastIndexOf("/") + 1));
                    }
                }
                catch (IOException e)
                {
                    String str = "模组添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }

                File[] modFiles = new File("cache/resources_cache/main/resources/run/mods").getAbsoluteFile().listFiles();
                double zong = modFiles.length;
                ProgressBarWindow.updateProgress("创建模组进度: " + 0 + "%", 0);
                for (int i = 0; i < modFiles.length; i++)
                {
                    File modFile = modFiles[i];
                    try
                    {
                        String fileType = modFile.toString().substring(modFile.toString().length() - 4, modFile.toString().length());
                        if (fileType.equalsIgnoreCase(".jar"))
                        {
                            File copyTo = new File("cache/space/" + name + "/mods/" + modFile.getName()).getAbsoluteFile();
                            Files.copy(Path.of(modFile.toString()), Path.of(copyTo.toString()));
                        }
                        else XFLog.warn("未知文件: " + modFile + " 无法添加。。。。");
                    }
                    catch (IOException e)
                    {
                        XFLog.warn("模组创建失败！", e);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "模组创建失败！ 生成失败！", "错误", 0);
                        return;
                    }
                    int bfb = (int) ((double) i / (double) zong * 100.0);
                    XFLog.info("创建模组进度: " + bfb + "%");
                    ProgressBarWindow.updateProgress("创建模组进度: " + bfb + "%", bfb);
                }
                XFLog.info("模组添加成功^_^!!!");

                XFLog.info("清空缓存");
                deleteDir("cache/resources_cache/main");

                XFLog.info("添加材质包中...");
                ProgressBarWindow.updateProgress("添加材质包中...", 99);

                XFLog.info("获取材质包链接....");
                File newFile3 = new File("cache/resources_cache").getAbsoluteFile();
                try
                {
                    FileUtil.loadRecourseFromJar("/main/resources/run/resourcepacks/xfherun_piano_resources.zip", newFile3.toString(), JMCIFileToMinecraftFunctionFile.class);
                }
                catch (IOException e)
                {
                    String str = "材质包添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }

                XFLog.info("开始创建材质包缓存空间");
                File resourceFiles = new File("cache/resources_cache/main/resources/run/resourcepacks/xfherun_piano_resources.zip").getAbsoluteFile();
                File copyTo = new File("cache/space/" + name + "/resourcePacks/" + resourceFiles.getName()).getAbsoluteFile();
                try
                {
                    Files.copy(Path.of(resourceFiles.toString()), Path.of(copyTo.toString()));
                }
                catch (IOException e)
                {
                    String str = "材质包添加失败！生成失败";
                    XFLog.warn(str, e);
                    clearCaches();
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                    return;
                }
                ProgressBarWindow.updateProgress("添加完毕... 开始压缩", 99);

                XFLog.info("清空缓存");
                deleteDir("cache/resources_cache/main");

                XFLog.info("最后的操作");
                try
                {
                    CompressDirUtil.compressFileToZip("cache/space/" + name);
                }
                catch (Exception e)
                {
                    XFLog.warn("压缩文件失败！", e);
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "压缩文件失败, 生成失败！",
                            "警告", 2);
                    return;
                }

                File mcr = new File(mcp + "/JMCI_JMCP");
                File srcFile = new File(mcr + "/xfmc_" + name + ".jmcs").getAbsoluteFile();
                XFLog.info("扫描是否有相同的文件");
                if (!srcFile.exists())
                {
                    XFLog.info("发现文件不存在: " + srcFile);
                    if (!mcr.exists()) mcr.mkdirs();
                    try
                    {
                        Files.copy(Path.of("cache/space/" + name + ".zip"), Path.of(mcr.toString() + "/xfmc_" + name + ".jmcs"));
                    }
                    catch (Exception e)
                    {
                        XFLog.warn("创建失败！", e);
                        clearCaches();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "创建失败, 生成失败！",
                                "警告", 2);
                        return;
                    }

                    XFLog.info("添加成功......");
                    ProgressBarWindow.updateProgress("添加成功", 100);

                    XFLog.info("清空缓存");
                    clearCaches();

                    String str = "生成成功！保存在: {0}" + new File(mcr + "/" + name + ".jmcs").getAbsoluteFile().getAbsolutePath();
                    XFLog.info(str.replace("{0}", ""));
                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            str.replace("{0}", "\n"), "提示", 1);
                }
                else
                {
                    XFLog.info("发现文件存在: " + srcFile);
                    String str = "发现文件冲突: {0}" + srcFile + "{1}是否要替换？";
                    XFLog.warn(str.replace("{0}", "").replace("{1}", ""));
                    int option = JOptionPane.showConfirmDialog(MainWindow.getMainWindow(),
                            str.replace("{0}", "\n").replace("{1}", "\n"),
                            "警告", 0, 2);
                    if (option == 0)
                    {
                        XFLog.info("替换原有的文件: " + srcFile);
                        XFLog.info("删除文件: " + srcFile);
                        srcFile.delete();
                        XFLog.info("文件: " + srcFile + "删除完毕!");
                        if (!mcr.exists()) mcr.mkdirs();
                        try
                        {
                            Files.copy(Path.of("cache/space/" + name + ".zip"), Path.of(mcr.toString() + "/xfmc_" + name + ".jmcs"));
                        }
                        catch (Exception e)
                        {
                            XFLog.warn("创建失败！", e);
                            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "创建失败, 生成失败！",
                                    "警告", 2);
                            return;
                        }

                        XFLog.info("添加成功......");
                        ProgressBarWindow.updateProgress("添加成功", 100);

                        XFLog.info("清空缓存");
                        clearCaches();

                        String str2 = "生成成功！保存在: {0}" + new File(mcr + "/" + name + ".jmcs").getAbsoluteFile().getAbsolutePath();
                        XFLog.info(str2.replace("{0}", ""));
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                str2.replace("{0}", "\n"), "提示", 1);
                    }
                    else
                    {
                        XFLog.info("清空缓存");
                        clearCaches();

                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "取消创建, 生成失败！",
                                "警告", 2);
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
