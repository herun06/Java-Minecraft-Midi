/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;

import java.util.Random;

public class Exit
{
    private Exit()
    {
    }

    public static void exit()
    {
        XFLog.info("准备退出...");
        XFLog.info("停止服务");
        MidiOut.closeDevice();
        int exitCode = new Random().nextInt(-999999999, 99999999);
        XFLog.info("进程已结束, 退出代码: " + exitCode);
        System.exit(exitCode);
    }
}
