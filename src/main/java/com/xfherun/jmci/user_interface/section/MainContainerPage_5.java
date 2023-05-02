package main.java.com.xfherun.jmci.user_interface.section;

import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.sneakgame.main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MainContainerPage_5
{
    private static JPanel mainContainerPanel;
    private static XFButton backButton;
    private static JLabel aboutList;
    private static final String HTML =
            "<html>" +
            "<h1 style=\"text-align: center; font-weight: bold;\">关于JMCI软件成员</h1>" +
            "<p style=\"text-align: center;\">软件开发: 21网络6班 -> 何润<p>" +
            "<p style=\"text-align: center;\">软件测试: 21网络6班 -> 欧永潮<p>" +
            "<p style=\"text-align: center;\">其他人员: 21网络6班 -> 何润<p>" +
            "<br>" +
            "<p style=\"text-align: center;\">该软件使用的编程语言是JavaSE - JDK17, midi文件编译器使用的编程语言是Python3.7.4<p><br>" +
            "<br>" +
                    "<p style=\"text-align: center;\">贪吃蛇在 <系统设置 -> 关于软件 -> (右键返回按钮即可)><p><br>" +
            "<p style=\"text-align: center;\"><p>" +
            "<br>" +
            "<h3 style=\"text-align: center;\">&copy;copyright 2023 xfherun<h3>" +
            "</html>"
    ;

    private MainContainerPage_5()
    {
    }

    public static void init()
    {
        mainContainerPanel = new JPanel();
        mainContainerPanel.setBounds(0, 0, MainWindow.getMainContainer().getWidth(),
                MainWindow.getMainContainer().getHeight());
        mainContainerPanel.setLayout(null);
        mainContainerPanel.setBackground(new Color(29, 115, 27, 255));
        mainContainerPanel.setLayout(null);
        addItems();
        mainContainerPanel.setVisible(false);
        MainWindow.getMainContainer().add(mainContainerPanel);
    }

    private static void addItems()
    {
        backButton = new XFButton("返回");
        backButton.setBounds(10, 10, 119, 35);
        backButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPage_4.setPageToCurrent(4);
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                Main.main(new ArrayList<>());
            }
        });
        backButton.addWindow(mainContainerPanel);

        aboutList = new JLabel(HTML);
        aboutList.setBounds(0, 35, mainContainerPanel.getWidth(), mainContainerPanel.getHeight());
        aboutList.setOpaque(true);
        aboutList.setBackground(new Color(0, 0, 0, 0));
        aboutList.setFont(new Font("微软雅黑", 0, 15));
        aboutList.setForeground(new Color(255, 255, 255, 255));
        aboutList.setVerticalAlignment(SwingConstants.TOP);
        aboutList.setHorizontalAlignment(SwingConstants.CENTER);
        mainContainerPanel.add(aboutList);
    }

    public static void setPageToCurrent(int index)
    {
        if (index < 0 || index > 5) throw new IndexOutOfBoundsException("Index: " + index + " out of range 0 ~ 5.");
        else
        {
            MainContainerPageHome.getMainContainerPanel().setVisible(false);
            MainContainerPage_1.getMainContainerPanel().setVisible(false);
            MainContainerPage_2.getMainContainerPanel().setVisible(false);
            MainContainerPage_3.getMainContainerPanel().setVisible(false);
            MainContainerPage_4.getMainContainerPanel().setVisible(false);
            MainContainerPage_5.getMainContainerPanel().setVisible(false);
            if (index == 0) MainContainerPageHome.getMainContainerPanel().setVisible(true);
            else if (index == 1) MainContainerPage_1.getMainContainerPanel().setVisible(true);
            else if (index == 2) MainContainerPage_2.getMainContainerPanel().setVisible(true);
            else if (index == 3) MainContainerPage_3.getMainContainerPanel().setVisible(true);
            else if (index == 4) MainContainerPage_4.getMainContainerPanel().setVisible(true);
            else MainContainerPage_5.getMainContainerPanel().setVisible(true);
        }
    }

    public static JPanel getMainContainerPanel()
    {
        return mainContainerPanel;
    }

    public static XFButton getBackButton()
    {
        return backButton;
    }

    public static JLabel getAboutList()
    {
        return aboutList;
    }
}
