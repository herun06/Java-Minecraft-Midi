package main.java.com.xfherun.jmci.init;

import com.xfherun.midiout.MidiOut;
import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

public class InitMidiDevice
{
    private InitMidiDevice()
    {
    }

    public static void init()
    {
        XFLog.info("打开默认的midi设备");
        MidiOut.openDevice(CurrentPianoInformation.currentMidiDevice);
    }
}
