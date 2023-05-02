package main.java.com.xfherun.jmci.midi;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.API_INTERFACE.PianoDataStreamInputIO;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.SetAllPianoKeyBoardColor;
import main.java.com.xfherun.jmci.utils.PlayWaveSound;
import main.java.com.xfherun.jmci.utils.Sleep;

import java.util.ArrayList;

public class StartSplitCommandAndArgsAndPlaySong
{
    private StartSplitCommandAndArgsAndPlaySong()
    {
    }

    public static void split(String[] args)
    {
        if (args.length == 4 || args.length == 5)
        {
            if (args[0].equalsIgnoreCase("midiout"))
            {
                if (args[1].equalsIgnoreCase("noteopen"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int pitch = Integer.parseInt(args[3]);
                    if (CurrentPianoInformation.movePitch != 0)
                    {
                        if (channel != 9) pitch += CurrentPianoInformation.movePitch;
                        if (pitch < 0) pitch = 0;
                        else if (pitch > 127) pitch = 127;
                    }
                    int velocity = Integer.parseInt(args[4]);
                    if (!CurrentPianoInformation.useWavePlaySound) MidiOut.noteOpen(channel, pitch, velocity);
                    else if (channel != 9) PlayWaveSound.play(pitch);
                    if (!CurrentPianoInformation.isEnableNoteFallEffectBlock)
                        SetAllPianoKeyBoardColor.down(channel, pitch);
                    else
                    {
                        int[] finalPitch = {pitch};
                        new Thread()
                        {
                            @Override
                            public void run()
                            {
                                SetAllPianoKeyBoardColor.up(finalPitch[0]);
                                SetAllPianoKeyBoardColor.down(channel, finalPitch[0]);
                                Sleep.sleep(119);
                                SetAllPianoKeyBoardColor.up(finalPitch[0]);
                            }
                        }.start();
                    }
                    if (!CurrentPianoInformation.isEnableNoteFallEffectBlock)
                        PianoDataStreamInputIO.setPianoKey(channel, pitch, PianoDataStreamInputIO.PIANO_KEY_DOWN);
                    //XFLog.info("播放音符: " + channel + "::" + pitch + "::" + velocity);
                }
                else if (args[1].equalsIgnoreCase("noteclose"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int pitch = Integer.parseInt(args[3]);
                    if (CurrentPianoInformation.movePitch != 0)
                    {
                        if (channel != 9) pitch += CurrentPianoInformation.movePitch;
                        if (pitch < 0) pitch = 0;
                        else if (pitch > 127) pitch = 127;
                    }
                    if (!CurrentPianoInformation.useWavePlaySound) MidiOut.noteClose(channel, pitch, 0);
                    if (!CurrentPianoInformation.isEnableNoteFallEffectBlock) SetAllPianoKeyBoardColor.up(pitch);
                    if (!CurrentPianoInformation.isEnableNoteFallEffectBlock)
                    {
                        int[] finalPitch = {pitch};
                        new Thread()
                        {
                            @Override
                            public void run()
                            {
                                PianoDataStreamInputIO.setPianoKey(channel, finalPitch[0], PianoDataStreamInputIO.PIANO_KEY_UP);
                            }
                        }.start();
                    }
                    //XFLog.info("关闭音符: " + channel + "::" + pitch + "::" + "0");
                }
                else if (args[1].equalsIgnoreCase("pitchwheelrange"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int lsb = Integer.parseInt(args[3]);
                    int msb = Integer.parseInt(args[4]);
                    if (CurrentPianoInformation.movePitch != 0)
                    {
                        if (CurrentPianoInformation.movePitch > 0)
                        {
                            lsb += CurrentPianoInformation.movePitch;
                            msb += CurrentPianoInformation.movePitch;
                        }
                        else
                        {
                            lsb += CurrentPianoInformation.movePitch;
                            msb += CurrentPianoInformation.movePitch;
                        }
                    }
                    if (!CurrentPianoInformation.useWavePlaySound) MidiOut.pitchWheelRange(channel, lsb, msb);
                    //XFLog.info("设置弯音轮: " + channel + "::" + lsb + "::" + msb);
                }
                else if (args[1].equalsIgnoreCase("setprogram"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int program = Integer.parseInt(args[3]);
                    if (!CurrentPianoInformation.useWavePlaySound) MidiOut.setProgram(channel, program);
                    //XFLog.info("设置程序: " + channel + "::" + program);
                }
                else if (args[1].equalsIgnoreCase("setcontrol"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int control = Integer.parseInt(args[3]);
                    int value = Integer.parseInt(args[4]);
                    if (!CurrentPianoInformation.useWavePlaySound) MidiOut.setControl(channel, control, value);
                    //XFLog.info("设置控制: " + channel + "::" + channel + "::" + value);
                }
            }
        }
    }

    public static void splitTest(String[] args)
    {
        if (args.length == 4 || args.length == 5)
        {
            if (args[0].equalsIgnoreCase("midiout"))
            {
                if (args[1].equalsIgnoreCase("noteopen"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int pitch = Integer.parseInt(args[3]);
                    int velocity = Integer.parseInt(args[4]);
                    MidiOut.noteOpen(channel, pitch, velocity);
                    //XFLog.info("播放音符: " + channel + "::" + pitch + "::" + velocity);
                }
                else if (args[1].equalsIgnoreCase("noteclose"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int pitch = Integer.parseInt(args[3]);
                    MidiOut.noteClose(channel, pitch, 0);
                    //XFLog.info("播放音符: " + channel + "::" + pitch + "::" + "0");
                }
                else if (args[1].equalsIgnoreCase("pitchwheelrange"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int lsb = Integer.parseInt(args[3]);
                    int msb = Integer.parseInt(args[4]);
                    MidiOut.pitchWheelRange(channel, lsb, msb);
                    //XFLog.info("设置弯音轮: " + channel + "::" + lsb + "::" + msb);
                }
                else if (args[1].equalsIgnoreCase("setprogram"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int program = Integer.parseInt(args[3]);
                    MidiOut.setProgram(channel, program);
                    //XFLog.info("设置程序: " + channel + "::" + program);
                }
                else if (args[1].equalsIgnoreCase("setcontrol"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int control = Integer.parseInt(args[3]);
                    int value = Integer.parseInt(args[4]);
                    MidiOut.setControl(channel, control, value);
                    //XFLog.info("设置控制: " + channel + "::" + channel + "::" + value);
                }
            }
        }
    }

    public static void split2(String[] args)
    {
        if (args.length == 4 || args.length == 5)
        {
            if (args[0].equalsIgnoreCase("midiout"))
            {
                if (args[1].equalsIgnoreCase("noteopen"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int pitch = Integer.parseInt(args[3]);
                    if (CurrentPianoInformation.movePitch != 0)
                    {
                        if (channel != 9) pitch += CurrentPianoInformation.movePitch;
                        if (pitch < 0) pitch = 0;
                        else if (pitch > 127) pitch = 127;
                    }
                    int velocity = Integer.parseInt(args[4]);
                    int[] finalPitch = {pitch};
                    new Thread(() -> PianoDataStreamInputIO.setPianoKey(channel, finalPitch[0], PianoDataStreamInputIO.PIANO_KEY_DOWN)).start();
                }
                else if (args[1].equalsIgnoreCase("noteclose"))
                {
                    int channel = Integer.parseInt(args[2]);
                    int pitch = Integer.parseInt(args[3]);
                    if (CurrentPianoInformation.movePitch != 0)
                    {
                        if (channel != 9) pitch += CurrentPianoInformation.movePitch;
                        if (pitch < 0) pitch = 0;
                        else if (pitch > 127) pitch = 127;
                    }
                    int finalPitch[] = {pitch};
                    new Thread(() -> PianoDataStreamInputIO.setPianoKey(channel, finalPitch[0], PianoDataStreamInputIO.PIANO_KEY_UP)).start();
                }
            }
        }
    }
}
