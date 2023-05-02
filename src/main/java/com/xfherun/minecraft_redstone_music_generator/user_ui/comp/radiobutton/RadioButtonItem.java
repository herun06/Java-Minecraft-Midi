/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.radiobutton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RadioButtonItem implements MouseListener
{
    private JPanel radioButton;
    private JLabel radioButtonItem;
    private JLabel radioButtonText;
    private boolean isChecked;
    private int id;
    private RadioButtonChecked radioButtonChecked;

    public RadioButtonItem(String text, int[] bounds)
    {
        id = -1;
        radioButtonChecked = null;
        radioButton = new JPanel();
        radioButton.setBounds(bounds[0], bounds[1], bounds[3], bounds[3]);
        radioButton.setOpaque(true);
        radioButton.setBackground(new Color(45, 45, 45, 255));
        radioButton.setForeground(Color.decode("#eeeeee"));
        radioButton.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
        radioButton.setLayout(null);
        radioButton.addMouseListener(this);

        int margin = 6;
        radioButtonItem = new JLabel();
        radioButtonItem.setBounds(margin, margin, bounds[3] - (margin * 2), bounds[3] - (margin * 2));
        radioButtonItem.setOpaque(true);
        radioButtonItem.setBackground(new Color(0, 0, 0, 0));
        radioButtonItem.setBorder(null);
        radioButton.add(radioButtonItem);

        radioButtonText = new JLabel(text);
        radioButtonText.setBounds(bounds[0] + bounds[3] + 5, bounds[1], bounds[2] - bounds[3], bounds[3]);
        radioButtonText.setOpaque(true);
        radioButtonText.setBackground(new Color(45, 45, 45, 255));
        radioButtonText.setForeground(Color.decode("#eeeeee"));
        radioButtonText.addMouseListener(this);
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setChecked(boolean b)
    {
        if (!b)
        {
            radioButtonItem.setBackground(new Color(45, 45, 45, 255));
            isChecked = false;
        }
        else
        {
            radioButtonItem.setBackground(new Color(255, 255, 255, 255));
            isChecked = true;
        }
    }

    public Object[] getSource()
    {
        return new Object[]{radioButton, radioButtonText};
    }

    public void addRadioButtonChecked(RadioButtonChecked radioButtonChecked)
    {
        this.radioButtonChecked = radioButtonChecked;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getSource() == radioButton || e.getSource() == radioButtonText)
        {

        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (e.getSource() == radioButton || e.getSource() == radioButtonText)
        {
            if (radioButtonChecked != null) if (e.getClickCount() == 1) radioButtonChecked.accept();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (e.getSource() == radioButton || e.getSource() == radioButtonText)
        {

        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (e.getSource() == radioButton || e.getSource() == radioButtonText)
        {
            radioButton.setBorder(new LineBorder(new Color(185, 185, 185, 255)));
            radioButtonText.setForeground(new Color(255, 255, 255, 255));
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (e.getSource() == radioButton || e.getSource() == radioButtonText)
        {
            radioButton.setBorder(new LineBorder(new Color(107, 107, 107, 255)));
            radioButtonText.setForeground(Color.decode("#eeeeee"));
        }
    }
}
