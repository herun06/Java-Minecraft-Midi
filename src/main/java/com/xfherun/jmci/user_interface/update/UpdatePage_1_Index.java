package main.java.com.xfherun.jmci.user_interface.update;

import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_1;
import main.java.com.xfherun.jmci.user_interface.section.page_1.DrawPianoKeys;
import main.java.com.xfherun.jmci.user_interface.section.page_1.UpdateAllPianoKeyPointAndSize;

public class UpdatePage_1_Index
{
    private static int bh, bw;

    private UpdatePage_1_Index()
    {
    }

    public static void start()
    {
        MainContainerPage_1.getMainContainerPanel().setBounds(0, 0, MainWindow.getMainWindow().getWidth() - 16, MainWindow.getMainWindow().getHeight() - 39);
        MainContainerPage_1.getPianoKeyBox().setBounds(0,
                (MainContainerPage_1.getMainContainerPanel()
                        .getHeight() - MainContainerPage_1.getPianoKeyBox().getHeight()) / 2,
                MainContainerPage_1.getMainContainerPanel().getWidth(),
                (MainContainerPage_1.getMainContainerPanel().getHeight() / 2) -
                        (MainContainerPage_1.getMainContainerPanel().getHeight() / 4) -
                        (MainContainerPage_1.getMainContainerPanel().getHeight() / 8));

        int width = MainContainerPage_1.getPianoKeyBox().getWidth();
        int height = MainContainerPage_1.getPianoKeyBox().getHeight();

        int whitePianoKeyWidth = width / 75;
        int whitePianoKeyHeight = height;
        int blackPianoKeyWidth = (whitePianoKeyWidth / 2) + (whitePianoKeyWidth / 4);
        int blackPianoKeyHeight = (whitePianoKeyHeight / 2) + (whitePianoKeyHeight / 4);
        bh = blackPianoKeyWidth;
        bw = blackPianoKeyHeight;
        DrawPianoKeys.setWhitePianoKeyWidth(whitePianoKeyWidth);
        DrawPianoKeys.setBlackPianoKeyWidth(blackPianoKeyWidth);
        DrawPianoKeys.setWhitePianoKeyHeight(whitePianoKeyHeight);
        DrawPianoKeys.setBlackPianoKeyHeight(blackPianoKeyHeight);

        int allWidth = whitePianoKeyWidth * 75;
        int x = (width - allWidth) / 2;
        for (int i = 0; i < DrawPianoKeys.getWhitePianoKeysPointIndexArray().length; i++)
        {
            DrawPianoKeys.getWhitePianoKeysPointIndexArray()[i] = x;
            x += whitePianoKeyWidth;
        }

        initBlackPianoKeyIndex();
        UpdateAllPianoKeyPointAndSize.start();

        MainContainerPage_1.getSetMidiChannelTitle().setBounds(10, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10, 119, 35);
        MainContainerPage_1.getSetMidiChannel().setBounds(10 + 119 + 5, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10, 200, 35);
        MainContainerPage_1.getSetMidiProgramTitle().setBounds(10, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + 35, 119, 35);
        MainContainerPage_1.getSetMidiProgram().setBounds(10 + 119 + 5, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + 35, 200, 35);
        MainContainerPage_1.getSetMidiControlTitle().setBounds(10, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + (35 * 2), 119, 35);
        MainContainerPage_1.getSetMidiControl().setBounds(10 + 119 + 5, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + (35 * 2), 200, 35);

        MainContainerPage_1.getBack().getButtonSource().setBounds(10, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + (35 * 3) + 2, 119, 35);
        MainContainerPage_1.getDoneMidiInformationSetting().getButtonSource().setBounds(10 + 119 + 5, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + (35 * 3) + 2, 100, 35);
        MainContainerPage_1.getUpdateJMCISourceOptionButton().setBounds(10 + 119 + 5 + 100, (MainContainerPage_1.getPianoKeyBox().getY() + MainContainerPage_1.getPianoKeyBox().getHeight()) + 10 + (35 * 4) + 2 - 35, 100, 35);

        MainContainerPage_1.getShowTimeBar().setBounds(10 + 119 + 10 + 200 + 10, MainContainerPage_1.getMainContainerPanel().getHeight() - 65, MainContainerPage_1.getMainContainerPanel().getWidth() - (10 + 119 + 10 + 200 + 10), 35);

        MainContainerPage_1.getSelectLocalJMCIFileButton().getButtonSource().setBounds(
                10 + 119 + 10 + 200 + 10, MainContainerPage_1.getSetMidiChannel().getY(),
                200, 35
        );

        int btnWidth = (((MainContainerPage_1.getMainContainerPanel().getWidth() - (10 + 119 + 10 + 200 + 10 + 200 + 5)) - 10) - 10) / 3;
        MainContainerPage_1.getStartPlaySongButton().setBounds(
                10 + 119 + 10 + 200 + 10 + 200 + 5,
                MainContainerPage_1.getSetMidiChannel().getY(), btnWidth, 35
        );
        MainContainerPage_1.getPausePlaySongButton().setBounds(
                10 + 119 + 10 + 200 + 10 + 200 + 5 + (btnWidth - 5) + 5,
                MainContainerPage_1.getSetMidiChannel().getY(), btnWidth, 35
        );
        MainContainerPage_1.getStopSongButton().setBounds(
                10 + 119 + 10 + 200 + 10 + 200 + 5 + ((btnWidth - 5) * 2) + (5 * 2),
                MainContainerPage_1.getSetMidiChannel().getY(), btnWidth, 35
        );

        MainContainerPage_1.getSongProgressSlider().setBounds(
                10 + 119 + 10 + 200 + 10,
                MainContainerPage_1.getSetMidiProgram().getY(),
                (MainContainerPage_1.getMainContainerPanel().getWidth() - (10 + 119 + 10 + 200 + 10)) - 10,
                35
        );

        MainContainerPage_1.getShowMidiPlaySourceFile().setBounds(10 + 119 + 10 + 200 + 10,
                MainContainerPage_1.getSetMidiProgram().getY() + (35 * 2) - 14,
                (MainContainerPage_1.getMainContainerPanel().getWidth() - (10 + 119 + 10 + 200 + 10)) - 10,
                35);
    }

    private static void initBlackPianoKeyIndex()
    {
        int primaryKeyIndex = 0;
        int blackIndex = 0;
        for (int b = 0; b < 10; b++)
        {
            for (int i = 0; i <= 1; i++, primaryKeyIndex++)
            {
                DrawPianoKeys.getBlackPianoKeysPointIndexArray()[blackIndex] = execute(DrawPianoKeys.getWhitePianoKeysPointIndexArray()[primaryKeyIndex]);
                blackIndex++;
            }
            primaryKeyIndex++;
            for (int i = 0; i <= 2; i++, primaryKeyIndex++)
            {
                DrawPianoKeys.getBlackPianoKeysPointIndexArray()[blackIndex] = execute(DrawPianoKeys.getWhitePianoKeysPointIndexArray()[primaryKeyIndex]);
                blackIndex++;
            }
            primaryKeyIndex++;
        }
        for (int i = 0; i <= 1; i++, primaryKeyIndex++)
        {
            DrawPianoKeys.getBlackPianoKeysPointIndexArray()[blackIndex] = execute(DrawPianoKeys.getWhitePianoKeysPointIndexArray()[primaryKeyIndex]);
            blackIndex++;
        }
        primaryKeyIndex++;
        DrawPianoKeys.getBlackPianoKeysPointIndexArray()[blackIndex] = execute(DrawPianoKeys.getWhitePianoKeysPointIndexArray()[primaryKeyIndex]);
    }

    private static int execute(int index)
    {
        int blackIndex = 0;

        blackIndex = ((index + DrawPianoKeys.getBlackPianoKeyWidth()) + ((DrawPianoKeys.getBlackPianoKeyWidth() / 2) - (DrawPianoKeys.getBlackPianoKeyWidth() / 4))) - DrawPianoKeys.getBlackPianoKeyWidth() / 2;

        return blackIndex;
    }
}
