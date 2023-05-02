/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.thread;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.ProgressBarWindow;

public class UpdateWindow2 extends Thread
{
    @Override
    public void run()
    {
        XFLog.debug("更新进度条窗口: " + UpdateWindow2.class);
        while (ProgressBarWindow.getMainWindow().isVisible())
        {
            ProgressBarWindow.getMainWindow().revalidate();
            ProgressBarWindow.getMainWindow().repaint();
        }
    }
}