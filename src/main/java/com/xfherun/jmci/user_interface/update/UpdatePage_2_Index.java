package main.java.com.xfherun.jmci.user_interface.update;

import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_1;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_2;

public class UpdatePage_2_Index
{
    private UpdatePage_2_Index()
    {
    }

    public static void start()
    {
        MainContainerPage_2.getMainContainerPanel().setBounds(0, 0, MainWindow.getMainWindow().getWidth() - 16, MainWindow.getMainWindow().getHeight() - 39);
        MainContainerPage_2.getFpsListScrollPane().setBounds(0, 35 * 2, 200, MainContainerPage_2.getMainContainerPanel().getHeight() - (35 * 3));
        MainContainerPage_2.getContentListScrollPane().setBounds(200, 35 * 2, MainContainerPage_2.getMainContainerPanel().getWidth() - 200,
                MainContainerPage_2.getMainContainerPanel().getHeight() - (35 * 3));
    }
}
