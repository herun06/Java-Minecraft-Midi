package main.java.com.xfherun.jmci.user_interface.section;

import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.page_2.InitFileMenu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class MainContainerPage_2
{
    private static JPanel mainContainerPanel;
    private static XFButton fileButton;
    private static XFButton editButton;
    private static XFButton addFPSButton;
    private static XFButton removeFPSButton;
    private static XFButton saveFPSButton;
    private static XFButton startPlayButton;
    private static XFButton stopPlayButton;
    private static List fpsList;
    private static JTextArea contentList;
    private static JScrollPane fpsListScrollPane;
    private static JScrollPane contentListScrollPane;
    private static boolean isAdd = false;

    private MainContainerPage_2()
    {
    }

    public static void init()
    {
        mainContainerPanel = new JPanel();
        mainContainerPanel.setBounds(0, 0, MainWindow.getMainContainer().getWidth(),
                MainWindow.getMainContainer().getHeight());
        mainContainerPanel.setLayout(null);
        mainContainerPanel.setBackground(new Color(29, 115, 27, 255));
        mainContainerPanel.setLayout(null);
        addItems();
        mainContainerPanel.setVisible(false);
        MainWindow.getMainContainer().add(mainContainerPanel);
    }

    private static void addItems()
    {
        fileButton = new XFButton("文件");
        editButton = new XFButton("返回");
        saveFPSButton = new XFButton("保存帧");
        startPlayButton = new XFButton("开始播放");
        stopPlayButton = new XFButton("终止播放");
        fileButton.setBounds(0, 0, 119, 35);
        editButton.setBounds(120, 0, 119, 35);
        saveFPSButton.setBounds(120 * 2, 0, 119, 35);
        startPlayButton.setBounds(120 * 3, 0, 119, 35);
        stopPlayButton.setBounds(120 * 4, 0, 119, 35);
        stopPlayButton.setEnabled(false);
        startPlayButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                int count = fpsList.getItemCount();
                if (count != 0)
                {
                    StartReadJMCIFileContentData.testPlaySong(InitFileMenu.objArray);
                    startPlayButton.setEnabled(false);
                    stopPlayButton.setEnabled(true);
                }
                else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                        "当前没有能够播放的帧",
                        "警告", 2);
            }

        });
        stopPlayButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StartReadJMCIFileContentData.testStopSong();
                startPlayButton.setEnabled(true);
                stopPlayButton.setEnabled(false);
            }
        });
        fileButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                InitFileMenu.init();
            }
        });
        editButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                InitFileMenu.init2();
            }
        });
        saveFPSButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                if (!isAdd)
                {
                    saveFPS();
                }
                else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                        "请等当前帧添加完",
                        "警告", 2);
            }
        });
        fileButton.addWindow(mainContainerPanel);
        editButton.addWindow(mainContainerPanel);
        saveFPSButton.addWindow(mainContainerPanel);
        startPlayButton.addWindow(mainContainerPanel);
        stopPlayButton.addWindow(mainContainerPanel);

        addFPSButton = new XFButton("+");
        removeFPSButton = new XFButton("-");
        addFPSButton.setBounds(0, 35, 35, 35);
        removeFPSButton.setBounds(35, 35, 35, 35);
        addFPSButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                if (!isAdd)
                {
                    String fps = (String) JOptionPane.showInputDialog(MainWindow.getMainWindow(),
                            "请输入要添加帧数的步数",
                            "添加帧", 1, null, null, "1");
                    try
                    {
                        int fps_int = Integer.parseInt(fps);
                        if (fps_int > 0 && fps_int <= 65536)
                        {
                            for (int i = 0; i < fps_int; i++)
                            {
                                ArrayList<String[]> arrayList = new ArrayList<>();
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                arrayList2.add("");
                                InitFileMenu.objArray.add(arrayList);
                                InitFileMenu.objArray2.add(arrayList2);
                            }
                            new Thread(() ->
                            {
                                MainContainerPage_2.getFpsList().removeAll();
                                isAdd = true;
                                MainContainerPage_2.getContentList().setEnabled(false);
                                for (int i = 0; i < InitFileMenu.objArray.size(); i++)
                                {
                                    MainContainerPage_2.getFpsList().add("" + i);
                                    MainContainerPage_2.getFpsList().select(i);
                                }
                                if (InitFileMenu.objArray.size() != 0)
                                    MainContainerPage_2.getContentList().setEnabled(true);
                                isAdd = false;
                            }).start();
                        }
                        else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "请输入正确的数字: " + fps_int,
                                "警告", 2);
                    }
                    catch (NumberFormatException e)
                    {
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "请输入正确的数字",
                                "警告", 2);
                    }
                }
                else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                        "请等当前帧添加完",
                        "警告", 2);
            }
        });
        removeFPSButton.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                if (!isAdd)
                {
                    int selectedIndex = MainContainerPage_2.getFpsList().getSelectedIndex();
                    if (selectedIndex != -1)
                    {
                        InitFileMenu.objArray.remove(selectedIndex);
                        InitFileMenu.objArray2.remove(selectedIndex);
                        new Thread(() ->
                        {
                            MainContainerPage_2.getFpsList().removeAll();
                            isAdd = true;
                            MainContainerPage_2.getContentList().setEnabled(false);
                            for (int i = 0; i < InitFileMenu.objArray.size(); i++)
                            {
                                MainContainerPage_2.getFpsList().add("" + i);
                                MainContainerPage_2.getFpsList().select(i);
                            }
                            if (InitFileMenu.objArray.size() != 0)
                                MainContainerPage_2.getContentList().setEnabled(true);
                            isAdd = false;
                        }).start();
                    }
                    else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                            "请选择要删除的帧, 只能单个删",
                            "警告", 2);
                }
                else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                        "请等当前帧添加完",
                        "警告", 2);
            }
        });
        addFPSButton.setEnabled(false);
        removeFPSButton.setEnabled(false);
        addFPSButton.addWindow(mainContainerPanel);
        removeFPSButton.addWindow(mainContainerPanel);

        fpsList = new List();
        fpsList.setBackground(new Color(29, 115, 27, 255));
        fpsList.setForeground(Color.decode("#eeeeee"));
        fpsList.setEnabled(false);
        fpsList.addMouseListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (e.getClickCount() == 1)
                {
                    int selectedIndex = fpsList.getSelectedIndex();
                    if (selectedIndex != -1)
                    {
                        ArrayList<String> arrayList = InitFileMenu.objArray2.get(selectedIndex);
                        String text = arrayList.get(0);
                        MainContainerPage_2.getContentList().setText(text);
                    }
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

            }

            @Override
            public void mouseExited(MouseEvent e)
            {

            }
        });
        fpsListScrollPane = new JScrollPane(fpsList);
        fpsListScrollPane.setBounds(0, 35 * 2, 200, mainContainerPanel.getHeight() - (35 * 2));
        fpsListScrollPane.setBorder(new LineBorder(new Color(40, 61, 5, 255)));
        fpsListScrollPane.setEnabled(false);
        mainContainerPanel.add(fpsListScrollPane);

        contentList = new JTextArea();
        contentList.setOpaque(true);
        contentList.setBackground(new Color(29, 115, 27, 255));
        contentList.setForeground(Color.decode("#eeeeee"));
        contentList.setEnabled(false);
        contentListScrollPane = new JScrollPane(contentList);
        contentListScrollPane.setBounds(200, 35 * 2, mainContainerPanel.getWidth() - 200, mainContainerPanel.getHeight() - (35 * 2));
        contentListScrollPane.setEnabled(false);
        mainContainerPanel.add(contentListScrollPane);
    }

    public static void saveFPS()
    {
        int selectedIndex = MainContainerPage_2.getFpsList().getSelectedIndex();
        if (selectedIndex != -1)
        {
            String text = MainContainerPage_2.getContentList().getText();
            int start = 0;
            int end = 0;
            int count = 0;
            ArrayList<String> command = new ArrayList<>();
            for (int i = 0; i < text.length(); i++)
            {
                char c = text.charAt(i);
                if (c == ';')
                {
                    end = i;
                    String result = text.substring(start, end);
                    command.add(result);
                    count++;
                }
                if (count != 0) start = end + 1;
            }
            String result = text.substring(start, text.length());
            command.add(result);

            ArrayList<String[]> list = new ArrayList<>();
            for (int i = 0; i < command.size(); i++)
            {
                String cmd = command.get(i);
                int startIndex = 0;
                int endIndex = 0;
                int spaceCount = 0;
                ArrayList<String> tempArgsList = new ArrayList<>();
                for (int j = 0; j < cmd.length(); j++)
                {
                    char c = cmd.charAt(j);
                    if (c == ' ')
                    {
                        endIndex = j;
                        String args = cmd.substring(startIndex, endIndex);
                        tempArgsList.add(args);
                        spaceCount++;
                    }
                    if (spaceCount != 0) startIndex = endIndex + 1;
                }
                String args = cmd.substring(startIndex, cmd.length());
                tempArgsList.add(args);
                String[] arr = new String[tempArgsList.size()];
                for (int l = 0; l < tempArgsList.size(); l++)
                {
                    String args2 = tempArgsList.get(l);
                    arr[l] = args2;
                }
                list.add(arr);
            }
            InitFileMenu.objArray.set(selectedIndex, list);
            ArrayList<String> strList = new ArrayList<>();
            strList.add(text);
            InitFileMenu.objArray2.set(selectedIndex, strList);
        } else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                "请选择要保存的帧",
                "警告", 2);
    }

    public static void setPageToCurrent(int index)
    {
        if (index < 0 || index > 5) throw new IndexOutOfBoundsException("Index: " + index + " out of range 0 ~ 5.");
        else
        {
            MainContainerPageHome.getMainContainerPanel().setVisible(false);
            MainContainerPage_1.getMainContainerPanel().setVisible(false);
            MainContainerPage_2.getMainContainerPanel().setVisible(false);
            MainContainerPage_3.getMainContainerPanel().setVisible(false);
            MainContainerPage_4.getMainContainerPanel().setVisible(false);
            MainContainerPage_5.getMainContainerPanel().setVisible(false);
            if (index == 0) MainContainerPageHome.getMainContainerPanel().setVisible(true);
            else if (index == 1) MainContainerPage_1.getMainContainerPanel().setVisible(true);
            else if (index == 2) MainContainerPage_2.getMainContainerPanel().setVisible(true);
            else if (index == 3) MainContainerPage_3.getMainContainerPanel().setVisible(true);
            else if (index == 4) MainContainerPage_4.getMainContainerPanel().setVisible(true);
            else MainContainerPage_5.getMainContainerPanel().setVisible(true);
        }
    }

    public static JPanel getMainContainerPanel()
    {
        return mainContainerPanel;
    }

    public static XFButton getFileButton()
    {
        return fileButton;
    }

    public static XFButton getEditButton()
    {
        return editButton;
    }

    public static XFButton getAddFPSButton()
    {
        return addFPSButton;
    }

    public static XFButton getRemoveFPSButton()
    {
        return removeFPSButton;
    }

    public static List getFpsList()
    {
        return fpsList;
    }

    public static JTextArea getContentList()
    {
        return contentList;
    }

    public static JScrollPane getFpsListScrollPane()
    {
        return fpsListScrollPane;
    }

    public static JScrollPane getContentListScrollPane()
    {
        return contentListScrollPane;
    }

    public static XFButton getSaveFPSButton()
    {
        return saveFPSButton;
    }

    public static XFButton getStartPlayButton()
    {
        return startPlayButton;
    }

    public static XFButton getStopPlayButton()
    {
        return stopPlayButton;
    }

    public static boolean isIsAdd()
    {
        return isAdd;
    }
}
