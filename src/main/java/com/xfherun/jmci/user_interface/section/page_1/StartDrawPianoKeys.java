package main.java.com.xfherun.jmci.user_interface.section.page_1;

public class StartDrawPianoKeys
{
    private static int[] blackPianoKeysIndexArray;
    private static int[] whitePianoKeysIndexArray;

    private StartDrawPianoKeys()
    {
    }

    public static void startDraw(int[] blackPianoKeysIndexArray_, int[] whitePianoKeysIndexArray_)
    {
        blackPianoKeysIndexArray = blackPianoKeysIndexArray_;
        whitePianoKeysIndexArray = whitePianoKeysIndexArray_;
        drawBlackPianoKeys();
        drawWhitePianoKeys();
    }

    private static void createWhiteObject()
    {
        CreateWhiteAndBlackPianoKeysObject.createWhitePianoKeysObject();
        AddAllPianoKeysToContainer.addWhitePianoKeys();
    }

    private static void createBlackObject()
    {
        CreateWhiteAndBlackPianoKeysObject.createBlackPianoKeysObject();
        AddAllPianoKeysToContainer.addBlackPianoKeys();
    }


    private static void drawBlackPianoKeys()
    {
        createBlackObject();
        AddAllPianoKeysStyle.startB();
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_0.setBounds(blackPianoKeysIndexArray[0], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_1.setBounds(blackPianoKeysIndexArray[1], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_2.setBounds(blackPianoKeysIndexArray[2], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_3.setBounds(blackPianoKeysIndexArray[3], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_4.setBounds(blackPianoKeysIndexArray[4], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_5.setBounds(blackPianoKeysIndexArray[5], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_6.setBounds(blackPianoKeysIndexArray[6], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_7.setBounds(blackPianoKeysIndexArray[7], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_8.setBounds(blackPianoKeysIndexArray[8], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_9.setBounds(blackPianoKeysIndexArray[9], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_10.setBounds(blackPianoKeysIndexArray[10], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_11.setBounds(blackPianoKeysIndexArray[11], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_12.setBounds(blackPianoKeysIndexArray[12], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_13.setBounds(blackPianoKeysIndexArray[13], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_14.setBounds(blackPianoKeysIndexArray[14], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_15.setBounds(blackPianoKeysIndexArray[15], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_16.setBounds(blackPianoKeysIndexArray[16], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_17.setBounds(blackPianoKeysIndexArray[17], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_18.setBounds(blackPianoKeysIndexArray[18], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_19.setBounds(blackPianoKeysIndexArray[19], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_20.setBounds(blackPianoKeysIndexArray[20], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_21.setBounds(blackPianoKeysIndexArray[21], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_22.setBounds(blackPianoKeysIndexArray[22], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_23.setBounds(blackPianoKeysIndexArray[23], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_24.setBounds(blackPianoKeysIndexArray[24], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_25.setBounds(blackPianoKeysIndexArray[25], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_26.setBounds(blackPianoKeysIndexArray[26], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_27.setBounds(blackPianoKeysIndexArray[27], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_28.setBounds(blackPianoKeysIndexArray[28], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_29.setBounds(blackPianoKeysIndexArray[29], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_30.setBounds(blackPianoKeysIndexArray[30], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_31.setBounds(blackPianoKeysIndexArray[31], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_32.setBounds(blackPianoKeysIndexArray[32], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_33.setBounds(blackPianoKeysIndexArray[33], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_34.setBounds(blackPianoKeysIndexArray[34], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_35.setBounds(blackPianoKeysIndexArray[35], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_36.setBounds(blackPianoKeysIndexArray[36], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_37.setBounds(blackPianoKeysIndexArray[37], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_38.setBounds(blackPianoKeysIndexArray[38], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_39.setBounds(blackPianoKeysIndexArray[39], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_40.setBounds(blackPianoKeysIndexArray[40], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_41.setBounds(blackPianoKeysIndexArray[41], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_42.setBounds(blackPianoKeysIndexArray[42], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_43.setBounds(blackPianoKeysIndexArray[43], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_44.setBounds(blackPianoKeysIndexArray[44], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_45.setBounds(blackPianoKeysIndexArray[45], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_46.setBounds(blackPianoKeysIndexArray[46], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_47.setBounds(blackPianoKeysIndexArray[47], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_48.setBounds(blackPianoKeysIndexArray[48], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_49.setBounds(blackPianoKeysIndexArray[49], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_50.setBounds(blackPianoKeysIndexArray[50], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_51.setBounds(blackPianoKeysIndexArray[51], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.black_piano_key_item_index_52.setBounds(blackPianoKeysIndexArray[52], 0, DrawPianoKeys.getBlackPianoKeyWidth(), DrawPianoKeys.getBlackPianoKeyHeight());
    }

    private static void drawWhitePianoKeys()
    {
        createWhiteObject();
        AddAllPianoKeysStyle.startW();
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_0.setBounds(whitePianoKeysIndexArray[0], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_1.setBounds(whitePianoKeysIndexArray[1], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_2.setBounds(whitePianoKeysIndexArray[2], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_3.setBounds(whitePianoKeysIndexArray[3], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_4.setBounds(whitePianoKeysIndexArray[4], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_5.setBounds(whitePianoKeysIndexArray[5], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_6.setBounds(whitePianoKeysIndexArray[6], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_7.setBounds(whitePianoKeysIndexArray[7], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_8.setBounds(whitePianoKeysIndexArray[8], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_9.setBounds(whitePianoKeysIndexArray[9], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_10.setBounds(whitePianoKeysIndexArray[10], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_11.setBounds(whitePianoKeysIndexArray[11], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_12.setBounds(whitePianoKeysIndexArray[12], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_13.setBounds(whitePianoKeysIndexArray[13], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_14.setBounds(whitePianoKeysIndexArray[14], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_15.setBounds(whitePianoKeysIndexArray[15], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_16.setBounds(whitePianoKeysIndexArray[16], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_17.setBounds(whitePianoKeysIndexArray[17], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_18.setBounds(whitePianoKeysIndexArray[18], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_19.setBounds(whitePianoKeysIndexArray[19], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_20.setBounds(whitePianoKeysIndexArray[20], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_21.setBounds(whitePianoKeysIndexArray[21], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_22.setBounds(whitePianoKeysIndexArray[22], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_23.setBounds(whitePianoKeysIndexArray[23], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_24.setBounds(whitePianoKeysIndexArray[24], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_25.setBounds(whitePianoKeysIndexArray[25], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_26.setBounds(whitePianoKeysIndexArray[26], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_27.setBounds(whitePianoKeysIndexArray[27], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_28.setBounds(whitePianoKeysIndexArray[28], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_29.setBounds(whitePianoKeysIndexArray[29], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_30.setBounds(whitePianoKeysIndexArray[30], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_31.setBounds(whitePianoKeysIndexArray[31], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_32.setBounds(whitePianoKeysIndexArray[32], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_33.setBounds(whitePianoKeysIndexArray[33], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_34.setBounds(whitePianoKeysIndexArray[34], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_35.setBounds(whitePianoKeysIndexArray[35], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_36.setBounds(whitePianoKeysIndexArray[36], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_37.setBounds(whitePianoKeysIndexArray[37], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_38.setBounds(whitePianoKeysIndexArray[38], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_39.setBounds(whitePianoKeysIndexArray[39], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_40.setBounds(whitePianoKeysIndexArray[40], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_41.setBounds(whitePianoKeysIndexArray[41], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_42.setBounds(whitePianoKeysIndexArray[42], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_43.setBounds(whitePianoKeysIndexArray[43], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_44.setBounds(whitePianoKeysIndexArray[44], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_45.setBounds(whitePianoKeysIndexArray[45], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_46.setBounds(whitePianoKeysIndexArray[46], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_47.setBounds(whitePianoKeysIndexArray[47], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_48.setBounds(whitePianoKeysIndexArray[48], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_49.setBounds(whitePianoKeysIndexArray[49], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_50.setBounds(whitePianoKeysIndexArray[50], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_51.setBounds(whitePianoKeysIndexArray[51], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_52.setBounds(whitePianoKeysIndexArray[52], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_53.setBounds(whitePianoKeysIndexArray[53], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_54.setBounds(whitePianoKeysIndexArray[54], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_55.setBounds(whitePianoKeysIndexArray[55], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_56.setBounds(whitePianoKeysIndexArray[56], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_57.setBounds(whitePianoKeysIndexArray[57], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_58.setBounds(whitePianoKeysIndexArray[58], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_59.setBounds(whitePianoKeysIndexArray[59], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_60.setBounds(whitePianoKeysIndexArray[60], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_61.setBounds(whitePianoKeysIndexArray[61], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_62.setBounds(whitePianoKeysIndexArray[62], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_63.setBounds(whitePianoKeysIndexArray[63], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_64.setBounds(whitePianoKeysIndexArray[64], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_65.setBounds(whitePianoKeysIndexArray[65], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_66.setBounds(whitePianoKeysIndexArray[66], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_67.setBounds(whitePianoKeysIndexArray[67], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_68.setBounds(whitePianoKeysIndexArray[68], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_69.setBounds(whitePianoKeysIndexArray[69], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_70.setBounds(whitePianoKeysIndexArray[70], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_71.setBounds(whitePianoKeysIndexArray[71], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_72.setBounds(whitePianoKeysIndexArray[72], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_73.setBounds(whitePianoKeysIndexArray[73], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
        WhitePianoKeysAndBlackPianoKeysObject.white_piano_key_item_index_74.setBounds(whitePianoKeysIndexArray[74], 0, DrawPianoKeys.getWhitePianoKeyWidth(), DrawPianoKeys.getWhitePianoKeyHeight());
    }
}
