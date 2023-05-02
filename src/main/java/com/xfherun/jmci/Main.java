/*
 * Copyright xfherun(c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci;

import com.xfherun.xflog.LoadXFLogConfigFile;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.frame_file.ReadFrameFile;
import main.java.com.xfherun.jmci.global_thread_exception_cache.GlobalExceptionHandler;
import main.java.com.xfherun.jmci.init.InitFile;
import main.java.com.xfherun.jmci.init.InitMidiDevice;
import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.soundfont.sf2.SoundFont;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.button.i.KeyEvent;
import main.java.com.xfherun.jmci.swing_util.list.menu.GetMousePoint;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.swing_util.list.normal.XFList;
import main.java.com.xfherun.jmci.swing_util.window_utils.RepaintWindow;
import main.java.com.xfherun.jmci.swing_util.window_utils.UpdateWindow;
import main.java.com.xfherun.jmci.swing_util.window_utils.Window;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.exception_window.ExceptionLeftBottomWindow;
import main.java.com.xfherun.jmci.utils.RandomGeneratorImages;
import main.java.com.xfherun.jmci.utils.ReadTextFile;
import main.java.com.xfherun.jmci.utils.Sleep;
import main.java.com.xfherun.minecraft_redstone_music_generator.utls.ForJarResources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Main
{
    static
    {
        new Thread(() -> Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler())).start();
        LoadXFLogConfigFile.useDefaultConfig();
        XFLog.info("\n\n" + XFLOGO.logo + "\n\n");
        Sleep.sleep(new Random().nextInt(1000, 3456));
        XFLog.info("程序启动中");
        XFLog.info("初始化文件系统");
        InitFile.init();
        Sleep.sleep(new Random().nextInt(200, 300));
        XFLog.info("初始化midi系统");
        InitMidiDevice.init();
        XFLog.info("更新鼠标信息");
        Sleep.sleep(new Random().nextInt(600, 780));
        GetMousePoint.update();
        XFLog.info("更新异常窗口");
        ExceptionLeftBottomWindow.init();
    }

    public static void main(String[] args)
    {
        XFLog.info("绘制随机标题的小标题");
        RandomGeneratorImages.randomImage("cache/home_title_image_flush");
        XFLog.info("初始化窗口");
        MainWindow.init();
        // main.java.com.xfherun.minecraft_redstone_music_generator.Main.main();
    }
}
