/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.sneakgame.main;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.window_utils.UpdateWindow;
import main.java.com.xfherun.jmci.swing_util.window_utils.Window;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.sneakgame.draw.RowAndCol;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Main
{
    private static JFrame gameMainWindow;
    private static int width = 120;
    private static int height = 70;
    private static JLabel[][] chunkBlock = new JLabel[height][width];
    private static boolean[][] chunkBlockAdministrator = new boolean[height][width];
    private static int[] cookPos = new int[] {-1, -1};
    private static int time = 70;
    private static int length = 500;
    private static int[] pos = new int[] {40, 40};
    private static String fx = "up";
    private static boolean isGameOver = false;

    private Main()
    {
    }

    private static void init()
    {
        XFLog.info("初始化贪吃蛇界面");
        gameMainWindow = new JFrame();
        gameMainWindow.setTitle("Java 贪吃蛇 -- 作者: 21网络6班 何润");
        gameMainWindow.setSize(1000, 600);
        gameMainWindow.setLayout(null);
        gameMainWindow.setResizable(false);
        gameMainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        gameMainWindow.setLocationRelativeTo(null);
        gameMainWindow.setIconImage(new ImageIcon(Objects.requireNonNull(Main.class.getClassLoader().getResource("main/resources/images/window/logo/logo.png"))).getImage());
        render();
        events();
        gameMainWindow.setVisible(true);
        new Thread(Main::loop).start();
    }

    private static void renderEnd()
    {
        gameMainWindow.setSize(gameMainWindow.getWidth() - 24, gameMainWindow.getHeight() - 1);
    }

    private static boolean ifIndex(int currentNumber, int from, int to)
    {
        if (currentNumber < from || currentNumber > to) return false;
        return true;
    }

    private static void sleep(long time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }

    private static void setColor(int row, int col, Color color)
    {
        if (ifIndex(row, 0, height) && ifIndex(col, 0, width))
        {
            chunkBlock[row][col].setBackground(color);
            chunkBlock[row][col].setBorder(new LineBorder(new Color(204, 182, 182, 255)));
            chunkBlockAdministrator[row][col] = true;
            sleep(time);
            chunkBlock[row][col].setBackground(new Color(13, 57, 162, 255));
            chunkBlock[row][col].setBorder(new LineBorder(color));
            sleep(length);
            if (!isGameOver) new Thread(() -> setDefaultColor(row, col)).start();
        }
    }

    private static void setDefaultColor(int row, int col)
    {
        if (ifIndex(row, 0, height) && ifIndex(col, 0, width))
        {
            chunkBlock[row][col].setBackground(new Color(40, 40, 40, 255));
            chunkBlock[row][col].setBorder(new LineBorder(new Color(40, 40, 40, 255)));
            chunkBlockAdministrator[row][col] = false;
        }
    }

    private static void runToUP()
    {
        new Thread(() -> setColor(pos[0], pos[1], new Color(159, 208, 6, 255))).start();
        pos[0] = pos[0] - 1;
        sleep(time);
    }

    private static void runToDOWN()
    {
        new Thread(() -> setColor(pos[0], pos[1], new Color(159, 208, 6, 255))).start();
        pos[0] = pos[0] + 1;
        sleep(time);
    }

    private static void runToLEFT()
    {
        new Thread(() -> setColor(pos[0], pos[1], new Color(159, 208, 6, 255))).start();
        pos[1] = pos[1] - 1;
        sleep(time);
    }

    private static void runToRIGHT()
    {
        new Thread(() -> setColor(pos[0], pos[1], new Color(159, 208, 6, 255))).start();
        pos[1] = pos[1] + 1;
        sleep(time);
    }

    private static void initSneakLength()
    {

    }

    private static void render()
    {
        for (int i = 0; i < chunkBlock.length; i++)
        {
            for (int j = 0; j < chunkBlock[i].length; j++)
            {
                JLabel block = new JLabel();
                block.setOpaque(true);
                block.setBackground(new Color(40, 40, 40, 255));
                block.setForeground(Color.decode("#eeeeee"));
                //block.setBorder(new LineBorder(new Color(201, 201, 201, 255), 1));
                block.setBorder(new LineBorder(new Color(40, 40, 40, 255), 1));
                chunkBlock[i][j] = block;
            }
        }

        int x = 0;
        int y = 0;
        int windowWidth = gameMainWindow.getWidth() - 16;
        int windowHeight = gameMainWindow.getHeight() - 39;
        int width = windowWidth / Main.width;
        int height = windowHeight / Main.height;
        for (int i = 0; i < chunkBlock.length; i++)
        {
            for (int j = 0; j < chunkBlock[i].length; j++)
            {
                chunkBlock[i][j].setBounds(x, y, width, height);
                gameMainWindow.getContentPane().add(chunkBlock[i][j]);
                x += width;
            }
            y += height;
            x = 0;
        }

        randomCook();
        initSneakLength();

        renderEnd();
    }

    private static void exit()
    {
        MainWindow.getMainWindow().setVisible(true);
        new UpdateWindow(MainWindow.getMainWindow()).start();
        gameMainWindow.setVisible(false);
    }

    private static void events()
    {
        gameMainWindow.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                exit();
            }

            @Override
            public void windowClosed(WindowEvent e)
            {

            }

            @Override
            public void windowIconified(WindowEvent e)
            {

            }

            @Override
            public void windowDeiconified(WindowEvent e)
            {

            }

            @Override
            public void windowActivated(WindowEvent e)
            {

            }

            @Override
            public void windowDeactivated(WindowEvent e)
            {

            }
        });

        gameMainWindow.addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                int code = e.getKeyCode();
                // 87 W
                // 83 S
                // 65 A
                // 68 D

                if (code == 87)
                {
                    fx = "up";
                    XFLog.info("上");
                }
                if (code == 83)
                {
                    fx = "down";
                    XFLog.info("下");
                }
                if (code == 65)
                {
                    fx = "left";
                    XFLog.info("左");
                }
                if (code == 68)
                {
                    fx = "right";
                    XFLog.info("右");
                }
            }

            @Override
            public void keyReleased(KeyEvent e)
            {

            }
        });
    }

    private static void gameOver()
    {
        isGameOver = true;
        XFLog.info("GameOver!!!");
        JOptionPane.showMessageDialog(gameMainWindow,
                "游戏结束, 你输了！",
                "提示", 1);
        exit();
    }

    private static Color getColor()
    {
        Color[] colors = new Color[]
                {
                   new Color(121, 41, 41, 255),
                   new Color(250, 1, 1, 255),
                   new Color(218, 178, 178, 255),
                   new Color(59, 6, 6, 255),
                   new Color(110, 16, 106, 255),
                   new Color(143, 46, 46, 255),
                   new Color(26, 63, 25, 255),
                   new Color(238, 255, 0, 255),
                   new Color(218, 7, 182, 255),
                   new Color(131, 131, 131, 255),
                   new Color(231, 23, 23, 255),
                   new Color(96, 16, 16, 255),
                   new Color(255, 243, 243, 255),
                   new Color(231, 255, 0, 255),
                   new Color(0, 0, 58, 255),
                   new Color(33, 33, 49, 255),
                   new Color(95, 95, 208, 255)
                };
        return colors[new Random().nextInt(0, colors.length)];
    }

    private static void randomCook()
    {
        while (true)
        {
            int row = new Random().nextInt(0, height);
            int col = new Random().nextInt(0, width);
            try
            {
                if (!chunkBlockAdministrator[row][col])
                {
                    cookPos[0] = row;
                    cookPos[1] = col;
                    chunkBlock[cookPos[0]][cookPos[1]].setBackground(getColor());
                    chunkBlock[cookPos[0]][cookPos[1]].setBorder(new LineBorder(Color.decode("#eeeeee")));
                    break;
                }
            }
            catch (NumberFormatException e)
            {

            }
        }
    }

    private static void loop()
    {
        while (gameMainWindow.isVisible())
        {
            if (!isGameOver)
            {
                int row = pos[0];
                int col = pos[1];
                if (fx.equalsIgnoreCase("up"))
                {
                    try
                    {
                        if (chunkBlockAdministrator[row - 1][col]) gameOver();
                        else runToUP();
                    }
                    catch (Exception e)
                    {
                        gameOver();
                    }
                }
                else if (fx.equalsIgnoreCase("down"))
                {
                    try
                    {
                        if (chunkBlockAdministrator[row + 1][col]) gameOver();
                        else runToDOWN();
                    }
                    catch (Exception e)
                    {
                        gameOver();
                    }
                }
                else if (fx.equalsIgnoreCase("left"))
                {
                    try
                    {
                        if (chunkBlockAdministrator[row][col - 1]) gameOver();
                        else runToLEFT();
                    }
                    catch (Exception e)
                    {
                        gameOver();
                    }
                }
                else if (fx.equalsIgnoreCase("right"))
                {
                    try
                    {
                        if (chunkBlockAdministrator[row][col + 1]) gameOver();
                        else runToRIGHT();
                    }
                    catch (Exception e)
                    {
                        gameOver();
                    }
                }
                if (row == cookPos[0] && col == cookPos[1])
                {
                    length += 500;
                    randomCook();
                }
            }
            gameMainWindow.getContentPane().repaint();
        }
    }

    public static void main(ArrayList<String> args)
    {
        width = 120;
        height = 70;
        chunkBlock = new JLabel[height][width];
        chunkBlockAdministrator = new boolean[height][width];
        cookPos = new int[] {-1, -1};
        isGameOver = false;
        fx = "up";
        time = 70;
        length = 500;
        pos[0] = 40;
        pos[1] = 40;
        new Thread(Main::init).start();
        if (MainWindow.getMainWindow() != null && MainWindow.getMainWindow().isVisible())
            MainWindow.getMainWindow().setVisible(false);
    }
}
