/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.utls.StringFormat;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenLogFile
{
    private static JDialog dialog;

    private OpenLogFile()
    {
    }

    public static void open(File logFile, Component component)
    {
        XFLog.info("准备文件中: " + logFile);
        /*String html = ReadTextFile.readAllToLine(logFile);
        XFLog.debug("HTML:\n" + html);
        init(logFile, component);*/
        File parentFile = logFile.getParentFile();
        try
        {
            String html = ReadTextFile.readAllToLine(logFile);
            boolean b = WriteFile.writeStringToFile("cache/cache/updateLogFile.html", html, "UTF-8");
            if (b)
            {
                Runtime.getRuntime().exec(StringFormat.stringFormat("cmd /c \"{0}\"",
                        new String[]{new File("cache/cache/updateLogFile.html").getAbsolutePath()}));
                XFLog.info("成功打开日志文件: " + logFile);
                Thread runnable = new Thread()
                {
                    public void run()
                    {
                        JOptionPane.showMessageDialog(component,
                                "成功打开日志文件: " + logFile,
                                "提示", 1);
                    }
                };
                runnable.start();
            }
            else
            {
                XFLog.warn("打开日志文件: " + logFile + "失败");
                Thread runnable = new Thread()
                {
                    public void run()
                    {
                        JOptionPane.showMessageDialog(component,
                                "打开日志文件: " + logFile + "失败",
                                "提示", 1);
                    }
                };
                runnable.start();
            }
        }
        catch (IOException e)
        {
            XFLog.warn("打开日志文件: " + logFile + "失败", e);
            Thread runnable = new Thread()
            {
                public void run()
                {
                    JOptionPane.showMessageDialog(component,
                            "打开日志文件: " + logFile + "失败",
                            "提示", 1);
                }
            };
            runnable.start();
        }
    }

    private static void init(final File file, Component component)
    {
        dialog = new JDialog();
        dialog.setTitle("查看更新日志");
        dialog.setSize(800, 480);
        dialog.setLocationRelativeTo(MainWindow.getMainWindow());
        dialog.setIconImage(new ImageIcon(Resources.getResources(OpenLogFile.class, "main/resources/images/window/logo/logo.png")).getImage());
        dialog.setModal(true);

        JEditorPane jEditorPane = new JEditorPane();
        jEditorPane.setEditable(false);
        try
        {
            jEditorPane.setPage(file.toURL());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        JScrollPane pane = new JScrollPane(jEditorPane);
        dialog.getContentPane().add(pane);

        component.setVisible(false);

        XFLog.info("成功打开日志文件: " + file);
        Thread runnable = new Thread()
        {
            public void run()
            {
                JOptionPane.showMessageDialog(dialog,
                        "成功打开日志文件: " + file,
                        "提示", 1);
            }
        };
        runnable.start();

        dialog.setVisible(true);
    }
}
