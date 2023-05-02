/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.minecraft_redstone_music_generator.utls;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.swing_util.window_utils.Window;
import main.java.com.xfherun.jmci.utils.FileUtil;
import main.java.com.xfherun.jmci.utils.ReadTextFile;
import main.java.com.xfherun.jmci.utils.Sleep;
import main.java.com.xfherun.minecraft_redstone_music_generator.user_ui.MainWindow;

import javax.annotation.processing.Filer;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class ExecuteJavaMinecraftSaveFile
{
    private static JDialog mainWindow;
    private static JPanel panel;
    private static JLabel titleLabel;
    private static Thread mainThread;
    private static boolean isEnd;
    private static ButtonClick buttonClick;

    private ExecuteJavaMinecraftSaveFile()
    {
    }

    public static boolean init(ButtonClick buttonClick)
    {
        XFLog.info("初始化窗口......");
        ExecuteJavaMinecraftSaveFile.buttonClick = buttonClick;
        isEnd = false;
        mainWindow = new JDialog();
        mainWindow.setTitle("准备中...");
        mainWindow.setSize(400, 200);
        mainWindow.setLocationRelativeTo(MainWindow.getMainWindow());
        mainWindow.setLayout(null);
        mainWindow.setResizable(false);

        panel = new JPanel();
        panel.setBounds(0, 0, mainWindow.getWidth() - 16, mainWindow.getHeight() - 39);
        panel.setOpaque(true);
        panel.setLayout(null);
        panel.setBackground(new Color(45, 45, 45, 255));
        panel.setBorder(null);

        titleLabel = new JLabel();
        titleLabel.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(45, 45, 45, 255));
        titleLabel.setForeground(Color.decode("#eeeeee"));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel);

        mainWindow.getContentPane().add(panel);
        mainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        mainWindow.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                stop();
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
        mainWindow.setModal(true);
        return true;
    }

    private static void stop()
    {
        if (!isEnd)
        {
            XFLog.info("终止启动Minecraft");
            int option = JOptionPane.showConfirmDialog(mainWindow,
                    "你确定要终止启动吗？",
                    "终止启动Minecraft", 0, 1);
            if (option == 0)
            {
                XFLog.info("开始终止");
                buttonClick.clicked(null);
            }
            else XFLog.info("继续启动Minecraft");
        }
        else
        {
            XFLog.info("正常关闭窗口");
            mainWindow.setVisible(false);
        }
    }

    private static void setProgress(String value)
    {
        mainWindow.setTitle(value);
        titleLabel.setText(value);
    }

    private static void hide()
    {
        /*isEnd = true;
        stop();*/
        mainWindow.setVisible(false);
        setEnd();
    }

    private static void setEnd()
    {
        MainWindow.setIsRunJMCSFile(true);
    }

    public static void deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if (file.isFile())
        {
            file.delete();
            XFLog.info("已删除: " + file);
        }
        else
        {
            File[] files = file.listFiles();
            if (files == null)
            {
                file.delete();
                XFLog.info("已删除: " + file);
            }
            else
            {
                for (int i = 0; i < files.length; i++) deleteDir(files[i].getAbsolutePath());
                file.delete();
                XFLog.info("已删除: " + file);
            }
        }
    }

    private static void updateWindow()
    {
        mainWindow.getContentPane().revalidate();
        mainWindow.getContentPane().repaint();
    }

    private static void fireman()
    {
        mainThread = null;
        Thread runnable = new Thread()
        {
            public void run()
            {
                init(new ButtonClick()
                {
                    @Override
                    public void clicked(MouseEvent event)
                    {
                        XFLog.info("终止中...");
                        setProgress("终止中...");
                        XFLog.info("结束进程");
                        mainThread.stop();
                        XFLog.info("进程: " + mainThread + " 死亡");
                        XFLog.info("清空缓存");
                        setProgress("清空缓存...");
                        clearCaches();
                        XFLog.info("清除成功");
                        setProgress("完成...");
                        Sleep.sleep(new Random().nextInt(1000, 3456));
                        mainWindow.setVisible(false);
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "启动结束！ 启动失败！！",
                                "警告", 2);
                        setEnd();
                    }
                });
            }
        };
        runnable.start();
    }

    private static void loop()
    {
        XFLog.info("开始循环窗口");
        while (true)
        {
            if (!mainWindow.isVisible())
            {
                XFLog.info("窗口已断开, 循环结束");
                break;
            }
            updateWindow();
        }
    }

    public static void execute()
    {
        fireman();
        mainThread = new Thread(() ->
        {
            XFLog.info("弹出文件选择对话框JFileChoose");
            JFileChooser jFileChooser = new JFileChooser("./");
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            jFileChooser.setMultiSelectionEnabled(false);
            jFileChooser.setDialogTitle("执行JMCS文件, 请选择JMCS文件位置");
            jFileChooser.setFileFilter(new FileFilter()
            {

                @Override
                public String getDescription()
                {
                    return "Java Minecraft Save 文件(*.jmcs)";
                }

                @Override
                public boolean accept(File f)
                {
                    if (f.getName().toLowerCase().endsWith(".jmcs")) return true;
                    return false;
                }
            });
            int option = jFileChooser.showOpenDialog(MainWindow.getMainWindow());
            if (option == 0)
            {
                File selectedFile = jFileChooser.getSelectedFile();
                if (selectedFile != null)
                {
                    XFLog.info("开始校验文件格式数据: " + selectedFile);
                    String fileName = selectedFile.getAbsolutePath();
                    String fileType = fileName.substring(fileName.length() - 5, fileName.length());
                    if (!fileType.equalsIgnoreCase(".jmcs"))
                    {
                        String str = "请选择有效的JMCS文件: {0}" + selectedFile;
                        XFLog.warn(str.replace("{0}", ""));
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                str.replace("{0}", "\n"),
                                "警告", 2);
                        return;
                    }
                    new Thread(() ->
                    {
                        mainWindow.setVisible(true);
                        new Thread(ExecuteJavaMinecraftSaveFile::loop).start();
                    }).start();
                    setProgress("清除本地缓存中...");
                    clearCaches();
                    File dotMinecraftFilePath = new File("cache/minecraft/.minecreaft").getAbsoluteFile();
                    setProgress("初始化Minecraft主程序");
                    XFLog.info("开始初始化 minecraft 主程序文件: " + dotMinecraftFilePath);
                    XFLog.info("生成.minecraft文件目录及程序: " + dotMinecraftFilePath);
                    File newFile = new File("cache/minecraft/.minecraft/minecraft_1.12.2_forge.zip").getAbsoluteFile();
                    try
                    {
                        FileUtil.loadRecourseFromJar("/main/resources/run/minecraft__1_12_2/minecraft_1.12.2_forge.zip", newFile.toString(), ExecuteJavaMinecraftSaveFile.class);
                    }
                    catch (IOException e)
                    {
                        String str = "运行失败！";
                        XFLog.warn(str, e);
                        clearCaches();
                        hide();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }
                    File copyTo = new File("cache/minecraft/.minecraft/" + "minecraft" + ".zip").getAbsoluteFile();
                    try
                    {
                        Files.copy(Path.of(new File("cache/minecraft/.minecraft/minecraft_1.12.2_forge.zip/main/resources/run/minecraft__1_12_2/minecraft_1.12.2_forge.zip").getAbsolutePath()), Path.of(copyTo.toString()));
                    }
                    catch (IOException e)
                    {
                        String str = "运行失败！";
                        XFLog.warn(str, e);
                        clearCaches();
                        hide();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }
                    XFLog.info("清除局部缓存");
                    deleteDir("cache/minecraft/.minecraft/minecraft_1.12.2_forge.zip");

                    setProgress("解压Minecraft主程序中...");
                    XFLog.info("开始解压minecraft主程序");
                    try
                    {
                        ZipUtil.unZip("cache/minecraft/.minecraft/" + "minecraft" + ".zip", "cache/minecraft/.minecraft");
                    }
                    catch (IOException e)
                    {
                        String str = "解压失败！ 运行失败！";
                        XFLog.warn(str, e);
                        clearCaches();
                        hide();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }
                    XFLog.info("开始删除源文件");
                    File srcFile = new File("cache/minecraft/.minecraft/" + "minecraft" + ".zip").getAbsoluteFile();
                    boolean delete = srcFile.delete();
                    if (delete) XFLog.info("源文件: " + srcFile + " 删除成功！");
                    else XFLog.info("源文件: " + srcFile + " 删除失败！ 可能没有这个文件..。。。");
                    setProgress("释放存档...");
                    XFLog.info("释放存档中...");

                    File copyTo2 = new File("cache/minecraft/.minecraft/" + selectedFile.getName()).getAbsoluteFile();
                    try
                    {
                        Files.copy(Path.of(selectedFile.getAbsolutePath()), Path.of(copyTo2.toString()));
                    }
                    catch (IOException e)
                    {
                        String str = "运行失败！";
                        XFLog.warn(str, e);
                        clearCaches();
                        hide();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }

                    XFLog.info("解压存档");
                    setProgress("解压存档...");
                    try
                    {
                        ZipUtil.unZip(copyTo2, new File("cache/minecraft/.minecraft").getAbsolutePath());
                    }
                    catch (IOException e)
                    {
                        String str = "运行失败！";
                        XFLog.warn(str, e);
                        clearCaches();
                        hide();
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(), str, "错误", 0);
                        return;
                    }

                    XFLog.info("删除缓存");
                    boolean delete1 = copyTo2.delete();
                    if (delete1) XFLog.info("文件: " + copyTo2 + " 删除成功");
                    else XFLog.info("文件: " + copyTo2 + " 删除失败");

                    setProgress("启动中...");
                    XFLog.info("获取启动参数");
                    File bootArgsFile = new File("cache/minecraft/.minecraft/boot_args");
                    File dotMinecraftPath = new File("cache/minecraft/.minecraft");
                    XFLog.info("获取到参数文件: " + bootArgsFile);
                    XFLog.info("开始读取参数文件");
                    ArrayList<String> arrayList = ReadTextFile.readAll(bootArgsFile);
                    String bootArgs = "@echo off\nset APPDATA=\"" + dotMinecraftPath.getAbsolutePath() + "\\\"\ncd /D \"" + dotMinecraftPath.getAbsolutePath() + "\\\"\n\"..\\..\\..\\jre1.8.0_91\\bin\\java.exe\" " + arrayList.get(0).replace("{JMCP_XFHERUN_PATH}", dotMinecraftPath.getAbsolutePath() + "\\").replace("{GAME_DIR}", "" + dotMinecraftPath.getAbsolutePath());
                    File boot_Args = new File("cache/minecraft/.minecraft/boot_args");
                    boolean delete2 = boot_Args.delete();
                    if (delete2) XFLog.info("文件: " + boot_Args + " 删除成功");
                    else XFLog.info("文件: " + boot_Args + " 删除失败");
                    XFLog.debug("启动参数:\n" + bootArgs);
                    XFLog.info("开始启动....");
                    hide();
                    BootMinecraft.boot(bootArgs);
                }
                else
                {
                    XFLog.warn("selectedFile is :: null");
                    setEnd();
                }
            }
            else
            {
                XFLog.info("用户已取消, 返回值: 1");
                setEnd();
            }
        });
        mainThread.start();
    }

    public static void clearCaches()
    {
        XFLog.info("清空缓存");
        File[] files = new File("cache/minecraft/.minecraft/").getAbsoluteFile().listFiles();
        for (int i = 0; i < files.length; i++)
        {
            File file = files[i];
            deleteDir(file.getAbsolutePath());
            XFLog.info("成功删除文件或文件目录: " + file);
        }
        File bootFIle = new File("cache/minecraft/boot.bat");
        bootFIle.delete();
        XFLog.info("完成！");
    }
}
