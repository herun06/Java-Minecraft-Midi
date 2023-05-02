package main.java.com.xfherun.jmci.user_interface.section;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.normal.XFList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.debugjmci.DebugJMCIWIndow;
import main.java.com.xfherun.jmci.user_interface.section.page_1.DrawPianoKeys;
import main.java.com.xfherun.jmci.user_interface.section.page_1.file_system.InitList;
import main.java.com.xfherun.jmci.user_interface.section.page_1.file_system.RightMenu;
import main.java.com.xfherun.jmci.user_interface.section.page_1.tool.Tool;
import main.java.com.xfherun.jmci.utils.AudioFilePlayer;
import main.java.com.xfherun.jmci.utils.PlaySound;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;

public class MainContainerPage_1
{
    private static JPanel mainContainerPanel;
    private static JPanel pianoKeyBox;
    private static JTextField setMidiChannel;
    private static JLabel setMidiChannelTitle;
    private static JTextField setMidiProgram;
    private static JLabel setMidiProgramTitle;
    private static JTextField setMidiControl;
    private static JLabel setMidiControlTitle;
    private static XFButton doneMidiInformationSetting;
    private static XFButton back;
    private static XFButton selectLocalJMCIFileButton;
    private static XFButton startPlaySongButton;
    private static XFButton pausePlaySongButton;
    private static XFButton stopSongButton;
    private static JProgressBar songProgressSlider;
    private static JTextField showMidiPlaySourceFile;
    private static XFButton updateJMCISourceOptionButton;
    private static JLabel showTimeBar;

    private MainContainerPage_1()
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
        pianoKeyBox = DrawPianoKeys.draw(mainContainerPanel.getWidth(), (mainContainerPanel.getHeight() / 2) -
                (mainContainerPanel.getHeight() / 4) - mainContainerPanel.getHeight() / 8);
        pianoKeyBox.setLocation(0, (mainContainerPanel.getHeight() - pianoKeyBox.getHeight()) / 2);
        mainContainerPanel.add(pianoKeyBox);

        setMidiChannel = new JTextField("0");
        setMidiProgram = new JTextField("0");
        setMidiControl = new JTextField("0=0");

        setMidiChannelTitle = new JLabel("设置midi通道: ");
        setMidiChannelTitle.setBounds(10, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10, 119, 35);
        setMidiChannelTitle.setOpaque(true);
        setMidiChannelTitle.setBackground(new Color(0, 0, 0, 0));
        setMidiChannelTitle.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(setMidiChannelTitle);
        setMidiChannel.setBounds(10 + 119 + 5, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10, 200, 35);
        setMidiChannel.setOpaque(true);
        setMidiChannel.setBackground(new Color(0, 0, 0, 0));
        setMidiChannel.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(setMidiChannel);

        setMidiProgramTitle = new JLabel("设置midi程序: ");
        setMidiProgramTitle.setBounds(10, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + 35, 119, 35);
        setMidiProgramTitle.setOpaque(true);
        setMidiProgramTitle.setBackground(new Color(0, 0, 0, 0));
        setMidiProgramTitle.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(setMidiProgramTitle);
        setMidiProgram.setBounds(10 + 119 + 5, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + 35, 200, 35);
        setMidiProgram.setOpaque(true);
        setMidiProgram.setBackground(new Color(0, 0, 0, 0));
        setMidiProgram.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(setMidiProgram);

        setMidiControlTitle = new JLabel("设置midi控制: ");
        setMidiControlTitle.setBounds(10, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + (35 * 2), 119, 35);
        setMidiControlTitle.setOpaque(true);
        setMidiControlTitle.setBackground(new Color(0, 0, 0, 0));
        setMidiControlTitle.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(setMidiControlTitle);
        setMidiControl.setBounds(10 + 119 + 5, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + (35 * 2), 200, 35);
        setMidiControl.setOpaque(true);
        setMidiControl.setBackground(new Color(0, 0, 0, 0));
        setMidiControl.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(setMidiControl);

        back = new XFButton("返回主界面");
        back.setSize(new int[]{119, 35});
        back.setLocation(new int[]{10, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + (35 * 3) + 2});
        back.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPageHome.setPageToCurrent(0);
            }
        });
        back.addWindow(mainContainerPanel);

        doneMidiInformationSetting = new XFButton("完成设置");
        doneMidiInformationSetting.setSize(new int[]{100, 35});
        doneMidiInformationSetting.setLocation(new int[]{10 + 119 + 5, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + (35 * 3) + 2});
        doneMidiInformationSetting.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                String channel = setMidiChannel.getText();
                String program = setMidiProgram.getText();
                String control = setMidiControl.getText();
                try
                {
                    int temp = Integer.parseInt(channel);
                    if (temp < 0 || temp > 15) setMidiChannel.setText("0");
                }
                catch (NumberFormatException e)
                {
                    setMidiChannel.setText("0");
                }
                try
                {
                    int temp = Integer.parseInt(program);
                    if (temp < 0 || temp > 127) setMidiProgram.setText("0");
                }
                catch (NumberFormatException e)
                {
                    setMidiProgram.setText("0");
                }
                int eqIndex = 0;
                int count = 0;
                for (int i = 0; i < control.length(); i++)
                {
                    char c = control.charAt(i);
                    if (c == '=')
                    {
                        eqIndex = i;
                        count++;
                    }
                }
                if (count != 1) setMidiControl.setText("0=0");
                else
                {
                    String left = control.substring(0, eqIndex);
                    String right = control.substring(eqIndex + 1, control.length());
                    try
                    {
                        int test = Integer.parseInt(left);
                        if (test < 0 || test > 127) setMidiControl.setText("0=0");
                    }
                    catch (NumberFormatException e)
                    {
                        setMidiControl.setText("0=0");
                    }
                    try
                    {
                        int test = Integer.parseInt(right);
                        if (test < 0 || test > 127) setMidiControl.setText("0=0");
                    }
                    catch (NumberFormatException e)
                    {
                        setMidiControl.setText("0=0");
                    }
                }

                channel = setMidiChannel.getText();
                program = setMidiProgram.getText();
                control = setMidiControl.getText();

                int channel_int = Integer.parseInt(channel);
                int program_int = Integer.parseInt(program);
                eqIndex = 0;
                count = 0;
                for (int i = 0; i < control.length(); i++)
                {
                    char c = control.charAt(i);
                    if (c == '=')
                    {
                        eqIndex = i;
                        count++;
                    }
                }
                if (count != 1) setMidiControl.setText("0=0");
                else
                {
                    String left = control.substring(0, eqIndex);
                    String right = control.substring(eqIndex + 1, control.length());
                    CurrentPianoInformation.currentMidiChannel = channel_int;
                    int left_int = Integer.parseInt(left);
                    int right_int = Integer.parseInt(right);
                    MidiOut.setProgram(CurrentPianoInformation.currentMidiChannel, program_int);
                    MidiOut.setControl(CurrentPianoInformation.currentMidiChannel, left_int, right_int);
                }
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                Tool.init();
            }
        });
        doneMidiInformationSetting.addWindow(mainContainerPanel);

        updateJMCISourceOptionButton = new XFButton("调试JMCI");
        updateJMCISourceOptionButton.setBounds(10 + 119 + 5 + 100, (pianoKeyBox.getY() + pianoKeyBox.getHeight()) + 10 + (35 * 4) + 2 - 15, 100, 35);
        updateJMCISourceOptionButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                new Thread(() -> DebugJMCIWIndow.init()).start();
            }
        });
        updateJMCISourceOptionButton.setEnabled(false);
        updateJMCISourceOptionButton.addWindow(mainContainerPanel);

        selectLocalJMCIFileButton = new XFButton("选择文件进行播放");
        selectLocalJMCIFileButton.setLocation(new int[]{10 + 119 + 10 + 200 + 10, setMidiChannel.getY()});
        selectLocalJMCIFileButton.setSize(new int[]{200, 35});
        selectLocalJMCIFileButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                InitList.init();
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                RightMenu.init();
            }

            @Override
            public void mouseRightDouble(MouseEvent event)
            {
                XFLog.info("清空缓存JMCI");
                int option = JOptionPane.showConfirmDialog(MainWindow.getMainWindow(),
                        "你确定要清空缓存吗？",
                        "警告", 0, 2);
                if (option == 0)
                {
                    File cacheJMCI = new File("cache/jmci");
                    XFLog.info("开始清空, 目标路径: " + cacheJMCI);
                    File[] list = cacheJMCI.listFiles();
                    for (File file : list)
                    {
                        String path = file.toString();
                        String fileType = path.substring(path.length() - 5, path.length());
                        if (fileType.equalsIgnoreCase(".jmci"))
                        {
                            file.delete();
                            XFLog.info("成功删除: " + file);
                        }
                    }
                }
            }
        });
        selectLocalJMCIFileButton.addWindow(mainContainerPanel);

        startPlaySongButton = new XFButton("播放");
        pausePlaySongButton = new XFButton("暂停");
        stopSongButton = new XFButton("终止");

        startPlaySongButton.setEnabled(false);
        pausePlaySongButton.setEnabled(false);
        stopSongButton.setEnabled(false);

        int btnWidth = (((mainContainerPanel.getWidth() - (10 + 119 + 10 + 200 + 10 + 200 + 5)) - 10) - 10) / 3;
        startPlaySongButton.setBounds(
                10 + 119 + 10 + 200 + 10 + 200 + 5,
                setMidiChannel.getY(), btnWidth, 35
        );
        pausePlaySongButton.setBounds(
                10 + 119 + 10 + 200 + 10 + 200 + 5 + (btnWidth - 5) + 5,
                setMidiChannel.getY(), btnWidth, 35
        );
        stopSongButton.setBounds(
                10 + 119 + 10 + 200 + 10 + 200 + 5 + ((btnWidth - 5) * 2) + (5 * 2),
                setMidiChannel.getY(), btnWidth, 35
        );

        startPlaySongButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StartReadJMCIFileContentData.startPlay();
            }
        });

        pausePlaySongButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StartReadJMCIFileContentData.pausePlay();
            }
        });

        stopSongButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StartReadJMCIFileContentData.endPlay();
            }
        });

        startPlaySongButton.addWindow(mainContainerPanel);
        pausePlaySongButton.addWindow(mainContainerPanel);
        stopSongButton.addWindow(mainContainerPanel);

        songProgressSlider = new JProgressBar(0, CurrentPianoInformation.currentSongMaxValue);
        songProgressSlider.setValue(0);
        songProgressSlider.setOpaque(true);
        songProgressSlider.setEnabled(false);
        songProgressSlider.setBackground(new Color(0, 0, 0, 0));
        songProgressSlider.setForeground(new Color(159, 222, 13, 255));
        songProgressSlider.setBorder(new LineBorder(new Color(210, 210, 210, 255)));
        songProgressSlider.setBounds(
                10 + 119 + 10 + 200 + 10,
                setMidiProgram.getY(),
                (mainContainerPanel.getWidth() - (10 + 119 + 10 + 200 + 10)) - 10,
                35
        );
        mainContainerPanel.add(songProgressSlider);

        showMidiPlaySourceFile = new JTextField("当前没有可播放的文件");
        showMidiPlaySourceFile.setBounds(10 + 119 + 10 + 200 + 10,
                setMidiProgram.getY() + (35 * 2) - 14,
                (mainContainerPanel.getWidth() - (10 + 119 + 10 + 200 + 10)) - 10,
                35);
        showMidiPlaySourceFile.setOpaque(true);
        showMidiPlaySourceFile.setBackground(new Color(0, 0, 0, 0));
        showMidiPlaySourceFile.setForeground(Color.decode("#eeeeee"));
        showMidiPlaySourceFile.setBorder(new LineBorder(new Color(0, 0, 0, 0)));
        showMidiPlaySourceFile.setEditable(false);
        showMidiPlaySourceFile.setSelectionColor(new Color(0, 0, 0, 0));
        showMidiPlaySourceFile.setSelectedTextColor(Color.decode("#eeeeee"));
        mainContainerPanel.add(showMidiPlaySourceFile);

        showTimeBar = new JLabel("剩余时间: ××秒", JLabel.CENTER);
        showTimeBar.setBounds(10 + 119 + 10 + 200 + 10, mainContainerPanel.getHeight() - 35, mainContainerPanel.getWidth() - (10 + 119 + 10 + 200 + 10), 35);
        showTimeBar.setOpaque(true);
        showTimeBar.setFont(new Font("新宋体", 0, 15));
        showTimeBar.setBackground(new Color(0, 0, 0, 0));
        showTimeBar.setForeground(Color.decode("#eeeeee"));
        mainContainerPanel.add(showTimeBar);
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

    public static JPanel getPianoKeyBox()
    {
        return pianoKeyBox;
    }

    public static JTextField getSetMidiChannel()
    {
        return setMidiChannel;
    }

    public static JLabel getSetMidiChannelTitle()
    {
        return setMidiChannelTitle;
    }

    public static JTextField getSetMidiProgram()
    {
        return setMidiProgram;
    }

    public static JTextField getSetMidiControl()
    {
        return setMidiControl;
    }

    public static JLabel getSetMidiProgramTitle()
    {
        return setMidiProgramTitle;
    }

    public static JLabel getSetMidiControlTitle()
    {
        return setMidiControlTitle;
    }

    public static XFButton getDoneMidiInformationSetting()
    {
        return doneMidiInformationSetting;
    }

    public static XFButton getBack()
    {
        return back;
    }

    public static XFButton getSelectLocalJMCIFileButton()
    {
        return selectLocalJMCIFileButton;
    }

    public static XFButton getStartPlaySongButton()
    {
        return startPlaySongButton;
    }

    public static XFButton getPausePlaySongButton()
    {
        return pausePlaySongButton;
    }

    public static XFButton getStopSongButton()
    {
        return stopSongButton;
    }

    public static JProgressBar getSongProgressSlider()
    {
        return songProgressSlider;
    }

    public static JTextField getShowMidiPlaySourceFile()
    {
        return showMidiPlaySourceFile;
    }

    public static XFButton getUpdateJMCISourceOptionButton()
    {
        return updateJMCISourceOptionButton;
    }

    public static JLabel getShowTimeBar()
    {
        return showTimeBar;
    }
}




