package main.java.com.xfherun.jmci.user_interface.function;

import main.java.com.xfherun.jmci.user_interface.section.MainContainerPageHome;

import javax.swing.*;
import java.awt.*;

public class HomeTitleImageRunSize extends Thread
{
    @Override
    public void run()
    {
        while (true)
        {
            if (MainContainerPageHome.getMainContainerPanel() != null)
            {
                if (MainContainerPageHome.getTitleImageRun() != null)
                {
                    JLabel titleImageRun = MainContainerPageHome.getTitleImageRun();
                    for (int i = 0; i < 10; i++)
                    {
                        if (i == 0) titleImageRun.setSize(300, 200);
                        else if (i == 1) titleImageRun.setSize(320, 220);
                        else if (i == 2) titleImageRun.setSize(330, 230);
                        else if (i == 3) titleImageRun.setSize(340, 230);
                        else if (i == 4) titleImageRun.setSize(350, 250);
                        else if (i == 5) titleImageRun.setSize(350, 250);
                        else if (i == 6) titleImageRun.setSize(340, 240);
                        else if (i == 7) titleImageRun.setSize(330, 200);
                        else if (i == 8) titleImageRun.setSize(320, 220);
                        else titleImageRun.setSize(300, 200);
                        try
                        {
                            Thread.sleep(119);
                        }
                        catch (InterruptedException e)
                        {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
