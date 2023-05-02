/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.section.page_3.tools;

import main.java.com.xfherun.jmci.frame_file.ReadFrameFile;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_3;
import main.java.com.xfherun.jmci.utils.ReadTextFile;

import java.io.File;

public class SetFile
{
    private SetFile()
    {
    }

    public static void start(File file)
    {
        String s = ReadFrameFile.show2(
                ReadTextFile.readAllToLine(file)
                        .replace("midiout", "midi输出: ")
                        .replace("|", ", ")
                        .replace("noteopen", "打开音符 >> ")
                        .replace("noteclose", "关闭音符 >> ")
                        .replace("setprogram", "设置midi程序 >> ")
                        .replace("setcontrol", "设置midi控制 >> ")
                        .replace("NONE", "空帧")
                        .replace("[", "")
                        .replace("]", "")
                        .replace("pitchwheelrange", "设置midi弯音轮 >> ")
        );
        MainContainerPage_3.getMainContainerPanelRightTopTextArea().setText(s);
    }
}
