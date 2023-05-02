package main.java.com.xfherun.jmci.swing_util.list.normal;

import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.normal.style.BasicScrollBarUIStyle;
import main.java.com.xfherun.jmci.swing_util.window_utils.UpdateWindow;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class XFList implements MouseListener, KeyListener
{
    private ArrayList<Integer> xfListIndex = new ArrayList<>();
    private ArrayList<String> xfListText = new ArrayList<>();
    private ArrayList<JTextField> xfListItem = new ArrayList<>();
    private JPanel panel = new JPanel();
    private JScrollPane jScrollPane = new JScrollPane();
    private Box box = Box.createVerticalBox();
    private int[] bounds;
    private int currentSelectIndex = 0;
    private ButtonClick buttonClick = null;
    private int height_ = 32;

    public XFList()
    {
        create();
    }

    private void create()
    {
        BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(boxLayout);
        panel.setOpaque(true);
        panel.setBackground(new Color(113, 145, 3, 255));
    }

    public int getCurrentSelectIndex()
    {
        return currentSelectIndex;
    }

    public String getCurrentSelectText()
    {
        return xfListText.get(getCurrentSelectIndex());
    }

    private void setThrow(int index)
    {
        if (index < 0 || index > (xfListText.size() - 1))
            throw new IndexOutOfBoundsException("Index " + index + " out of range 0 ~ " + (xfListText.size() - 1));
    }

    public String getText(int index)
    {
        setThrow(index);
        return xfListText.get(index);
    }

    public void add(String itemText)
    {
        xfListText.add(itemText);
        JTextField list = new JTextField(" " + itemText);
        list.setOpaque(true);
        list.setEditable(false);
        list.setSelectionColor(new Color(5, 79, 1, 255));
        list.setSelectedTextColor(Color.decode("#eeeeee"));
        list.setPreferredSize(new Dimension(bounds[2] - 25, height_));
        list.setMaximumSize(new Dimension(bounds[2] - 25, height_));
        list.setMinimumSize(new Dimension(bounds[2] - 25, height_));
        list.setBorder(new LineBorder(new Color(30, 126, 0, 255), 2));
        list.setBackground(new Color(113, 145, 3, 255));
        list.setForeground(new Color(208, 208, 208, 255));
        list.addMouseListener(this);
        xfListItem.add(list);
        xfListIndex = new ArrayList<>();
        updateIndex();
        update();
    }

    public void insert(int index, String itemText)
    {
        xfListText.add(index, itemText);
        JTextField list = new JTextField(" " + itemText);
        list.setOpaque(true);
        list.setEditable(false);
        list.setSelectionColor(new Color(5, 79, 1, 255));
        list.setSelectedTextColor(Color.decode("#eeeeee"));
        list.setPreferredSize(new Dimension(bounds[2] - 25, height_));
        list.setMaximumSize(new Dimension(bounds[2] - 25, height_));
        list.setMinimumSize(new Dimension(bounds[2] - 25, height_));
        list.setBorder(new LineBorder(new Color(30, 126, 0, 255), 2));
        list.setBackground(new Color(113, 145, 3, 255));
        list.setForeground(new Color(208, 208, 208, 255));
        list.addMouseListener(this);
        xfListItem.add(index, list);
        xfListIndex = new ArrayList<>();
        updateIndex();
        update();
    }

    private void updateIndex()
    {
        int index = 0;
        for (String s : xfListText)
        {
            xfListIndex.add(index);
            index++;
        }
    }

    public void set(int index, String text)
    {
        setThrow(index);
        xfListText.set(index, text);
        xfListItem.get(index).setText(text);
        update();
    }

    public void remove(int index)
    {
        setThrow(index);
        xfListText.remove(index);
        xfListItem.remove(index);
        updateIndex();
        update();
    }

    public void removeAll()
    {
        xfListText.clear();
        xfListItem.clear();
        xfListIndex.clear();
        update();
    }

    public void setHeight(int height)
    {
        height_ = height;
        updateLocationAndSize();
        update();
    }

    public int getHeight()
    {
        return height_;
    }

    public Object[] removeToWindow(Container container)
    {
        Object[] o = new Object[2];
        o[0] = getSource();
        o[1] = getPanel();
        container.remove(getSource());
        container.repaint();
        return o;
    }

    public void setTextLeftMargin(int width)
    {
        if (width < 0) throw new IndexOutOfBoundsException("Index " + width + " out of range < 0");
        if (width != 0)
        {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < width; i++) space.append(" ");
            String sp = space.toString();
            for (JTextField jTextField : xfListItem) jTextField.setText(sp + jTextField.getText());
            update();
        }
        else
        {
            for (int i = 0; i < xfListItem.size(); i++) xfListItem.get(i).setText(xfListText.get(i));
            update();
        }
    }

    public void setTextRightMargin(int width)
    {
        if (width < 0) throw new IndexOutOfBoundsException("Index " + width + " out of range < 0");
        if (width != 0)
        {
            StringBuilder space = new StringBuilder();
            for (int i = 0; i < width; i++) space.append(" ");
            String sp = space.toString();
            for (JTextField jTextField : xfListItem) jTextField.setText(jTextField.getText() + sp);
            update();
        }
        else
        {
            for (int i = 0; i < xfListItem.size(); i++) xfListItem.get(i).setText(xfListText.get(i));
            update();
        }
    }

    public void setTextLeftMargin(String type)
    {
        if (!type.equalsIgnoreCase("align: left") &&
                !type.equalsIgnoreCase("align: center") &&
                !type.equalsIgnoreCase("align: right"))
            throw new RuntimeException("没有名为: " + type + " 的类型。");
        if (type.equalsIgnoreCase("align: left"))
        {
            for (int i = 0; i < xfListItem.size(); i++) xfListItem.get(i).setText(xfListText.get(i));
            update();
        }
        else if (type.equalsIgnoreCase("align: center"))
        {
            for (int i = 0; i < xfListItem.size(); i++)
            {
                xfListItem.get(i).setText(xfListText.get(i));
                xfListItem.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            }
            update();
        }
        else if (type.equalsIgnoreCase("align: right"))
        {
            for (int i = 0; i < xfListItem.size(); i++)
            {
                xfListItem.get(i).setText(xfListText.get(i));
                xfListItem.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
            }
            update();
        }
    }

    public void setTextFont(Font font)
    {
        for (JTextField jTextField : xfListItem) jTextField.setFont(font);
        update();
    }

    public void updateLocationAndSize()
    {
        for (JTextField jTextField : xfListItem)
        {
            jTextField.setPreferredSize(new Dimension(bounds[2] - 25, height_));
            jTextField.setMaximumSize(new Dimension(bounds[2] - 25, height_));
            jTextField.setMinimumSize(new Dimension(bounds[2] - 25, height_));
        }
    }

    public int getItemCount()
    {
        return xfListText.size();
    }

    public JScrollPane getSource()
    {
        return jScrollPane;
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public void setBounds(int[] arr)
    {
        bounds = arr;
        jScrollPane.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
    }

    public void setCurrentSelectIndex(int index)
    {
        setThrow(index);
        currentSelectIndex = index;
        for (JTextField jTextField : xfListItem)
        {
            jTextField.setBackground(new Color(113, 145, 3, 255));
            jTextField.setForeground(new Color(208, 208, 208, 255));
        }
        JTextField jTextField = xfListItem.get(currentSelectIndex);
        jTextField.setBackground(new Color(5, 79, 1, 255));
        jTextField.setForeground(Color.decode("#eeeeee"));
        jTextField.repaint();
    }

    public void addWindow(Container window)
    {
        for (JTextField jTextField : xfListItem) box.add(jTextField);
        panel.add(box);
        jScrollPane.setViewportView(panel);
        jScrollPane.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
        jScrollPane.setBorder(new LineBorder(new Color(30, 126, 0, 255), 2));
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUIStyle());

        if (xfListItem.size() > 0)
        {
            JTextField jTextField = xfListItem.get(currentSelectIndex);
            jTextField.setBackground(new Color(5, 79, 1, 255));
            jTextField.setForeground(Color.decode("#eeeeee"));
            jTextField.repaint();
        }

        window.add(jScrollPane);
        setVSB();
    }

    public void setVSB()
    {
        for (int i = 0; i < getItemCount(); i++)
            jScrollPane.getVerticalScrollBar().setValue(jScrollPane.getVerticalScrollBar().getMaximum());
    }

    public void update()
    {
        box.removeAll();
        for (int i = 0; i < xfListItem.size(); i++)
        {
            box.add(xfListItem.get(i));
            box.repaint();
        }
    }

    public void addButtonClicked(ButtonClick buttonClick)
    {
        this.buttonClick = buttonClick;
    }


    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        for (JTextField jTextField : xfListItem)
            if (e.getSource() == jTextField) if (buttonClick != null)
            {
                if (e.getButton() == 1) buttonClick.clicked(e);
                else if (e.getButton() == 3) buttonClick.mouseRightClicked(e);
            }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        int i = 0;
        for (JTextField jTextField : xfListItem)
        {
            if (e.getSource() == jTextField)
            {
                currentSelectIndex = i;
                jTextField.repaint();
                break;
            }
            i++;
        }

        for (JTextField jTextField : xfListItem)
        {
            jTextField.setBackground(new Color(113, 145, 3, 255));
            jTextField.setForeground(new Color(208, 208, 208, 255));
        }
        JTextField jTextField = xfListItem.get(currentSelectIndex);
        jTextField.setBackground(new Color(5, 79, 1, 255));
        jTextField.setForeground(Color.decode("#eeeeee"));
        jTextField.repaint();
        for (JTextField jTextField2 : xfListItem)
            if (e.getSource() == jTextField2) if (buttonClick != null)
            {
                if (e.getClickCount() == 2) buttonClick.mouseDouble(e);
                else buttonClick.mouseDown(e);
            }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        for (JTextField jTextField : xfListItem)
            if (e.getSource() == jTextField) if (buttonClick != null) buttonClick.mouseUp(e);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        for (JTextField jTextField : xfListItem)
        {
            if (e.getSource() == jTextField)
                jTextField.setBorder(new LineBorder(new Color(171, 171, 171, 255), 2));
            jTextField.repaint();
        }
        for (JTextField jTextField : xfListItem)
            if (e.getSource() == jTextField) if (buttonClick != null) buttonClick.mouseOver(e);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        int i = 0;
        for (JTextField jTextField : xfListItem)
        {
            if (e.getSource() == jTextField)
                jTextField.setBorder(new LineBorder(new Color(30, 126, 0, 255), 2));
            if (i != currentSelectIndex)
            {
                jTextField.setBackground(new Color(113, 145, 3, 255));
                jTextField.setForeground(new Color(208, 208, 208, 255));
            }
            jTextField.repaint();
            i++;
        }
        for (JTextField jTextField : xfListItem)
            if (e.getSource() == jTextField) if (buttonClick != null) buttonClick.mouseOut(e);
    }
}
