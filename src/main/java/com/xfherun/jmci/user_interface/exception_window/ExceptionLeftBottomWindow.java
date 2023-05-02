/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.exception_window;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.swing_util.list.normal.XFList;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class ExceptionLeftBottomWindow extends JFrame
{
    private static Image image = new ImageIcon(Resources.getResources(ExceptionLeftBottomWindow.class, "" +
            "main/resources/images/window/logo/logo.png")).getImage();

    private static JFrame mainWindow;
    private static XFList list;

    private ExceptionLeftBottomWindow()
    {
    }

    public static void init()
    {
        mainWindow = new JFrame();
        mainWindow.setTitle("异常任务栏");
        mainWindow.setSize(400, 400);
        mainWindow.setResizable(false);
        mainWindow.setLayout(null);
        URL imageUrl = Resources.getResources(ExceptionLeftBottomWindow.class, "" +
                "main/resources/images/window/logo/logo.png");
        Image image = new ImageIcon(imageUrl).getImage();
        mainWindow.setIconImage(image);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainWindow.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                MainWindow.getExceptionSwitch().setChecked(false, false);
                mainWindow.setVisible(false);
            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {

            }

            @Override
            public void windowActivated(WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {

            }
        });
        addItems();
        mainWindow.setVisible(false);
    }

    public static void updateList()
    {
        /*list.removeAll();
        for (int i = 0; i < StaticValue.throwableList.size(); i++)
        {
            Throwable throwable = (Throwable) StaticValue.throwableList.get(i)[0];
            list.insert(0, throwable.toString());
            if (list.getItemCount() - 1 != -1) list.setCurrentSelectIndex(0);
            list.setVSB();
        }
        list.getSource().repaint();*/
        list.removeAll();
        for (int i = StaticValue.throwableList.size() - 1; i >= 0; i--)
        {
            Throwable throwable = (Throwable) StaticValue.throwableList.get(i)[0];
            list.insert(0, throwable.toString());
            if (list.getItemCount() - 1 != -1) list.setCurrentSelectIndex(0);
            list.setVSB();
        }
        list.getSource().repaint();
    }

    private static void addItems()
    {
        list = new XFList();
        list.setBounds(new int[] {0, 0, 400 - 16, 400 - 39});
        list.addButtonClicked(new ButtonClick()
        {
            @Override
            public void mouseDouble(MouseEvent event)
            {
                int index = list.getCurrentSelectIndex();
                XFLog.info("Index: " + index);
                showExceptionWindow(index);
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                XFMenuList xfMenuList = new XFMenuList(
                        false, true, null, true,
                        true, true, 119
                );
                xfMenuList.setBounds(new int[] {0, 0, 119, 35});
                xfMenuList.add("打开");
                xfMenuList.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        int index = list.getCurrentSelectIndex();
                        XFLog.info("Index: " + index);
                        showExceptionWindow(index);
                    }
                });
                xfMenuList.show();
            }
        });
        list.addWindow(mainWindow);
    }

    private static void showExceptionWindow(int index)
    {
        JDialog dialog = new JDialog();
        dialog.setTitle("异常: " + StaticValue.throwableList.get(index)[0]);
        dialog.setSize(800, 480);
        dialog.setLocationRelativeTo(mainWindow);
        dialog.setResizable(true);
        URL imageUrl = Resources.getResources(ExceptionLeftBottomWindow.class, "" +
                "main/resources/images/window/logo/logo.png");
        Image image = new ImageIcon(imageUrl).getImage();
        dialog.setIconImage(image);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText((String) StaticValue.throwableList.get(index)[1]);
        JScrollPane pane = new JScrollPane(textArea);
        dialog.getContentPane().add(pane);

        dialog.setModal(true);
        dialog.setVisible(true);
    }

    public static Image getImage()
    {
        return image;
    }

    public static JFrame getMainWindow()
    {
        return mainWindow;
    }

    public static XFList getList()
    {
        return list;
    }
}
