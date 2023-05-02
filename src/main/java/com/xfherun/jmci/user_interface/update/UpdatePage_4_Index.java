package main.java.com.xfherun.jmci.user_interface.update;

import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_3;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_4;

public class UpdatePage_4_Index
{
    private UpdatePage_4_Index()
    {
    }

    public static void start()
    {
        MainContainerPage_4.getMainContainerPanel().setBounds(0, 0, MainWindow.getMainWindow().getWidth() - 16, MainWindow.getMainWindow().getHeight() - (39 + 35));
        MainContainerPage_4.getAboutButton().setBounds(MainContainerPage_4.getMainContainerPanel().getWidth() - (200 + 10), MainContainerPage_4.getMainContainerPanel().getHeight() - (35 + 10), 200, 35);
    }
}
