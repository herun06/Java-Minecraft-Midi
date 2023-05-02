/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.update_log;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.normal.XFList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.utils.OpenLogFile;
import main.java.com.xfherun.jmci.utils.ReadTextFile;
import main.java.com.xfherun.jmci.utils.Resources;
import main.java.com.xfherun.jmci.utils.StringMethod;

import javax.sql.rowset.FilteredRowSet;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class UpdateLogWindow extends JDialog
{
    private static JDialog mainWindow;
    private static XFList xfList;

    private UpdateLogWindow()
    {
    }

    public static void init()
    {
        XFLog.info("初始化: 更新日志列表");
        mainWindow = new JDialog();
        mainWindow.setTitle("更新日志列表");
        mainWindow.setIconImage(new ImageIcon(Resources.getResources(UpdateLogWindow.class, "main/resources/images/window/logo/logo.png")).getImage());
        mainWindow.setSize(400, 400);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(MainWindow.getMainWindow());
        mainWindow.setModal(true);
        mainWindow.setLayout(null);
        addItems();
        mainWindow.setVisible(true);
        XFLog.info("初始化完毕！");
    }

    private static void addItems()
    {
        XFLog.info("添加控件");

        xfList = new XFList();
        xfList.setBounds(new int[]{0, 0, mainWindow.getWidth() - 16, mainWindow.getHeight() - 39});
        scannerUpdateLog();
        xfList.addButtonClicked(new ButtonClick()
        {
            @Override
            public void mouseDouble(MouseEvent event)
            {
                if (event.getButton() == 1)
                {
                    XFLog.info("打开日志文件");
                    String currentSelectText = xfList.getCurrentSelectText();
                    String fileName = currentSelectText.substring(8);
                    File file = new File("system/update/log/list/" + fileName + ".html").getAbsoluteFile();
                    if (file.exists())
                    {
                        XFLog.info("正在打开更新日志: " + file);

                        OpenLogFile.open(file, mainWindow);
                    }
                    else
                    {
                        mainWindow.setVisible(false);
                        XFLog.warn("更新日志文件: " + file + " 不存在");
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "更新日志文件: " + file + " 不存在",
                                "警告", 2);
                    }
                }
            }
        });
        if (xfList.getItemCount() - 1 != -1) xfList.setCurrentSelectIndex(xfList.getItemCount() - 1);
        xfList.addWindow(mainWindow);
        XFLog.info("添加控件完毕");
    }

    private static void scannerUpdateLog()
    {
        XFLog.info("扫描更新日志文件");
        File updateLogFile = new File("system/update/log/list").getAbsoluteFile();
        XFLog.info("目标目录: " + updateLogFile);
        File[] files = updateLogFile.listFiles();
        for (File file : files)
        {
            XFLog.info("扫描到的文件: " + file);
            XFLog.info("扫描文件类型");
            String fileType = file.toString().substring(file.toString().lastIndexOf("."), file.toString().length());
            XFLog.info("文件类型: " + fileType);
            if (fileType.equalsIgnoreCase(".html"))
            {
                XFLog.info("文件: " + file + " 是一个有效的文件");
                XFLog.info("开始读取文件, 其实就是一个HTML文本而已");
                String[] log = ReadTextFile.readAllToLine_lineNumber(file);
                if (log != null)
                {
                    String newLog = "    " + StringMethod.countString("-", Integer.parseInt(log[2]) + 1) + "\n" + log[0].substring(0, log[0].lastIndexOf("\n"));
                    ArrayList<String> temp = new ArrayList<>();
                    int s = 0;
                    int e = 0;
                    int c = 0;
                    for (int i = 0; i < newLog.length(); i++)
                    {
                        char c2 = newLog.charAt(i);
                        if (c2 == '\n')
                        {
                            e = i;
                            String result = newLog.substring(s, e);
                            temp.add(result);
                            c++;
                        }
                        if (c != 0) s = e + 1;
                    }
                    String result = newLog.substring(s);
                    temp.add(result);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < temp.size(); i++)
                    {
                        String str = temp.get(i);
                        int maxLength = Integer.parseInt(log[2]);
                        String fill = fill(maxLength + 5, str, " ");
                        if (!str.equalsIgnoreCase("    " + StringMethod.countString("-", Integer.parseInt(log[2]) + 1)))
                            stringBuilder.append(fill).append("|").append("\n");
                        else
                            stringBuilder.append("    ").append(StringMethod.countString("-", Integer.parseInt(log[2]) + 1)).append("-").append("\n");
                    }
                    stringBuilder.append("    ").append(StringMethod.countString("-", Integer.parseInt(log[2]) + 1)).append("-");
                    XFLog.info("日志内容:\n" + stringBuilder);
                    xfList.add("更新日志 -> " + file.getName().substring(0, file.getName().lastIndexOf(".")));
                } else XFLog.warn("文件: " + file + " 不是一个有效的更新日志文件");
            }
            else XFLog.warn("文件: " + file + " 不是一个有效的更新日志文件");
        }
    }

    private static String fill(int length, String string, String str)
    {
        int size = length - string.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) stringBuilder.append(str);
        stringBuilder.insert(0, string);
        return stringBuilder.toString();
    }
}
