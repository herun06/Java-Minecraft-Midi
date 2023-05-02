/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.list;

import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.ClickedConnect;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.comp.button.PushButton;

import javax.sql.XAConnection;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class List implements MouseListener
{
    private JPanel mainContainer;
    private Box mainContainerLayout_V;
    private ListAction listAction;
    private ArrayList<JPanel> mainArrayList;
    private ArrayList<JTextField[]> textAreaArray;
    private ArrayList<Object[]> mainFileArrayList;
    private int width;

    public List()
    {
        listAction = null;
        mainArrayList = new ArrayList<>();
        mainFileArrayList = new ArrayList<>();
        textAreaArray = new ArrayList<>();
        mainContainerLayout_V = Box.createVerticalBox();
        mainContainer = new JPanel();
        mainContainer.setOpaque(true);
        mainContainer.setBackground(new Color(0, 0, 0, 0));
        mainContainer.setBorder(null);
        addItems();
        mainContainer.add(mainContainerLayout_V);
    }

    public void add(URL image, Object[] data, String title, String subtitle, String createTime, String updateTime, ListAction listAction)
    {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        // panel.setPreferredSize(new Dimension(500, 75));
        panel.setMaximumSize(new Dimension(999999999, 75));
        panel.setMinimumSize(new Dimension(0, 75));
        panel.setBackground(new Color(45, 45, 45, 0));
        panel.setBorder(new LineBorder(new Color(148, 148, 148, 0)));
        panel.addMouseListener(new MouseListener()
        {
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
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 255)));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 0)));
            }
        });
        //Box box_H = Box.createHorizontalBox();
        //box_H.setOpaque(true);
        //box_H.setBackground(new Color(0, 0, 0, 0));
        JLabel imageLabel = new JLabel("", JLabel.CENTER);
        imageLabel.setSize(64, 64);
        imageLabel.setPreferredSize(new Dimension(64, 64));
        imageLabel.setMaximumSize(new Dimension(64, 64));
        imageLabel.setMinimumSize(new Dimension(64, 64));
        imageLabel.setOpaque(true);
        imageLabel.setBackground(new Color(0, 0, 0, 0));
        imageLabel.setForeground(new Color(0, 0, 0, 0));
        imageLabel.setBorder(null);
        if (image != null)
        {
            ImageIcon imageIcon = new ImageIcon(image);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(64, 64, Image.SCALE_DEFAULT));
            imageLabel.setIcon(imageIcon);
        }
        else imageLabel.setBackground(new Color(24, 49, 162, 255));
        //box_H.add(imageLabel);
        panel.add(imageLabel, BorderLayout.WEST);
        Box box_V = Box.createVerticalBox();
        Box box_V_2 = Box.createVerticalBox();

        JTextField field = new JTextField();
        field.setOpaque(true);
        field.setSize(41, 41);
        field.setMaximumSize(new Dimension(999999999, 41));
        field.setMinimumSize(new Dimension(0, 41));
        field.setBackground(new Color(0, 0, 0, 0));
        field.setFont(new Font("微软雅黑", 1, 20));
        field.setForeground(Color.decode("#eeeeee"));
        field.setBorder(null);
        field.setText("   " + title);
        field.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        field.setCaretColor(new Color(0, 0, 0, 0));
        field.setSelectionColor(new Color(0, 0, 0, 0));
        field.setEditable(false);
        field.setSelectedTextColor(Color.decode("#eeeeee"));
        field.addMouseListener(new MouseListener()
        {
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
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 255)));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 0)));
            }
        });
        box_V.add(field);

        JTextField field2 = new JTextField();
        field2.setOpaque(true);
        field2.setSize(41, 41);
        field2.setMaximumSize(new Dimension(999999999, 41));
        field2.setMinimumSize(new Dimension(0, 41));
        field2.setBackground(new Color(0, 0, 0, 0));
        field2.setForeground(Color.decode("#eeeeee"));
        field2.setBorder(null);
        field2.setText("   " + subtitle);
        field2.setFont(new Font("微软雅黑", 0, 15));
        field2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        field2.setCaretColor(new Color(0, 0, 0, 0));
        field2.setSelectionColor(new Color(0, 0, 0, 0));
        field2.setEditable(false);
        field2.setSelectedTextColor(Color.decode("#eeeeee"));
        field2.addMouseListener(new MouseListener()
        {
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
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 255)));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 0)));
            }
        });
        box_V.add(field2);

        JTextField field3 = new JTextField();
        field3.setOpaque(true);
        field3.setSize(41, 41);
        field3.setMaximumSize(new Dimension(999999999, 41));
        field3.setMinimumSize(new Dimension(0, 41));
        field3.setBackground(new Color(0, 0, 0, 0));
        field3.setForeground(Color.decode("#eeeeee"));
        field3.setBorder(null);
        field3.setText("   创建时间: " + createTime + " 修改时间: " + updateTime);
        field3.setFont(new Font("微软雅黑", 1, 9));
        field3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        field3.setCaretColor(new Color(0, 0, 0, 0));
        field3.setSelectionColor(new Color(0, 0, 0, 0));
        field3.setEditable(false);
        field3.setSelectedTextColor(Color.decode("#eeeeee"));
        field3.addMouseListener(new MouseListener()
        {
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
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 255)));
            }

            @Override
            public void mouseExited(MouseEvent e)
            {
                panel.setBorder(new LineBorder(new Color(148, 148, 148, 0)));
            }
        });
        box_V.add(field3);

        //box_H.add(box_V);
        panel.add(box_V, BorderLayout.CENTER);

        PushButton pushButton1 = new PushButton(" 打开工程 ");
        PushButton pushButton2 = new PushButton(" 删除工程 ");
        pushButton1.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (eventType.equals("mouseClicked")) if (listAction != null) listAction.accept(0);
            }
        });
        pushButton2.addClickedConnect(new ClickedConnect()
        {
            @Override
            public void accept(MouseEvent mouseEvent, String eventType)
            {
                if (eventType.equals("mouseClicked")) if (listAction != null) listAction.accept(1);
            }
        });
        pushButton1.getPushButton().setSize(119, 41);
        pushButton2.getPushButton().setSize(119, 41);
        pushButton1.getPushButton().setFont(new Font("新宋体", 0, 12));
        pushButton2.getPushButton().setFont(new Font("新宋体", 0, 12));
        box_V_2.add(pushButton1.getPushButton());
        JLabel label = new JLabel();
        label.setSize(10, 2);
        label.setMaximumSize(new Dimension(10, 2));
        label.setMinimumSize(new Dimension(10, 2));
        label.setPreferredSize(new Dimension(10, 2));
        label.setOpaque(true);
        label.setBackground(new Color(0, 0, 0, 0));
        label.setForeground(new Color(0, 0, 0, 0));
        label.setBorder(null);
        box_V_2.add(label);
        box_V_2.add(pushButton2.getPushButton());

        //box_H.add(box_V_2);
        panel.add(box_V_2, BorderLayout.EAST);
        //panel.add(box_H);
        mainArrayList.add(panel);
        mainFileArrayList.add(data);
        JTextField[] fieldArray = {
                field, field2, field3
        };
        textAreaArray.add(fieldArray);
        //repaint();
    }

    public void updateSize(int width2)
    {
        width = width2;
        for (JTextField[] jTextFields : textAreaArray)
        {
            jTextFields[0].setPreferredSize(new Dimension(width, jTextFields[0].getHeight()));
            jTextFields[1].setPreferredSize(new Dimension(width, jTextFields[1].getHeight()));
            jTextFields[2].setPreferredSize(new Dimension(width, jTextFields[2].getHeight()));
        }
        repaint();
    }

    public void clear()
    {
        mainArrayList.clear();
        mainFileArrayList.clear();
        textAreaArray.clear();
        repaint();
    }

    public void rep()
    {
        Dimension size = MainWindow.getMainWindow().getSize();
        MainWindow.getMainWindow().setSize(size.width + 1, size.height + 1);
        MainWindow.getMainWindow().setSize(size);
    }

    public void repaint()
    {
        mainContainerLayout_V.removeAll();
        mainContainerLayout_V = Box.createVerticalBox();
        mainContainer.removeAll();
        for (JPanel panel : mainArrayList) mainContainerLayout_V.add(panel);
        mainContainer.add(mainContainerLayout_V);
    }

    private void addItems()
    {

    }

    public JPanel getMainContainer()
    {
        return mainContainer;
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

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }
}
