/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.section.page_1.tool;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.switch_button.XFSwitchButton;
import main.java.com.xfherun.jmci.swing_util.switch_button.action.SwitchListener;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;
import main.java.com.xfherun.jmci.user_interface.MainWindow;

import javax.swing.*;

public class Tool
{
    private static JDialog mainWindow;
    private static XFSwitchButton loopPlay;

    private Tool()
    {
    }

    public static void init()
    {
        XFLog.info("初始化工具窗口");
        mainWindow = new JDialog();
        mainWindow.setTitle("其他调试");
        mainWindow.setSize(400, 400);
        mainWindow.setLayout(null);
        mainWindow.setLocationRelativeTo(MainWindow.getMainWindow());
        mainWindow.setResizable(false);
        addItems();
        mainWindow.setModal(true);
        mainWindow.setVisible(true);
    }

    private static void addItems()
    {
        JLabel loopPlayLabel = new JLabel("循环播放");
        loopPlayLabel.setBounds( 10 + 70, 10, 64, 35);
        mainWindow.getContentPane().add(loopPlayLabel);
        loopPlay = new XFSwitchButton("循环播放");
        loopPlay.setBounds(10, 10, 64, 35);
        loopPlay.addActionListener(new SwitchListener()
        {
            @Override
            public void acc(boolean isOn)
            {
                if (isOn) StaticValue.isLoopPlay = true;
                else StaticValue.isLoopPlay = false;
            }
        });
        loopPlay.addToWindow(mainWindow);
        loopPlay.setChecked(StaticValue.isLoopPlay, false);
    }
}
