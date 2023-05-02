package main.java.com.xfherun.jmci.user_interface.section.page_1.sounds;

import com.xfherun.midiout.MidiOut;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.user_interface.section.page_1.WhitePianoKeysAndBlackPianoKeysObject;

import java.awt.event.MouseEvent;
import java.util.Random;

public class PlaySound
{
    private PlaySound()
    {
    }

    public static void playSound(MouseEvent event)
    {
        if (CurrentPianoInformation.isMidiOpen)
        {
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 0, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 1, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 2, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 3, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 4, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 5, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 6, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 7, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 8, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 9, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 10, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 11, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 12, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 13, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 14, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 15, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 16, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 17, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 18, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 19, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 20, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 21, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 22, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 23, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 24, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 25, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 26, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 27, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 28, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 29, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 30, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 31, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 32, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 33, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 34, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 35, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 36, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 37, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 38, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 39, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 40, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 41, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 42, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 43, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 44, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 45, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 46, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 47, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 48, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 49, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 50, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 51, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 52, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 53, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 54, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 55, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 56, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 57, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 58, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 59, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 60, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 61, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 62, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 63, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 64, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 65, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 66, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 67, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 68, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 69, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 70, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 71, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 72, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 73, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 74, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 75, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 76, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 77, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 78, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 79, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 80, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 81, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 82, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 83, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 84, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 85, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 86, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 87, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 88, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 89, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 90, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 91, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 92, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 93, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 94, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 95, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 96, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 97, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 98, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 99, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 100, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 101, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 102, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 103, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 104, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 105, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 106, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 107, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 108, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 109, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 110, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 111, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 112, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 113, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 114, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 115, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 116, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 117, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 118, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 119, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 120, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 121, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 122, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 123, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 124, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 125, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 126, new Random().nextInt(80, 127));
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74)
                MidiOut.noteOpen(CurrentPianoInformation.currentMidiChannel, 127, new Random().nextInt(80, 127));
        }
    }
}
