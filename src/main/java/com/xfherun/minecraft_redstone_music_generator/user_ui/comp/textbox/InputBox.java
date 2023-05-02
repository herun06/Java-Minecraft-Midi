/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.textbox;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputBox implements MouseListener
{

    private JTextField field;
    private boolean isFouce;
    public InputBox()
    {
        create();
    }

    private void create()
    {
        isFouce = false;
        field = new JTextField();
        field.setOpaque(true);
        field.setBackground(new Color(0, 0, 0, 0));
        field.setForeground(Color.decode("#eeeeee"));
        field.setCaretColor(Color.decode("#eeeeee"));
        field.setSelectionColor(Color.WHITE);
        field.setSelectedTextColor(Color.BLACK);
        field.setBorder(new LineBorder(new Color(172, 173, 173, 255)));
        field.setFont(new Font("新宋体", 0, 15));
        field.addMouseListener(this);
        field.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                isFouce = true;
                field.setBorder(new LineBorder(Color.WHITE, 2));
            }

            @Override
            public void focusLost(FocusEvent e)
            {
                isFouce = false;
                field.setBorder(new LineBorder(new Color(173, 173, 173, 255)));
            }
        });
    }

    public JTextField getSource()
    {
        return field;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (e.getSource() == field)
        {
            if (!isFouce) field.setBorder(new LineBorder(Color.WHITE));
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (e.getSource() == field)
        {
            if (!isFouce) field.setBorder(new LineBorder(new Color(173, 173, 173, 255)));
        }
    }
}
