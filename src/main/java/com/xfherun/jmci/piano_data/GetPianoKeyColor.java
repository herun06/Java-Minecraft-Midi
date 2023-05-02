package main.java.com.xfherun.jmci.piano_data;

import java.awt.*;

public class GetPianoKeyColor
{
    private GetPianoKeyColor()
    {
    }

    public static Color getPianoKeyColor(int channel)
    {
        if (channel == 0) return PianoNoteBlockColor.MIDI_CHANNEL_0;
        else if (channel == 1) return PianoNoteBlockColor.MIDI_CHANNEL_1;
        else if (channel == 2) return PianoNoteBlockColor.MIDI_CHANNEL_2;
        else if (channel == 3) return PianoNoteBlockColor.MIDI_CHANNEL_3;
        else if (channel == 4) return PianoNoteBlockColor.MIDI_CHANNEL_4;
        else if (channel == 5) return PianoNoteBlockColor.MIDI_CHANNEL_5;
        else if (channel == 6) return PianoNoteBlockColor.MIDI_CHANNEL_6;
        else if (channel == 7) return PianoNoteBlockColor.MIDI_CHANNEL_7;
        else if (channel == 8) return PianoNoteBlockColor.MIDI_CHANNEL_8;
        else if (channel == 9) return PianoNoteBlockColor.MIDI_CHANNEL_9;
        else if (channel == 10) return PianoNoteBlockColor.MIDI_CHANNEL_10;
        else if (channel == 11) return PianoNoteBlockColor.MIDI_CHANNEL_11;
        else if (channel == 12) return PianoNoteBlockColor.MIDI_CHANNEL_12;
        else if (channel == 13) return PianoNoteBlockColor.MIDI_CHANNEL_13;
        else if (channel == 14) return PianoNoteBlockColor.MIDI_CHANNEL_14;
        else if (channel == 15) return PianoNoteBlockColor.MIDI_CHANNEL_15;
        else throw new IndexOutOfBoundsException("Index: " + channel + " out of range 0 ~ 15");
    }
}
