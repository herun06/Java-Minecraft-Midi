/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.user_interface.section.page_2;

import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPageHome;
import main.java.com.xfherun.jmci.user_interface.section.MainContainerPage_2;
import main.java.com.xfherun.jmci.utils.GeneratorJMCIFile;
import main.java.com.xfherun.jmci.utils.WriteFile;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

public class InitFileMenu
{
    public static ArrayList<ArrayList<String[]>> objArray = new ArrayList<>();
    public static ArrayList<ArrayList<String>> objArray2 = new ArrayList<>();

    private InitFileMenu()
    {
    }

    public static void init()
    {
        XFMenuList xfMenuList = new XFMenuList(
                false, true, null, true, true,
                false, 100
        );
        xfMenuList.setBounds(new int[]{0, 0, 100, 35});
        xfMenuList.add("新建空白JMCI文件");
        xfMenuList.add("打开JMCI文件");
        xfMenuList.add("保存JMCI文件");
        xfMenuList.addButtonClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                int currentSelectIndex = xfMenuList.getCurrentSelectIndex();
                if (currentSelectIndex == 0)
                {
                    MainContainerPage_2.getAddFPSButton().setEnabled(true);
                    MainContainerPage_2.getRemoveFPSButton().setEnabled(true);
                    MainContainerPage_2.getFpsList().setEnabled(true);
                    MainContainerPage_2.getContentList().setEnabled(false);
                    MainContainerPage_2.getContentListScrollPane().setEnabled(true);
                    MainContainerPage_2.getFpsListScrollPane().setEnabled(true);
                    objArray.clear();
                    objArray2.clear();
                    MainContainerPage_2.getFpsList().removeAll();
                    MainContainerPage_2.getContentList().setText("");
                }
                if (currentSelectIndex == 1)
                {
                    JFileChooser fileChooser = new JFileChooser(new File("./"));
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.showOpenDialog(MainWindow.getMainWindow());
                    final File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null)
                    {
                        String filePath = selectedFile.toString();
                        String fileType = filePath.substring(filePath.length() - 5, filePath.length());
                        if (!fileType.equals(".jmci")) JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "请选择一个有效的*.jmci文件",
                                "警告", 2);
                        else
                        {
                            Thread runnable = new Thread()
                            {
                                public void run()
                                {
                                    MainContainerPage_2.getFpsList().removeAll();
                                    MainContainerPage_2.getAddFPSButton().setEnabled(true);
                                    MainContainerPage_2.getRemoveFPSButton().setEnabled(true);
                                    MainContainerPage_2.getFpsList().setEnabled(true);
                                    MainContainerPage_2.getContentList().setEnabled(true);
                                    MainContainerPage_2.getContentListScrollPane().setEnabled(true);
                                    MainContainerPage_2.getFpsListScrollPane().setEnabled(true);
                                    MainContainerPage_2.getFileButton().setEnabled(false);
                                    MainContainerPage_2.getEditButton().setEnabled(false);
                                    MainContainerPage_2.getStopPlayButton().setEnabled(false);
                                    MainContainerPage_2.getStartPlayButton().setEnabled(false);
                                    MainContainerPage_2.getSaveFPSButton().setEnabled(false);
                                    MainContainerPage_2.getAddFPSButton().setEnabled(false);
                                    MainContainerPage_2.getRemoveFPSButton().setEnabled(false);
                                    objArray.clear();
                                    MainContainerPage_2.getFpsList().removeAll();
                                    ArrayList<ArrayList<String[]>> arrayLists = StartReadJMCIFileContentData.openToString(selectedFile);
                                    for (int i = 0; i < arrayLists.size(); i++)
                                    {
                                        ArrayList<String[]> arrayList = arrayLists.get(i);
                                        InitFileMenu.objArray.add(arrayList);
                                        StringBuilder sb = new StringBuilder();
                                        ArrayList<String> cmd = new ArrayList<>();
                                        ArrayList<String> cmd2 = new ArrayList<>();
                                        cmd2.add("");
                                        for (int j = 0; j < arrayList.size(); j++)
                                        {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            String[] strings = arrayList.get(j);
                                            for (int l = 0; l < strings.length; l++)
                                            {
                                                String string = strings[l];
                                                if (l < (strings.length - 1))
                                                    stringBuilder.append(string).append(" ");
                                                else stringBuilder.append(string);
                                            }
                                            cmd.add(stringBuilder.toString());
                                        }
                                        for (int b = 0; b < cmd.size(); b++)
                                        {
                                            String args = cmd.get(b);
                                            if (b < (cmd.size() - 1)) sb.append(args).append(";").append("\n");
                                            else sb.append(args).append(";");
                                        }
                                        cmd2.set(0, sb.toString().replace("NONE;", ""));
                                        InitFileMenu.objArray2.add(cmd2);
                                    }
                                    for (int i = 0; i < InitFileMenu.objArray2.size(); i++)
                                    {
                                        MainContainerPage_2.getFpsList().add("" + i);
                                        MainContainerPage_2.getFpsList().select(i);
                                    }
                                    MainContainerPage_2.getFileButton().setEnabled(true);
                                    MainContainerPage_2.getEditButton().setEnabled(true);
                                    MainContainerPage_2.getStopPlayButton().setEnabled(true);
                                    MainContainerPage_2.getStartPlayButton().setEnabled(true);
                                    MainContainerPage_2.getSaveFPSButton().setEnabled(true);
                                    MainContainerPage_2.getAddFPSButton().setEnabled(true);
                                    MainContainerPage_2.getRemoveFPSButton().setEnabled(true);
                                }
                            };
                            runnable.start();
                        }
                    }

                }
                if (currentSelectIndex == 2)
                {
                    JFileChooser fileChooser = new JFileChooser(new File("./"));
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.showOpenDialog(MainWindow.getMainWindow());
                    File selectedFile = fileChooser.getSelectedFile();
                    if (selectedFile != null)
                    {
                        String write = GeneratorJMCIFile.write(InitFileMenu.objArray);
                        String fileName = JOptionPane.showInputDialog(MainWindow.getMainWindow(),
                                "请输入文件名, 不要加后缀",
                                "输入文件名", 1);
                        if (fileName != null && !fileName.equals(""))
                        {
                            File resultFile = new File(selectedFile.toString() + "/" + fileName + ".jmci");
                            if (!resultFile.exists())
                            {
                                WriteFile.writeStringToFile(resultFile.toString(), write, "UTF-8");
                                JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                        "保存成功！", "提示", 1);
                            }
                            else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "已存在的文件:\n    " + resultFile + "\n无法保存, 请重新输入文件名！",
                                    "警告", 2);
                        }
                        else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "文件保存失败！",
                                "警告", 2);
                    }
                }
            }
        });
        xfMenuList.show();
    }

    public static void init2()
    {
        MainContainerPageHome.setPageToCurrent(0);
    }
}
