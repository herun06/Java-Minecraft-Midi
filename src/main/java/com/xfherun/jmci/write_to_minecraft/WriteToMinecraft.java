/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.write_to_minecraft;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_3;
import main.java.com.xfherun.jmci.utils.ReadTextFile;

import javax.swing.*;
import java.io.File;

public class WriteToMinecraft
{
    private static StringBuilder stringBuilder;

    private WriteToMinecraft()
    {
    }

    public static void write(final String minecraftRootPath, final String midiPath, final String title, final String subTitle, File jmciPath)
    {
        if (jmciPath == null)
        {
            XFLog.warn("没有选择JMCI文件或JMCI文件为空: null");
            JOptionPane.showMessageDialog(
                    MainWindow.getMainWindow(),
                    "没有选择JMCI文件或JMCI文件为空: null",
                    "警告", 2
            );
        }
        else
        {
            final String content = ReadTextFile.readAllToLine(jmciPath);
            if (content.equals(""))
            {
                XFLog.warn("没有选择JMCI文件或JMCI文件为空: null");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "没有选择JMCI文件或JMCI文件为空: null",
                        "警告", 2
                );
                return;
            }
            if (minecraftRootPath.equals(""))
            {
                XFLog.warn(".minecraft路径不能为空");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        ".minecraft路径不能为空",
                        "警告", 2);
                return;
            }
            if (midiPath.equals(""))
            {
                XFLog.warn("midi路径不能为空");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "midi路径不能为空",
                        "警告", 2);
                return;
            }
            if (title.equals(""))
            {
                XFLog.warn("标题不能为空");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "标题不能为空",
                        "警告", 2);
                return;
            }
            if (subTitle.equals(""))
            {
                XFLog.warn("副标题不能为空");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "副标题不能为空",
                        "警告", 2);
                return;
            }
            if (!new File(minecraftRootPath).exists())
            {
                XFLog.warn("无效的.minecraft路径");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "无效的.minecraft路径",
                        "警告", 2);
                return;
            }
            if (!new File(midiPath).exists())
            {
                XFLog.warn("无效的midi路径");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "无效的midi路径",
                        "警告", 2);
                return;
            }
            String fileType = midiPath.substring(midiPath.length() - 4, midiPath.length());
            if (!fileType.equals(".mid"))
            {
                XFLog.warn("无效的midi文件");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "无效的midi文件",
                        "警告", 2);
                return;
            }
            if (!new File(midiPath).isFile())
            {
                XFLog.warn("无效的midi路径");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "无效的midi路径",
                        "警告", 2);
                return;
            }
            if (!new File(minecraftRootPath).isDirectory())
            {
                XFLog.warn("无效的.minecraft路径");
                JOptionPane.showMessageDialog(
                        MainWindow.getMainWindow(),
                        "无效的.minecraft路径",
                        "警告", 2);
                return;
            }


            MainContainerPage_3.getMainContainerPanelRightFooterTextArea().setText("");

            setEnableToFalse();

            stringBuilder = new StringBuilder();

            Thread runnable = new Thread()
            {
                public void run()
                {
                    File writeFile = new File(minecraftRootPath + "/saves/xfherun_" + title).getAbsoluteFile();
                    XFLog.info("写入目标文件: " + writeFile);
                    writeText("准备中...", 119, 200);
                    writeText("校验信息...", 119, 200);
                    writeText("JMCI文件内容", 119, 200);
                    XFLog.info("预测内容: " + content);
                    writeText(content, 119, 200);
                    XFLog.info("目标路径: " + minecraftRootPath);
                    writeText("minecraft路径: " + minecraftRootPath, 119, 200);
                    writeText("midi路径: " + midiPath, 119, 200);
                    writeText("标题: " + title, 119, 200);
                    writeText("副标题: " + subTitle, 119, 200);
                    XFLog.info("开始写入");
                    writeText("开始写入mcfunction文件 . . . ", 500, 1000);



                    XFLog.info("成功写入到Minecraft, 路径: " + writeFile);
                    writeText("成功写入到Minecraft, 路径: " + writeFile, 500, 1000);
                    writeText("编译程序退出...", 500, 1000);
                    setEnableToTrue();
                    XFLog.info("完成!!!");
                }
            };
            runnable.start();
        }
    }

    private static void writeText(String str, int from, int to)
    {
        stringBuilder.append(str).append("\n");
        MainContainerPage_3.getMainContainerPanelRightFooterTextArea().setText(stringBuilder.toString());
        MainContainerPage_3.getMainContainerPanelRightFooterTextArea().setCaretPosition(stringBuilder.length());
        Sleep.sleep(from, to);
    }

    private static void setEnableToFalse()
    {
        MainContainerPage_3.getMainContainerPanelLeftTopFileButton().setEnabled(false);
        MainContainerPage_3.getMainContainerPanelLeftFooterBackButton().setEnabled(false);
        MainContainerPage_3.getMainContainerPanelLeftFooterGeneratorButton().setEnabled(false);
    }

    private static void setEnableToTrue()
    {
        MainContainerPage_3.getMainContainerPanelLeftTopFileButton().setEnabled(true);
        MainContainerPage_3.getMainContainerPanelLeftFooterBackButton().setEnabled(true);
        MainContainerPage_3.getMainContainerPanelLeftFooterGeneratorButton().setEnabled(true);
    }
}
