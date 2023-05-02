package main.java.com.xfherun.jmci.midi;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.soundfont.sf2.SoundFont;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_1;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_2;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.AllNoteBlockData;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.ConnectPianoAllKeys;
import main.java.com.xfherun.jmci.utils.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class StartReadJMCIFileContentData
{
    private static ArrayList<ArrayList<String[]>> list = new ArrayList<>();
    private static double jmciBPM;
    private static double jmciTickRate;
    private static long jmciTickRateBackup;
    private static long time = -999999999;
    private static boolean stopPlaySong = false;
    private static boolean stopPlaySong2 = false;
    private static int currentP = -1;

    private StartReadJMCIFileContentData()
    {
    }

    private static void header(String string)
    {
        XFLog.info("获取文件的头信息");
        ArrayList<Integer> jkhIndex = new ArrayList<>();
        for (int i = 0; i < string.length(); i++)
        {
            char c = string.charAt(i);
            if (c == '<') jkhIndex.add(i);
            if (c == '>') jkhIndex.add(i);
        }
        for (int i = 0; i < jkhIndex.size(); i += 2)
        {
            int startIndex = jkhIndex.get(i) + 1;
            int endIndex = jkhIndex.get(i + 1);
            String result = string.substring(startIndex, endIndex);
            int eqPos = 0;
            int count = 0;
            for (int j = 0; j < result.length(); j++)
            {
                char c = result.charAt(j);
                if (c == '=')
                {
                    eqPos = j;
                    count++;
                }
            }
            if (count != 1) throw new RuntimeException("在解析jmci文件时出现异常, 可能是因为文件损坏或更改。重新编译即可！");
            else
            {
                String keyName = result.substring(0, eqPos);
                String keyValue = result.substring(eqPos + 1, result.length());
                if (keyName.equals("BPM"))
                {
                    try
                    {
                        double bpm = Double.parseDouble(keyValue);
                        jmciBPM = bpm;
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("在解析jmci文件时出现异常, 可能是因为文件损坏或更改。重新编译即可！");
                    }
                }
                if (keyName.equals("FRAME"))
                {
                    try
                    {
                        double frame = Double.parseDouble(keyValue);
                        jmciTickRate = frame;
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("在解析jmci文件时出现异常, 可能是因为文件损坏或更改。重新编译即可！");
                    }
                }
            }
        }

        int t = 1000;
        long temp = (long) jmciTickRate;
        long sc = t;
        time = (sc / temp);
        // time = temp;
        jmciTickRateBackup = (sc / temp);
        XFLog.info("BPM: " + jmciBPM + ", 帧: " + jmciTickRateBackup);
    }

    private static ArrayList<String> header_JNI_OPEN(String string)
    {
        ArrayList<String> arrayListLong = new ArrayList<>();
        XFLog.info("获取文件的头信息 :: JNI_OPEN");
        ArrayList<Integer> jkhIndex = new ArrayList<>();
        for (int i = 0; i < string.length(); i++)
        {
            char c = string.charAt(i);
            if (c == '<') jkhIndex.add(i);
            if (c == '>') jkhIndex.add(i);
        }
        for (int i = 0; i < jkhIndex.size(); i += 2)
        {
            int startIndex = jkhIndex.get(i) + 1;
            int endIndex = jkhIndex.get(i + 1);
            String result = string.substring(startIndex, endIndex);
            int eqPos = 0;
            int count = 0;
            for (int j = 0; j < result.length(); j++)
            {
                char c = result.charAt(j);
                if (c == '=')
                {
                    eqPos = j;
                    count++;
                }
            }
            if (count != 1) throw new RuntimeException("在解析jmci文件时出现异常, 可能是因为文件损坏或更改。重新编译即可！");
            else
            {
                String keyName = result.substring(0, eqPos);
                String keyValue = result.substring(eqPos + 1, result.length());
                if (keyName.equals("BPM"))
                {
                    try
                    {
                        double bpm = Double.parseDouble(keyValue);
                        arrayListLong.add(String.valueOf(bpm));
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("在解析jmci文件时出现异常, 可能是因为文件损坏或更改。重新编译即可！");
                    }
                }
                if (keyName.equals("FRAME"))
                {
                    try
                    {
                        double frame = Double.parseDouble(keyValue);
                        arrayListLong.add(String.valueOf(frame));
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("在解析jmci文件时出现异常, 可能是因为文件损坏或更改。重新编译即可！");
                    }
                }
            }
        }

        int t = 1000;
        long temp = (long) ((double) (Double.parseDouble(arrayListLong.get(1))));
        long sc = t;
        long time = (sc / temp);
        arrayListLong.add(String.valueOf(time));

        XFLog.info("BPM: " + arrayListLong.get(0) + ", 帧: " + arrayListLong.get(1));
        XFLog.debug(arrayListLong);
        return arrayListLong;
    }

    public static void startRead(File file)
    {
        XFLog.info("读取主要文件内容");
        list.clear();
        String allJMCIData = ReadTextFile.readAllToString(file);
        header(allJMCIData);
        ArrayList<Integer> zkhIndex = new ArrayList<>();
        for (int i = 0; i < allJMCIData.length(); i++)
        {
            char c = allJMCIData.charAt(i);
            if (c == '[') zkhIndex.add(i);
            if (c == ']') zkhIndex.add(i);
        }

        ArrayList<String> command = new ArrayList<>();
        for (int i = 0; i < zkhIndex.size(); i += 2)
        {
            int startIndex = zkhIndex.get(i) + 1;
            int endIndex = zkhIndex.get(i + 1);
            String result = allJMCIData.substring(startIndex, endIndex);
            command.add(result);
        }
        splitCommand(command);
        new Thread(() -> playSong()).start();
        // testOutput();
        MainContainerPage_1.getShowMidiPlaySourceFile().setText("当前文件: " + file);
        XFLog.info("读取完毕: 当前文件: " + file);
    }

    public static ArrayList<ArrayList<String[]>> openToString(File file)
    {
        XFLog.info("开始读取主要文件内容");
        list.clear();
        String allJMCIData = ReadTextFile.readAllToString(file);
        header(allJMCIData);
        ArrayList<Integer> zkhIndex = new ArrayList<>();
        for (int i = 0; i < allJMCIData.length(); i++)
        {
            char c = allJMCIData.charAt(i);
            if (c == '[') zkhIndex.add(i);
            if (c == ']') zkhIndex.add(i);
        }

        ArrayList<String> command = new ArrayList<>();
        for (int i = 0; i < zkhIndex.size(); i += 2)
        {
            int startIndex = zkhIndex.get(i) + 1;
            int endIndex = zkhIndex.get(i + 1);
            String result = allJMCIData.substring(startIndex, endIndex);
            command.add(result);
        }
        splitCommand(command);
        XFLog.info("读取完毕");
        return list;
    }

    public static ArrayList<ArrayList<String[]>> JNI_OPEN(File file)
    {
        XFLog.info("开始读取主要文件内容 :: JNI_OPEN");
        XFLog.info("清除缓存::内存");
        list.clear();
        String allJMCIData = ReadTextFile.readAllToString(file);
        ArrayList<String> objects = header_JNI_OPEN(allJMCIData);
        String[] ooo = new String[objects.size()];
        for (int i = 0; i < objects.size(); i++) ooo[i] = objects.get(i);
        ArrayList<Integer> zkhIndex = new ArrayList<>();
        for (int i = 0; i < allJMCIData.length(); i++)
        {
            char c = allJMCIData.charAt(i);
            if (c == '[') zkhIndex.add(i);
            if (c == ']') zkhIndex.add(i);
        }

        ArrayList<String> command = new ArrayList<>();
        for (int i = 0; i < zkhIndex.size(); i += 2)
        {
            int startIndex = zkhIndex.get(i) + 1;
            int endIndex = zkhIndex.get(i + 1);
            String result = allJMCIData.substring(startIndex, endIndex);
            command.add(result);
        }
        splitCommand(command);
        XFLog.info("读取完毕");
        ArrayList<String[]> objects1 = new ArrayList<>();
        objects1.add(ooo);
        list.add(0, objects1);
        return list;
    }

    public static void splitFile(String allJMCIData)
    {
        XFLog.info("拆分参数");
        ArrayList<Integer> zkhIndex = new ArrayList<>();
        for (int i = 0; i < allJMCIData.length(); i++)
        {
            char c = allJMCIData.charAt(i);
            if (c == '[') zkhIndex.add(i);
            if (c == ']') zkhIndex.add(i);
        }

        ArrayList<String> command = new ArrayList<>();
        for (int i = 0; i < zkhIndex.size(); i += 2)
        {
            int startIndex = zkhIndex.get(i) + 1;
            int endIndex = zkhIndex.get(i + 1);
            String result = allJMCIData.substring(startIndex, endIndex);
            command.add(result);
        }
        splitCommand(command);
        XFLog.info("完成");
    }

    private static void splitCommand(ArrayList<String> commandList)
    {
        XFLog.info("拆分命令");
        ArrayList<String[]> lineCommand = new ArrayList<>();
        for (int i = 0; i < commandList.size(); i++)
        {
            ArrayList<String[]> commandAndArgsArrayList = new ArrayList<>();
            String subCommand = commandList.get(i);
            int startIndex = 0;
            int endIndex = 0;
            int count = 0;
            ArrayList<String> lineCommandArrayList = new ArrayList<>();
            for (int j = 0; j < subCommand.length(); j++)
            {
                char c = subCommand.charAt(j);
                if (c == '|')
                {
                    endIndex = j;
                    String result = subCommand.substring(startIndex, endIndex);
                    lineCommandArrayList.add(result);
                    count++;
                }
                if (count != 0) startIndex = endIndex + 1;
            }
            String result = subCommand.substring(startIndex, subCommand.length());
            lineCommandArrayList.add(result);
            for (int j = 0; j < lineCommandArrayList.size(); j++)
            {
                String commandAndArgs = lineCommandArrayList.get(j);
                ArrayList<String> argsList = new ArrayList<>();
                int startIndexArgs = 0;
                int endIndexArgs = 0;
                int countIndexArgs = 0;
                for (int k = 0; k < commandAndArgs.length(); k++)
                {
                    char c = commandAndArgs.charAt(k);
                    if (c == ' ')
                    {
                        endIndexArgs = k;
                        String args = commandAndArgs.substring(startIndexArgs, endIndexArgs);
                        argsList.add(args);
                        countIndexArgs++;
                    }
                    if (countIndexArgs != 0) startIndexArgs = endIndexArgs + 1;
                }
                String args = commandAndArgs.substring(startIndexArgs, commandAndArgs.length());
                argsList.add(args);
                String[] argsArray = new String[argsList.size()];
                for (int k = 0; k < argsArray.length; k++) argsArray[k] = argsList.get(k);
                commandAndArgsArrayList.add(argsArray);
            }
            list.add(commandAndArgsArrayList);
        }
        XFLog.info("完成");
    }

    public static void testOutput(ArrayList<ArrayList<String[]>> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            ArrayList<String[]> arrayList = list.get(i);
            XFLog.stdout("第 " + (i + 1) + " 帧:");
            for (int j = 0; j < arrayList.size(); j++)
            {
                String[] strings = arrayList.get(j);
                XFLog.stdout("    " + Arrays.toString(strings));
            }
        }
    }

    private static int getMidiSongMaxValue()
    {
        return list.size();
    }

    private static void initInterface()
    {
        XFLog.info("初始化...");
        MainContainerPage_1.getShowTimeBar().setText("剩余时间: ××秒");
        MainContainerPage_1.getSongProgressSlider().setEnabled(true);
        MainContainerPage_1.getSongProgressSlider().setMaximum(getMidiSongMaxValue());
        MainContainerPage_1.getStartPlaySongButton().setEnabled(true);
        MainContainerPage_1.getPausePlaySongButton().setEnabled(false);
        MainContainerPage_1.getStopSongButton().setEnabled(true);
        MainContainerPage_1.getSelectLocalJMCIFileButton().setEnabled(false);
        MainContainerPage_1.getUpdateJMCISourceOptionButton().setEnabled(false);
        CurrentPianoInformation.currentSongProgress = 0;
        CurrentPianoInformation.movePitch = 0;
    }

    private static void unInitInterface()
    {
        XFLog.info("反向初始化...");
        if (CurrentPianoInformation.isEnableSoundFontPlay)
        {
            MainContainerPage_1.getShowMidiPlaySourceFile().setText("当前没有可播放的文件");
            MainContainerPage_1.getShowTimeBar().setText("剩余时间: ××秒");
        }
        MainContainerPage_1.getSongProgressSlider().setEnabled(false);
        MainContainerPage_1.getSongProgressSlider().setMaximum(0);
        MainContainerPage_1.getStartPlaySongButton().setEnabled(false);
        MainContainerPage_1.getPausePlaySongButton().setEnabled(false);
        MainContainerPage_1.getStopSongButton().setEnabled(false);
        MainContainerPage_1.getSelectLocalJMCIFileButton().setEnabled(true);
        MainContainerPage_1.getUpdateJMCISourceOptionButton().setEnabled(false);
        CurrentPianoInformation.currentSongProgress = 0;
        CurrentPianoInformation.movePitch = 0;
        list.clear();
        ConnectPianoAllKeys.getPianoNoteBlockTempArrayList().clear();
        // new Thread(StartReadJMCIFileContentData::reopenMidiDevice).start();
        reopenMidiDevice();
        if (!CurrentPianoInformation.isEnableSoundFontPlay)
        {
            MainContainerPage_1.getShowMidiPlaySourceFile().setText("当前没有可播放的文件");
            MainContainerPage_1.getShowTimeBar().setText("剩余时间: ××秒");
        }
        for (int i = 0; i < AllNoteBlockData.list.size(); i++)
            MainContainerPage_1.getMainContainerPanel().remove(AllNoteBlockData.list.get(i));
        AllNoteBlockData.list.clear();
        CurrentPianoInformation.currentBPM = -119.119;
    }

    private static void reopenMidiDevice()
    {
        XFLog.info("重新打开midi设备");
        if (!CurrentPianoInformation.isEnableSoundFontPlay)
        {
            Thread runnable = new Thread()
            {
                public void run()
                {
                    MidiOut.closeDevice();
                    MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
                }
            };
            runnable.start();
        }
        else
        {
            try
            {
                XFLog.info("加载SoundFont");
                SoundFont.loadSoundFont(CurrentPianoInformation.currentSoundFontFile.getAbsolutePath());
                XFLog.info("加载成功！");
            }
            catch (Exception e)
            {
                XFLog.warn("SoundFont加载失败！", e);
            }
        }
    }

    private static void reopenMidiDevice2()
    {
        XFLog.info("重新打开midi设备");
        if (!CurrentPianoInformation.isEnableSoundFontPlay)
        {
            MidiOut.closeDevice();
            MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
        }
        else
        {
            try
            {
                XFLog.info("加载SoundFont");
                SoundFont.loadSoundFont(CurrentPianoInformation.currentSoundFontFile.getAbsolutePath());
                XFLog.info("加载成功！");
            }
            catch (Exception e)
            {
                XFLog.warn("SoundFont加载失败！", e);
            }
        }
    }

    private static void setHandel()
    {
        XFLog.info("设置接口");
        JProgressBar songProgressSlider = MainContainerPage_1.getSongProgressSlider();
        songProgressSlider.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {

            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if (CurrentPianoInformation.isPlay)
                {
                    new Thread(StartReadJMCIFileContentData::initWindowToSetProgress).start();
                    throw new RuntimeException("Change progress complete!");
                }
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
    }

    private static void getTimeOut(long time2, int allFrame)
    {
        long time = time2 * allFrame;
        MainContainerPage_1.getShowTimeBar().setText("剩余时间: " + (time / 1000) + "秒");
    }

    public static void initWindowToSetProgress()
    {
        JDialog d = new JDialog();
        d.setTitle("设置进度: " + CurrentPianoInformation.currentSongProgress + " / " + getMidiSongMaxValue());
        d.setSize(400, 119 + 10);
        d.setLocationRelativeTo(MainWindow.getMainWindow());
        d.setLayout(null);
        d.setResizable(false);

        XFButton button = new XFButton("确认修改");
        button.setBounds((400 - 119) / 2, 40, 119, 35);
        button.addWindow(d);

        JLabel bg = new JLabel("");
        bg.setBounds(0, 0, 400, 119 + 10);
        bg.setOpaque(true);
        bg.setBackground(new Color(33, 155, 15, 255));
        bg.setForeground(new Color(0, 0, 0, 0));
        d.add(bg);

        JSlider slider = new JSlider(0, getMidiSongMaxValue());
        slider.setBounds(0, 0, 380, 35);
        slider.setOpaque(true);
        slider.setBackground(new Color(33, 155, 15, 255));
        slider.setValue(CurrentPianoInformation.currentSongProgress);
        slider.addMouseMotionListener(new MouseMotionListener()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                int value = slider.getValue();
                d.setTitle("设置进度: " + value + " / " + getMidiSongMaxValue());
            }

            @Override
            public void mouseMoved(MouseEvent e)
            {

            }
        });
        d.add(slider);

        button.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                int value = slider.getValue();
                if (value != 0 && value != getMidiSongMaxValue())
                {
                    StopAllMidiDeviceSound.stopAll();
                    DefaultAllPianoKeysColor.defaultPianoKeys();
                    CurrentPianoInformation.currentSongProgress = value;
                    d.setVisible(false);
                }
                else
                {
                    StopAllMidiDeviceSound.stopAll();
                    DefaultAllPianoKeysColor.defaultPianoKeys();
                    reopenMidiDevice();
                    if (value == 0) CurrentPianoInformation.currentSongProgress = 0;
                    else
                    {
                        if (!StaticValue.isLoopPlay)
                        {
                            stopPlaySong = true;
                            CurrentPianoInformation.currentSongProgress = 0;
                            currentP = -1;
                            unInitInterface();
                        }
                        else
                        {
                            CurrentPianoInformation.currentSongProgress = 0;
                            currentP = -1;
                        }
                    }
                    d.setVisible(false);
                }
                ConnectPianoAllKeys.getPianoNoteBlockTempArrayList().clear();
                MainContainerPage_1.getSongProgressSlider().setValue(CurrentPianoInformation.currentSongProgress);
            }
        });

        d.setModal(true);
        d.setVisible(true);
    }

    private static void playSong()
    {
        XFLog.info("文件准备中...");
        ConnectPianoAllKeys.getPianoNoteBlockTempArrayList().clear();
        setHandel();
        CurrentPianoInformation.isPlay = false;
        MainContainerPage_1.getSelectLocalJMCIFileButton().setEnabled(false);
        reopenMidiDevice();
        initInterface();
        XFLog.info("文件已准备, 等待播放!");
    }

    public static void endPlay()
    {
        XFLog.info("已终止播放");
        StopAllMidiDeviceSound.stopAll();
        DefaultAllPianoKeysColor.defaultPianoKeys();
        stopPlaySong = false;
        currentP = -1;
        CurrentPianoInformation.currentSongProgress = 0;
        Thread runnable = new Thread()
        {
            public void run()
            {
                MainContainerPage_1.getSongProgressSlider().setEnabled(false);
                MainContainerPage_1.getSongProgressSlider().setMaximum(0);
                MainContainerPage_1.getStartPlaySongButton().setEnabled(false);
                MainContainerPage_1.getPausePlaySongButton().setEnabled(false);
                MainContainerPage_1.getStopSongButton().setEnabled(false);
                MainContainerPage_1.getUpdateJMCISourceOptionButton().setEnabled(false);
            }
        };
        runnable.start();
        unInitInterface();
        CurrentPianoInformation.isPlay = false;
        MainContainerPage_1.getShowMidiPlaySourceFile().setText("当前没有可播放的文件");
    }

    public static void pausePlay()
    {
        XFLog.info("已暂停");
        StopAllMidiDeviceSound.stopAll();
        DefaultAllPianoKeysColor.defaultPianoKeys();
        for (int i = 0; i < AllNoteBlockData.list.size(); i++)
            MainContainerPage_1.getMainContainerPanel().remove(AllNoteBlockData.list.get(i));
        AllNoteBlockData.list.clear();
        stopPlaySong = true;
        currentP = CurrentPianoInformation.currentSongProgress;
        MainContainerPage_1.getSongProgressSlider().setEnabled(false);
        MainContainerPage_1.getSongProgressSlider().setMaximum(getMidiSongMaxValue());
        MainContainerPage_1.getStartPlaySongButton().setEnabled(true);
        MainContainerPage_1.getPausePlaySongButton().setEnabled(false);
        MainContainerPage_1.getStopSongButton().setEnabled(true);
        MainContainerPage_1.getUpdateJMCISourceOptionButton().setEnabled(false);
        MainContainerPage_1.getSelectLocalJMCIFileButton().setEnabled(false);
        CurrentPianoInformation.isPlay = false;
        ConnectPianoAllKeys.getPianoNoteBlockTempArrayList().clear();
    }

    public static void testStopSong()
    {
        XFLog.info("测试终止");
        stopPlaySong2 = true;
        reopenMidiDevice();
    }

    public static void testPlaySong(ArrayList<ArrayList<String[]>> list1)
    {
        XFLog.info("测试播放");
        list.clear();
        String write = GeneratorJMCIFile.write(list1);
        splitFile(write);

        Thread runnable = new Thread()
        {
            public void run()
            {
                for
                (
                        int i = 0;
                        i < list.size();
                        i++)
                {
                    if (stopPlaySong2)
                    {
                        stopPlaySong2 = false;
                        throw new RuntimeException("Success stopping!");
                    }
                    int finalI = i;
                    ArrayList<String[]> arrayList = list.get(i);
                    //XFLog.info("第 " + i + " 帧: ");
                    // if (arrayList.size() != 1) new Thread(() -> MainContainerPage_2.getFpsList().select(finalI)).start();
                    new Thread(() -> MainContainerPage_2.getFpsList().select(finalI)).start();
                    for (int j = 0; j < arrayList.size(); j++)
                    {
                        String[] strings = arrayList.get(j);
                        StartSplitCommandAndArgsAndPlaySong.splitTest(strings);
                    }
                    try
                    {
                        if (time >= 0) Thread.sleep(time);
                        else throw new RuntimeException("睡觉的时间必须要 >= 0");
                    }
                    catch (InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                MainContainerPage_2.getStartPlayButton().setEnabled(true);
                MainContainerPage_2.getStopPlayButton().setEnabled(false);
                MainContainerPage_1.getUpdateJMCISourceOptionButton().setEnabled(true);
                stopPlaySong2 = false;
                reopenMidiDevice();
                list.clear();
            }
        };
        runnable.start();
    }

    public static void startPlay()
    {
        XFLog.info("开始播放");
        ConnectPianoAllKeys.getPianoNoteBlockTempArrayList().clear();
        MainContainerPage_1.getSongProgressSlider().setEnabled(true);
        MainContainerPage_1.getSongProgressSlider().setMaximum(getMidiSongMaxValue());
        MainContainerPage_1.getStartPlaySongButton().setEnabled(false);
        MainContainerPage_1.getPausePlaySongButton().setEnabled(true);
        MainContainerPage_1.getStopSongButton().setEnabled(true);
        MainContainerPage_1.getUpdateJMCISourceOptionButton().setEnabled(true);
        MainContainerPage_1.getSelectLocalJMCIFileButton().setEnabled(false);
        CurrentPianoInformation.isPlay = true;
        stopPlaySong = false;
        Thread runnable = new Thread()
        {
            public void run()
            {
                do
                {
                    Sleep.sleep(new Random().nextInt(1000, 1234));
                    CurrentPianoInformation.currentSongProgress = 0;
                    if (currentP != -1) CurrentPianoInformation.currentSongProgress = currentP;
                    for
                    (
                            ;
                            CurrentPianoInformation.currentSongProgress < list.size();
                            CurrentPianoInformation.currentSongProgress++)
                    {
                        if (stopPlaySong)
                        {
                            CurrentPianoInformation.isPlay = false;
                            throw new RuntimeException("Success stopping!");
                        }
                        ArrayList<String[]> arrayList = list.get(CurrentPianoInformation.currentSongProgress);
                        for (int j = 0; j < arrayList.size(); j++)
                        {
                            String[] strings = arrayList.get(j);
                            // XFLog.info("第 " + CurrentPianoInformation.currentSongProgress + " 帧:");
                            StartSplitCommandAndArgsAndPlaySong.split(strings);
                            if (CurrentPianoInformation.isEnableNoteFallEffectBlock)
                                StartSplitCommandAndArgsAndPlaySong.split2(strings);
                        }
                        new Thread(() -> MainContainerPage_1.getSongProgressSlider().setValue(CurrentPianoInformation.currentSongProgress)).start();
                        try
                        {
                            if (time > 0)
                            {
                                getTimeOut(time, (list.size() - CurrentPianoInformation.currentSongProgress));
                                Thread.sleep(time);
                            }
                            else throw new RuntimeException("睡觉的时间必须要 >= 0");
                        }
                        catch (InterruptedException e)
                        {
                            XFLog.err("", e);
                        }
                    }
                    currentP = -1;
                    Sleep.sleep(new Random().nextInt(1000, 1234));
                    reopenMidiDevice2();
                }
                while (StaticValue.isLoopPlay);
                StopAllMidiDeviceSound.stopAll();
                Sleep.sleep(new Random().nextInt(1000, 1234));
                CurrentPianoInformation.currentSongProgress = 0;
                currentP = -1;
                stopPlaySong = false;
                CurrentPianoInformation.isPlay = false;
                unInitInterface();
                MainContainerPage_1.getShowMidiPlaySourceFile().setText("当前没有可播放的文件");
            }
        };
        runnable.start();
    }

    public static long getTime()
    {
        return time;
    }

    public static void setTime(long time1)
    {
        time = time1;
    }

    public static long getJmciTickRateBackup()
    {
        return jmciTickRateBackup;
    }

    public static double getJmciBPM()
    {
        return jmciBPM;
    }

    public static double getJmciTickRate()
    {
        return jmciTickRate;
    }
}
