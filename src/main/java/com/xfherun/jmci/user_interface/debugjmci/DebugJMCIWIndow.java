/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.debugjmci;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.utils.StopAllMidiDeviceSound;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DebugJMCIWIndow extends JDialog
{
    private static JDialog mainWindow;
    private static JPanel mainContainer;
    private static XFButton doneBPM;
    private static int tempBpm;
    private static XFButton timePitchButton;
    private static XFButton addPitchButton;
    private static JTextField pitchField;

    private DebugJMCIWIndow()
    {
    }

    public static void init()
    {
        XFLog.info("初始化调试窗口中");
        createWindow();
        addItems();
        mainWindow.setVisible(true);
        XFLog.info("初始化完毕");
    }

    private static void createMainContainer()
    {
        mainContainer = new JPanel();
        mainContainer.setBounds(0, 0, mainWindow.getWidth() - 16, mainWindow.getHeight() - 39);
        mainContainer.setLayout(null);
        mainContainer.setOpaque(true);
        mainContainer.setBackground(new Color(8, 104, 182, 255));
        addToMainContainer();
        mainWindow.getContentPane().add(mainContainer);
    }

    private static void addToMainContainer()
    {
        XFLog.info("设置BPM");
        doneBPM = new XFButton("设置BPM");
        doneBPM.setBounds((5 + ((mainContainer.getWidth() - 10) - 119)) / 2, 5, 119, 35);
        doneBPM.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                String debugOption = null;
                if (CurrentPianoInformation.currentBPM == -119.119)
                    debugOption = (String) JOptionPane.showInputDialog(mainWindow,
                            "输入指定的bpm: ",
                            "调试", 1, null, null, "" + StartReadJMCIFileContentData.getJmciBPM());
                else debugOption = (String) JOptionPane.showInputDialog(mainWindow,
                        "输入指定的bpm: ",
                        "调试", 1, null, null, CurrentPianoInformation.currentBPM);
                if (debugOption != null && !debugOption.equals(""))
                {
                    try
                    {
                        double bpm = Double.parseDouble(debugOption);
                        long time = (long) (1000 / (bpm / 2.5));
                        if (time > 0 && time <= 1000)
                        {
                            StartReadJMCIFileContentData.setTime(time);
                            CurrentPianoInformation.currentBPM = bpm;
                            XFLog.info("BPM成功设置为: " + bpm);
                        }
                        else
                        {
                            XFLog.warn("请输入正确的数: " + bpm + " : " + time);
                            JOptionPane.showMessageDialog(mainWindow,
                                    "请输入正确的数: " + bpm + " : " + time,
                                    "警告", 2);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        XFLog.warn("请提供有效的帧(BPM)", e);
                        JOptionPane.showMessageDialog(mainWindow,
                                "请提供有效的帧(BPM)",
                                "警告", 2);
                    }
                }
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                StartReadJMCIFileContentData.setTime(StartReadJMCIFileContentData.getJmciTickRateBackup());
                XFLog.info("已还原帧(BPM): " + StartReadJMCIFileContentData.getJmciBPM() + ",\n每秒的帧数是: " + StartReadJMCIFileContentData.getJmciTickRate());
                JOptionPane.showMessageDialog(mainWindow,
                        "已还原帧(BPM): " + StartReadJMCIFileContentData.getJmciBPM() + ",\n每秒的帧数是: " + StartReadJMCIFileContentData.getJmciTickRate());
            }
        });
        doneBPM.addWindow(mainContainer);

        timePitchButton = new XFButton("左移音高");
        addPitchButton = new XFButton("右移音高");
        pitchField = new JTextField("" + CurrentPianoInformation.movePitch, JTextField.CENTER);

        int margin = 1;
        int timePitchButtonWidth = 119;
        int addPitchButtonWidth = 119;
        int pitchFieldWidth = 119;

        int height = 35;

        int allWidth = timePitchButtonWidth + addPitchButtonWidth + pitchFieldWidth + (margin * 3);
        int startPos_x = (mainContainer.getWidth() - allWidth) / 2;
        int startPos_y = 40;

        timePitchButton.setBounds(startPos_x, startPos_y, timePitchButtonWidth, height);
        pitchField.setBounds(startPos_x + timePitchButtonWidth + margin, startPos_y, timePitchButtonWidth, height);
        addPitchButton.setBounds(startPos_x + (timePitchButtonWidth + addPitchButtonWidth) + margin, startPos_y, timePitchButtonWidth, height);

        pitchField.setOpaque(true);
        pitchField.setBackground(new Color(8, 104, 182, 255));
        pitchField.setForeground(Color.decode("#eeeeee"));
        pitchField.setCaretColor(Color.decode("#eeeeee"));

        timePitchButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StopAllMidiDeviceSound.stopAll2();
                boolean format = format(pitchField.getText(), pitchField, 0);
                XFLog.info("音高移动步数: " + format);
                if (!format)
                {
                    XFLog.warn("\"" + pitchField.getText() + "\" 不是一个有效的整形");
                    JOptionPane.showMessageDialog(mainWindow,
                            "\"" + pitchField.getText() + "\" 不是一个有效的整形",
                            "警告", 2);
                }
            }
        });

        addPitchButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StopAllMidiDeviceSound.stopAll2();
                boolean format = format(pitchField.getText(), pitchField, 1);
                XFLog.info("音高移动步数: " + format);
                if (!format)
                {
                    XFLog.warn("\"" + pitchField.getText() + "\" 不是一个有效的整形");
                    JOptionPane.showMessageDialog(mainWindow,
                            "\"" + pitchField.getText() + "\" 不是一个有效的整形",
                            "警告", 2);
                }
            }
        });

        pitchField.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1 && e.getClickCount() == 2)
                {
                    StopAllMidiDeviceSound.stopAll2();
                    CurrentPianoInformation.movePitch = 0;
                    pitchField.setText("0");
                    XFLog.info("默认音高为: 0");
                }
            }

            @Override
            public void mousePressed(MouseEvent e)
            {

            }

            @Override
            public void mouseReleased(MouseEvent e)
            {

            }

            @Override
            public void mouseEntered(MouseEvent e)
            {

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
        pitchField.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                int code = e.getKeyCode();
                if (code == 10)
                {
                    try
                    {
                        int step = Integer.parseInt(pitchField.getText());
                        CurrentPianoInformation.movePitch = step;
                        XFLog.info("步数: " + step);
                    }
                    catch (NumberFormatException ex)
                    {
                        XFLog.warn("\"" + pitchField.getText() + "\" 不是一个有效的整形", ex);
                        JOptionPane.showMessageDialog(mainWindow,
                                "\"" + pitchField.getText() + "\" 不是一个有效的整形",
                                "警告", 2);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });

        timePitchButton.addWindow(mainWindow);
        mainContainer.add(pitchField);
        addPitchButton.addWindow(mainWindow);
    }

    private static void addItems()
    {
        createMainContainer();
    }

    private static boolean format(String args, JTextField field, int flag)
    {
        XFLog.info("格式化音高: " + args + ", " + field + ", " + field);
        try
        {
            int step = Integer.parseInt(args);
            if (flag == 1)
            {
                field.setText("" + (step + 1));
                CurrentPianoInformation.movePitch = step + 1;
            }
            else if (flag == 0)
            {
                field.setText("" + (step - 1));
                CurrentPianoInformation.movePitch = step - 1;
            }
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    private static void createWindow()
    {
        mainWindow = new JDialog();
        mainWindow.setTitle("调试JMCI");
        mainWindow.setSize(400, 400);
        mainWindow.setResizable(false);
        mainWindow.setLayout(null);
        mainWindow.setLocationRelativeTo(MainWindow.getMainWindow());
        mainWindow.setModal(true);
    }
}
