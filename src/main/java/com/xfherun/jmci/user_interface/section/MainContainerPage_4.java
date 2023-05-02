package main.java.com.xfherun.jmci.user_interface.section;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.soundfont.sf2.SoundFont;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.ConnectPianoAllKeys;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.PianoNoteBlockForFallingBlock;
import main.java.com.xfherun.jmci.utils.FileUtil;
import main.java.com.xfherun.jmci.utils.LoadSoundPackage;
import main.java.com.xfherun.minecraft_redstone_music_generator.utls.JMCIFileToMinecraftFunctionFile;

import javax.sound.midi.MidiDevice;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainContainerPage_4
{
    private static JPanel mainContainerPanel;
    private static XFButton backButton;
    private static XFButton selectMidiDeviceButton;
    private static XFButton selectMidiNoteBlockEffectButton;
    private static XFButton playSoundTypeButton;
    private static XFButton aboutButton;
    private static int currentIndexBlock = 0;

    private MainContainerPage_4()
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
                MainContainerPageHome.setPageToCurrent(0);
            }
        });
        backButton.addWindow(mainContainerPanel);

        selectMidiDeviceButton = new XFButton("选择midi设备");
        selectMidiDeviceButton.setBounds(10, 10 + 35 + 5, 200, 35);
        selectMidiDeviceButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                XFMenuList xfMenuList = new XFMenuList(
                        false, true, null, false, false, true, 400
                );
                xfMenuList.setBounds(new int[]{
                        XFMenuList.getButtonPoint(MainWindow.getMainWindow(), selectMidiDeviceButton)[0],
                        XFMenuList.getButtonPoint(MainWindow.getMainWindow(), selectMidiDeviceButton)[1],
                        35,
                        400
                });
                MidiDevice.Info[] midiDevicesInfo = MidiOut.getMidiDevicesInfo();
                for (int i = 1; i < midiDevicesInfo.length; i++)
                {
                    MidiDevice.Info info = midiDevicesInfo[i];
                    XFLog.info("系统Midi设备: " + info);
                    xfMenuList.add(info.toString());
                }
                xfMenuList.setCurrentSelectIndex(CurrentPianoInformation.currentMidiDevice);
                xfMenuList.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void mouseDouble(MouseEvent event)
                    {
                        CurrentPianoInformation.currentMidiDevice = xfMenuList.getCurrentSelectIndex();
                        MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
                        xfMenuList.close();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "成功更换midi设备: " + xfMenuList.getCurrentSelectText(),
                                "提示", 1);
                    }

                    @Override
                    public void mouseRightClicked(MouseEvent event)
                    {
                        XFMenuList xfMenuList1 = new XFMenuList(
                                false, true, null, true, true, false, 0
                        );
                        xfMenuList1.setBounds(new int[]{0, 0, 200, 35});
                        xfMenuList1.add("选择此midi设备");
                        xfMenuList1.addButtonClicked(new ButtonClick()
                        {
                            @Override
                            public void clicked(MouseEvent event)
                            {
                                CurrentPianoInformation.currentMidiDevice = xfMenuList.getCurrentSelectIndex();
                                MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                        "成功更换midi设备: " + xfMenuList.getCurrentSelectText(),
                                        "提示", 1);
                            }
                        });
                        xfMenuList1.show();
                    }
                });
                xfMenuList.show();
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                XFMenuList xfMenuList1 = new XFMenuList(
                        false, true, null, true, true, false, 0
                );
                xfMenuList1.setBounds(new int[]{0, 0, 200, 35});
                xfMenuList1.add("选择默认midi设备");
                xfMenuList1.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        CurrentPianoInformation.currentMidiDevice = 0;
                        MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "成功更换midi设备: " + MidiOut.getMidiDevicesInfo()[1],
                                "提示", 1);
                    }
                });
                xfMenuList1.show();
            }
        });
        selectMidiDeviceButton.addWindow(mainContainerPanel);

        selectMidiNoteBlockEffectButton = new XFButton("选择音符上滑方式");
        selectMidiNoteBlockEffectButton.setBounds(10, 10 + ((35 + 5) * 2), 200, 35);
        selectMidiNoteBlockEffectButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                XFMenuList xfMenuList = new XFMenuList(
                        false, true, null, false, true, true, selectMidiNoteBlockEffectButton.getWidth()
                );
                xfMenuList.setBounds(new int[]{
                        XFMenuList.getButtonPoint(MainWindow.getMainWindow(), selectMidiNoteBlockEffectButton)[0],
                        XFMenuList.getButtonPoint(MainWindow.getMainWindow(), selectMidiNoteBlockEffectButton)[1],
                        selectMidiNoteBlockEffectButton.getWidth(),
                        200
                });
                xfMenuList.add("启用上滑音符::方块流");
                xfMenuList.add("启用上滑音符::瀑布流");
                xfMenuList.add("关闭上滑音符::方块流");
                xfMenuList.add("关闭上滑音符::瀑布流");
                xfMenuList.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        int currentSelectIndex = xfMenuList.getCurrentSelectIndex();
                        String currentSelectText = xfMenuList.getCurrentSelectText();
                        if (currentSelectIndex == 0)
                        {
                            CurrentPianoInformation.isEnableNoteFallEffectBlock = true;
                            CurrentPianoInformation.isEnableNoteFallEffect = true;
                            currentIndexBlock = 0;
                        }
                        if (currentSelectIndex == 1)
                        {
                            CurrentPianoInformation.isEnableNoteFallEffectBlock = false;
                            CurrentPianoInformation.isEnableNoteFallEffect = true;
                            currentIndexBlock = 1;
                        }
                        if (currentSelectIndex == 2)
                        {
                            CurrentPianoInformation.isEnableNoteFallEffectBlock = true;
                            CurrentPianoInformation.isEnableNoteFallEffect = false;
                            currentIndexBlock = 2;
                        }
                        if (currentSelectIndex == 3)
                        {
                            CurrentPianoInformation.isEnableNoteFallEffectBlock = false;
                            CurrentPianoInformation.isEnableNoteFallEffect = false;
                            currentIndexBlock = 3;
                        }
                        StartReadJMCIFileContentData.pausePlay();
                        StartReadJMCIFileContentData.startPlay();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "成功选择音符上滑方式: " + currentSelectText,
                                "提示", 1);
                    }
                });
                xfMenuList.setCurrentSelectIndex(currentIndexBlock);

                xfMenuList.show();
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                XFMenuList xfMenuList1 = new XFMenuList(
                        false, true, null, true, true, false, 0
                );
                xfMenuList1.setBounds(new int[]{0, 0, 200, 35});
                xfMenuList1.add("默认音符上滑方式");
                xfMenuList1.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        CurrentPianoInformation.isEnableNoteFallEffectBlock = true;
                        currentIndexBlock = 0;
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "成功默认音符上滑方式: 方块流",
                                "提示", 1);
                    }
                });
                xfMenuList1.show();
            }
        });
        selectMidiNoteBlockEffectButton.addWindow(mainContainerPanel);

        playSoundTypeButton = new XFButton("选择声音播放方式");
        playSoundTypeButton.setBounds(10, 10 + ((35 + 5) * 3), 200, 35);
        playSoundTypeButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                XFMenuList xfMenuList = new XFMenuList(
                        false, true, null, false, false, true, 200
                );
                xfMenuList.setBounds(new int[]{
                        XFMenuList.getButtonPoint(MainWindow.getMainWindow(), playSoundTypeButton)[0],
                        XFMenuList.getButtonPoint(MainWindow.getMainWindow(), playSoundTypeButton)[1],
                        200, 200
                });
                xfMenuList.add("使用系统midi设备播放");
                xfMenuList.add("使用声音包进行播放");
                xfMenuList.add("获取声音包的样本模板");
                if (CurrentPianoInformation.useWavePlaySound) xfMenuList.setCurrentSelectIndex(1);
                else xfMenuList.setCurrentSelectIndex(0);
                xfMenuList.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        int currentSelectIndex = xfMenuList.getCurrentSelectIndex();
                        if (currentSelectIndex != 2)
                        {
                            if (currentSelectIndex == 0)
                            {
                                CurrentPianoInformation.useWavePlaySound = false;
                                LoadSoundPackage.releasedMemory();
                            }
                            if (currentSelectIndex == 1)
                            {
                                CurrentPianoInformation.useWavePlaySound = true;
                                LoadSoundPackage.reload();
                            }
                            xfMenuList.close();
                            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "成功选择播放声音方式: " + xfMenuList.getCurrentSelectText(),
                                    "提示", 1);
                        }
                        else
                        {
                            String absolutePath = new File("assets/package").getAbsolutePath();
                            XFLog.info("开始保存声音包的模板至: " + absolutePath);
                            try
                            {
                                FileUtil.loadRecourseFromJar("/main/resources/sound_package/SoundPackage样本.zip", new File("cache/cache").getAbsolutePath(), MainContainerPage_4.class);
                            }
                            catch (Exception e)
                            {
                                String str = "保存声音包模板失败！" + "\n" + e;
                                XFLog.warn(str, e);
                                XFLog.info("清除缓存");
                                JMCIFileToMinecraftFunctionFile.deleteDir(new File("cache/cache/main/resources/sound_package").getAbsolutePath());
                                XFLog.info("缓存清除完毕");
                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                        str,
                                        "警告", 2);
                                return;
                            }
                            try
                            {
                                Files.copy(Path.of(new File("cache/cache/main/resources/sound_package/SoundPackage样本.zip").getAbsolutePath()), Path.of(absolutePath + "/SoundPackage样本.zip"));
                            }
                            catch (Exception e)
                            {
                                String str = "保存声音包模板失败！" + "\n" + e;
                                XFLog.warn(str, e);
                                XFLog.info("清除缓存");
                                JMCIFileToMinecraftFunctionFile.deleteDir(new File("cache/cache/main/resources/sound_package").getAbsolutePath());
                                XFLog.info("缓存清除完毕");
                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                        str,
                                        "警告", 2);
                                return;
                            }
                            XFLog.info("清除缓存");
                            JMCIFileToMinecraftFunctionFile.deleteDir(new File("cache/cache/main/resources/sound_package").getAbsolutePath());
                            XFLog.info("缓存清除完毕");
                            String str = "声音模板保存成功: " + absolutePath + "/[SoundPackage] 样本.zip";
                            XFLog.info(str);
                            JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    str,
                                    "提示", 1);
                        }
                    }

                    @Override
                    public void mouseRightClicked(MouseEvent event)
                    {
                        if (xfMenuList.getCurrentSelectIndex() == 0)
                        {
                            if (!CurrentPianoInformation.useWavePlaySound)
                            {
                                XFLog.info("设置播放SoundFont");
                                XFMenuList xfml = new XFMenuList(
                                        false, true, null, true, false, false, 119
                                );
                                xfml.setBounds(new int[]{0, 0, 119, 35});
                                xfml.add("播放SoundFont::启用");
                                xfml.add("播放SoundFont::关闭");
                                if (CurrentPianoInformation.isEnableSoundFontPlay) xfml.setCurrentSelectIndex(0);
                                else xfml.setCurrentSelectIndex(1);
                                xfml.addButtonClicked(new ButtonClick()
                                {
                                    @Override
                                    public void clicked(MouseEvent event)
                                    {
                                        if (event.getButton() == 1 && event.getClickCount() == 2)
                                        {
                                            int currentSelectIndex = xfml.getCurrentSelectIndex();
                                            String currentSelectText = xfml.getCurrentSelectText();
                                            if (currentSelectIndex == 0)
                                                CurrentPianoInformation.isEnableSoundFontPlay = true;
                                            else if (currentSelectIndex == 1)
                                                CurrentPianoInformation.isEnableSoundFontPlay = false;
                                            else CurrentPianoInformation.isEnableSoundFontPlay = false;
                                            xfml.close();
                                            if (CurrentPianoInformation.currentSoundFontFile != null)
                                            {
                                                String sf2 = CurrentPianoInformation.currentSoundFontFile.getAbsolutePath();
                                                try
                                                {
                                                    XFLog.info("尝试加载SoundFont");
                                                    SoundFont.loadSoundFont(sf2);
                                                    XFLog.info("加载成功！");
                                                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                            "成功选择播放声音方式: " + xfMenuList.getCurrentSelectText() + " :: " + currentSelectText,
                                                            "提示", 1);
                                                }
                                                catch (Exception e)
                                                {
                                                    XFLog.warn("SoundFont加载失败！", e);
                                                    JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                            "SoundFont加载失败！:\n" + e,
                                                            "警告", 2);
                                                }
                                            }
                                            else
                                            {
                                                String str = "没有SoundFont文件加载, 请在: " + new File("soundfont").getAbsolutePath() + " 文件目录下放入*.sf2的音色库文件。";
                                                XFLog.warn(str);
                                                CurrentPianoInformation.isEnableSoundFontPlay = false;
                                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                                        str,
                                                        "警告", 2);
                                            }
                                        }
                                    }
                                });
                                xfml.show();
                            }
                            else
                            {
                                XFLog.warn("你必须启用midi设备播放后才能进行使用SoundFont播放");
                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                        "你必须启用midi设备播放后才能进行使用SoundFont播放",
                                        "警告", 2);
                            }
                        }
                    }
                });
                xfMenuList.show();
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                XFMenuList xfMenuList1 = new XFMenuList(
                        false, true, null, true, true, false, 0
                );
                xfMenuList1.setBounds(new int[]{0, 0, 200, 35});
                xfMenuList1.add("默认声音播放方式");
                xfMenuList1.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        CurrentPianoInformation.useWavePlaySound = true;
                        CurrentPianoInformation.isEnableSoundFontPlay = false;
                        LoadSoundPackage.reload();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "默认声音播放方式: 使用声音包进行播放",
                                "提示", 1);
                    }
                });
                xfMenuList1.show();
            }
        });
        playSoundTypeButton.addWindow(mainContainerPanel);

        aboutButton = new XFButton("关于软件");
        aboutButton.setBounds(mainContainerPanel.getWidth() - (200 + 10), mainContainerPanel.getHeight() - (35 + 10), 200, 35);
        aboutButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPage_5.setPageToCurrent(5);
            }
        });
        aboutButton.addWindow(mainContainerPanel);
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

    public static XFButton getSelectMidiDeviceButton()
    {
        return selectMidiDeviceButton;
    }

    public static XFButton getSelectMidiNoteBlockEffectButton()
    {
        return selectMidiNoteBlockEffectButton;
    }

    public static XFButton getAboutButton()
    {
        return aboutButton;
    }
}
