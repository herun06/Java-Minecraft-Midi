package main.java.com.xfherun.jmci.user_interface.section;

import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.events.ChangePage;
import main.java.com.xfherun.jmci.user_interface.function.ChangeImage;
import main.java.com.xfherun.jmci.user_interface.function.HomeTitleImageRun;
import main.java.com.xfherun.jmci.user_interface.function.HomeTitleImageRunSize;
import main.java.com.xfherun.jmci.utils.Resources;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainContainerPageHome
{
    private static JPanel mainContainerPanel;
    private static XFButton playSongPianoKeyButton;
    private static XFButton editJavaMinecraftMidiButton;
    private static XFButton minecraftRedStoneMusicButton;
    private static XFButton systemSettingsButton;
    private static XFButton exitApplicationButton;
    private static JLabel titleImage;
    private static int titleImageFontSize = 50;
    private static JLabel titleImageRun;

    private MainContainerPageHome()
    {
    }

    public static void init()
    {
        mainContainerPanel = new JPanel();
        mainContainerPanel.setBounds(0, 0, MainWindow.getMainContainer().getWidth(),
                MainWindow.getMainContainer().getHeight());
        mainContainerPanel.setOpaque(true);
        mainContainerPanel.setBackground(new Color(29, 115, 27, 255));
        mainContainerPanel.setLayout(null);
        addItems();
        mainContainerPanel.setVisible(false);
        MainWindow.getMainContainer().add(mainContainerPanel);
    }

    private static void addItems()
    {
        int count = 5;
        int margin = 5;
        // int width = (mainContainerPanel.getWidth() / 4) * 2;
        int width = 500;
        // int height = mainContainerPanel.getHeight() / (count + 5);
        int height = 40;
        int x = (mainContainerPanel.getWidth() - width) / 2;
        int y = ((mainContainerPanel.getHeight() - ((height + margin) * count)) / 2) + ((count + 5) * 4);
        int vy = ((mainContainerPanel.getHeight() - ((height + margin) * count)) / 2) + ((count + 5) * 4);
        playSongPianoKeyButton = new XFButton("开始播放");
        editJavaMinecraftMidiButton = new XFButton("JMCI编辑");
        minecraftRedStoneMusicButton = new XFButton("Minecraft红石音乐");
        systemSettingsButton = new XFButton("系统设置");
        exitApplicationButton = new XFButton("退出程序");

        playSongPianoKeyButton.setSize(new int[] {width, height});
        editJavaMinecraftMidiButton.setSize(new int[] {width, height});
        minecraftRedStoneMusicButton.setSize(new int[] {width, height});
        systemSettingsButton.setSize(new int[] {width, height});
        exitApplicationButton.setSize(new int[] {width, height});

        playSongPianoKeyButton.setLocation(new int[] {x, y});
        y += (height + margin);
        editJavaMinecraftMidiButton.setLocation(new int[] {x, y});
        y += (height + margin);
        minecraftRedStoneMusicButton.setLocation(new int[] {x, y});
        y += (height + margin);
        systemSettingsButton.setLocation(new int[] {x, y});
        y += (height + margin);
        exitApplicationButton.setLocation(new int[] {x, y});

        playSongPianoKeyButton.addWindow(mainContainerPanel);
        editJavaMinecraftMidiButton.addWindow(mainContainerPanel);
        minecraftRedStoneMusicButton.addWindow(mainContainerPanel);
        systemSettingsButton.addWindow(mainContainerPanel);
        exitApplicationButton.addWindow(mainContainerPanel);

        titleImageRun = new JLabel("", JLabel.CENTER);
        titleImageRun.setBounds(mainContainerPanel.getWidth() - 300, 0, 300, 200);
        titleImageRun.setOpaque(true);
        titleImageRun.setBackground(new Color(0, 0, 0, 0));
        mainContainerPanel.add(titleImageRun);
        new HomeTitleImageRun().start();
        new HomeTitleImageRunSize().start();
        new ChangeImage().start();

        titleImage = new JLabel("JMCI");
        titleImage.setBounds(0, 0, mainContainerPanel.getWidth(), vy);
        titleImage.setOpaque(true);
        titleImage.setFont(new Font("微软雅黑", 1, titleImageFontSize));
        titleImage.setBackground(new Color(0, 0, 0, 0));
        titleImage.setForeground(new Color(97, 225, 35, 255));
        titleImage.setVerticalAlignment(SwingConstants.CENTER);
        titleImage.setHorizontalAlignment(SwingConstants.CENTER);
        mainContainerPanel.add(titleImage);

        ChangePage.change();
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

    public static XFButton getPlaySongPianoKeyButton()
    {
        return playSongPianoKeyButton;
    }

    public static XFButton getEditJavaMinecraftMidiButton()
    {
        return editJavaMinecraftMidiButton;
    }

    public static XFButton getMinecraftRedStoneMusicButton()
    {
        return minecraftRedStoneMusicButton;
    }

    public static XFButton getSystemSettingsButton()
    {
        return systemSettingsButton;
    }

    public static XFButton getExitApplicationButton()
    {
        return exitApplicationButton;
    }

    public static JLabel getTitleImage()
    {
        return titleImage;
    }

    public static int getTitleImageFontSize()
    {
        return titleImageFontSize;
    }

    public static void setTitleImageFontSize(int num)
    {
        titleImageFontSize = num;
    }

    public static JLabel getTitleImageRun()
    {
        return titleImageRun;
    }
}
