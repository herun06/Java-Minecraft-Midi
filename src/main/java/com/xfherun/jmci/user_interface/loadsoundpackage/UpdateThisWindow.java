/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.loadsoundpackage;

import com.xfherun.xflog.XFLog;

public class UpdateThisWindow extends Thread
{
    @Override
    public void run()
    {
        XFLog.info("开始更新窗口");
        while (LoadSoundPackage.getMainWindow().isVisible())
        {
            //LoadSoundPackage.getMainWindow().revalidate();
            /*LoadSoundPackage.getRightList().repaint();
            LoadSoundPackage.getLeftList().repaint();*/
            LoadSoundPackage.getMainWindow().repaint();
        }
        XFLog.info("开始更新完毕！");
    }
}
