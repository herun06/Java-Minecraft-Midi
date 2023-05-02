package main.java.com.xfherun.jmci.user_interface.section.page_1;

import javax.swing.*;
import java.awt.*;

public class DrawPianoKeys
{
    private static int widthAll, heightAll;
    private static JPanel keyBox;
    private static int[] whitePianoKeysPointIndexArray;
    private static int[] blackPianoKeysPointIndexArray;
    private static int whitePianoKeyWidth;
    private static int blackPianoKeyWidth;
    private static int whitePianoKeyHeight;
    private static int blackPianoKeyHeight;

    private DrawPianoKeys()
    {
    }

    public static JPanel draw(int width, int height)
    {
        widthAll = width;
        heightAll = height;
        whitePianoKeysPointIndexArray = new int[75];
        blackPianoKeysPointIndexArray = new int[53];
        whitePianoKeyWidth = width / whitePianoKeysPointIndexArray.length;
        whitePianoKeyHeight = height;
        blackPianoKeyHeight = (whitePianoKeyHeight / 2) + (whitePianoKeyHeight / 4);
        blackPianoKeyWidth = (whitePianoKeyWidth / 2) + (whitePianoKeyWidth / 4);
        keyBox = new JPanel();
        keyBox.setSize(width, height);
        keyBox.setLayout(null);
        keyBox.setOpaque(true);
        keyBox.setBackground(new Color(0, 0, 0, 0));
        addWhiteKeyAndBlackKey();
        return keyBox;
    }

    private static void addWhiteKeyAndBlackKey()
    {
        initWhitePianoKeyIndex();
        initBlackPianoKeyIndex();
        StartDrawPianoKeys.startDraw(blackPianoKeysPointIndexArray, whitePianoKeysPointIndexArray);
    }

    private static void initWhitePianoKeyIndex()
    {
        int allWidth = whitePianoKeyWidth * 75;
        int x = (widthAll - allWidth) / 2;
        for (int i = 0; i < whitePianoKeysPointIndexArray.length; i++)
        {
            whitePianoKeysPointIndexArray[i] = x;
            x += whitePianoKeyWidth;
        }
    }

    private static void initBlackPianoKeyIndex()
    {
        int primaryKeyIndex = 0;
        int blackIndex = 0;
        for (int b = 0; b < 10; b++)
        {
            for (int i = 0; i <= 1; i++, primaryKeyIndex++)
            {
                blackPianoKeysPointIndexArray[blackIndex] = execute(whitePianoKeysPointIndexArray[primaryKeyIndex]);
                blackIndex++;
            }
            primaryKeyIndex++;
            for (int i = 0; i <= 2; i++, primaryKeyIndex++)
            {
                blackPianoKeysPointIndexArray[blackIndex] = execute(whitePianoKeysPointIndexArray[primaryKeyIndex]);
                blackIndex++;
            }
            primaryKeyIndex++;
        }
        for (int i = 0; i <= 1; i++, primaryKeyIndex++)
        {
            blackPianoKeysPointIndexArray[blackIndex] = execute(whitePianoKeysPointIndexArray[primaryKeyIndex]);
            blackIndex++;
        }
        primaryKeyIndex++;
        blackPianoKeysPointIndexArray[blackIndex] = execute(whitePianoKeysPointIndexArray[primaryKeyIndex]);
    }

    private static int execute(int index)
    {
        int blackIndex = 0;

        blackIndex = ((index + blackPianoKeyWidth) + ((blackPianoKeyWidth / 2) - (blackPianoKeyWidth / 4))) - blackPianoKeyWidth / 2;

        return blackIndex;
    }

    public static int getWidthAll()
    {
        return widthAll;
    }

    public static int getHeightAll()
    {
        return heightAll;
    }

    public static JPanel getKeyBox()
    {
        return keyBox;
    }

    public static int[] getWhitePianoKeysPointIndexArray()
    {
        return whitePianoKeysPointIndexArray;
    }

    public static int[] getBlackPianoKeysPointIndexArray()
    {
        return blackPianoKeysPointIndexArray;
    }

    public static int getWhitePianoKeyWidth()
    {
        return whitePianoKeyWidth;
    }

    public static int getBlackPianoKeyWidth()
    {
        return blackPianoKeyWidth;
    }

    public static int getWhitePianoKeyHeight()
    {
        return whitePianoKeyHeight;
    }

    public static int getBlackPianoKeyHeight()
    {
        return blackPianoKeyHeight;
    }

    public static void setWhitePianoKeyWidth(int whitePianoKeyWidth)
    {
        DrawPianoKeys.whitePianoKeyWidth = whitePianoKeyWidth;
    }

    public static void setBlackPianoKeyWidth(int blackPianoKeyWidth)
    {
        DrawPianoKeys.blackPianoKeyWidth = blackPianoKeyWidth;
    }

    public static void setWhitePianoKeyHeight(int whitePianoKeyHeight)
    {
        DrawPianoKeys.whitePianoKeyHeight = whitePianoKeyHeight;
    }

    public static void setBlackPianoKeyHeight(int blackPianoKeyHeight)
    {
        DrawPianoKeys.blackPianoKeyHeight = blackPianoKeyHeight;
    }
}
