/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.thread;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;

import java.awt.*;

public class UpdateWindow extends Thread
{
    @Override
    public void run()
    {
        while (MainWindow.getMainWindow() != null && MainWindow.getMainWindow().isVisible())
        {
            if (MainWindow.getMainWindow().getExtendedState() == Frame.MAXIMIZED_BOTH)
            {
                XFLog.stdout("禁止窗口最大化");
                MainWindow.getMainWindow().setExtendedState(Frame.NORMAL);
            }
            MainWindow.getMainWindow().getContentPane().revalidate();
            MainWindow.getMainWindow().getContentPane().repaint();
        }
    }
}
