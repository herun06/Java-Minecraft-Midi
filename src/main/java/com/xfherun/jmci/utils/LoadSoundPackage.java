/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.system_static_value.StaticValue;

import java.io.File;
import java.util.Arrays;
import java.util.Map;

public class LoadSoundPackage
{
    private LoadSoundPackage()
    {
    }

    public static void releasedMemory()
    {
        XFLog.info("释放内存");
        Arrays.fill(CurrentPianoInformation.GLOBAL_SOUND_LIB_ARRAY, null);
    }

    public static void reload()
    {
        XFLog.info("加载声音包");
        LoadSounds.load();
        load();
    }

    public static void load()
    {
        StaticValue.soundPackageArrayList.clear();
        StaticValue.tempLoadSoundPackageArrayList.clear();
        File[] files = new File("assets/package").listFiles();
        int index = 0;
        for (File file : files)
        {
            if (file.isDirectory())
            {
                Map<String, String> read = ReadAndWriteXFHerunConfig.read(new File(file + "/package.xf"));
                String pack = read.get("pack");
                String pack_format = read.get("pack_format");
                if (pack.equalsIgnoreCase(file.getName()))
                {
                    if (pack_format.equalsIgnoreCase("sound"))
                    {
                        /*if (StaticValue.backupSoundPackageArrayList.size() == 0 && StaticValue.soundPackageArrayList.size() == 0)
                        {
                            StaticValue.backupSoundPackageArrayList.add(file);
                            StaticValue.soundPackageArrayList.add(file);
                        }
                        else
                        {
                            int size = StaticValue.backupSoundPackageArrayList.size();
                            int size2 = StaticValue.soundPackageArrayList.size();
                            if (size2 == size)
                            {
                                for (int i = 0; i < size; i++)
                                {
                                    String file1 = StaticValue.backupSoundPackageArrayList.get(i).getAbsolutePath();
                                    String file2 = StaticValue.soundPackageArrayList.get(i).getAbsolutePath();
                                    if (file2.equalsIgnoreCase(file1))
                                    {
                                        if (!file.getAbsolutePath().equalsIgnoreCase(file1))
                                        {
                                            StaticValue.backupSoundPackageArrayList.add(file);
                                            StaticValue.soundPackageArrayList.add(file);
                                        }
                                    }
                                    else
                                    {
                                        StaticValue.backupSoundPackageArrayList.set(index, file);
                                        StaticValue.soundPackageArrayList.set(index, file);
                                    }
                                }
                            }
                        }*/
                        StaticValue.soundPackageArrayList.add(file);
                        XFLog.info("扫描的声音包: " + file);
                    }
                }
                XFLog.info("文件: " + file);
            }
            index++;
        }
        StaticValue.tempLoadSoundPackageArrayList.addAll(StaticValue.loadSoundPackageArrayList);
    }
}
