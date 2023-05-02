package main.java.com.xfherun.jmci.piano_data.API_INTERFACE;

import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.piano_data.GetPianoKeyColor;
import main.java.com.xfherun.jmci.piano_data.PianoNoteBlockColor;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_1;
import main.java.com.xfherun.jmci.user_interface.section.page_1.SetWhitePianoKeysAndBlackPianoKeysStyle;
import main.java.com.xfherun.jmci.user_interface.section.page_1.WhitePianoKeysAndBlackPianoKeysObject;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.ConnectPianoAllKeys;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.SetAllPianoKeyBoardColor;

import javax.swing.*;

public class PianoDataStreamInputIO
{
    public static final int PIANO_KEY_DOWN = 0;
    public static final int PIANO_KEY_UP = 1;

    private PianoDataStreamInputIO()
    {
    }

    public static void setPianoKey(final int channel, final int pitch, final int status)
    {
        if (status != PIANO_KEY_DOWN && status != PIANO_KEY_UP)
            throw new IndexOutOfBoundsException("Index: " + status + " out of range 0 ~ 1");
        else if (pitch < 0 || pitch > 127)
            throw new IndexOutOfBoundsException("Piano key index: " + pitch + " out of range 0 ~ 127");
        else if (channel < 0 || channel > 15)
            throw new IndexOutOfBoundsException("Midi channel: " + channel + " out of range 0 ~ 15");
        else
        {
            if (status == PIANO_KEY_DOWN)
            {
                if (CurrentPianoInformation.isEnableNoteFallEffect)
                    ConnectPianoAllKeys.midiDeviceControlConnectToPianoKeys(channel, pitch);
            }
            else
            {
                if (CurrentPianoInformation.isEnableNoteFallEffect)
                    ConnectPianoAllKeys.midiDeviceControlDisconnectToPianoKeys(pitch);
            }
        }
    }
}
