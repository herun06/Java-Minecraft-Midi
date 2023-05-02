/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.soundfont.sf2;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundFont
{
    private SoundFont()
    {
    }

    public static void loadSoundFont(URL url) throws Exception
    {
        loadSoundFont(url, 119);
    }

    public static void loadSoundFont(String file) throws Exception
    {
        loadSoundFont(new File(file).toURL(), 119);
    }

    private static void loadSoundFont(URL urlName, int id) throws Exception
    {
        XFLog.info("开始加载SoundFont: " + urlName);
        Soundbank soundbank = MidiSystem.getSoundbank(urlName);
        MidiDevice device = MidiOut.getDevice();
        if (device == null) MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
        Synthesizer midis = (Synthesizer) device;
        assert midis != null;
        midis.loadAllInstruments(soundbank);
        Receiver receiver = device.getReceiver();
        MidiOut.setReceiver(receiver);
        XFLog.info("SoundFont加载完毕！");
    }
}
