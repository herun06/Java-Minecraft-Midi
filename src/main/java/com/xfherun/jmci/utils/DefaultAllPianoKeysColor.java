/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import main.java.com.xfherun.jmci.piano_data.API_INTERFACE.PianoDataStreamInputIO;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.user_interface.section.page_1.SetWhitePianoKeysAndBlackPianoKeysStyle;
import main.java.com.xfherun.jmci.user_interface.section.page_1.WhitePianoKeysAndBlackPianoKeysObject;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.ConnectPianoAllKeys;
import main.java.com.xfherun.jmci.user_interface.section.page_1.falling_block.SetAllPianoKeyBoardColor;

public class DefaultAllPianoKeysColor
{
    private DefaultAllPianoKeysColor()
    {
    }

    public static void defaultPianoKeys()
    {
        new Thread(() -> start()).start();
        if (!CurrentPianoInformation.isEnableNoteFallEffectBlock)
            new Thread(() -> clearAllNoteBlock()).start();
    }

    private static void clearAllNoteBlock()
    {
        for (int i = 0; i < 128; i++)
        {
            ConnectPianoAllKeys.midiDeviceControlDisconnectToPianoKeys(i);
        }
    }

    private static void start()
    {
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getWhiteNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.setBackground(SetWhitePianoKeysAndBlackPianoKeysStyle.getBlackNormalColor());
    }
}
