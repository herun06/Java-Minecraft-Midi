/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.Write;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.utils.WriteFile;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BootMinecraft
{
    private BootMinecraft()
    {
    }

    public static boolean boot(String bootCommands)
    {
        XFLog.info("获取Runtime();");
        File cdFile = new File("cache/minecraft").getAbsoluteFile();
        XFLog.info("写入bat脚本:\n" + bootCommands);
        WriteFile.writeStringToFile("cache/minecraft/boot.bat", bootCommands, "UTF-8");
        XFLog.info("写入完毕, 开始执行");
        String command = "cmd /c cd /d \"" + cdFile.getAbsolutePath() + "\" && boot.bat";
        XFLog.info("命令执行完毕！");
        Process proc = null;
        try
        {
            proc = Runtime.getRuntime().exec(command);
            new Thread(() ->
            {
                XFLog.info("启动成功！");
                JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "启动成功！", "提示", 1);
            }).start();
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null)
            {
                XFLog.stdout(line);
            }
            in.close();
            proc.waitFor();
        }
        catch (Exception e)
        {
            XFLog.err("启动失败！！！", new RuntimeException(e.getMessage()));
            JOptionPane.showMessageDialog(MainWindow.getMainWindow(), "启动失败: " + e, "错误", 0);
            return false;
        }
        return true;
    }
}
