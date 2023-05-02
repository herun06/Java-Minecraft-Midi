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
import java.util.ArrayList;
import java.util.Map;

public class UpdateSoundPackage
{
    private UpdateSoundPackage()
    {
    }

    public static void update(ArrayList<File> fileArrayList)
    {
        XFLog.info("开始更新声音包");
        LoadSounds.load();
        for (int xfy = fileArrayList.size() - 1; xfy >= 0; xfy--)
        {
            File file = fileArrayList.get(xfy);
            if (file.isDirectory())
            {
                XFLog.info("扫描到的文件目录: " + file);
                Map<String, String> read = ReadAndWriteXFHerunConfig.read(new File(file + "/package.xf"));
                String pack = read.get("pack");
                String pack_format = read.get("pack_format");
                if (pack.equalsIgnoreCase(file.getName()))
                {
                    if (pack_format.equalsIgnoreCase("sound"))
                    {
                        Map<String, String> sounds = ReadAndWriteXFHerunConfig.read(new File(file + "/assets/sounds.sd"));
                        for (int i = 0; i < 128; i++)
                        {
                            String filePath = sounds.get("PROGRAM" + 0 + "_PITCH" + i);
                            File waveFile = new File(file + "/assets/" + filePath).getAbsoluteFile();
                            if (waveFile.exists())
                                CurrentPianoInformation.GLOBAL_SOUND_LIB_ARRAY[i] = new AudioFilePlayer(waveFile);
                        }
                        XFLog.info("扫描的声音包: " + file);
                    }
                }
            }
        }
    }
}
