/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.swing_util.switch_button;

import main.java.com.xfherun.jmci.swing_util.switch_button.action.SwitchListener;
import main.java.com.xfherun.jmci.utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class XFSwitchButton implements MouseListener
{
    private boolean state;
    private String text;
    private JLabel switchButton;
    private static boolean toolTextIsEnd = false;
    private int[] bounds;
    private SwitchListener actionListener;

    public XFSwitchButton(String text)
    {
        bounds = new int[]{0, 0, 0, 0};
        state = false;
        actionListener = null;
        this.text = text;
        switchButton = new JLabel("", JLabel.CENTER);
        switchButton.setToolTipText(this.text + ": OFF");
        switchButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        switchButton.setOpaque(true);
        switchButton.addMouseListener(this);
    }

    public void addActionListener(SwitchListener actionListener)
    {
        this.actionListener = actionListener;
    }

    private void setIcon(boolean isOn, boolean isHover)
    {
        if (bounds[2] == 0 || bounds[3] == 0)
            throw new RuntimeException("请给它一个合适的大小。");
        ImageIcon imageIcon = null;

        if (isOn && !isHover)
            imageIcon = new ImageIcon(
                    Resources.getResources(XFSwitchButton.class, "" +
                            "main/resources/images/comp/switch_button/on.png")
            );
        else if (!isOn && !isHover)
            imageIcon = new ImageIcon(
                    Resources.getResources(XFSwitchButton.class, "" +
                            "main/resources/images/comp/switch_button/off.png")
            );
        else if (isOn && isHover)
            imageIcon = new ImageIcon(
                    Resources.getResources(XFSwitchButton.class, "" +
                            "main/resources/images/comp/switch_button/on_hover.png")
            );
        else if (!isOn && isHover) imageIcon = new ImageIcon(
                Resources.getResources(XFSwitchButton.class, "" +
                        "main/resources/images/comp/switch_button/off_hover.png")
        );

        imageIcon.getImage().getScaledInstance(switchButton.getWidth(), switchButton.getHeight(), Image.SCALE_DEFAULT);
        switchButton.setIcon(imageIcon);
    }

    public void setBounds(int x, int y, int width, int height)
    {
        bounds = new int[4];
        bounds[0] = x;
        bounds[1] = y;
        bounds[2] = width;
        bounds[3] = height;
        switchButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
    }

    public void setSize(int[] size)
    {
        bounds[2] = size[0];
        bounds[3] = size[1];
        switchButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
    }

    public void setLocation(int[] location)
    {
        bounds[0] = location[0];
        bounds[1] = location[1];
        switchButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
    }

    public void setFont(Font font)
    {
        switchButton.setFont(font);
    }

    public boolean isIOn()
    {
        return state;
    }

    public void addToWindow(Container container)
    {
        setIcon(false, false);
        container.add(switchButton);
    }

    public JLabel getScore()
    {
        return switchButton;
    }

    public void setChecked(boolean b, boolean isHover)
    {
        if (b)
        {
            switchButton.setToolTipText(this.text + ": ON");
            setIcon(true, isHover);
            state = true;
        }
        else
        {
            switchButton.setToolTipText(this.text + ": OFF");
            setIcon(false, isHover);
            state = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (e.getButton() == 1)
        {
            if (!state)
            {
                switchButton.setToolTipText(this.text + ": ON");
                setIcon(true, true);
                state = true;
            }
            else
            {
                switchButton.setToolTipText(this.text + ": OFF");
                setIcon(false, true);
                state = false;
            }
            if (actionListener != null) actionListener.acc(state);
        }
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
        if (!state) setIcon(false, true);
        else setIcon(true, true);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (!state) setIcon(false, false);
        else setIcon(true, false);
    }
}
