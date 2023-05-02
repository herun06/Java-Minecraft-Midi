/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class PlaySound
{
    private URL filename;
    private SourceDataLine auline;

    public PlaySound(URL wavfile)
    {
        filename = wavfile;
    }

    public PlaySound(File wavfile)
    {
        try
        {
            filename = wavfile.toURL();
        }
        catch (MalformedURLException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void play()
    {
        new Thread(() -> run()).start();
    }

    public void stop()
    {
        if (auline != null) auline.stop();
    }

    public void run()
    {
        AudioInputStream audioInputStream = null;
        try
        {
            audioInputStream = AudioSystem.getAudioInputStream(filename);
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
            return;
        }
        AudioFormat format = audioInputStream.getFormat();
        auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
        try
        {
            auline = (SourceDataLine) AudioSystem.getLine(info);
            if (auline != null) auline.open(format);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return;
        }
        if (auline != null) auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[512];
        try
        {
            while (nBytesRead != -1)
            {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    if (auline != null) auline.write(abData, 0, nBytesRead);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        finally
        {
            if (auline != null) auline.drain();
            if (auline != null) auline.close();
        }
    }
}

