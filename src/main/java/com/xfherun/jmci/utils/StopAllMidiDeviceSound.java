package main.java.com.xfherun.jmci.utils;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;

import java.util.Random;

public class StopAllMidiDeviceSound
{
    private StopAllMidiDeviceSound()
    {
    }

    public static void stopAll()
    {
        XFLog.info("开始停止所有声音");
        new Thread(StopAllMidiDeviceSound::stop).start();
    }

    private static void stop()
    {
        int time = new Random().nextInt(1000, 1119 + 1);
        XFLog.info("先等待" + time + "毫秒再停止, 因为怕声音没有播放完后就那个了！！！！！");
        Sleep.sleep(time);
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 128; j++)
            {
                try
                {
                    MidiOut.noteClose(i, j, 0);
                }
                catch (Exception e)
                {
                    XFLog.warn("'这个异常可以忽略'", e);
                }
            }
        }
        XFLog.info("声音停止完毕！");
    }

    public static void stopAll2()
    {
        XFLog.info("开始停止所有声音");
        new Thread(StopAllMidiDeviceSound::stop2).start();
    }

    private static void stop2()
    {
        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 128; j++)
            {
                try
                {
                    MidiOut.noteClose(i, j, 0);
                }
                catch (Exception e)
                {
                    XFLog.warn("'这个异常可以忽略'", e);
                }
            }
        }
        XFLog.info("声音停止完毕！");
    }
}
