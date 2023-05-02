package main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block;

import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_1;
import main.java.com.xfherun.jmci.user_interface.section.page_1.WhitePianoKeysAndBlackPianoKeysObject;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ConnectPianoAllKeys
{
    private static ArrayList<Object[]> pianoNoteBlockTempArrayList = new ArrayList<>();

    private ConnectPianoAllKeys()
    {
    }

    public static void addWhiteToArrayList(int channel, int x, int y, int width, int start, int end, String pitch)
    {
        Object[] objArr = new Object[2];
        objArr[0] = pitch;
        objArr[1] = new PianoNoteBlockForFallingBlock(
                MainContainerPage_1.getMainContainerPanel(),
                width,
                start, end, x, y, channel, pitch);
        pianoNoteBlockTempArrayList.add(objArr);
        PianoNoteBlockForFallingBlock o = (PianoNoteBlockForFallingBlock) objArr[1];
        o.start();
    }

    public static void removeWhiteToArrayList(String pitch)
    {
        if (!CurrentPianoInformation.isEnableNoteFallEffectBlock)
            for (int index = 0; index < pianoNoteBlockTempArrayList.size(); index++)
            {
                String s = (String) pianoNoteBlockTempArrayList.get(index)[0];
                if (s.equals(pitch))
                {
                    PianoNoteBlockForFallingBlock pianoNoteBlockForFallingBlock = (PianoNoteBlockForFallingBlock)
                            pianoNoteBlockTempArrayList.get(index)[1];
                    pianoNoteBlockForFallingBlock.stop();
                    pianoNoteBlockTempArrayList.remove(index);
                    break;
                }
            }
    }

    public static void white(MouseEvent event)
    {
        if (CurrentPianoInformation.isEnableNoteFallEffect)
        {
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_0");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_1");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_2");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_3");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_4");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_5");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_6");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_7");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_8");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_9");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_10");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_11");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_12");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_13");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_14");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_15");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_16");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_17");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_18");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_19");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_20");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_21");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_22");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_23");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_24");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_25");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_26");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_27");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_28");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_29");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_30");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_31");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_32");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_33");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_34");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_35");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_36");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_37");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_38");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_39");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_40");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_41");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_42");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_43");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_44");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_45");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_46");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_47");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_48");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_49");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_50");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_51");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_52");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_53");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_54");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_55");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_56");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_57");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_58");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_59");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_60");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_61");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_62");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_63");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_64");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_65");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_66");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_67");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_68");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_69");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_70");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_71");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_72");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_73");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_74");
            }
        }
    }

    public static void black(MouseEvent event)
    {
        if (CurrentPianoInformation.isEnableNoteFallEffect)
        {
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_0");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_1");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_2");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_3");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_4");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_5");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_6");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_7");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_8");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_9");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_10");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_11");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_12");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_13");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_14");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_15");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_16");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_17");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_18");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_19");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_20");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_21");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_22");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_23");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_24");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_25");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_26");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_27");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_28");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_29");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_30");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_31");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_32");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_33");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_34");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_35");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_36");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_37");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_38");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_39");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_40");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_41");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_42");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_43");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_44");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_45");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_46");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_47");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_48");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_49");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_50");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_51");
            }
            if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52)
            {
                addWhiteToArrayList(
                        CurrentPianoInformation.currentMidiChannel,
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.getX(),
                        MainContainerPage_1.getPianoKeyBox().getY(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.getWidth(),
                        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.getY(),
                        MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_52");
            }
        }
    }

    public static void whiteDefault(MouseEvent event)
    {
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0)
        {
            removeWhiteToArrayList("white_piano_key_item_index_0");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1)
        {
            removeWhiteToArrayList("white_piano_key_item_index_1");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2)
        {
            removeWhiteToArrayList("white_piano_key_item_index_2");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3)
        {
            removeWhiteToArrayList("white_piano_key_item_index_3");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4)
        {
            removeWhiteToArrayList("white_piano_key_item_index_4");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5)
        {
            removeWhiteToArrayList("white_piano_key_item_index_5");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6)
        {
            removeWhiteToArrayList("white_piano_key_item_index_6");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7)
        {
            removeWhiteToArrayList("white_piano_key_item_index_7");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8)
        {
            removeWhiteToArrayList("white_piano_key_item_index_8");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9)
        {
            removeWhiteToArrayList("white_piano_key_item_index_9");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10)
        {
            removeWhiteToArrayList("white_piano_key_item_index_10");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11)
        {
            removeWhiteToArrayList("white_piano_key_item_index_11");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12)
        {
            removeWhiteToArrayList("white_piano_key_item_index_12");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13)
        {
            removeWhiteToArrayList("white_piano_key_item_index_13");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14)
        {
            removeWhiteToArrayList("white_piano_key_item_index_14");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15)
        {
            removeWhiteToArrayList("white_piano_key_item_index_15");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16)
        {
            removeWhiteToArrayList("white_piano_key_item_index_16");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17)
        {
            removeWhiteToArrayList("white_piano_key_item_index_17");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18)
        {
            removeWhiteToArrayList("white_piano_key_item_index_18");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19)
        {
            removeWhiteToArrayList("white_piano_key_item_index_19");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20)
        {
            removeWhiteToArrayList("white_piano_key_item_index_20");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21)
        {
            removeWhiteToArrayList("white_piano_key_item_index_21");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22)
        {
            removeWhiteToArrayList("white_piano_key_item_index_22");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23)
        {
            removeWhiteToArrayList("white_piano_key_item_index_23");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24)
        {
            removeWhiteToArrayList("white_piano_key_item_index_24");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25)
        {
            removeWhiteToArrayList("white_piano_key_item_index_25");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26)
        {
            removeWhiteToArrayList("white_piano_key_item_index_26");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27)
        {
            removeWhiteToArrayList("white_piano_key_item_index_27");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28)
        {
            removeWhiteToArrayList("white_piano_key_item_index_28");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29)
        {
            removeWhiteToArrayList("white_piano_key_item_index_29");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30)
        {
            removeWhiteToArrayList("white_piano_key_item_index_30");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31)
        {
            removeWhiteToArrayList("white_piano_key_item_index_31");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32)
        {
            removeWhiteToArrayList("white_piano_key_item_index_32");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33)
        {
            removeWhiteToArrayList("white_piano_key_item_index_33");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34)
        {
            removeWhiteToArrayList("white_piano_key_item_index_34");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35)
        {
            removeWhiteToArrayList("white_piano_key_item_index_35");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36)
        {
            removeWhiteToArrayList("white_piano_key_item_index_36");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37)
        {
            removeWhiteToArrayList("white_piano_key_item_index_37");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38)
        {
            removeWhiteToArrayList("white_piano_key_item_index_38");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39)
        {
            removeWhiteToArrayList("white_piano_key_item_index_39");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40)
        {
            removeWhiteToArrayList("white_piano_key_item_index_40");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41)
        {
            removeWhiteToArrayList("white_piano_key_item_index_41");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42)
        {
            removeWhiteToArrayList("white_piano_key_item_index_42");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43)
        {
            removeWhiteToArrayList("white_piano_key_item_index_43");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44)
        {
            removeWhiteToArrayList("white_piano_key_item_index_44");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45)
        {
            removeWhiteToArrayList("white_piano_key_item_index_45");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46)
        {
            removeWhiteToArrayList("white_piano_key_item_index_46");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47)
        {
            removeWhiteToArrayList("white_piano_key_item_index_47");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48)
        {
            removeWhiteToArrayList("white_piano_key_item_index_48");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49)
        {
            removeWhiteToArrayList("white_piano_key_item_index_49");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50)
        {
            removeWhiteToArrayList("white_piano_key_item_index_50");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51)
        {
            removeWhiteToArrayList("white_piano_key_item_index_51");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52)
        {
            removeWhiteToArrayList("white_piano_key_item_index_52");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53)
        {
            removeWhiteToArrayList("white_piano_key_item_index_53");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54)
        {
            removeWhiteToArrayList("white_piano_key_item_index_54");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55)
        {
            removeWhiteToArrayList("white_piano_key_item_index_55");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56)
        {
            removeWhiteToArrayList("white_piano_key_item_index_56");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57)
        {
            removeWhiteToArrayList("white_piano_key_item_index_57");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58)
        {
            removeWhiteToArrayList("white_piano_key_item_index_58");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59)
        {
            removeWhiteToArrayList("white_piano_key_item_index_59");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60)
        {
            removeWhiteToArrayList("white_piano_key_item_index_60");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61)
        {
            removeWhiteToArrayList("white_piano_key_item_index_61");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62)
        {
            removeWhiteToArrayList("white_piano_key_item_index_62");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63)
        {
            removeWhiteToArrayList("white_piano_key_item_index_63");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64)
        {
            removeWhiteToArrayList("white_piano_key_item_index_64");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65)
        {
            removeWhiteToArrayList("white_piano_key_item_index_65");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66)
        {
            removeWhiteToArrayList("white_piano_key_item_index_66");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67)
        {
            removeWhiteToArrayList("white_piano_key_item_index_67");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68)
        {
            removeWhiteToArrayList("white_piano_key_item_index_68");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69)
        {
            removeWhiteToArrayList("white_piano_key_item_index_69");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70)
        {
            removeWhiteToArrayList("white_piano_key_item_index_70");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71)
        {
            removeWhiteToArrayList("white_piano_key_item_index_71");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72)
        {
            removeWhiteToArrayList("white_piano_key_item_index_72");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73)
        {
            removeWhiteToArrayList("white_piano_key_item_index_73");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74)
        {
            removeWhiteToArrayList("white_piano_key_item_index_74");
        }
    }

    public static void blackDefault(MouseEvent event)
    {
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0)
        {
            removeWhiteToArrayList("black_piano_key_item_index_0");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1)
        {
            removeWhiteToArrayList("black_piano_key_item_index_1");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2)
        {
            removeWhiteToArrayList("black_piano_key_item_index_2");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3)
        {
            removeWhiteToArrayList("black_piano_key_item_index_3");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4)
        {
            removeWhiteToArrayList("black_piano_key_item_index_4");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5)
        {
            removeWhiteToArrayList("black_piano_key_item_index_5");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6)
        {
            removeWhiteToArrayList("black_piano_key_item_index_6");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7)
        {
            removeWhiteToArrayList("black_piano_key_item_index_7");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8)
        {
            removeWhiteToArrayList("black_piano_key_item_index_8");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9)
        {
            removeWhiteToArrayList("black_piano_key_item_index_9");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10)
        {
            removeWhiteToArrayList("black_piano_key_item_index_10");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11)
        {
            removeWhiteToArrayList("black_piano_key_item_index_11");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12)
        {
            removeWhiteToArrayList("black_piano_key_item_index_12");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13)
        {
            removeWhiteToArrayList("black_piano_key_item_index_13");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14)
        {
            removeWhiteToArrayList("black_piano_key_item_index_14");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15)
        {
            removeWhiteToArrayList("black_piano_key_item_index_15");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16)
        {
            removeWhiteToArrayList("black_piano_key_item_index_16");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17)
        {
            removeWhiteToArrayList("black_piano_key_item_index_17");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18)
        {
            removeWhiteToArrayList("black_piano_key_item_index_18");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19)
        {
            removeWhiteToArrayList("black_piano_key_item_index_19");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20)
        {
            removeWhiteToArrayList("black_piano_key_item_index_20");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21)
        {
            removeWhiteToArrayList("black_piano_key_item_index_21");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22)
        {
            removeWhiteToArrayList("black_piano_key_item_index_22");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23)
        {
            removeWhiteToArrayList("black_piano_key_item_index_23");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24)
        {
            removeWhiteToArrayList("black_piano_key_item_index_24");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25)
        {
            removeWhiteToArrayList("black_piano_key_item_index_25");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26)
        {
            removeWhiteToArrayList("black_piano_key_item_index_26");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27)
        {
            removeWhiteToArrayList("black_piano_key_item_index_27");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28)
        {
            removeWhiteToArrayList("black_piano_key_item_index_28");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29)
        {
            removeWhiteToArrayList("black_piano_key_item_index_29");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30)
        {
            removeWhiteToArrayList("black_piano_key_item_index_30");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31)
        {
            removeWhiteToArrayList("black_piano_key_item_index_31");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32)
        {
            removeWhiteToArrayList("black_piano_key_item_index_32");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33)
        {
            removeWhiteToArrayList("black_piano_key_item_index_33");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34)
        {
            removeWhiteToArrayList("black_piano_key_item_index_34");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35)
        {
            removeWhiteToArrayList("black_piano_key_item_index_35");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36)
        {
            removeWhiteToArrayList("black_piano_key_item_index_36");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37)
        {
            removeWhiteToArrayList("black_piano_key_item_index_37");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38)
        {
            removeWhiteToArrayList("black_piano_key_item_index_38");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39)
        {
            removeWhiteToArrayList("black_piano_key_item_index_39");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40)
        {
            removeWhiteToArrayList("black_piano_key_item_index_40");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41)
        {
            removeWhiteToArrayList("black_piano_key_item_index_41");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42)
        {
            removeWhiteToArrayList("black_piano_key_item_index_42");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43)
        {
            removeWhiteToArrayList("black_piano_key_item_index_43");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44)
        {
            removeWhiteToArrayList("black_piano_key_item_index_44");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45)
        {
            removeWhiteToArrayList("black_piano_key_item_index_45");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46)
        {
            removeWhiteToArrayList("black_piano_key_item_index_46");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47)
        {
            removeWhiteToArrayList("black_piano_key_item_index_47");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48)
        {
            removeWhiteToArrayList("black_piano_key_item_index_48");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49)
        {
            removeWhiteToArrayList("black_piano_key_item_index_49");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50)
        {
            removeWhiteToArrayList("black_piano_key_item_index_50");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51)
        {
            removeWhiteToArrayList("black_piano_key_item_index_51");
        }
        if (event.getSource() == WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52)
        {
            removeWhiteToArrayList("black_piano_key_item_index_52");
        }
    }

    public static void midiDeviceControlConnectToPianoKeys(int channel, int pitch)
    {
        if (pitch == 0)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_0");
        }
        if (pitch == 1)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_0");
        }
        if (pitch == 2)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_1");
        }
        if (pitch == 3)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_1");
        }
        if (pitch == 4)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_2");
        }
        if (pitch == 5)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_3");
        }
        if (pitch == 6)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_2");
        }
        if (pitch == 7)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_4");
        }
        if (pitch == 8)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_3");
        }
        if (pitch == 9)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_5");
        }
        if (pitch == 10)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_4");
        }
        if (pitch == 11)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_6");
        }
        if (pitch == 12)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_7");
        }
        if (pitch == 13)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_5");
        }
        if (pitch == 14)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_8");
        }
        if (pitch == 15)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_6");
        }
        if (pitch == 16)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_9");
        }
        if (pitch == 17)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_10");
        }
        if (pitch == 18)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_7");
        }
        if (pitch == 19)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_11");
        }
        if (pitch == 20)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_8");
        }
        if (pitch == 21)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_12");
        }
        if (pitch == 22)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_9");
        }
        if (pitch == 23)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_13");
        }
        if (pitch == 24)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_14");
        }
        if (pitch == 25)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_10");
        }
        if (pitch == 26)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_15");
        }
        if (pitch == 27)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_11");
        }
        if (pitch == 28)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_16");
        }
        if (pitch == 29)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_17");
        }
        if (pitch == 30)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_12");
        }
        if (pitch == 31)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_18");
        }
        if (pitch == 32)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_13");
        }
        if (pitch == 33)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_19");
        }
        if (pitch == 34)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_14");
        }
        if (pitch == 35)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_20");
        }
        if (pitch == 36)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_21");
        }
        if (pitch == 37)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_15");
        }
        if (pitch == 38)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_22");
        }
        if (pitch == 39)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_16");
        }
        if (pitch == 40)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_23");
        }
        if (pitch == 41)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_24");
        }
        if (pitch == 42)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_17");
        }
        if (pitch == 43)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_25");
        }
        if (pitch == 44)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_18");
        }
        if (pitch == 45)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_26");
        }
        if (pitch == 46)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_19");
        }
        if (pitch == 47)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_27");
        }
        if (pitch == 48)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_28");
        }
        if (pitch == 49)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_20");
        }
        if (pitch == 50)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_29");
        }
        if (pitch == 51)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_21");
        }
        if (pitch == 52)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_30");
        }
        if (pitch == 53)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_31");
        }
        if (pitch == 54)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_22");
        }
        if (pitch == 55)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_32");
        }
        if (pitch == 56)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_23");
        }
        if (pitch == 57)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_33");
        }
        if (pitch == 58)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_24");
        }
        if (pitch == 59)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_34");
        }
        if (pitch == 60)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_35");
        }
        if (pitch == 61)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_25");
        }
        if (pitch == 62)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_36");
        }
        if (pitch == 63)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_26");
        }
        if (pitch == 64)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_37");
        }
        if (pitch == 65)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_38");
        }
        if (pitch == 66)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_27");
        }
        if (pitch == 67)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_39");
        }
        if (pitch == 68)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_28");
        }
        if (pitch == 69)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_40");
        }
        if (pitch == 70)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_29");
        }
        if (pitch == 71)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_41");
        }
        if (pitch == 72)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_42");
        }
        if (pitch == 73)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_30");
        }
        if (pitch == 74)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_43");
        }
        if (pitch == 75)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_31");
        }
        if (pitch == 76)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_44");
        }
        if (pitch == 77)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_45");
        }
        if (pitch == 78)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_32");
        }
        if (pitch == 79)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_46");
        }
        if (pitch == 80)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_33");
        }
        if (pitch == 81)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_47");
        }
        if (pitch == 82)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_34");
        }
        if (pitch == 83)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_48");
        }
        if (pitch == 84)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_49");
        }
        if (pitch == 85)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_35");
        }
        if (pitch == 86)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_50");
        }
        if (pitch == 87)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_36");
        }
        if (pitch == 88)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_51");
        }
        if (pitch == 89)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_52");
        }
        if (pitch == 90)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_37");
        }
        if (pitch == 91)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_53");
        }
        if (pitch == 92)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_38");
        }
        if (pitch == 93)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_54");
        }
        if (pitch == 94)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_39");
        }
        if (pitch == 95)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_55");
        }
        if (pitch == 96)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_56");
        }
        if (pitch == 97)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_40");
        }
        if (pitch == 98)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_57");
        }
        if (pitch == 99)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_41");
        }
        if (pitch == 100)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_58");
        }
        if (pitch == 101)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_59");
        }
        if (pitch == 102)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_42");
        }
        if (pitch == 103)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_60");
        }
        if (pitch == 104)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_43");
        }
        if (pitch == 105)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_61");
        }
        if (pitch == 106)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_44");
        }
        if (pitch == 107)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_62");
        }
        if (pitch == 108)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_63");
        }
        if (pitch == 109)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_45");
        }
        if (pitch == 110)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_64");
        }
        if (pitch == 111)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_46");
        }
        if (pitch == 112)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_65");
        }
        if (pitch == 113)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_66");
        }
        if (pitch == 114)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_47");
        }
        if (pitch == 115)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_67");
        }
        if (pitch == 116)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_48");
        }
        if (pitch == 117)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_68");
        }
        if (pitch == 118)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_49");
        }
        if (pitch == 119)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_69");
        }
        if (pitch == 120)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_70");
        }
        if (pitch == 121)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_50");
        }
        if (pitch == 122)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_71");
        }
        if (pitch == 123)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_51");
        }
        if (pitch == 124)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_72");
        }
        if (pitch == 125)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_73");
        }
        if (pitch == 126)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "black_piano_key_item_index_52");
        }
        if (pitch == 127)
        {
            addWhiteToArrayList(
                    channel,
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.getX(),
                    MainContainerPage_1.getPianoKeyBox().getY(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.getWidth(),
                    WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.getY(),
                    MainContainerPage_1.getMainContainerPanel().getY(), "white_piano_key_item_index_74");
        }
    }

    public static void midiDeviceControlDisconnectToPianoKeys(int pitch)
    {
        if (pitch == 0)
        {
            removeWhiteToArrayList("white_piano_key_item_index_0");
        }
        if (pitch == 1)
        {
            removeWhiteToArrayList("black_piano_key_item_index_0");
        }
        if (pitch == 2)
        {
            removeWhiteToArrayList("white_piano_key_item_index_1");
        }
        if (pitch == 3)
        {
            removeWhiteToArrayList("black_piano_key_item_index_1");
        }
        if (pitch == 4)
        {
            removeWhiteToArrayList("white_piano_key_item_index_2");
        }
        if (pitch == 5)
        {
            removeWhiteToArrayList("white_piano_key_item_index_3");
        }
        if (pitch == 6)
        {
            removeWhiteToArrayList("black_piano_key_item_index_2");
        }
        if (pitch == 7)
        {
            removeWhiteToArrayList("white_piano_key_item_index_4");
        }
        if (pitch == 8)
        {
            removeWhiteToArrayList("black_piano_key_item_index_3");
        }
        if (pitch == 9)
        {
            removeWhiteToArrayList("white_piano_key_item_index_5");
        }
        if (pitch == 10)
        {
            removeWhiteToArrayList("black_piano_key_item_index_4");
        }
        if (pitch == 11)
        {
            removeWhiteToArrayList("white_piano_key_item_index_6");
        }
        if (pitch == 12)
        {
            removeWhiteToArrayList("white_piano_key_item_index_7");
        }
        if (pitch == 13)
        {
            removeWhiteToArrayList("black_piano_key_item_index_5");
        }
        if (pitch == 14)
        {
            removeWhiteToArrayList("white_piano_key_item_index_8");
        }
        if (pitch == 15)
        {
            removeWhiteToArrayList("black_piano_key_item_index_6");
        }
        if (pitch == 16)
        {
            removeWhiteToArrayList("white_piano_key_item_index_9");
        }
        if (pitch == 17)
        {
            removeWhiteToArrayList("white_piano_key_item_index_10");
        }
        if (pitch == 18)
        {
            removeWhiteToArrayList("black_piano_key_item_index_7");
        }
        if (pitch == 19)
        {
            removeWhiteToArrayList("white_piano_key_item_index_11");
        }
        if (pitch == 20)
        {
            removeWhiteToArrayList("black_piano_key_item_index_8");
        }
        if (pitch == 21)
        {
            removeWhiteToArrayList("white_piano_key_item_index_12");
        }
        if (pitch == 22)
        {
            removeWhiteToArrayList("black_piano_key_item_index_9");
        }
        if (pitch == 23)
        {
            removeWhiteToArrayList("white_piano_key_item_index_13");
        }
        if (pitch == 24)
        {
            removeWhiteToArrayList("white_piano_key_item_index_14");
        }
        if (pitch == 25)
        {
            removeWhiteToArrayList("black_piano_key_item_index_10");
        }
        if (pitch == 26)
        {
            removeWhiteToArrayList("white_piano_key_item_index_15");
        }
        if (pitch == 27)
        {
            removeWhiteToArrayList("black_piano_key_item_index_11");
        }
        if (pitch == 28)
        {
            removeWhiteToArrayList("white_piano_key_item_index_16");
        }
        if (pitch == 29)
        {
            removeWhiteToArrayList("white_piano_key_item_index_17");
        }
        if (pitch == 30)
        {
            removeWhiteToArrayList("black_piano_key_item_index_12");
        }
        if (pitch == 31)
        {
            removeWhiteToArrayList("white_piano_key_item_index_18");
        }
        if (pitch == 32)
        {
            removeWhiteToArrayList("black_piano_key_item_index_13");
        }
        if (pitch == 33)
        {
            removeWhiteToArrayList("white_piano_key_item_index_19");
        }
        if (pitch == 34)
        {
            removeWhiteToArrayList("black_piano_key_item_index_14");
        }
        if (pitch == 35)
        {
            removeWhiteToArrayList("white_piano_key_item_index_20");
        }
        if (pitch == 36)
        {
            removeWhiteToArrayList("white_piano_key_item_index_21");
        }
        if (pitch == 37)
        {
            removeWhiteToArrayList("black_piano_key_item_index_15");
        }
        if (pitch == 38)
        {
            removeWhiteToArrayList("white_piano_key_item_index_22");
        }
        if (pitch == 39)
        {
            removeWhiteToArrayList("black_piano_key_item_index_16");
        }
        if (pitch == 40)
        {
            removeWhiteToArrayList("white_piano_key_item_index_23");
        }
        if (pitch == 41)
        {
            removeWhiteToArrayList("white_piano_key_item_index_24");
        }
        if (pitch == 42)
        {
            removeWhiteToArrayList("black_piano_key_item_index_17");
        }
        if (pitch == 43)
        {
            removeWhiteToArrayList("white_piano_key_item_index_25");
        }
        if (pitch == 44)
        {
            removeWhiteToArrayList("black_piano_key_item_index_18");
        }
        if (pitch == 45)
        {
            removeWhiteToArrayList("white_piano_key_item_index_26");
        }
        if (pitch == 46)
        {
            removeWhiteToArrayList("black_piano_key_item_index_19");
        }
        if (pitch == 47)
        {
            removeWhiteToArrayList("white_piano_key_item_index_27");
        }
        if (pitch == 48)
        {
            removeWhiteToArrayList("white_piano_key_item_index_28");
        }
        if (pitch == 49)
        {
            removeWhiteToArrayList("black_piano_key_item_index_20");
        }
        if (pitch == 50)
        {
            removeWhiteToArrayList("white_piano_key_item_index_29");
        }
        if (pitch == 51)
        {
            removeWhiteToArrayList("black_piano_key_item_index_21");
        }
        if (pitch == 52)
        {
            removeWhiteToArrayList("white_piano_key_item_index_30");
        }
        if (pitch == 53)
        {
            removeWhiteToArrayList("white_piano_key_item_index_31");
        }
        if (pitch == 54)
        {
            removeWhiteToArrayList("black_piano_key_item_index_22");
        }
        if (pitch == 55)
        {
            removeWhiteToArrayList("white_piano_key_item_index_32");
        }
        if (pitch == 56)
        {
            removeWhiteToArrayList("black_piano_key_item_index_23");
        }
        if (pitch == 57)
        {
            removeWhiteToArrayList("white_piano_key_item_index_33");
        }
        if (pitch == 58)
        {
            removeWhiteToArrayList("black_piano_key_item_index_24");
        }
        if (pitch == 59)
        {
            removeWhiteToArrayList("white_piano_key_item_index_34");
        }
        if (pitch == 60)
        {
            removeWhiteToArrayList("white_piano_key_item_index_35");
        }
        if (pitch == 61)
        {
            removeWhiteToArrayList("black_piano_key_item_index_25");
        }
        if (pitch == 62)
        {
            removeWhiteToArrayList("white_piano_key_item_index_36");
        }
        if (pitch == 63)
        {
            removeWhiteToArrayList("black_piano_key_item_index_26");
        }
        if (pitch == 64)
        {
            removeWhiteToArrayList("white_piano_key_item_index_37");
        }
        if (pitch == 65)
        {
            removeWhiteToArrayList("white_piano_key_item_index_38");
        }
        if (pitch == 66)
        {
            removeWhiteToArrayList("black_piano_key_item_index_27");
        }
        if (pitch == 67)
        {
            removeWhiteToArrayList("white_piano_key_item_index_39");
        }
        if (pitch == 68)
        {
            removeWhiteToArrayList("black_piano_key_item_index_28");
        }
        if (pitch == 69)
        {
            removeWhiteToArrayList("white_piano_key_item_index_40");
        }
        if (pitch == 70)
        {
            removeWhiteToArrayList("black_piano_key_item_index_29");
        }
        if (pitch == 71)
        {
            removeWhiteToArrayList("white_piano_key_item_index_41");
        }
        if (pitch == 72)
        {
            removeWhiteToArrayList("white_piano_key_item_index_42");
        }
        if (pitch == 73)
        {
            removeWhiteToArrayList("black_piano_key_item_index_30");
        }
        if (pitch == 74)
        {
            removeWhiteToArrayList("white_piano_key_item_index_43");
        }
        if (pitch == 75)
        {
            removeWhiteToArrayList("black_piano_key_item_index_31");
        }
        if (pitch == 76)
        {
            removeWhiteToArrayList("white_piano_key_item_index_44");
        }
        if (pitch == 77)
        {
            removeWhiteToArrayList("white_piano_key_item_index_45");
        }
        if (pitch == 78)
        {
            removeWhiteToArrayList("black_piano_key_item_index_32");
        }
        if (pitch == 79)
        {
            removeWhiteToArrayList("white_piano_key_item_index_46");
        }
        if (pitch == 80)
        {
            removeWhiteToArrayList("black_piano_key_item_index_33");
        }
        if (pitch == 81)
        {
            removeWhiteToArrayList("white_piano_key_item_index_47");
        }
        if (pitch == 82)
        {
            removeWhiteToArrayList("black_piano_key_item_index_34");
        }
        if (pitch == 83)
        {
            removeWhiteToArrayList("white_piano_key_item_index_48");
        }
        if (pitch == 84)
        {
            removeWhiteToArrayList("white_piano_key_item_index_49");
        }
        if (pitch == 85)
        {
            removeWhiteToArrayList("black_piano_key_item_index_35");
        }
        if (pitch == 86)
        {
            removeWhiteToArrayList("white_piano_key_item_index_50");
        }
        if (pitch == 87)
        {
            removeWhiteToArrayList("black_piano_key_item_index_36");
        }
        if (pitch == 88)
        {
            removeWhiteToArrayList("white_piano_key_item_index_51");
        }
        if (pitch == 89)
        {
            removeWhiteToArrayList("white_piano_key_item_index_52");
        }
        if (pitch == 90)
        {
            removeWhiteToArrayList("black_piano_key_item_index_37");
        }
        if (pitch == 91)
        {
            removeWhiteToArrayList("white_piano_key_item_index_53");
        }
        if (pitch == 92)
        {
            removeWhiteToArrayList("black_piano_key_item_index_38");
        }
        if (pitch == 93)
        {
            removeWhiteToArrayList("white_piano_key_item_index_54");
        }
        if (pitch == 94)
        {
            removeWhiteToArrayList("black_piano_key_item_index_39");
        }
        if (pitch == 95)
        {
            removeWhiteToArrayList("white_piano_key_item_index_55");
        }
        if (pitch == 96)
        {
            removeWhiteToArrayList("white_piano_key_item_index_56");
        }
        if (pitch == 97)
        {
            removeWhiteToArrayList("black_piano_key_item_index_40");
        }
        if (pitch == 98)
        {
            removeWhiteToArrayList("white_piano_key_item_index_57");
        }
        if (pitch == 99)
        {
            removeWhiteToArrayList("black_piano_key_item_index_41");
        }
        if (pitch == 100)
        {
            removeWhiteToArrayList("white_piano_key_item_index_58");
        }
        if (pitch == 101)
        {
            removeWhiteToArrayList("white_piano_key_item_index_59");
        }
        if (pitch == 102)
        {
            removeWhiteToArrayList("black_piano_key_item_index_42");
        }
        if (pitch == 103)
        {
            removeWhiteToArrayList("white_piano_key_item_index_60");
        }
        if (pitch == 104)
        {
            removeWhiteToArrayList("black_piano_key_item_index_43");
        }
        if (pitch == 105)
        {
            removeWhiteToArrayList("white_piano_key_item_index_61");
        }
        if (pitch == 106)
        {
            removeWhiteToArrayList("black_piano_key_item_index_44");
        }
        if (pitch == 107)
        {
            removeWhiteToArrayList("white_piano_key_item_index_62");
        }
        if (pitch == 108)
        {
            removeWhiteToArrayList("white_piano_key_item_index_63");
        }
        if (pitch == 109)
        {
            removeWhiteToArrayList("black_piano_key_item_index_45");
        }
        if (pitch == 110)
        {
            removeWhiteToArrayList("white_piano_key_item_index_64");
        }
        if (pitch == 111)
        {
            removeWhiteToArrayList("black_piano_key_item_index_46");
        }
        if (pitch == 112)
        {
            removeWhiteToArrayList("white_piano_key_item_index_65");
        }
        if (pitch == 113)
        {
            removeWhiteToArrayList("white_piano_key_item_index_66");
        }
        if (pitch == 114)
        {
            removeWhiteToArrayList("black_piano_key_item_index_47");
        }
        if (pitch == 115)
        {
            removeWhiteToArrayList("white_piano_key_item_index_67");
        }
        if (pitch == 116)
        {
            removeWhiteToArrayList("black_piano_key_item_index_48");
        }
        if (pitch == 117)
        {
            removeWhiteToArrayList("white_piano_key_item_index_68");
        }
        if (pitch == 118)
        {
            removeWhiteToArrayList("black_piano_key_item_index_49");
        }
        if (pitch == 119)
        {
            removeWhiteToArrayList("white_piano_key_item_index_69");
        }
        if (pitch == 120)
        {
            removeWhiteToArrayList("white_piano_key_item_index_70");
        }
        if (pitch == 121)
        {
            removeWhiteToArrayList("black_piano_key_item_index_50");
        }
        if (pitch == 122)
        {
            removeWhiteToArrayList("white_piano_key_item_index_71");
        }
        if (pitch == 123)
        {
            removeWhiteToArrayList("black_piano_key_item_index_51");
        }
        if (pitch == 124)
        {
            removeWhiteToArrayList("white_piano_key_item_index_72");
        }
        if (pitch == 125)
        {
            removeWhiteToArrayList("white_piano_key_item_index_73");
        }
        if (pitch == 126)
        {
            removeWhiteToArrayList("black_piano_key_item_index_52");
        }
        if (pitch == 127)
        {
            removeWhiteToArrayList("white_piano_key_item_index_74");
        }
    }

    public static ArrayList<Object[]> getPianoNoteBlockTempArrayList()
    {
        return pianoNoteBlockTempArrayList;
    }
}
