package main.java.com.xfherun.jmci.user_interface.events;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.swing_util.list.normal.XFList;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.loadsoundpackage.LoadSoundPackage;
import main.java.com.xfherun.jmci.user_interface.loadsoundpackage.UpdateThisWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPageHome;
import main.java.com.xfherun.jmci.user_interface.section.*;
import main.java.com.xfherun.jmci.utils.AudioFilePlayer;
import main.java.com.xfherun.jmci.utils.Exit;
import main.java.com.xfherun.jmci.utils.ReadAndWriteXFHerunConfig;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ChangePage
{
    public static boolean isOpen = true;

    private ChangePage()
    {
    }

    public static void change()
    {
        MainContainerPageHome.getPlaySongPianoKeyButton().addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPage_1.setPageToCurrent(1);
            }
        });
        MainContainerPageHome.getEditJavaMinecraftMidiButton().addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPage_2.setPageToCurrent(2);
            }
        });
        MainContainerPageHome.getMinecraftRedStoneMusicButton().addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                // MainContainerPage_3.setPageToCurrent(3);
                if (isOpen)
                {
                    main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow.setupUi();
                    isOpen = false;
                }
            }
        });
        MainContainerPageHome.getSystemSettingsButton().addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                MainContainerPage_4.setPageToCurrent(4);
            }

            @Override
            public void mouseRightClicked(MouseEvent event)
            {
                XFMenuList xfMenuList = new XFMenuList(
                        false, true, null, true, true, false, 400
                );
                xfMenuList.setBounds(new int[]{0, 0, 400, 400});
                xfMenuList.add("查看已加载的声音包");
                xfMenuList.add("加载声音包");
                xfMenuList.add("打开声音包所在的文件夹");
                xfMenuList.addButtonClicked(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        int currentSelectIndex = xfMenuList.getCurrentSelectIndex();
                        if (currentSelectIndex == 0)
                        {
                            XFMenuList xfMenuList1 = new XFMenuList(
                                    true, true, null, false, false, true, 400, true
                            );
                            xfMenuList1.setBounds(new int[]{0, 0, 400, 400});
                            for (File file : StaticValue.loadSoundPackageArrayList)
                            {
                                file = file.getAbsoluteFile();
                                if (file.isDirectory())
                                {
                                    Map<String, String> read = ReadAndWriteXFHerunConfig.read(new File(file + "/package.xf"));
                                    String pack = read.get("pack");
                                    String pack_format = read.get("pack_format");
                                    String pack_description = read.get("pack_description");
                                    if (pack.equalsIgnoreCase(file.getName()) && pack_format.equalsIgnoreCase("sound"))
                                    {
                                        xfMenuList1.add("SP: " + pack + " -> " + pack_description);
                                        XFLog.info("声音包: " + file);
                                    }
                                }
                                XFLog.info("扫描到的文件: " + file);
                            }
                            xfMenuList1.show("已加载的声音包", MainWindow.getMainWindow());
                        }
                        if (currentSelectIndex == 1)
                        {
                            XFLog.info("开始加载界面...");
                            new Thread(LoadSoundPackage::loadInterface).start();
                            new Thread(() ->
                            {
                                while (true)
                                    if (LoadSoundPackage.getMainWindow() != null && LoadSoundPackage.getMainWindow().isVisible())
                                    {
                                        new UpdateThisWindow().start();
                                        break;
                                    }
                            }).start();
                            XFLog.info("加载成功...");
                        }
                        if (currentSelectIndex == 2)
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
                xfMenuList.show();
            }
        });
        MainContainerPageHome.getExitApplicationButton().addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                Exit.exit();
            }
        });
    }
}
