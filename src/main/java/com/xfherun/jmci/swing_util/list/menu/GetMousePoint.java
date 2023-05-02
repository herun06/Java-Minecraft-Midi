package main.java.com.xfherun.jmci.swing_util.list.menu;

import java.awt.*;

public class GetMousePoint
{
    private static int[] point = new int[2];

    private GetMousePoint()
    {
    }

    public static void update()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                while (true)
                {
                    PointerInfo mouseInfo = MouseInfo.getPointerInfo();
                    int x = mouseInfo.getLocation().x;
                    int y = mouseInfo.getLocation().y;
                    point[0] = x;
                    point[1] = y;
                }
            }
        }.start();
    }

    public static int[] getPoint()
    {
        return point;
    }
}
