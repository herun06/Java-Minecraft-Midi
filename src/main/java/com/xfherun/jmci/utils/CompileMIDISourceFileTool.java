/*
 * Copyright (c) 2023. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package main.java.com.xfherun.jmci.utils;

import com.xfherun.xflog.XFLog;
import main.java.com.xfherun.jmci.piano_data.CurrentPianoInformation;
import main.java.com.xfherun.jmci.swing_util.button.XFButton;
import main.java.com.xfherun.jmci.swing_util.button.i.ButtonClick;
import main.java.com.xfherun.jmci.user_interface.MainWindow;
import main.java.com.xfherun.jmci.user_interface.exception_window.ExceptionLeftBottomWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class CompileMIDISourceFileTool
{
    private CompileMIDISourceFileTool()
    {
    }

    public static void startCompile(File sourceFile, double bpm, String name)
    {
        /*CompileProgress compileProgress = new CompileProgress();
        compileProgress.start();*/
        XFLog.info("开始编译: " + sourceFile + " :: " + bpm + " :: " + name);
        new Thread(CompileProgress::run).start();
        UpdateCompileProgress updateCompileProgress = new UpdateCompileProgress();
        updateCompileProgress.start();
        StartCompileMidiFile startCompileMidiFile = new StartCompileMidiFile(sourceFile, bpm, name);
        startCompileMidiFile.start();
    }
}

class StartCompileMidiFile extends Thread
{
    public static boolean isEnd = false;
    private File file;
    private double bpm;
    private String name;

    public StartCompileMidiFile(File file, double bpm, String name)
    {
        this.file = file;
        this.bpm = bpm;
        this.name = name;
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

    private static void init()
    {
        XFLog.info("初始化编译器");
        if (CompileProgress.compileProgressDialog != null) CompileProgress.compileProgressDialog.setTitle("开始编译, 请稍等 ...");
        if (CompileProgress.progressBarTitle != null) CompileProgress.progressBarTitle.setText("开始编译, 请稍等 ...");
        if (CompileProgress.progressBar != null) CompileProgress.progressBar.setValue(0);
        File newFile = new File("cache/compile_cache").getAbsoluteFile();
        String fileName = "xfherun_compile.dat";
        CompileProgress.setProgress("清空缓存中...", 0);
        deleteDir("cache/compile_cache");
        CompileProgress.setProgress("加载编译器...", 0);
        XFLog.info("创建编译器");
        try
        {
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-console-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-datetime-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-debug-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-errorhandling-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-file-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-file-l1-2-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-file-l2-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-handle-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-heap-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-interlocked-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-libraryloader-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-localization-l1-2-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-memory-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-namedpipe-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-processenvironment-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-processthreads-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-processthreads-l1-1-1.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-profile-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-rtlsupport-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-string-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-synch-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-synch-l1-2-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-sysinfo-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-timezone-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-core-util-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-conio-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-convert-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-environment-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-filesystem-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-heap-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-locale-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-math-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-process-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-runtime-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-stdio-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-string-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-time-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/api-ms-win-crt-utility-l1-1-0.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/base_library.zip", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/libcrypto-1_1.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/libssl-1_1.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/python37.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/select.pyd", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/TEST.py", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/ucrtbase.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/unicodedata.pyd", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/VCRUNTIME140.dll", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/xfherun_compile.dat", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/_bz2.pyd", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/_hashlib.pyd", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/_lzma.pyd", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/_socket.pyd", newFile.toString(), StartCompileMidiFile.class);
            FileUtil.loadRecourseFromJar("/main/resources/compile/python/_ssl.pyd", newFile.toString(), StartCompileMidiFile.class);
            CompileProgress.setProgress("完成... 等待编译器开始工作", 0);
        }
        catch (IOException e)
        {
            CompileProgress.setProgress("初始化编译器失败, 可以终止编译", 0);
            XFLog.warn("初始化编译器失败, 可以终止编译", e);
            return;
        }
        File renameFile = new File("cache/compile_cache/main/resources/compile/python/xfherun_compile.dat");
        File renameFile2 = new File("cache/compile_cache/main/resources/compile/python/run.exe");
        renameFile.renameTo(renameFile2);
        renameFile.delete();
        XFLog.info("清空缓存成功");
    }

    @Override
    public void run()
    {
        XFLog.info("准备工作完毕, 等待编译器开始工作");
        CompileProgress.setProgress("完成... 等待编译器开始工作", 0);
        int num = 0;
        init();
        File exeFile = new File("cache/compile_cache/main/resources/compile/python").getAbsoluteFile();
        String fileName = "run.exe";
        Runtime runtime = Runtime.getRuntime();
        String cmdHeader = "cmd /c ";
        String cmd = "\"" + fileName + "\" \"" + (file.getAbsolutePath()) + "\" \"" + name + "\"";
        String cd = "cd /d \"\" \"" + exeFile + "\"";
        String command = cmdHeader + cd + " && " + cmd;
        XFLog.info("Windows DOS Command: " + command);
        try
        {
            runtime.exec(command);
            XFLog.info("编译器成功运行");
        }
        catch (IOException e)
        {
            XFLog.info("编译器运行失败!", e);
        }
        while (true)
        {
            if (isEnd)
            {
                isEnd = false;
                end();
                throw new RuntimeException("Normal End...");
            }
            else
            {
                File ioFile = new File("cache/compile_cache/main/resources/compile/python/io/io.txt");
                File errorFile = new File("cache/compile_cache/main/resources/compile/python/io/error.txt");
                if (ioFile.exists())
                {
                    String info = ReadTextFile.readAllToString(ioFile);
                    int num2 = split(info);
                    if (num2 != -1) num = num2;
                    CompileProgress.setProgress(info, num);
                    if (info.equals("编译完成"))
                    {
                        isEnd = false;
                        endDone();
                        throw new RuntimeException("Normal End...");
                    }
                }
                if (errorFile.exists())
                {
                    String error = ReadTextFile.readAllToLine(errorFile);
                    if (!error.equals(""))
                    {
                        XFLog.info("编译器出现异常");
                        JDialog dialog = new JDialog();
                        dialog.setTitle("Python编译器出现异常");
                        dialog.setSize(800, 480);
                        dialog.setResizable(true);
                        dialog.setLocationRelativeTo(MainWindow.getMainWindow());

                        JTextArea jTextArea = new JTextArea();
                        jTextArea.setEditable(false);
                        JScrollPane jScrollPane = new JScrollPane(jTextArea);
                        dialog.add(jScrollPane);
                        jTextArea.setText(error);
                        System.err.println(error);
                        XFLog.err(error);

                        dialog.setModal(true);
                        dialog.setVisible(true);
                        isEnd = false;
                        endDone();
                        if (errorFile.exists()) errorFile.delete();
                        file = null;
                        CompileProgress.compileProgressDialog.setVisible(false);
                        deleteFileAndDir();
                        deleteDir("cache/compile_cache");
                        CompileProgress.setProgress("开始编译, 请稍等 ...", 0);
                        XFLog.warn("编译失败");
                        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                                "编译已终止, 编译失败", "警告", 2);
                        throw new RuntimeException("Normal End...");
                    }
                }
            }
        }
    }

    private static void end()
    {
        XFLog.info("开始终止编译器进程");
        try
        {
            CompileProgress.setProgress("终止...", 0);
            Runtime.getRuntime().exec("taskkill /f /im \"run.exe\"");
            XFLog.info("终止成功");
        }
        catch (IOException e)
        {
            XFLog.info("终止失败, 尝试另一种方式终止.", e);
            try
            {
                CompileProgress.setProgress("终止...", 0);
                Runtime.getRuntime().exec("taskkill /f /im \"python.exe\"");
                XFLog.info("终止成功");
            }
            catch (IOException ex)
            {
                XFLog.info("终止失败" + ex);
            }
        }
        CompileProgress.compileProgressDialog.setVisible(false);
        deleteFileAndDir();
        CompileProgress.setProgress("开始编译, 请稍等 ...", 0);
        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                "编译已终止, 编译失败", "警告", 2);
    }

    private static void deleteFileAndDir()
    {
        XFLog.info("删除目录");
        File oldFile = new File("cache/compile_cache/main/resources/compile/python/_compile");
        XFLog.info("路径: " + oldFile);
        File[] files = oldFile.listFiles();
        try
        {
            for (File file : files)
            {
                file.delete();
                XFLog.info("文件已删除: " + file);
            }
        }
        catch (Exception e)
        {
            XFLog.info("", e);
        }
        try
        {
            oldFile.delete();
            XFLog.info("文件已删除: " + oldFile);
        }
        catch (Exception e)
        {
            XFLog.info("", e);
        }
        File ioFile = null;
        try
        {
            ioFile = new File("cache/compile_cache/main/resources/compile/python/io/io.txt");
            XFLog.info("文件已删除: " + ioFile);
        }
        catch (Exception e)
        {
            XFLog.info("", e);
        }
        try
        {
            ioFile.delete();
            XFLog.info("文件已删除: " + ioFile);
        }
        catch (Exception e)
        {
            XFLog.info("", e);
        }
        File renameFile2 = null;
        try
        {
            renameFile2 = new File("cache/compile_cache/main/resources/compile/python/run.exe");
            XFLog.info("文件: " + renameFile2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            renameFile2.delete();
            XFLog.info("文件已删除: " + renameFile2);
        }
        catch (Exception e)
        {
            XFLog.info("", e);
        }
    }

    private static void endDone()
    {
        XFLog.info("编译结束");
        CompileProgress.compileProgressDialog.setVisible(false);
        File oldFile = new File("cache/compile_cache/main/resources/compile/python/_compile");
        File[] files = oldFile.listFiles();
        for (File file : files)
        {
            File newFile = new File("cache/jmci/" + file.getName());
            int i = 1;
            while (true)
            {
                if (newFile.exists())
                {
                    newFile = new File("cache/jmci/" + get_(i) + file.getName());
                    i++;
                }
                else break;
            }
            XFLog.info("文件列表: " + newFile);


            try
            {
                Files.copy(Path.of(file.toString()), Path.of(newFile.toString()));
                XFLog.info("将编译后的文件放入本地缓存: " + file + " :: " + newFile);
            }
            catch (IOException e)
            {
                XFLog.info("", e);
            }
        }
        deleteFileAndDir();
        deleteDir("cache/compile_cache");
        XFLog.info("清空缓存");
        CompileProgress.setProgress("开始编译, 请稍等 ...", 0);
        XFLog.info("编译完成");
        JOptionPane.showMessageDialog(MainWindow.getMainWindow(),
                "编译完成", "提示", 1);
    }

    private static String get_(int num)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num; i++) stringBuilder.append("_");
        return stringBuilder.toString();
    }

    private static int split(String str)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9')
            {
                stringBuilder.append(c);
            }
        }
        try
        {
            return Integer.parseInt(stringBuilder.toString());
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
}

class UpdateCompileProgress extends Thread
{
    @Override
    public void run()
    {
        while (CompileProgress.compileProgressDialog != null && CompileProgress.compileProgressDialog.isVisible())
            CompileProgress.compileProgressDialog.repaint();
    }
}

/*class CompileProgress extends Thread
{
    public static JDialog compileProgressDialog;
    public static JProgressBar progressBar;
    public static JLabel progressBarTitle;
    public static String information = "开始编译, 请稍等 ...";
    private static XFButton cancel;

    @Override
    public void run()
    {
        compileProgressDialog = new JDialog();
        compileProgressDialog.setTitle(information);
        compileProgressDialog.setSize(400, 200);
        compileProgressDialog.setLocationRelativeTo(MainWindow.getMainWindow());
        compileProgressDialog.setResizable(false);
        compileProgressDialog.setLayout(null);
        addItems();
        compileProgressDialog.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                StartCompileMidiFile.isEnd = true;
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
        compileProgressDialog.setModal(true);
        compileProgressDialog.setVisible(true);
    }

    private static void addItems()
    {
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(10, 10, (compileProgressDialog.getWidth() - 16) - (10 * 2), 35);
        compileProgressDialog.getContentPane().add(progressBar);

        progressBarTitle = new JLabel(information);
        progressBarTitle.setBounds(10, 50, (compileProgressDialog.getWidth() - 16) - (10 * 2), 35);
        progressBarTitle.setHorizontalAlignment(SwingConstants.CENTER);
        compileProgressDialog.getContentPane().add(progressBarTitle);

        cancel = new XFButton("终止编译");
        cancel.setBounds(((compileProgressDialog.getWidth() - 16) - 119) / 2, 10 + 90, 119, 35);
        cancel.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StartCompileMidiFile.isEnd = true;
            }
        });
        cancel.addWindow(compileProgressDialog);
    }

    public static void setProgress(String text, int value)
    {
        information = text;
        progressBarTitle.setText(information);
        compileProgressDialog.setTitle(information);
        progressBar.setValue(value);
    }
}*/

class CompileProgress
{
    public static JDialog compileProgressDialog;
    public static JProgressBar progressBar;
    public static JLabel progressBarTitle;
    public static String information = "开始编译, 请稍等 ...";
    private static String stringsList = "";
    private static XFButton cancel;

    private CompileProgress()
    {
    }

    public static void run()
    {
        stringsList = "";
        compileProgressDialog = new JDialog();
        compileProgressDialog.setTitle(information);
        compileProgressDialog.setSize(400, 200);
        compileProgressDialog.setLocationRelativeTo(MainWindow.getMainWindow());
        compileProgressDialog.setResizable(false);
        URL imageUrl = Resources.getResources(ExceptionLeftBottomWindow.class, "" +
                "main/resources/images/window/logo/logo.png");
        Image image = new ImageIcon(imageUrl).getImage();
        compileProgressDialog.setIconImage(image);
        compileProgressDialog.setLayout(null);
        addItems();
        compileProgressDialog.addWindowListener(new WindowListener()
        {
            @Override
            public void windowOpened(WindowEvent e)
            {

            }

            @Override
            public void windowClosing(WindowEvent e)
            {
                StartCompileMidiFile.isEnd = true;
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
        compileProgressDialog.setModal(true);
        compileProgressDialog.setVisible(true);
    }

    private static void addItems()
    {
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(10, 10, (compileProgressDialog.getWidth() - 16) - (10 * 2), 35);
        compileProgressDialog.getContentPane().add(progressBar);

        progressBarTitle = new JLabel(information);
        progressBarTitle.setBounds(10, 50, (compileProgressDialog.getWidth() - 16) - (10 * 2), 35);
        progressBarTitle.setHorizontalAlignment(SwingConstants.CENTER);
        compileProgressDialog.getContentPane().add(progressBarTitle);

        cancel = new XFButton("终止编译");
        cancel.setBounds(((compileProgressDialog.getWidth() - 16) - 119) / 2, 10 + 90, 119, 35);
        cancel.addMouseClicked(new ButtonClick()
        {
            @Override
            public void clicked(MouseEvent event)
            {
                StartCompileMidiFile.isEnd = true;
            }
        });
        cancel.addWindow(compileProgressDialog);
    }

    public static void setProgress(String text, int value)
    {
        if (!text.equals(""))
        {
            information = text;
            if (!information.equals(stringsList))
            {
                if (progressBarTitle != null) progressBarTitle.setText(information);
                if (compileProgressDialog != null) compileProgressDialog.setTitle(information);
                if (progressBar != null) progressBar.setValue(value);
                XFLog.info(information);
            }
            stringsList = information;
        }
    }
}
