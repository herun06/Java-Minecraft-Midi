package main.java.com.xfherun.jmci.user_interface.update;

import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_2;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_3;

public class UpdatePage_3_Index
{
    private UpdatePage_3_Index()
    {
    }

    public static void start()
    {
        MainContainerPage_3.getMainContainerPanel().setBounds(0, 0, MainWindow.getMainWindow().getWidth() - 16, MainWindow.getMainWindow().getHeight() - (39 + 35));
        MainContainerPage_3.getMainContainerPanelLeft().setBounds(0, 0, 250, MainContainerPage_3.getMainContainerPanel().getHeight());
        MainContainerPage_3.getMainContainerPanelRight().setBounds(250, 0, MainContainerPage_3.getMainContainerPanel().getWidth() - 250, MainContainerPage_3.getMainContainerPanel().getHeight());
        MainContainerPage_3.getMainContainerPanelLeftTop().setBounds(0, 0, 250, 35);
        MainContainerPage_3.getMainContainerPanelLeftTCenter().setBounds(0, 35, 250, MainContainerPage_3.getMainContainerPanelLeft().getHeight() - (35 * 2));
        MainContainerPage_3.getMainContainerPanelLeftTFooter().setBounds(0, MainContainerPage_3.getMainContainerPanelLeft().getHeight() - 35, 250, 35);
        MainContainerPage_3.getMainContainerPanelRightTop().setBounds(0, 0, MainContainerPage_3.getMainContainerPanelRight().getWidth(),  MainContainerPage_3.getMainContainerPanelRight().getHeight() - 119);
        MainContainerPage_3.getMainContainerPanelRightFooter().setBounds(0,  MainContainerPage_3.getMainContainerPanelRight().getHeight() - 119, MainContainerPage_3.getMainContainerPanelRight().getWidth(), 119);
        MainContainerPage_3.getMainContainerPanelRightTopTextAreaScrollPane().setBounds(0, 0, MainContainerPage_3.getMainContainerPanelRightTop().getWidth(), MainContainerPage_3.getMainContainerPanelRightTop().getHeight());
        MainContainerPage_3.getMainContainerPanelRightFooterTextAreaScrollPane().setBounds(0, 0, MainContainerPage_3.getMainContainerPanelRightFooter().getWidth(), MainContainerPage_3.getMainContainerPanelRightFooter().getHeight());
    }
}
