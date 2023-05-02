/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PushButton implements MouseListener
{
    private JLabel pushButton;
    private Color btnColor = new Color(58, 58, 58, 255);
    private Color btnBorderHover = new Color(255, 255, 255, 255);
    private Color btnBorder = new Color(90, 90, 90, 255);
    private ClickedConnect clickedConnect;
    private boolean isEnable;

    public PushButton(String text)
    {
        clickedConnect = null;
        isEnable = false;
        pushButton = new JLabel();
        pushButton.setText(text);
        pushButton.setOpaque(true);
        pushButton.addMouseListener(this);
        pushButton.setBorder(new LineBorder(btnBorder));
        pushButton.setBackground(btnColor);
        pushButton.setForeground(Color.decode("#eeeeee"));
    }

    public void addClickedConnect(ClickedConnect clickedConnect)
    {
        this.clickedConnect = clickedConnect;
    }

    public void setEnabled(boolean b)
    {
        if (!b)
        {
            pushButton.setBorder(new LineBorder(btnBorder));
            pushButton.setBackground(new Color(47, 47, 47, 255));
            pushButton.setForeground(new Color(140, 140, 140, 255));
            isEnable = true;
        }
        else
        {
            pushButton.setBorder(new LineBorder(btnBorder));
            pushButton.setBackground(btnColor);
            pushButton.setForeground(Color.decode("#eeeeee"));
            isEnable = false;
        }
    }

    public JLabel getPushButton()
    {
        return pushButton;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (!isEnable) if (clickedConnect != null) clickedConnect.accept(e, "mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (!isEnable) if (clickedConnect != null) clickedConnect.accept(e, "mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (!isEnable) if (clickedConnect != null) clickedConnect.accept(e, "mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (!isEnable) pushButton.setBorder(new LineBorder(btnBorderHover));
        if (!isEnable) pushButton.setBackground(btnColor);
        if (!isEnable) pushButton.setForeground(Color.decode("#eeeeee"));
        if (!isEnable) if (clickedConnect != null) clickedConnect.accept(e, "mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (!isEnable) pushButton.setBorder(new LineBorder(btnBorder));
        if (!isEnable) pushButton.setBackground(btnColor);
        if (!isEnable) pushButton.setForeground(Color.decode("#eeeeee"));
        if (!isEnable) if (clickedConnect != null) clickedConnect.accept(e, "mouseExited");
    }
}
