/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp;

import main.java.com.xfherun.minecraft_redstone_music_generator.thread.UpdateWindow2;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.ClickedConnect;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.PushButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ProgressBarWindow extends JDialog
{
    private static JDialog mainWindow;
    private static JProgressBar progressBar;
    private static JPanel panel;
    private static JLabel title;
    private static PushButton pushButton;
    private static ClickedConnect clickedConnect;
    private static boolean isEnd;

    private ProgressBarWindow()
    {
    }

    public static void init(ClickedConnect clickedConnect)
    {
        isEnd = false;
        ProgressBarWindow.clickedConnect = clickedConnect;
        mainWindow = new JDialog();
        mainWindow.setTitle("");
        mainWindow.setLayout(null);
        mainWindow.setSize(400, 200);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(MainWindow.getMainWindow());
        panel = new JPanel();
        panel.setBounds(0, 0, mainWindow.getWidth() - 16, mainWindow.getHeight() - 39);
        panel.setOpaque(true);
        panel.setLayout(null);
        panel.setBackground(new Color(45, 45, 45, 255));
        panel.setForeground(new Color(0, 0, 0, 0));
        addItems();
        mainWindow.getContentPane().add(panel);
        mainWindow.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                if (!isEnd)
                {
                    clickedConnect.accept(null, "mouseClicked");
                    isEnd = true;
                }
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
        updateProgress("准备中...", 0);
        mainWindow.setModal(true);
        mainWindow.setVisible(true);
        // new UpdateWindow2().start();
    }

    private static void addItems()
    {
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(10, 10, mainWindow.getWidth() - (16 + 20), 35);
        progressBar.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        progressBar.setOpaque(true);
        progressBar.setBackground(new Color(45, 45, 45, 255));
        progressBar.setForeground(new Color(208, 208, 208, 255));
        panel.add(progressBar);

        title = new JLabel();
        title.setBounds(10, 10 + 40, mainWindow.getWidth() - (16 + 20), 35);
        title.setBackground(new Color(45, 45, 45, 255));
        title.setForeground(Color.decode("#eeeeee"));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(title);

        pushButton = new PushButton("终止生成");
        pushButton.getPushButton().setBounds((((mainWindow.getWidth() - 16) - 20) - 119) / 2, 10 + 40 + 35 + 10, 119, 35);
        pushButton.getPushButton().setHorizontalAlignment(SwingConstants.CENTER);
        pushButton.getPushButton().setVerticalAlignment(SwingConstants.CENTER);
        pushButton.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (eventType.equals("mouseClicked") && mouseEvent.getButton() == 1)
                {
                    clickedConnect.accept(mouseEvent, eventType);
                }
            }
        });
        panel.add(pushButton.getPushButton());
    }

    public static void updateProgress(String title, int value)
    {
        if (progressBar != null)
        {
            progressBar.setValue(value);
            ProgressBarWindow.title.setText(title);
            mainWindow.setTitle(title);
        }
    }

    public static JDialog getMainWindow()
    {
        return mainWindow;
    }

    public static JProgressBar getProgressBar()
    {
        return progressBar;
    }

    public static JPanel getPanel()
    {
        return panel;
    }

    public static PushButton getPushButton()
    {
        return pushButton;
    }

    public static ClickedConnect getClickedConnect()
    {
        return clickedConnect;
    }
}