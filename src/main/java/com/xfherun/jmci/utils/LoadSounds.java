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

import java.net.URL;

public class LoadSounds
{
    private LoadSounds()
    {
    }

    public static void load()
    {
        for (int i = 0; i < CurrentPianoInformation.GLOBAL_SOUND_LIB_ARRAY.length; i++)
        {
            AudioFilePlayer musicPlayer = new AudioFilePlayer(LoadSounds.class.getClassLoader().getResource("main/resources/sounds/program0_pitch" + i + ".wav"));
            // AudioFilePlayer audioFilePlayer = new AudioFilePlayer("assets/sounds/program0_pitch" + i + ".ogg");
            CurrentPianoInformation.GLOBAL_SOUND_LIB_ARRAY[i] = musicPlayer;
            XFLog.info("成功加载声音: " + musicPlayer.getPath());
        }
    }
}
