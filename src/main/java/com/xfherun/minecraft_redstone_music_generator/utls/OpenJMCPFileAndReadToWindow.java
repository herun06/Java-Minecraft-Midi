/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;

import javax.swing.*;
import java.util.Arrays;

public class OpenJMCPFileAndReadToWindow
{
    private OpenJMCPFileAndReadToWindow()
    {
    }

    public static boolean run(Object[] datas) throws Exception
    {
        XFLog.info("成功拿到数据: " + datas + " 开始设置窗口屏幕的内容进行显示出来");
        String title = (String) datas[0];
        String mcp = (String) datas[4];
        String jmcip = (String) datas[5];
        String mt = (String) datas[6];
        String st = (String) datas[7];
        String mcffn = (String) datas[8];
        if (!mcffn.equals("xfherun_redstone_music"))
        {
            XFLog.warn("错误的数据: " + mcffn, new RuntimeException("错误的数据: " + mcffn));
            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                    "错误的数据: " + mcffn,
                    "警告", 2);
            return false;
        }
        MainWindow.getInputBox_1().getSource().setText(title);
        MainWindow.getInputBox_2().getSource().setText(mcp);
        MainWindow.getInputBox_3().getSource().setText(jmcip);
        MainWindow.getInputBox_4().getSource().setText(mt);
        MainWindow.getInputBox_5().getSource().setText(st);
        MainWindow.setCurrentSelectPage(0);
        XFLog.stdout(Arrays.toString(datas));
        return true;
    }
}
