/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.loadsoundpackage;

import com.xfherun.xflog.XFLog;
import jdk.dynalink.beans.StaticClass;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.utils.Resources;
import main.java.com.xfherun.jmci.utils.UpdateSoundPackage;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadSoundPackage extends JDialog
{
    private static JDialog mainWindow;
    private static JPanel backgroundBox;
    private static JPanel leftContainerPanel;
    private static JPanel rightContainerPanel;
    private static XFButton leftButton;
    private static XFButton rightButton;
    private static XFButton openSoundPackageFolderButton;
    private static XFButton doneLoadSoundPackageButton;
    private static JList<Object> leftList;
    private static JList<Object> rightList;

    private LoadSoundPackage()
    {
    }

    public static void loadInterface()
    {
        main.java.com.xfherun.jmci.utils.LoadSoundPackage.load();
        if (StaticValue.loadSoundPackageArrayList.size() != StaticValue.soundPackageArrayList.size())
        {
            for (int i = 0; i < StaticValue.soundPackageArrayList.size(); i++)
            {
                String file = StaticValue.soundPackageArrayList.get(i).getAbsolutePath();
                for (int j = 0; j < StaticValue.loadSoundPackageArrayList.size(); j++)
                {
                    String file2 = StaticValue.loadSoundPackageArrayList.get(j).getAbsolutePath();
                    if (file.equalsIgnoreCase(file2)) StaticValue.soundPackageArrayList.remove(i);
                }
            }
        }
        else StaticValue.soundPackageArrayList.clear();

        XFLog.info("初始化界面");
        createWindow();
        addItems();
        XFLog.info("初始化完毕！");
        mainWindow.setModal(true);
        mainWindow.setVisible(true);

    }

    private static JPanel createPanel(JPanel p)
    {
        p = new JPanel();
        p.setOpaque(true);
        p.setBackground(new Color(86, 124, 15, 255));
        p.setLayout(null);
        return p;
    }

    private static void drawBackgroundBox()
    {
        backgroundBox = createPanel(backgroundBox);
        adds();
        mainWindow.getContentPane().add(backgroundBox);
    }

    private static <E> Object[] toArray(List<E> list)
    {
        Object[] objects = new Object[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            E o = list.get(i);
            if (o instanceof File)
            {
                File file = (File) o;
                Object name = ((File) o).getName();
                objects[i] = name;
            }
        }
        return objects;
    }

    private static void updateList()
    {
        rightList.setListData(toArray(StaticValue.tempLoadSoundPackageArrayList));
        leftList.setListData(toArray(StaticValue.soundPackageArrayList));
        Dimension size = mainWindow.getSize();
        mainWindow.setSize(size.width + 1, size.height + 1);
        mainWindow.setSize(size);
    }

    private static void adds()
    {
        leftContainerPanel = createPanel(leftContainerPanel);
        leftContainerPanel.setBackground(new Color(86, 124, 15, 255));
        leftContainerPanel.setBorder(new LineBorder(new Color(18, 61, 0, 255)));

        leftList = new JList<>(toArray(StaticValue.soundPackageArrayList));
        leftList.setOpaque(true);
        leftList.setBackground(new Color(86, 124, 15, 255));
        leftList.setForeground(Color.decode("#eeeeee"));
        leftList.setBorder(new LineBorder(new Color(18, 61, 0, 255), 2));
        leftContainerPanel.add(leftList);

        backgroundBox.add(leftContainerPanel);

        rightContainerPanel = createPanel(rightContainerPanel);
        rightContainerPanel.setBackground(new Color(86, 124, 15, 255));
        rightContainerPanel.setBorder(new LineBorder(new Color(18, 61, 0, 255)));

        rightList = new JList<>(toArray(StaticValue.tempLoadSoundPackageArrayList));
        rightList.setOpaque(true);
        rightList.setBackground(new Color(86, 124, 15, 255));
        rightList.setForeground(Color.decode("#eeeeee"));
        rightList.setBorder(new LineBorder(new Color(18, 61, 0, 255), 2));
        rightContainerPanel.add(rightList);

        backgroundBox.add(rightContainerPanel);

        rightButton = new XFButton("→");
        leftButton = new XFButton("←");
        rightButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                if (event.getButton() == 1 && event.getClickCount() == 1)
                {
                    XFLog.info("开始将声音包移入预加载区里");
                    int selectedIndex = leftList.getSelectedIndex();
                    if (selectedIndex != -1)
                    {
                        File file = StaticValue.soundPackageArrayList.get(selectedIndex);
                        StaticValue.soundPackageArrayList.remove(selectedIndex);
                        StaticValue.tempLoadSoundPackageArrayList.add(0, file);
                        updateList();
                        rightList.setSelectedIndex(0);
                    }
                    else
                    {
                        String str = "请选择要操作的声音包";
                        XFLog.warn(str);
                        JOptionPane.showMessageDialog(mainWindow,
                                str, "警告", 2);
                    }
                }
            }
        });
        leftButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                if (event.getButton() == 1 && event.getClickCount() == 1)
                {
                    XFLog.info("开始将声音包从预加载区里移出");
                    int selectedIndex = rightList.getSelectedIndex();
                    if (selectedIndex != -1)
                    {
                        File file = StaticValue.tempLoadSoundPackageArrayList.get(selectedIndex);
                        StaticValue.tempLoadSoundPackageArrayList.remove(selectedIndex);
                        StaticValue.soundPackageArrayList.add(0, file);
                        updateList();
                        leftList.setSelectedIndex(0);
                    }
                    else
                    {
                        String str = "请选择要操作的声音包";
                        XFLog.warn(str);
                        JOptionPane.showMessageDialog(mainWindow,
                                str, "警告", 2);
                    }
                }
            }
        });
        rightButton.addWindow(backgroundBox);
        leftButton.addWindow(backgroundBox);

        openSoundPackageFolderButton = new XFButton("打开声音包文件夹");
        doneLoadSoundPackageButton = new XFButton("完成");
        openSoundPackageFolderButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                if (event.getButton() == 1 && event.getClickCount() == 1)
                {
                    String commandHeader = "cmd /c ";
                    String command = "start \"\" \"" + new File("assets/package").getAbsolutePath() + "\"";
                    try
                    {
                        Runtime.getRuntime().exec(commandHeader + command);
                        XFLog.info("成功打开文件夹: " + new File("assets/package").getAbsolutePath());
                    }
                    catch (IOException e)
                    {
                        XFLog.err("", e);
                    }
                }
            }
        });
        doneLoadSoundPackageButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                exit(0);
            }
        });
        openSoundPackageFolderButton.addWindow(backgroundBox);
        doneLoadSoundPackageButton.addWindow(backgroundBox);
    }

    private static void resize()
    {
        int windowWidth = mainWindow.getWidth() - 16;
        int windowHeight = mainWindow.getHeight() - 39;
        backgroundBox.setBounds(0, 0, windowWidth, windowHeight);
        leftContainerPanel.setBounds(0, 0, backgroundBox.getWidth() / 2 - 15, backgroundBox.getHeight() - 41);
        rightContainerPanel.setBounds((backgroundBox.getWidth() / 2) + 15, 0, backgroundBox.getWidth() / 2 - 15, backgroundBox.getHeight() - 41);
        rightButton.setBounds((backgroundBox.getWidth() / 2) - 15, (leftContainerPanel.getHeight() - (30 * 2)) / 2, 30, 30);
        leftButton.setBounds((backgroundBox.getWidth() / 2) - 15, ((rightContainerPanel.getHeight() - (30 * 2)) / 2) + 30, 30, 30);
        openSoundPackageFolderButton.setBounds(0, backgroundBox.getHeight() - 41, backgroundBox.getWidth() / 2, 41);
        doneLoadSoundPackageButton.setBounds(backgroundBox.getWidth() / 2, backgroundBox.getHeight() - 41, backgroundBox.getWidth() / 2, 41);
        leftList.setBounds(0, 0, leftContainerPanel.getWidth(), leftContainerPanel.getHeight());
        rightList.setBounds(0, 0, rightContainerPanel.getWidth(), rightContainerPanel.getHeight());
    }

    private static void addItems()
    {
        XFLog.info("加载控件");
        drawBackgroundBox();
        resize();
    }

    private static void exit()
    {
        XFLog.info("退出中...");
        XFLog.info("开始关闭窗口");
        mainWindow.setVisible(false);
        XFLog.info("窗口关闭成功...");
    }

    private static void exit(int status)
    {
        if (status != 0)
        {
            StaticValue.tempLoadSoundPackageArrayList.clear();
            exit();
        }
        else
        {
            StaticValue.loadSoundPackageArrayList.clear();
            StaticValue.loadSoundPackageArrayList.addAll(StaticValue.tempLoadSoundPackageArrayList);
            UpdateSoundPackage.update(StaticValue.loadSoundPackageArrayList);
            exit();
        }
    }

    private static void addWindowEvents()
    {
        mainWindow.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                exit(119);
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

        mainWindow.addComponentListener(new ComponentListener()
        {
            @Override
            public void componentResized(ComponentEvent e)
            {
                resize();
            }

            @Override
            public void componentMoved(ComponentEvent e)
            {

            }

            @Override
            public void componentShown(ComponentEvent e)
            {

            }

            @Override
            public void componentHidden(ComponentEvent e)
            {

            }
        });
    }

    private static void createWindow()
    {
        XFLog.info("创建窗口");
        mainWindow = new JDialog();
        mainWindow.setTitle("加载声音包");
        mainWindow.setSize(800, 480);
        mainWindow.setMinimumSize(new Dimension(400, 400));
        mainWindow.setLayout(null);
        mainWindow.setResizable(true);
        mainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainWindow.setLocationRelativeTo(MainWindow.getMainWindow());
        mainWindow.setIconImage(new ImageIcon(Resources.getResources(LoadSoundPackage.class, "main/resources/images/window/logo/logo.png")).getImage());
        addWindowEvents();
    }

    public static JDialog getMainWindow()
    {
        return mainWindow;
    }

    public static JPanel getBackgroundBox()
    {
        return backgroundBox;
    }

    public static JPanel getLeftContainerPanel()
    {
        return leftContainerPanel;
    }

    public static JPanel getRightContainerPanel()
    {
        return rightContainerPanel;
    }

    public static XFButton getLeftButton()
    {
        return leftButton;
    }

    public static XFButton getRightButton()
    {
        return rightButton;
    }

    public static XFButton getOpenSoundPackageFolderButton()
    {
        return openSoundPackageFolderButton;
    }

    public static XFButton getDoneLoadSoundPackageButton()
    {
        return doneLoadSoundPackageButton;
    }

    public static JList<Object> getLeftList()
    {
        return leftList;
    }

    public static JList<Object> getRightList()
    {
        return rightList;
    }
}
