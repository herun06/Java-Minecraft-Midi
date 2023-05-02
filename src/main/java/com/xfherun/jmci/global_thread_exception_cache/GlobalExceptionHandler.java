/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.global_thread_exception_cache;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;
import main.java.com.xfherun.jmci.user_interface.exception_window.ExceptionLeftBottomWindow;
import main.java.com.xfherun.jmci.user_interface.exception_window.UpdateWindow;
import main.java.com.xfherun.jmci.utils.PrintException;

import java.awt.*;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        String exception = "Exception in thread \"" + t.getName() + "\" " + PrintException.getException(e,
                StaticValue.appVersion);
        StaticValue.throwableList.add(new Object[]{e, exception});
        //StaticValue.throwableListString.add(exception);
        if (ExceptionLeftBottomWindow.getMainWindow().isVisible())
        {
            Thread tt = new Thread(() ->
            {
                ExceptionLeftBottomWindow.updateList();
                ExceptionLeftBottomWindow.getMainWindow().setVisible(true);
            });
            tt.start();
        }
        XFLog.err("程序出现了一个异常: ", e);
    }
}
