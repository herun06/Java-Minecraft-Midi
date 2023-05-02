package main.java.com.xfherun.jmci.user_interface.function;

import main.java.com.xfherun.jmci.user_interface.section.MainContainerPageHome;

import javax.swing.*;
import java.awt.*;

public class HomeTitleImageRun extends Thread
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
                        ImageIcon imageIcon = new ImageIcon("cache/home_title_image_flush/title_" + i + ".png");
                        imageIcon.setImage(imageIcon.getImage().getScaledInstance(titleImageRun.getWidth(), titleImageRun.getHeight(), Image.SCALE_DEFAULT));
                        titleImageRun.setIcon(imageIcon);
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
