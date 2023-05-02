package main.java.com.xfherun.jmci.swing_util.window_utils;

import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Window
{
    private Window()
    {
    }

    public static void addWindowMouseEvent(Container container, ButtonClick buttonClick) {
        container.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getButton() == 1) buttonClick.clicked(e);
                if (e.getButton() == 3) buttonClick.mouseRightClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e)
            {
                if (e.getButton() == 1)
                {
                    buttonClick.mouseDown(e);
                    if (e.getClickCount() != 2) buttonClick.mouseDown(e);
                }
                if (e.getButton() == 3)
                {
                    buttonClick.mouseRightDown(e);
                    if (e.getClickCount() != 2) buttonClick.mouseDown(e);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                if (e.getButton() == 1) buttonClick.mouseUp(e);
                if (e.getButton() == 3) buttonClick.mouseRightUp(e);
            }

            @Override
            public void mouseEntered(MouseEvent e)
            {
                buttonClick.mouseOver(e);
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                buttonClick.mouseOut(e);
            }
        });
    }
}
