package main.java.com.xfherun.jmci.swing_util.button;

import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class XFButton implements MouseListener, KeyListener
{
    private JLabel button;
    private String text = "";
    private ButtonClick buttonClick = null;
    private main.java.com.xfherun.jmci.swing_util.button.i.KeyEvent keyEvent2 = null;

    public XFButton(String text)
    {
        this.text = text;
        createButton();
    }

    public void setEnabled(boolean b)
    {
        button.setBackground(new Color(38, 103, 36, 255));
        button.setForeground(new Color(255, 255, 255, 255));
        button.setBorder(new LineBorder(new Color(17, 73, 0, 255), 2));
        button.setEnabled(b);

    }

    public XFButton()
    {
        createButton();
    }

    public XFButton(String text, Font font)
    {
        this.text = text;
        createButton();
        button.setFont(font);
    }

    public XFButton(String text, ButtonClick buttonClick)
    {
        createButton();
        addMouseClicked(buttonClick);
    }

    public XFButton(String text, main.java.com.xfherun.jmci.swing_util.button.i.KeyEvent keyEvent)
    {
        createButton();
        addKeyEvent(keyEvent);
    }

    public int getWidth()
    {
        return button.getWidth();
    }

    public int getY()
    {
        return button.getY();
    }

    public int getX()
    {
        return button.getX();
    }

    public int getHeight()
    {
        return button.getHeight();
    }

    public Point getLocation()
    {
        return new Point(getX(), getY());
    }

    public Dimension getSize()
    {
        return new Dimension(getWidth(), getHeight());
    }

    private void createButton()
    {
        button = new JLabel(text);
        button.setOpaque(true);
        button.setBackground(new Color(38, 103, 36, 255));
        button.setForeground(new Color(255, 255, 255, 255));
        button.setFont(new Font("新宋体", 0, 15));
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setBorder(new LineBorder(new Color(17, 73, 0, 255), 2));
        button.addMouseListener(this);
        button.addKeyListener(this);
    }

    public void setSize(int[] size)
    {
        button.setSize(size[0], size[1]);
    }

    public void setBounds(int x, int y, int width, int height)
    {
        setLocation(new int[] {x, y});
        setSize(new int[] {width, height});
    }

    public void setText(String text)
    {
        this.text = text;
        button.setText(this.text);
    }

    public void setFont(Font font)
    {
        button.setFont(font);
    }

    public Font getFont()
    {
        return button.getFont();
    }

    public String getText()
    {
        return button.getText();
    }

    public JLabel getButtonSource()
    {
        return button;
    }

    public void setLocation(int[] location)
    {
        button.setLocation(location[0], location[1]);
    }

    public void addWindow(Container component)
    {
        component.add(button);
    }

    public void addMouseClicked(ButtonClick buttonClick)
    {
        this.buttonClick = buttonClick;
    }

    public void addKeyEvent(main.java.com.xfherun.jmci.swing_util.button.i.KeyEvent keyEvent)
    {
        this.keyEvent2 = keyEvent;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (button.isEnabled())
        {
            if (e.getButton() == 1) if (buttonClick != null) buttonClick.clicked(e);
            if (e.getButton() == 3) if (buttonClick != null)
            {
                if (e.getClickCount() != 2) buttonClick.mouseRightClicked(e);
                else if (e.getButton() == 3) buttonClick.mouseRightDouble(e);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if (button.isEnabled())
        {
            if (e.getButton() == 1) if (buttonClick != null)
            {
                if (e.getClickCount() != 2) buttonClick.mouseDown(e);
                else if (e.getButton() == 1) buttonClick.mouseDouble(e);
            }
            if (e.getButton() == 3)
            {
                if (buttonClick != null) buttonClick.mouseRightDown(e);
                if (e.getClickCount() != 2)  if (buttonClick != null) buttonClick.mouseRightDown(e);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if (button.isEnabled())
        {
            if (buttonClick != null) buttonClick.mouseUp(e);
            if (e.getButton() == 3) if (buttonClick != null) buttonClick.mouseRightUp(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        if (button.isEnabled())
        {
            if (buttonClick != null) buttonClick.mouseOver(e);
            button.setBackground(new Color(77, 136, 17, 255));
            button.setForeground(new Color(255, 255, 255, 255));
            button.setBorder(new LineBorder(new Color(23, 101, 1, 255), 2));
        }
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        if (button.isEnabled())
        {
            if (buttonClick != null) buttonClick.mouseOut(e);
            button.setBackground(new Color(38, 103, 36, 255));
            button.setForeground(new Color(255, 255, 255, 255));
            button.setBorder(new LineBorder(new Color(17, 73, 0, 255), 2));
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        if (button.isEnabled())
        {
            if (keyEvent2 != null) keyEvent2.inputData(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (button.isEnabled())
        {
            if (keyEvent2 != null) keyEvent2.keyDown(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (button.isEnabled())
        {
            if (keyEvent2 != null) keyEvent2.keyUp(e);
        }
    }
}
