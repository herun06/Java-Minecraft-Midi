package main.java.com.xfherun.jmci.user_interface.update;

import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_4;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_5;

public class UpdatePage_5_Index
{
    private UpdatePage_5_Index()
    {
    }

    public static void start()
    {
        MainContainerPage_5.getMainContainerPanel().setBounds(0, 0, MainWindow.getMainWindow().getWidth() - 16, MainWindow.getMainWindow().getHeight() - (39 + 35));
        MainContainerPage_5.getAboutList().setBounds(0, 35, MainContainerPage_5.getMainContainerPanel().getWidth(), MainContainerPage_5.getMainContainerPanel().getHeight());
    }
}
