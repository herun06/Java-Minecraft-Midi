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
import java.net.URL;

import javax.sound.sampled.*;

public class AudioFilePlayer
{
    private File filepath_FILE;
    private URL filepath_URL;
    private String filepath_STRING;
    private int index = 0;
    // private SourceDataLine line;

    public AudioFilePlayer()
    {
    }

    public AudioFilePlayer(File file)
    {
        filepath_FILE = file;
        index = 0;
    }

    public AudioFilePlayer(URL file)
    {
        filepath_URL = file;
        index = 1;
    }

    public AudioFilePlayer(String file)
    {
        filepath_STRING = file;
        index = 2;
    }

    public void setWave(File file)
    {
        filepath_FILE = file;
    }

    public void setWave(URL file)
    {
        filepath_URL = file;
    }

    public void setWave(String file)
    {
        filepath_STRING = file;
    }

    public String getPath()
    {
        return filepath_FILE + " :: " + filepath_URL;
    }

    public void play()
    {
        if (index == 0) play(filepath_FILE);
        else if (index == 1) play(filepath_URL);
        else if (index == 2) play(filepath_STRING);
    }

    public void play(File path)
    {
        new Thread(new Thread(() ->
        {
            try
            {
                AudioInputStream in = AudioSystem.getAudioInputStream(path);
                AudioFormat outFormat = getOutFormat(in.getFormat());
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                if (line != null)
                {
                    line.open(outFormat);
                    line.start();
                    stream(AudioSystem.getAudioInputStream(outFormat, in), line);
                    line.drain();
                    line.stop();
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
            // Thread.currentThread().stop();
        })).start();
    }

    public void play(URL path)
    {
        new Thread(new Thread(() ->
        {
            try
            {
                AudioInputStream in = AudioSystem.getAudioInputStream(path);
                AudioFormat outFormat = getOutFormat(in.getFormat());
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                if (line != null)
                {
                    line.open(outFormat);
                    line.start();
                    stream(AudioSystem.getAudioInputStream(outFormat, in), line);
                    line.drain();
                    line.stop();
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
            // Thread.currentThread().stop();
        })).start();
    }

    public void play(String path)
    {
        new Thread(new Thread(() ->
        {
            try
            {
                AudioInputStream in = AudioSystem.getAudioInputStream(new File(path));
                AudioFormat outFormat = getOutFormat(in.getFormat());
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);
                SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
                if (line != null)
                {
                    line.open(outFormat);
                    line.start();
                    stream(AudioSystem.getAudioInputStream(outFormat, in), line);
                    line.drain();
                    line.stop();
                }
            }
            catch (Exception e)
            {
                throw new RuntimeException(e);
            }
            // Thread.currentThread().stop();
        })).start();
    }

    private AudioFormat getOutFormat(AudioFormat inFormat)
    {
        int ch = inFormat.getChannels();
        float rate = inFormat.getSampleRate();
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }

    private void stream(AudioInputStream in, SourceDataLine line)
            throws IOException
    {
        byte[] buffer = new byte[65536];
        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length))
        {
            line.write(buffer, 0, n);
        }
    }
}
