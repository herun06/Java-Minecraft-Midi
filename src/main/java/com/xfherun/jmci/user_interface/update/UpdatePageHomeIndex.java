package main.java.com.xfherun.jmci.user_interface.update;

import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPageHome;

import java.awt.*;

public class UpdatePageHomeIndex
{
    private UpdatePageHomeIndex()
    {
    }

    public static void start()
    {
        int windowWidth = MainWindow.getMainWindow().getWidth() - 16;
        int windowHeight = MainWindow.getMainWindow().getHeight() - 39;
        MainWindow.getMainContainer().setBounds(0, 35, windowWidth, windowHeight - 35);
        MainContainerPageHome.getMainContainerPanel().setBounds(0, 0, windowWidth, windowHeight);

        MainWindow.getStateBarBackground().setBounds(0, 0, windowWidth, 35);
        MainWindow.getExceptionSwitch().getScore().setBounds(windowWidth - 65, 2, 64, 32);

        int count = 5;
        // int width = (MainContainerPageHome.getMainContainerPanel().getWidth() / 4) * 2;
        int margin = 5;
        int width = 500;
        // int height = MainContainerPageHome.getMainContainerPanel().getHeight() / (count + 5);
        int height = 40;
        int x = (MainContainerPageHome.getMainContainerPanel().getWidth() - width) / 2;
        int y = ((MainContainerPageHome.getMainContainerPanel().getHeight() - ((height + margin) * count)) / 2) + ((count + 5) * 4);
        int vy = ((MainContainerPageHome.getMainContainerPanel().getHeight() - ((height + margin) * count)) / 2) + ((count + 5) * 4);

        MainContainerPageHome.getPlaySongPianoKeyButton().setLocation(new int[] {x, y});
        y += (height + margin);
        MainContainerPageHome.getEditJavaMinecraftMidiButton().setLocation(new int[] {x, y});
        y += (height + margin);
        MainContainerPageHome.getMinecraftRedStoneMusicButton().setLocation(new int[] {x, y});
        y += (height + margin);
        MainContainerPageHome.getSystemSettingsButton().setLocation(new int[] {x, y});
        y += (height + margin);
        MainContainerPageHome.getExitApplicationButton().setLocation(new int[] {x, y});

        MainContainerPageHome.getTitleImage().setBounds(0, 0, MainContainerPageHome.getMainContainerPanel().getWidth(), vy);
        MainContainerPageHome.getTitleImage().setFont(new Font("微软雅黑", 1,
                MainContainerPageHome.getTitleImageFontSize()
        ));

        MainContainerPageHome.getTitleImageRun().setBounds(
                (MainContainerPageHome.getPlaySongPianoKeyButton().getButtonSource().getX() +
                        MainContainerPageHome.getPlaySongPianoKeyButton().getButtonSource().getWidth())
                        - 119, (MainContainerPageHome.getPlaySongPianoKeyButton().getButtonSource().getY()) - 150, 300, 200
        );
    }
}
