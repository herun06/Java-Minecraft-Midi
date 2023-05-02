package main.java.com.xfherun.jmci.user_interface.section.page_1.file_system;

import main.java.com.xfherun.jmci.midi.StartReadJMCIFileContentData;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.list.menu.XFMenuList;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.utils.CompileMIDISourceFileTool;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.MouseEvent;
import java.io.File;

public class RightMenu
{
    private RightMenu()
    {
    }

    public static void init()
    {
        XFMenuList xfMenuList = new XFMenuList(
                false, true, null, true,
                true, false, 0
        );
        xfMenuList.setBounds(new int[]{0, 0, 100, 50});
        xfMenuList.add("选择*.mid源文件进行编译");
        xfMenuList.add("选择现有的*.jmci文件进行播放");
        xfMenuList.add("选择本地缓存*.jmci文件进行播放");
        xfMenuList.addButtonClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                int currentSelectIndex = xfMenuList.getCurrentSelectIndex();
                if (currentSelectIndex == 0)
                {
                    JFileChooser fileChooser = new JFileChooser(new File("./"));
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setDialogTitle("选择*.mid源文件");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setFileFilter(new FileFilter()
                    {

                        @Override
                        public String getDescription()
                        {
                            return "Musical Instrument Digital Interface 文件(*.mid)";
                        }

                        @Override
                        public boolean accept(File f)
                        {
                            if (f.getName().toLowerCase().endsWith(".mid")) return true;
                            return false;
                        }
                    });
                    int option = fileChooser.showOpenDialog(MainWindow.getMainWindow());
                    if (option == 0)
                    {
                        if (fileChooser.getSelectedFile() != null)
                        {
                            String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                            String fileType = ".mid";
                            if (absolutePath.substring(absolutePath.length() - 4, absolutePath.length()).equalsIgnoreCase(fileType))
                            {
                                String midiSourceFile = fileChooser.getSelectedFile().getPath();
                                double bpm = 100.0;
                                String name = new File(midiSourceFile).getName().substring(0, new File(midiSourceFile).getName().length() - 4);
                                CompileMIDISourceFileTool.startCompile(new File(midiSourceFile).getAbsoluteFile(), bpm, name);
                            }
                            else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "请选择一个有效的*.mid文件",
                                    "警告", 2);
                        }
                    }
                }
                if (currentSelectIndex == 1)
                {
                    String currentDir = "./";
                    if (new File("./cache/jmci").exists()) currentDir = "././cache/jmci";
                    JFileChooser fileChooser = new JFileChooser(new File(currentDir));
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.setDialogTitle("选择*.jmci源文件");
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fileChooser.setFileFilter(new FileFilter()
                    {

                        @Override
                        public String getDescription()
                        {
                            return "Java Minecraft Midi 文件(*.jmci)";
                        }

                        @Override
                        public boolean accept(File f)
                        {
                            if (f.getName().toLowerCase().endsWith(".jmci")) return true;
                            return false;
                        }
                    });
                    int option = fileChooser.showOpenDialog(MainWindow.getMainWindow());
                    if (option == 0)
                    {
                        if (fileChooser.getSelectedFile() != null)
                        {
                            String absolutePath = fileChooser.getSelectedFile().getAbsolutePath();
                            String fileType = ".jmci";
                            if (absolutePath.substring(absolutePath.length() - 5, absolutePath.length()).equalsIgnoreCase(fileType))
                            {
                                String midiSourceFile = fileChooser.getSelectedFile().toString();
                                StartReadJMCIFileContentData.startRead(new File(midiSourceFile));
                            }
                            else JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                    "请选择一个有效的*.jmci文件",
                                    "警告", 2);
                        }
                    }
                }
                if (currentSelectIndex == 2)
                {
                    InitList.init();
                }
            }
        });
        xfMenuList.show();
    }
}
